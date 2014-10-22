package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Set;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;

public class NewProjWizard extends Wizard 
        implements IPageChangingListener, IExecutableExtension, INewWizard {

    private PageRepo pageRepo;
    private PageDb pageDb;
    private PageMisc pageMisc;

    private final IPreferenceStore mainPrefStore;

    private PgDbProject props;
    private IConfigurationElement config;
    private IWorkbench workbench;
    
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
        pageRepo = new PageRepo(Messages.newProjWizard_repository_settings, mainPrefStore);
        addPage(pageRepo);
        pageDb = new PageDb(Messages.newProjWizard_schema_source_settings, mainPrefStore);
        addPage(pageDb);
        pageMisc = new PageMisc(Messages.miscellaneous);
        addPage(pageMisc);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        ((WizardDialog) getContainer()).addPageChangingListener(this);
        IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
        helpSystem.setHelp(pageRepo.getControl(), HELP.NEW_WIZARD);
        helpSystem.setHelp(pageDb.getControl(), HELP.NEW_WIZARD_INIT);
        helpSystem.setHelp(pageMisc.getControl(), HELP.NEW_WIZARD_MISC);
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        if(page == pageRepo && !pageRepo.isDoInit()) {
            return pageMisc;
        }
        return super.getNextPage(page);
    }

    @Override
    public void handlePageChanging(PageChangingEvent event) {
        if (event.getCurrentPage() == pageRepo && event.getTargetPage() == pageDb) {
            boolean isInit = pageRepo.isDoInit();
            
            if (isInit && pageDb.isSourceNone()) {
                pageDb.setSourceDb();
            }
            
            pageDb.setSourceNoneEnabled(!isInit);
        } else if (event.getCurrentPage() == pageRepo && event.getTargetPage() == pageMisc){
            File sub = new File (pageRepo.getProjectRootPath()); 

            if (!new File(sub, ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
                MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
                mb.setMessage(Messages.missing_marker_file_in_working_directory 
                        + sub + System.lineSeparator()
                        + Messages.NewProjWizard_demand_init_project);
                mb.setText(Messages.newProjWizard_bad_work_dir);
                mb.open();
                event.doit = false;
            }
        }
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageRepo && pageRepo.isDoInit()) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            props = PgDbProject.getProjFromFile(pageRepo.getProjectName(),
                    pageRepo.getProjectRootPath());

            Log.log(Log.LOG_INFO, "Creating new project properties"); //$NON-NLS-1$

            fillProjProps();

            if (pageRepo.isDoInit()) {
                try {
                    getContainer().run(false, false,
                            new InitProjectFromSource(mainPrefStore, props,
                                    pageDb.getDumpPath()));
                } catch (InvocationTargetException ex) {
                    props.deleteFromWorkspace();
                    ExceptionNotifier.showErrorDialog(
                            Messages.newProjWizard_error_in_initializing_repo_from_source,
                                    ex);
                    return false;
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    props.deleteFromWorkspace();
                    ExceptionNotifier.showErrorDialog(
                            Messages.newProjWizard_project_initializer_thread_interrupted,
                                    ex);
                    return false;
                }
            } else if (!pageRepo.isDoInit()
                    && !new File(pageRepo.getProjectRootPath(),
                            ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()) {
                props.deleteFromWorkspace();
                MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
                mb.setMessage(Messages.missing_marker_file_in_working_directory
                        + pageRepo.getProjectRootPath()
                        + Messages.create_marker_file_named
                        + ApgdiffConsts.FILENAME_WORKING_DIR_MARKER
                        + Messages.manually_and_try_again);
                mb.setText(Messages.newProjWizard_bad_work_dir);
                mb.open();
                return false;
            }
            
            BasicNewProjectResourceWizard.updatePerspective(config);
            BasicNewResourceWizard.selectAndReveal(props.getProject(), 
                    workbench.getActiveWorkbenchWindow());

            props.openProject();
            try {
                PgDbProject.addNatureToProject(props.getProject());
                props.getPrefs().flush();
            } catch (BackingStoreException e) {
                ExceptionNotifier.showErrorDialog(
                        Messages.NewProjWizard_error_saving_projprefs, e);
                return false;
            } catch (CoreException e) {
                ExceptionNotifier.showErrorDialog(
                        Messages.NewProjWizard_error_adding_nature, e);
                return false;
            }
            OpenEditor.openEditor(PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage(),
                    props.getProject());
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.showErrorDialog(Messages.NewProjWizard_error_creating_project, e);
            return false;
        }
        return true;
    }

    void setPageContentFromOldSettings(String oldPrefs) throws IOException {
        PreferenceStore prefs = new PreferenceStore(oldPrefs);
        prefs.load();
        pageMisc.setEncoding(prefs.getString(PROJ_PREF.ENCODING));
        pageRepo.setProjectRootPath(Paths.get(prefs.getString(PROJ_PREF.REPO_ROOT_PATH), 
                prefs.getString(PROJ_PREF.REPO_SUBDIR_PATH)).toString());
        pageDb.setDbName(prefs.getString(PROJ_PREF.DB_NAME));
        pageDb.setDbUser(prefs.getString(PROJ_PREF.DB_USER));
        pageDb.setDbPass(prefs.getString(PROJ_PREF.DB_PASS));
        pageDb.setDbHost(prefs.getString(PROJ_PREF.DB_HOST));
        pageDb.setDbPort(prefs.getInt(PROJ_PREF.DB_PORT));
        pageDb.setSource(prefs.getString(PROJ_PREF.SOURCE));
    }

    private void fillProjProps() {
        IEclipsePreferences newPrefs = props.getPrefs();
        setDbSource(newPrefs);
        newPrefs.put(PROJ_PREF.ENCODING, pageMisc.getEncoding());
        newPrefs.put(PROJ_PREF.REPO_ROOT_PATH, pageRepo.getProjectRootPath());
        newPrefs.put(PROJ_PREF.DB_NAME, pageDb.getDbName());
        newPrefs.put(PROJ_PREF.DB_USER, pageDb.getDbUser());
        newPrefs.put(PROJ_PREF.DB_PASS, pageDb.getDbPass());
        newPrefs.put(PROJ_PREF.DB_HOST, pageDb.getDbHost());
        newPrefs.putInt(PROJ_PREF.DB_PORT, pageDb.getDbPort());
    }

    private void setDbSource(IEclipsePreferences newPrefs) {
        String src;
        if (pageDb.isSourceDb()) {
            src = PROJ_PREF.SOURCE_TYPE_DB;
        } else if (pageDb.isSourceDump()) {
            src = PROJ_PREF.SOURCE_TYPE_DUMP;
        } else if (pageDb.isSourceNone()) {
            src = PROJ_PREF.SOURCE_TYPE_NONE;
        } else {
            ExceptionNotifier.showErrorDialog(
                    Messages.newProjWizard_no_schema_source_selected, null);
            return;
        }
        newPrefs.put(PROJ_PREF.SOURCE, src);
    }

    @Override
    public void setInitializationData(IConfigurationElement config,
            String propertyName, Object data) throws CoreException {
        this.config = config;        
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
    }    
}

class PageRepo extends WizardPage implements Listener {

    private Composite container;
    private Text txtProjectRoot, txtProjectName, txtOldProjFile;
    private Label lblProjRoot, lblProjectFile;
    private Button btnBrowseOldFile, btnDoInit;
    private CLabel lblWarnInit;
    private LocalResourceManager lrm;
    
    private final IPreferenceStore mainPrefStore;

    public String getOldProjFilePath() {
        return txtOldProjFile.getText();
    }
    
    public String getProjectRootPath() {
        return txtProjectRoot.getText();
    }
    
    void setProjectRootPath(String value) {
        txtProjectRoot.setText(value);
    }
    
    public String getProjectName() {
        return txtProjectName.getText().trim();
    }
    
    PageRepo(String pageName, IPreferenceStore mainPrefStore) {
        super(pageName, pageName, null);
        this.mainPrefStore = mainPrefStore;
    }
    
    @Override
    public void createControl(final Composite parent) {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                parent);
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        
        Button btnImportOldProjPrefs = new Button(container, SWT.CHECK);
        btnImportOldProjPrefs.setText(Messages.NewProjWizard_import_old_proj);
        GridData gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        btnImportOldProjPrefs.setLayoutData(gd);
        btnImportOldProjPrefs.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean importOldProjPrefs = ((Button)e.widget).getSelection();
                btnBrowseOldFile.setEnabled(importOldProjPrefs);
                txtOldProjFile.setEnabled(importOldProjPrefs);
                txtOldProjFile.setText(""); //$NON-NLS-1$
            }
        });
        
        Label lblOldProjFile = new Label(container, SWT.NONE);
        lblOldProjFile.setText(Messages.NewProjWizard_select_old_proj);
        gd = new GridData();
        gd.horizontalSpan = 2;
        lblOldProjFile.setLayoutData(gd);
        
        txtOldProjFile = new Text(container, SWT.BORDER);
        txtOldProjFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtOldProjFile.addListener(SWT.Modify, this);
        txtOldProjFile.setEnabled(false);
        
        btnBrowseOldFile = new Button(container, SWT.PUSH);
        btnBrowseOldFile.setText(Messages.browse);
        btnBrowseOldFile.setEnabled(false);
        btnBrowseOldFile.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell());
                dialog.setText(Messages.loadProj_open_project);
                dialog.setOverwrite(false);
                dialog.setFilterExtensions(new String[] { "*.project", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterPath(mainPrefStore.getString(PREF.LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtOldProjFile.setText(path);
                    try {
                        ((NewProjWizard)getWizard()).setPageContentFromOldSettings(path);
                    } catch (IOException e1) {
                        ExceptionNotifier.showErrorDialog(
                                Messages.NewProjWizard_error_loading_old_proj, e1);
                    }
                    PreferenceInitializer.savePreference(mainPrefStore,
                            PREF.LAST_OPENED_LOCATION, new File(path).getParent());
                }
            }
        });
        
        lblProjectFile = new Label(container, SWT.NONE);
        lblProjectFile.setText(Messages.NewProjWizard_project_name);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblProjectFile.setLayoutData(gd);
        
        txtProjectName = new Text(container, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        txtProjectName.setLayoutData(gd);
        txtProjectName.addListener(SWT.Modify, this);

        lblProjRoot = new Label(container, SWT.NONE);
        lblProjRoot.setText(Messages.newProjWizard_select_git_repository_root_directory);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblProjRoot.setLayoutData(gd);

        txtProjectRoot = new Text(container, SWT.BORDER);
        txtProjectRoot.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjectRoot.addListener(SWT.Modify, this);

        Button btnBrowseRepo = new Button(container, SWT.PUSH);
        btnBrowseRepo.setText(Messages.browse);
        btnBrowseRepo.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(container.getShell());
                dialog.setFilterPath(mainPrefStore.getString(PREF.LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtProjectRoot.setText(path);
                    PreferenceInitializer.savePreference(mainPrefStore,
                            PREF.LAST_OPENED_LOCATION, path);
                }
            }
        });
        
        gd = new GridData();
        gd.horizontalSpan = 2;
        btnDoInit = new Button(container, SWT.CHECK);
        btnDoInit.setText(Messages.newProjWizard_init_project_subdir_from_schema_source);
        btnDoInit.setLayoutData(gd);
        
        btnDoInit.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                GridData gd = (GridData) lblWarnInit.getLayoutData();

                gd.exclude = !btnDoInit.getSelection();
                lblWarnInit.setVisible(btnDoInit.getSelection());

                getShell().pack();
                container.layout(false);
            }
        });
        btnDoInit.addListener(SWT.Selection, this);
        
        lblWarnInit = new CLabel(container, SWT.NONE);
        lblWarnInit.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(FILE.ICONWARNING))));
        lblWarnInit.setText(Messages.warning
                        + Messages.newProjWizard_this_will_delete_contents_and_recreate_them);        
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnInit.setLayoutData(gd);
        lblWarnInit.setVisible(false);
        
        setControl(container);
    }
    
    public boolean isDoInit() {
        return btnDoInit.getSelection();
    }

    @Override
    public boolean isPageComplete() {
        String errMsg = checkFields();
        
        setErrorMessage(errMsg);
        return errMsg == null;
    }
    
    private String checkFields() {
        if (getProjectName().isEmpty()) {
            return Messages.NewProjWizard_enter_project_name;
        }
        
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IStatus nameStatus = workspace.validateName(getProjectName(), IResource.PROJECT); 
        if (!nameStatus.isOK()) {
            return nameStatus.getMessage();
        }
        
        if (workspace.getRoot().getProject(getProjectName()).exists()) {
            return Messages.newProjWizard_project_with_that_name_already_exist;
        }
        
        if (getProjectRootPath().isEmpty()
                || !new File(getProjectRootPath()).isDirectory()) {
            return Messages.newProjWizard_select_repo_root_directory;
        }
        
        IProject existingProj = workspace.getRoot().getProject(getProjectName());
        URI projPath = new File(getProjectRootPath()).toURI();
        if (existingProj != null) {
            URI existingProjPath = existingProj.getLocationURI();
            if (existingProjPath != null && 
                    URIUtil.equals(existingProjPath, projPath)) {
                return Messages.newProjWizard_location_is_the_current_location;
            }
        }
        
        IStatus locationStatus = 
                workspace.validateProjectLocationURI(existingProj, projPath);
        if (!locationStatus.isOK()) {
            return locationStatus.getMessage();
        }
        
        return null;
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

    private Button radioDb, radioDump, radioNone;

    private DbPicker grpDb;
    private Group grpDump;

    private Label lblNoSource;

    private Text txtDumpPath;

    public boolean isSourceDb() {
        return radioDb.getSelection();
    }

    void setSourceDb() {
        radioDump.setSelection(false);
        radioNone.setSelection(false);
        radioDb.setSelection(true);
        radioDb.notifyListeners(SWT.Selection, new Event());
    }
    
    private void setSourceDump() {
        radioDump.setSelection(true);
        radioNone.setSelection(false);
        radioDb.setSelection(false);
        radioDump.notifyListeners(SWT.Selection, new Event());
    }
    
    private void setSourceNone() {
        radioDump.setSelection(false);
        radioNone.setSelection(true);
        radioDb.setSelection(false);
        radioNone.notifyListeners(SWT.Selection, new Event());
    }
    
    void setSource(String value) {
        switch (value) {
        case PROJ_PREF.SOURCE_TYPE_DB:
            setSourceDb();
            break;
        case PROJ_PREF.SOURCE_TYPE_DUMP:
            setSourceDump();
            break;
        default:
            setSourceNone();
            break;
        }
    }

    public boolean isSourceDump() {
        return radioDump.getSelection();
    }

    public boolean isSourceNone() {
        return radioNone.getSelection();
    }

    void setSourceNoneEnabled(boolean enabled) {
        radioNone.setEnabled(enabled);
    }

    public String getDbName() {
        return grpDb.txtDbName.getText();
    }
    
    void setDbName(String value) {
        grpDb.txtDbName.setText(value);
    }

    public String getDbUser() {
        return grpDb.txtDbUser.getText();
    }
    
    void setDbUser(String value) {
        grpDb.txtDbUser.setText(value);
    }

    public String getDbPass() {
        return grpDb.txtDbPass.getText();
    }
    
    void setDbPass(String value) {
        grpDb.txtDbPass.setText(value);
    }

    public String getDbHost() {
        return grpDb.txtDbHost.getText();
    }
    
    void setDbHost(String value) {
        grpDb.txtDbHost.setText(value);
    }

    public int getDbPort() {
        try {
            return Integer.parseInt(grpDb.txtDbPort.getText());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    void setDbPort(int value) {
        grpDb.txtDbPort.setText(Integer.valueOf(value).toString());
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

        radioDb = new Button(radioGrp, SWT.RADIO);
        radioDb.setText(Messages.db);

        radioDb.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (radioDb.getSelection()) {
                    grpDump.setVisible(false);
                    lblNoSource.setVisible(false);
                    grpDb.setVisible(true);

                    ((GridData) grpDump.getLayoutData()).exclude = true;
                    ((GridData) lblNoSource.getLayoutData()).exclude = true;
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
                    lblNoSource.setVisible(false);
                    grpDump.setVisible(true);

                    ((GridData) grpDb.getLayoutData()).exclude = true;
                    ((GridData) lblNoSource.getLayoutData()).exclude = true;
                    ((GridData) grpDump.getLayoutData()).exclude = false;

                    container.layout(false);
                }
            }
        });
        radioDb.addListener(SWT.Selection, this);

        radioNone = new Button(radioGrp, SWT.RADIO);
        radioNone.setText(Messages.none);
        radioNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                grpDb.setVisible(false);
                grpDump.setVisible(false);
                lblNoSource.setVisible(true);

                ((GridData) grpDb.getLayoutData()).exclude = true;
                ((GridData) grpDump.getLayoutData()).exclude = true;
                ((GridData) lblNoSource.getLayoutData()).exclude = false;

                container.layout(false);
            }
        });
        radioNone.addListener(SWT.Selection, this);
        radioNone.setSelection(true);

        grpDb = new DbPicker(container, SWT.NONE, mainPrefs);
        grpDb.setText(Messages.newProjWizard_db_source_settings);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
        gd.exclude = true;
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);
        grpDb.setVisible(false);

        grpDb.txtDbPort.addListener(SWT.Modify, this);

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

        lblNoSource = new Label(container, SWT.NONE);
        lblNoSource.setText(Messages.newProjWizard_no_schema_source_selected);

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

class PageMisc extends WizardPage {

    private static final String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$
    private Combo cmbEncoding;

    public String getEncoding() {
        return cmbEncoding.getText();
    }
    
    void setEncoding(String value) {
        cmbEncoding.select(cmbEncoding.indexOf(value) == -1 ? 
                cmbEncoding.indexOf(DEFAULT_ENCODING) : cmbEncoding.indexOf(value));
    }

    PageMisc(String pageName) {
        super(pageName, pageName, null);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));

        new Label(container, SWT.NONE)
                .setText(Messages.newProjWizard_project_encoding);

        cmbEncoding = new Combo(container, SWT.BORDER | SWT.DROP_DOWN
                | SWT.READ_ONLY);
        Set<String> charsets = Charset.availableCharsets().keySet();
        cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
        cmbEncoding.select(cmbEncoding.indexOf(DEFAULT_ENCODING)); 

        setControl(container);
    }
}
