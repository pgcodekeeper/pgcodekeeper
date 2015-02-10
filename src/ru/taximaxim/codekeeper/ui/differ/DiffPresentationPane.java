package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.layout.PixelConverter;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DBSources;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class DiffPresentationPane extends Composite {

    // should be true for commit, false for diff script
    private final boolean isProjSrc;

    private final Composite contNotifications;
    private final Button btnUpdateRefreshed;
    protected final DiffTableViewer diffTable;
    private final Composite containerSrc;
    private final Composite containerDb;
    private final Button btnDump, btnPgDump, btnJdbc;
    private final Button btnGetChanges;
    private final Button btnFlipDbPicker;
    protected final DbPicker dbSrc;
    private final DiffPaneViewer diffPane;
    private final Label lblSourceInfo;

    protected DBSources selectedDBSource;
    protected DbSource dbSource;
    protected DbSource dbTarget;
    protected TreeDiffer treeDiffer;

    protected IPreferenceStore mainPrefs;
    protected final PgDbProject proj;
    
    private LocalResourceManager lrm;

    private void setDbSource(DbSource dbSource) {
        this.dbSource = dbSource;
        setDiffPaneDb(isProjSrc, dbSource);
    }

    private void setDbTarget(DbSource dbTarget) {
        this.dbTarget = dbTarget;
        setDiffPaneDb(!isProjSrc, dbTarget);
    }

    private void setDiffPaneDb(boolean isDbSrc, DbSource db) {
        if (diffPane != null) {
            if (isDbSrc) {
                diffPane.setDbSource(db);
            } else { 
                diffPane.setDbTarget(db);    
            }
        }
    }
    
    public DiffTableViewer getDiffTable() {
        return diffTable;
    }
    
    public DiffPresentationPane(Composite parent, boolean projIsSrc,
            final IPreferenceStore mainPrefs, final PgDbProject proj) {
        super(parent, SWT.NONE);

        this.setLayout(new GridLayout());
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        this.isProjSrc = projIsSrc;
        this.proj = proj;
        this.mainPrefs = mainPrefs;
        final IEclipsePreferences projProps = proj.getPrefs();

        // notifications container
        // simplified for 1 static notification
        // refactor into multiple child composites w/ description class
        // for multiple dynamic notifications if necessary
        contNotifications = new Group(this, SWT.BORDER);
        contNotifications.setLayout(new GridLayout(5, false));
        
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = true;
        contNotifications.setVisible(false);
        contNotifications.setLayoutData(gd);
        
        Label lblWarnIcon = new Label(contNotifications, SWT.NONE);
        lblWarnIcon.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONWARNING))));
        lblWarnIcon.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        
        Label lblNotification = new Label(contNotifications, SWT.NONE);
        lblNotification.setText(Messages.DiffPresentationPane_attention);
        lblNotification.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        lblNotification.setForeground(getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
        lblNotification.setFont(lrm.createFont(FontDescriptor.createFrom(
                lblNotification.getFont()).withStyle(SWT.BOLD).increaseHeight(2)));
        
        Label l = new Label(contNotifications, SWT.NONE);
        l.setText(Messages.DiffPresentationPane_project_modified);
        l.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        
        btnUpdateRefreshed = new Button(contNotifications, SWT.PUSH);
        btnUpdateRefreshed.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONREFRESH))));
        btnUpdateRefreshed.setToolTipText(Messages.DiffPresentationPane_refresh_editor);
        btnUpdateRefreshed.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true));
        
        btnUpdateRefreshed.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (isProjSrc && dbTarget.isLoaded()) {
                    setDbTarget(DbSource.fromDbObject(dbTarget.getDbObject(), 
                            dbTarget.getOrigin()));
                } else if (!isProjSrc && dbSource.isLoaded()){
                    setDbSource(DbSource.fromDbObject(dbSource.getDbObject(), 
                            dbSource.getOrigin()));
                }
                loadChanges();
                
                showNotificationArea(false);
            }
        });
        
        Button btnDismissRefresh = new Button(contNotifications, SWT.PUSH | SWT.FLAT);
        btnDismissRefresh.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONCLOSE))));
        btnDismissRefresh.setToolTipText(Messages.DiffPresentationPane_dismiss);
        btnDismissRefresh.setLayoutData(new GridData(SWT.DEFAULT, SWT.BOTTOM, false, true));
        
        btnDismissRefresh.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                showNotificationArea(false);
            }
        });
        // end notifications container

        // upper container
        final Composite containerUpper = new Composite(this, SWT.NONE);
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
        
        // upper middle part
        lblSourceInfo = new Label(containerUpper, SWT.NONE);
        lblSourceInfo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));

        // upper right part
        btnGetChanges = new Button(containerUpper, SWT.PUSH);
        btnGetChanges.setText(Messages.get_changes);
        btnGetChanges.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    showNotificationArea(false);
                    if (fillDbSources(proj, projProps)) {
                        clearInputs();
                        loadChanges();
                        saveDBPrefs(projProps);
                    }
                } catch (PgCodekeeperUIException e1) {
                    ExceptionNotifier.notifyDefault(
                            Messages.DiffPresentationPane_error_loading_changes, e1);
                } catch (BackingStoreException e1) {
                    ExceptionNotifier.notifyDefault(
                            Messages.DiffPresentationPane_cannotSaveDbPropToProjProps, e1);
                }
            }
        });

        gd = new GridData(SWT.RIGHT, SWT.FILL, false, true);
        gd.widthHint = btnGetChanges.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        gd.minimumWidth = btnGetChanges.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        gd.horizontalIndent = 20;
        btnGetChanges.setLayoutData(gd);
        // end upper container

        SashForm sashOuter = new SashForm(this, SWT.VERTICAL | SWT.SMOOTH);
        sashOuter.setLayoutData(new GridData(GridData.FILL_BOTH));

        // middle container
        containerDb = new Composite(sashOuter, SWT.NONE);
        gl = new GridLayout(3, false);
        gl.marginHeight = gl.marginWidth = 0;
        gl.horizontalSpacing = gl.verticalSpacing = 2;
        containerDb.setLayout(gl);

        diffTable = new DiffTableViewer(containerDb, SWT.NONE, mainPrefs, false);
        diffTable.setLayoutData(new GridData(GridData.FILL_BOTH));
        diffTable.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = ((IStructuredSelection) event
                        .getSelection());

                if (selection.size() != 1) {
                    diffPane.setInput(null);
                } else {
                    TreeElement el = (TreeElement) selection.getFirstElement();
                    diffPane.setInput(el);
                }
            }
        });

        // flip button set up
        btnFlipDbPicker = new Button(containerDb, SWT.PUSH | SWT.FLAT);
        btnFlipDbPicker.setText("\u25B8"); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_VERTICAL);
        gd.widthHint = 20;
        btnFlipDbPicker.setLayoutData(gd);
        btnFlipDbPicker.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                flipDbPicker(containerSrc.getVisible());
            }
        });

        // middle right container
        containerSrc = new Composite(containerDb, SWT.NONE);
        gl = new GridLayout(2, false);
        gl.marginHeight = gl.marginWidth = 0;
        containerSrc.setLayout(gl);

        gd = new GridData(SWT.FILL, SWT.FILL, false, true);
        gd.widthHint = new PixelConverter(parent).convertWidthInCharsToPixels(45);
        containerSrc.setLayoutData(gd);

        Group grpSrc = new Group(containerSrc, SWT.NONE);
        grpSrc.setText(isProjSrc ? Messages.commitPartDescr_get_changes_from
                : Messages.diffPartDescr_get_changes_for);
        grpSrc.setLayout(new GridLayout(3, false));

        btnDump = new Button(grpSrc, SWT.RADIO);
        btnDump.setText(Messages.dump);
        btnDump.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(false);
                selectedDBSource = DBSources.SOURCE_TYPE_DUMP;
                lblSourceInfo.setText(getSourceInfoText());
                containerUpper.layout();
            }
        });

        btnPgDump = new Button(grpSrc, SWT.RADIO);
        btnPgDump.setText(Messages.db);
        btnPgDump.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(true);
                selectedDBSource = DBSources.SOURCE_TYPE_DB;
                lblSourceInfo.setText(getSourceInfoText());
                containerUpper.layout();
            }
        });

        btnJdbc = new Button(grpSrc, SWT.RADIO);
        btnJdbc.setText(Messages.jdbc);
        btnJdbc.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showDbPicker(true);
                selectedDBSource = DBSources.SOURCE_TYPE_JDBC;
                lblSourceInfo.setText(getSourceInfoText());
                containerUpper.layout();
            }
        });
        
        dbSrc = new DbPicker(containerSrc, SWT.NONE, mainPrefs, false);
        dbSrc.setText(Messages.db_source);
        dbSrc.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));
        dbSrc.addListener(SWT.Modify, new Listener() {

            @Override
            public void handleEvent(Event event) {
                lblSourceInfo.setText(getSourceInfoText());
            }
        });

        boolean useDbPicker = false;
        selectedDBSource = DBSources.getEnum(projProps.get(PROJ_PREF.SOURCE, "")); //$NON-NLS-1$
        switch (selectedDBSource) {
        case SOURCE_TYPE_DUMP:
            btnDump.setSelection(true);
            break;
        case SOURCE_TYPE_DB:
            btnPgDump.setSelection(true);
            useDbPicker = true;
            break;
        case SOURCE_TYPE_JDBC:
            btnJdbc.setSelection(true);
            useDbPicker = true;
            break;
        }
        showDbPicker(useDbPicker);

        dbSrc.getTxtDbName().setText(projProps.get(PROJ_PREF.DB_NAME, "")); //$NON-NLS-1$
        dbSrc.getTxtDbUser().setText(projProps.get(PROJ_PREF.DB_USER, "")); //$NON-NLS-1$
        dbSrc.getTxtDbHost().setText(projProps.get(PROJ_PREF.DB_HOST, "")); //$NON-NLS-1$
        dbSrc.getTxtDbPort().setText(String.valueOf(projProps.getInt(PROJ_PREF.DB_PORT, 0)));
        // end middle right container
        
        // read flip position from preferences
        flipDbPicker(Activator.getDefault().getPreferenceStore().getBoolean(PREF.IS_FLIPPED_DB_SOURCE));       
        // end middle container

        lblSourceInfo.setText(getSourceInfoText());

        diffPane = new DiffPaneViewer(sashOuter, SWT.NONE, isProjSrc ? dbSource
                : dbTarget, isProjSrc ? dbTarget : dbSource, !isProjSrc);
        
        diffTable.getViewer().addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent e) {
                TreeElement el = (TreeElement) ((IStructuredSelection) e.getSelection()).getFirstElement();
                openElementInEditor(el, proj);
            }
        });
    }

    private void openElementInEditor(TreeElement el, PgDbProject proj){
        if (el != null && el.getSide() != (isProjSrc ? DiffSide.RIGHT : DiffSide.LEFT)){
            PgDatabase projectDb = isProjSrc ? dbSource.getDbObject() : dbTarget.getDbObject();
            File projectDir = proj.getPathToProject().toFile();
            File file = new File(projectDir, "SCHEMA"); //$NON-NLS-1$
            
            TreeElement parentEl = el.getParent().getParent();
            String parentExportedFileName = parentEl == null ? 
                    null : ModelExporter.getExportedFilename(parentEl.getPgStatement(projectDb));
                    
            switch(el.getType()){
                case EXTENSION:
                    file = new File(projectDir, "EXTENSION"); //$NON-NLS-1$
                    break;
                case SEQUENCE:
                    file = new File(new File(file, parentExportedFileName), "SEQUENCE"); //$NON-NLS-1$
                    break;
                case VIEW:
                    file = new File(new File(file, parentExportedFileName), "VIEW"); //$NON-NLS-1$
                    break;
                case TABLE:
                    file = new File(new File(file, parentExportedFileName), "TABLE"); //$NON-NLS-1$
                    break;
                case FUNCTION:
                    file = new File(new File(file, parentExportedFileName), "FUNCTION"); //$NON-NLS-1$
                    break;
                case CONSTRAINT:
                case INDEX:
                case TRIGGER:
                    el = parentEl;
                    String schemaName = ModelExporter.getExportedFilename(
                            parentEl.getParent().getParent().getPgStatement(projectDb));
                    file = new File(new File(file, schemaName), "TABLE"); //$NON-NLS-1$
                    break;
                default:
                    break;
            }
            
            file = new File(file, 
                    ModelExporter.getExportedFilename(el.getPgStatement(projectDb)) + ".sql"); //$NON-NLS-1$
            
            if (file.exists() && file.isFile()) {
                Log.log(Log.LOG_INFO, "Opening editor for file " + file.getAbsolutePath()); //$NON-NLS-1$
                
                IFileStore fileStore = EFS.getLocalFileSystem().getStore(file.toURI());
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
             
                try {
                    IDE.openEditorOnFileStore( page, fileStore );
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(
                            MessageFormat.format(Messages.could_not_open_editor_for_file, 
                            file.getAbsolutePath()), e);
                }
            } else {
                Log.log(Log.LOG_WARNING, "Editor will not be opened for file " +  //$NON-NLS-1$
                        file.getAbsolutePath() + " because it is either nonexistent or not a file."); //$NON-NLS-1$
            }
        }
    }

    private void saveDBPrefs(IEclipsePreferences projProps) throws BackingStoreException {
        projProps.put(PROJ_PREF.SOURCE, selectedDBSource.toString());
        switch (selectedDBSource) {
        case SOURCE_TYPE_DUMP:
            // keep old db values, change only source type
            break;
        case SOURCE_TYPE_DB:
        case SOURCE_TYPE_JDBC:
            projProps.put(PROJ_PREF.DB_NAME, dbSrc.getTxtDbName().getText());
            projProps.put(PROJ_PREF.DB_USER, dbSrc.getTxtDbUser().getText());
            projProps.put(PROJ_PREF.DB_HOST, dbSrc.getTxtDbHost().getText());
            projProps.putInt(PROJ_PREF.DB_PORT, Integer.valueOf(dbSrc.getTxtDbPort().getText()));
            break;
        }
        projProps.flush();
    }

    private void flipDbPicker(boolean open){
        containerSrc.setVisible(!open);
        ((GridData) containerSrc.getLayoutData()).exclude = open;
        containerDb.layout();

        btnFlipDbPicker.setText(open ? "\u25C2" // ◂ //$NON-NLS-1$
                : "\u25B8"); // ▸ //$NON-NLS-1$
        PreferenceInitializer.savePreference(Activator.getDefault().getPreferenceStore(), 
                PREF.IS_FLIPPED_DB_SOURCE, String.valueOf(open));
    }
    
    private String getSourceInfoText(){
        StringBuilder value = new StringBuilder().append(Messages.source);
        switch (selectedDBSource) {
        case SOURCE_TYPE_DUMP:
            return value.append(Messages.dump_file).toString();
        case SOURCE_TYPE_DB:
            value.append(Messages.pg_dump);
            break;
        case SOURCE_TYPE_JDBC:
            value.append(Messages.jdbc);
            break;
        }
        String preset = dbSrc.getSelectedDbPresetName();
        if (preset.isEmpty()){
            value.append("     ").append(Messages.connection_details); //$NON-NLS-1$
            value.append(dbSrc.getTxtDbUser().getText().isEmpty() ? "" : dbSrc.getTxtDbUser().getText() + '@'); //$NON-NLS-1$
            value.append(dbSrc.getTxtDbHost().getText().isEmpty() ? Messages.unknown_host : dbSrc.getTxtDbHost().getText());
            value.append(dbSrc.getTxtDbPort().getText().isEmpty() ? "" : ':' + dbSrc.getTxtDbPort().getText()); //$NON-NLS-1$ 
            value.append('/'); 
            value.append(dbSrc.getTxtDbName().getText().isEmpty() ? Messages.unknown_db : dbSrc.getTxtDbName().getText());
        }else{
            value.append("     ") //$NON-NLS-1$
                    .append(Messages.commitPartDescr_used_connection_template)
                    .append('[').append(preset).append(']'); 
        }
        return value.toString();
    }
    
    private void showDbPicker(boolean show) {
        ((GridData) dbSrc.getLayoutData()).exclude = !show;
        dbSrc.setVisible(show);

        dbSrc.getParent().layout();
    }

    private boolean fillDbSources(PgDbProject proj, IEclipsePreferences projProps)
            throws PgCodekeeperUIException {
        if (!OpenProjectUtils.checkVersionAndWarn(proj.getProject(), getShell(), true)) {
            return false;
        }
        
        DbSource dbsProj, dbsRemote;
        dbsProj = DbSource.fromProject(mainPrefs.getBoolean(PREF.USE_ANTLR) ? 
                ParserClass.getAntlr(null, 1) : ParserClass.getLegacy(null, 1), proj);
        switch (selectedDBSource) {
        case SOURCE_TYPE_DUMP:
            FileDialog dialog = new FileDialog(getShell());
            dialog.setText(Messages.choose_dump_file_with_changes);
            String dumpfile = dialog.open();
            if (dumpfile == null) {
                return false;
            }
            dbsRemote = DbSource.fromFile(mainPrefs.getBoolean(PREF.USE_ANTLR) ? 
                    ParserClass.getAntlr(null, 1) : ParserClass.getLegacy(null, 1), dumpfile,
                    projProps.get(PROJ_PREF.ENCODING, UIConsts.UTF_8));
            break;
        case SOURCE_TYPE_DB:
            String sPort = dbSrc.getTxtDbPort().getText();
            int port = sPort.isEmpty() ? 0 : Integer.parseInt(sPort);

            dbsRemote = DbSource.fromDb(mainPrefs.getBoolean(PREF.USE_ANTLR) ? 
                    ParserClass.getAntlr(null, 1) : ParserClass.getLegacy(null, 1),
                    mainPrefs.getString(PREF.PGDUMP_EXE_PATH),
                    mainPrefs.getString(PREF.PGDUMP_CUSTOM_PARAMS),
                    dbSrc.getTxtDbHost().getText(), port, dbSrc.getTxtDbUser().getText(),
                    dbSrc.getTxtDbPass().getText(), dbSrc.getTxtDbName().getText(),
                    projProps.get(PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                    projProps.get(PROJ_PREF.TIMEZONE, UIConsts.UTC));
            break;
        case SOURCE_TYPE_JDBC:
            sPort = dbSrc.getTxtDbPort().getText();
            port = sPort.isEmpty() ? 0 : Integer.parseInt(sPort);

            dbsRemote = DbSource.fromJdbc(dbSrc.getTxtDbHost().getText(), port,
                    dbSrc.getTxtDbUser().getText(), dbSrc.getTxtDbPass().getText(),
                    dbSrc.getTxtDbName().getText(), 
                    projProps.get(PROJ_PREF.ENCODING, UIConsts.UTF_8), 
                    projProps.get(PROJ_PREF.TIMEZONE, UIConsts.UTC),
                    mainPrefs.getBoolean(PREF.USE_ANTLR));
            break;
        default:
            throw new PgCodekeeperUIException(Messages.undefined_source_for_db_changes);
        }

        setDbSource(isProjSrc ? dbsProj : dbsRemote);
        setDbTarget(isProjSrc ? dbsRemote : dbsProj);

        return true;
    }

    private void loadChanges() {
        Log.log(Log.LOG_INFO, "Getting changes for diff"); //$NON-NLS-1$
        final TreeDiffer newDiffer = new TreeDiffer(dbSource, dbTarget);

        Job job = new Job(Messages.diffPresentationPane_getting_changes_for_diff) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    newDiffer.run(monitor);
                } catch (InvocationTargetException e) {
                    return new Status(Status.ERROR, PLUGIN_ID.THIS,
                            Messages.error_in_differ_thread, e);
                }
                if (monitor.isCanceled()) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
        job.addJobChangeListener(new JobChangeAdapter() {
            
            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    Display.getDefault().asyncExec(new Runnable() {
                        
                        @Override
                        public void run() {
                            if (DiffPresentationPane.this.isDisposed()) {
                                return;
                            }
                            treeDiffer = newDiffer;
                            diffTable.setInput(newDiffer, !isProjSrc);
                            diffPane.setInput(null);
                            diffLoaded();
                        }
                    });
                }
            }
        });
        job.setUser(true);
        job.schedule();
    }

    /**
     * @param container
     *            has {@link GridLayout} with 0 margins set by default
     * @param gl
     *            pre-made {@link GridLayout} of the container
     */
    protected abstract void createUpperContainer(Composite container, GridLayout gl);
    
    /**
     * Allows clients to make actions after a diff has been loaded.
     */
    protected void diffLoaded() {
    }
    
    private void clearInputs() {
        diffTable.setInput(null, !isProjSrc);
        diffPane.setInput(null);
    }
    
    public void reset() {
        clearInputs();
        if (dbTarget != null && dbSource != null) {
            showNotificationArea(true);
        }
    }
    
    private void showNotificationArea(boolean visible) {
        ((GridData) contNotifications.getLayoutData()).exclude = !visible;
        contNotifications.setVisible(visible);
        this.layout();
        if (visible) {
            btnUpdateRefreshed.setFocus();
        }
    }
}
