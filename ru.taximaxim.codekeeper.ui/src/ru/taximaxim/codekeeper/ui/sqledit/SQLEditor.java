package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempFile;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.CONTEXT;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROP_TEST;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

public class SQLEditor extends AbstractDecoratedTextEditor implements IResourceChangeListener {
    public static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    public static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    public static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    public static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    public static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    public static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$

    static final String CONTENT_ASSIST = "ContentAssist"; //$NON-NLS-1$

    private final XmlHistory history;

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private SqlEditorPartListener partListener;

    private volatile boolean isRunning;
    private Thread scriptThread;

    private DbInfo currentDB;

    private volatile boolean updateDdlJobInProcessing;
    private volatile boolean quickUpdateJobInProcessing;

    private Composite parentComposite;
    private SQLEditorContentOutlinePage fOutlinePage;
    private Image errorTitleImage;
    private PgDbParser parser;

    private final Listener list = e -> {
        if (parentComposite == null) {
            return;
        }
        UiSync.exec(parentComposite, () -> {
            if (fOutlinePage != null) {
                Control c = fOutlinePage.getControl();
                if (c != null && !c.isDisposed()) {
                    fOutlinePage.externalRefresh();
                }
            }
        });
    };

    private final Listener parserListener = e -> {
        if (parentComposite == null) {
            return;
        }
        UiSync.exec(parentComposite, () -> {
            if (!getSourceViewer().getTextWidget().isDisposed()) {
                setLineBackground();
            }
        });
    };

    public SQLEditor() {
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED,
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
    }

    public boolean isGetChangesJobInProcessing() {
        IEditorPart activeEditor = getEditorSite().getPage().getActiveEditor();
        if(activeEditor == null) {
            return false;
        }

        IEditorInput editorInput = activeEditor.getEditorInput();
        if(editorInput instanceof IFileEditorInput) {
            IProject proj = ((IFileEditorInput)editorInput).getFile().getProject();

            IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            if(workbenchWindow == null) {
                return false;
            }

            IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
            for (IEditorReference ref : workbenchPage.getEditorReferences()) {
                IEditorPart editor = ref.getEditor(true);

                if ((editor != null) && (editor instanceof ProjectEditorDiffer)) {
                    ProjectEditorDiffer projEditor = (ProjectEditorDiffer)editor;

                    if (projEditor.getProject().equals(proj)) {
                        return projEditor.isGetChangesJobInProcessing();
                    }
                }
            }
        }

        return false;
    }

    public boolean isUpdateDdlJobInProcessing() {
        return updateDdlJobInProcessing;
    }

    public void setUpdateDdlJobInProcessing(boolean updateDdlJobInProcessing) {
        this.updateDdlJobInProcessing = updateDdlJobInProcessing;
        getSite().getService(IEvaluationService.class).requestEvaluation(PROP_TEST.UPDATE_DDL_RUNNING);
    }

    public boolean isQuickUpdateJobInProcessing() {
        return quickUpdateJobInProcessing;
    }

    public void setQuickUpdateJobInProcessing(boolean quickUpdateJobInProcessing) {
        this.quickUpdateJobInProcessing = quickUpdateJobInProcessing;
        getSite().getService(IEvaluationService.class).requestEvaluation(PROP_TEST.QUICK_UPDATE_RUNNING);
    }

    public void setLastDb(DbInfo lastDb) {
        IEditorInput editorInput = getEditorSite().getPage().getActiveEditor().getEditorInput();
        if(editorInput instanceof IFileEditorInput) {
            PgDbProject proj = new PgDbProject(((IFileEditorInput)editorInput).getFile().getProject());
            proj.getPrefs().put(PROJ_PREF.LAST_DB_STORE_EDITOR, lastDb.toString());
        }
    }

    public DbInfo getLastDb() {
        IEditorInput editorInput = getEditorSite().getPage().getActiveEditor().getEditorInput();
        if(editorInput instanceof IFileEditorInput) {
            PgDbProject proj = new PgDbProject(((IFileEditorInput)editorInput).getFile().getProject());
            List<DbInfo> lastStore = DbInfo.preferenceToStore(proj.getPrefs().get(PROJ_PREF.LAST_DB_STORE_EDITOR, "")); //$NON-NLS-1$
            return lastStore.isEmpty() ? null : lastStore.get(0);
        } else {
            return null;
        }
    }

    public void setCurrentDb(DbInfo currentDB) {
        this.currentDB = currentDB;
    }

    public DbInfo getCurrentDb() {
        DbInfo db = (currentDB != null) ? currentDB : getLastDb();

        if(DbInfo.preferenceToStore(Activator.getDefault().getPreferenceStore().getString(PREF.DB_STORE))
                .contains(db)) {
            return db;
        }

        return null;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IContentOutlinePage.class.isAssignableFrom(adapter) && fOutlinePage != null) {
            return adapter.cast(fOutlinePage);
        }
        return super.getAdapter(adapter);
    }

    @Override
    public void createPartControl(Composite parent) {
        parentComposite = parent;
        super.createPartControl(parent);
        setLineBackground();
        getSite().getService(IContextService.class).activateContext(CONTEXT.EDITOR);
    }

    public void setLineBackground() {
        // TODO who deletes stale annotations after editor refresh?
        List<PgObjLocation> refs = getParser().getObjsForEditor(getEditorInput());
        IAnnotationModel model = getSourceViewer().getAnnotationModel();
        for (PgObjLocation loc : refs) {
            String annotationMsg = null;
            if (loc.getAction() == StatementActions.DROP && loc.getObjType() == DbObjType.TABLE){
                annotationMsg = "DROP TABLE statement"; //$NON-NLS-1$
            } else if (loc.getAction() == StatementActions.ALTER){
                String text = loc.getText();
                if (loc.getObjType() == DbObjType.TABLE) {
                    if (DangerStatement.ALTER_COLUMN.getRegex().matcher(text).matches()) {
                        annotationMsg = "ALTER COLUMN ... TYPE statement"; //$NON-NLS-1$
                    } else if (DangerStatement.DROP_COLUMN.getRegex().matcher(text).matches()) {
                        annotationMsg = "DROP COLUMN statement"; //$NON-NLS-1$
                    }
                } else if (loc.getObjType() == DbObjType.SEQUENCE &&
                        DangerStatement.RESTART_WITH.getRegex().matcher(text).matches()) {
                    annotationMsg = "ALTER SEQUENCE ... RESTART WITH statement"; //$NON-NLS-1$
                }
            }
            if (annotationMsg != null) {
                model.addAnnotation(new Annotation(MARKER.DANGER_ANNOTATION, false, annotationMsg),
                        new Position(loc.getOffset(), loc.getObjLength()));
            }
        }
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        IResource res = ResourceUtil.getResource(getEditorInput());
        try {
            if (!isProject(res)) {
                refreshParser(getParser(), res, progressMonitor);
            }
        } catch (IOException | InterruptedException | LicenseException | CoreException ex) {
            Log.log(ex);
        }
    }

    @Override
    protected void createActions() {
        super.createActions();
        ResourceBundle bundle = ResourceBundle.getBundle(Messages.getBundleName());
        ContentAssistAction action = new ContentAssistAction(bundle, "contentAssist.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction(CONTENT_ASSIST, action);
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                getSharedColors(), getPreferenceStore(), this));
        setDocumentProvider(new SQLEditorCommonDocumentProvider());

        super.init(site, input);

        try {
            parser = initParser();
        } catch (InterruptedException | IOException | LicenseException | CoreException ex) {
            throw new PartInitException(ex.getLocalizedMessage(), ex);
        }
        parser.addListener(list);

        fOutlinePage = new SQLEditorContentOutlinePage(this);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);

        partListener = new SqlEditorPartListener(this);
        getSite().getPage().addPartListener(partListener);
        getParser().addListener(parserListener);
    }

    private PgDbParser initParser() throws InterruptedException, IOException, LicenseException, CoreException {
        IEditorInput in = getEditorInput();

        IResource res = ResourceUtil.getResource(in);
        if (isProject(res)) {
            return PgDbParser.getParser(res.getProject());
        }

        PgDbParser parser = new PgDbParser();
        if (refreshParser(parser, res, null)) {
            return parser;
        }

        throw new PartInitException("Unknown editor input: " + in); //$NON-NLS-1$
    }

    /**
     * Use only for non-project parsers
     * @param {@link IFileEditorInput} {@link IResource} or null
     * @return true if refresh was triggered successfully
     */
    private boolean refreshParser(PgDbParser parser, IResource res, IProgressMonitor monitor)
            throws InterruptedException, IOException, LicenseException, CoreException {
        if (res instanceof IFile) {
            parser.getObjFromProjFile((IFile) res, monitor);
            return true;
        }

        IEditorInput in = getEditorInput();
        if (in instanceof IURIEditorInput) {
            IURIEditorInput uri = (IURIEditorInput) in;
            IDocument document = getDocumentProvider().getDocument(getEditorInput());
            InputStream stream = new ByteArrayInputStream(document.get().getBytes(StandardCharsets.UTF_8));
            parser.fillRefsFromInputStream(stream, uri.getURI().toString(), monitor);
            return true;
        }
        return false;
    }

    /**
     * @param {@link IFileEditorInput} {@link IResource} or null
     * @throws CoreException
     */
    private boolean isProject(IResource res) throws CoreException {
        return res == null ? false : res.getProject().hasNature(NATURE.ID)
                && PgUIDumpLoader.isInProject(res);
    }

    PgDbParser getParser() {
        return parser;
    }

    @Override
    public void dispose() {
        getSite().getPage().removePartListener(partListener);
        getParser().removeListener(parserListener);

        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        if (parser != null) {
            parser.removeListener(list);
        }
        if (errorTitleImage != null) {
            errorTitleImage.dispose();
        }
        super.dispose();
    }

    private String getReplacedString(String dbInfo, DbInfo externalDbInfo) {
        String s = dbInfo;
        if (externalDbInfo != null) {
            if (externalDbInfo.getDbHost() != null) {
                s = s.replace(DB_HOST_PLACEHOLDER, externalDbInfo.getDbHost());
            }
            if (externalDbInfo.getDbName() != null) {
                s = s.replace(DB_NAME_PLACEHOLDER, externalDbInfo.getDbName());
            }
            if (externalDbInfo.getDbUser() != null) {
                s = s.replace(DB_USER_PLACEHOLDER, externalDbInfo.getDbUser());
            }
            if (externalDbInfo.getDbPass() != null) {
                s = s.replace(DB_PASS_PLACEHOLDER, externalDbInfo.getDbPass());
            }
            int port = externalDbInfo.getDbPort();
            if (port == 0) {
                port = JDBC_CONSTS.JDBC_DEFAULT_PORT;
            }
            s = s.replace(DB_PORT_PLACEHOLDER, "" + port); //$NON-NLS-1$
        }
        return s;
    }

    private void afterScriptFinished(final String scriptOutput) {
        UiSync.exec(parentComposite, new Runnable() {

            @Override
            public void run() {
                if (!isUpdateDdlJobInProcessing()) {
                    parentComposite.setCursor(null);

                    if (mainPrefs.getBoolean(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                        new ScriptRunResultDialog(parentComposite.getShell(), scriptOutput).open();
                    }
                }
                isRunning = false;
            }
        });
    }

    public String getEditorText() {
        return getSourceViewer().getTextWidget().getText();
    }

    public void updateDdl() {
        if (!isRunning) {
            final String textRetrieved;
            Point point = getSourceViewer().getSelectedRange();
            IDocument document = getSourceViewer().getDocument();
            if (point.y == 0){
                textRetrieved = document.get();
            } else {
                try {
                    textRetrieved = document.get(point.x, point.y);
                } catch (BadLocationException ble){
                    Log.log(Log.LOG_WARNING, ble.getMessage());
                    ExceptionNotifier.notifyDefault(Messages.SqlEditor_selected_text_error, ble);
                    return;
                }
            }
            // new runnable to unlock the UI thread
            Runnable launcher;

            if (!mainPrefs.getBoolean(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE)){
                Log.log(Log.LOG_INFO, "Running DDL update using JDBC"); //$NON-NLS-1$

                DbInfo dbInfo = getCurrentDb();
                if (dbInfo == null){
                    ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
                    return;
                }

                final String jdbcHost = dbInfo.getDbHost();
                final int jdbcPort = dbInfo.getDbPort();
                final String jdbcUser = dbInfo.getDbUser();
                final String jdbcPass = dbInfo.getDbPass();
                final String jdbcDbName = dbInfo.getDbName();

                launcher = new Runnable() {

                    @Override
                    public void run() {
                        String output = Messages.sqlScriptDialog_script_has_not_been_run_yet;
                        try{
                            setUpdateDdlJobInProcessing(true);

                            JdbcConnector connector = new JdbcConnector(
                                    jdbcHost, jdbcPort, jdbcUser, jdbcPass, jdbcDbName,
                                    ApgdiffConsts.UTC);
                            output = new JdbcRunner(connector).runScript(textRetrieved);
                            if (JDBC_CONSTS.JDBC_SUCCESS.equals(output)) {
                                output = Messages.SqlEditor_jdbc_success;
                                ProjectEditorDiffer.notifyDbChanged(dbInfo);
                            }
                        } catch (IOException e) {
                            throw new IllegalStateException(e.getLocalizedMessage(), e);
                        } finally {
                            setUpdateDdlJobInProcessing(false);

                            // request UI change: button label changed
                            afterScriptFinished(output);
                        }
                    }
                };
            } else {
                Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$
                try {
                    history.addHistoryEntry(mainPrefs.getString(DB_UPDATE_PREF.MIGRATION_COMMAND_SCRIPT));
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.SqlScriptDialog_error_adding_command_history, e);
                }
                final List<String> command = new ArrayList<>(Arrays.asList(
                        getReplacedString(mainPrefs.getString(DB_UPDATE_PREF.MIGRATION_COMMAND_SCRIPT), currentDB)
                        .split(" "))); //$NON-NLS-1$

                launcher = new RunScriptExternal(textRetrieved, command);
            }
            // run thread that calls StdStreamRedirector.launchAndRedirect()
            scriptThread = new Thread(launcher);
            scriptThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.sqlScriptDialog_exception_during_script_execution,e);
                }
            });

            ScriptThreadJobWrapper scriptThreadJobWrapper = new ScriptThreadJobWrapper(scriptThread);
            scriptThreadJobWrapper.addJobChangeListener(new JobChangeAdapter() {
                @Override
                public void done(IJobChangeEvent event) {
                    setLastDb(currentDB);
                }
            });
            scriptThreadJobWrapper.schedule();

            isRunning = true;
            parentComposite.setCursor(parentComposite.getDisplay().getSystemCursor(SWT.CURSOR_WAIT));
            // case Stop script
        } else {
            ConsoleFactory.write(Messages.sqlScriptDialog_script_execution_interrupted);
            Log.log(Log.LOG_INFO, "Script execution interrupted by user"); //$NON-NLS-1$

            scriptThread.interrupt();
            isRunning = false;
        }
    }

    private class ScriptThreadJobWrapper extends Job {
        private final Thread scriptThread;

        ScriptThreadJobWrapper(Thread scriptThread) {
            super(Messages.SqlEditor_update_ddl);
            this.scriptThread = scriptThread;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                Log.log(Log.LOG_INFO, "Update DDL starting"); //$NON-NLS-1$
                monitor.beginTask(Messages.SqlEditor_update_ddl, 100);
                monitor.worked(50);

                scriptThread.start();

                while(scriptThread.isAlive()) {
                    if(monitor.isCanceled()) {
                        ConsoleFactory.write(Messages.sqlScriptDialog_script_execution_interrupted);
                        Log.log(Log.LOG_INFO, "Script execution interrupted by user"); //$NON-NLS-1$

                        scriptThread.interrupt();
                        isRunning = false;
                        return Status.CANCEL_STATUS;
                    }
                }

                monitor.worked(50);
            } finally {
                monitor.done();
            }
            return Status.OK_STATUS;
        }
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        IResource file = ResourceUtil.getResource(getEditorInput());
        IResourceDelta delta = event.getDelta();
        if (delta != null && file != null) {
            IResourceDelta child = delta.findMember(file.getFullPath());
            if (child != null && (child.getFlags() & IResourceDelta.MARKERS) != 0) {
                UiSync.exec(parentComposite, new Runnable() {
                    @Override
                    public void run() {
                        if (!parentComposite.isDisposed()) {
                            firePropertyChange(IWorkbenchPart.PROP_TITLE);
                        }
                    }
                });
            }
        }
    }

    @Override
    public Image getTitleImage() {
        Image image = super.getTitleImage();
        try {
            IEditorInput input = getEditorInput();
            IResource file = ResourceUtil.getResource(input);
            if (input.exists() && file != null
                    && file.findMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO).length > 0) {
                if (errorTitleImage == null) {
                    errorTitleImage = new DecorationOverlayIcon(image,
                            PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
                                    ISharedImages.IMG_DEC_FIELD_ERROR), IDecoration.BOTTOM_LEFT)
                            .createImage();
                }
                return errorTitleImage;
            }
        } catch (CoreException e) {
            Log.log(e);
        }
        return image;
    }

    private class RunScriptExternal implements Runnable {
        private final String textRetrieved;
        private final List<String> command;

        RunScriptExternal(String textRetrieved, List<String> command) {
            this.textRetrieved = textRetrieved;
            this.command = command;
        }

        @Override
        public void run() {
            final StdStreamRedirector sr = new StdStreamRedirector();
            try (TempFile tempFile = new TempFile("tmp_migration_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
                File outFile = tempFile.get().toFile();
                try (PrintWriter writer = new PrintWriter(outFile, ApgdiffConsts.UTF_8)) {
                    writer.write(textRetrieved);
                }

                String filepath = outFile.getAbsolutePath();
                ListIterator<String> it = command.listIterator();
                while (it.hasNext()) {
                    it.set(it.next().replace(SCRIPT_PLACEHOLDER, filepath));
                }

                ProcessBuilder pb = new ProcessBuilder(command);
                sr.launchAndRedirect(pb);
            } catch (IOException ex) {
                throw new IllegalStateException(ex.getLocalizedMessage(), ex);
            } finally {
                // request UI change: button label changed
                afterScriptFinished(sr.getStorage());
            }
        }
    }

    private static class ScriptRunResultDialog extends TrayDialog {
        private final String text;

        ScriptRunResultDialog(Shell shell, String text) {
            super(shell);
            this.text = text;
            setShellStyle(getShellStyle() | SWT.RESIZE);
        }

        @Override
        protected void configureShell(Shell newShell) {
            super.configureShell(newShell);
            newShell.setText(Messages.sqlScriptDialog_script_output);
        }

        @Override
        protected Control createDialogArea(Composite parent) {
            Composite comp = (Composite) super.createDialogArea(parent);
            Text filed = new Text(comp, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                    | SWT.READ_ONLY | SWT.MULTI);
            filed.setText(text);
            filed.setBackground(getShell().getDisplay().getSystemColor(
                    SWT.COLOR_LIST_BACKGROUND));
            filed.setFont(JFaceResources.getTextFont());
            PixelConverter pc = new PixelConverter(filed);
            GridData gd = new GridData(GridData.FILL_BOTH);
            gd.widthHint = pc.convertWidthInCharsToPixels(80);
            gd.heightHint = pc.convertHeightInCharsToPixels(30);
            filed.setLayoutData(gd);
            return comp;
        }

        @Override
        protected void createButtonsForButtonBar(Composite parent) {
            createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        }
    }

    private static class SqlEditorPartListener extends IPartAdapter2 {
        private final SQLEditor sqlEditor;

        public SqlEditorPartListener(SQLEditor sqlEditor) {
            this.sqlEditor = sqlEditor;
        }

        @Override
        public void partClosed(IWorkbenchPartReference partRef) {
            if (partRef.getPart(false) == sqlEditor && !PlatformUI.getWorkbench().isClosing()
                    && sqlEditor.getEditorInput() instanceof IFileEditorInput) {
                IFile f = ((IFileEditorInput) sqlEditor.getEditorInput()).getFile();
                if (PROJ_PATH.MIGRATION_DIR.equals(f.getProjectRelativePath().segment(0))) {
                    sqlEditor.askDeleteScript(f);
                }
            }
        }
    }

    public void askDeleteScript(IFile f) {
        String mode = mainPrefs.getString(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE);
        // if select "YES" with toggle
        if (mode.equals(MessageDialogWithToggle.ALWAYS)){
            deleteFile(f);
            // if not select "NO" with toggle, show choice message dialog
        } else if (!mode.equals(MessageDialogWithToggle.NEVER)){
            MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getSite().getShell(),
                    Messages.SqlEditor_script_delete_dialog_title, MessageFormat.format(
                            Messages.SqlEditor_script_delete_dialog_message, f.getName()),
                    Messages.remember_choice_toggle, false, mainPrefs, DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE);
            if(dialog.getReturnCode() == IDialogConstants.YES_ID){
                deleteFile(f);
            }
        }
    }

    private void deleteFile(IFile f) {
        try {
            Log.log(Log.LOG_INFO, "Deleting file " + f.getName()); //$NON-NLS-1$
            f.delete(true, null);
        } catch (CoreException ex) {
            Log.log(ex);
        }
    }
}