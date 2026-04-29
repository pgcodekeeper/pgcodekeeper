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
package ru.taximaxim.codekeeper.ui.properties;

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

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceCategory;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceScope;
import ru.taximaxim.codekeeper.ui.prefs.Preferences;
import ru.taximaxim.codekeeper.ui.settings.FieldEditorStore;
import ru.taximaxim.codekeeper.ui.settings.ICustomFieldEditor;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class DbUpdateProperties extends PropertyPage {

    private Button btnEnableProjPref;
    private FieldEditorStore fieldEditorStore;
    private DatabaseType dbType;

    private IEclipsePreferences prefs;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject project = element.getAdapter(IProject.class);
        dbType = ProjectUtils.getDatabaseType(project);
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

        Preferences
            .build(PreferenceScope.PROJECT, PreferenceCategory.DB_UPDATE, btnsPanel, dbType)
            .forEach(e -> {
                var f = (ICustomFieldEditor<?>) e;
                fieldEditorStore.add(f);
                f.setValue(prefs);
            });

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
            setErrorMessage(
                    Messages.projectProperties_error_occurs_while_saving_properties.formatted(e.getLocalizedMessage()));
            setValid(false);
        }
    }

    @Override
    public boolean performOk() {
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(Messages.projectProperties_error_occurs_while_saving_properties.formatted(
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void fillPrefs() throws BackingStoreException {
        prefs.putBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, btnEnableProjPref.getSelection());
        fieldEditorStore.getFields().forEach(e -> e.fillValue(prefs));
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}
