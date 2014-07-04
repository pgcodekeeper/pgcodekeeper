package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class NewProjWizard extends Wizard implements IPageChangingListener {

    private PageRepo pageRepo;
    private PageSubdir pageSubdir;
    private PageDb pageDb;
    private PageMisc pageMisc;

    final IPreferenceStore mainPrefStore;

    private PgDbProject props;

    public NewProjWizard(IPreferenceStore mainPrefStore) {
        setWindowTitle(Messages.newProjWizard_new_pg_db_project);
        setNeedsProgressMonitor(true);
        this.mainPrefStore = mainPrefStore;
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
            pageSubdir.setRepoRoot(pageRepo.getRepoRootPath());
            pageSubdir.setProjectFile(pageRepo.getProjectFile());
            
            if (JGitExec.isGitRepo(pageRepo.getRepoRootPath())){
                return;
            }
            
            if (MessageDialog.openQuestion(getShell(), Messages.newProjWizard_selected_directory_is_empty,
                            Messages.newProjWizard_target_dir_isnt_git_repository_root_dir
                            + pageRepo.getRepoUrl()
                            + Messages.newProjWizard_to_selected_dir_now)) {

                final String repoUrl = pageRepo.getRepoUrl();
                final String repoUser = pageRepo.getRepoUser();
                final String repoPass = pageRepo.getRepoPass();
                final String repoPath = pageRepo.getRepoRootPath();
                
                IRunnableWithProgress cloneRunnable = new IRunnableWithProgress() {
                    
                    @Override
                    public void run(IProgressMonitor monitor)
                            throws InvocationTargetException,
                            InterruptedException {
                        SubMonitor pm = SubMonitor.convert(monitor,
                                Messages.newProjWizard_cloning_get_repo, 2);
                        final JGitExec git = new JGitExec(repoUrl,repoUser, repoPass,
                                mainPrefStore.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
                        pm.worked(1);
                        try {
                            git.repoCheckOut(new File(repoPath));
                            AddonPrefLoader.savePreference(mainPrefStore, 
                                    UIConsts.PREF_LAST_REPO, repoUrl);
                        } catch (IOException e) {
                            throw new InvocationTargetException(e, Messages.newProjWizard_error_cloning_repository);
                        }
                        monitor.done();
                    }
                };
                
                try {
                    new ProgressMonitorDialog(pageRepo.getShell()).run(true,
                            false, cloneRunnable);
                } catch (InvocationTargetException ex) {
                    event.doit = false;
                    throw new IllegalStateException(Messages.newProjWizard_cloning_wasnt_successful, ex);
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    event.doit = false;
                    throw new IllegalStateException(Messages.newProjWizard_cloning_thread_interrupted, ex);
                }
            } else {
                // didn't clone the repo; can't proceed without it
                event.doit = false;
            }
        }else if (event.getCurrentPage() == pageSubdir && event.getTargetPage() == pageMisc){
            File sub = new File (pageSubdir.getRepoSubdir()); 

            if (sub.list().length > 0 && !new File(sub, ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
                if (sub.list().length == 1 && sub.list()[0].equals(".git")){ //$NON-NLS-1$
                    return;
                }
                new MessageDialog(getShell(), Messages.newProjWizard_bad_work_dir, null, 
                        Messages.missing_marker_file_in_working_directory + sub + 
                        Messages.create_marker_file_named + ApgdiffConsts.FILENAME_WORKING_DIR_MARKER +
                        Messages.manually_and_try_again, MessageDialog.WARNING, 
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
        props = new PgDbProject(pageRepo.getProjectFile());

        Log.log(Log.LOG_INFO, "Creating new project properties at " //$NON-NLS-1$
                + props.getProjectFile());

        props.setValue(UIConsts.PROJ_PREF_ENCODING, pageMisc.getEncoding());

        props.setValue(UIConsts.PROJ_PREF_REPO_ROOT_PATH, pageRepo.getRepoRootPath());

        props.setValue(UIConsts.PROJ_PREF_REPO_SUBDIR_PATH,
                        Paths.get(pageRepo.getRepoRootPath())
                        .relativize(Paths.get(pageSubdir.getRepoSubdir()))
                        .toString());

        String src;
        if (pageDb.isSourceDb()) {
            src = UIConsts.PROJ_SOURCE_TYPE_DB;
        } else if (pageDb.isSourceDump()) {
            src = UIConsts.PROJ_SOURCE_TYPE_DUMP;
        } else if (pageDb.isSourceNone()) {
            src = UIConsts.PROJ_SOURCE_TYPE_NONE;
        } else {
            throw new IllegalStateException(Messages.newProjWizard_no_schema_source_selected);
        }
        props.setValue(UIConsts.PROJ_PREF_SOURCE, src);

        props.setValue(UIConsts.PROJ_PREF_DB_NAME, pageDb.getDbName());
        props.setValue(UIConsts.PROJ_PREF_DB_USER, pageDb.getDbUser());
        props.setValue(UIConsts.PROJ_PREF_DB_PASS, pageDb.getDbPass());
        props.setValue(UIConsts.PROJ_PREF_DB_HOST, pageDb.getDbHost());
        props.setValue(UIConsts.PROJ_PREF_DB_PORT, pageDb.getDbPort());

        props.setValue(UIConsts.PROJ_PREF_REPO_TYPE, pageRepo.getRepoType());
        props.setValue(UIConsts.PROJ_PREF_REPO_URL, pageRepo.getRepoUrl());
        props.setValue(UIConsts.PROJ_PREF_REPO_USER, pageRepo.getRepoUser());
        props.setValue(UIConsts.PROJ_PREF_REPO_PASS, pageRepo.getRepoPass());

        try {
            props.save();
        } catch (IOException ex) {
            throw new IllegalStateException(
                    Messages.newProjWizard_error_while_saving_project_properties, ex);
        }

        if (pageSubdir.isDoInit()){
            try {
                getContainer().run(false, false, 
                        new InitProjectFromSource(mainPrefStore, props, pageDb.getDumpPath()));
            } catch (InvocationTargetException ex) {
                throw new IllegalStateException(
                        Messages.newProjWizard_error_in_initializing_repo_from_source, ex);
            } catch (InterruptedException ex) {
                // assume run() was called as non cancelable
                throw new IllegalStateException(
                        Messages.newProjWizard_project_initializer_thread_interrupted, ex);
            }
        } else if (!pageSubdir.isDoInit() && new File(pageSubdir.getRepoSubdir()).list().length == 0 ){
            try {
                // init empty db for further commits
                new ModelExporter(pageSubdir.getRepoSubdir(), new PgDatabase(),
                        props.getString(UIConsts.PROJ_PREF_ENCODING)).export();
                IRepoWorker repo = new JGitExec(props, 
                        mainPrefStore.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
                repo.repoRemoveMissingAddNew(new File(pageSubdir.getRepoSubdir()));
                repo.repoCommit(new File(pageSubdir.getRepoSubdir()), "empty working directory"); //$NON-NLS-1$
            } catch (IOException ex) {
                throw new IllegalStateException(Messages.newProjWizard_couldnt_create_empty_database_in
                            + new File(pageSubdir.getRepoSubdir()), ex);
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
        
        return true;
    }
}

class PageRepo extends WizardPage implements Listener {

    private Composite container;
    private Group grpRepo;
    private String repoTypeName;
    private Text txtRepoUrl, txtRepoUser, txtRepoPass, txtRepoRoot;
    private Label lblRepoUrl, lblRepoUser, lblRepoPass, lblRepoRoot;
    private Text txtProjectFile;
    private Label lblProjectFile;


    private LocalResourceManager lrm;
    
    private CLabel lblWarnPass;
    private final IPreferenceStore mainPrefStore;

    public String getRepoType() {
        return repoTypeName;
    }

    public String getRepoUrl() {
        return txtRepoUrl.getText();
    }

    public String getRepoUser() {
        return txtRepoUser.getText();
    }

    public String getRepoPass() {
        return txtRepoPass.getText();
    }

    public String getRepoRootPath() {
        return txtRepoRoot.getText();
    }
    
    public String getProjectFile() {
        return txtProjectFile.getText();
    }
    
    PageRepo(String pageName, IPreferenceStore mainPrefStore) {
        super(pageName, pageName, null);
        this.mainPrefStore = mainPrefStore;
    }
    
    private void redrawLabels() {
            if (JGitExec.PATTERN_HTTP_URL.matcher(txtRepoUrl.getText()).matches()){
                lblWarnPass
                .setText(Messages.warning
                        + Messages.providing_password_here_is_insecure + "\n" //$NON-NLS-1$
                        + Messages.this_password_will_show_up_in_logs
                        + Messages.consider_using_ssh_authentication_instead_use_git);
            }else if (JGitExec.PATTERN_FILE_URL.matcher(txtRepoUrl.getText()).matches()){
                lblWarnPass.setText(""); //$NON-NLS-1$
            }else {
                lblWarnPass.setText(Messages.make_sure_you_have_priv_and_public_keys
                        + Messages.filenames_entered_in_application_preferences);
            }
    }

    @Override
    public void createControl(final Composite parent) {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                parent);
        repoTypeName = UIConsts.PROJ_REPO_TYPE_GIT_NAME;
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        
        grpRepo = new Group(container, SWT.NONE);
        grpRepo.setText(repoTypeName + Messages.settings_lwhtitespace);
        grpRepo.setLayout(new GridLayout(2, false));
        grpRepo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

        lblRepoUrl = new Label(grpRepo, SWT.NONE);
        lblRepoUrl.setText(repoTypeName + Messages.repo_url);

        txtRepoUrl = new Text(grpRepo, SWT.BORDER);
        txtRepoUrl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtRepoUrl.setText(mainPrefStore.getString(UIConsts.PREF_LAST_REPO));
        txtRepoUrl.selectAll();
        txtRepoUrl.addListener(SWT.Modify, this);

        lblRepoUser = new Label(grpRepo, SWT.NONE);
        lblRepoUser.setText(repoTypeName + Messages.user_);

        txtRepoUser = new Text(grpRepo, SWT.BORDER);
        txtRepoUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        lblRepoPass = new Label(grpRepo, SWT.NONE);
        lblRepoPass.setText(repoTypeName + Messages.newProjWizard_password);

        txtRepoPass = new Text(grpRepo, SWT.BORDER | SWT.PASSWORD);
        txtRepoPass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtRepoPass.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData) lblWarnPass.getLayoutData();
                if ((txtRepoPass.getText().isEmpty() && !gd.exclude)
                        || (!txtRepoPass.getText().isEmpty() && gd.exclude)) {
                    gd.exclude = !gd.exclude;
                    lblWarnPass.setVisible(!lblWarnPass.getVisible());
                    container.layout(false);
                }
                if (!txtRepoUrl.getText().isEmpty() &&  
                        !JGitExec.PATTERN_HTTP_URL.matcher(txtRepoUrl.getText()).matches() && 
                        !JGitExec.PATTERN_FILE_URL.matcher(txtRepoUrl.getText()).matches()){
                    lblWarnPass.setVisible(true);
                    gd.exclude = false;
                    container.layout(true);
                }else if (!txtRepoPass.isEnabled()) {
                    lblWarnPass.setVisible(false);
                    gd.exclude = true;
                    container.layout(false);
                }
                getShell().pack();
            }
        });
        
        txtRepoUrl.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                if (txtRepoUrl.getText().isEmpty()) {
                    txtRepoUser.setEnabled(true);
                    txtRepoPass.setEnabled(true);
                    redrawLabels();
                    txtRepoPass.notifyListeners(SWT.Modify, new Event());                    
                } else if (JGitExec.PATTERN_HTTP_URL.matcher(
                        txtRepoUrl.getText()).matches()) {
                    txtRepoUser.setEnabled(true);
                    txtRepoPass.setEnabled(true);
                    redrawLabels();
                    txtRepoPass.notifyListeners(SWT.Modify, new Event());
                } else {
                    txtRepoUser.setEnabled(false);
                    txtRepoPass.setEnabled(false);
                    redrawLabels();
                    txtRepoPass.notifyListeners(SWT.Modify, new Event());
                }
            }
        });
        
        lblWarnPass = new CLabel(grpRepo, SWT.NONE);
        lblWarnPass.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(UIConsts.FILENAME_ICONWARNING))));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnPass.setLayoutData(gd);
        lblWarnPass.setVisible(false);

        lblRepoRoot = new Label(container, SWT.NONE);
        lblRepoRoot.setText(Messages.newProjWizard_select_git_repository_root_directory);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblRepoRoot.setLayoutData(gd);

        txtRepoRoot = new Text(container, SWT.BORDER);
        txtRepoRoot.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtRepoRoot.addListener(SWT.Modify, this);

        Button btnBrowseRepo = new Button(container, SWT.PUSH);
        btnBrowseRepo.setText(Messages.browse);
        btnBrowseRepo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(container
                        .getShell());
                dialog.setFilterPath(mainPrefStore.getString(UIConsts.PREF_LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtRepoRoot.setText(path);
                    AddonPrefLoader.savePreference(mainPrefStore, UIConsts.PREF_LAST_OPENED_LOCATION, path);
                }
            }
        });
        
        lblProjectFile = new Label(container, SWT.NONE);
        lblProjectFile.setText(Messages.newProjWizard_select_project_name);
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblProjectFile.setLayoutData(gd);
        txtProjectFile = new Text(container, SWT.BORDER);
        txtProjectFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjectFile.addListener(SWT.Modify, this);
        
        Button btnBrowseProj = new Button(container, SWT.PUSH);
        btnBrowseProj.setText(Messages.browse);
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell(),SWT.SAVE);
                dialog.setFilterExtensions(new String [] {"*.project"}); //$NON-NLS-1$
                dialog.setOverwrite(true);
                dialog.setFilterPath(mainPrefStore.getString(UIConsts.PREF_LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtProjectFile.setText(path);
                    AddonPrefLoader.savePreference(mainPrefStore,
                            UIConsts.PREF_LAST_OPENED_LOCATION, new File (path).getParent());
                }
            }
        });
        
        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        // TODO enable Next if git repo url is empty && selected root dir is 
        // git repo root. In that case get git repo url from repo
        
        // TODO check for conflicting user repo url and existing repo url
        String errMsg = null;
        
        if (getRepoUrl().isEmpty()) {
            errMsg = Messages.newProjWizard_enter + repoTypeName + Messages.newProjWizard_repo_url_demand;
        } else if (getRepoRootPath().isEmpty()
                || !new File(getRepoRootPath()).isDirectory()) {
            errMsg = Messages.newProjWizard_select_repo_root_directory;
        } else if (!JGitExec.isGitRepo(getRepoRootPath())
                && new File(txtRepoRoot.getText()).list().length != 0) {
            errMsg = Messages.newProjWizard_selecterd_dir_must_be_empty_or_be_a_root_dir_of;
        } else if (getProjectFile().isEmpty()
                || !getProjectFile().endsWith(UIConsts.FILENAME_PROJ_PREF_STORE)) {
            errMsg = Messages.newProjWizard_select_project_filename_demand;
        } else if (new File(getRepoRootPath()).toPath().getNameCount() == 0) {
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
                        .getResource(UIConsts.FILENAME_ICONWARNING))));
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
