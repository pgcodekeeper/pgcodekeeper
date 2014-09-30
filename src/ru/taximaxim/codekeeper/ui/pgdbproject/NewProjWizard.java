package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewProjWizard extends BasicNewProjectResourceWizard implements IPageChangingListener, INewWizard,
IExecutableExtension {

    private PageRepo pageRepo;
    private PageSubdir pageSubdir;
    private PageDb pageDb;
    private PageMisc pageMisc;

    private final IPreferenceStore mainPrefStore;
    protected IConfigurationElement fConfigElement;

    private PgDbProject props;
    
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
        pageSubdir = new PageSubdir(Messages.newProjWizard_workdirectory_settings);
        addPage(pageSubdir);
        pageDb = new PageDb(Messages.newProjWizard_schema_source_settings, mainPrefStore);
        addPage(pageDb);
        pageMisc = new PageMisc(Messages.miscellaneous);
        addPage(pageMisc);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        ((WizardDialog) getContainer()).addPageChangingListener(this);
    }

    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        if(page == pageSubdir && !pageSubdir.isDoInit()) {
            return pageMisc;
        }
        return super.getNextPage(page);
    }

    @Override
    public void handlePageChanging(PageChangingEvent event) {
        if (event.getCurrentPage() == pageSubdir
                && event.getTargetPage() == pageDb) {
            boolean isInit = pageSubdir.isDoInit();
            
            if (isInit && pageDb.isSourceNone()) {
                pageDb.setSourceDb();
            }
            
            pageDb.setSourceNoneEnabled(!isInit);
        } else if (event.getCurrentPage() == pageRepo
                && event.getTargetPage() == pageSubdir) {
            pageSubdir.setRepoRoot(pageRepo.getProjectRootPath());
            pageSubdir.setProjectFile(pageRepo.getProjectName());
            
        }else if (event.getCurrentPage() == pageSubdir && event.getTargetPage() == pageMisc){
            File sub = new File (pageSubdir.getRepoSubdir()); 

            if (!new File(sub, ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
                new MessageDialog(getShell(), Messages.newProjWizard_bad_work_dir, null, 
                        Messages.missing_marker_file_in_working_directory + sub + " " +
                        "Initialize project from DB or dump file", MessageDialog.WARNING, 
                        new String []{"Ok"}, 0).open(); //$NON-NLS-1$
                event.doit = false;
            }
        }
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == pageSubdir && pageSubdir.isDoInit()) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        props = PgDbProject
                .getProgFromFile(pageRepo.getProjectName(), 
                        pageRepo.getProjectRootPath());
        
        Log.log(Log.LOG_INFO, "Creating new project properties at " //$NON-NLS-1$
                + props.getPathToProject());
        
        fillProjProps();

        if (pageSubdir.isDoInit()){
            try {
                getContainer().run(false, false, 
                        new InitProjectFromSource(mainPrefStore, props, pageDb.getDumpPath()));
            } catch (InvocationTargetException ex) {
                props.deleteFromWorkspace();
                throw new IllegalStateException(
                        Messages.newProjWizard_error_in_initializing_repo_from_source, ex);
            } catch (InterruptedException ex) {
                // assume run() was called as non cancelable
                props.deleteFromWorkspace();
                throw new IllegalStateException(
                        Messages.newProjWizard_project_initializer_thread_interrupted, ex);
            }
        } else if (!pageSubdir.isDoInit() && !new File(pageSubdir.getRepoSubdir(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
            new MessageDialog(getShell(), Messages.newProjWizard_bad_work_dir, null, 
                    Messages.missing_marker_file_in_working_directory + pageSubdir.getRepoSubdir() + 
                    Messages.create_marker_file_named + ApgdiffConsts.FILENAME_WORKING_DIR_MARKER +
                    Messages.manually_and_try_again, MessageDialog.WARNING, 
                    new String []{"Ok"}, 0).open(); //$NON-NLS-1$
            return false;
        }
        BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
        selectAndReveal(props.getProject());
        
        props.openProject();
        try {
            PgDbProject.addNatureToProject(props.getProject());
            props.getPrefs().flush();
        } catch (BackingStoreException e) {
            Log.log(Log.LOG_ERROR, "Failed to save project preferences", e);
        } catch (CoreException e) {
            Log.log(Log.LOG_ERROR, "Failed to add nature to project", e);
        }
        OpenEditor.openEditor(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage(), props.getProject());
        return true;
    }

    private void fillProjProps() {
        if (pageRepo.getOldProjFilePath().isEmpty()) {
            copyPref(null, props.getPrefs());
        } else {
            copyPref(new PreferenceStore(pageRepo.getOldProjFilePath()), 
                    props.getPrefs());
        }
    }

    private void copyPref(PreferenceStore oldPrefs,
            IEclipsePreferences newPrefs) {
        try {
            if (oldPrefs != null) {
                oldPrefs.load();
            }
        } catch (IOException e) {
            Log.log(Log.LOG_ERROR, "Cannot load old properties. Using defaults", e);
        }
        setDbSource(newPrefs, oldPrefs, PROJ_PREF.SOURCE);
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.ENCODING, pageMisc.getEncoding());
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.REPO_ROOT_PATH, 
                pageSubdir.getRepoSubdir());
        
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.DB_NAME, pageDb.getDbName());
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.DB_USER, pageDb.getDbUser());
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.DB_PASS, pageDb.getDbPass());
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.DB_HOST, pageDb.getDbHost());
        setNotEmptyString(newPrefs, oldPrefs, PROJ_PREF.DB_HOST, pageDb.getDbHost());
        newPrefs.putInt(PROJ_PREF.DB_PORT, oldPrefs == null ? pageDb.getDbPort() : 
            oldPrefs.getInt(PROJ_PREF.DB_PORT));
    }
    
    private void setNotEmptyString(IEclipsePreferences newPrefs,
            PreferenceStore oldPrefs, String prefName, String defValue) {
        String value;
        if (oldPrefs != null && !oldPrefs.getString(prefName).isEmpty()) {
            value = oldPrefs.getString(prefName);
        } else {
            value = defValue;
        }
        newPrefs.put(prefName, value);
    }

    private void setDbSource(IEclipsePreferences newPrefs,
            PreferenceStore oldPrefs, String prefName) {
        String src;
        if (oldPrefs == null || (src = oldPrefs.getString(prefName)).isEmpty() ||
                src.equals(PROJ_PREF.SOURCE_TYPE_NONE)) {
            if (pageDb.isSourceDb()) {
                src = PROJ_PREF.SOURCE_TYPE_DB;
            } else if (pageDb.isSourceDump()) {
                src = PROJ_PREF.SOURCE_TYPE_DUMP;
            } else if (pageDb.isSourceNone()) {
                src = PROJ_PREF.SOURCE_TYPE_NONE;
            } else {
                throw new IllegalStateException(Messages.newProjWizard_no_schema_source_selected);
            }
        }
        newPrefs.put(prefName, src);
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        super.init(workbench, selection);
    }

    @Override
    public void setInitializationData(IConfigurationElement cfig,
            String propertyName, Object data) {
        super.setInitializationData(cfig, propertyName, data);
        fConfigElement = cfig;
    }
}

class PageRepo extends WizardPage implements Listener {

    private Composite container;
    private Text txtProjectRoot, txtProjectName, txtOldProgFile;
    private Label lblProjRoot, lblProjectFile;
    private Button btnBrowseOldFile;
    
    private final IPreferenceStore mainPrefStore;

    public String getOldProjFilePath() {
        return txtOldProgFile.getText();
    }
    
    public String getProjectRootPath() {
        return txtProjectRoot.getText();
    }
    
    public String getProjectName() {
        return txtProjectName.getText();
    }
    
    PageRepo(String pageName, IPreferenceStore mainPrefStore) {
        super(pageName, pageName, null);
        this.mainPrefStore = mainPrefStore;
    }
    
    @Override
    public void createControl(final Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        
        lblProjectFile = new Label(container, SWT.NONE);
        lblProjectFile.setText("Project Name: ");
        GridData gd = new GridData();
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
                DirectoryDialog dialog = new DirectoryDialog(container
                        .getShell());
                dialog.setFilterPath(mainPrefStore.getString(PREF.LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtProjectRoot.setText(path);
                    AddonPrefLoader.savePreference(mainPrefStore, PREF.LAST_OPENED_LOCATION, path);
                }
            }
        });
        
        Button btnImportOldProjPrefs = new Button(container, SWT.CHECK);
        btnImportOldProjPrefs.setText("Import settings form old project file");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        btnImportOldProjPrefs.setLayoutData(gd);
        btnImportOldProjPrefs.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean importOldProjPrefs = ((Button)e.widget).getSelection();
                btnBrowseOldFile.setEnabled(importOldProjPrefs);
                txtOldProgFile.setEnabled(importOldProjPrefs);
                txtOldProgFile.setText("");
            }
        });
        
        Label lblOldProjFile = new Label(container, SWT.NONE);
        lblOldProjFile.setText("Select old project file: ");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblOldProjFile.setLayoutData(gd);
        
        txtOldProgFile = new Text(container, SWT.BORDER);
        txtOldProgFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtOldProgFile.addListener(SWT.Modify, this);
        txtOldProgFile.setEnabled(false);
        
        btnBrowseOldFile = new Button(container, SWT.PUSH);
        btnBrowseOldFile.setText(Messages.browse);
        btnBrowseOldFile.setEnabled(false);
        btnBrowseOldFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container
                        .getShell());
                dialog.setText(Messages.loadProj_open_project);
                dialog.setOverwrite(false);
                dialog.setFilterExtensions(new String[] { "*.project", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterPath(mainPrefStore.getString(PREF.LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtOldProgFile.setText(path);
                    AddonPrefLoader.savePreference(mainPrefStore, PREF.LAST_OPENED_LOCATION, path);
                }
            }
        });
        
        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        String errMsg = null;
        if (getProjectRootPath().isEmpty()
                || !new File(getProjectRootPath()).isDirectory()) {
            errMsg = Messages.newProjWizard_select_repo_root_directory;
        } else if (getProjectName().isEmpty()) {
            errMsg = "Input project name";
        } else if (new File(getProjectRootPath()).toPath().getNameCount() == 0) {
            errMsg = Messages.newProjWizard_select_project_directory_demand;
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

class PageSubdir extends WizardPage implements Listener {

    private LocalResourceManager lrm;
    
    private Button btnDoInit;
    private Composite container;
    private CLabel lblWarnInit;
    private Text txtRepoSubdir;
    private Label lblRepoSubdir;
    
    private String repoRoot;

    private String projectFile;
    
    public String getRepoSubdir() {
        return txtRepoSubdir.getText();
    }

    public void setProjectFile(String projectFile) {
       this.projectFile = projectFile;
    }

    public void setRepoRoot(String repoRoot) {
        this.repoRoot = repoRoot;
        this.txtRepoSubdir.setText(repoRoot);
    }
    
    PageSubdir(String pageName) {
        super(pageName, pageName, null);
    }
    
    @Override
    public void createControl(Composite parent) {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                parent);
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        GridData gd = new GridData();
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
        
        lblRepoSubdir = new Label(container, SWT.NONE);
        lblRepoSubdir.setText(Messages.newProjWizard_select_a_dir_inside_the_repo);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblRepoSubdir.setLayoutData(gd);

        txtRepoSubdir = new Text(container, SWT.BORDER);
        txtRepoSubdir.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        txtRepoSubdir.addListener(SWT.Modify, this);
        Button btnBrowseProj = new Button(container, SWT.PUSH);
        btnBrowseProj.setText(Messages.browse);
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(container
                        .getShell());
                dialog.setFilterPath(repoRoot);
                String path = dialog.open();
                if (path != null) {
                    txtRepoSubdir.setText(path);
                }
            }
        });
        setControl(container);
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
    
    public boolean isDoInit() {
        return btnDoInit.getSelection();
    }
    
    @Override
    public boolean isPageComplete() {
        String repoSubdir = txtRepoSubdir.getText();
        String errMsg = null;
        
        if (repoSubdir.isEmpty() || !new File(repoSubdir).exists()
                || !new File(repoSubdir).isDirectory() 
                || !Paths.get(repoSubdir).startsWith(Paths.get(repoRoot))) {
            errMsg = Messages.newProjWizard_select_correct_subdir_of_the_git_repo;
        }else if (isDoInit() && Paths.get(projectFile).startsWith(getRepoSubdir())){
            errMsg = Messages.newProjWizard_project_fiel + projectFile 
                    + Messages.newProjWizard_cannt_be_saved_in_working;
        }
        
        setErrorMessage(errMsg);
        return errMsg == null;
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

    public void setSourceDb() {
        radioDump.setSelection(false);
        radioNone.setSelection(false);
        radioDb.setSelection(true);
        radioDb.notifyListeners(SWT.Selection, new Event());
    }

    public boolean isSourceDump() {
        return radioDump.getSelection();
    }

    public boolean isSourceNone() {
        return radioNone.getSelection();
    }

    public void setSourceNoneEnabled(boolean enabled) {
        radioNone.setEnabled(enabled);
    }

    public String getDbName() {
        return grpDb.txtDbName.getText();
    }

    public String getDbUser() {
        return grpDb.txtDbUser.getText();
    }

    public String getDbPass() {
        return grpDb.txtDbPass.getText();
    }

    public String getDbHost() {
        return grpDb.txtDbHost.getText();
    }

    public int getDbPort() {
        try {
            return Integer.parseInt(grpDb.txtDbPort.getText());
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
        } else if (radioDb.getSelection()
                && !grpDb.txtDbPort.getText().isEmpty()) {
            try {
                Integer.parseInt(grpDb.txtDbPort.getText());
            } catch (NumberFormatException ex) {
                errMsg = Messages.port_must_be_a_number;
            }
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

    private Combo cmbEncoding;

    public String getEncoding() {
        return cmbEncoding.getText();
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
        cmbEncoding.select(cmbEncoding.indexOf("UTF-8")); //$NON-NLS-1$

        setControl(container);
    }
}
