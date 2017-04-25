package ru.taximaxim.codekeeper.ui.editors;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.osgi.service.prefs.BackingStoreException;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyTreeExtender;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PERSPECTIVE;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPresentationPane;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.DepcyFromPSQLOutput;

public class ProjectEditorDiffer extends EditorPart implements IResourceChangeListener {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private ProjectEditorInput input;
    private PgDbProject proj;
    private ProjectEditorSelectionProvider sp;
    private DiffPresentationPane commit;

    private Composite parent;

    public ProjectEditorSelectionProvider getSelectionProvider() {
        return sp;
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof ProjectEditorInput)) {
            throw new PartInitException(Messages.ProjectEditorDiffer_error_bad_input_type);
        }
        this.input = (ProjectEditorInput) input;
        Exception ex = this.input.getError();
        if (ex != null) {
            throw new PartInitException(this.input.getError().getLocalizedMessage(), ex);
        }

        proj = new PgDbProject(this.input.getProject());
        sp = new ProjectEditorSelectionProvider(proj.getProject());
        setPartName(this.input.getName());

        // message box
        if(!site.getPage().getPerspective().getId().equals(PERSPECTIVE.MAIN)){
            askPerspectiveChange(site);
        }
        setSite(site);
        setInput(input);
    }

    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;
        commit = new CommitPage(parent, mainPrefs, proj, this);

        getSite().setSelectionProvider(sp);

        ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
                IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE
                | IResourceChangeEvent.POST_CHANGE);
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void setFocus() {
        // no imp
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        // no impl
    }

    @Override
    public void doSaveAs() {
        // no impl
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        super.dispose();
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE:
        case IResourceChangeEvent.PRE_DELETE:
            handlerCloseProject(event);
            break;
        case IResourceChangeEvent.POST_CHANGE:
            handleChangeProject(event);
            break;
        default:
            break;
        }
    }

    private void handlerCloseProject(IResourceChangeEvent event) {
        if (event.getResource().getName().equals(getEditorInput().getName())) {
            UiSync.exec(parent, new Runnable(){

                @Override
                public void run() {
                    if (!parent.isDisposed()) {
                        getSite().getPage().closeEditor(ProjectEditorDiffer.this, true);
                    }
                }
            });
        }
    }

    private void handleChangeProject(IResourceChangeEvent event) {
        IResourceDelta rootDelta = event.getDelta();

        ApgdiffConsts.WORK_DIR_NAMES[] dirs = ApgdiffConsts.WORK_DIR_NAMES.values();
        final IPath[] projDirs = new IPath[dirs.length];
        for (int i = 0; i < dirs.length; ++i) {
            projDirs[i] = proj.getProject().getFullPath().append(dirs[i].name());
        }

        final boolean[] schemaChanged = new boolean[1];
        try {
            rootDelta.accept(new IResourceDeltaVisitor() {

                @Override
                public boolean visit(IResourceDelta delta) throws CoreException {
                    if (schemaChanged[0]) {
                        return false;
                    }
                    if (delta.getFlags() != IResourceDelta.MARKERS &&
                            delta.getResource().getType() == IResource.FILE) {
                        // something other than just markers has changed
                        for (IPath dir : projDirs) {
                            // check that it's our resource
                            if (dir.isPrefixOf(delta.getFullPath())) {
                                schemaChanged[0] = true;
                                return false;
                            }
                        }
                    }
                    return true;
                }
            });
        } catch (CoreException ex) {
            Log.log(ex);
        }

        if (schemaChanged[0]) {
            UiSync.exec(parent, () -> {
                commit.notifyProjectChanged();
            });
        }
    }

    public void getChanges() {
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), parent.getShell(), true)) {
            return;
        }
        try {
            DbSource dbRemote = commit.getRemoteDbSource();
            if (dbRemote != null) {
                DbSource dbProject = DbSource.fromProject(proj);
                commit.reset();
                commit.hideNotificationArea();
                loadChanges(dbProject, dbRemote);
                commit.saveDbPrefs();
            }
        } catch (CoreException e1) {
            ExceptionNotifier.notifyDefault(
                    Messages.DiffPresentationPane_error_loading_changes, e1);
        } catch (BackingStoreException e1) {
            ExceptionNotifier.notifyDefault(
                    Messages.DiffPresentationPane_cannotSaveDbPropToProjProps, e1);
        }
    }

    private void loadChanges(final DbSource dbProject, final DbSource dbRemote) {
        Log.log(Log.LOG_INFO, "Getting changes for diff"); //$NON-NLS-1$
        final TreeDiffer newDiffer = new TreeDiffer(dbProject, dbRemote, true);
        Job job = new Job(Messages.diffPresentationPane_getting_changes_for_diff) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    SubMonitor sub = SubMonitor.convert(monitor,
                            Messages.diffPresentationPane_getting_changes_for_diff, 100);
                    proj.getProject().refreshLocal(IResource.DEPTH_INFINITE, sub.newChild(10));

                    PgDiffUtils.checkCancelled(monitor);
                    sub.subTask(Messages.diffPresentationPane_getting_changes_for_diff);
                    newDiffer.run(sub.newChild(90));
                    monitor.done();
                } catch (InvocationTargetException | CoreException e) {
                    return new Status(Status.ERROR, PLUGIN_ID.THIS,
                            Messages.error_in_differ_thread, e);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    UiSync.exec(parent, new Runnable() {

                        @Override
                        public void run() {
                            if (commit.isDisposed()) {
                                return;
                            }
                            commit.setInput(dbProject, dbRemote, newDiffer.getDiffTree());
                        }
                    });
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }

    private void askPerspectiveChange(IEditorSite site) {
        String mode = mainPrefs.getString(PG_EDIT_PREF.PERSPECTIVE_CHANGING_STATUS);
        // if select "YES" with toggle
        if (mode.equals(MessageDialogWithToggle.ALWAYS)){
            changePerspective(site);
            // if not select "NO" with toggle, show choice message dialog
        } else if (!mode.equals(MessageDialogWithToggle.NEVER)){
            MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(site.getShell(),
                    Messages.change_perspective_title, Messages.change_perspective_message,
                    Messages.remember_choice_toggle, false, mainPrefs, PG_EDIT_PREF.PERSPECTIVE_CHANGING_STATUS);
            if(dialog.getReturnCode() == IDialogConstants.YES_ID){
                changePerspective(site);
            }
        }
    }

    private void changePerspective(IEditorSite site) {
        //change perspective to pgCodeKeeper
        try {
            site.getWorkbenchWindow().getWorkbench().showPerspective(PERSPECTIVE.MAIN,
                    site.getWorkbenchWindow());
        } catch (WorkbenchException e) {
            Log.log(Log.LOG_ERROR, "Can't change perspective", e); //$NON-NLS-1$
        }
    }
}

class CommitPage extends DiffPresentationPane {

    private Button btnSave, btnGetLatest, btnAddDepcy;
    private boolean isCommitCommandAvailable;
    private List<Entry<PgStatement, PgStatement>> manualDepciesSource = new LinkedList<>();
    private List<Entry<PgStatement, PgStatement>> manualDepciesTarget = new LinkedList<>();

    public CommitPage(Composite parent, IPreferenceStore mainPrefs, PgDbProject proj,
            ProjectEditorDiffer projEditor) {
        super(parent, mainPrefs, proj, projEditor);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, HELP.MAIN_EDITOR);
    }

    @Override
    protected void createUpperContainer(final Composite container, GridLayout gl) {
        gl.numColumns = 4;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        btnSave = new Button(container, SWT.PUSH);
        btnSave.setText(Messages.commitPartDescr_commit);
        btnSave.setEnabled(false);
        btnSave.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    commit();
                } catch (PgCodekeeperException ex) {
                    ExceptionNotifier.notifyDefault(Messages.error_creating_dependency_graph, ex);
                }
            }
        });

        btnGetLatest = new Button(container, SWT.PUSH);
        btnGetLatest.setText(Messages.diffPartDescr_get_latest);
        btnGetLatest.setEnabled(false);
        btnGetLatest.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                diff();
            }
        });

        btnAddDepcy = new Button(container, SWT.PUSH);
        btnAddDepcy.setText(Messages.diffPartDescr_add_dependencies);
        btnAddDepcy.setEnabled(false);
        btnAddDepcy.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ManualDepciesDialog dialog = new ManualDepciesDialog(getShell(),
                        manualDepciesSource, manualDepciesTarget,
                        PgDatabase.listPgObjects(dbRemote.getDbObject()),
                        PgDatabase.listPgObjects(dbProject.getDbObject()),
                        Messages.database, Messages.ProjectEditorDiffer_project);
                if (dialog.open() == Dialog.OK) {
                    manualDepciesSource = dialog.getDepciesSourceList();
                    manualDepciesTarget = dialog.getDepciesTargetList();
                }
            }
        });

        ICommandService commandService =
                PlatformUI.getWorkbench().getService(ICommandService.class);
        @SuppressWarnings("unchecked")
        Collection<String> commandIds = commandService.getDefinedCommandIds();
        isCommitCommandAvailable = commandIds.contains(COMMAND.COMMIT_COMMAND_ID);
    }

    private void diff() {
        Log.log(Log.LOG_INFO, "Started DB update"); //$NON-NLS-1$
        if (warnCheckedElements() < 1 ||
                !OpenProjectUtils.checkVersionAndWarn(proj.getProject(), getShell(), true)) {
            return;
        }

        IEclipsePreferences pref = proj.getPrefs();
        final Differ differ = new Differ(dbRemote.getDbObject(),
                dbProject.getDbObject(), diffTree.getRevertedCopy(), false,
                pref.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC));
        differ.setAdditionalDepciesSource(manualDepciesSource);
        differ.setAdditionalDepciesTarget(manualDepciesTarget);

        Job job = differ.getDifferJob();
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                Log.log(Log.LOG_INFO, "Differ job finished with status " +  //$NON-NLS-1$
                        event.getResult().getSeverity());
                if (event.getResult().isOK()) {
                    UiSync.exec(CommitPage.this, new Runnable() {

                        @Override
                        public void run() {
                            if (CommitPage.this.isDisposed()) {
                                return;
                            }
                            try {
                                showEditor(differ);
                            } catch (PartInitException ex) {
                                ExceptionNotifier.notifyDefault(
                                        Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
                            }
                        }
                    });
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }

    private void showEditor(Differ differ) throws PartInitException {
        DepcyFromPSQLOutput input = new DepcyFromPSQLOutput(differ, proj,
                PgDatabase.listPgObjects(dbRemote.getDbObject()));
        input.setDbinfo(storePicker.getDbInfo());
        projEditor.getSite().getPage().openEditor(input, EDITOR.ROLLON);
    }

    private void commit() throws PgCodekeeperException {
        Log.log(Log.LOG_INFO, "Started project update"); //$NON-NLS-1$
        if (warnCheckedElements() < 1 ||
                !OpenProjectUtils.checkVersionAndWarn(proj.getProject(), getShell(), true)) {
            return;
        }

        boolean considerDepcy = mainPrefs.getBoolean(COMMIT_PREF.CONSIDER_DEPCY_IN_COMMIT);
        Set<TreeElement> sumNewAndDelete = null;
        if(considerDepcy){
            Log.log(Log.LOG_INFO, "Processing depcies for project update"); //$NON-NLS-1$
            sumNewAndDelete = new DepcyTreeExtender(dbProject.getDbObject(),
                    dbRemote.getDbObject(), diffTree).getDepcies();
        }

        Log.log(Log.LOG_INFO, "Querying user for project update"); //$NON-NLS-1$
        // display commit dialog
        CommitDialog cd = new CommitDialog(getShell(), sumNewAndDelete, dbProject, dbRemote,
                diffTree, mainPrefs, isCommitCommandAvailable);
        if (cd.open() != CommitDialog.OK) {
            return;
        }

        Log.log(Log.LOG_INFO, "Updating project " + proj.getProjectName()); //$NON-NLS-1$
        Job job = new JobProjectUpdater(Messages.projectEditorDiffer_save_project, diffTree);
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                Log.log(Log.LOG_INFO, "Project updater job finished with status " + //$NON-NLS-1$
                        event.getResult().getSeverity());
                if (event.getResult().isOK()) {
                    ConsoleFactory.write(Messages.commitPartDescr_success_project_updated);
                    try {
                        proj.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
                        UiSync.exec(CommitPage.this, new Runnable() {

                            @Override
                            public void run() {
                                if (!CommitPage.this.isDisposed()) {
                                    callEgitCommitCommand();
                                }
                            }
                        });
                    } catch (CoreException e) {
                        ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_error_refreshing_project, e);
                    }
                }
            }
        });

        job.setUser(true);
        job.schedule();
    }

    /**
     * Programmatically selects this editor's project in either of Project/Package explorer
     * (if any open) and calls EGIT commit command
     * (see org.eclipse.egit.ui.internal.actions.ActionCommands.COMMIT_ACTION).
     * <br><br>
     * Should be called strictly from the UI thread, otherwise NPE is thrown.
     */
    private void callEgitCommitCommand(){
        if (!isCommitCommandAvailable || !mainPrefs.getBoolean(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE)){
            return;
        }

        try {
            projEditor.getSite().getSelectionProvider().setSelection(new StructuredSelection(proj.getProject()));
            projEditor.getSite().getService(IHandlerService.class).executeCommand(COMMAND.COMMIT_COMMAND_ID, null);
        } catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
            Log.log(Log.LOG_WARNING, "Could not execute command " + COMMAND.COMMIT_COMMAND_ID, e); //$NON-NLS-1$
            ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_failed_egit_commit, e);
        }
    }

    @Override
    public final void reset() {
        btnSave.setEnabled(false);
        btnGetLatest.setEnabled(false);
        btnAddDepcy.setEnabled(false);
        manualDepciesSource.clear();
        manualDepciesTarget.clear();
        super.reset();
    }

    @Override
    public void setInput(DbSource dbProject, DbSource dbRemote, TreeElement diffTree) {
        super.setInput(dbProject, dbRemote, diffTree);
        if (diffTree != null) {
            btnSave.setEnabled(true);
            btnGetLatest.setEnabled(true);
            btnAddDepcy.setEnabled(true);
            manualDepciesSource.clear();
            manualDepciesTarget.clear();
        }
    }

    private class JobProjectUpdater extends Job {

        private final TreeElement tree;

        JobProjectUpdater(String name, TreeElement tree) {
            super(name);
            this.tree = tree;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            SubMonitor pm = SubMonitor.convert(
                    monitor, Messages.commitPartDescr_commiting, 2);

            Log.log(Log.LOG_INFO, "Applying diff tree to db"); //$NON-NLS-1$
            pm.newChild(1).subTask(Messages.commitPartDescr_modifying_db_model); // 1
            pm.newChild(1).subTask(Messages.commitPartDescr_exporting_db_model); // 2

            try {
                Collection<TreeElement> checked = new TreeFlattener()
                        .onlySelected()
                        .onlyEdits(dbProject.getDbObject(), dbRemote.getDbObject())
                        .flatten(tree);
                new ProjectUpdater(dbRemote.getDbObject(), dbProject.getDbObject(),
                        checked, proj).updatePartial();
                monitor.done();
            } catch (IOException | CoreException e) {
                return new Status(Status.ERROR, PLUGIN_ID.THIS,
                        Messages.ProjectEditorDiffer_commit_error, e);
            }
            if (monitor.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
            return Status.OK_STATUS;
        }
    }
}