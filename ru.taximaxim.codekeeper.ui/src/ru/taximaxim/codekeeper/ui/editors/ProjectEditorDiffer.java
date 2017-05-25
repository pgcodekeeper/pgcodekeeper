package ru.taximaxim.codekeeper.ui.editors;

import java.io.File;
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
import org.eclipse.core.runtime.Path;
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
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.service.prefs.BackingStoreException;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyTreeExtender;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PERSPECTIVE;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPaneViewer;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.sqledit.DepcyFromPSQLOutput;
import ru.taximaxim.codekeeper.ui.views.DBPair;

public class ProjectEditorDiffer extends EditorPart implements IResourceChangeListener {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private ProjectEditorInput input;
    private PgDbProject proj;
    private ProjectEditorSelectionProvider sp;
    private Composite parent;

    private DbInfo lastRemote;
    private DbSource dbProject, dbRemote;
    private TreeElement diffTree;

    private Composite containerUpper;
    private Composite contNotifications;
    private Label lblNotificationText;
    private Button btnDismissRefresh;

    private DbStorePicker storePicker;
    private Button btnGetChanges;
    private DiffTableViewer diffTable;
    private DiffPaneViewer diffPane;

    private LocalResourceManager lrm;
    private Button btnSave, btnGetLatest, btnAddDepcy;
    private boolean isCommitCommandAvailable;
    private List<Entry<PgStatement, PgStatement>> manualDepciesSource = new LinkedList<>();
    private List<Entry<PgStatement, PgStatement>> manualDepciesTarget = new LinkedList<>();

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
        getSite().setSelectionProvider(sp);
    }

    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;

        parent.setLayout(new GridLayout());
        lrm = new LocalResourceManager(JFaceResources.getResources(), parent);

        // notifications container
        // simplified for 1 static notification
        // refactor into multiple child composites w/ description class
        // for multiple dynamic notifications if necessary
        contNotifications = new Group(parent, SWT.BORDER);
        contNotifications.setLayout(new GridLayout(4, false));

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        contNotifications.setVisible(false);
        contNotifications.setLayoutData(gd);

        Label lblWarnIcon = new Label(contNotifications, SWT.NONE);
        lblWarnIcon.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJS_WARN_TSK));
        lblWarnIcon.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        Label lblNotification = new Label(contNotifications, SWT.NONE);
        lblNotification.setText(Messages.DiffPresentationPane_attention);
        lblNotification.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        lblNotification.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
        lblNotification.setFont(lrm.createFont(FontDescriptor.createFrom(
                lblNotification.getFont()).withStyle(SWT.BOLD).increaseHeight(2)));

        lblNotificationText = new Label(contNotifications, SWT.NONE);
        lblNotificationText.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        btnDismissRefresh = new Button(contNotifications, SWT.PUSH | SWT.FLAT);
        btnDismissRefresh.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONCLOSE))));
        btnDismissRefresh.setToolTipText(Messages.DiffPresentationPane_dismiss);
        btnDismissRefresh.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));

        btnDismissRefresh.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                hideNotificationArea();
            }
        });
        // end notifications container

        // upper container
        containerUpper = new Composite(parent, SWT.NONE);
        containerUpper.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        containerUpper.setLayout(gl);

        // upper left part
        Composite contUpperLeft = new Composite(containerUpper, SWT.NONE);
        contUpperLeft.setLayoutData(new GridData(GridData.FILL_BOTH));
        // initialize default layout for customizable container
        gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        contUpperLeft.setLayout(gl);
        createUpperContainer(contUpperLeft, gl);

        // upper right part
        storePicker = new DbStorePicker(containerUpper, SWT.NONE, mainPrefs, true, false);
        storePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        storePicker.setSelection(new StructuredSelection(DbInfo.preferenceToStore(
                proj.getPrefs().get(PROJ_PREF.LAST_DB_STORE, "")))); //$NON-NLS-1$

        btnGetChanges = new Button(containerUpper, SWT.PUSH);
        btnGetChanges.setText(Messages.get_changes);
        btnGetChanges.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONREFRESH))));
        btnGetChanges.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        btnGetChanges.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                getChanges();
            }
        });
        // end upper container

        SashForm sashOuter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        diffTable = new DiffTableViewer(sashOuter, false);
        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection.size() != 1) {
                    diffPane.setInput(null, null);
                } else {
                    TreeElement el = (TreeElement) selection.getFirstElement();
                    diffPane.setInput(el, diffTable.getElements());
                }
            }
        });
        diffTable.getViewer().addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent e) {
                TreeElement el = (TreeElement) ((IStructuredSelection) e.getSelection()).getFirstElement();
                openElementInEditor(el);
            }
        });

        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                // bind both to postselection for performance
                sp.fireSelectionChanged(event, new DBPair(dbProject, dbRemote));
            }
        });

        diffPane = new DiffPaneViewer(sashOuter, SWT.NONE);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, HELP.MAIN_EDITOR);

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
            UiSync.exec(parent, this::notifyProjectChanged);
        }
    }

    public void getChanges() {
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), parent.getShell(), true)) {
            return;
        }
        try {
            DbSource dbRemote = getRemoteDbSource();
            if (dbRemote != null) {
                DbSource dbProject = DbSource.fromProject(proj);
                reset();
                hideNotificationArea();
                loadChanges(dbProject, dbRemote);
                saveDbPrefs();
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
        final TreeDiffer newDiffer = new TreeDiffer(dbProject, dbRemote, false);
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
                            if (!parent.isDisposed()) {
                                setInput(dbProject, dbRemote, newDiffer.getDiffTree());
                            }
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

    private void openElementInEditor(TreeElement el) {
        if (el != null && el.getSide() != DiffSide.RIGHT) {
            try {
                getSite().getPage().openEditor(
                        new FileEditorInput(proj.getProject().getFile(
                                Path.fromOSString(ModelExporter.getRelativeFilePath(
                                        el.getPgStatement(dbProject.getDbObject()), true)))),
                        EDITOR.SQL);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            }
        }
    }

    public DbSource getRemoteDbSource() throws CoreException {
        DbSource dbRemote = null;

        IEclipsePreferences projProps = proj.getPrefs();
        boolean forceUnixNewlines = projProps.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
        lastRemote = storePicker.getDbInfo();
        File dumpfile;
        if (lastRemote != null) {
            dbRemote = DbSource.fromDbInfo(lastRemote, mainPrefs, forceUnixNewlines,
                    proj.getProjectCharset(), projProps.get(PROJ_PREF.TIMEZONE, ApgdiffConsts.UTC));
        } else if ((dumpfile = storePicker.getPathOfFile()) != null) {
            dbRemote = DbSource.fromFile(forceUnixNewlines, dumpfile, proj.getProjectCharset());
        } else {
            MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.DiffPresentationPane_cannot_get_changes);
            mb.setMessage(Messages.DiffPresentationPane_select_db_source);
            mb.open();
        }
        return dbRemote;
    }

    public void saveDbPrefs() throws BackingStoreException {
        DbInfo storeDB = storePicker.getDbInfo();
        if (storeDB != null) {
            IEclipsePreferences projProps = proj.getPrefs();
            projProps.put(PROJ_PREF.LAST_DB_STORE, storeDB.toString());
            projProps.flush();
        }
    }

    private void createUpperContainer(Composite container, GridLayout gl){
        gl.numColumns = 6;
        container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        lrm = new LocalResourceManager(JFaceResources.getResources(), container);

        new Label(container, SWT.NONE).setText(Messages.ProjectEditorDiffer_apply_to);

        btnSave = new Button(container, SWT.PUSH);
        btnSave.setText(Messages.commitPartDescr_commit);
        btnSave.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONAPPSMALL))));
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
        btnGetLatest.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONDATABASE))));
        btnGetLatest.setEnabled(false);
        btnGetLatest.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                diff();
            }
        });

        Label l = new Label(container, SWT.NONE);
        l.setText("|"); //$NON-NLS-1$
        l.setEnabled(false);

        btnAddDepcy = new Button(container, SWT.PUSH);
        btnAddDepcy.setText(Messages.diffPartDescr_add_dependencies);
        btnAddDepcy.setEnabled(false);
        btnAddDepcy.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ManualDepciesDialog dialog = new ManualDepciesDialog(parent.getShell(),
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
                !OpenProjectUtils.checkVersionAndWarn(proj.getProject(), parent.getShell(), true)) {
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
                    UiSync.exec(parent, new Runnable() {

                        @Override
                        public void run() {
                            if (!parent.isDisposed()) {
                                try {
                                    showEditor(differ);
                                } catch (PartInitException ex) {
                                    ExceptionNotifier.notifyDefault(
                                            Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
                                }
                            }
                        }
                    });
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }

    private void setInput(DbSource dbProject, DbSource dbRemote, TreeElement diffTree) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
        this.diffTree = diffTree;
        diffPane.setDbSources(dbProject, dbRemote);
        diffPane.setInput(null, null);

        IgnoreList ignoreList = null;
        if (diffTree != null) {
            ignoreList = InternalIgnoreList.readInternalList();
            InternalIgnoreList.readAppendList(
                    proj.getPathToProject().resolve(FILE.IGNORED_OBJECTS), ignoreList);
        }
        diffTable.setInput(dbProject, dbRemote, diffTree, ignoreList);
        if (diffTree != null) {
            btnSave.setEnabled(true);
            btnGetLatest.setEnabled(true);
            btnAddDepcy.setEnabled(true);
            manualDepciesSource.clear();
            manualDepciesTarget.clear();
        }
    }

    private void reset() {
        btnSave.setEnabled(false);
        btnGetLatest.setEnabled(false);
        btnAddDepcy.setEnabled(false);
        manualDepciesSource.clear();
        manualDepciesTarget.clear();
        setInput(null, null, null);
    }

    private void hideNotificationArea() {
        showNotificationArea(false, null);
    }

    private void showEditor(Differ differ) throws PartInitException {
        DepcyFromPSQLOutput input = new DepcyFromPSQLOutput(differ, proj,
                PgDatabase.listPgObjects(dbRemote.getDbObject()));
        input.setDbinfo(storePicker.getDbInfo());
        getSite().getPage().openEditor(input, EDITOR.ROLLON);
    }

    private void showNotificationArea(boolean visible, String message) {
        if (diffTree == null && visible) {
            // since there's only one notification about diff sides changing
            // we can skip showing it if the pane is empty (has no diff loaded)
            return;
        }
        if (message != null) {
            lblNotificationText.setText(message);
        }
        ((GridData) contNotifications.getLayoutData()).exclude = !visible;
        contNotifications.setVisible(visible);
        parent.layout();
        if (visible) {
            btnDismissRefresh.setFocus();
        }
    }

    private void notifyProjectChanged() {
        if (!parent.isDisposed()) {
            showNotificationArea(true, Messages.DiffPresentationPane_project_modified);
            reset();
        }
    }

    private void commit() throws PgCodekeeperException {
        Log.log(Log.LOG_INFO, "Started project update"); //$NON-NLS-1$
        if (warnCheckedElements() < 1 ||
                !OpenProjectUtils.checkVersionAndWarn(proj.getProject(), parent.getShell(), true)) {
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
        CommitDialog cd = new CommitDialog(parent.getShell(), sumNewAndDelete, dbProject, dbRemote,
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
                        UiSync.exec(parent, new Runnable() {

                            @Override
                            public void run() {
                                if (!parent.isDisposed()) {
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

    private void callEgitCommitCommand(){
        if (!isCommitCommandAvailable || !mainPrefs.getBoolean(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE)){
            return;
        }
        try {
            getSite().getSelectionProvider().setSelection(new StructuredSelection(proj.getProject()));
            getSite().getService(IHandlerService.class).executeCommand(COMMAND.COMMIT_COMMAND_ID, null);
        } catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
            Log.log(Log.LOG_WARNING, "Could not execute command " + COMMAND.COMMIT_COMMAND_ID, e); //$NON-NLS-1$
            ExceptionNotifier.notifyDefault(Messages.ProjectEditorDiffer_failed_egit_commit, e);
        }
    }

    private void resetRemoteChanged() {
        // may be called off UI thread so check that we're still alive
        if (!parent.isDisposed()) {
            showNotificationArea(true, Messages.DiffPresentationPane_remote_changed_notification);
            reset();
        }
    }

    /**
     * @return number of checked elements
     */
    private int warnCheckedElements() {
        int checked = diffTable.getCheckedElementsCount();
        if (checked < 1) {
            MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
            mb.setMessage(Messages.please_check_at_least_one_row);
            mb.setText(Messages.empty_selection);
            mb.open();
        }
        return checked;
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

    public static void notifyDbChanged(DbInfo dbinfo) {
        for (IWorkbenchWindow wnd : PlatformUI.getWorkbench().getWorkbenchWindows()) {
            for (IWorkbenchPage page : wnd.getPages()) {
                for (IEditorReference ref : page.getEditorReferences()) {
                    IEditorPart ed = ref.getEditor(false);
                    if (ed instanceof ProjectEditorDiffer) {
                        notifyDbChanged(dbinfo, (ProjectEditorDiffer) ed);
                    }
                }
            }
        }
    }

    private static void notifyDbChanged(DbInfo dbinfo, ProjectEditorDiffer editor) {
        UiSync.exec(editor.parent, () -> {
            if (dbinfo.equals(editor.lastRemote)) {
                editor.resetRemoteChanged();
            }
        });
    }
}