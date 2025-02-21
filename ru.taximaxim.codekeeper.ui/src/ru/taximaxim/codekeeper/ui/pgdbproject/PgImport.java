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
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WorkingSetGroup;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.WORKING_SET;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.handlers.ConvertProject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

class PgImport extends WizardPage {

    private static final String FILE_METADATA = ".metadata"; //$NON-NLS-1$
    private static final String FILE_PROJECT = ".project"; //$NON-NLS-1$

    private final IStructuredSelection selection;
    private Text txtPath;
    private Text txtName;
    private ComboViewer cmbDbType;
    private ComboViewer charsetCombo;
    private WorkingSetGroup workingSetGroup;

    protected PgImport(String pageName, IStructuredSelection selection) {
        super(pageName);
        this.selection = selection;

        setTitle(Messages.PgImportWizardImportPage_project);
        setDescription(Messages.PgImportWizardImportPage_select_project);
    }

    @Override
    public void createControl(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(3, false));
        area.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(area, SWT.NONE).setText(Messages.PgImportWizardImportPage_select_root_directory);

        txtPath = new Text(area, SWT.BORDER);
        txtPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtPath.addModifyListener(e -> {
            //set project name if not given, or if project is in root of workspace
            Path pathDir = Paths.get(txtPath.getText());
            if (txtName.getText().isEmpty() || isInWorkspaceRoot(pathDir)) {
                txtName.setText(pathDir.getFileName().toString());
            }

            getWizard().getContainer().updateButtons();
        });

        Button browse = new Button(area, SWT.PUSH);
        browse.setText(Messages.PgImportWizardImportPage_browse);
        browse.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                find();
            }
        });

        new Label(area, SWT.NONE).setText(Messages.PgImportWizardImportPage_name);

        txtName = new Text(area, SWT.BORDER);
        txtName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));
        txtName.addModifyListener(e -> getWizard().getContainer().updateButtons());

        //char sets
        new Label(area, SWT.NONE).setText(Messages.NewProjWizard_select_charset);

        charsetCombo = new ComboViewer(area, SWT.DROP_DOWN);
        charsetCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));
        charsetCombo.setContentProvider(ArrayContentProvider.getInstance());
        charsetCombo.setInput(UIConsts.ENCODINGS);
        charsetCombo.setSelection(new StructuredSelection(Consts.UTF_8));

        new Label(area, SWT.NONE).setText(Messages.database_type);

        cmbDbType = new ComboViewer(area, SWT.READ_ONLY);
        cmbDbType.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbType.setLabelProvider(UIConsts.DATABASE_TYPE_PROVIDER);
        cmbDbType.setInput(DatabaseType.values());
        cmbDbType.getCombo().select(0);

        Composite workingSet = new Composite(area, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = layout.marginWidth = 0;
        workingSet.setLayout(layout);
        workingSet.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        workingSetGroup = new WorkingSetGroup(workingSet, selection,
                new String[] { WORKING_SET.RESOURCE_WORKING_SET });

        setControl(area);
    }

    public DatabaseType getSelectedDbType() {
        return (DatabaseType) cmbDbType.getStructuredSelection().getFirstElement();
    }

    private void find() {
        DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
        dialog.setMessage(Messages.PgImportWizardImportPage_select_root_for_import);
        dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        String selectedDirectory = dialog.open();
        if (selectedDirectory != null) {
            txtPath.setText(selectedDirectory);
        }
    }

    public boolean createProject () {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(txtName.getText());
        Path p = Paths.get(txtPath.getText());

        try {
            if (ConvertProject.createMarker(getShell(), p, getSelectedDbType())) {
                PgDbProject props = PgDbProject.createPgDbProject(project,
                        isInWorkspaceRoot(p) ? null : p.toUri(), getSelectedDbType());
                String charset = charsetCombo.getCombo().getText();
                if (!charset.isEmpty() && !ResourcesPlugin.getWorkspace().getRoot()
                        .getDefaultCharset().equals(charset)) {
                    props.setProjectCharset(charset);
                }
                addToWorkingSet(project);
            } else {
                return false;
            }
        } catch (CoreException | IOException e) {
            ExceptionNotifier.notifyDefault(Messages.PgImport_import_error, e);
            return false;
        }

        try {
            project.open(null);
        } catch (CoreException e) {
            // created project but couldn't open, proceed on
            Log.log(e);
        }
        return true;
    }

    private void addToWorkingSet(IProject project) {
        IWorkingSet[] selectedWorkingSets = workingSetGroup.getSelectedWorkingSets();
        if (selectedWorkingSets.length != 0) {
            IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
            workingSetManager.addToWorkingSets(project, selectedWorkingSets);
        }
    }

    @Override
    public boolean isPageComplete(){
        String name = txtName.getText();
        String fullpath = txtPath.getText();

        //empty path: show default message
        if (fullpath.isEmpty()) {
            setErrorMessage(null);
            return false;
        }

        String err = null;
        if (name.isEmpty()) {
            err = Messages.PgImport_error_no_name;
        }
        Path path = Paths.get(fullpath);
        if (Files.exists(path.resolve(FILE_PROJECT))) {
            //if has .project
            err = Messages.PgImportWizardImportPage_already_exist;
        } else if (Files.exists(path.resolve(FILE_METADATA))) {
            //if has .metadata
            err = Messages.PgImport_error_metadata;
        } else if (isInWorkspaceRoot(path) && !path.getFileName().toString().equals(name)) {
            //if project in root of workspace, it must have default name
            err = Messages.PgImport_error_default_name;
        }
        setErrorMessage(err);
        return err == null;
    }

    private boolean isInWorkspaceRoot(Path path) {
        Path parent = path.getParent();
        if (parent == null) {
            return false;
        }

        String root = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
        return root.equals(parent.toString());
    }
}
