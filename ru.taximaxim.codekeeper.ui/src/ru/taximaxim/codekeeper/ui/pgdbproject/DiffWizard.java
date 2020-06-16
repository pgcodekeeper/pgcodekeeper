package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;

public class DiffWizard extends Wizard implements IPageChangingListener {

    private PageDiff pageDiff;
    private PagePartial pagePartial;

    private final PgDbProject proj;
    private final IPreferenceStore mainPrefs;

    public DiffWizard(PgDbProject proj, IPreferenceStore mainPrefs) {
        this.proj = proj;
        this.mainPrefs = mainPrefs;

        setWindowTitle(Messages.diffWizard_Diff);
        setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONAPPWIZ)));
        setNeedsProgressMonitor(true);
    }

    @Override
    public void addPages() {
        pageDiff = new PageDiff(Messages.diffWizard_diff_parameters, mainPrefs, proj);
        pagePartial = new PagePartial(Messages.diffWizard_diff_tree);

        addPage(pageDiff);
        addPage(pagePartial);
    }

    @Override
    public void createPageControls(Composite pageContainer) {
        super.createPageControls(pageContainer);
        ((WizardDialog) getContainer()).addPageChangingListener(this);
    }

    @Override
    public void handlePageChanging(PageChangingEvent e) {
        if (e.getCurrentPage() == pageDiff && e.getTargetPage() == pagePartial) {
            DbSource dbSource = pageDiff.getDbSource();
            DbSource dbTarget = pageDiff.getDbTarget();
            TreeDiffer treediffer = new TreeDiffer(dbSource, dbTarget);

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

            pagePartial.setData(treediffer, pageDiff.getIgnoreList());
        }
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() != pagePartial) {
            return false;
        }
        return super.canFinish();
    }

    @Override
    public boolean performFinish() {
        try {
            TreeDiffer treediffer = pagePartial.getTreeDiffer();
            PgDatabase source = treediffer.getDbSource().getDbObject();

            Differ differ = new Differ(source, treediffer.getDbTarget().getDbObject(),
                    treediffer.getDiffTree(), false, pageDiff.getTimezone(),
                    source.getArguments().isMsSql(), null, pageDiff.getOneTimePrefs());
            getContainer().run(true, true, differ);

            FileUtilsUi.saveOpenTmpSqlEditor(differ.getDiffDirect(),
                    "diff_wizard_result", source.getArguments().isMsSql()); //$NON-NLS-1$
            return true;
        } catch (InvocationTargetException ex) {
            ExceptionNotifier.notifyDefault(Messages.error_in_differ_thread, ex);
        } catch (InterruptedException ex) {
            // cancelled
        } catch (PartInitException ex) {
            ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
        } catch (IOException | CoreException ex) {
            ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_error_creating_file, ex);
        }
        return false;
    }
}

class PageDiff extends WizardPage implements Listener {

    private final IPreferenceStore mainPrefs;
    private final PgDbProject proj;

    private DbSourcePicker dbSource;
    private DbSourcePicker dbTarget;
    private Button btnMsSql;
    private ComboViewer cmbTimezone;
    private CLabel lblWarnPosix;

    private Button btnNoPrivileges;
    private Button btnEnableFuncDep;
    private Button btnSimplifyView;
    private Button btnUseGlobalIgnoreList;

    private Button btnScriptAddTransact;
    private Button btnCheckFuncBodies;
    private Button btnAlterColUsingExpr;
    private Button btnCreateIdxConcurrent;

    public PageDiff(String pageName, IPreferenceStore mainPrefs, PgDbProject proj) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
        this.proj = proj;
        setDescription(Messages.diffwizard_diffpage_select);
    }

    public DbSource getDbSource() {
        return dbSource.getDbSource(btnMsSql.getSelection(), getOneTimePrefs());
    }

    public DbSource getDbTarget() {
        return dbTarget.getDbSource(btnMsSql.getSelection(), getOneTimePrefs());
    }

    public IgnoreList getIgnoreList() {
        if (btnUseGlobalIgnoreList.getSelection()) {
            return InternalIgnoreList.readInternalList();
        }

        return new IgnoreList();
    }

    public String getTimezone() {
        return cmbTimezone.getCombo().getText();
    }

    public void setTimezone(String timezone) {
        cmbTimezone.getCombo().setText(timezone);
    }

    public boolean isMsSql() {
        return btnMsSql.getSelection();
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout());

        Composite dbContainer = new Composite(container, SWT.NONE);
        dbContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        dbContainer.setLayout(new GridLayout(2, true));

        dbSource = new DbSourcePicker(dbContainer, Messages.DiffWizard_source, this);
        dbSource.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        dbTarget = new DbSourcePicker(dbContainer, Messages.DiffWizard_target, this);
        dbTarget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Composite compTz = new Composite(container, SWT.NONE);
        compTz.setLayout(new GridLayout(2, false));

        new Label(compTz, SWT.NONE).setText(Messages.DiffWizard_db_tz);

        cmbTimezone = new ComboViewer(compTz, SWT.DROP_DOWN | SWT.BORDER);
        cmbTimezone.setContentProvider(ArrayContentProvider.getInstance());
        cmbTimezone.setLabelProvider(new LabelProvider());
        cmbTimezone.setInput(UIConsts.TIME_ZONES);
        cmbTimezone.getCombo().setText(ApgdiffConsts.UTC);
        cmbTimezone.getCombo().addModifyListener(e -> timeZoneWarn());

        lblWarnPosix = new CLabel(container, SWT.NONE);
        lblWarnPosix.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnPosix.setText(Messages.ProjectProperties_posix_is_used_warn);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.exclude = true;
        lblWarnPosix.setLayoutData(gd);

        btnMsSql = new Button(container, SWT.CHECK);
        btnMsSql.setText(Messages.DiffWizard_ms_sql_dump);
        btnMsSql.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                getWizard().getContainer().updateButtons();
                getWizard().getContainer().updateMessage();
            }
        });

        Button btnShowPrefs = new Button(container, SWT.CHECK);
        btnShowPrefs.setText(Messages.DiffWizard_show_advanced_options);
        btnShowPrefs.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean selected = btnShowPrefs.getSelection();
                btnNoPrivileges.setVisible(selected);
                btnEnableFuncDep.setVisible(selected);
                btnSimplifyView.setVisible(selected);
                btnUseGlobalIgnoreList.setVisible(selected);
                btnScriptAddTransact.setVisible(selected);
                btnCheckFuncBodies.setVisible(selected);
                btnAlterColUsingExpr.setVisible(selected);
                btnCreateIdxConcurrent.setVisible(selected);

                UiSync.exec(getShell(), () -> getShell().pack());
            }
        });

        btnNoPrivileges = new Button(container, SWT.CHECK);
        btnNoPrivileges.setText(Messages.dbUpdatePrefPage_ignore_privileges);
        btnNoPrivileges.setSelection(mainPrefs.getBoolean(PREF.NO_PRIVILEGES));
        btnNoPrivileges.setVisible(false);

        btnEnableFuncDep = new Button(container, SWT.CHECK);
        btnEnableFuncDep.setText(Messages.GeneralPrefPage_enable_body_dependencies);
        btnEnableFuncDep.setToolTipText(Messages.GeneralPrefPage_body_depcy_tooltip);
        btnEnableFuncDep.setSelection(mainPrefs.getBoolean(PREF.ENABLE_BODY_DEPENDENCIES));
        btnEnableFuncDep.setVisible(false);

        btnSimplifyView = new Button(container, SWT.CHECK);
        btnSimplifyView.setText(Messages.GeneralPrefPage_simplify_view);
        btnSimplifyView.setSelection(mainPrefs.getBoolean(PREF.SIMPLIFY_VIEW));
        btnSimplifyView.setVisible(false);

        btnUseGlobalIgnoreList = new Button(container, SWT.CHECK);
        btnUseGlobalIgnoreList.setText(Messages.ProjectProperties_use_global_ignore_list);
        btnUseGlobalIgnoreList.setSelection(true);
        btnUseGlobalIgnoreList.setVisible(false);

        btnScriptAddTransact = new Button(container, SWT.CHECK);
        btnScriptAddTransact.setText(Messages.dbUpdatePrefPage_script_add_transaction);
        btnScriptAddTransact.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION));
        btnScriptAddTransact.setVisible(false);

        btnCheckFuncBodies = new Button(container, SWT.CHECK);
        btnCheckFuncBodies.setText(Messages.dbUpdatePrefPage_check_function_bodies);
        btnCheckFuncBodies.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES));
        btnCheckFuncBodies.setVisible(false);

        btnAlterColUsingExpr = new Button(container, SWT.CHECK);
        btnAlterColUsingExpr.setText(Messages.dbUpdatePrefPage_switch_on_off_using);
        btnAlterColUsingExpr.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.USING_ON_OFF));
        btnAlterColUsingExpr.setVisible(false);

        btnCreateIdxConcurrent = new Button(container, SWT.CHECK);
        btnCreateIdxConcurrent.setText(Messages.DbUpdatePrefPage_print_index_with_concurrently);
        btnCreateIdxConcurrent.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY));
        btnCreateIdxConcurrent.setVisible(false);

        if (proj != null) {
            dbTarget.setDbStore(new StructuredSelection(proj.getProject().getLocation().toFile()));
        }

        setControl(container);
    }

    private void timeZoneWarn() {
        String tz = cmbTimezone.getCombo().getText();
        GridData data = (GridData) lblWarnPosix.getLayoutData();
        if ((!ApgdiffConsts.UTC.equals(tz)
                && tz.startsWith(ApgdiffConsts.UTC)) == data.exclude)  {
            lblWarnPosix.setVisible(data.exclude);
            data.exclude = !data.exclude;
            lblWarnPosix.getParent().layout();
            UiSync.exec(getShell(), () -> getShell().pack());
        }
    }

    private boolean isMsSqlDb(DbSourcePicker sourcePicer) {
        DbInfo dbInfo = sourcePicer.getSelectedDbInfo();
        if (dbInfo != null) {
            return dbInfo.isMsSql();
        }

        return isMsSql();
    }

    @Override
    public boolean isPageComplete() {
        String err = null;

        if (getDbSource() == null) {
            err = Messages.diffwizard_diffpage_source_warning;
        } else if (getDbTarget() == null) {
            err = Messages.diffwizard_diffpage_target_warning;
        } else if (getTimezone().isEmpty()) {
            err = Messages.DiffWizard_select_db_tz;
        } else if (isMsSqlDb(dbSource) != isMsSqlDb(dbTarget)) {
            err = Messages.DiffWizard_different_types;
        }

        boolean isPg = !isMsSqlDb(dbSource);
        btnSimplifyView.setEnabled(isPg);
        btnCheckFuncBodies.setEnabled(isPg);
        btnAlterColUsingExpr.setEnabled(isPg);

        setErrorMessage(err);
        return err == null;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }

    public Map<String, Boolean> getOneTimePrefs() {
        Map<String, Boolean> oneTimePrefs = new HashMap<>();

        oneTimePrefs.put(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION, btnScriptAddTransact.getSelection());
        oneTimePrefs.put(PREF.NO_PRIVILEGES, btnNoPrivileges.getSelection());
        oneTimePrefs.put(PREF.ENABLE_BODY_DEPENDENCIES, btnEnableFuncDep.getSelection());
        oneTimePrefs.put(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, btnUseGlobalIgnoreList.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, btnCheckFuncBodies.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.USING_ON_OFF, btnAlterColUsingExpr.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY, btnCreateIdxConcurrent.getSelection());
        oneTimePrefs.put(PREF.SIMPLIFY_VIEW, btnSimplifyView.getSelection());

        return oneTimePrefs;
    }
}

class PagePartial extends WizardPage {

    private TreeDiffer treeDiffer;
    private Label lblSource;
    private Label lblTarget;
    private DiffTableViewer diffTable;

    public void setData(TreeDiffer treeDiffer, IgnoreList ignoreList) {
        this.treeDiffer = treeDiffer;
        DbSource source = treeDiffer.getDbSource();
        DbSource target = treeDiffer.getDbTarget();
        lblSource.setText(source.getOrigin());
        lblTarget.setText(target.getOrigin());
        lblSource.getParent().layout();
        diffTable.setInput(source, target, treeDiffer.getDiffTree(), ignoreList);
    }

    public TreeDiffer getTreeDiffer() {
        return treeDiffer;
    }

    public PagePartial(String pageName) {
        super(pageName, pageName, null);
        setDescription(Messages.diffwizard_pagepartial_description);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, true));

        new Label(container, SWT.NONE).setText(Messages.DiffWizard_source + ':');
        new Label(container, SWT.NONE).setText(Messages.DiffWizard_target + ':');
        lblSource = new Label(container, SWT.WRAP);
        lblTarget = new Label(container, SWT.WRAP);

        diffTable = new DiffTableViewer(container, false);
        diffTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        setControl(container);
    }
}
