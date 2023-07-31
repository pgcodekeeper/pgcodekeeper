/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

/**
 * Dialog box for filling in one-time preferences that will be used when showing the difference.
 */
public class GetChangesCustomDialog extends Dialog {

    private Button btnNoPrivileges;
    private Button btnAutoFormatCode;
    private Button btnIgnoreColumnOrder;
    private Button btnEnableFuncDep;
    private Button btnSimplifyView;
    private Button btnUseGlobalIgnoreList;

    private final OverridablePrefs prefs;
    private final boolean isMsSql;

    private final Map<String, Boolean> customSettings;

    public GetChangesCustomDialog(Shell parentShell, OverridablePrefs prefs,
            boolean isMsSql, Map<String, Boolean> customSettings) {
        super(parentShell);
        this.customSettings = customSettings;
        this.prefs = prefs;
        this.isMsSql = isMsSql;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.DiffTableViewer_get_changes_custom);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());

        new Label(panel, SWT.NONE).setText(MessageFormat
            .format(Messages.getChangesCustomDialog_custom_prefs_description,
                    Messages.DiffTableViewer_get_changes));

        btnIgnoreColumnOrder = new Button(panel, SWT.CHECK);
        btnIgnoreColumnOrder.setText(Messages.GeneralPrefPage_ignore_column_order);
        GridData gd = new GridData();
        gd.horizontalIndent = 10;
        btnIgnoreColumnOrder.setLayoutData(gd);
        btnIgnoreColumnOrder.setSelection(prefs.getBooleanOfRootPref(PREF.IGNORE_COLUMN_ORDER));

        btnEnableFuncDep = new Button(panel, SWT.CHECK);
        btnEnableFuncDep.setText(Messages.GeneralPrefPage_enable_body_dependencies);
        btnEnableFuncDep.setToolTipText(Messages.GeneralPrefPage_body_depcy_tooltip);
        gd = new GridData();
        gd.horizontalIndent = 10;
        btnEnableFuncDep.setLayoutData(gd);
        btnEnableFuncDep.setSelection(prefs.getBooleanOfRootPref(PREF.ENABLE_BODY_DEPENDENCIES));

        btnNoPrivileges = new Button(panel, SWT.CHECK);
        btnNoPrivileges.setText(Messages.dbUpdatePrefPage_ignore_privileges);
        gd = new GridData();
        gd.horizontalIndent = 10;
        btnNoPrivileges.setLayoutData(gd);
        btnNoPrivileges.setSelection(prefs.getBooleanOfRootPref(PREF.NO_PRIVILEGES));

        if (!isMsSql) {
            btnSimplifyView = new Button(panel, SWT.CHECK);
            btnSimplifyView.setText(Messages.GeneralPrefPage_simplify_view);
            gd = new GridData();
            gd.horizontalIndent = 10;
            btnSimplifyView.setLayoutData(gd);
            btnSimplifyView.setSelection(prefs.getBooleanOfRootPref(PREF.SIMPLIFY_VIEW));
        }

        btnAutoFormatCode = new Button(panel, SWT.CHECK);
        btnAutoFormatCode.setText(Messages.GeneralPrefPage_format_object_code_automatically);
        gd = new GridData();
        gd.horizontalIndent = 10;
        btnAutoFormatCode.setLayoutData(gd);
        btnAutoFormatCode.setSelection(prefs.getBooleanOfRootPref(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY));

        btnUseGlobalIgnoreList = new Button(panel, SWT.CHECK);
        btnUseGlobalIgnoreList.setText(Messages.ProjectProperties_use_global_ignore_list);
        gd = new GridData();
        gd.horizontalIndent = 10;
        btnUseGlobalIgnoreList.setLayoutData(gd);
        btnUseGlobalIgnoreList.setSelection(prefs.isUseGlobalIgnoreList());

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
        customSettings.put(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, true);
        customSettings.put(PREF.NO_PRIVILEGES, btnNoPrivileges.getSelection());
        customSettings.put(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY, btnAutoFormatCode.getSelection());
        customSettings.put(PREF.IGNORE_COLUMN_ORDER, btnIgnoreColumnOrder.getSelection());
        customSettings.put(PREF.ENABLE_BODY_DEPENDENCIES, btnEnableFuncDep.getSelection());
        if (!isMsSql) {
            customSettings.put(PREF.SIMPLIFY_VIEW, btnSimplifyView.getSelection());
        }
        customSettings.put(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, btnUseGlobalIgnoreList.getSelection());
        super.okPressed();
    }
}
