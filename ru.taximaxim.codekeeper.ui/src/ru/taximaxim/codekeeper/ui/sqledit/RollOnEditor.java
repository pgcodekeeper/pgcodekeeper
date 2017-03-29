package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class RollOnEditor extends SQLEditor implements IPartListener2 {

    private static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    private static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    private static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    private static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    private static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    private static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$

    private static final String RUN_SCRIPT_LABEL =  Messages.sqlScriptDialog_run_script;
    private static final String STOP_SCRIPT_LABEL = Messages.sqlScriptDialog_stop_script;

    private XmlHistory history;

    private Differ differ;
    private List<Entry<PgStatement, PgStatement>> oldDepcy;
    private DepcyFromPSQLOutput depcyInput;

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private Color colorPink;
    private Composite parentComposite;

    private DbInfo externalDbInfo;

    private Text txtCommand;
    private Combo cmbScript;
    private Button btnJdbcToggle;
    private DbStorePicker storePicker;

    private volatile boolean isRunning;
    private Thread scriptThread;
    private String scriptFileEncoding = ApgdiffConsts.UTF_8;
    private String connectionTimezone = ApgdiffConsts.UTC;

    private Button runScriptBtn;
    private Button saveAsBtn;

    public RollOnEditor() {
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED,
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
    }

    @Override
    protected ISourceViewer createSourceViewer(Composite parent,
            IVerticalRuler ruler, int styles) {
        Layout gl = new GridLayout(1, false);
        parent.setLayout(gl);
        parent.setLayoutData(new GridData());

        createDialogArea(parent);

        SourceViewer sw = (SourceViewer) super.createSourceViewer(parent, ruler, styles);
        sw.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        sw.appendVerifyKeyListener(new VerifyKeyListener() {

            @Override
            public void verifyKey(VerifyEvent event) {
                if ((event.stateMask & SWT.MOD1) != 0 && event.keyCode == SWT.F5) {
                    runButtonMethod();
                }
            }
        });

        return sw;
    }

    @Override
    public void createPartControl(Composite parent) {
        parentComposite = parent;
        super.createPartControl(parent);
        if (checkDangerDdl()) {
            if (showDangerWarning() == SWT.OK) {
                getSourceViewer().getTextWidget().setBackground(colorPink);
            } else {
                close(false);
            }
        }
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        // открыть с помощью кодкипера на каком-то скрипте
        if (input instanceof DepcyFromPSQLOutput) {
            final DepcyFromPSQLOutput in = (DepcyFromPSQLOutput)input;
            initializeDepcyInput(in);
            try {
                if (this.getSourceViewer() != null) {
                    in.updateScript(this.getSourceViewer().getDocument().get());
                }
                IRunnableWithProgress runParse = new IRunnableWithProgress() {

                    @Override
                    public void run(IProgressMonitor monitor) throws InvocationTargetException,
                    InterruptedException {
                        try {
                            in.updateParser(SubMonitor.convert(monitor));
                            monitor.done();
                        } catch (CoreException | IOException | LicenseException ex) {
                            throw new InvocationTargetException(ex, ex.getLocalizedMessage());
                        }
                    }
                };
                new ProgressMonitorDialog(site.getShell()).run(true, true, runParse);
            } catch (InvocationTargetException e) {
                throw new PartInitException(e.getLocalizedMessage(), e);
            } catch (InterruptedException ex) {
                throw new PartInitException(
                        Messages.RollOnEditor_parsing_cancelled + ex.getLocalizedMessage(), ex);
            }
        }
        // после создания парсера вызвать создание основного редактора
        super.init(site, input);
        getEditorSite().getWorkbenchWindow().getPartService().addPartListener(this);
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        IEditorInput input = getEditorInput();
        if (input instanceof DepcyFromPSQLOutput) {
            DepcyFromPSQLOutput in = (DepcyFromPSQLOutput) input;
            try {
                in.updateScript(this.getSourceViewer().getDocument().get());
                in.updateParser(progressMonitor);
            } catch (CoreException | IOException | LicenseException e) {
                Log.log(Log.LOG_ERROR, "Cannot parse Editor input"); //$NON-NLS-1$
            } catch (InterruptedException ex) {
                progressMonitor.setCanceled(true);
            }
        }
    }

    @Override
    public void dispose() {
        getEditorSite().getWorkbenchWindow().getPartService().removePartListener(this);
        if (colorPink != null) {
            colorPink.dispose();
        }
        super.dispose();
    }

    private void initializeDepcyInput(DepcyFromPSQLOutput input) {
        depcyInput = input;
        this.differ = depcyInput.getDiffer();

        this.oldDepcy = differ.getAdditionalDepciesSource();
        if (oldDepcy != null) {
            differ.setAdditionalDepciesSource(new ArrayList<>(oldDepcy));
        }
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED,
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
        this.connectionTimezone = differ.getTimezone();
        this.scriptFileEncoding = depcyInput.getScriptFileEncoding();
        this.externalDbInfo = depcyInput.dbinfo;
    }

    protected Control createDialogArea(final Composite parent) {
        GridLayout lay = new GridLayout();
        parent.setLayout(lay);

        btnJdbcToggle = new Button(parent, SWT.CHECK);
        btnJdbcToggle.setText(Messages.sqlScriptDialog_use_command_for_ddl_update);
        btnJdbcToggle.setSelection(Activator.getDefault().getPreferenceStore()
                .getBoolean(PREF.IS_DDL_UPDATE_OVER_JDBC));

        storePicker = new DbStorePicker(parent, SWT.NONE, mainPrefs, false, false);
        storePicker.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        if (externalDbInfo != null) {
            storePicker.setSelection(new StructuredSelection(externalDbInfo));
        }

        final Composite notJdbc = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        notJdbc.setLayoutData(gd);

        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        notJdbc.setLayout(gl);

        Label l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.sqlScriptDialog_Enter_cmd_to_update_ddl_with_sql_script
                + SCRIPT_PLACEHOLDER + ' '
                + DB_NAME_PLACEHOLDER + ' '
                + DB_HOST_PLACEHOLDER + ' ' + DB_PORT_PLACEHOLDER + ' '
                + DB_USER_PLACEHOLDER + ' ' + DB_PASS_PLACEHOLDER + ')' + ':');
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        cmbScript = new Combo(notJdbc, SWT.DROP_DOWN);
        cmbScript.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbScript.setToolTipText(
                DB_NAME_PLACEHOLDER + '=' + getReplacedString(DB_NAME_PLACEHOLDER, externalDbInfo) + UIConsts._NL +
                DB_HOST_PLACEHOLDER + '=' + getReplacedString(DB_HOST_PLACEHOLDER, externalDbInfo) + UIConsts._NL +
                DB_PORT_PLACEHOLDER + '=' + getReplacedString(DB_PORT_PLACEHOLDER, externalDbInfo) + UIConsts._NL +
                DB_USER_PLACEHOLDER + '=' + getReplacedString(DB_NAME_PLACEHOLDER, externalDbInfo) + UIConsts._NL +
                DB_PASS_PLACEHOLDER + '=' + getReplacedString(DB_USER_PLACEHOLDER, externalDbInfo));

        List<String> prev = null;
        try {
            prev = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.notifyDefault(Messages.SqlScriptDialog_error_loading_command_history, e1);
        }
        if (prev == null) {
            prev = new ArrayList<>();
        }
        if (prev.isEmpty()) {
            prev.add(UIConsts.DDL_DEFAULT_CMD);
        }
        for (String el : prev) {
            cmbScript.add(el);
        }
        cmbScript.select(0);

        cmbScript.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                txtCommand.setText(getReplacedString());
            }
        });

        l = new Label(notJdbc, SWT.NONE);
        l.setText(Messages.SqlScriptDialog_command_to_execute + SCRIPT_PLACEHOLDER
                + Messages.SqlScriptDialog_will_be_replaced);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);

        txtCommand = new Text(notJdbc, SWT.BORDER | SWT.READ_ONLY);
        txtCommand.setText(getReplacedString());
        txtCommand.setBackground(parent.getShell().getDisplay()
                .getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        colorPink = new Color(parent.getShell().getDisplay(), new RGB(0xff, 0xe1, 0xff));

        btnJdbcToggle.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean isCmd = btnJdbcToggle.getSelection();
                notJdbc.setVisible(isCmd);
                ((GridData)notJdbc.getLayoutData()).exclude = !isCmd;

                storePicker.setVisible(!isCmd);
                ((GridData)storePicker.getLayoutData()).exclude = isCmd;

                parent.layout();

                Activator.getDefault().getPreferenceStore().setValue(
                        PREF.IS_DDL_UPDATE_OVER_JDBC, isCmd);
            }
        });
        createButtonsForButtonBar(parent);
        btnJdbcToggle.notifyListeners(SWT.Selection, new Event());

        return parent;
    }

    protected void createButtonsForButtonBar(Composite parent) {
        Composite comp = new Composite(parent, SWT.NONE);
        comp.setLayout(new GridLayout(3, true));

        runScriptBtn = new Button(comp, SWT.PUSH);
        runScriptBtn.setText(RUN_SCRIPT_LABEL);
        runScriptBtn.setToolTipText(Messages.RollOnEditor_tooltip_run_selected);
        runScriptBtn.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                runButtonMethod();
            }
        });

        saveAsBtn = new Button(comp, SWT.PUSH);
        saveAsBtn.setText(Messages.sqlScriptDialog_save_as);
        saveAsBtn.addSelectionListener(new SaveButtonHandler());
    }

    private int showDangerWarning() {
        MessageBox mb = new MessageBox(parentComposite.getShell(), SWT.ICON_WARNING
                | SWT.OK | SWT.CANCEL);
        mb.setText(Messages.sqlScriptDialog_warning);
        mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data);
        return mb.open();
    }

    private String getReplacedString() {
        return getReplacedString(cmbScript.getText(), externalDbInfo);
    }

    private static String getReplacedString(String s, DbInfo externalDbInfo) {
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
                if (!runScriptBtn.isDisposed()) {
                    parentComposite.setCursor(null);

                    if (mainPrefs.getBoolean(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                        new ScriptRunResultDialog(parentComposite.getShell(), scriptOutput).open();
                    }
                    if (depcyInput != null) {
                        showAddDepcyDialog();
                    }
                    setRunButtonText(RUN_SCRIPT_LABEL);
                }
                isRunning = false;
            }
        });
    }

    private void showAddDepcyDialog() {
        if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY) && depcyInput != null && !depcyInput.isAddDepcyEmpty()) {
            MessageBox mb = new MessageBox(parentComposite.getShell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
            mb.setText(Messages.sqlScriptDialog_psql_dependencies);
            mb.setMessage(Messages.SqlScriptDialog__results_of_script_revealed_dependent_objects +
                    depcyInput.depcyToString() + UIConsts._NL);
            String repeats = depcyInput.getRepeatedDepcy();
            if (repeats.length() > 0) {
                mb.setMessage(mb.getMessage() +
                        Messages.sqlScriptDialog_this_dependencies_have_been_added_already_check_order + repeats);
            }
            mb.setMessage(mb.getMessage() + UIConsts._NL +
                    Messages.SqlScriptDialog_add_it_to_script);
            if (mb.open() == SWT.OK) {
                List<Entry<PgStatement, PgStatement>> saveToRestore = depcyInput
                        .addAdditionalDepciesSource();
                Job job = differ.getDifferJob();
                job.addJobChangeListener(new DiffReGenerationListener(saveToRestore));
                job.setUser(true);
                job.schedule();
            }
        }
    }

    private boolean checkDangerDdl() {
        if (differ == null) {
            return false;
        }
        return differ.getScript().isDangerDdl(
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.RESTART_WITH_STATEMENT));
    }

    private void runButtonMethod() {
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
                    ExceptionNotifier.notifyDefault(Messages.RollOnEditor_selected_text_error, ble);
                    return;
                }
            }
            // new runnable to unlock the UI thread
            Runnable launcher;

            if (!btnJdbcToggle.getSelection()){
                Log.log(Log.LOG_INFO, "Running DDL update using JDBC"); //$NON-NLS-1$

                DbInfo dbInfo = storePicker.getDbInfo();
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
                            JdbcConnector connector = new JdbcConnector(
                                    jdbcHost, jdbcPort, jdbcUser, jdbcPass, jdbcDbName,
                                    scriptFileEncoding, connectionTimezone);
                            output = new JdbcRunner(connector).runScript(textRetrieved);
                            if (JDBC_CONSTS.JDBC_SUCCESS.equals(output)) {
                                output = Messages.RollOnEditor_jdbc_success;
                                ProjectEditorDiffer.notifyDbChanged(dbInfo);
                            } else if (depcyInput != null && mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                                depcyInput.getDependenciesFromOutput(output);
                            }
                        } catch (IOException e) {
                            throw new IllegalStateException(e.getLocalizedMessage(), e);
                        } finally {
                            // request UI change: button label changed
                            afterScriptFinished(output);
                        }
                    }
                };
            }else{
                Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$
                final List<String> command = new ArrayList<>(Arrays.asList(
                        getReplacedString().split(" "))); //$NON-NLS-1$

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
            scriptThread.start();
            isRunning = true;
            setRunButtonText(STOP_SCRIPT_LABEL);
            parentComposite.setCursor(parentComposite.getDisplay().getSystemCursor(SWT.CURSOR_WAIT));
            // case Stop script
        } else {
            ConsoleFactory.write(Messages.sqlScriptDialog_script_execution_interrupted);
            Log.log(Log.LOG_INFO, "Script execution interrupted by user"); //$NON-NLS-1$

            scriptThread.interrupt();
            setRunButtonText(RUN_SCRIPT_LABEL);
            isRunning = false;
        }
    }

    private void setRunButtonText(String text) {
        runScriptBtn.setText(text);
        runScriptBtn.getParent().layout();
    }

    private class SaveButtonHandler extends SelectionAdapter {

        @Override
        public void widgetSelected(SelectionEvent e) {
            String textRetrieved = RollOnEditor.this.getSourceViewer().getDocument().get();
            FileDialog fd = new FileDialog(parentComposite.getShell(), SWT.SAVE);
            fd.setText(Messages.sqlScriptDialog_save_as);
            fd.setOverwrite(true);
            fd.setFilterExtensions(new String[] {"*.sql", "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
            String scriptFileName = fd.open();

            if (scriptFileName != null) {
                File script = new File(scriptFileName);
                try (PrintWriter writer = new PrintWriter(script, scriptFileEncoding)) {
                    writer.write(textRetrieved);
                } catch (IOException ex) {
                    ExceptionNotifier.notifyDefault(
                            Messages.sqlScriptDialog_error_saving_script_to_file, ex);
                    return;
                }

                ConsoleFactory.write(Messages.sqlScriptDialog_script_saved_to_file + script.getAbsolutePath());
            }
        }
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
                File outFile = tempFile.get();
                try (PrintWriter writer = new PrintWriter(outFile, scriptFileEncoding)) {
                    writer.write(textRetrieved);
                }

                String filepath = outFile.getAbsolutePath();
                ListIterator<String> it = command.listIterator();
                while (it.hasNext()) {
                    it.set(it.next().replace(SCRIPT_PLACEHOLDER, filepath));
                }

                ProcessBuilder pb = new ProcessBuilder(command);
                sr.launchAndRedirect(pb);
                if (depcyInput != null && mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                    depcyInput.getDependenciesFromOutput(sr.getStorage());
                }
            } catch (IOException ex) {
                if (depcyInput != null && mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                    depcyInput.getDependenciesFromOutput(sr.getStorage());
                    if (!depcyInput.isAddDepcyEmpty()) {
                        // actually parsed some depcies, do not rethrow
                        return;
                    }
                }
                throw new IllegalStateException(ex.getLocalizedMessage(), ex);
            } finally {
                // request UI change: button label changed
                afterScriptFinished(sr.getStorage());
            }
        }
    }

    private class DiffReGenerationListener extends JobChangeAdapter {

        private final List<Entry<PgStatement, PgStatement>> saveToRestore;

        DiffReGenerationListener(
                List<Entry<PgStatement, PgStatement>> saveToRestore) {
            this.saveToRestore = saveToRestore;
        }

        @Override
        public void done(IJobChangeEvent event) {
            if (event.getResult().isOK()) {
                UiSync.exec(parentComposite, new Runnable() {

                    @Override
                    public void run() {
                        if (parentComposite.isDisposed()) {
                            return;
                        }
                        checkAskDanger();
                    }
                });
            }
        }

        private void checkAskDanger() {
            if (checkDangerDdl()) {
                if (showDangerWarning() != SWT.OK) {
                    differ.setAdditionalDepciesSource(saveToRestore);
                    return;
                } else {
                    RollOnEditor.this.getSourceViewer().getTextWidget().setBackground(colorPink);
                }
            }
            IEditorInput input = RollOnEditor.this.getEditorInput();
            if (input instanceof DepcyFromPSQLOutput) {
                ((DepcyFromPSQLOutput)input).updateScript(differ.getDiffDirect());
            }
            RollOnEditor.this.setInput(input);
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

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partClosed(IWorkbenchPartReference partRef) {
        if (depcyInput != null) {
            if (isRunning) {
                /*MessageBox errorDialog = new MessageBox(this.getEditorSite()
                        .getShell(), SWT.OK);
                errorDialog.setMessage(Messages.sqlScriptDialog_stop_script_before_closing_dialog);
                errorDialog.open();*/
            } else {
                differ.setAdditionalDepciesSource(oldDepcy);
                try {
                    history.addHistoryEntry(cmbScript.getText());
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.SqlScriptDialog_error_adding_command_history, e);
                }
            }
        }
    }

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partHidden(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partVisible(IWorkbenchPartReference partRef) {
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) {
    }
}
