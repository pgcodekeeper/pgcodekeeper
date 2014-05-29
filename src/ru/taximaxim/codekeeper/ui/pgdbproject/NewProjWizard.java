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

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ExceptionNotifyHelper;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

public class NewProjWizard extends Wizard implements IPageChangingListener {

    private PageRepo pageRepo;
    private PageSubdir pageSubdir;
    private PageDb pageDb;
    private PageMisc pageMisc;

    final IPreferenceStore mainPrefStore;

    private PgDbProject props;

    public NewProjWizard(IPreferenceStore mainPrefStore) {
        setWindowTitle("New PgDbProject");
        setNeedsProgressMonitor(true);
        this.mainPrefStore = mainPrefStore;
    }
    
    public PgDbProject getProject() {
        return props;
    }

    @Override
    public void addPages() {
        pageRepo = new PageRepo("Repository settings", mainPrefStore);
        addPage(pageRepo);
        pageSubdir = new PageSubdir("Working directory settings");
        addPage(pageSubdir);
        pageDb = new PageDb("Schema Source Settings", mainPrefStore);
        addPage(pageDb);
        pageMisc = new PageMisc("Miscellaneous");
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
            
            if (JGitExec.isGitRepo(pageRepo.getRepoRootPath())){
                return;
            }
            
            if (MessageDialog.openQuestion(getShell(), "Selected directory is empty",
                            "Targer directory is not a GIT repository root directory.\n"
                            + "You need to clone the repo first in order to select working directory.\n"
                            + "Do you want to clone repository \""
                            + pageRepo.getRepoUrl()
                            + "\" to selected directory now?")) {

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
                                "Cloning GIT repository", 2);
                        final JGitExec git = new JGitExec(repoUrl,repoUser, repoPass,
                                mainPrefStore.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
                        pm.worked(1);
                        try {
                            git.repoCheckOut(new File(repoPath));
                            AddonPrefLoader.savePreference(mainPrefStore, 
                                    UIConsts.PREF_LAST_REPO, repoUrl);
                        } catch (IOException e) {
                            throw new InvocationTargetException(e);
                        }
                        monitor.done();
                    }
                };
                
                try {
                    new ProgressMonitorDialog(pageRepo.getShell()).run(true,
                            false, cloneRunnable);
                } catch (InvocationTargetException | InterruptedException e) {
                    event.doit = false;
                    ExceptionNotifyHelper.notifyAndThrow(new IllegalStateException(e), 
                            this.getShell());
                }
            } else {
                // didn't clone the repo; can't proceed without it
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

        Log.log(Log.LOG_INFO, "Creating new project properties at "
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
            throw new IllegalStateException("No Schema Source selected.");
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
                    "Error while saving project properties", ex);
        }

        if (pageSubdir.isDoInit()){
            try {
                getContainer().run(false, false, 
                        new InitProjectFromSource(mainPrefStore, props, pageDb.getDumpPath()));
            } catch (InvocationTargetException ex) {
                ExceptionNotifyHelper.notifyAndThrow(new IllegalStateException(
                        "Error while initializing repo", ex), getShell());
            } catch (InterruptedException ex) {
                // assume run() was called as non cancelable
                ExceptionNotifyHelper.notifyAndThrow(new IllegalStateException(
                        "Project creator thread cancelled. Shouldn't happen!", ex), getShell());
            }
        }

        try {
            boolean isCreated = new File (props.getProjectWorkingDir(),
                    UIConsts.FILENAME_WORKING_DIR_MARKER).createNewFile();
            if (isCreated){
                new JGitExec(props, mainPrefStore.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE)).
                            repoCommit(props.getProjectWorkingDir(), "File-marker added");
            }
        } catch (IOException e) {
            Log.log(Log.LOG_WARNING, "Could not either create marker file or "
                    + "commit it in " + props.getProjectWorkingDir());
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
                .setText("Warning:\n"
                        + "Providing password here is insecure!"
                        + " This password WILL show up in logs!\n"
                        + "Consider using ssh authentification instead (use git@host as repo url).");
            }else if (JGitExec.PATTERN_FILE_URL.matcher(txtRepoUrl.getText()).matches()){
                lblWarnPass.setText("");
            }else {
                lblWarnPass.setText("Make sure you have private and public keys\n"
                        + "filenames entered in application preferences.");
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
        grpRepo.setText(repoTypeName + " Settings");
        grpRepo.setLayout(new GridLayout(2, false));
        grpRepo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

        lblRepoUrl = new Label(grpRepo, SWT.NONE);
        lblRepoUrl.setText(repoTypeName + " Repo URL:");

        txtRepoUrl = new Text(grpRepo, SWT.BORDER);
        txtRepoUrl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtRepoUrl.setText(mainPrefStore.getString(UIConsts.PREF_LAST_REPO));
        txtRepoUrl.addListener(SWT.Modify, this);

        lblRepoUser = new Label(grpRepo, SWT.NONE);
        lblRepoUser.setText(repoTypeName + " User:");

        txtRepoUser = new Text(grpRepo, SWT.BORDER);
        txtRepoUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        lblRepoPass = new Label(grpRepo, SWT.NONE);
        lblRepoPass.setText(repoTypeName + " Password:");

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
        lblRepoRoot.setText("Select Git repository root directory "
                + "(either empty folder or existing repository)");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblRepoRoot.setLayoutData(gd);

        txtRepoRoot = new Text(container, SWT.BORDER);
        txtRepoRoot.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtRepoRoot.addListener(SWT.Modify, this);

        Button btnBrowseRepo = new Button(container, SWT.PUSH);
        btnBrowseRepo.setText("Browse...");
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
        lblProjectFile.setText("Select project filename");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblProjectFile.setLayoutData(gd);
        txtProjectFile = new Text(container, SWT.BORDER);
        txtProjectFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjectFile.addListener(SWT.Modify, this);
        
        Button btnBrowseProj = new Button(container, SWT.PUSH);
        btnBrowseProj.setText("Browse...");
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell(),SWT.SAVE);
                dialog.setFilterExtensions(new String [] {"*.project"});
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
        String errMsg = null;
        
        if (getRepoUrl().isEmpty()) {
            errMsg = "Enter " + repoTypeName + " Repo URL!";
        } else if (getRepoRootPath().isEmpty()
                || !new File(getRepoRootPath()).isDirectory()) {
            errMsg = "Select repo root directory!";
        } else if (!JGitExec.isGitRepo(getRepoRootPath())
                && new File(txtRepoRoot.getText()).list().length != 0) {
            errMsg = "Selected directory must be empty or be a root directory of"
                    + " existing git repository (must contain .git subdirectory)";
        } else if (getProjectFile().isEmpty()
                || !getProjectFile().endsWith(UIConsts.FILENAME_PROJ_PREF_STORE)) {
            errMsg = "Select project filename!";
        } else if (new File(getRepoRootPath()).toPath().getNameCount() == 0) {
            errMsg = "Select Project Directory (should not be root)!";
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
    
    public String getRepoSubdir() {
        return txtRepoSubdir.getText();
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
        btnDoInit.setText("Init project subdirectory from Schema Source (Live DB or dump file)");
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
        lblWarnInit.setText("Warning:\n"
                        + "This will delete repo contents and recreate them "
                        + "from Schema Source (next page).");        
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarnInit.setLayoutData(gd);
        lblWarnInit.setVisible(false);
        
        lblRepoSubdir = new Label(container, SWT.NONE);
        lblRepoSubdir.setText("Select a directory inside the repository,"
                            + " that will contain DB schemas and constraints\n"
                            + "(leave unchanged to use root)");
        gd = new GridData();
        gd.horizontalSpan = 2;
        gd.verticalIndent = 12;
        lblRepoSubdir.setLayoutData(gd);

        txtRepoSubdir = new Text(container, SWT.BORDER);
        txtRepoSubdir.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        txtRepoSubdir.addListener(SWT.Modify, this);
        Button btnBrowseProj = new Button(container, SWT.PUSH);
        btnBrowseProj.setText("Browse...");
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
        
        if (repoSubdir.isEmpty() || !new File(repoSubdir).exists() || 
                !Paths.get(repoSubdir).startsWith(Paths.get(repoRoot))) {
            errMsg = "Select correct subdir of the GIT repository";
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
        radioGrp.setText("Schema Source");
        radioGrp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
                2, 1));
        radioGrp.setLayout(new GridLayout(3, false));

        radioDb = new Button(radioGrp, SWT.RADIO);
        radioDb.setText("DB");

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
        radioDump.setText("Dump File");

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
        radioNone.setText("None");
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
        grpDb.setText("DB Source Settings");
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
        gd.exclude = true;
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);
        grpDb.setVisible(false);

        grpDb.txtDbPort.addListener(SWT.Modify, this);

        grpDump = new Group(container, SWT.NONE);
        grpDump.setText("Dump File Source Settings");
        gd = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
        gd.exclude = true;
        gd.verticalIndent = 12;
        grpDump.setLayoutData(gd);
        grpDump.setLayout(new GridLayout(2, false));
        grpDump.setVisible(false);

        Label l = new Label(grpDump, SWT.NONE);
        l.setText("Path to DB Schema Dump:");
        gd = new GridData();
        gd.horizontalSpan = 2;
        l.setLayoutData(gd);

        txtDumpPath = new Text(grpDump, SWT.BORDER);
        txtDumpPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDumpPath.addListener(SWT.Modify, this);

        Button btnBrowseDump = new Button(grpDump, SWT.PUSH);
        btnBrowseDump.setText("Browse...");
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
        lblNoSource.setText("No Schema Source selected.");

        setControl(container);
    }

    @Override
    public boolean isPageComplete() {
        String errMsg = null;
        if (radioDump.getSelection()
                && (txtDumpPath.getText().isEmpty() || !new File(
                        txtDumpPath.getText()).isFile())) {
            errMsg = "Select a readable DB dump file!";
        } else if (radioDb.getSelection()
                && !grpDb.txtDbPort.getText().isEmpty()) {
            try {
                Integer.parseInt(grpDb.txtDbPort.getText());
            } catch (NumberFormatException ex) {
                errMsg = "Port must be a number!";
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
                .setText("Project encoding (used for all supporting operaions):");

        cmbEncoding = new Combo(container, SWT.BORDER | SWT.DROP_DOWN
                | SWT.READ_ONLY);
        Set<String> charsets = Charset.availableCharsets().keySet();
        cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
        cmbEncoding.select(cmbEncoding.indexOf("UTF-8"));

        setControl(container);
    }
}
