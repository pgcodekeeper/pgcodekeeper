package ru.taximaxim.codekeeper.ui.reports;

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

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

/**
 * Represents a register of tracking event types.
 * Each event type must be registered via this register before the corresponding event can be sent.
 */
public class EventRegister {

    // Event type component name
    private static final String EVENT_TYPE_COMPONENT_NAME = "cmp";
    // Event type component version
    private static final String EVENT_TYPE_VERSION = "v";
    // Event type action name
    private static final String EVENT_TYPE_ACTION_NAME = "a";
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

    private static final EventRegister INSTANCE = new EventRegister();
    private Map<EventTypeKey, UsageEventProperties> eventPropertyStorage;
    private Map<UsageEventType, Set<UsageEventProperties>> eventPropertyStorageByType;
    private Set<UsageEventType> eventTypes;

    private EventRegister() {
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
        if (eventTypes == null) {
            eventTypes = new HashSet<>();
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
    public synchronized Result checkTrackData(UsageEvent event, boolean countEvent) {
        Result result = new Result();
        init();
        // Check if the event type has been registered
        if (eventTypes != null && eventTypes.contains(event.getType())) {
            long today = System.currentTimeMillis();
            EventTypeKey eventTypeKey = new EventTypeKey(event.getType(), event.getLabel());
            UsageEventProperties preferenceProperties = eventPropertyStorage.get(eventTypeKey);
            if (preferenceProperties == null) {
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
                if (!isSameDay(today, preferenceProperties.date)) {
                    if (countEvent) {
                        result.previousSumOfValues = preferenceProperties.value;
                        preferenceProperties.value = getValue(event);
                    } else {
                        preferenceProperties.count = 1;
                    }
                } else {
                    if (countEvent) {
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
            result.okToSend = !countEvent || result.previousSumOfValues>0;
        } else {
            Log.log(Log.LOG_ERROR, "Event type [" + event.toString() + "] is not registered and will be ignored.");
        }
        return result;
    }

    public synchronized UsageEventType[] getRegisteredEventTypes() {
        if (eventTypes == null) {
            return new UsageEventType[0];
        }
        return eventTypes.toArray(new UsageEventType[eventTypes.size()]);
    }

    public synchronized Set<Result> checkCountEvent(UsageEventType type) {
        Set<Result> results = new HashSet<>();
        init();
        if (eventTypes != null && eventTypes.contains(type)) {
            long today = System.currentTimeMillis();
            Set<UsageEventProperties> preferencePropertiesSet = eventPropertyStorageByType.get(type);
            if (preferencePropertiesSet != null) {
                for (UsageEventProperties preferenceProperties : preferencePropertiesSet) {
                    if (!isSameDay(today, preferenceProperties.date)) {
                        Result result = new Result();
                        result.previousSumOfValues = preferenceProperties.value;
                        result.countEventLabel = preferenceProperties.countEventLabel;
                        result.okToSend = result.previousSumOfValues>0;
                        preferenceProperties.count = 0;
                        preferenceProperties.value = 0;
                        preferenceProperties.date = today;
                        results.add(result);
                        saveProperties(preferenceProperties);
                    }
                }
            }
        }
        return results;
    }

    private int getValue(UsageEvent event) {
        return event.getValue() != null ? event.getValue() : 1;
    }

    private boolean isSameDay(long date1, long date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTimeInMillis(date1);
        calendar2.setTimeInMillis(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR);
    }

    private File getStorageDirectory() {
        Activator plugin = Activator.getDefault();
        if (plugin != null) {
            //The plug-in instance can be null at shutdown, when the plug-in is stopped.
            IPath path = plugin.getStateLocation();
            File file = new File(path.toFile(), "events"); //$NON-NLS-1$
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } else {
            return null;
        }
    }

    private File getStorageFile(UsageEventProperties properties) {
        File directory = getStorageDirectory();
        if (directory != null) {
            String name = properties.type.getActionName() + "-" + properties.countEventLabel;
            try {
                name = URLEncoder.encode(name, "UTF-8");
                if (name.length() > 40) {
                    name = (UUID.nameUUIDFromBytes(name.getBytes())).toString();
                }
                return new File(directory, name);
            } catch (UnsupportedEncodingException e) {
                Log.log(Log.LOG_ERROR, e.getMessage());
            }
        }
        return null;
    }

    private boolean saveProperties(UsageEventProperties properties) {
        File file = getStorageFile(properties);
        if (file != null) {
            if (file.isFile()) {
                file.delete();
            }
            try (FileWriter writer  = new FileWriter(file)) {
                UsageEventType type = properties.type;
                Properties pr = new Properties();
                pr.put(EVENT_TYPE_COMPONENT_NAME, type.getComponentName());
                pr.put(EVENT_TYPE_VERSION, type.getComponentVersion());
                pr.put(EVENT_TYPE_ACTION_NAME, type.getActionName());
                if (type.getValueDescription() != null) {
                    pr.put(EVENT_TYPE_VALUE_DESCRIPTION, type.getValueDescription());
                }
                pr.put(EVENT_TYPE_DATE, Long.toString(properties.date));
                pr.put(EVENT_TYPE_COUNT, Long.toString(properties.count));
                pr.put(EVENT_TYPE_VALUE_SUM, Long.toString(properties.value));
                pr.put(EVENT_TYPE_COUNT_EVENT_LABEL, properties.countEventLabel);
                pr.store(writer, null);
                return true;
            } catch (IOException e) {
                Log.log(Log.LOG_ERROR, e.getMessage());
            }
        }
        return false;
    }

    private void init() {
        if (eventPropertyStorage == null) {
            eventPropertyStorage = new HashMap<>();
            eventPropertyStorageByType = new HashMap<>();
            File directory = getStorageDirectory();
            if (directory != null) {
                File[] files = directory.listFiles();
                long sixMonthsAgo = System.currentTimeMillis() - 1000L*60*60*24*132;
                for (File file : files) {
                    if (file.isFile()) {
                        try (FileReader reader = new FileReader(file)) {
                            Properties pr = new Properties();
                            pr.load(reader);
                            long date = Long.parseLong(pr.getProperty(EVENT_TYPE_DATE, "0"));
                            if (date > sixMonthsAgo) {
                                String component = pr.getProperty(EVENT_TYPE_COMPONENT_NAME);
                                String version = pr.getProperty(EVENT_TYPE_VERSION);
                                String action = pr.getProperty(EVENT_TYPE_ACTION_NAME);
                                String value = pr.getProperty(EVENT_TYPE_VALUE_DESCRIPTION);
                                int count = Integer.parseInt(pr.getProperty(EVENT_TYPE_COUNT, "0"));
                                int valueSum = Integer.parseInt(pr.getProperty(EVENT_TYPE_VALUE_SUM, "0"));
                                String countLabel = pr.getProperty(EVENT_TYPE_COUNT_EVENT_LABEL);
                                if (component != null && version != null && action != null && countLabel != null) {
                                    UsageEventType type = new UsageEventType(component, version, action, value);
                                    UsageEventProperties properties = new UsageEventProperties();
                                    properties.type = type;
                                    properties.date = date;
                                    properties.count = count;
                                    properties.value = valueSum;
                                    properties.countEventLabel = countLabel;
                                    eventPropertyStorage.put(new EventTypeKey(type, countLabel), properties);
                                    addTypePropetiesToStorage(properties, type);
                                }
                            } else {
                                file.delete(); // This event type has not been used at least for the last six months, so let's remove it.
                            }
                        } catch (IOException e) {
                            Log.log(Log.LOG_ERROR, e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private void addTypePropetiesToStorage(UsageEventProperties properties, UsageEventType type) {
        Set<UsageEventProperties> typeProperties = eventPropertyStorageByType.get(type);
        if(typeProperties==null) {
            typeProperties = new HashSet<>();
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
            this.label = (label == null) ? UsageReporter.NOT_APPLICABLE_LABEL : label;
        }

        @Override
        public int hashCode() {
            return (type.getComponentName() + type.getActionName() + label).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EventTypeKey) {
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