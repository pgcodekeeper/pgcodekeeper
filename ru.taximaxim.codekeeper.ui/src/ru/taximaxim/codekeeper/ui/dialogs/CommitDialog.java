/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.pgcodekeeper.core.api.PgCodeKeeperApi;
import org.pgcodekeeper.core.database.api.loader.ILoader;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.model.difftree.TreeFlattener;
import org.pgcodekeeper.core.settings.ISettings;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.settings.UISettings;

public final class CommitDialog extends TrayDialog {

    private final IPreferenceStore prefs;
    private final boolean egitCommitAvailable;
    private final boolean forceOverridesOnly;
    private final boolean initialOverrides;

    private final ILoader dbProject;
    private final ILoader dbRemote;
    private final TreeElement diffTree;
    private final Set<TreeElement> depcyElementsSet;
    private final PgDbProject proj;
    private Button btnAutocommit;
    private Button btnSaveOverrides;
    private Label warningLbl;

    public CommitDialog(Shell parentShell, Set<TreeElement> depcyElementsSet, ILoader dbProject, ILoader dbRemote,
            TreeElement diffTree, IPreferenceStore mainPrefs, boolean egitCommitAvailable, boolean forceOverridesOnly,
            boolean initialOverrides, PgDbProject proj) {
        super(parentShell);
        this.depcyElementsSet = depcyElementsSet;
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
        this.diffTree = diffTree;
        this.prefs = mainPrefs;
        this.egitCommitAvailable = egitCommitAvailable;
        this.forceOverridesOnly = forceOverridesOnly;
        this.initialOverrides = initialOverrides;
        this.proj = proj;

        setShellStyle(getShellStyle() & ~SWT.CLOSE);
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.commitPartDescr_commit_confirmation);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        Composite container = new Composite(area, SWT.NONE);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        container.setLayout(gl);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.commitPartDescr_the_following_changes_be_included_in_commit);

        Group gTop = new Group(container, SWT.NONE);
        gTop.setLayout(new GridLayout());
        GridData gd = new GridData(GridData.FILL_BOTH);
        gTop.setLayoutData(gd);
        gTop.setText(Messages.commitDialog_user_selected_elements);

        var dbType = DatabaseType.fromStatement(dbProject.getDatabase());
        ISettings settings = new UISettings(proj.getProject(), null);
        DiffTableViewer dtvTop = new DiffTableViewer(gTop, true, dbType, settings);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 300;
        gd.widthHint = 1000;
        dtvTop.setLayoutData(gd);

        dtvTop.setAutoExpand(true);
        List<TreeElement> result = new TreeFlattener().onlySelected().flatten(diffTree);
        dtvTop.setInputCollection(result, dbProject, dbRemote, Collections.emptySet());

        Group gBottom = new Group(container, SWT.NONE);
        gBottom.setLayout(new GridLayout());

        gd = new GridData(GridData.FILL_BOTH);
        gBottom.setLayoutData(gd);
        gBottom.setText(Messages.commitDialog_depcy_elements);

        DiffTableViewer dtvBottom = new DiffTableViewer(gBottom, false, dbType, settings);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 300;
        gd.widthHint = 1000;
        dtvBottom.setLayoutData(gd);

        // select all dependent elements for applying
        for (TreeElement el : depcyElementsSet) {
            el.setSelected(true);
        }
        dtvTop.setAutoExpand(true);
        dtvBottom.setInputCollection(depcyElementsSet, dbProject, dbRemote, Collections.emptySet());

        dtvBottom.addCheckStateListener(new ValidationCheckStateListener());
        warningLbl = new Label(gBottom, SWT.NONE);
        warningLbl.setText(Messages.CommitDialog_unchecked_objects_can_occur_unexpected_errors);
        warningLbl.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
        warningLbl.setVisible(false);

        btnAutocommit = new Button(container, SWT.CHECK);
        btnAutocommit.setText(Messages.commitPartDescr_show_commit_window);
        btnAutocommit.setSelection(prefs.getBoolean(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE));
        btnAutocommit.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                prefs.setValue(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE, btnAutocommit.getSelection());
            }
        });
        btnAutocommit.setEnabled(egitCommitAvailable);

        btnSaveOverrides = new Button(container, SWT.CHECK);
        btnSaveOverrides.setText(Messages.CommitDialog_save_privileges);
        btnSaveOverrides.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                checkState();
            }
        });

        btnSaveOverrides.setSelection(initialOverrides);

        return area;
    }

    @Override
    protected void okPressed() {
        getButton(IDialogConstants.OK_ID).setEnabled(false);
        getButton(IDialogConstants.CANCEL_ID).setEnabled(false);

        Log.log(Log.LOG_INFO, Messages.CommitDialog_updating_project.formatted(proj.getProjectName()));
        Job job = new JobProjectUpdater(Messages.projectEditorDiffer_save_project, btnSaveOverrides.getSelection());
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                Log.log(Log.LOG_INFO,
                        Messages.CommitDialog_project_updater_job_finished.formatted(event.getResult().getSeverity()));

                try {
                    proj.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
                } catch (CoreException e) {
                    ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_error_refreshing_project, e);
                }
                UiSync.exec(getShell(), () -> {
                    if (event.getResult().isOK()) {
                        setReturnCode(OK);
                        close();
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                        getButton(IDialogConstants.CANCEL_ID).setEnabled(true);
                        warningLbl.setText(event.getResult().getMessage());
                        warningLbl.getParent().layout();
                        warningLbl.setVisible(true);
                    }
                });
            }
        });

        job.setUser(true);
        job.schedule();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    private void checkState() {
        boolean showWarning = false;
        for (TreeElement el : depcyElementsSet) {
            if (!el.isSelected()) {
                switch (el.getSide()) {
                // being deleted
                case LEFT:
                    showWarning = hasSelectedParent(el);
                    break;
                // being created
                case RIGHT:
                    showWarning = el.isSubTreeSelected();
                    break;
                default:
                    break;
                }
                if (showWarning) {
                    break;
                }
            }
        }

        if (showWarning) {
            warningLbl.setText(Messages.CommitDialog_unchecked_objects_can_occur_unexpected_errors);
        } else if (forceOverridesOnly && !btnSaveOverrides.getSelection()) {
            showWarning = true;
            warningLbl.setText(Messages.CommitDialog_privileges_must_be_saved);
        }

        warningLbl.getParent().layout();
        warningLbl.setVisible(showWarning);
        getButton(OK).setEnabled(!showWarning);
    }

    private boolean hasSelectedParent(TreeElement el) {
        TreeElement parent = el.getParent();
        while (parent != null) {
            if (parent.isSelected()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /**
     * This class monitors element unchecking and validates the following: <br>
     * 1. Element is being deleted: if there are selected parents - show warning;
     * <br>
     * 2. Element is being created: if there are selected children - show warning
     *
     * @author botov_av
     */
    private class ValidationCheckStateListener implements ICheckStateListener {

        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            checkState();
        }
    }

    private class JobProjectUpdater extends Job {

        private final boolean isOverridesOnly;

        JobProjectUpdater(String name, boolean isOverridesOnly) {
            super(name);
            this.isOverridesOnly = isOverridesOnly;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            SubMonitor pm = SubMonitor.convert(monitor, Messages.commitPartDescr_commiting, 2);

            Log.log(Log.LOG_INFO, Messages.CommitDialog_applying_diff_tree_to_db);
            pm.newChild(1).subTask(Messages.commitPartDescr_modifying_db_model); // 1
            pm.newChild(1).subTask(Messages.commitPartDescr_exporting_db_model); // 2

            try {
                List<TreeElement> checked = new TreeFlattener().onlySelected()
                        .onlyEdits(dbProject.getDatabase(), dbRemote.getDatabase()).flatten(diffTree);

                var provider = DatabaseType.fromStatement(dbProject.getDatabase()).getDatabaseProvider();
                var settings = new UISettings(proj.getProject(), null);
                PgCodeKeeperApi.exportToProject(provider, dbProject.getDatabase(), dbRemote.getDatabase(),
                        checked, proj.getPathToProject(), isOverridesOnly, settings);

                monitor.done();
            } catch (IOException e) {
                return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.ProjectEditorDiffer_commit_error, e);
            }
            return Status.OK_STATUS;
        }
    }

}