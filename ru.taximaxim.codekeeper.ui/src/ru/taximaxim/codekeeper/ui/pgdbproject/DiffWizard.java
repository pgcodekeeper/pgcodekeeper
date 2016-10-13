package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Set;
import java.util.TimeZone;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTreeViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DiffWizard extends Wizard implements IPageChangingListener {

    private PageDiff pageDiff;
    private PagePartial pagePartial;
    private PageResult pageResult;

    private final PgDbProject proj;

    private final IPreferenceStore mainPrefs;

    public DiffWizard(PgDbProject proj, IPreferenceStore mainPrefs) {
        setWindowTitle(Messages.diffWizard_Diff);
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

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);

        getShell().addShellListener(new ShellAdapter() {

            @Override
            public void shellActivated(ShellEvent e) {
                getShell().removeShellListener(this);

                getShell().pack();
            }
        });

        ((WizardDialog) getContainer()).addPageChangingListener(this);
    };

    private DbSource dbSource, dbTarget;
    @Override
    public void handlePageChanging(PageChangingEvent e) {
        try {
            if (e.getCurrentPage() == pageDiff && e.getTargetPage() == pagePartial) {
                TreeDiffer treediffer = new TreeDiffer(
                        DbSource.fromProject(proj), pageDiff.getTargetDbSource(proj), false);

                try {
                    getContainer().run(true, true, treediffer);
                }  catch (InvocationTargetException ex) {
                    e.doit = false;
                    ExceptionNotifier.notifyDefault(Messages.error_in_differ_thread, ex);
                    return;
                } catch (InterruptedException ex) {
                    // cancelled
                    e.doit = false;
                    return;
                }
                dbSource = treediffer.getDbSource();
                dbTarget = treediffer.getDbTarget();

                pagePartial.setData(dbSource.getOrigin(), dbTarget.getOrigin(),
                        treediffer.getDiffTree());
                pagePartial.layout();
            } else if (e.getCurrentPage() == pagePartial && e.getTargetPage() == pageResult) {
                TreeElement filtered = pagePartial.getDiffTree().getTreeInput();

                IEclipsePreferences pref = proj.getPrefs();
                Differ differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                        filtered, true,
                        pref.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC),
                        pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true));
                try {
                    getContainer().run(true, true, differ);
                } catch (InvocationTargetException ex) {
                    e.doit = false;
                    ExceptionNotifier.notifyDefault(Messages.error_in_differ_thread, ex);
                    return;
                } catch (InterruptedException ex) {
                    // cancelled
                    e.doit = false;
                    return;
                }

                pageResult.setData(dbSource.getOrigin(), dbTarget.getOrigin(),
                        differ.getDiffDirect(), differ.getDiffReverse());
                pageResult.layout();
            }
        } catch(PgCodekeeperUIException e1) {
            e.doit = false;
            ExceptionNotifier.notifyDefault(Messages.DiffWizard_unexpected_error, e1);
            return;
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
        DB, DUMP, JDBC, PROJ
    }

    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;

    private Composite container;
    private Button radioDb, radioJdbc, radioDump, radioProj;
    private Group currentTargetGrp;
    private DbPicker grpDb;
    private Group grpDump, grpProj;
    private Text txtDumpPath, txtProjPath;
    private Combo cmbEncoding;
    private Combo cmbTimezone;

    public DiffTargetType getTargetType() throws PgCodekeeperUIException {
        if (radioDb.getSelection()) {
            return DiffTargetType.DB;
        }else if (radioJdbc.getSelection()){
            return DiffTargetType.JDBC;
        }else if (radioDump.getSelection()) {
            return DiffTargetType.DUMP;
        }else if (radioProj.getSelection()) {
            return DiffTargetType.PROJ;
        }
        throw new PgCodekeeperUIException(Messages.diffWizard_no_target_type_selection_found);
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

    public String getProjPath() {
        return txtProjPath.getText();
    }

    public String getTargetEncoding() {
        return cmbEncoding.getText();
    }

    public String getTargetTimezone() {
        return cmbTimezone.getText();
    }

    public DbSource getTargetDbSource(PgDbProject proj) throws PgCodekeeperUIException {
        IEclipsePreferences pref = proj.getPrefs();
        DbSource dbs;

        switch (getTargetType()) {
        case DB:
            dbs = DbSource.fromDb(pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                    mainPrefs.getString(PREF.PGDUMP_EXE_PATH),
                    mainPrefs.getString(PREF.PGDUMP_CUSTOM_PARAMS),
                    getDbHost(), getDbPort(), getDbUser(), getDbPass(),
                    getDbName(), getTargetEncoding(), getTargetTimezone());
            break;

        case JDBC:
            dbs = DbSource.fromJdbc(getDbHost(), getDbPort(), getDbUser(),
                    getDbPass(), getDbName(), getTargetEncoding(), getTargetTimezone(),
                    pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true));
            break;

        case DUMP:
            dbs = DbSource.fromFile(pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                    new File(getDumpPath()), getTargetEncoding());
            break;

        case PROJ:
            dbs = DbSource.fromDirTree(pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                    getProjPath(), getTargetEncoding());
            break;

        default:
            throw new PgCodekeeperUIException(Messages.diffWizard_unexpected_target_type_value);
        }

        return dbs;
    }

    public PageDiff(String pageName, IPreferenceStore mainPrefs, PgDbProject proj) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
        this.proj = proj;
    }

    @Override
    public void createControl(Composite parent) {
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
                    switchTargetGrp((Group) cause.getData());
                }
            }
        };

        radioDb = new Button(grpRadio, SWT.RADIO);
        radioDb.setText(Messages.db);
        radioDb.setSelection(true);
        radioDb.addSelectionListener(switcher);

        radioJdbc = new Button(grpRadio, SWT.RADIO);
        radioJdbc.setText(Messages.jdbc);
        radioJdbc.setSelection(false);
        radioJdbc.addSelectionListener(switcher);

        radioDump = new Button(grpRadio, SWT.RADIO);
        radioDump.setText(Messages.dump);
        radioDump.addSelectionListener(switcher);

        radioProj = new Button(grpRadio, SWT.RADIO);
        radioProj.setText(Messages.diffWizard_project);
        radioProj.addSelectionListener(switcher);

        grpDb = new DbPicker(container, SWT.NONE, mainPrefs);
        grpDb.setText(Messages.diffWizard_db_taget);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpDb.setLayoutData(gd);

        currentTargetGrp = grpDb;

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

        grpProj = new Group(container, SWT.NONE);
        grpProj.setText(Messages.diffWizard_project_target);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpProj.setLayoutData(gd);
        grpProj.setLayout(new GridLayout(2, false));

        gd.exclude = true;
        grpProj.setVisible(false);

        Composite tmpCont = new Composite(grpProj, SWT.NONE);
        tmpCont.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                2, 1));
        tmpCont.setLayout(new GridLayout(2, false));

        l = new Label(tmpCont, SWT.NONE);
        l.setText(Messages.diffWizard_path_to_target_project);
        l.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

        txtProjPath = new Text(tmpCont, SWT.BORDER);
        txtProjPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtProjPath.addListener(SWT.Modify, this);

        Button btnBrowseProj = new Button(tmpCont, SWT.PUSH);
        btnBrowseProj.setText(Messages.browse);
        btnBrowseProj.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(container.getShell());
                String lastLoc = mainPrefs.getString(PREF.LAST_OPENED_LOCATION);
                if (!lastLoc.isEmpty()) {
                    dialog.setFilterPath(lastLoc);
                }
                String path = dialog.open();
                if (path != null) {
                    txtProjPath.setText(path);
                    File f = new File(path);
                    String parent = f.getParent();
                    mainPrefs.setValue(PREF.LAST_OPENED_LOCATION, parent == null ? f.getPath() : parent);
                }
            }
        });

        radioDb.setData(grpDb);
        radioJdbc.setData(grpDb);
        radioDump.setData(grpDump);
        radioProj.setData(grpProj);

        Group grpEncoding = new Group(container, SWT.NONE);
        grpEncoding.setText(Messages.diffWizard_encoding);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        grpEncoding.setLayoutData(gd);
        grpEncoding.setLayout(new GridLayout(2, false));

        new Label(grpEncoding, SWT.NONE).setText(Messages.diffWizard_target_encoding);

        cmbEncoding = new Combo(grpEncoding,  SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        Set<String> charsets = Charset.availableCharsets().keySet();
        cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
        try {
            cmbEncoding.select(
                    cmbEncoding.indexOf(proj.getProjectCharset()));
        } catch (CoreException e1) {
            setErrorMessage(Messages.DiffWizard_project_charset_error);
            Log.log(Log.LOG_ERROR, "Cannot get project charset", e1); //$NON-NLS-1$
            cmbEncoding.select(
                    cmbEncoding.indexOf(ApgdiffConsts.UTF_8));
        }

        new Label(grpEncoding, SWT.NONE).setText(Messages.diffWizard_target_timezone);

        String[] availableTimezones = TimeZone.getAvailableIDs();
        Arrays.sort(availableTimezones);
        cmbTimezone = new Combo(grpEncoding, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbTimezone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbTimezone.setItems(availableTimezones);
        cmbTimezone.select(cmbTimezone.indexOf(
                proj.getPrefs().get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC)));

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

        try {
            switch (getTargetType()) {
            case DB:
            case JDBC:
                break;

            case DUMP:
                if (txtDumpPath.getText().isEmpty()
                        || !new File(txtDumpPath.getText()).isFile()) {
                    errMsg = Messages.select_readable_db_dump_file;
                }
                break;

            case PROJ:
                String dir = txtProjPath.getText();
                if (dir.isEmpty() || !new File(dir).isDirectory()) {
                    errMsg = Messages.diffWizard_select_valid_project_file;
                }
                break;
            }
        } catch (PgCodekeeperUIException e) {
            errMsg = Messages.DiffWizard_bad_target_db;
            return false;
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

    private final PgDbProject proj;

    private Composite container;
    private TabFolder tabs;
    private Label lblSource, lblTarget;

    private Text txtDirect, txtReverse;

    public void setData(String source, String target, String direct, String reverse) {
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

        tabs = new TabFolder(container, SWT.NONE);
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
        txtDirect.setFont(JFaceResources.getTextFont());

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
        gd = new GridData(SWT.END, SWT.DEFAULT, false, false);
        gd.verticalIndent = 12;
        btnSave.setLayoutData(gd);
        btnSave.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog saveDialog = new FileDialog(getShell(), SWT.SAVE);
                saveDialog.setText(MessageFormat.format(
                        Messages.diffWizard_save__,
                        tabs.getSelection()[0].getText()));
                saveDialog.setOverwrite(true);
                saveDialog.setFilterExtensions(new String[] { "*.sql", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                saveDialog.setFilterPath(proj.getPathToProject().toString());

                String saveTo = saveDialog.open();
                if (saveTo != null) {
                    saveScript(saveTo);
                }
            }
        });

        setControl(container);
    }

    private void saveScript(String saveTo) {
        String charset = ApgdiffConsts.UTF_8;
        try {
            charset = proj.getProjectCharset();
        } catch (CoreException e) {
            setErrorMessage(Messages.DiffWizard_project_charset_error);
            Log.log(Log.LOG_ERROR, "Cannot get project charset", e); //$NON-NLS-1$
        }
        try (PrintWriter encodedWriter = new UnixPrintWriter(
                // TODO save to proj encoding can be incorrect.
                // Consider saving to unicode if proj and PageDiff encodings differ
                new OutputStreamWriter(new FileOutputStream(saveTo), charset))) {
            Text txtDiff = (Text) tabs.getSelection()[0].getControl();
            encodedWriter.println(txtDiff.getText());
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.diffWizard_unexpected_error_while_saving_diff, ex);
        }
    }

    @Override
    public IWizardPage getPreviousPage() {
        return null;
    }
}
