/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.event;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.eclipse.core.runtime.IPath;
import org.jboss.tools.usage.event.UsageEvent;
import org.jboss.tools.usage.event.UsageEventType;
import org.jboss.tools.usage.event.UsageReporter;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.preferences.GlobalUsageSettings;

/**
 * Represents a register of tracking event types.
 * Each event type must be registered via this register before the corresponding event can be sent.
 *  
 * @author Alexey Kazakov
 */
public class EventRegister {

	// Event type component name
	private static final String EVENT_TYPE_COMPONENT_NAME = "cmp";
	// Event type component version
	private static final String EVENT_TYPE_VERSION = "v";
	// Event type category name
	private static final String EVENT_TYPE_CATEGORY_NAME = "ct";
	// Event type action name
	private static final String EVENT_TYPE_ACTION_NAME = "a";
	// Event type label description
	private static final String EVENT_TYPE_LABEL_DESCRIPTION = "l";
	// Event type value description
	private static final String EVENT_TYPE_VALUE_DESCRIPTION = "vl";
	// Event type date when last time sent
	private static final String EVENT_TYPE_DATE = "d";
	// How many times sent during the day
	private static final String EVENT_TYPE_COUNT = "c";
	// The sum of all values collected during the day
	private static final String EVENT_TYPE_VALUE_SUM = "s";
	// Label value used by countEvent()
	private static final String EVENT_TYPE_COUNT_EVENT_LABEL = "cl";

	private static EventRegister INSTANCE = new EventRegister();
	protected Map<EventTypeKey, UsageEventProperties> eventPropertyStorage;
	protected Map<UsageEventType, Set<UsageEventProperties>> eventPropertyStorageByType;
	protected Set<UsageEventType> eventTypes;

	protected EventRegister() {
	}

	public static EventRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * Registers the event type
	 * 
	 * @param type
	 */
	public synchronized void registerEvent(UsageEventType type) {
		if(eventTypes==null) {
			eventTypes = new HashSet<UsageEventType>();
		}
		eventTypes.add(type);
	}

	/**
	 * Returns Result.okToSend == true if the event can be sent
	 * 
	 * @param event
	 * @param settings
	 * @param countEvent
	 * @return
	 */
	public synchronized Result checkTrackData(UsageEvent event, GlobalUsageSettings settings, boolean countEvent) {
		Result result = new Result();
		if(settings.isReportingEnabled()) {
			init();
			// Check if the event type has been registered
			if(eventTypes!=null && eventTypes.contains(event.getType())) {
				long today = getCurrentTime();
				EventTypeKey eventTypeKey = new EventTypeKey(event.getType(), event.getLabel());
				UsageEventProperties preferenceProperties = eventPropertyStorage.get(eventTypeKey);
				if(preferenceProperties==null) {
					// First time use of the event
					preferenceProperties = new UsageEventProperties();
					preferenceProperties.type = event.getType();
					preferenceProperties.date = today;
					if(countEvent) {
						preferenceProperties.value = getValue(event);
					} else {
						preferenceProperties.count = 1;
					}
					String label = event.getLabel();
					if(label == null) {
						label = eventTypeKey.label;
					}
					preferenceProperties.countEventLabel = label;
					eventPropertyStorage.put(eventTypeKey, preferenceProperties);
					addTypePropetiesToStorage(preferenceProperties, event.getType());
				} else {
					if(!isSameDay(today, preferenceProperties.date)) {
						if(countEvent) {
							result.previousSumOfValues = preferenceProperties.value;
							preferenceProperties.value = getValue(event);
						} else {
							preferenceProperties.count = 1;
						}
					} else {
						if(countEvent) {
							preferenceProperties.value = preferenceProperties.value + getValue(event);
						} else {
							preferenceProperties.count++;
						}
					}
					preferenceProperties.date = today;
				}
				// Update preferenceProperties in workspace
				saveProperties(preferenceProperties);
				// Check remote usage.properties
				result.countEventLabel = preferenceProperties.countEventLabel;
				result.okToSend = checkRemoteSettings(settings, event.getType(), event.getLabel(), preferenceProperties.count) && (!countEvent || result.previousSumOfValues>0);
			} else {
				JBossToolsUsageActivator.getDefault().getLogger().error("Event type [" + event.toString() + "] is not registered and will be ignored.", false);
			}
		}
		return result;
	}

	public synchronized UsageEventType[] getRegisteredEventTypes() {
		if(eventTypes==null) {
			return new UsageEventType[0];
		}
		return eventTypes.toArray(new UsageEventType[eventTypes.size()]);
	}

	public synchronized Set<Result> checkCountEvent(UsageEventType type, GlobalUsageSettings settings) {
		Set<Result> results = new HashSet<Result>();
		if(settings.isReportingEnabled()) {
			init();
			if(eventTypes!=null && eventTypes.contains(type)) {
				long today = getCurrentTime();
				Set<UsageEventProperties> preferencePropertiesSet = eventPropertyStorageByType.get(type);
				if(preferencePropertiesSet!=null) {
					for (UsageEventProperties preferenceProperties : preferencePropertiesSet) {
						if(!isSameDay(today, preferenceProperties.date)) {
							Result result = new Result();
							result.previousSumOfValues = preferenceProperties.value;
							result.countEventLabel = preferenceProperties.countEventLabel;
							result.okToSend = result.previousSumOfValues>0 && checkRemoteSettings(settings, type, preferenceProperties.countEventLabel, preferenceProperties.count);
							preferenceProperties.count = 0;
							preferenceProperties.value = 0;
							preferenceProperties.date = today;
							results.add(result);
							saveProperties(preferenceProperties);
						}
					}
				}
			}
		}
		return results;
	}

	private int getValue(UsageEvent event) {
		return event.getValue()!=null?event.getValue():1;
	}

	/**
	 * Check remote settings.
	 * 
	 * Format of the settings:
	 * 
	 * For category (required) + action (optional):
	 * <category>[.<action>]=-n/0/+n
	 *                       -n = no limit (used by default)
	 *                        0 = never send
	 *                       +n = maximum a day
	 *                              
	 * Additionally, an optional label can be used as an extra parameter to enable or disable some particular labels 
	 * <category>.<action>[.<label>]=-n/0
	 *                               -n = no limit (used by default)
	 *                                0 = never send
	 * 
	 * '.' can be used in category/label/action names.
	 * But all whitespace characters should be replaced by '-' in the usage.properties file though users still can send names with whitespace.
	 * So property "server.new.AS-7.1" is equals to Event with Category: "server", Action: "new", Label: "AS 7.1" 
	 * 
	 * 
	 * Example:
	 *   server=0
	 *   server.new=3
	 *   server.new.AS7-1=-1
	 *   sever.run=5
	 * It means:
	 *   jst.palette      - enabled, no limit (there is no property "jst" or "jst.palette" so the default value "no limit" is used)
	 *   server.new.AS7-1 - enabled, no limit ("server.new.AS7-1=-1" is used) 
	 *   server.new.AS6-2 - no more than 3 times a day (there is no "server.new.AS6-2" property so the existing "server.new=3" is used) 
	 *   server.run.AS-1  - no more than 5 times a day (there is no "server.run.AS-1" property so the existing "sever.run=5" is used)
	 *   server.remove    - disabled (there is no "server.remove" property so the existing "server=0" is used)
	 * 
	 *
	 * @param settings
	 * @param type
	 * @param label
	 * @param count
	 * @return
	 */
	private boolean checkRemoteSettings(GlobalUsageSettings settings, UsageEventType type, String label, int count) {
		try {
			Map<Object, Object> map = settings.getRemoteSettings();
			String actionKey = type.getCategoryName() + "." + type.getActionName();
			String value = null;
			if(label!=null) {
				String labelKey = actionKey + "." + label;
				value = (String)map.get(labelKey);
			}
			if(value==null) {
				value = (String)map.get(actionKey);
				if(value==null) {
					value = (String)map.get(type.getCategoryName());
				}
			}
			if(value!=null && !value.isEmpty()) {
				try {
					int v = Integer.valueOf(value);
					return v<0 || count<=v;
				} catch (NumberFormatException e) {
					JBossToolsUsageActivator.getDefault().getLogger().error(e);
				}
			}
			return true;
		} catch (IOException e) {
			JBossToolsUsageActivator.getDefault().getLogger().error(e, true);
		}
		return false;
	}

	protected long getCurrentTime() {
		return System.currentTimeMillis();
	}

	private boolean isSameDay(long date1, long date2) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTimeInMillis(date1);
		calendar2.setTimeInMillis(date2);
		return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR);
	}

	protected File getStorageDirectory() {
		JBossToolsUsageActivator plugin = JBossToolsUsageActivator.getDefault();
		if(plugin != null) {
			//The plug-in instance can be null at shutdown, when the plug-in is stopped. 
			IPath path = plugin.getStateLocation();
			File file = new File(path.toFile(), "events"); //$NON-NLS-1$
			if(!file.exists()) {
				file.mkdirs();
			}
			return file;
		} else {
			return null;
		}
	}

	private File getStorageFile(UsageEventProperties properties) {
		File directory = getStorageDirectory();
		if(directory!=null) {
			String name = properties.type.getCategoryName() + "-" + properties.type.getActionName() + "-" + properties.countEventLabel;
			try {
				name = URLEncoder.encode(name, "UTF-8");
				if(name.length()>40) {
					name = (UUID.nameUUIDFromBytes(name.getBytes())).toString();	
				}
				return new File(directory, name);
			} catch (UnsupportedEncodingException e) {
				JBossToolsUsageActivator.getDefault().getLogger().error(e);
			}
		}
		return null;
	}

	private boolean saveProperties(UsageEventProperties properties) {
		File file = getStorageFile(properties);
		if(file!=null) {
			if(file.isFile()) {
				file.delete();
			}
			FileWriter writer = null;
			try {
				UsageEventType type = properties.type;
				writer = new FileWriter(file);
				Properties pr = new Properties();
				pr.put(EVENT_TYPE_COMPONENT_NAME, type.getComponentName());
				pr.put(EVENT_TYPE_VERSION, type.getComponentVersion());
				pr.put(EVENT_TYPE_CATEGORY_NAME, type.getCategoryName());
				pr.put(EVENT_TYPE_ACTION_NAME, type.getActionName());
				if(type.getLabelDescription()!=null) {
					pr.put(EVENT_TYPE_LABEL_DESCRIPTION, type.getLabelDescription());
					if(type.getValueDescription()!=null) {
						pr.put(EVENT_TYPE_VALUE_DESCRIPTION, type.getValueDescription());
					}
				}
				pr.put(EVENT_TYPE_DATE, "" + properties.date);
				pr.put(EVENT_TYPE_COUNT, "" + properties.count);
				pr.put(EVENT_TYPE_VALUE_SUM, "" + properties.value);
				pr.put(EVENT_TYPE_COUNT_EVENT_LABEL, properties.countEventLabel);
				pr.store(writer, null);
				return true;
			} catch (IOException e) {
				JBossToolsUsageActivator.getDefault().getLogger().error(e);
			} finally {
				if(writer!=null) {
					try {
						writer.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return false;
	}

	protected void init() {
		if(eventPropertyStorage==null) {
			eventPropertyStorage = new HashMap<EventTypeKey, UsageEventProperties>();
			eventPropertyStorageByType = new HashMap<UsageEventType, Set<UsageEventProperties>>();
			File directory = getStorageDirectory();
			if(directory!=null) {
				File[] files = directory.listFiles();
				long sixMonthsAgo = System.currentTimeMillis() - 1000L*60*60*24*132;
				for (File file : files) {
					if(file.isFile()) {
						FileReader reader = null;
						try {
							reader = new FileReader(file);
							Properties pr = new Properties();
							pr.load(reader);
							long date = Long.parseLong(pr.getProperty(EVENT_TYPE_DATE, "0"));
							if(date<sixMonthsAgo) {
								file.delete(); // This event type has not been used at least for the last six months, so let's remove it.
							} else {
								String component = pr.getProperty(EVENT_TYPE_COMPONENT_NAME);
								String version = pr.getProperty(EVENT_TYPE_VERSION);
								String category = pr.getProperty(EVENT_TYPE_CATEGORY_NAME);
								String action = pr.getProperty(EVENT_TYPE_ACTION_NAME);
								String label = pr.getProperty(EVENT_TYPE_LABEL_DESCRIPTION);
								String value = pr.getProperty(EVENT_TYPE_VALUE_DESCRIPTION);
								int count = Integer.parseInt(pr.getProperty(EVENT_TYPE_COUNT, "0"));
								int valueSum = Integer.parseInt(pr.getProperty(EVENT_TYPE_VALUE_SUM, "0"));
								String countLabel = pr.getProperty(EVENT_TYPE_COUNT_EVENT_LABEL);
								if(component!=null && version!=null && category!=null && action!=null && countLabel!=null) {
									UsageEventType type = new UsageEventType(component, version, category, action, label, value);
									UsageEventProperties properties = new UsageEventProperties();
									properties.type = type;
									properties.date = date;
									properties.count = count;
									properties.value = valueSum;
									properties.countEventLabel = countLabel;
									eventPropertyStorage.put(new EventTypeKey(type, countLabel), properties);
									addTypePropetiesToStorage(properties, type);
								}
							}
						} catch (IOException e) {
							JBossToolsUsageActivator.getDefault().getLogger().error(e);
						} finally {
							if(reader!=null) {
								try {
									reader.close();
								} catch (IOException e) {
								}
							}
						}
					}
				}
			}
		}
	}

	private void addTypePropetiesToStorage(UsageEventProperties properties, UsageEventType type) {
		Set<UsageEventProperties> typeProperties = eventPropertyStorageByType.get(type);
		if(typeProperties==null) {
			typeProperties = new HashSet<UsageEventProperties>();
		}
		typeProperties.add(properties);
		eventPropertyStorageByType.put(type, typeProperties);
	}

	private static class EventTypeKey {
		UsageEventType type;
		String label;

		/**
		 * Label may be null
		 * @param type
		 * @param label
		 */
		EventTypeKey(UsageEventType type, String label) {
			this.type = type;
			if(label==null) {
				label = UsageReporter.NOT_APPLICABLE_LABEL;
			}
			this.label = label;
		}

		@Override
		public int hashCode() {
			return (type.getComponentName() + type.getCategoryName() + type.getActionName() + label).hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj instanceof EventTypeKey) {
				EventTypeKey key = (EventTypeKey)obj;
				return type.equals(key.type) && label.equals(key.label);
			}
			return false;
		}

		@Override
		public String toString() {
			return "Type: " + type.toString() + "; Label: " + label;
		}
	}

	public static class Result {
		private boolean okToSend;
		private int previousSumOfValues;
		private String countEventLabel;

		/**
		 * Returns true if this event can be sent
		 *  
		 * @return
		 */
		public boolean isOkToSend() {
			return okToSend;
		}

		/**
		 * Returns the sum of all values of this event collected during the day when this event was send last time.
		 * It's used for daily event tracking. The daily event should be sent if the returned number is bigger than 0.
		 * Category, action names and labels are taken into account when values are being counted. If the label is null then "N/A" is used.  
		 * @return
		 */
		public int getPreviousSumOfValues() {
			return previousSumOfValues;
		}

		public String getCountEventLabel() {
			return countEventLabel;
		}
	}

	private static class UsageEventProperties {
		UsageEventType type;
		long date; // The date when the event with this type was sent last time 
		int count; // How many times events with this type and even label were sent on the day of the last use
		int value; // The sum of all values collected during the day
		String countEventLabel;
	}
}