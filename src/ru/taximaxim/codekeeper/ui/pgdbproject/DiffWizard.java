package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Set;

import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTreeViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import cz.startnet.utils.pgdiff.UnixPrintWriter;

public class DiffWizard extends Wizard implements IPageChangingListener {

    private PageDiff pageDiff;
    private PagePartial pagePartial;
    private PageResult pageResult;

    private final PgDbProject proj;

    private final IPreferenceStore mainPrefs;

    public DiffWizard(PgDbProject proj, IPreferenceStore mainPrefs) {
        setWindowTitle(Messages.diffWizard_diff);
        setNeedsProgressMonitor(true);

        this.proj = proj;
        this.mainPrefs = mainPrefs;
    }

    @Override
    public void addPages() {
        pageDiff = new PageDiff(Messages.diffWizard_diff_parameters, mainPrefs, proj);
        pagePartial = new PagePartial(Messages.diffWizard_diff_tree);
        pageResult = new PageResult(Messages.diffWizard_diff_result, proj);

        addPage(pageDiff);
        addPage(pagePartial);
        addPage(pageResult);
    }

    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        ((WizardDialog) getContainer()).addPageChangingListener(this);
    };

    DbSource dbSource, dbTarget;

    @Override
    public void handlePageChanging(PageChangingEvent e) {
        try {
            if (e.getCurrentPage() == pageDiff && e.getTargetPage() == pagePartial) {
                TreeDiffer treediffer = new TreeDiffer(
                        DbSource.fromProject(proj),
                        pageDiff.getTargetDbSource());

                try {
                    getContainer().run(true, false, treediffer);
                } catch (InvocationTargetException ex) {
                    e.doit = false;
                    throw new IllegalStateException(Messages.error_in_differ_thread, ex);
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    e.doit = false;
                    throw new IllegalStateException(
                            Messages.differ_thread_cancelled_shouldnt_happen, ex);
                }

                dbSource = treediffer.getDbSource();
                dbTarget = treediffer.getDbTarget();

                pagePartial.setData(dbSource.getOrigin(), dbTarget.getOrigin(),
                        treediffer.getDiffTree());
                pagePartial.layout();
            } else if (e.getCurrentPage() == pagePartial && e.getTargetPage() == pageResult) {
                TreeElement filtered = pagePartial.getDiffTree().filterDiffTree();

                DbSource fdbSource = DbSource.fromFilter(dbSource,
                        filtered, DiffSide.LEFT);
                DbSource fdbTarget = DbSource.fromFilter(dbTarget,
                        filtered, DiffSide.RIGHT);

                Differ differ = new Differ(fdbSource, fdbTarget, true);
                differ.setFullDbs(dbSource.getDbObject(), dbTarget.getDbObject());
                try {
                    getContainer().run(true, false, differ);
                } catch (InvocationTargetException ex) {
                    e.doit = false;
                    throw new IllegalStateException(Messages.error_in_differ_thread, ex);
                } catch (InterruptedException ex) {
                    // assume run() was called as non cancelable
                    e.doit = false;
                    throw new IllegalStateException(
                            Messages.differ_thread_cancelled_shouldnt_happen, ex);
                }

                pageResult.setData(fdbSource.getOrigin(), fdbTarget.getOrigin(),
                        differ.getDiffDirect(), differ.getDiffReverse());
                pageResult.layout();
            }
        } catch (Exception ex) {
            e.doit = false;
            throw ex;
        }
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() != pageResult) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        return true;
    }
}

class PageDiff extends WizardPage implements Listener {

    public enum DiffTargetType {
        DB, DUMP, /*SVN, */GIT, PROJ
    }

    private final IPreferenceStore mainPrefs;

    private final PgDbProject proj;

    private Composite container;

    private Button radioDb, radioDump, radioGit, radioProj;

    private Group currentTargetGrp;

    private DbPicker grpDb;

    private Group grpDump, grpGit, grpProj;

    private Text txtDumpPath, txtProjPath, txtProjRev, txtGitUrl, txtGitUser, 
                    txtGitPass, txtGitRev;

    private CLabel lblWarnGitPass;

    private Combo cmbEncoding;

    private LocalResourceManager lrm;

    public DiffTargetType getTargetType() {
        if (radioDb.getSelection()) {
            return DiffTargetType.DB;
        }
        if (radioDump.getSelection()) {
            return DiffTargetType.DUMP;
        }
        if (radioGit.getSelection()) {
            return DiffTargetType.GIT;
        }
        if (radioProj.getSelection()) {
            return DiffTargetType.PROJ;
        }

        throw new IllegalStateException(Messages.diffWizard_no_target_type_selection_found);
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

    public String getGitUrl() {
        return txtGitUrl.getText();
    }

    public String getGitUser() {
        return txtGitUser.getText();
    }

    public String getGitPass() {
        return txtGitPass.getText();
    }

    public String getGitRev() {
        return txtGitRev.getText();
    }

    public String getProjPath() {
        return txtProjPath.getText();
    }

    public String getProjRev() {
        return txtProjRev.getText();
    }

    public String getTargetEncoding() {
        return cmbEncoding.getText();
    }

    public DbSource getTargetDbSource() {
        DbSource dbs;

        switch (getTargetType()) {
        case DB:
            dbs = DbSource.fromDb(
                    mainPrefs.getString(UIConsts.PREF_PGDUMP_EXE_PATH),
                    mainPrefs.getString(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS),
                    getDbHost(), getDbPort(), getDbUser(), getDbPass(),
                    getDbName(), getTargetEncoding());
            break;

        case DUMP:
            dbs = DbSource.fromFile(getDumpPath(), getTargetEncoding());
            break;

        case GIT:
            dbs = DbSource.fromGit(
                    getGitUrl(), getGitUser(), getGitPass(), getGitRev(),
                    getTargetEncoding(), mainPrefs.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
            break;

        case PROJ:
            PgDbProject fromProj = new PgDbProject(getProjPath());
            fromProj.load();

            if (getProjRev().isEmpty()) {
                dbs = DbSource.fromProject(fromProj);
            } else {
                dbs = DbSource.fromGit(
                                fromProj.getString(UIConsts.PROJ_PREF_REPO_URL),
                                fromProj.getString(UIConsts.PROJ_PREF_REPO_USER),
                                fromProj.getString(UIConsts.PROJ_PREF_REPO_PASS),
                                getProjRev(),
                                fromProj.getString(UIConsts.PROJ_PREF_ENCODING),
                                mainPrefs.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
            }
            break;
        default:
            throw new IllegalStateException(Messages.diffWizard_unexpected_target_type_value);
        }

        return dbs;
    }

    public PageDiff(String pageName, IPreferenceStore mainPrefs,
            PgDbProject proj) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
        this.proj = proj;
    }

    @Override
    public void createControl(Composite parent) {
        this.lrm = new LocalResourceManager(JFaceResources.getResources(),
                parent);

        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());

        Group grpRadio = new Group(container, SWT.NONE);
        grpRadio.setText(Messages.diffWizard_diff_target);
        grpRadio.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        grpRadio.setLayout(new GridLayout(5, false));

        SelectionListener switcher = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button cause = (Button) e.getSource();

                if (cause.getSelection()) {
                    Group to = (Group) cause.getData();

                    if (to != grpProj) {
                        cmbEncoding.setEnabled(true);
                        cmbEncoding.select(cmbEncoding.indexOf("UTF-8")); //$NON-NLS-1$
                    } else {
                        cmbEncoding.setEnabled(false);
                        txtProjPath.notifyListeners(SWT.Modify, null);
                    }
                    switchTargetGrp(to);
                }
            }
        };

        radioDb = new Button(grpRadio, SWT.RADIO);
        radioDb.setText(Messages.db);
        radioDb.setSelection(true);
        radioDb.addSelectionListener(switcher);

        radioDump = new Button(grpRadio, SWT.RADIO);
        radioDump.setText(Messages.dump);
        radioDump.addSelectionListener(switcher);
        radioGit = new Button(grpRadio, SWT.RADIO);
        radioGit.setText(UIConsts.PROJ_REPO_TYPE_GIT_NAME);
        radioGit.addSelectionListener(switcher);

        radioProj = new Button(grpRadio, SWT.RADIO);
        radioProj.setText(Messages.diffWizard_project);
        radioProj.addSelectionListener(switcher);

        grpDb = new DbPicker(container, SWT.NONE, mainPrefs);
        grpDb.setText(Messages.diffWizard_db_taget);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);

        currentTargetGrp = grpDb;

        grpDb.txtDbPort.addListener(SWT.Modify, this);

        grpDump = new Group(container, SWT.NONE);
        grpDump.setText(Messages.diffWizard_dump_taget);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDump.setLayoutData(gd);
        grpDump.setLayout(new GridLayout(2, false));

        gd.exclude = true;
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
        
        grpGit = new Group(container, SWT.NONE);
        grpGit.setText(Messages.diffWizard_git_target);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpGit.setLayoutData(gd);
        grpGit.setLayout(new GridLayout(2, false));

        gd.exclude = true;
        grpGit.setVisible(false);

        new Label(grpGit, SWT.NONE).setText(Messages.diffWizard_git_repo_url);

        txtGitUrl = new Text(grpGit, SWT.BORDER);
        txtGitUrl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtGitUrl.addListener(SWT.Modify, this);
        txtGitUrl.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                if (txtGitUrl.getText().isEmpty()) {
                    txtGitUser.setEnabled(true);
                    txtGitPass.setEnabled(true);
                    txtGitPass.notifyListeners(SWT.Modify, new Event());                    
                } else if (JGitExec.PATTERN_HTTP_URL.matcher(
                        txtGitUrl.getText()).matches()) {
                    txtGitUser.setEnabled(true);
                    txtGitPass.setEnabled(true);
                    lblWarnGitPass.setText(Messages.warning
                            + Messages.providing_password_here_is_insecure + "\n"
                            + Messages.this_password_will_show_up_in_logs
                            + Messages.diffWizard_consider_using_ssh_authentication_instead);
                    txtGitPass.notifyListeners(SWT.Modify, new Event());
                } else if (JGitExec.PATTERN_FILE_URL.matcher(
                        txtGitUrl.getText()).matches()) {
                    txtGitUser.setEnabled(false);
                    txtGitPass.setEnabled(false);
                    txtGitPass.notifyListeners(SWT.Modify, new Event());
                }else {
                    txtGitUser.setEnabled(false);
                    txtGitPass.setEnabled(false);
                    lblWarnGitPass.setText(Messages.make_sure_you_have_priv_and_public_keys
                            + Messages.filenames_entered_in_application_preferences);
                    txtGitPass.notifyListeners(SWT.Modify, new Event());
                }
            }
        });
        
        new Label(grpGit, SWT.NONE).setText(Messages.diffWizard_git_user);

        txtGitUser = new Text(grpGit, SWT.BORDER);
        txtGitUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(grpGit, SWT.NONE).setText(Messages.diffWizard_git_password);

        txtGitPass = new Text(grpGit, SWT.BORDER | SWT.PASSWORD);
        txtGitPass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtGitPass.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                GridData gd = (GridData) lblWarnGitPass.getLayoutData();
                if ((txtGitPass.getText().isEmpty() && !gd.exclude)
                        || (!txtGitPass.getText().isEmpty() && gd.exclude)) {
                    gd.exclude = !gd.exclude;
                    lblWarnGitPass.setVisible(!lblWarnGitPass.getVisible());
                    container.layout(false);
                }
                if (!txtGitUrl.getText().isEmpty() &&  !JGitExec.PATTERN_HTTP_URL.matcher(txtGitUrl.getText()).matches() && !JGitExec.PATTERN_FILE_URL.matcher(txtGitUrl.getText()).matches()){
                    lblWarnGitPass.setVisible(true);
                    gd.exclude = false;
                    container.layout(true);
                }else if (!txtGitPass.isEnabled()) {
                    lblWarnGitPass.setVisible(false);
                    gd.exclude = true;
                    container.layout(false);
                }
                getShell().pack();
            }
        });

        lblWarnGitPass = new CLabel(grpGit, SWT.NONE);
        lblWarnGitPass.setImage(lrm.createImage(ImageDescriptor
                .createFromURL(Activator.getContext().getBundle()
                        .getResource(UIConsts.FILENAME_ICONWARNING))));
        lblWarnGitPass.setText(Messages.warning
                + Messages.providing_password_here_is_insecure + "\n"
                + Messages.this_password_will_show_up_in_logs
                + Messages.diffWizard_consider_using_ssh_authentication_instead);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1);
        gd.exclude = true;
        lblWarnGitPass.setLayoutData(gd);
        lblWarnGitPass.setVisible(false);

        new Label(grpGit, SWT.NONE).setText(Messages.diffWizard_git_commit_hash);

        txtGitRev = new Text(grpGit, SWT.BORDER);
        txtGitRev.setLayoutData(new GridData());
        txtGitRev.addListener(SWT.Modify, this);

        grpProj = new Group(container, SWT.NONE);
        grpProj.setText(Messages.diffWizard_project_target);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpProj.setLayoutData(gd);
        grpProj.setLayout(new GridLayout(2, false));

        gd.exclude = true;
        grpProj.setVisible(false);

        final Button btnThis = new Button(grpProj, SWT.CHECK);
        btnThis.setText(Messages.diffWizard_this_project);
        btnThis.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
                2, 1));
        btnThis.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (btnThis.getSelection()) {
                    txtProjPath.setText(proj.getProjectWorkingDir().toString());
                    txtProjPath.setEnabled(false);
                } else {
                    txtProjPath.setEnabled(true);
                }
            }
        });

        Composite tmpCont = new Composite(grpProj, SWT.NONE);
        tmpCont.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                2, 1));
        tmpCont.setLayout(new GridLayout(2, false));

        l = new Label(tmpCont, SWT.NONE);
        l.setText(Messages.diffWizard_path_to_target_project);
        l.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

        txtProjPath = new Text(tmpCont, SWT.BORDER);
        txtProjPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjPath.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                String dir = txtProjPath.getText();

                if (!dir.isEmpty() && new File(dir).isFile() &&
                        dir.endsWith(UIConsts.FILENAME_PROJ_PREF_STORE)) {
                    PgDbProject tmpProj = new PgDbProject(dir);
                    tmpProj.load();
                    cmbEncoding.select(cmbEncoding.indexOf(tmpProj.getString(
                            UIConsts.PROJ_PREF_ENCODING)));
                }
            }
        });
        txtProjPath.addListener(SWT.Modify, this);

        Button btnBrowseProj = new Button(tmpCont, SWT.PUSH);
        btnBrowseProj.setText(Messages.browse);
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(container.getShell());
                dialog.setText(Messages.diffWizard_open_project_file);
                dialog.setOverwrite(false);
                dialog.setFilterExtensions(new String[] { "*.project", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterPath(mainPrefs.getString(UIConsts.PREF_LAST_OPENED_LOCATION));
                String path = dialog.open();
                if (path != null) {
                    txtProjPath.setText(path);
                    txtProjPath.setEnabled(true);
                    btnThis.setSelection(false);
                    AddonPrefLoader.savePreference(mainPrefs, UIConsts.PREF_LAST_OPENED_LOCATION, new File (path).getParent());
                }
            }
        });

        new Label(grpProj, SWT.NONE)
                .setText(Messages.diffWizard_project_revision_grab_from_repo);

        txtProjRev = new Text(grpProj, SWT.BORDER);
        txtProjRev.setLayoutData(new GridData());

        radioDb.setData(grpDb);
        radioDump.setData(grpDump);
        radioGit.setData(grpGit);
        radioProj.setData(grpProj);

        Group grpEncoding = new Group(container, SWT.NONE);
        grpEncoding.setText(Messages.diffWizard_encoding);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpEncoding.setLayoutData(gd);
        grpEncoding.setLayout(new GridLayout(2, false));

        new Label(grpEncoding, SWT.NONE).setText(Messages.diffWizard_target_encoding);

        cmbEncoding = new Combo(grpEncoding, SWT.BORDER | SWT.DROP_DOWN
                | SWT.READ_ONLY);
        Set<String> charsets = Charset.availableCharsets().keySet();
        cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
        cmbEncoding.select(cmbEncoding.indexOf("UTF-8")); //$NON-NLS-1$

        setControl(container);
    }

    private void switchTargetGrp(Group newActive) {
        currentTargetGrp.setVisible(false);
        newActive.setVisible(true);

        ((GridData) currentTargetGrp.getLayoutData()).exclude = true;
        ((GridData) newActive.getLayoutData()).exclude = false;

        currentTargetGrp = newActive;

        getShell().pack();
        container.layout(false);

        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }

    @Override
    public boolean isPageComplete() {
        String errMsg = null;

        switch (getTargetType()) {
        case DB:
            if (!grpDb.txtDbPort.getText().isEmpty()) {
                try {
                    Integer.parseInt(grpDb.txtDbPort.getText());
                } catch (NumberFormatException ex) {
                    errMsg = Messages.port_must_be_a_number;
                }
            }
            break;

        case DUMP:
            if (txtDumpPath.getText().isEmpty()
                    || !new File(txtDumpPath.getText()).isFile()) {
                errMsg = Messages.select_readable_db_dump_file;
            }
            break;

        case GIT:
            if (txtGitUrl.getText().isEmpty()) {
                errMsg = Messages.diffWizard_enter_git_repo_url;
            }
            break;

        case PROJ:
            String dir = txtProjPath.getText();

            if (dir.isEmpty() || !dir.endsWith(UIConsts.FILENAME_PROJ_PREF_STORE) 
                    || !new File(dir).isFile()) {
                errMsg = Messages.diffWizard_select_valid_project_file;
            }

            break;
        }

        setErrorMessage(errMsg);

        if (errMsg != null) {
            return false;
        }
        return true;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }
}

class PagePartial extends WizardPage {

    private Composite container;

    private Label lblSource, lblTarget;

    private DiffTreeViewer diffTree;

    public void setData(String source, String target, TreeElement root) {
        lblSource.setText(source);
        lblTarget.setText(target);
        diffTree.setTreeInput(root);
    }

    public DiffTreeViewer getDiffTree() {
        return diffTree;
    }

    public PagePartial(String pageName) {
        super(pageName, pageName, null);
    }

    public void layout() {
        container.layout(true);
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());

        new Label(container, SWT.NONE).setText(Messages.diffWizard_source);

        lblSource = new Label(container, SWT.WRAP);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        lblSource.setLayoutData(gd);

        Label l = new Label(container, SWT.NONE);
        l.setText(Messages.diffWizard_target);
        gd = new GridData();
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        lblTarget = new Label(container, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        lblTarget.setLayoutData(gd);

        diffTree = new DiffTreeViewer(container, SWT.NONE);
        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 12;
        diffTree.setLayoutData(gd);

        setControl(container);
    }

    @Override
    public IWizardPage getPreviousPage() {
        return null;
    }
}

class PageResult extends WizardPage {

    final private PgDbProject proj;

    private Composite container;

    private Label lblSource, lblTarget;

    private Text txtDirect, txtReverse;

    public void setData(String source, String target, String direct,
            String reverse) {
        lblSource.setText(source);
        lblTarget.setText(target);
        txtDirect.setText(direct);
        txtReverse.setText(reverse);
    }

    public PageResult(String pageName, PgDbProject proj) {
        super(pageName, pageName, null);

        this.proj = proj;
    }

    public void layout() {
        container.layout(true);
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());

        new Label(container, SWT.NONE).setText(Messages.diffWizard_source);

        lblSource = new Label(container, SWT.WRAP);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        lblSource.setLayoutData(gd);

        Label l = new Label(container, SWT.NONE);
        l.setText(Messages.diffWizard_target);
        gd = new GridData();
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        lblTarget = new Label(container, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        lblTarget.setLayoutData(gd);

        final TabFolder tabs = new TabFolder(container, SWT.NONE);
        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 12;
        gd.widthHint = 600;
        tabs.setLayoutData(gd);
        tabs.setLayout(new GridLayout());

        txtDirect = new Text(tabs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txtDirect.setLayoutData(new GridData(GridData.FILL_BOTH));
        txtDirect.setBackground(getShell().getDisplay().getSystemColor(
                SWT.COLOR_LIST_BACKGROUND));
        txtDirect.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

        TabItem tabDirect = new TabItem(tabs, SWT.NONE);
        tabDirect.setText(Messages.diffWizard_source_target);
        tabDirect.setControl(txtDirect);

        txtReverse = new Text(tabs, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txtReverse.setLayoutData(new GridData(GridData.FILL_BOTH));
        txtReverse.setBackground(getShell().getDisplay().getSystemColor(
                SWT.COLOR_LIST_BACKGROUND));
        txtReverse.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

        TabItem tabReverse = new TabItem(tabs, SWT.NONE);
        tabReverse.setText(Messages.diffWizard_target_source);
        tabReverse.setControl(txtReverse);

        Button btnSave = new Button(container, SWT.PUSH);
        btnSave.setText(Messages.diffWizard_save);
        gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gd.verticalIndent = 12;
        btnSave.setLayoutData(gd);
        btnSave.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog saveDialog = new FileDialog(getShell(), SWT.SAVE);
                saveDialog.setText(Messages.diffWizard_save__ + tabs.getSelection()[0].getText()
                        + " diff..."); //$NON-NLS-1$
                saveDialog.setOverwrite(true);
                saveDialog.setFilterExtensions(new String[] { "*.sql", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                saveDialog.setFilterPath(proj.getProjectFile().getParent());

                String saveTo = saveDialog.open();
                if (saveTo != null) {
                    try (final PrintWriter encodedWriter = new UnixPrintWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(saveTo),
                                    proj.getString(UIConsts.PROJ_PREF_ENCODING)))) {
                        Text txtDiff = (Text) tabs.getSelection()[0]
                                .getControl();
                        encodedWriter.println(txtDiff.getText());
                    } catch (FileNotFoundException
                            | UnsupportedEncodingException ex) {
                        throw new IllegalStateException(
                                Messages.diffWizard_unexpected_error_while_saving_diff, ex);
                    }
                }
            }
        });

        setControl(container);
    }

    @Override
    public IWizardPage getPreviousPage() {
        return null;
    }
}
