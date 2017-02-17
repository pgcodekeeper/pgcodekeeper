package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import ru.taximaxim.codekeeper.ui.UIConsts.WORKING_SET;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

class PgImport extends WizardPage {

    private final IStructuredSelection selection;
    private Text txtPath, txtName;
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
        txtPath.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                getWizard().getContainer().updateButtons();
            }
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
        txtName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                getWizard().getContainer().updateButtons();
            }
        });

        Composite workingSet = new Composite(area, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = layout.marginWidth = 0;
        workingSet.setLayout(layout);
        workingSet.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 3, 1));
        workingSetGroup = new WorkingSetGroup(workingSet, selection,
                new String[] { WORKING_SET.RESOURCE_WORKING_SET });

        setControl(area);
    }

    private void find() {
        DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
        dialog.setMessage(Messages.PgImportWizardImportPage_select_root_for_import);
        dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        String selectedDirectory = dialog.open();
        if (selectedDirectory != null) {
            txtPath.setText(selectedDirectory);
            txtName.setText(Paths.get(txtPath.getText()).getFileName().toString());
        }
    }

    public boolean createProject () {
        try {
            //if don't have .pgCodekeeper
            if (Files.notExists(Paths.get(txtPath.getText()+"/.pgcodekeeper"))){
                setMessage(Messages.PgImportWizardImportPage_no_project, WARNING);
                return false;
            }
            //if have .project
            if (Files.exists(Paths.get(txtPath.getText()+"/.project"))){
                setMessage(Messages.PgImportWizardImportPage_already_exist, WARNING);
                return false;
            }
            //set default name, if project in root of workspace
            if(Files.exists(Paths.get(txtPath.getText()).getParent().resolve(".metadata"))){ //$NON-NLS-1$
                txtName.setText(Paths.get(txtPath.getText()).getFileName().toString());
            }
            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(txtName.getText());
            PgDbProject.createPgDbProject(project, Paths.get(txtPath.getText()).toUri());
            project.getProject().open(null);
            addToWorkingSet(project);
        } catch (CoreException e) {
            return false;
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
        return txtPath.getText().length()>0 && txtName.getText().length()>0;
    }
}