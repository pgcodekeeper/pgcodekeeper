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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.text.MessageFormat;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceCategory;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceScope;
import ru.taximaxim.codekeeper.ui.prefs.Preferences;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;
import ru.taximaxim.codekeeper.ui.settings.FieldEditorStore;
import ru.taximaxim.codekeeper.ui.settings.ICustomFieldEditor;

/**
 * Dialog box for filling in one-time preferences that will be used
 * when generating the script.
 */
public class ApplyCustomDialog extends Dialog {

    private FieldEditorStore fieldEditorStore;

    private final OverridablePrefs prefs;
    private final DatabaseType dbType;

    private final Map<String, Object> customSettings;

    public ApplyCustomDialog(Shell parentShell, OverridablePrefs prefs,
            DatabaseType dbType, Map<String, Object> customSettings) {
        super(parentShell);
        this.customSettings = customSettings;
        this.prefs = prefs;
        this.dbType = dbType;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.DiffTableViewer_apply_to_custom);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());

        new Label(panel, SWT.NONE).setText(MessageFormat
                .format(Messages.getChangesCustomDialog_custom_prefs_description,
                        Messages.DiffTableViewer_apply_to));

        Composite btnsPanel = new Composite(panel, SWT.NONE);
        GridData gd = new GridData();
        gd.horizontalIndent = 10;
        btnsPanel.setLayoutData(gd);

        fieldEditorStore = new FieldEditorStore();

        Preferences
            .build(PreferenceScope.CUSTOM_APPLY_TO, PreferenceCategory.DB_UPDATE, btnsPanel, dbType)
            .forEach(e -> {
                var f = (ICustomFieldEditor<?>) e;
                fieldEditorStore.add(f);
                f.setValue(prefs);
            });

        return panel;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        Button btnOk = getButton(IDialogConstants.OK_ID);
        btnOk.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false));
        btnOk.setText(Messages.getChangesCustomDialog_run_with_specified_prefs);
    }

    @Override
    protected void okPressed() {
        customSettings.put(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, true);
        customSettings.putAll(fieldEditorStore.getPrefs());

        super.okPressed();
    }
}
