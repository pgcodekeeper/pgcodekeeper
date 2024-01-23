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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

/**
 * Dialog box for filling in one-time preferences that will be used
 * when generating the script.
 */
public class ApplyCustomDialog extends Dialog {

    private Button btnScriptAddTransact;
    private Button btnCheckFuncBodies;
    private Button btnAlterColUsingExpr;
    private Button btnCreateIdxConcurrent;
    private Button btnConstraintNotValid;
    private Button btnScriptFromSelObjs;
    private Button btnGenerateExists;
    private Button btndropBeforeCreate;
    private Button btnCommInScriptEnd;
    private Button btnAddPrePostScript;
    private Button btnDataMovementMode;

    private final OverridablePrefs prefs;
    private final DatabaseType dbType;

    private final Map<String, Boolean> customSettings;

    public ApplyCustomDialog(Shell parentShell, OverridablePrefs prefs,
            DatabaseType dbType, Map<String, Boolean> customSettings) {
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

        btnScriptAddTransact = createCustomButton(panel, DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                Messages.dbUpdatePrefPage_script_add_transaction);

        btnCreateIdxConcurrent = createCustomButton(panel, DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                Messages.DbUpdatePrefPage_print_index_with_concurrently);

        btnConstraintNotValid = createCustomButton(panel, DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID,
                Messages.ApplyCustomDialog_constraint_not_valid);

        btnGenerateExists = createCustomButton(panel, DB_UPDATE_PREF.GENERATE_EXISTS,
                Messages.DbUpdatePrefPage_option_if_exists);

        btndropBeforeCreate = createCustomButton(panel, DB_UPDATE_PREF.DROP_BEFORE_CREATE,
                Messages.DbUpdatePrefPage_option_drop_object);

        btnCommInScriptEnd = createCustomButton(panel, DB_UPDATE_PREF.COMMENTS_TO_END,
                Messages.DbUpdatePrefPage_comments_to_end);

        btnAddPrePostScript = createCustomButton(panel, DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                Messages.DbUpdatePrefPage_add_pre_post_script);

        if (dbType == DatabaseType.PG) {
            btnCheckFuncBodies = createCustomButton(panel, DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                    Messages.dbUpdatePrefPage_check_function_bodies);

            btnAlterColUsingExpr = createCustomButton(panel, DB_UPDATE_PREF.USING_ON_OFF,
                    Messages.dbUpdatePrefPage_switch_on_off_using);
        }

        btnScriptFromSelObjs = createCustomButton(panel, DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS,
                Messages.DbUpdatePrefPage_script_from_selected_objs);

        btnDataMovementMode = createCustomButton(panel, DB_UPDATE_PREF.DATA_MOVEMENT_MODE,
                Messages.DbUpdatePrefPage_allow_data_movement);

        return panel;
    }

    private Button createCustomButton(Composite panel, String prefName, String text) {
        GridData gd = new GridData();
        Button btn = new Button(panel, SWT.CHECK);
        gd.horizontalIndent = 10;
        btn.setLayoutData(gd);
        btn.setText(text);
        btn.setSelection(prefs.getBooleanOfDbUpdatePref(prefName));
        return btn;
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
        customSettings.put(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                btnScriptAddTransact.getSelection());
        customSettings.put(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                btnCreateIdxConcurrent.getSelection());
        customSettings.put(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID,
                btnConstraintNotValid.getSelection());
        customSettings.put(DB_UPDATE_PREF.GENERATE_EXISTS,
                btnGenerateExists.getSelection());
        customSettings.put(DB_UPDATE_PREF.DROP_BEFORE_CREATE,
                btndropBeforeCreate.getSelection());
        customSettings.put(DB_UPDATE_PREF.COMMENTS_TO_END,
                btnCommInScriptEnd.getSelection());
        customSettings.put(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                btnAddPrePostScript.getSelection());
        if (dbType == DatabaseType.PG) {
            customSettings.put(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                    btnCheckFuncBodies.getSelection());
            customSettings.put(DB_UPDATE_PREF.USING_ON_OFF,
                    btnAlterColUsingExpr.getSelection());
        }
        customSettings.put(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS,
                btnScriptFromSelObjs.getSelection());
        customSettings.put(DB_UPDATE_PREF.DATA_MOVEMENT_MODE,
                btnDataMovementMode.getSelection());
        super.okPressed();
    }
}
