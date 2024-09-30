/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.jface.preference.IPreferenceStore;

public final class FieldEditorStore {

    private final List<TempBooleanFieldEditor> list = new ArrayList<>();

    /**
     * Method set default preference in project properties from pgCodeKeeper global preference
     *
     * @param prefs - preference store which store pgCodeKeeper global preference
     */
    public void performDefaults(IPreferenceStore prefs) {
        list.forEach(e -> e.setSelection(prefs.getBoolean(e.getPreferenceName())));
    }

    public void add(TempBooleanFieldEditor btn) {
        list.add(btn);
    }

    public void setEnable(boolean enabled) {
        list.forEach(e -> e.setEnabled(enabled));
    }

    public void setVisible(boolean visible) {
        list.forEach(e -> e.setVisible(visible));
    }

    public Map<String, Boolean> getPrefs() {
        return list.stream().collect(
                Collectors.toMap(TempBooleanFieldEditor::getPreferenceName, TempBooleanFieldEditor::getBooleanValue));
    }

    public boolean getValue(String prefName) {
        return list.stream()
                .filter(e -> Objects.equals(prefName, e.getPreferenceName()))
                .findAny()
                .orElseThrow(() -> throwUnknownParamException(prefName))
                .getBooleanValue();
    }

    public void setValue(String prefName, boolean value) {
        list.stream()
        .filter(e -> Objects.equals(prefName, e.getPreferenceName()))
        .findAny()
        .orElseThrow(() -> throwUnknownParamException(prefName))
        .setSelection(value);
    }

    private IllegalArgumentException throwUnknownParamException(String prefName) {
        return new IllegalArgumentException(
                String.format("Button with preference: %s do not contains in this page", prefName)); //$NON-NLS-1$
    }
}