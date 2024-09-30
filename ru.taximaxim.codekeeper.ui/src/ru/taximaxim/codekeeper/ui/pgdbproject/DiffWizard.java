/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
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
import ru.taximaxim.codekeeper.ui.prefs.FieldEditorStore;
import ru.taximaxim.codekeeper.ui.prefs.TempBooleanFieldEditor;
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
        setDefaultPageImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.APP_WIZ));
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
                MessageBox mb = new MessageBox(getContainer().getShell(), SWT.ERROR);
                mb.setText(Messages.error_in_differ_thread);
                mb.setMessage(ex.getLocalizedMessage());
                mb.open();
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
            AbstractDatabase source = treediffer.getDbSource().getDbObject();

            Differ differ = new Differ(source, treediffer.getDbTarget().getDbObject(),
                    treediffer.getDiffTree(), false, pageDiff.getTimezone(),
                    source.getArguments().getDbType(), null, pageDiff.getOneTimePrefs());
            getContainer().run(true, true, differ);

            FileUtilsUi.saveOpenTmpSqlEditor(differ.getDiffDirect(), "diff_wizard_result", //$NON-NLS-1$
                    source.getArguments().getDbType());
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

    private FieldEditorStore fieldEditorStore;

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
        if (fieldEditorStore.getValue(PROJ_PREF.USE_GLOBAL_IGNORE_LIST)) {
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
        cmbDbType.setLabelProvider(UIConsts.DATABASE_TYPE_PROVIDER);
        cmbDbType.setInput(DatabaseType.values());
        cmbDbType.addSelectionChangedListener(e -> {
            StructuredSelection sel = (StructuredSelection) e.getSelection();
            DatabaseType selDbType = (DatabaseType) sel.getFirstElement();
            dbSource.filter(selDbType);
            dbTarget.filter(selDbType);
            getWizard().getContainer().updateButtons();
            getWizard().getContainer().updateMessage();
        });
        cmbDbType.setSelection(new StructuredSelection(DatabaseType.PG));

        Button btnShowPrefs = new Button(container, SWT.CHECK);
        btnShowPrefs.setText(Messages.DiffWizard_show_advanced_options);
        btnShowPrefs.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean selected = btnShowPrefs.getSelection();
                fieldEditorStore.setVisible(selected);
                UiSync.exec(getShell(), () -> getShell().pack());
            }
        });

        fieldEditorStore = new FieldEditorStore();

        fieldEditorStore.add(new TempBooleanFieldEditor(PREF.NO_PRIVILEGES,
                Messages.dbUpdatePrefPage_ignore_privileges, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(PREF.IGNORE_COLUMN_ORDER,
                Messages.GeneralPrefPage_ignore_column_order, container, mainPrefs::getBoolean));
        var bodyDepBtn = new TempBooleanFieldEditor(PREF.ENABLE_BODY_DEPENDENCIES,
                Messages.GeneralPrefPage_enable_body_dependencies, container, mainPrefs::getBoolean);
        bodyDepBtn.setToolTipText(Messages.GeneralPrefPage_body_depcy_tooltip);
        fieldEditorStore.add(bodyDepBtn);
        fieldEditorStore.add(new TempBooleanFieldEditor(PREF.SIMPLIFY_VIEW,
                Messages.GeneralPrefPage_simplify_view, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(PROJ_PREF.USE_GLOBAL_IGNORE_LIST,
                Messages.ProjectProperties_use_global_ignore_list, container, true));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION,
                Messages.DbUpdatePrefPage_script_add_transaction, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY,
                Messages.ApplyCustomDialog_constraint_not_valid, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS,
                Messages.DbUpdatePrefPage_script_from_selected_objs, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.GENERATE_EXISTS,
                Messages.DbUpdatePrefPage_option_if_exists, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.DROP_BEFORE_CREATE,
                Messages.DbUpdatePrefPage_option_drop_object, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.DATA_MOVEMENT_MODE,
                Messages.DbUpdatePrefPage_allow_data_movement, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES,
                Messages.dbUpdatePrefPage_check_function_bodies, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.USING_ON_OFF,
                Messages.dbUpdatePrefPage_switch_on_off_using, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID,
                Messages.dbUpdatePrefPage_check_function_bodies, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK,
                Messages.DbUpdatePrefPage_generate_exist_do_block, container, mainPrefs::getBoolean));
        fieldEditorStore.add(new TempBooleanFieldEditor(DB_UPDATE_PREF.COMMENTS_TO_END,
                Messages.DbUpdatePrefPage_comments_to_end, container, mainPrefs::getBoolean));

        fieldEditorStore.setVisible(false);

        if (proj != null) {
            dbTarget.setDbStore(proj.getProject().getLocation().toFile());
        }

        setControl(container);
    }

    private void timeZoneWarn() {
        String tz = cmbTimezone.getCombo().getText();
        GridData data = (GridData) lblWarnPosix.getLayoutData();
        if ((!Consts.UTC.equals(tz) && tz.startsWith(Consts.UTC)) == data.exclude) {
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

        setErrorMessage(err);
        return err == null;
    }

    @Override
    public void handleEvent(Event event) {
        getWizard().getContainer().updateButtons();
        getWizard().getContainer().updateMessage();
    }

    public Map<String, Boolean> getOneTimePrefs() {
        return fieldEditorStore.getPrefs();
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
