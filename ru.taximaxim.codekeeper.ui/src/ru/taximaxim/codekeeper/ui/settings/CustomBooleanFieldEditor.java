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
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

public final class CustomBooleanFieldEditor extends BooleanFieldEditor implements ICustomFieldEditor<Boolean> {

    private final Composite parent;
    private boolean defaultValue;

    public CustomBooleanFieldEditor(String name, String label, Composite parent) {
        super(name, label, parent);
        this.parent = parent;
    }

    @Override
    public void setValue(Boolean selection) {
        getControl().setSelection(selection);
    }

    @Override
    public Boolean getValue() {
        return getControl().getSelection();
    }

    @Override
    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue != null && defaultValue;
    }

    @Override
    public Button getControl() {
        return getChangeControl(parent);
    }

    @Override
    public void setValue(IEclipsePreferences prefs) {
        setValue(prefs.getBoolean(getPreferenceName(), defaultValue));
    }

    @Override
    public void fillValue(IEclipsePreferences prefs) {
        prefs.putBoolean(getPreferenceName(), getValue());
    }

    @Override
    public void setValue(OverridablePrefs prefs) {
        setValue((boolean) prefs.get(getPreferenceName()));
    }

    @Override
    public void setValue(IPreferenceStore mainPrefs) {
        var name = getPreferenceName();
        if (!mainPrefs.contains(name)) {
            setValue(defaultValue);
        }
        setValue(mainPrefs.getBoolean(name));
    }
}