package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.DBSources;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewProjWizard extends Wizard 
        implements IExecutableExtension, INewWizard {

    private PageRepo pageRepo;
    private PageDb pageDb;

    private final IPreferenceStore mainPrefStore;

    private PgDbProject props;
    private IConfigurationElement config;
    private IWorkbench workbench;
    private IStructuredSelection selection;
    
    public NewProjWizard() {
        setWindowTitle(Messages.newProjWizard_new_pg_db_project);
        setNeedsProgressMonitor(true);
        this.mainPrefStore = Activator.getDefault().getPreferenceStore();
    }
    
    public PgDbProject getProject() {
        return props;
    }

    @Override
    public void addPages() {
        pageRepo = new PageRepo(Messages.newProjWizard_repository_settings, selection);
        pageRepo.setTitle(Messages.newProjWizard_new_pg_db_project);
        pageRepo.setDescription(Messages.NewProjWizard_create_project);
        addPage(pageRepo);
        pageDb = new PageDb(Messages.newProjWizard_schema_source_settings, mainPrefStore);
        addPage(pageDb);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
        helpSystem.setHelp(pageRepo.getControl(), HELP.NEW_WIZARD);
        helpSystem.setHelp(pageDb.getControl(), HELP.NEW_WIZARD_INIT);
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        if(page.equals(pageRepo)) {
            if (!checkMarkerExist()) {
                return pageDb;
            } else {
                return null;
            }
        }
        return super.getNextPage(page);
    }
    /**
     * Проверяет на наличие файла маркера в директории проекта
     * @return существует ли маркер
     */
    private boolean checkMarkerExist() {
            File sub = new File (pageRepo.getLocationURI()); 
            if (!new File(sub, ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
            return false;
            }
        return true;
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageRepo && !checkMarkerExist()) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            props = PgDbProject.getProjectFromIProjectHandle(
                    pageRepo.getProjectHandle(), 
                    pageRepo.useDefaults() ? null : pageRepo.getLocationURI());

            Log.log(Log.LOG_INFO, "Creating new project properties"); //$NON-NLS-1$

            fillProjProps();
            
            if (!checkMarkerExist()) {
                try {
                    getContainer().run(true, true,
                            new InitProjectFromSource(mainPrefStore, props,
                                    pageDb.getDumpPath(), pageDb.getDbPass()));
                } catch (InvocationTargetException ex) {
                    props.deleteFromWorkspace();
                    ExceptionNotifier.notifyDefault(
                            Messages.newProjWizard_error_in_initializing_repo_from_source,
                                    ex);
                    return false;
                } catch (InterruptedException ex) {
                    // cancelled
                    props.deleteFromWorkspace();
                    return false;
                }
            }
            
            BasicNewProjectResourceWizard.updatePerspective(config);
            BasicNewResourceWizard.selectAndReveal(props.getProject(), 
                    workbench.getActiveWorkbenchWindow());

            props.openProject();
            try {
                PgDbProject.addNatureToProject(props.getProject());
                props.getPrefs().flush();
            } catch (BackingStoreException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.NewProjWizard_error_saving_projprefs, e);
                return false;
            } catch (CoreException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.NewProjWizard_error_adding_nature, e);
                return false;
            }
            
            IWorkingSet[] workingSets = pageRepo.getSelectedWorkingSets();
            workbench.getWorkingSetManager().addToWorkingSets(props.getProject(),
                    workingSets);
            
            OpenEditor.openEditor(PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage(),
                    props.getProject());
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.notifyDefault(Messages.NewProjWizard_error_creating_project, e);
            return false;
        }
        return true;
    }
    
    private void fillProjProps() {
        IEclipsePreferences newPrefs = props.getPrefs();
        setDbSource(newPrefs);
        newPrefs.put(PROJ_PREF.DB_NAME, pageDb.getDbName());
        newPrefs.put(PROJ_PREF.DB_USER, pageDb.getDbUser());
        newPrefs.put(PROJ_PREF.DB_HOST, pageDb.getDbHost());
        newPrefs.putInt(PROJ_PREF.DB_PORT, pageDb.getDbPort());
    }

    private void setDbSource(IEclipsePreferences newPrefs) {
        DBSources src;
        if (pageDb.isSourceDb()) {
            src = DBSources.SOURCE_TYPE_DB;
        } else if (pageDb.isSourceDump()) {
            src = DBSources.SOURCE_TYPE_DUMP;
        } else if (pageDb.isSourceJdbc()) {
            src = DBSources.SOURCE_TYPE_JDBC;
        } else {
            ExceptionNotifier.notifyDefault(
                    Messages.newProjWizard_no_schema_source_selected, null);
            return;
        }
        newPrefs.put(PROJ_PREF.SOURCE, src.toString());
    }

    @Override
    public void setInitializationData(IConfigurationElement config,
            String propertyName, Object data) throws CoreException {
        this.config = config;        
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
    }    
}

class PageRepo extends WizardNewProjectCreationPage implements Listener {
    
    private static final String WORKING_SET_ID = "org.eclipse.ui.resourceWorkingSetPage"; //$NON-NLS-1$
    
    private IStructuredSelection selection;

    PageRepo(String pageName, IStructuredSelection selection) {
        super(pageName);
        this.selection = selection;
    }
    
    @Override
    public void createControl(final Composite parent) {
        super.createControl(parent);
        createWorkingSetGroup((Composite) getControl(), selection,
                new String[] { WORKING_SET_ID });
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}

class PageDb extends WizardPage implements Listener {

    private final IPreferenceStore mainPrefs;

    private Composite container;
    private Button radioDb, radioJdbc, radioDump;
    private DbPicker grpDb;
    private Group grpDump;
    private Text txtDumpPath;

    public boolean isSourceDb() {
        return radioDb.getSelection();
    }

    public boolean isSourceDump() {
        return radioDump.getSelection();
    }

    public boolean isSourceJdbc() {
        return radioJdbc.getSelection();
    }

    public String getDbName() {
        return grpDb.getTxtDbName().getText();
    }

    public String getDbUser() {
        return grpDb.getTxtDbUser().getText();
    }
    
    public String getDbPass() {
        return grpDb.getTxtDbPass().getText();
    }
    
    public String getDbHost() {
        return grpDb.getTxtDbHost().getText();
    }
    
    public int getDbPort() {
        try {
            return Integer.parseInt(grpDb.getTxtDbPort().getText());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    public String getDumpPath() {
        return txtDumpPath.getText();
    }

    PageDb(String pageName, IPreferenceStore mainPrefs) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
    }

    @Override
    public void createControl(final Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));

        Group radioGrp = new Group(container, SWT.NONE);
        radioGrp.setText(Messages.newProjWizard_schema_source);
        radioGrp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
                2, 1));
        radioGrp.setLayout(new GridLayout(3, false));

        radioJdbc = new Button(radioGrp, SWT.RADIO);
        radioJdbc.setText(Messages.jdbc);
        radioJdbc.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                grpDb.setVisible(true);
                grpDump.setVisible(false);

                ((GridData) grpDb.getLayoutData()).exclude = false;
                ((GridData) grpDump.getLayoutData()).exclude = true;

                container.layout(false);
            }
        });
        radioJdbc.addListener(SWT.Selection, this);
        radioJdbc.setSelection(true);

        radioDb = new Button(radioGrp, SWT.RADIO);
        radioDb.setText(Messages.db);

        radioDb.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (radioDb.getSelection()) {
                    grpDump.setVisible(false);
                    grpDb.setVisible(true);

                    ((GridData) grpDump.getLayoutData()).exclude = true;
                    ((GridData) grpDb.getLayoutData()).exclude = false;

                    container.layout(false);
                }
            }
        });
        radioDb.addListener(SWT.Selection, this);

        radioDump = new Button(radioGrp, SWT.RADIO);
        radioDump.setText(Messages.dump_file);

        radioDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (radioDump.getSelection()) {
                    grpDb.setVisible(false);
                    grpDump.setVisible(true);

                    ((GridData) grpDb.getLayoutData()).exclude = true;
                    ((GridData) grpDump.getLayoutData()).exclude = false;

                    container.layout(false);
                }
            }
        });
        radioDb.addListener(SWT.Selection, this);

        grpDb = new DbPicker(container, SWT.NONE, mainPrefs);
        grpDb.setText(Messages.newProjWizard_db_source_settings);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
        gd.exclude = false;
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);
        grpDb.setVisible(true);

        grpDump = new Group(container, SWT.NONE);
        grpDump.setText(Messages.newProjWizard_dump_file_source_settings);
        gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
        gd.exclude = true;
        gd.verticalIndent = 12;
        grpDump.setLayoutData(gd);
        grpDump.setLayout(new GridLayout(2, false));
        grpDump.setVisible(false);

        Label l = new Label(grpDump, SWT.NONE);
        l.setText(Messages.path_to_db_schema_dump);
        gd = new GridData();
        gd.horizontalSpan = 2;
        l.setLayoutData(gd);

        txtDumpPath = new Text(grpDump, SWT.BORDER);
        txtDumpPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDumpPath.addListener(SWT.Modify, this);

        Button btnBrowseDump = new Button(grpDump, SWT.PUSH);
        btnBrowseDump.setText(Messages.browse);
        btnBrowseDump.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell());
                String filename = dialog.open();
                if (filename != null) {
                    txtDumpPath.setText(filename);
                }
            }
        });

        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        String errMsg = null;
        if (radioDump.getSelection()
                && (txtDumpPath.getText().isEmpty()
                        || !new File(txtDumpPath.getText()).isFile())) {
            errMsg = Messages.select_readable_db_dump_file;
        }

        setErrorMessage(errMsg);
        return errMsg == null;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}