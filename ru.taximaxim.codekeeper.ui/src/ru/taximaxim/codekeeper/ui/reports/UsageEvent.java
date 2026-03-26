/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 *  Represents a data which will be send to Google Analytics to track the user's event
 */
public class UsageEvent {

    private final UsageEventType type;
    private String label;
    private Integer value;

    public UsageEvent(UsageEventType type, String label, Integer value) {
        if (type == null) {
            throw new IllegalArgumentException(Messages.UsageEvent_type_error);
        }
        this.type = type;
        if (type.getValueDescription() == null && value != null) {
            throw new IllegalArgumentException(Messages.UsageEvent_value_error);
        }
        this.label = label;
        this.value = value;
    }

    /**
     * @return the event type
     */
    public UsageEventType getType() {
        return type;
    }

    /**
     * @return the event label name. May be null.
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the event value. May be null.
     */
    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Type=").append(type); //$NON-NLS-1$
        if (label != null) {
            sb.append("; Label=\"").append(label).append('"'); //$NON-NLS-1$
        }
        if (value != null) {
            sb.append("; Value=\"").append(value).append('"'); //$NON-NLS-1$
        }
        sb.append('}');
        return sb.toString();
    }

    public UsageEvent copy() {
        return new UsageEvent(this.type, this.label, this.value);
    }
}