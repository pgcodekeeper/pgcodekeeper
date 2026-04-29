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
package ru.taximaxim.codekeeper.ui.settings;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Control;

import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

public interface ICustomFieldEditor<T> {

    default void setToolTipText(String toolTip) {
        getControl().setToolTipText(toolTip);
    }

    default void setEnabled(boolean enabled) {
        getControl().setEnabled(enabled);
    }

    default void setVisible(boolean visible) {
        getControl().setVisible(visible);
    }

    void setValue(T value);
    void setValue(OverridablePrefs prefs);
    void setValue(IEclipsePreferences prefs);
    void setValue(IPreferenceStore mainPrefs);
    void setDefaultValue(T value);

    void fillValue(IEclipsePreferences prefs);

    String getPreferenceName();
    Control getControl();
    T getValue();
}
