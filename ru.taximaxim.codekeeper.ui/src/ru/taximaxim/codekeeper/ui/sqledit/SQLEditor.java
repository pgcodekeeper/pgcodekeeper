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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.progress.IProgressConstants2;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.IProgressReporter;
import ru.taximaxim.codekeeper.core.fileutils.TempFile;
import ru.taximaxim.codekeeper.core.loader.AbstractJdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcRunner;
import ru.taximaxim.codekeeper.core.parsers.antlr.ScriptParser;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.ITextErrorReporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.CMD_VARS;
import ru.taximaxim.codekeeper.ui.UIConsts.CONTEXT;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_BIND_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.SQL_EDITOR_PREF;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfoJdbcConnector;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.handlers.AddBuilder;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.propertytests.UpdateDdlJobTester;

public class SQLEditor extends AbstractDecoratedTextEditor
implements IResourceChangeListener, ITextErrorReporter {

    static final String CONTENT_ASSIST = "ContentAssist"; //$NON-NLS-1$

    private static final int JDBC_DEFAULT_PORT = 5432;

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private SqlEditorPartListener partListener;

    private DbInfo currentDB;

    private Composite parentComposite;
    private SQLEditorContentOutlinePage fOutlinePage;
    private Image errorTitleImage;
    private PgDbParser parser;
    private DatabaseType dbType = DatabaseType.PG;
    private boolean isLargeFile;

    private Annotation[] occurrenceAnnotations = null;

    private ScriptThreadJobWrapper scriptThreadJobWrapper;

    private EditorSelectionChangedListener changedListener;

    private final Listener parserListener = e -> refreshReferences();

    public DatabaseType getDbType() {
        return dbType;
    }

    public void saveLastDb(DbInfo lastDb) {
        saveLastDb(lastDb, getEditorInput());
    }

    public static void saveLastDb(DbInfo lastDb, IEditorInput inputForProject) {
        IResource res = ResourceUtil.getResource(inputForProject);
        if (res != null) {
            IEclipsePreferences prefs = PgDbProject.getPrefs(res.getProject(), false);
            if (prefs != null) {
                prefs.put(DB_BIND_PREF.LAST_DB_STORE_EDITOR, lastDb.getName());
                try {
                    prefs.flush();
                } catch (BackingStoreException ex) {
                    Log.log(ex);
                }
            }
        }
    }

    public void setCurrentDb(DbInfo currentDB) {
        this.currentDB = currentDB;
    }

    public void refreshReferences() {
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
            if (getSourceViewer() != null && getSourceViewer().getTextWidget() != null
                    && !getSourceViewer().getTextWidget().isDisposed()) {
                setLineBackground();
            }
        });
    }

    public DbInfo getCurrentDb() {
        // it's need to do for refresh content and state of DbCombo in SQLEditor
        // when it's opened as inactive second tab, while setting the binding in
        // project properties
        DbInfo boundDb = getDbFromPref(DB_BIND_PREF.NAME_OF_BOUND_DB);
        if (boundDb != null) {
            return boundDb;
        }

        if (currentDB != null) {
            return currentDB;
        }

        return getDbFromPref(DB_BIND_PREF.LAST_DB_STORE_EDITOR);
    }

    private DbInfo getDbFromPref(String prefName) {
        IEclipsePreferences auxPrefs = getProjDbBindPrefs();
        return auxPrefs == null ? null : DbInfo.getLastDb(auxPrefs.get(prefName, ""), dbType); //$NON-NLS-1$
    }

    public IEclipsePreferences getProjDbBindPrefs() {
        IResource res = ResourceUtil.getResource(getEditorInput());
        return res != null ? PgDbProject.getPrefs(res.getProject(), false) : null;
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

        changedListener = new EditorSelectionChangedListener();
        changedListener.install(getSelectionProvider());

        getSite().getService(IContextService.class).activateContext(CONTEXT.EDITOR);
    }

    public void setLineBackground() {
        // TODO who deletes stale annotations after editor refresh?
        IAnnotationModel model = getSourceViewer().getAnnotationModel();
        for (PgObjLocation loc : getReferences()) {
            if (loc.isDanger()) {
                model.addAnnotation(new Annotation(MARKER.DANGER_ANNOTATION, false,
                        getWarningText(loc.getDanger())),
                        new Position(loc.getOffset(), loc.getObjLength()));
            }
        }
    }

    private String getWarningText(DangerStatement danger) {
        return switch (danger) {
            case ALTER_COLUMN -> "ALTER COLUMN ... TYPE statement"; //$NON-NLS-1$
            case DROP_COLUMN -> "DROP COLUMN statement"; //$NON-NLS-1$
            case DROP_TABLE -> "DROP TABLE statement"; //$NON-NLS-1$
            case RESTART_WITH -> "ALTER SEQUENCE ... RESTART WITH statement"; //$NON-NLS-1$
            case UPDATE -> "UPDATE statement"; //$NON-NLS-1$
            default -> null;
        };
    }

    private Set<PgObjLocation> getReferences() {
        return getParser().getObjsForEditor(getEditorInput());
    }

    @Override
    // NOTE: this method's monitor is weird / useless / bad, do not use it
    // see Eclipse bug 543782
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        refreshParser();
    }

    public void doFormat() {
        ((SourceViewer) getSourceViewer()).doOperation(ISourceViewer.FORMAT);
    }

    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    @Override
    protected void createActions() {
        super.createActions();
        ResourceBundle bundle = ResourceBundle.getBundle(Messages.getBundleName());
        ContentAssistAction action = new ContentAssistAction(bundle, "contentAssist.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction(CONTENT_ASSIST, action);
    }

    public PgObjLocation getCurrentReference() {
        ISelectionProvider provider = getSelectionProvider();
        if (provider == null) {
            return null;
        }

        ISelection selection = provider.getSelection();
        if (selection instanceof ITextSelection textSelection) {
            return getObjectAtOffset(textSelection.getOffset(), true);
        }

        return null;
    }

    public PgObjLocation getObjectAtOffset(int offset, boolean includeNextPos) {
        for (PgObjLocation obj : getReferences()) {
            int endPos = obj.getOffset() + obj.getObjLength();
            if (includeNextPos) {
                endPos++;
            }
            if (offset >= obj.getOffset() && offset < endPos) {
                return obj;
            }
        }
        return null;
    }

    public void changeLanguage(DatabaseType dbType) {
        IResource res = ResourceUtil.getResource(getEditorInput());
        try {
            if (res == null || !UIProjectLoader.isInProject(res)) {
                this.dbType = dbType;
                refreshParser(getParser(), res, null);
            }
        } catch (InterruptedException | IOException | CoreException ex) {
            Log.log(ex);
        }
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setDocumentProvider(new SQLEditorCommonDocumentProvider());

        super.init(site, input);
        checkFileSize();

        try {
            checkBuilder();
            parser = initParser();
        } catch (PartInitException ex) {
            throw ex;
        } catch (InterruptedException | IOException | CoreException ex) {
            throw new PartInitException(ex.getLocalizedMessage(), ex);
        } catch (Exception ex) {
            // do not destroy UI and create empty parser, if have unexpected error
            Log.log(ex);
            parser = new PgDbParser();
        }
        parser.addListener(parserListener);

        fOutlinePage = new SQLEditorContentOutlinePage(this);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);

        partListener = new SqlEditorPartListener();
        getSite().getPage().addPartListener(partListener);

        if (isLargeFile()) {
            IWorkbenchPage page = getSite().getPage();
            IViewPart part = page.showView(IPageLayout.ID_OUTLINE, null, IWorkbenchPage.VIEW_CREATE);
            IWorkbenchPartReference ref = page.getReference(part);
            if (IWorkbenchPage.STATE_MINIMIZED == page.getPartState(ref)) {
                page.setPartState(ref, IWorkbenchPage.STATE_RESTORED);
            }
        }
    }

    public boolean isLargeFile() {
        return isLargeFile;
    }

    private void checkFileSize() {
        int lines = getDocumentProvider().getDocument(getEditorInput()).getNumberOfLines();
        int maxLines = mainPrefs.getInt(SQL_EDITOR_PREF.NUMBER_OF_LINES_LIMIT);
        isLargeFile = maxLines != 0 && lines > maxLines;
    }

    @Override
    protected void doSetInput(IEditorInput input) throws CoreException {
        setPreferenceStore(createCombinedPreferenceStore());
        super.doSetInput(input);
    }

    private IPreferenceStore createCombinedPreferenceStore() {
        List<IPreferenceStore> stores = new ArrayList<>(2);
        stores.add(mainPrefs);
        stores.add(EditorsUI.getPreferenceStore());
        return new ChainedPreferenceStore(stores.toArray(new IPreferenceStore[stores.size()]));
    }

    @Override
    protected void initializeEditor() {
        // already initialize in this moment
    }

    @Override
    protected void setPreferenceStore(IPreferenceStore store) {
        super.setPreferenceStore(store);
        if (getSourceViewerConfiguration() == null) {
            setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                    getSharedColors(), store, this));
        }
    }

    @Override
    protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
        char[] brackets = {'(', ')', '[', ']'};
        ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(brackets,
                SQLEditorCommonDocumentProvider.SQL_PARTITIONING);
        support.setCharacterPairMatcher(matcher);
        support.setMatchingCharacterPainterPreferenceKeys(SQL_EDITOR_PREF.MATCHING_BRACKETS,
                SQL_EDITOR_PREF.MATCHING_BRACKETS_COLOR,
                SQL_EDITOR_PREF.HIGHLIGHT_BRACKET_AT_CARET_LOCATION,
                SQL_EDITOR_PREF.ENCLOSING_BRACKETS);

        super.configureSourceViewerDecorationSupport(support);
    }

    private void checkBuilder() {
        IResource resource = ResourceUtil.getResource(getEditorInput());
        IProject proj = resource == null ? null : resource.getProject();
        if (OpenProjectUtils.isPgCodeKeeperProject(proj) && !AddBuilder.hasBuilder(proj)) {
            MessageBox mb = new MessageBox(getEditorSite().getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
            mb.setText(Messages.SqlEditor_absent_builder_title);
            mb.setMessage(Messages.SqlEditor_absent_builder_message);
            if (mb.open() == SWT.YES) {
                AddBuilder.addBuilder(proj);
            }
        }
    }

    private PgDbParser initParser() throws InterruptedException, IOException, CoreException {
        if (isLargeFile()) {
            return new PgDbParser();
        }

        IEditorInput in = getEditorInput();
        IResource res = ResourceUtil.getResource(in);
        String projName = null;

        if (res != null) {
            dbType = OpenProjectUtils.getDatabaseType(res.getProject());
        } else if (in instanceof SQLEditorInput sqlEditor) {
            dbType = sqlEditor.getDbType();
            projName = sqlEditor.getProject();
        }

        if (res != null && UIProjectLoader.isInProject(res)) {
            return PgDbParser.getParser(res);
        }

        if (null != projName) {
            IProject proj = ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
            if (proj != null) {
                return PgDbParser.getParser(proj);
            }
        }

        return createNewParser(res);
    }

    private PgDbParser createNewParser(IResource res) throws InterruptedException, IOException, CoreException {
        PgDbParser pgDbParser = new PgDbParser();
        refreshParser(pgDbParser, res, null);
        return pgDbParser;
    }

    void refreshParser() {
        IResource res = ResourceUtil.getResource(getEditorInput());
        try {
            if (res == null || !UIProjectLoader.isInProject(res)) {
                refreshParser(getParser(), res, new NullProgressMonitor());
            }
        } catch (InterruptedException | IOException | CoreException ex) {
            Log.log(ex);
        }
    }

    /**
     * Use only for non-project parsers
     * @param {@link IFileEditorInput} {@link IResource} or null
     * @return true if refresh was triggered successfully
     */
    private void refreshParser(PgDbParser parser, IResource res, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        checkFileSize();
        if (isLargeFile()) {
            parser.clear();
            parser.notifyListeners();
            return;
        }

        if (res instanceof IFile file) {
            IProject proj = file.getProject();
            IEclipsePreferences prefs = PgDbProject.getPrefs(proj, true);

            if (prefs != null && prefs.getBoolean(PROJ_PREF.DISABLE_PARSER_IN_EXTERNAL_FILES, false)) {
                return;
            }

            if (OpenProjectUtils.isPgCodeKeeperProject(proj)) {
                parser.getObjFromProjFile(file, monitor, dbType);
                return;
            }
        }

        IEditorInput in = getEditorInput();
        if (in.exists() && in instanceof IURIEditorInput uriInput) {
            IDocument document = getDocumentProvider().getDocument(in);
            InputStream stream = new ByteArrayInputStream(document.get().getBytes(StandardCharsets.UTF_8));
            String name = Paths.get(uriInput.getURI()).toString();
            parser.fillRefsFromInputStream(stream, name, dbType, monitor);
        }
    }

    PgDbParser getParser() {
        return parser;
    }

    @Override
    public void dispose() {
        if (partListener != null) {
            getSite().getPage().removePartListener(partListener);
        }
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        if (parser != null) {
            parser.removeListener(parserListener);
        }
        if (errorTitleImage != null) {
            errorTitleImage.dispose();
        }

        if (changedListener != null) {
            changedListener.uninstall(getSelectionProvider());
            changedListener = null;
        }

        removeOccurrenceAnnotations();

        super.dispose();
    }

    private void removeOccurrenceAnnotations() {
        IDocumentProvider provider = getDocumentProvider();
        if (provider == null) {
            return;
        }

        IAnnotationModel model = provider.getAnnotationModel(getEditorInput());
        if (model == null || occurrenceAnnotations == null) {
            return;
        }

        synchronized (getLock(model)) {
            if (model instanceof IAnnotationModelExtension ext) {
                ext.replaceAnnotations(occurrenceAnnotations, null);
            } else {
                for (Annotation annotation : occurrenceAnnotations) {
                    model.removeAnnotation(annotation);
                }
            }

            occurrenceAnnotations = null;
        }
    }

    private Object getLock(IAnnotationModel model) {
        if (model instanceof ISynchronizable sync) {
            Object lock = sync.getLockObject();
            if (lock != null) {
                return lock;
            }
        }

        return model;
    }

    private void afterScriptFinished() {
        UiSync.exec(parentComposite, () -> {
            if (!parentComposite.isDisposed()) {
                parentComposite.setCursor(null);
            }
        });
    }

    public String getEditorText() {
        return getSourceViewer().getTextWidget().getText();
    }

    public void cancelDdl() {
        scriptThreadJobWrapper.cancel();
    }

    public void updateDdl() {
        DbInfo dbInfo = currentDB;
        if (dbInfo == null) {
            ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
            return;
        }

        final String textRetrieved;
        Point point = getSourceViewer().getSelectedRange();
        IDocument document = getSourceViewer().getDocument();
        if (point.y == 0) {
            textRetrieved = document.get();
        } else {
            try {
                textRetrieved = document.get(point.x, point.y);
            } catch (BadLocationException ble) {
                Log.log(Log.LOG_WARNING, ble.getMessage());
                ExceptionNotifier.notifyDefault(Messages.SqlEditor_selected_text_error, ble);
                return;
            }
        }

        ScriptParser[] parsers = new ScriptParser[1];
        IRunnableWithProgress runnable = monitor -> {
            try {
                ScriptParser scriptParser = new ScriptParser(
                        getEditorInput().getName(), textRetrieved, dbInfo.getDbType());
                String error = scriptParser.getErrorMessage();
                if (error != null) {
                    UiProgressReporter.writeSingleError(error);
                } else {
                    parsers[0] = scriptParser;
                }
            } catch (InterruptedException | IOException ex) {
                UiProgressReporter.writeSingleError(ex.getLocalizedMessage());
            }
        };

        try {
            new ProgressMonitorDialog(parentComposite.getShell()).run(true, true, runnable);
        } catch (InterruptedException | InvocationTargetException ex) {
            Log.log(ex);
        }

        if (parsers[0] == null) {
            return;
        }

        if (parsers[0].isDangerDdl(DangerStatement.getAllowedDanger(
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.RESTART_WITH_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.UPDATE_STATEMENT)))) {

            MessageBox mb = new MessageBox(parentComposite.getShell(),
                    SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
            mb.setText(Messages.sqlScriptDialog_warning);
            mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data);

            if (mb.open() != SWT.OK) {
                return;
            }
        }

        scriptThreadJobWrapper = new ScriptThreadJobWrapper(dbInfo, parsers[0], point.y == 0 ? 0 : point.x);
        scriptThreadJobWrapper.setProperty(IProgressConstants2.SHOW_IN_TASKBAR_ICON_PROPERTY, Boolean.TRUE);
        scriptThreadJobWrapper.setUser(true);
        scriptThreadJobWrapper.schedule();

        saveLastDb(dbInfo);
        parentComposite.setCursor(parentComposite.getDisplay().getSystemCursor(SWT.CURSOR_WAIT));
    }

    @Override
    public void setErrorPosition(int start, int length) {
        UiSync.exec(parentComposite, () -> {
            if (!parentComposite.isDisposed()) {
                selectAndReveal(start, length);
            }
        });
    }

    private class ScriptThreadJobWrapper extends SingletonEditorJob {

        private final DbInfo dbInfo;
        private final ScriptParser parser;
        private final int offset;

        public ScriptThreadJobWrapper(DbInfo dbInfo, ScriptParser parser, int offset) {
            super(Messages.SqlEditor_update_ddl + getEditorInput().getName(),
                    SQLEditor.this, UpdateDdlJobTester.EVAL_PROP);
            this.dbInfo = dbInfo;
            this.parser = parser;
            this.offset = offset;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            SubMonitor.convert(monitor).setTaskName(Messages.SqlEditor_update_ddl);
            return mainPrefs.getBoolean(DB_UPDATE_PREF.COMMAND_LINE_DDL_UPDATE) ?
                    runExternal(monitor) : runInternal(monitor);
        }

        private IStatus runInternal(IProgressMonitor monitor) {
            Log.log(Log.LOG_INFO, "Running DDL update using JDBC"); //$NON-NLS-1$

            AbstractJdbcConnector connector = new DbInfoJdbcConnector(dbInfo);

            IProgressReporter reporter = new UiProgressReporter(monitor, SQLEditor.this, offset, dbInfo.getName());
            try (IProgressReporter toClose = reporter) {
                new JdbcRunner(monitor).runBatches(connector, parser.batch(), reporter);
                ProjectEditorDiffer.notifyDbChanged(dbInfo);
                return Status.OK_STATUS;
            } catch (InterruptedException ex) {
                reporter.writeError(ex.getLocalizedMessage());
                return Status.CANCEL_STATUS;
            } catch (SQLException | IOException e) {
                reporter.writeError(e.getLocalizedMessage());
                return new Status(IStatus.WARNING, PLUGIN_ID.THIS,
                        Messages.sqlScriptDialog_exception_during_script_execution, e);
            } finally {
                afterScriptFinished();
            }
        }

        private IStatus runExternal(IProgressMonitor monitor) {
            Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$

            Thread scriptThread = null;
            try (UiProgressReporter reporter = new UiProgressReporter(monitor, SQLEditor.this)) {
                scriptThread = new Thread(new RunScriptExternal(parser.getScript(),
                        reporter, new ArrayList<>(Arrays.asList(
                                getReplacedCmd(mainPrefs.getString(DB_UPDATE_PREF.MIGRATION_COMMAND), dbInfo).split(" "))))); //$NON-NLS-1$
                scriptThread.setUncaughtExceptionHandler((t, e) ->  ExceptionNotifier.notifyDefault(
                        Messages.sqlScriptDialog_exception_during_script_execution, e));
                scriptThread.start();

                while (scriptThread.isAlive()) {
                    Thread.sleep(20);
                    if (monitor.isCanceled()) {
                        reporter.writeMessage(Messages.sqlScriptDialog_script_execution_interrupted);
                        Log.log(Log.LOG_INFO, "Script execution interrupted by user"); //$NON-NLS-1$

                        scriptThread.interrupt();
                        return Status.CANCEL_STATUS;
                    }
                }
                return Status.OK_STATUS;
            } catch (InterruptedException ex) {
                scriptThread.interrupt();
                Thread.currentThread().interrupt();
                return Status.CANCEL_STATUS;
            } finally {
                monitor.done();
            }
        }

        private String getReplacedCmd(String cmd, DbInfo externalDbInfo) {
            String s = cmd;
            if (externalDbInfo != null) {
                if (externalDbInfo.getDbHost() != null) {
                    s = s.replace(CMD_VARS.DB_HOST_PLACEHOLDER, externalDbInfo.getDbHost());
                }
                if (externalDbInfo.getDbName() != null) {
                    s = s.replace(CMD_VARS.DB_NAME_PLACEHOLDER, externalDbInfo.getDbName());
                }
                if (externalDbInfo.getDbUser() != null) {
                    s = s.replace(CMD_VARS.DB_USER_PLACEHOLDER, externalDbInfo.getDbUser());
                }
                if (externalDbInfo.getDbPass() != null) {
                    s = s.replace(CMD_VARS.DB_PASS_PLACEHOLDER, externalDbInfo.getDbPass());
                }
                int port = externalDbInfo.getDbPort();
                if (port == 0) {
                    port = JDBC_DEFAULT_PORT;
                }
                s = s.replace(CMD_VARS.DB_PORT_PLACEHOLDER, "" + port); //$NON-NLS-1$
            }
            return s;
        }
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        IResource file = ResourceUtil.getResource(getEditorInput());
        IResourceDelta delta = event.getDelta();
        if (delta != null && file != null) {
            IResourceDelta child = delta.findMember(file.getFullPath());
            if (child != null && (child.getFlags() & IResourceDelta.MARKERS) != 0) {
                UiSync.exec(parentComposite, () -> {
                    if (!parentComposite.isDisposed()) {
                        firePropertyChange(IWorkbenchPart.PROP_TITLE);
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
        private final UiProgressReporter reporter;

        RunScriptExternal(String textRetrieved, UiProgressReporter reporter, List<String> command) {
            this.textRetrieved = textRetrieved;
            this.command = command;
            this.reporter = reporter;
        }

        @Override
        public void run() {
            final StdStreamRedirector sr = new StdStreamRedirector(reporter);
            try (TempFile tempFile = new TempFile("tmp_migration_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
                File outFile = tempFile.get().toFile();
                try (PrintWriter writer = new PrintWriter(outFile, Consts.UTF_8)) {
                    writer.write(textRetrieved);
                }

                String filepath = outFile.getAbsolutePath();
                ListIterator<String> it = command.listIterator();
                while (it.hasNext()) {
                    it.set(it.next().replace(CMD_VARS.SCRIPT_PLACEHOLDER, filepath));
                }

                ProcessBuilder pb = new ProcessBuilder(command);
                sr.launchAndRedirect(pb);
            } catch (IOException ex) {
                throw new IllegalStateException(ex.getLocalizedMessage(), ex);
            } finally {
                reporter.terminate();
                afterScriptFinished();
            }
        }
    }

    private class EditorSelectionChangedListener extends AbstractSelectionChangedListener {

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            // remove occurrences in modified file
            if (isDirty()) {
                removeOccurrenceAnnotations();
                return;
            }

            PgObjLocation selected = getCurrentReference();
            IDocumentProvider provider = getDocumentProvider();
            if (selected == null || provider == null) {
                return;
            }

            Map<Annotation, Position> annotations = new HashMap<>();
            for (PgObjLocation loc : getReferences()) {
                if (loc.compare(selected)) {
                    annotations.put(new Annotation(MARKER.OBJECT_OCCURRENCE, false, loc.toString()),
                            new Position(loc.getOffset(), loc.getObjLength()));
                }
            }

            IAnnotationModel model = provider.getAnnotationModel(getEditorInput());
            if (model == null) {
                return;
            }

            synchronized (getLock(model)) {
                if (model instanceof IAnnotationModelExtension ext) {
                    ext.replaceAnnotations(occurrenceAnnotations, annotations);
                } else {
                    removeOccurrenceAnnotations();
                    for (Entry<Annotation, Position> entry : annotations.entrySet()) {
                        model.addAnnotation(entry.getKey(), entry.getValue());
                    }
                }

                occurrenceAnnotations = annotations.keySet().toArray(new Annotation[annotations.size()]);
            }
        }
    }

    private class SqlEditorPartListener extends IPartAdapter2 {

        @Override
        public void partClosed(IWorkbenchPartReference partRef) {
            if (partRef.getPart(false) == SQLEditor.this && !PlatformUI.getWorkbench().isClosing()
                    && getEditorInput() instanceof IFileEditorInput fileInput) {
                IFile f = fileInput.getFile();
                if (PROJ_PATH.MIGRATION_DIR.equals(f.getProjectRelativePath().segment(0))) {
                    askDeleteScript(f);
                }
            }
        }
    }

    public void askDeleteScript(IFile f) {
        String mode = mainPrefs.getString(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE);
        // if select "YES" with toggle
        if (mode.equals(MessageDialogWithToggle.ALWAYS)) {
            deleteFile(f);
            // if not select "NO" with toggle, show choice message dialog
        } else if (!mode.equals(MessageDialogWithToggle.NEVER)) {
            MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getSite().getShell(),
                    Messages.SqlEditor_script_delete_dialog_title, MessageFormat.format(
                            Messages.SqlEditor_script_delete_dialog_message, f.getName()),
                    Messages.remember_choice_toggle, false, mainPrefs, DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE);
            if (dialog.getReturnCode() == IDialogConstants.YES_ID) {
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
    /*
    @Override
    protected boolean isTabsToSpacesConversionEnabled() {
        return FORMATTER_PREF.TAB.equals(mainPrefs.getString(FORMATTER_PREF.INDENT_TYPE));
    }

    @Override
    protected boolean isSpacesAsTabsDeletionEnabled() {
        return false;
    }
     */
}
