/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.reports;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

/**
 * Represents a register of tracking event types.
 * Each event type must be registered via this register before the corresponding event can be sent.
 */
public class EventRegister {

    // Remove unused events after this period (6 month)
    private static final long PERIOD = 1000L*60*60*24*132;

    // Event type component name
    private static final String EVENT_TYPE_COMPONENT_NAME = "cmp"; //$NON-NLS-1$
    // Event type component version
    private static final String EVENT_TYPE_VERSION = "v"; //$NON-NLS-1$
    // Event type action name
    private static final String EVENT_TYPE_ACTION_NAME = "a"; //$NON-NLS-1$
    // Event type value description
    private static final String EVENT_TYPE_VALUE_DESCRIPTION = "vl"; //$NON-NLS-1$
    // Event type date when last time sent
    private static final String EVENT_TYPE_DATE = "d"; //$NON-NLS-1$
    // How many times sent during the day
    private static final String EVENT_TYPE_COUNT = "c"; //$NON-NLS-1$
    // The sum of all values collected during the day
    private static final String EVENT_TYPE_VALUE_SUM = "s"; //$NON-NLS-1$
    // Label value used by countEvent()
    private static final String EVENT_TYPE_COUNT_EVENT_LABEL = "cl"; //$NON-NLS-1$

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
    public synchronized Result checkTrackData(UsageEvent event) {
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
                preferenceProperties.count = 1;
                String label = event.getLabel();
                if(label == null) {
                    label = eventTypeKey.label;
                }
                preferenceProperties.countEventLabel = label;
                eventPropertyStorage.put(eventTypeKey, preferenceProperties);
                addTypePropetiesToStorage(preferenceProperties, event.getType());
            } else {
                if (!isSameDay(today, preferenceProperties.date)) {
                    preferenceProperties.count = 1;
                } else {
                    preferenceProperties.count++;
                }
                preferenceProperties.date = today;
            }
            // Update preferenceProperties in workspace
            saveProperties(preferenceProperties);
            // Check remote usage.properties
            result.countEventLabel = preferenceProperties.countEventLabel;
            result.okToSend = true;
        } else {
            Log.log(Log.LOG_ERROR, "Event type [" + event.toString() + "] is not registered and will be ignored."); //$NON-NLS-1$ //$NON-NLS-2$
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

    private boolean isSameDay(long date1, long date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTimeInMillis(date1);
        calendar2.setTimeInMillis(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR);
    }

    private Path getStorageDirectory() {
        Activator plugin = Activator.getDefault();
        //The plug-in instance can be null at shutdown, when the plug-in is stopped.
        if (plugin != null) {
            Path dir = Paths.get(plugin.getStateLocation().toOSString(), "events"); //$NON-NLS-1$
            try {
                return Files.createDirectories(dir);
            } catch (IOException e) {
                Log.log(Log.LOG_ERROR, e.getMessage());
            }
        }
        return null;
    }

    private Path getStorageFile(UsageEventProperties properties) {
        Path directory = getStorageDirectory();
        if (directory != null) {
            String name = properties.type.getActionName() + '-' + properties.countEventLabel;
            try {
                name = URLEncoder.encode(name, "UTF-8"); //$NON-NLS-1$
                if (name.length() > 40) {
                    name = (UUID.nameUUIDFromBytes(name.getBytes())).toString();
                }
                return directory.resolve(name);
            } catch (UnsupportedEncodingException e) {
                Log.log(Log.LOG_ERROR, e.getMessage());
            }
        }
        return null;
    }

    private void saveProperties(UsageEventProperties properties) {
        Path file = getStorageFile(properties);
        if (file == null) {
            return;
        }

        try (Writer writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
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
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, e.getMessage());
        }
    }

    private void init() {
        if (eventPropertyStorage != null) {
            return;
        }

        eventPropertyStorage = new HashMap<>();
        eventPropertyStorageByType = new HashMap<>();
        Path directory = getStorageDirectory();
        if (directory == null) {
            return;
        }

        long removeTime = System.currentTimeMillis() - PERIOD;

        try (Stream<Path> stream = Files.list(directory)) {
            stream.filter(Files::isRegularFile).forEach(p -> read(p, removeTime));
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, e.getMessage());
        }
    }

    private void read(Path path, long removeTime) {
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            Properties pr = new Properties();
            pr.load(reader);
            long date = Long.parseLong(pr.getProperty(EVENT_TYPE_DATE, "0")); //$NON-NLS-1$

            if (date < removeTime) {
                // This event type has not been used at least for the PERIOD constant, so let's remove it.
                Files.delete(path);
                return;
            }

            String component = pr.getProperty(EVENT_TYPE_COMPONENT_NAME);
            String version = pr.getProperty(EVENT_TYPE_VERSION);
            String action = pr.getProperty(EVENT_TYPE_ACTION_NAME);
            String value = pr.getProperty(EVENT_TYPE_VALUE_DESCRIPTION);
            int count = Integer.parseInt(pr.getProperty(EVENT_TYPE_COUNT, "0")); //$NON-NLS-1$
            int valueSum = Integer.parseInt(pr.getProperty(EVENT_TYPE_VALUE_SUM, "0")); //$NON-NLS-1$
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
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, e.getMessage());
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
            if (obj instanceof EventTypeKey key) {
                return type.equals(key.type) && label.equals(key.label);
            }
            return false;
        }

        @Override
        public String toString() {
            return "Type: " + type.toString() + "; Label: " + label; //$NON-NLS-1$ //$NON-NLS-2$
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