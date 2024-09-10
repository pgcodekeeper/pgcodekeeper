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
package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_BIND_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.dbstore.AbstractStorePicker;
import ru.taximaxim.codekeeper.ui.dbstore.DbMenuStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class DBStoreCombo extends WorkbenchWindowControlContribution {

    private DbMenuStorePicker storePicker;
    private EditorPartListener editorPartListener;

    @Override
    protected Control createControl(Composite parent) {
        IWorkbenchPage page = getWorkbenchWindow().getActivePage();

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout();
        gl.marginWidth = gl.marginHeight = 0;
        composite.setLayout(gl);

        IEditorPart editorPart = page.getActiveEditor();
        storePicker = new DbMenuStorePicker(composite,
                editorPart instanceof ProjectEditorDiffer, false);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.minimumWidth = new PixelConverter(composite)
                .convertWidthInCharsToPixels(AbstractStorePicker.DEFAULT_LENGTH);
        storePicker.getControl().setLayoutData(gd);

        editorPartListener = new EditorPartListener();
        page.addPartListener(editorPartListener);

        storePicker.addSelectionListener(() -> {
            IEditorPart editor = getWorkbenchWindow().getActivePage().getActiveEditor();

            if (editor instanceof SQLEditor sqlEditor) {
                sqlEditor.setCurrentDb(storePicker.getDbInfo());
            } else if (editor instanceof ProjectEditorDiffer differ) {
                Object selection = storePicker.getDbInfo();
                if (selection == null) {
                    selection = storePicker.getPathOfFile();
                }
                differ.setCurrentDb(selection);
            }
        });

        composite.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                if (!storePicker.isEnabled()) {
                    MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
                    mb.setText(Messages.DbStoreCombo_db_binding_property_title);
                    mb.setMessage(Messages.DbStoreCombo_db_binding_property);
                    mb.open();
                }
            }
        });

        setSelectionFromPart(editorPart);

        return composite;
    }

    @Override
    public void dispose() {
        getWorkbenchWindow().getActivePage().removePartListener(editorPartListener);
        storePicker.dispose();
    }

    private void setSelectionFromPart(IWorkbenchPart part) {
        Object lastDb = null;
        IProject proj = null;

        if (part instanceof SQLEditor editor) {
            lastDb = editor.getCurrentDb();
            storePicker.setUseFileSources(false);
            IEditorInput input = editor.getEditorInput();
            if (input instanceof FileEditorInput fileEditorInput) {
                proj = fileEditorInput.getFile().getProject();
            }
            setDbComboEnableState(editor.getProjDbBindPrefs());
        } else if (part instanceof ProjectEditorDiffer differ) {
            lastDb = differ.getCurrentDb();
            storePicker.setUseFileSources(true);
            proj = differ.getProject();
            setDbComboEnableState(PgDbProject.getPrefs(differ.getProject(), false));
        } else {
            return;
        }

        try {
            DatabaseType dbType;
            if (proj != null && proj.hasNature(NATURE.ID)) {
                dbType = OpenProjectUtils.getDatabaseType(proj);
            } else {
                dbType = null;
            }
            storePicker.filter(dbType);
        } catch (CoreException ex) {
            Log.log(ex);
        }

        if (lastDb == null) {
            storePicker.clearSelection();
        } else {
            storePicker.setSelection(lastDb);
            storePicker.updateSelection();
        }
        update();
    }

    private void setDbComboEnableState(IEclipsePreferences auxPrefs) {
        storePicker.setEnabled(auxPrefs == null ||
                auxPrefs.get(DB_BIND_PREF.NAME_OF_BOUND_DB, "").isEmpty()); //$NON-NLS-1$
    }

    private class EditorPartListener extends IPartAdapter2 {

        @Override
        public void partActivated(IWorkbenchPartReference partRef) {
            setSelectionFromPart(partRef.getPart(false));
        }
    }
}
