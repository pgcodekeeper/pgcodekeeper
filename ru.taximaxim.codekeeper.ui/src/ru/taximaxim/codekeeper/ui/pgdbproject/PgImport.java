package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.IMPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgImport extends WizardPage {
    private Text path, name;
    private WorkingSetGroup workingSetGroup;
    private IWorkingSet[] selectedWorkingSets;

    protected PgImport(String pageName) {
        super(pageName);
        setTitle(Messages.PgImportWizardImportPage_project);
        setDescription(Messages.PgImportWizardImportPage_select_project);
    }

    @Override
    public void createControl(Composite parent) {
        initializeDialogUnits(parent);
        Composite area = new Composite(parent, SWT.NONE);
        setControl(area);
        area.setLayout(new GridLayout());
        area.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
        createBody(area);
    }

    private void createBody(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);

        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.makeColumnsEqualWidth = false;
        layout.marginWidth = 0;

        area.setLayout(layout);
        area.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(area, SWT.NONE).setText(Messages.PgImportWizardImportPage_select_root_directory);

        path = new Text(area, SWT.NONE);
        path.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        path.addModifyListener(new ModifyListener() {
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

        name = new Text(area, SWT.NONE);
        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        name.setLayoutData(data);
        name.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                getWizard().getContainer().updateButtons();
            }
        });

        Composite workingSet = new Composite(parent, SWT.NONE);
        workingSet.setLayout(new GridLayout());
        workingSet.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        workingSetGroup = new WorkingSetGroup(workingSet, null,
                new String[] { IMPORT_PREF.RESOURCE_WORKING_SET, IMPORT_PREF.JAVA_WORKING_SET });
    }

    private void find() {
        DirectoryDialog dialog = new DirectoryDialog(path.getShell(), SWT.SHEET);
        dialog.setMessage(Messages.PgImportWizardImportPage_select_root_for_import);
        dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        String selectedDirectory = dialog.open();
        if(selectedDirectory!=null){
            path.setText(selectedDirectory);
            name.setText(Paths.get(path.getText()).getFileName().toString());
            setMessage(Messages.PgImportWizardImportPage_all_ok);
        }
    }

    public boolean createProject () {
        try {
            //if don't have .pgCodekeeper
            if (Files.notExists(Paths.get(path.getText()+"/.pgcodekeeper"))){
                setMessage(Messages.PgImportWizardImportPage_no_project, WARNING);
                return false;
            }
            //if have .project
            if (Files.exists(Paths.get(path.getText()+"/.project"))){
                setMessage(Messages.PgImportWizardImportPage_already_exist, WARNING);
                return false;
            }
            //set default name, if project in root of workspace
            if(Files.exists(Paths.get(path.getText()).getParent().resolve(".metadata"))){ //$NON-NLS-1$
                name.setText(Paths.get(path.getText()).getFileName().toString());
            }
            IProject project = PgDbProject.getProjFromFile(name.getText(), path.getText()).getProject();
            project.getProject().open(null);
            PgDbProject.addNatureToProject(project);
            addToWorkingSet(project);
        }
        catch (CoreException | PgCodekeeperUIException e) {
            return false;
        }
        return true;
    }

    private void addToWorkingSet(IProject project) {
        selectedWorkingSets = workingSetGroup.getSelectedWorkingSets();
        if (selectedWorkingSets == null || selectedWorkingSets.length == 0) {
            return; // no Working set is selected
        }
        IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
        workingSetManager.addToWorkingSets(project, selectedWorkingSets);
    }

    @Override
    public boolean isPageComplete(){
        return path.getText().length()>0 && name.getText().length()>0;
    }
}