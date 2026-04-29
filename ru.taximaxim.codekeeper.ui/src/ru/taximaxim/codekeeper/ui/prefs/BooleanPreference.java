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
package ru.taximaxim.codekeeper.ui.prefs;

import java.util.Set;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.settings.CustomBooleanFieldEditor;

public class BooleanPreference extends AbstractPreference<Boolean> {

    protected BooleanPreference(String preferenceName, PreferenceCategory category, String label, String toolTipText,
            Boolean initialValue, boolean isNeedReset, Set<DatabaseType> valiDbTypes, Set<PreferenceScope> scopes) {
        super(preferenceName, category, label, toolTipText, initialValue, isNeedReset, valiDbTypes, scopes);
    }

    protected BooleanPreference(String preferenceName, PreferenceCategory category, String label, String toolTipText,
            Boolean initialValue, boolean isNeedReset, Set<PreferenceScope> scopes) {
        this(preferenceName, category, label, toolTipText, initialValue, isNeedReset, Set.of(), scopes);
    }

    protected BooleanPreference(String preferenceName, PreferenceCategory category, String label,
            Set<PreferenceScope> scopes) {
        this(preferenceName, category, label, null, null, false, Set.of(), scopes);
    }

    @Override
    protected void initialize(IPreferenceStore store) {
        store.setDefault(preferenceName, initialValue);
    }

    @Override
    protected CustomBooleanFieldEditor create(Composite parent, PreferenceScope scope) {
        var field = new CustomBooleanFieldEditor(preferenceName, label, parent);

        if (null != toolTipText) {
            field.getDescriptionControl(parent).setToolTipText(toolTipText);
        }
        if (null != initialValue) {
            field.setDefaultValue(initialValue);
        }
        return field;
    }
}
