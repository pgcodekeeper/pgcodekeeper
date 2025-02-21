/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.editors;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.progress.IProgressConstants2;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.model.graph.DepcyTreeExtender;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.CONTEXT;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_BIND_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PERSPECTIVE;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.VIEW;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dbstore.DBStoreMenu;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbMenuStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ApplyCustomDialog;
import ru.taximaxim.codekeeper.ui.dialogs.CommitDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.GetChangesCustomDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ManualDepciesDialog;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.DiffPaneViewer;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;
import ru.taximaxim.codekeeper.ui.propertytests.ChangesJobTester;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.views.DBPair;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;
import ru.taximaxim.codekeeper.ui.xmlstore.IgnoreListsXmlStore;

public class ProjectEditorDiffer extends EditorPart implements IResourceChangeListener {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private PgDbProject proj;
    private ProjectEditorSelectionProvider sp;
    private Composite parent;
    /**
     * do not read directly, use {@link #getCurrentDb()}
     */
    private Object currentRemote;
    private DbSource dbProject;
    private DbSource dbRemote;
    private TreeElement diffTree;
    private Object loadedRemote;

    private Composite contNotifications;
    private Label lblNotificationText;
    private Link linkRefresh;

    private DbMenuStorePicker dbStorePicker;
    private Label lblApplyTo;
    private Action getChangesAction;
    private DiffTable diffTable;
    private DiffPaneViewer diffPane;
    private boolean isDBLoaded;
    private boolean isCommitCommandAvailable;
    private List<Entry<PgStatement, PgStatement>> manualDepciesSource = new ArrayList<>();
    private List<Entry<PgStatement, PgStatement>> manualDepciesTarget = new ArrayList<>();

    private DatabaseType dbType;
    private final Map<String, Boolean> oneTimePrefs = new HashMap<>();

    public IProject getProject() {
        return proj.getProject();
    }

    public void changeMigrationDireciton(boolean isApplyToProj, boolean showWarning) {
        diffTable.changeMigrationDireciton(isApplyToProj, showWarning);
    }

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

        setInput(input);
        setSite(site);
        setPartName(in.getName());

        proj = new PgDbProject(in.getProject());
        sp = new ProjectEditorSelectionProvider(getProject());
        dbType = OpenProjectUtils.getDatabaseType(getProject());

        // message box
        if(!site.getPage().getPerspective().getId().equals(PERSPECTIVE.MAIN)){
            askPerspectiveChange(site);
        }
        getSite().setSelectionProvider(sp);
    }

    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;

        parent.setLayout(new GridLayout());
        LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), parent);

        SashForm sashOuter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        IStatusLineManager manager = getEditorSite().getActionBars().getStatusLineManager();

        diffTable = new DiffTable(sashOuter, false, manager,
                Paths.get(getProject().getLocationURI()));

        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.getViewer().addPostSelectionChangedListener(e -> {
            IStructuredSelection selection = (IStructuredSelection) e.getSelection();
            if (selection.size() != 1) {
                diffPane.setInput(null, null);
            } else {
                TreeElement el = (TreeElement) selection.getFirstElement();
                diffPane.setInput(el, diffTable.getElements());
            }
        });

        diffTable.getViewer().addDoubleClickListener(
                e -> openElementInEditor((TreeElement) ((IStructuredSelection) e.getSelection()).getFirstElement()));

        diffTable.getViewer().addPostSelectionChangedListener(
                e -> sp.fireSelectionChanged(e, new DBPair(dbProject, dbRemote)));

        diffPane = new DiffPaneViewer(sashOuter);

        // notifications container
        // simplified for 1 static notification
        // refactor into multiple child composites w/ description class
        // for multiple dynamic notifications if necessary
        contNotifications = new Group(parent, SWT.NONE);
        contNotifications.setLayout(new GridLayout(4, false));

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        contNotifications.setVisible(false);
        contNotifications.setLayoutData(gd);

        Label lblNotification = new Label(contNotifications, SWT.NONE);
        lblNotification.setText(Messages.DiffPresentationPane_attention);
        lblNotification.setFont(lrm.create(FontDescriptor.createFrom(lblNotification.getFont()).withStyle(SWT.BOLD)));

        lblNotificationText = new Label(contNotifications, SWT.NONE);

        linkRefresh = new Link(contNotifications, SWT.NONE);
        linkRefresh.setText(Messages.DiffPresentationPane_refresh_link);
        gd = new GridData();
        gd.horizontalIndent = 10;
        linkRefresh.setLayoutData(gd);

        // Event handling when users click on links.
        linkRefresh.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                getChanges();
            }

        });

        Link linkClose = new Link(contNotifications, SWT.NONE);
        linkClose.setText(Messages.DiffPresentationPane_close_link);
        gd = new GridData();
        gd.horizontalIndent = 5;
        linkClose.setLayoutData(gd);

        // Event handling when users click on links.
        linkClose.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                hideNotificationArea();
            }

        });
        // end notifications container

        diffTable.changeMigrationDireciton(getLastDirection(), false);

        ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
                IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE
                | IResourceChangeEvent.POST_CHANGE);

        ICommandService commandService =
                PlatformUI.getWorkbench().getService(ICommandService.class);
        @SuppressWarnings("unchecked")
        Collection<String> commandIds = commandService.getDefinedCommandIds();
        isCommitCommandAvailable = commandIds.contains(COMMAND.COMMIT_COMMAND_ID);

        getSite().getService(IContextService.class).activateContext(CONTEXT.MAIN);
    }

    private void updateWorkWith() {
        dbStorePicker.setSelection(getCurrentDb(), false);
        lblApplyTo.setText(diffTable.isApplyToProj() ? Messages.ProjectEditorDiffer_apply_project
                : Messages.ProjectEditorDiffer_apply_db);
        diffTable.layout(true, true);
    }

    public void addDependency() {
        if (isDBLoaded){
            ManualDepciesDialog dialog = new ManualDepciesDialog(parent.getShell(),
                    manualDepciesSource, manualDepciesTarget,
                    AbstractDatabase.listPgObjects(dbRemote.getDbObject()),
                    AbstractDatabase.listPgObjects(dbProject.getDbObject()),
                    Messages.database, Messages.ProjectEditorDiffer_project);
            if (dialog.open() == Window.OK) {
                manualDepciesSource = dialog.getDepciesSourceList();
                manualDepciesTarget = dialog.getDepciesTargetList();
            }
        }
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void setFocus() {
        diffTable.getViewer().getControl().setFocus();
        diffTable.updateObjectsLabels();
        updateSelection();
    }

    private void updateSelection() {
        if (dbProject != null) {
            ISelection selection = diffTable.getViewer().getSelection();
            if (selection.isEmpty()) {
                DBPair pair = new DBPair(dbProject, dbRemote);
                sp.fireSelectionChanged(new SelectionChangedEvent(sp, new StructuredSelection(pair)), pair);
            }
        }
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
        dbStorePicker.dispose();
        diffPane.dispose();
        super.dispose();
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        switch (event.getType()) {
        case IResourceChangeEvent.PRE_CLOSE, IResourceChangeEvent.PRE_DELETE:
            handlerCloseProject(event);
        break;
        case IResourceChangeEvent.POST_CHANGE:
            handleChangeProject(event.getDelta());
            break;
        default:
            break;
        }
    }

    private void handlerCloseProject(IResourceChangeEvent event) {
        if (event.getResource().getProject().equals(getProject())) {
            UiSync.exec(parent, () -> {
                if (!parent.isDisposed()) {
                    getSite().getPage().closeEditor(ProjectEditorDiffer.this, true);
                }
            });
        }
    }

    private void handleChangeProject(IResourceDelta rootDelta) {
        final boolean[] schemaChanged = new boolean[1];
        try {
            rootDelta.accept(delta -> {
                if (schemaChanged[0]) {
                    return false;
                }
                // something other than just markers has changed
                // check that it's our resource
                if (delta.getFlags() != IResourceDelta.MARKERS &&
                        (UIProjectLoader.isInProject(delta, OpenProjectUtils.getDatabaseType(getProject()))
                                || UIProjectLoader.isOverridesFolder(delta)) &&
                        delta.getResource().getType() == IResource.FILE &&
                        delta.getResource().getProject().equals(getProject())) {
                    schemaChanged[0] = true;
                    return false;
                }
                return true;
            });
        } catch (CoreException ex) {
            Log.log(ex);
        }

        if (schemaChanged[0]) {
            UiSync.exec(parent, this::notifyProjectChanged);
        }
    }

    public void getChanges() {
        Object currentRemote = getCurrentDb();
        if (currentRemote == null) {
            MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
            mb.setText(Messages.GetChanges_select_source);
            mb.setMessage(Messages.GetChanges_select_source_msg);
            mb.open();
            return;
        }

        boolean isDbInfo = currentRemote instanceof DbInfo;
        DatabaseType dbType = OpenProjectUtils.getDatabaseType(getProject());
        if (isDbInfo && ((DbInfo) currentRemote).getDbType() != dbType) {
            MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
            mb.setText(Messages.ProjectEditorDiffer_different_types);
            mb.setMessage(Messages.ProjectEditorDiffer_different_types_msg);
            mb.open();
            return;
        }

        String charset;
        try {
            charset = proj.getProjectCharset();
        } catch (CoreException e) {
            ExceptionNotifier.notifyDefault(Messages.DiffPresentationPane_error_loading_changes, e);
            return;
        }
        IEclipsePreferences projProps = proj.getPrefs();

        boolean forceUnixNewlines = projProps.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);

        DbSource dbProject = DbSource.fromProject(proj, oneTimePrefs);

        TreeDiffer newDiffer;

        if (isDbInfo) {
            DbInfo dbInfo = (DbInfo) currentRemote;
            DbSource dbRemote = DbSource.fromDbInfo(dbInfo, forceUnixNewlines,
                    charset, projProps.get(PROJ_PREF.TIMEZONE, Consts.UTC),
                    getProject(), oneTimePrefs);
            newDiffer = new TreeDiffer(dbProject, dbRemote);
            saveLastDb(dbInfo);
        } else {
            File file = (File) currentRemote;
            DbSource dbRemote = DbSource.fromFile(forceUnixNewlines, file, charset,
                    dbType, getProject(), oneTimePrefs);
            newDiffer = new TreeDiffer(dbProject, dbRemote);
        }

        if (!OpenProjectUtils.checkVersionAndWarn(getProject(), parent.getShell(), true)) {
            return;
        }

        Log.log(Log.LOG_INFO, "Getting changes for diff"); //$NON-NLS-1$

        reset();
        hideNotificationArea();

        Job job = new SingletonEditorJob(Messages.diffPresentationPane_getting_changes_for_diff,
                this, ChangesJobTester.EVAL_PROP) {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    SubMonitor sub = SubMonitor.convert(monitor,
                            Messages.diffPresentationPane_getting_changes_for_diff, 100);
                    getProject().refreshLocal(IResource.DEPTH_INFINITE, sub.newChild(10));

                    PgDiffUtils.checkCancelled(monitor);
                    sub.subTask(Messages.diffPresentationPane_getting_changes_for_diff);
                    newDiffer.run(sub.newChild(90));
                    monitor.done();
                } catch (InvocationTargetException | CoreException e) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.error_in_differ_thread, e);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void aboutToRun(IJobChangeEvent event) {
                UiSync.exec(parent, () -> {
                    if (!parent.isDisposed()) {
                        getChangesAction.setEnabled(false);
                    }
                });
            }


            @Override
            public void done(IJobChangeEvent event) {
                UiSync.exec(parent, () -> {
                    if (!parent.isDisposed()) {
                        getChangesAction.setEnabled(true);
                    }
                });

                if (event.getResult().isOK()) {
                    UiSync.exec(parent, () -> {
                        if (!parent.isDisposed()) {
                            loadedRemote = currentRemote;
                            setInput(newDiffer.getDbSource(), newDiffer.getDbTarget(),
                                    newDiffer.getDiffTree());
                            if (diffTable.getElements().isEmpty()) {
                                showNotificationArea(true, Messages.ProjectEditorDiffer_no_differences);
                            }

                            // clearing because this preferences must be used only once
                            oneTimePrefs.clear();
                        }
                    });
                }

                if (mainPrefs.getBoolean(PG_EDIT_PREF.SHOW_DIFF_ERRORS)) {
                    newDiffer.getErrors().forEach(e -> StatusManager.getManager().handle(
                            new Status(IStatus.WARNING, PLUGIN_ID.THIS, e.toString()),
                            StatusManager.SHOW));
                }
            }
        });
        job.setProperty(IProgressConstants2.SHOW_IN_TASKBAR_ICON_PROPERTY, Boolean.TRUE);
        job.setUser(true);
        job.schedule();
    }

    private boolean showOverrideView(DbSource dbProject) {
        List<PgOverride> overrides = dbProject.getDbObject().getOverrides();
        if (overrides.isEmpty()) {
            return true;
        }

        try {
            getSite().getPage().showView(VIEW.OVERRIDE_VIEW, null, IWorkbenchPage.VIEW_VISIBLE);
            updateSelection();
        } catch (PartInitException e) {
            ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
        }

        if (proj.getPrefs().getBoolean(PROJ_PREF.LIB_SAFE_MODE, true)) {
            MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_ERROR | SWT.YES | SWT.NO);
            mb.setText(Messages.ProjectEditorDiffer_library_duplication_title);
            mb.setMessage(Messages.ProjectEditorDiffer_library_duplication_exception);
            if (mb.open() == SWT.YES) {
                PreferencesUtil.createPropertyDialogOn(
                        parent.getShell(), proj.getProject(), PREF_PAGE.DEPENDENCIES, null, null).open();
            }
            return false;
        }

        return true;
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
            if (dialog.getReturnCode() == IDialogConstants.YES_ID) {
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
        if (el == null || el.getSide() == DiffSide.RIGHT) {
            return;
        }

        try {
            PgStatement st = el.getPgStatement(dbProject.getDbObject());
            IProject project = getProject();
            FileUtilsUi.openFileInSqlEditor(
                    st.getLocation(), project.getName(), OpenProjectUtils.getDatabaseType(project), st.isLib());
        } catch (CoreException e) {
            ExceptionNotifier.notifyCoreException(e);
        }
    }

    /**
     * @param remote remote DB schema: either {@link File} or {@link DbInfo}
     * @throws IllegalArgumentException invalid remote type
     */
    public void setCurrentDb(Object currentRemote) {
        if (currentRemote == null || currentRemote instanceof DbInfo || currentRemote instanceof File) {
            this.currentRemote = currentRemote;
        } else {
            throw new IllegalArgumentException("Remote is not a File or DbInfo!"); //$NON-NLS-1$
        }

        updateWorkWith();
    }

    /**
     * @return currently set remote for this editor
     */
    public Object getCurrentDb() {
        IEclipsePreferences prefs = proj.getDbBindPrefs();
        DbInfo boundDb = DbInfo.getLastDb(prefs.get(DB_BIND_PREF.NAME_OF_BOUND_DB, ""), dbType); //$NON-NLS-1$
        if (boundDb != null) {
            dbStorePicker.setEnabled(false);
            return boundDb;
        }

        if (currentRemote != null) {
            return currentRemote;
        }

        return DbInfo.getLastDb(prefs.get(DB_BIND_PREF.LAST_DB_STORE, ""), dbType); //$NON-NLS-1$
    }

    public void saveLastDb(DbInfo lastDb) {
        saveLastDb(lastDb, getProject());
    }

    public static void saveLastDb(DbInfo lastDb, IProject project) {
        IEclipsePreferences prefs = PgDbProject.getPrefs(project, false);
        if (prefs != null) {
            prefs.put(DB_BIND_PREF.LAST_DB_STORE, lastDb.getName());
            try {
                prefs.flush();
            } catch (BackingStoreException ex) {
                Log.log(ex);
            }
        }
    }

    public boolean getLastDirection() {
        IEclipsePreferences prefs = proj.getDbBindPrefs();
        return prefs.getBoolean(DB_BIND_PREF.LAST_DIRECTION, true);
    }

    public void diff() {
        Log.log(Log.LOG_INFO, "Started DB update"); //$NON-NLS-1$
        if (warnCheckedElements() < 1 ||
                !OpenProjectUtils.checkVersionAndWarn(getProject(), parent.getShell(), true)) {
            return;
        }

        IEclipsePreferences pref = proj.getPrefs();
        final Differ differ = new Differ(dbRemote.getDbObject(),
                dbProject.getDbObject(), diffTree.getRevertedCopy(), false,
                pref.get(PROJ_PREF.TIMEZONE, Consts.UTC),
                OpenProjectUtils.getDatabaseType(getProject()), getProject(), oneTimePrefs);
        differ.setAdditionalDepciesSource(manualDepciesSource);
        differ.setAdditionalDepciesTarget(manualDepciesTarget);

        Job job = differ.getDifferJob();
        job.addJobChangeListener(new JobChangeAdapter() {

            @Override
            public void done(IJobChangeEvent event) {
                Log.log(Log.LOG_INFO, "Differ job finished with status " +  //$NON-NLS-1$
                        event.getResult().getSeverity());
                if (event.getResult().isOK()) {
                    UiSync.exec(parent, () -> {
                        if (!parent.isDisposed()) {
                            try {
                                showEditor(differ);
                            } catch (PartInitException ex) {
                                ExceptionNotifier.notifyDefault(
                                        Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
                            }
                        }
                    });
                }

                // clearing because this preferences must be used only once
                oneTimePrefs.clear();
            }
        });
        job.setUser(true);
        job.schedule();
    }

    private void setInput(DbSource dbProject, DbSource dbRemote, TreeElement diffTree) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
        this.diffTree = diffTree;

        if (dbProject != null && !showOverrideView(dbProject)) {
            return;
        }

        diffPane.setDbSources(dbProject, dbRemote);
        diffPane.setInput(null, null);

        IgnoreList ignoreList = null;
        if (diffTree != null) {
            boolean isGlobal = new OverridablePrefs(getProject(), oneTimePrefs).isUseGlobalIgnoreList();
            ignoreList = isGlobal ? InternalIgnoreList.readInternalList() : new IgnoreList();

            InternalIgnoreList.readAppendList(
                    proj.getPathToProject().resolve(FILE.IGNORED_OBJECTS), ignoreList);

            if (loadedRemote instanceof DbInfo info) {
                info.appendIgnoreFiles(ignoreList);
            }

            try {
                for (String path : new IgnoreListsXmlStore(getProject()).readObjects()) {
                    InternalIgnoreList.readAppendList(Paths.get(path), ignoreList);
                }
            } catch (IOException e) {
                Log.log(e);
            }
        }
        diffTable.setInput(dbProject, dbRemote, diffTree, ignoreList);
        if (diffTree != null) {
            isDBLoaded = true;
            manualDepciesSource.clear();
            manualDepciesTarget.clear();
        }
    }

    private void reset() {
        isDBLoaded = false;
        manualDepciesSource.clear();
        manualDepciesTarget.clear();
        setInput(null, null, null);
    }

    private void hideNotificationArea() {
        showNotificationArea(false, null);
    }

    private void showEditor(Differ differ) throws PartInitException {
        try {
            boolean inProj = false;
            String creationMode = mainPrefs.getString(DB_UPDATE_PREF.CREATE_SCRIPT_IN_PROJECT);
            // if select "YES" with toggle
            if (creationMode.equals(MessageDialogWithToggle.ALWAYS)) {
                inProj = true;
                // if not select "NO" with toggle, show choice message dialog
            } else if (!creationMode.equals(MessageDialogWithToggle.NEVER)) {
                MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(parent.getShell(),
                        Messages.ProjectEditorDiffer_script_creation_title, Messages.ProjectEditorDiffer_script_creation_message,
                        Messages.remember_choice_toggle, false, mainPrefs, DB_UPDATE_PREF.CREATE_SCRIPT_IN_PROJECT);
                if (dialog.getReturnCode() == IDialogConstants.YES_ID) {
                    inProj = true;
                }
            }

            String content = differ.getDiffDirect();
            String filename = generateScriptName();
            if (inProj) {
                IEditorInput file = createProjectScriptFile(content, filename);
                if (loadedRemote instanceof DbInfo info) {
                    SQLEditor.saveLastDb(info, file);
                }
                getSite().getPage().openEditor(file, EDITOR.SQL);
            } else {
                FileUtilsUi.saveOpenTmpSqlEditor(content, filename,
                        OpenProjectUtils.getDatabaseType(getProject()));
            }
        } catch (CoreException | IOException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_creating_file, ex);
        }
    }

    private String generateScriptName() {
        String name = FileUtils.getFileDate() + " migration"; //$NON-NLS-1$
        if (loadedRemote != null) {
            name += " for " + getRemoteName(loadedRemote); //$NON-NLS-1$
        }
        return FileUtils.sanitizeFilename(name);
    }

    private IEditorInput createProjectScriptFile(String content, String filename) throws CoreException, IOException {
        Log.log(Log.LOG_INFO, "Creating file " + filename); //$NON-NLS-1$
        IFolder folder = getProject().getFolder(PROJ_PATH.MIGRATION_DIR);
        if (!folder.exists()){
            folder.create(IResource.NONE, true, null);
        }
        IFile file = folder.getFile(filename + ".sql"); //$NON-NLS-1$
        InputStream source = new ByteArrayInputStream(content.getBytes(proj.getProjectCharset()));
        file.create(source, IResource.NONE, null);
        return new FileEditorInput(getProject().getFile(file.getProjectRelativePath()));
    }

    private void showNotificationArea(boolean visible, String message) {
        if (diffTree == null && visible) {
            // since there's only one notification about diff sides changing
            // we can skip showing it if the pane is empty (has no diff loaded)
            return;
        }
        if (message != null) {
            lblNotificationText.setText(message);

            // Updates the size of the composite when replacing text.
            // ('layout' method doesn't set correct height for the composit in
            // first request of this composite)
            contNotifications.pack();
        }
        ((GridData) contNotifications.getLayoutData()).exclude = !visible;
        contNotifications.setVisible(visible);
        parent.layout();
        if (visible) {
            linkRefresh.setFocus();
        }
    }

    private void notifyProjectChanged() {
        if (!parent.isDisposed()) {
            showNotificationArea(true, Messages.DiffPresentationPane_project_modified);
            reset();
        }
    }

    public void commit() {
        Log.log(Log.LOG_INFO, "Started project update"); //$NON-NLS-1$
        if (warnCheckedElements() < 1
                || !OpenProjectUtils.checkVersionAndWarn(getProject(), parent.getShell(), true)) {
            return;
        }

        boolean forceSave = false;
        boolean saveOverrides = false;

        if (diffTable.checkLibChange()) {
            if (proj.getPrefs().getBoolean(PROJ_PREF.LIB_SAFE_MODE, true)) {
                MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
                mb.setMessage(Messages.ProjectEditorDiffer_lib_change_error_message);
                mb.setText(Messages.ProjectEditorDiffer_lib_change_warning_title);
                if (mb.open() != SWT.YES) {
                    return;
                }
                forceSave = true;
                saveOverrides = true;
            } else {
                MessageDialog mb = new MessageDialog(parent.getShell(),
                        Messages.ProjectEditorDiffer_lib_change_warning_title, null,
                        Messages.ProjectEditorDiffer_lib_change_warning_message, MessageDialog.WARNING,
                        new String[] { Messages.ProjectEditorDiffer_override_privileges,
                                Messages.ProjectEditorDiffer_override_objects,
                                Messages.ProjectEditorDiffer_override_cancel }, 0);
                int override = mb.open();
                if (Window.OK == override || Window.CANCEL == override) {
                    saveOverrides = override == Window.OK;
                } else {
                    // cancelled
                    return;
                }
            }
        }

        TreeElement treeCopy = diffTree.getCopy();
        Log.log(Log.LOG_INFO, "Processing depcies for project update"); //$NON-NLS-1$
        Set<TreeElement> sumNewAndDelete = new DepcyTreeExtender(
                dbProject.getDbObject(), dbRemote.getDbObject(), treeCopy).getDepcies();

        Log.log(Log.LOG_INFO, "Querying user for project update"); //$NON-NLS-1$
        // display commit dialog
        CommitDialog cd = new CommitDialog(parent.getShell(), sumNewAndDelete,
                dbProject, dbRemote, treeCopy, mainPrefs, isCommitCommandAvailable,
                forceSave, saveOverrides, proj);
        if (cd.open() != Window.OK) {
            return;
        }
        callEgitCommitCommand();
    }

    private void callEgitCommitCommand(){
        if (!isCommitCommandAvailable || !mainPrefs.getBoolean(PREF.CALL_COMMIT_COMMAND_AFTER_UPDATE)){
            return;
        }
        try {
            getSite().getSelectionProvider().setSelection(new StructuredSelection(getProject()));
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

    public void updateRemoteChanged() {
        // may be called off UI thread so check that we're still alive
        if (!parent.isDisposed()) {
            getChanges();
            showNotificationArea(true, Messages.DiffPresentationPane_remote_changed_notification);
        }
    }

    /**
     * @return number of checked elements
     */
    private int warnCheckedElements() {
        int checked = diffTable.getCheckedElementsCount();

        if (checked < 1) {
            IStructuredSelection selection = diffTable.getViewer().getStructuredSelection();
            if (selection.isEmpty()) {
                MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
                mb.setMessage(Messages.please_check_at_least_one_row);
                mb.setText(Messages.empty_selection);
                mb.open();
            } else {
                diffTable.setElementsChecked(selection.toList(), true, false);
                return selection.size();
            }
        }
        return checked;
    }

    public static void notifyDbChanged(DbInfo dbinfo) {
        String action = Activator.getDefault().getPreferenceStore().getString(PG_EDIT_PREF.EDITOR_UPDATE_ACTION);
        if (action.equals(PG_EDIT_PREF.NO_ACTION)) {
            return;
        }
        for (IWorkbenchWindow wnd : PlatformUI.getWorkbench().getWorkbenchWindows()) {
            for (IWorkbenchPage page : wnd.getPages()) {
                for (IEditorReference ref : page.getEditorReferences()) {
                    IEditorPart ed = ref.getEditor(false);
                    if (ed instanceof ProjectEditorDiffer differ) {
                        notifyDbChanged(dbinfo, differ, action.equals(PG_EDIT_PREF.UPDATE));
                    }
                }
            }
        }
    }

    private static void notifyDbChanged(DbInfo dbinfo, ProjectEditorDiffer editor, boolean update) {
        UiSync.exec(editor.parent, () -> {
            if (dbinfo.equals(editor.getCurrentDb())) {
                if (update) {
                    editor.updateRemoteChanged();
                } else {
                    editor.resetRemoteChanged();
                }
            }
        });
    }

    private static String getRemoteName(Object remote) {
        if (remote instanceof DbInfo info) {
            return info.getName();
        }
        if (remote instanceof File file) {
            return file.getName();
        }
        throw new IllegalArgumentException("Remote is not a File or DbInfo!"); //$NON-NLS-1$
    }

    private class DiffTable extends DiffTableViewer {

        private Action applyAction;
        private Action actionToProj;
        private Action actionToDb;

        private ImageDescriptor imgDescrApplyIcon;
        private ImageDescriptor imgDescrProj;
        private ImageDescriptor imgDescrDb;

        public DiffTable(Composite parent, boolean viewOnly, IStatusLineManager lineManager, Path location) {
            super(parent, viewOnly, lineManager, location, dbType);
        }

        @Override
        public void createRightSide(Composite container) {
            GridLayout layout = new GridLayout(2, false);
            layout.marginHeight = 0;
            layout.marginWidth = 0;
            container.setLayout(layout);

            Composite labelCont = new Composite(container, SWT.NONE);
            GridLayout labelLayout = new GridLayout(4, false);
            labelLayout.marginHeight = 0;
            labelLayout.marginWidth = 0;
            labelCont.setLayout(labelLayout);

            PixelConverter pc = new PixelConverter(labelCont);
            GridData gd = new GridData(SWT.END, SWT.CENTER, true, false);
            gd.horizontalIndent = pc.convertWidthInCharsToPixels(4);
            labelCont.setLayoutData(gd);

            Label l = new Label(labelCont, SWT.NONE);
            l.setText(Messages.ProjectEditorDiffer_work_with);
            l.setEnabled(false);

            //current remote

            dbStorePicker = new DbMenuStorePicker(labelCont, true, false);
            dbStorePicker.filter(dbType);
            labelCont.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseDown(MouseEvent e) {
                    if (!dbStorePicker.isEnabled()) {
                        MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
                        mb.setText(Messages.DbStoreCombo_db_binding_property_title);
                        mb.setMessage(Messages.DbStoreCombo_db_binding_property);
                        mb.open();
                    }
                }
            });

            dbStorePicker.addSelectionListener(()-> {
                Object selection = dbStorePicker.getDbInfo();
                if (selection == null) {
                    selection = dbStorePicker.getPathOfFile();
                }
                ProjectEditorDiffer.this.setCurrentDb(selection);
            });

            l = new Label(labelCont, SWT.NONE);
            l.setText(Messages.ProjectEditorDiffer_apply_to);
            l.setEnabled(false);

            //change apply action
            lblApplyTo = new Label(labelCont, SWT.NONE);
            lblApplyTo.setCursor(getDisplay().getSystemCursor(SWT.CURSOR_HAND));

            createApplyActions();
            MenuManager menuMg = new MenuManager();
            menuMg.add(actionToProj);
            menuMg.add(actionToDb);

            lblApplyTo.setMenu(menuMg.createContextMenu(lblApplyTo));

            lblApplyTo.addMouseListener(MouseListener.mouseDownAdapter(e -> {
                if (e.button == 1) {
                    lblApplyTo.getMenu().setVisible(true);
                }
            }));

            final ToolBarManager mgrTblBtn = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
            addBtnApplyWithMenu(container, mgrTblBtn);
            mgrTblBtn.add(new Separator());
            addBtnGetChangesWithMenu(container, mgrTblBtn);

            ToolBar toolbar = mgrTblBtn.createControl(container);
            gd = new GridData(SWT.END, SWT.CENTER, false, false);
            gd.horizontalIndent = pc.convertWidthInCharsToPixels(2);
            toolbar.setLayoutData(gd);

            // ensure toolbar is never hidden
            gd.minimumWidth = toolbar.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        }

        private void createApplyActions() {
            actionToProj = new Action(Messages.DiffTableViewer_to_project, IAction.AS_RADIO_BUTTON) {

                @Override
                public void run() {
                    changeMigrationDireciton(true, false);
                }
            };

            actionToProj.setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.APP_SMALL));
            actionToDb = new Action(Messages.DiffTableViewer_to_database, IAction.AS_RADIO_BUTTON) {

                @Override
                public void run() {
                    changeMigrationDireciton(false, false);
                }
            };
            actionToDb.setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.DATABASE));
        }

        /**
         * Adds [Apply] button with drop-down menu, which contains
         * main button [Apply] and additional button for applying
         * with custom settings.
         */
        private void addBtnApplyWithMenu(Composite container, ToolBarManager mgrTblBtn) {
            imgDescrApplyIcon = Activator.getRegisteredDescriptor(ProjectIcon.APPLY_TO);

            imgDescrProj = Activator.getRegisteredDescriptor(ProjectIcon.DECOR_PGCODEKEEPER);
            imgDescrDb = Activator.getRegisteredDescriptor(ProjectIcon.DECOR_DATABASE);

            applyAction = new Action("", IAction.AS_DROP_DOWN_MENU) { //$NON-NLS-1$
                @Override
                public void run() {
                    if (!diffTable.isApplyToProj()) {
                        diff();
                    } else {
                        commit();
                    }
                }
            };
            applyAction.setToolTipText(Messages.DiffTableViewer_apply_to + ' ' + Messages.DiffTableViewer_to_project);
            applyAction.setImageDescriptor(new DecorationOverlayIcon(imgDescrApplyIcon,
                    imgDescrProj, IDecoration.TOP_RIGHT));

            applyAction.setMenuCreator(new IMenuCreator() {

                private MenuManager menuMgrApplyCustom;

                @Override
                public void dispose() {
                    if (menuMgrApplyCustom != null) {
                        menuMgrApplyCustom.dispose();
                        menuMgrApplyCustom = null;
                    }
                }

                @Override
                public Menu getMenu(Control parent) {
                    if (menuMgrApplyCustom != null) {
                        menuMgrApplyCustom.dispose();
                    }

                    menuMgrApplyCustom = new MenuManager();
                    IAction applyCustomAction = new Action(Messages.DiffTableViewer_apply_to_custom) {

                        @Override
                        public void run() {
                            ApplyCustomDialog dialog = new ApplyCustomDialog(container.getShell(),
                                    new OverridablePrefs(proj.getProject(), null), dbType, oneTimePrefs);
                            if (dialog.open() == Window.OK) {
                                // 'oneTimePrefs' filled by one-time preferences
                                // will be used in 'diff()'
                                diff();
                            }
                        }
                    };

                    Action applyTitle = new Action(Messages.DiffTableViewer_apply_to) {
                    };
                    applyTitle.setEnabled(false);
                    menuMgrApplyCustom.add(applyTitle);

                    menuMgrApplyCustom.add(actionToProj);
                    menuMgrApplyCustom.add(actionToDb);
                    menuMgrApplyCustom.add(new Separator());
                    applyCustomAction.setEnabled(actionToDb.isChecked());

                    menuMgrApplyCustom.add(applyCustomAction);
                    return menuMgrApplyCustom.createContextMenu(parent);
                }

                @Override
                public Menu getMenu(Menu parent) {
                    return null;
                }
            });
            mgrTblBtn.add(applyAction);
        }

        private void addBtnGetChangesWithMenu(Composite container, ToolBarManager mgrTblBtn) {
            getChangesAction = new Action("", IAction.AS_DROP_DOWN_MENU) { //$NON-NLS-1$

                @Override
                public void run() {
                    getChanges();
                }
            };
            getChangesAction.setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.REFRESH));
            getChangesAction.setToolTipText(Messages.DiffTableViewer_get_changes);
            getChangesAction.setMenuCreator(new IMenuCreator() {

                private MenuManager menuMgrGetChangesCustom;

                @Override
                public void dispose() {
                    if (menuMgrGetChangesCustom != null) {
                        menuMgrGetChangesCustom.dispose();
                        menuMgrGetChangesCustom = null;
                    }
                }

                @Override
                public Menu getMenu(Control parent) {
                    if (menuMgrGetChangesCustom != null) {
                        menuMgrGetChangesCustom.dispose();
                    }

                    menuMgrGetChangesCustom = new MenuManager();
                    menuMgrGetChangesCustom.add(new Action(Messages.DiffTableViewer_get_changes_custom) {

                        @Override
                        public void run() {
                            GetChangesCustomDialog dialog = new GetChangesCustomDialog(container.getShell(),
                                    new OverridablePrefs(proj.getProject(), null), dbType, oneTimePrefs);
                            if (dialog.open() == Window.OK) {
                                // 'oneTimePrefs' filled by one-time preferences
                                // will be used in 'getChanges()'
                                getChanges();
                            }
                        }
                    });
                    menuMgrGetChangesCustom.add(new Separator());
                    DBStoreMenu dbMenu = new DBStoreMenu(menuMgrGetChangesCustom, true, false, dbType, parent.getShell(), getCurrentDb());
                    dbMenu.fillDbMenu(DbXmlStore.getStore());
                    dbMenu.addSelectionListener(ProjectEditorDiffer.this::setCurrentDb);
                    return menuMgrGetChangesCustom.createContextMenu(parent);
                }

                @Override
                public Menu getMenu(Menu parent) {
                    return null;
                }
            });
            mgrTblBtn.add(getChangesAction);
        }

        public void changeMigrationDireciton(boolean isApplyToProj, boolean showWarning) {
            if (showWarning && isApplyToProj != diffTable.isApplyToProj()) {
                MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_WARNING);
                mb.setText(Messages.ProjectEditorDiffer_changed_direction_of_roll_on_title);
                mb.setMessage(MessageFormat.format(Messages.ProjectEditorDiffer_changed_direction_of_roll_on,
                        isApplyToProj ? Messages.ProjectEditorDiffer_project
                                : Messages.ProjectEditorDiffer_database));
                mb.open();
            }
            diffTable.setApplyToProj(isApplyToProj);
            diffTable.getViewer().refresh();
            diffTable.updateObjectsLabels();
            saveLastDirection(getProject(), isApplyToProj);
            updateWorkWith();
            actionToProj.setChecked(isApplyToProj);
            actionToDb.setChecked(!isApplyToProj);

            String message = isApplyToProj ? Messages.DiffTableViewer_to_project : Messages.DiffTableViewer_to_database;
            ImageDescriptor descr = isApplyToProj ? imgDescrProj : imgDescrDb;

            applyAction.setToolTipText(Messages.DiffTableViewer_apply_to + ' ' + message);
            applyAction.setImageDescriptor(new DecorationOverlayIcon(imgDescrApplyIcon,
                    descr, IDecoration.TOP_RIGHT));
        }

        private void saveLastDirection(IProject project, boolean isProj) {
            IEclipsePreferences prefs = PgDbProject.getPrefs(project, false);
            if (prefs != null) {
                prefs.putBoolean(DB_BIND_PREF.LAST_DIRECTION, isProj);
                try {
                    prefs.flush();
                } catch (BackingStoreException ex) {
                    Log.log(ex);
                }
            }
        }
    }
}
