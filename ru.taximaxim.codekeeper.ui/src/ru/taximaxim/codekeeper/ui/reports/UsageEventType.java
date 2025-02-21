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

import org.eclipse.core.runtime.Assert;

/**
 * Represents an event type
 */
public class UsageEventType {

    private final String componentName;
    private final String componentVersion;
    private final String actionName;
    private final String valueDescription;

    /**
     * @param componentName May not be null. All whitespaces will be replaced by "-".
     * @param componentVersion May not be null
     * @param categoryName If null, the component name is used as category name. All whitespaces will be replaced by "-".
     * @param actionName May not be null. All whitespaces will be replaced by "-".
     * @param valueDescription Optinal. May be null.
     */
    public UsageEventType(String componentName, String componentVersion,
            String actionName, String valueDescription) {
        Assert.isLegal(componentName!=null, "Component name may not be null"); //$NON-NLS-1$
        Assert.isLegal(componentVersion!=null, "Component version may not be null"); //$NON-NLS-1$
        Assert.isLegal(actionName != null, "Action name may not be null"); //$NON-NLS-1$
        this.componentName = componentName.replaceAll("\\s", "-"); //$NON-NLS-1$ //$NON-NLS-2$
        this.componentVersion = componentVersion;
        this.actionName = actionName.replaceAll("\\s", "-"); //$NON-NLS-1$ //$NON-NLS-2$
        this.valueDescription = valueDescription;
    }

    /**
     * Creates a new event with this event type
     * @param label
     * @param value
     * @return
     */
    public UsageEvent event(String label, int value) {
        return new UsageEvent(this, label, value);
    }

    /**
     * Creates a new event with this event type
     * @param label
     * @return
     */
    public UsageEvent event(String label) {
        return new UsageEvent(this, label, null);
    }

    public String getComponentName() {
        return componentName;
    }

    public String getComponentVersion() {
        return componentVersion;
    }

    public String getActionName() {
        return actionName;
    }


    public String getValueDescription() {
        return valueDescription;
    }

    @Override
    public int hashCode() {
        return (componentName + actionName).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UsageEventType type) {
            return getComponentName().equals(type.getComponentName()) && getActionName().equals(type.getActionName());
        }
        return false;
    }

    @Override
    public String toString() {
        return "{Component=\"" + componentName + "\"; Category=\"" + "\"; Action=\"" + actionName + "\"}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }
}