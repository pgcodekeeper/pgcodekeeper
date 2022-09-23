package ru.taximaxim.codekeeper.ui.properties;


import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbUpdateProperties extends PropertyPage {

    private Button btnEnableProjPref;
    private Button btnScriptAddTransact;
    private Button btnCheckFuncBodies;
    private Button btnAlterColUsingExpr;
    private Button btnCreateIdxConcurrent;
    private Button btnConstraintNotValid;
    private Button btnScriptFromSelObjs;
    private Button btnGenerateExists;
    private Button btnDropBeforeCreate;
    private Button btnAddPrePostScript;
    private Button btnDataMovementMode;

    private IEclipsePreferences prefs;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        prefs = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        panel.setLayout(layout);

        boolean overridePref = prefs.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);

        btnEnableProjPref = new Button(panel, SWT.CHECK);
        btnEnableProjPref.setText(Messages.ProjectProperties_enable_proj_prefs);
        btnEnableProjPref.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnEnableProjPref.setSelection(overridePref);
        btnEnableProjPref.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                btnScriptAddTransact.setEnabled(btnEnableProjPref.getSelection());
                btnCheckFuncBodies.setEnabled(btnEnableProjPref.getSelection());
                btnAlterColUsingExpr.setEnabled(btnEnableProjPref.getSelection());
                btnCreateIdxConcurrent.setEnabled(btnEnableProjPref.getSelection());
                btnConstraintNotValid.setEnabled(btnEnableProjPref.getSelection());
                btnScriptFromSelObjs.setEnabled(btnEnableProjPref.getSelection());
                btnGenerateExists.setEnabled(btnEnableProjPref.getSelection());
                btnDropBeforeCreate.setEnabled(btnEnableProjPref.getSelection());
                btnAddPrePostScript.setEnabled(btnEnableProjPref.getSelection());
                btnDataMovementMode.setEnabled(btnEnableProjPref.getSelection());
            }
        });

        btnScriptAddTransact = createPropertyButton(panel, DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                Messages.dbUpdatePrefPage_script_add_transaction, overridePref);
        btnCheckFuncBodies = createPropertyButton(panel, DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                Messages.dbUpdatePrefPage_check_function_bodies, overridePref);
        btnAlterColUsingExpr = createPropertyButton(panel, DB_UPDATE_PREF.USING_ON_OFF,
                Messages.dbUpdatePrefPage_switch_on_off_using, overridePref);
        btnCreateIdxConcurrent = createPropertyButton(panel, DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                Messages.DbUpdatePrefPage_print_index_with_concurrently, overridePref);
        btnConstraintNotValid = createPropertyButton(panel, DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID,
                Messages.ApplyCustomDialog_constraint_not_valid, overridePref);
        btnScriptFromSelObjs = createPropertyButton(panel, DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS,
                Messages.DbUpdatePrefPage_script_from_selected_objs, overridePref);
        btnGenerateExists = createPropertyButton(panel, DB_UPDATE_PREF.GENERATE_EXISTS,
                Messages.DbUpdatePrefPage_option_if_exists, overridePref);
        btnDropBeforeCreate = createPropertyButton(panel, DB_UPDATE_PREF.DROP_BEFORE_CREATE,
                Messages.DbUpdatePrefPage_option_drop_object, overridePref);
        btnAddPrePostScript = createPropertyButton(panel, DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                Messages.DbUpdatePrefPage_add_pre_post_script, overridePref);
        btnDataMovementMode = createPropertyButton(panel, DB_UPDATE_PREF.DATA_MOVEMENT_MODE,
                Messages.DbUpdatePrefPage_allow_data_movement, overridePref);

        return panel;
    }

    private Button createPropertyButton(Composite panel, String prefName, String text, boolean overridePref) {
        Button btn = new Button(panel, SWT.CHECK);
        btn.setText(text);
        GridData gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false, 2, 1);
        gd.horizontalIndent = 10;
        btn.setLayoutData(gd);
        btn.setSelection(prefs.getBoolean(prefName, false));
        btn.setEnabled(overridePref);
        return btn;
    }

    @Override
    protected void performDefaults() {
        IPreferenceStore mainPS = Activator.getDefault().getPreferenceStore();
        btnEnableProjPref.setSelection(false);
        setDefault(mainPS, btnScriptAddTransact, DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION);
        setDefault(mainPS, btnCheckFuncBodies, DB_UPDATE_PREF.CHECK_FUNCTION_BODIES);
        setDefault(mainPS, btnAlterColUsingExpr, DB_UPDATE_PREF.USING_ON_OFF);
        setDefault(mainPS, btnCreateIdxConcurrent, DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY);
        setDefault(mainPS, btnConstraintNotValid, DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID);
        setDefault(mainPS, btnScriptFromSelObjs, DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS);
        setDefault(mainPS, btnGenerateExists, DB_UPDATE_PREF.GENERATE_EXISTS);
        setDefault(mainPS, btnDropBeforeCreate, DB_UPDATE_PREF.DROP_BEFORE_CREATE);
        setDefault(mainPS, btnAddPrePostScript, DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT);
        setDefault(mainPS, btnDataMovementMode, DB_UPDATE_PREF.DATA_MOVEMENT_MODE);

        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
        }
    }

    private void setDefault(IPreferenceStore mainPS, Button btn, String prefName) {
        btn.setEnabled(false);
        btn.setSelection(mainPS.getBoolean(prefName));
    }

    @Override
    public boolean performOk() {
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void fillPrefs() throws BackingStoreException {
        prefs.putBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, btnEnableProjPref.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION, btnScriptAddTransact.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, btnCheckFuncBodies.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.USING_ON_OFF, btnAlterColUsingExpr.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY, btnCreateIdxConcurrent.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID, btnConstraintNotValid.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS, btnScriptFromSelObjs.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.GENERATE_EXISTS, btnGenerateExists.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.DROP_BEFORE_CREATE, btnDropBeforeCreate.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT, btnAddPrePostScript.getSelection());
        prefs.putBoolean(DB_UPDATE_PREF.DATA_MOVEMENT_MODE, btnDataMovementMode.getSelection());
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}
