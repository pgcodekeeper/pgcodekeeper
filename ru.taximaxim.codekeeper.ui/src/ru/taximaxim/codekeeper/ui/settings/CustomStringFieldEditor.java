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
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

public class CustomStringFieldEditor extends StringFieldEditor implements ICustomFieldEditor<String> {

    private final Composite parent;
    private String defaultValue;

    public CustomStringFieldEditor(String settingsName, String settingText, Composite parent) {
        super(settingsName, settingText, parent);
        this.parent = parent;
    }

    @Override
    public Text getControl() {
        return getTextControl(parent);
    }

    @Override
    public void setValue(String value) {
        setStringValue(value);
    }

    @Override
    public String getValue() {
        return getStringValue();
    }

    @Override
    public void setDefaultValue(String defaultValue) {
       this.defaultValue = defaultValue;
    }

    @Override
    public void setValue(IEclipsePreferences prefs) {
        setValue(prefs.get(getPreferenceName(), defaultValue));
    }

    @Override
    public void fillValue(IEclipsePreferences prefs) {
        prefs.put(getPreferenceName(), getValue());
    }

    @Override
    public void setValue(OverridablePrefs prefs) {
        setValue((String) prefs.get(getPreferenceName()));
    }

    @Override
    public void setValue(IPreferenceStore mainPrefs) {
        var name = getPreferenceName();
        if (!mainPrefs.contains(name)) {
            setValue(defaultValue);
        }
        setValue(mainPrefs.getString(name));
    }
}
