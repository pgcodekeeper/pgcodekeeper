/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
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
            } catch (InvocationTargetException ex) {
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
                    source.getArguments().getDbType(), null, pageDiff.getOneTimePrefs());
            getContainer().run(true, true, differ);

            FileUtilsUi.saveOpenTmpSqlEditor(differ.getDiffDirect(),
                    "diff_wizard_result", source.getArguments().getDbType()); //$NON-NLS-1$
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
    private ComboViewer cmbDbType;
    private ComboViewer cmbTimezone;
    private CLabel lblWarnPosix;

    private Button btnNoPrivileges;
    private Button btnIgnoreColumnOrder;
    private Button btnEnableFuncDep;
    private Button btnSimplifyView;
    private Button btnUseGlobalIgnoreList;

    private Button btnScriptAddTransact;
    private Button btnCheckFuncBodies;
    private Button btnAlterColUsingExpr;
    private Button btnCreateIdxConcurrent;
    private Button btnConstraintNotValid;
    private Button btnScriptFromSelObjs;
    private Button btnGenerateExists;
    private Button btnDropBeforeCreate;
    private Button btnDataMovementMode;

    public PageDiff(String pageName, IPreferenceStore mainPrefs, PgDbProject proj) {
        super(pageName, pageName, null);

        this.mainPrefs = mainPrefs;
        this.proj = proj;
        setDescription(Messages.diffwizard_diffpage_select);
    }

    public DbSource getDbSource() {
        return dbSource.getDbSource(getSelectedDbType(), getOneTimePrefs());
    }

    public DbSource getDbTarget() {
        return dbTarget.getDbSource(getSelectedDbType(), getOneTimePrefs());
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

    public DatabaseType getSelectedDbType() {
        return (DatabaseType) cmbDbType.getStructuredSelection().getFirstElement();
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

        lblWarnPosix = new CLabel(container, SWT.NONE);
        lblWarnPosix.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnPosix.setText(Messages.ProjectProperties_posix_is_used_warn);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.exclude = true;
        lblWarnPosix.setLayoutData(gd);

        Composite compTz = new Composite(container, SWT.NONE);
        compTz.setLayout(new GridLayout(2, false));

        new Label(compTz, SWT.NONE).setText(Messages.DiffWizard_db_tz);

        cmbTimezone = new ComboViewer(compTz, SWT.DROP_DOWN | SWT.BORDER);
        cmbTimezone.setContentProvider(ArrayContentProvider.getInstance());
        cmbTimezone.setLabelProvider(new LabelProvider());
        cmbTimezone.setInput(UIConsts.TIME_ZONES);
        cmbTimezone.getCombo().setText(Consts.UTC);
        cmbTimezone.getCombo().addModifyListener(e -> timeZoneWarn());

        new Label(compTz, SWT.NONE).setText(Messages.database_type);
        cmbDbType = new ComboViewer(compTz, SWT.READ_ONLY);
        cmbDbType.setContentProvider(ArrayContentProvider.getInstance());
        cmbDbType.setInput(DatabaseType.values());
        cmbDbType.getCombo().select(0);
        cmbDbType.addSelectionChangedListener(e -> {
            StructuredSelection sel = (StructuredSelection) e.getSelection();
            DatabaseType selDbType = (DatabaseType) sel.getFirstElement();
            dbSource.filter(selDbType);
            dbTarget.filter(selDbType);
            getWizard().getContainer().updateButtons();
            getWizard().getContainer().updateMessage();
        });

        Button btnShowPrefs = new Button(container, SWT.CHECK);
        btnShowPrefs.setText(Messages.DiffWizard_show_advanced_options);
        btnShowPrefs.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean selected = btnShowPrefs.getSelection();
                btnNoPrivileges.setVisible(selected);
                btnIgnoreColumnOrder.setVisible(selected);
                btnEnableFuncDep.setVisible(selected);
                btnSimplifyView.setVisible(selected);
                btnUseGlobalIgnoreList.setVisible(selected);
                btnScriptAddTransact.setVisible(selected);
                btnCheckFuncBodies.setVisible(selected);
                btnAlterColUsingExpr.setVisible(selected);
                btnCreateIdxConcurrent.setVisible(selected);
                btnConstraintNotValid.setVisible(selected);
                btnScriptFromSelObjs.setVisible(selected);
                btnGenerateExists.setVisible(selected);
                btnDropBeforeCreate.setVisible(selected);
                btnDataMovementMode.setVisible(selected);

                UiSync.exec(getShell(), () -> getShell().pack());
            }
        });

        btnNoPrivileges = new Button(container, SWT.CHECK);
        btnNoPrivileges.setText(Messages.dbUpdatePrefPage_ignore_privileges);
        btnNoPrivileges.setSelection(mainPrefs.getBoolean(PREF.NO_PRIVILEGES));
        btnNoPrivileges.setVisible(false);

        btnIgnoreColumnOrder = new Button(container, SWT.CHECK);
        btnIgnoreColumnOrder.setText(Messages.GeneralPrefPage_ignore_column_order);
        btnIgnoreColumnOrder.setSelection(mainPrefs.getBoolean(PREF.IGNORE_COLUMN_ORDER));
        btnIgnoreColumnOrder.setVisible(false);

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

        btnConstraintNotValid = new Button(container, SWT.CHECK);
        btnConstraintNotValid.setText(Messages.ApplyCustomDialog_constraint_not_valid);
        btnConstraintNotValid.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID));
        btnConstraintNotValid.setVisible(false);

        btnScriptFromSelObjs = new Button(container, SWT.CHECK);
        btnScriptFromSelObjs.setText(Messages.DbUpdatePrefPage_script_from_selected_objs);
        btnScriptFromSelObjs.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS));
        btnScriptFromSelObjs.setVisible(false);
        btnGenerateExists = new Button(container, SWT.CHECK);
        btnGenerateExists.setText(Messages.DbUpdatePrefPage_option_if_exists);
        btnGenerateExists.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.GENERATE_EXISTS));
        btnGenerateExists.setVisible(false);

        btnDropBeforeCreate = new Button(container, SWT.CHECK);
        btnDropBeforeCreate.setText(Messages.DbUpdatePrefPage_option_drop_object);
        btnDropBeforeCreate.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_BEFORE_CREATE));
        btnDropBeforeCreate.setVisible(false);

        btnDataMovementMode = new Button(container, SWT.CHECK);
        btnDataMovementMode.setText(Messages.DbUpdatePrefPage_allow_data_movement);
        btnDataMovementMode.setSelection(mainPrefs.getBoolean(DB_UPDATE_PREF.DATA_MOVEMENT_MODE));
        btnDataMovementMode.setVisible(false);

        if (proj != null) {
            dbTarget.setDbStore(proj.getProject().getLocation().toFile());
        }

        setControl(container);
    }

    private void timeZoneWarn() {
        String tz = cmbTimezone.getCombo().getText();
        GridData data = (GridData) lblWarnPosix.getLayoutData();
        if ((!Consts.UTC.equals(tz)
                && tz.startsWith(Consts.UTC)) == data.exclude) {
            lblWarnPosix.setVisible(data.exclude);
            data.exclude = !data.exclude;
            lblWarnPosix.getParent().layout();
            UiSync.exec(getShell(), () -> getShell().pack());
        }
    }

    private DatabaseType getDbType(DbSourcePicker sourcePicer) {
        DbInfo dbInfo = sourcePicer.getSelectedDbInfo();
        if (dbInfo != null) {
            return dbInfo.getDbType();
        }
        return getSelectedDbType();
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
        } else if (getDbType(dbSource) != getDbType(dbTarget)) {
            err = Messages.DiffWizard_different_types;
        }

        boolean isPg = getDbType(dbSource) == DatabaseType.PG;
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
        oneTimePrefs.put(PREF.IGNORE_COLUMN_ORDER, btnIgnoreColumnOrder.getSelection());
        oneTimePrefs.put(PREF.ENABLE_BODY_DEPENDENCIES, btnEnableFuncDep.getSelection());
        oneTimePrefs.put(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, btnUseGlobalIgnoreList.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, btnCheckFuncBodies.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.USING_ON_OFF, btnAlterColUsingExpr.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY, btnCreateIdxConcurrent.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID, btnConstraintNotValid.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.GENERATE_EXISTS, btnGenerateExists.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.DROP_BEFORE_CREATE, btnDropBeforeCreate.getSelection());
        oneTimePrefs.put(PREF.SIMPLIFY_VIEW, btnSimplifyView.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS, btnScriptFromSelObjs.getSelection());
        oneTimePrefs.put(DB_UPDATE_PREF.DATA_MOVEMENT_MODE, btnDataMovementMode.getSelection());

        return oneTimePrefs;
    }

    @Override
    public void dispose() {
        dbSource.dispose();
        dbTarget.dispose();
        super.dispose();
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
