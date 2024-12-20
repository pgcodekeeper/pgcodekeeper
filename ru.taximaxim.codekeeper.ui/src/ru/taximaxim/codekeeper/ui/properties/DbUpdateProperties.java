/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.properties;


import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.FieldEditorStore;
import ru.taximaxim.codekeeper.ui.prefs.TempBooleanFieldEditor;

public class DbUpdateProperties extends PropertyPage {

    private Button btnEnableProjPref;
    private FieldEditorStore fieldEditorStore;
    private DatabaseType dbType;

    private IEclipsePreferences prefs;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        dbType = OpenProjectUtils.getDatabaseType(project);
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

        Composite btnsPanel = new Composite(panel, SWT.NONE);
        GridData gd = new GridData(SWT.BEGINNING, SWT.DEFAULT, true, false, 2, 1);
        gd.horizontalIndent = 10;
        btnsPanel.setLayoutData(gd);

        btnEnableProjPref.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                fieldEditorStore.setEnable(btnEnableProjPref.getSelection());
            }
        });

        fieldEditorStore = new FieldEditorStore();

        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                Messages.DbUpdatePrefPage_script_add_transaction, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                Messages.ApplyCustomDialog_constraint_not_valid, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS,
                Messages.DbUpdatePrefPage_script_from_selected_objs, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.GENERATE_EXISTS,
                Messages.DbUpdatePrefPage_option_if_exists, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.DROP_BEFORE_CREATE,
                Messages.DbUpdatePrefPage_option_drop_object, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                Messages.DbUpdatePrefPage_add_pre_post_script, btnsPanel, prefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.DATA_MOVEMENT_MODE,
                Messages.DbUpdatePrefPage_allow_data_movement, btnsPanel, prefs::getBoolean));

        if (DatabaseType.PG == dbType) {
            fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                    Messages.dbUpdatePrefPage_check_function_bodies, btnsPanel, prefs::getBoolean));
            fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.USING_ON_OFF,
                    Messages.dbUpdatePrefPage_switch_on_off_using, btnsPanel, prefs::getBoolean));
            fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID,
                    Messages.dbUpdatePrefPage_check_function_bodies, btnsPanel, prefs::getBoolean));
            fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK,
                    Messages.DbUpdatePrefPage_generate_exist_do_block, btnsPanel, prefs::getBoolean));
            fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.COMMENTS_TO_END,
                    Messages.DbUpdatePrefPage_comments_to_end, btnsPanel, prefs::getBoolean));
        }

        fieldEditorStore.setEnable(overridePref);
        return panel;
    }

    @Override
    protected void performDefaults() {
        btnEnableProjPref.setSelection(false);
        fieldEditorStore.performDefaults(Activator.getDefault().getPreferenceStore());
        fieldEditorStore.setEnable(false);

        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
        }
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
        fieldEditorStore.getPrefs().forEach((k, v) -> prefs.putBoolean(k, v));
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}
