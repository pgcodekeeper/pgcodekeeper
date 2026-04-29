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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.settings.CustomStringFieldEditor;

public class StringPreference extends AbstractPreference<String> {

    protected StringPreference(String preferenceName, PreferenceCategory category, String label, String toolTipText,
            String initialValue, boolean isNeedReset, Set<DatabaseType> validDbTypes, Set<PreferenceScope> scopes) {
        super(preferenceName, category, label, toolTipText, initialValue, isNeedReset, validDbTypes, scopes);
    }

    @Override
    protected void initialize(IPreferenceStore store) {
        store.setDefault(preferenceName, initialValue);
    }

    @Override
    protected CustomStringFieldEditor create(Composite parent, PreferenceScope scope) {
        Composite panelString = new Composite(parent.getParent(), SWT.NONE);
        var field = new CustomStringFieldEditor(preferenceName, label, panelString);
        Text textControl = field.getTextControl(panelString);

        var gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd.widthHint = 200;
        textControl.setLayoutData(gd);

        if (null != initialValue) {
            field.setDefaultValue(initialValue);
        }

        return field;
    }
}
