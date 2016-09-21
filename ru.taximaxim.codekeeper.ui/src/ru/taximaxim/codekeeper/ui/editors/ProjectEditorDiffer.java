package ru.taximaxim.codekeeper.ui.editors;

import java.io.IOException;
import java.util.ArrayList;
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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.MultiPageEditorPart;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyTreeExtender;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DiffPresentationPane;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.DepcyFromPSQLOutput;

public class ProjectEditorDiffer extends MultiPageEditorPart implements IResourceChangeListener {

    private PgDbProject proj;
    private DiffPresentationPane commit, diff;
    private Image iCommit, iDiff;

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof ProjectEditorInput)) {
            throw new PartInitException(Messages.ProjectEditorDiffer_error_bad_input_type);
        }

        ProjectEditorInput in = (ProjectEditorInput) input;
        Exception ex = in.getError();
        if (ex != null) {
            throw new PartInitException(in.getError().getLocalizedMessage(), ex);
        }
        this.proj = new PgDbProject(in.getProject());
        setPartName(in.getName());
        super.init(site, input);
    }

    @Override
    protected void createPages() {
        int i;

        iCommit = ImageDescriptor.createFromURL(Activator.getContext().
                getBundle().getResource(FILE.ICONBALLBLUE)).createImage();
        commit = new CommitPage(getContainer(),
                Activator.getDefault().getPreferenceStore(), proj, this);
        i = addPage(commit);
        setPageText(i, Messages.ProjectEditorDiffer_page_text_commit);
        setPageImage(i, iCommit);

        iDiff = ImageDescriptor.createFromURL(Activator.getContext().
                getBundle().getResource(FILE.ICONBALLRED)).createImage();
        diff = new DiffPage(getContainer(),
                Activator.getDefault().getPreferenceStore(), proj);
        i = addPage(diff);
        setPageText(i, Messages.ProjectEditorDiffer_page_text_diff);
        setPageImage(i, iDiff);

        final ProjectEditorSelectionProvider sp = new ProjectEditorSelectionProvider(proj.getProject());
        ISelectionChangedListener selectionListener = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                sp.fireSelectionChanged(event);
            }
        };
        ISelectionChangedListener postSelectionListener = new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                sp.firePostSelectionChanged(event);
            }
        };
        diff.getDiffTable().getViewer().addSelectionChangedListener(selectionListener);
        diff.getDiffTable().getViewer().addPostSelectionChangedListener(postSelectionListener);
        commit.getDiffTable().getViewer().addSelectionChangedListener(selectionListener);
        commit.getDiffTable().getViewer().addPostSelectionChangedListener(postSelectionListener);
        getSite().setSelectionProvider(sp);

        ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
                IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE
                | IResourceChangeEvent.POST_CHANGE);
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);

        super.dispose();
        iCommit.dispose();
        iDiff.dispose();
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
        }
    }

    private void handlerCloseProject(IResourceChangeEvent event) {
        if (event.getResource().getName().equals(getEditorInput().getName())) {
            UiSync.exec(getContainer(), new Runnable(){

                @Override
                public void run() {
                    if (!getContainer().isDisposed()) {
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
                    int flags = delta.getFlags();
                    if (flags != 0 && flags != IResourceDelta.MARKERS) {
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
            UiSync.exec(getContainer(), new Runnable() {

                @Override
                public void run() {
                    if (!commit.isDisposed()) {
                        commit.reset();
                    }
                    if (!diff.isDisposed()) {
                        diff.reset();
                    }
                }
            });
        }
    }
}

class CommitPage extends DiffPresentationPane {

    private final ProjectEditorDiffer editor;
    private boolean isCommitCommandAvailable;

    private Button btnSave;

    public CommitPage(Composite parent, IPreferenceStore mainPrefs, PgDbProject proj,
            ProjectEditorDiffer editor) {
        super(parent, true, mainPrefs, proj);
        this.editor = editor;

        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, HELP.MAIN_EDITOR);
    }

    @Override
    protected void createUpperContainer(final Composite container, GridLayout gl) {
        gl.numColumns = 3;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        if (mainPrefs.getBoolean(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_IS_BACKLIGHT)){
            String rgb = mainPrefs.getString(PG_EDIT_PREF.PRJ_UPDATE_EDITOR_BACKLIGHT);
            String[] colors = rgb.split(","); //$NON-NLS-1$
            setTitleColor(new RGB(
                    Integer.parseInt(colors[0]),
                    Integer.parseInt(colors[1]),
                    Integer.parseInt(colors[2])));
        } else {
            setTitleColor(null);
        }
        new Label(container, SWT.NONE).setImage(lrm.createImage(
                ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                        .getResource(FILE.ICONBALLBLUE))));

        btnSave = new Button(container, SWT.PUSH);
        btnSave.setText(Messages.commitPartDescr_commit);
        btnSave.setEnabled(false);
        btnSave.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    commit();
                } catch (PgCodekeeperException | PgCodekeeperUIException ex) {
                    ExceptionNotifier.notifyDefault(Messages.error_creating_dependency_graph, ex);
                }
            }
        });

        ICommandService commandService =
                PlatformUI.getWorkbench().getService(ICommandService.class);
        @SuppressWarnings("unchecked")
        Collection<String> commandIds = commandService.getDefinedCommandIds();
        isCommitCommandAvailable = commandIds.contains(COMMAND.COMMIT_COMMAND_ID);
    }

    private void commit() throws PgCodekeeperException, PgCodekeeperUIException {
        Log.log(Log.LOG_INFO, "Started project update"); //$NON-NLS-1$
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), getShell(), true)) {
            return;
        }
        if (diffTable.getCheckedElementsCount() < 1){
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
            return;
        }
        boolean considerDepcy = mainPrefs.getBoolean(COMMIT_PREF.CONSIDER_DEPCY_IN_COMMIT);

        final TreeElement tblInputTree = treeDiffer.getDiffTree();
        Set<TreeElement> sumNewAndDelete = null;

        if(considerDepcy){
            Log.log(Log.LOG_INFO, "Processing depcies for project update"); //$NON-NLS-1$
            sumNewAndDelete = new DepcyTreeExtender(dbSource.getDbObject(),
                    dbTarget.getDbObject(), tblInputTree).getDepcies();
        }

        Log.log(Log.LOG_INFO, "Querying user for project update"); //$NON-NLS-1$
        // display commit dialog
        CommitDialog cd = new CommitDialog(getShell(), sumNewAndDelete,
                mainPrefs, treeDiffer, isCommitCommandAvailable);
        if (cd.open() != CommitDialog.OK) {
            return;
        }

        Log.log(Log.LOG_INFO, "Updating project " + proj.getProjectName()); //$NON-NLS-1$
        Job job = new JobProjectUpdater(Messages.projectEditorDiffer_save_project, tblInputTree);
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
            // in case user switched to a different window while update was working
            editor.getSite().getPage().activate(editor);
            editor.getSite().getService(IHandlerService.class)
            .executeCommand(COMMAND.COMMIT_COMMAND_ID, null);
        } catch (ExecutionException | NotDefinedException | NotEnabledException
                | NotHandledException e) {
            Log.log(Log.LOG_WARNING, "Could not execute command " + COMMAND.COMMIT_COMMAND_ID, e); //$NON-NLS-1$
        }
    }

    @Override
    public final void reset() {
        btnSave.setEnabled(false);
        super.reset();
    }

    @Override
    protected final void diffLoaded() {
        btnSave.setEnabled(true);
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
                Collection<TreeElement> checked = tree.flattenAlteredElements(
                        new ArrayList<TreeElement>(),
                        dbSource.getDbObject(), dbTarget.getDbObject(),
                        true, null);
                new ProjectUpdater(dbTarget.getDbObject(), dbSource.getDbObject(), checked, proj)
                .updatePartial();
                pm.done();
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

class DiffPage extends DiffPresentationPane {

    private Button btnGetLatest, btnAddDepcy;

    /**
     * A collection of manually added object dependencies.
     * Keys are dependants, values are lists of dependencies.
     */
    private List<Entry<PgStatement, PgStatement>> manualDepciesSource = new LinkedList<>();
    private List<Entry<PgStatement, PgStatement>> manualDepciesTarget = new LinkedList<>();

    public DiffPage(Composite parent, IPreferenceStore mainPrefs, PgDbProject proj) {
        super(parent, false, mainPrefs, proj);
    }

    @Override
    protected void createUpperContainer(Composite container, GridLayout gl) {
        gl.numColumns = 3;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        if (mainPrefs.getBoolean(PG_EDIT_PREF.DB_UPDATE_EDITOR_IS_BACKLIGHT)){
            String rgb = mainPrefs.getString(PG_EDIT_PREF.DB_UPDATE_EDITOR_BACKLIGHT);
            String[] colors = rgb.split(","); //$NON-NLS-1$
            setTitleColor(new RGB(
                    Integer.parseInt(colors[0]),
                    Integer.parseInt(colors[1]),
                    Integer.parseInt(colors[2])));
        } else {
            setTitleColor(null);
        }

        new Label(container, SWT.NONE).setImage(lrm.createImage(
                ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                        .getResource(FILE.ICONBALLRED))));

        btnGetLatest = new Button(container, SWT.PUSH);
        btnGetLatest.setText(Messages.diffPartDescr_get_latest);
        btnGetLatest.setEnabled(false);
        btnGetLatest.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    diff();
                } catch (PgCodekeeperUIException e1) {
                    ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_diff_error, e1);
                }
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
                        PgDatabase.listViewsTables(dbSource.getDbObject()),
                        PgDatabase.listViewsTables(dbTarget.getDbObject()),
                        Messages.database, Messages.ProjectEditorDiffer_project);
                if (dialog.open() == Dialog.OK) {
                    manualDepciesSource = dialog.getDepciesSourceList();
                    manualDepciesTarget = dialog.getDepciesTargetList();
                }
            }
        });
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, HELP.MAIN_EDITOR);
    }

    private void diff() throws PgCodekeeperUIException {
        Log.log(Log.LOG_INFO, "Started DB update"); //$NON-NLS-1$
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), getShell(), true)) {
            return;
        }
        if (diffTable.getCheckedElementsCount() < 1){
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
            return;
        }
        final TreeElement filtered = treeDiffer.getDiffTree();

        IEclipsePreferences pref = proj.getPrefs();
        final Differ differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                filtered, false,
                pref.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC),
                pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true));
        differ.setAdditionalDepciesSource(manualDepciesSource);
        differ.setAdditionalDepciesTarget(manualDepciesTarget);

        Job job = differ.getDifferJob();
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                Log.log(Log.LOG_INFO, "Differ job finished with status " +  //$NON-NLS-1$
                        event.getResult().getSeverity());
                if (event.getResult().isOK()) {
                    UiSync.exec(DiffPage.this, new Runnable() {

                        @Override
                        public void run() {
                            if (DiffPage.this.isDisposed()) {
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
        List<PgStatement> list = PgDatabase.listViewsTables(dbSource.getDbObject());
        DepcyFromPSQLOutput input = new DepcyFromPSQLOutput(differ, proj,
                list);
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .openEditor(input, EDITOR.ROLLON);
    }

    @Override
    public final void reset() {
        setButtonsClearDepcies(false);
        super.reset();
    }

    @Override
    protected final void diffLoaded() {
        setButtonsClearDepcies(true);
    }

    private void setButtonsClearDepcies(boolean state) {
        btnGetLatest.setEnabled(state);
        btnAddDepcy.setEnabled(state);
        manualDepciesSource.clear();
        manualDepciesTarget.clear();
    }
}
