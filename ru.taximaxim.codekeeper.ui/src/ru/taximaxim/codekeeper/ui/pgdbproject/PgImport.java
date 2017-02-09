package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.ui.dialogs.WorkingSetGroup;

import ru.taximaxim.codekeeper.ui.UIConsts.IMPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgImport extends WizardPage {
    Text path;
    IProjectDescription description;
    Text name;

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

        Button browse = new Button(area, SWT.PUSH);
        browse.setText(Messages.PgImportWizardImportPage_browse);
        browse.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                find();
            }
        });

        new Label(area, SWT.NONE).setText("Project name:");

        name = new Text(area, SWT.NONE);
        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        name.setLayoutData(data);


        Composite workingSet = new Composite(parent, SWT.NONE);
        workingSet.setLayout(new GridLayout());
        workingSet.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        String[] workingSetIds = new String[] { IMPORT_PREF.RESOURCE_WORKING_SET, IMPORT_PREF.JAVA_WORKING_SET };
        new WorkingSetGroup(workingSet, null, workingSetIds);
    }

    private void find() {
        DirectoryDialog dialog = new DirectoryDialog(path.getShell(), SWT.SHEET);
        dialog.setMessage(Messages.PgImportWizardImportPage_select_root_for_import);
        dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
        String selectedDirectory = dialog.open();
        if(selectedDirectory!=null){
            path.setText(selectedDirectory);
            try {
                description = ResourcesPlugin.getWorkspace().
                        loadProjectDescription(new Path(path.getText()+"/.project"));
                name.setText(description.getName());
                setMessage(Messages.PgImportWizardImportPage_all_ok);
            } catch (CoreException e) {
                setMessage(Messages.PgImportWizardImportPage_no_project, WARNING);
            }
        }
    }

    public boolean createProject () {
        try {
            if (!new File(path.getText()+"/.pgcodekeeper").exists()){
                setMessage("Not pgCodeKeeper project",WARNING);
                return false;
            }
            if (name.getText().length()==0){
                setMessage("Project name can not be empty",WARNING);
                return false;
            }
            description = ResourcesPlugin.getWorkspace().
                    loadProjectDescription(new Path(path.getText()+"/.project"));

            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name.getText());
            project.create(description,null);
            project.open(null);
        }
        catch (CoreException e) {
            setMessage(Messages.PgImportWizardImportPage_exist_or_corrupted, WARNING);
            return false;
        }
        return true;
    }
}
