package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempFile;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
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

    private final XmlHistory history;

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private Composite parentComposite;

    private DbInfo externalDbInfo;

    private Text txtCommand;
    private Combo cmbScript;
    private Button btnJdbcToggle;
    private DbStorePicker storePicker;

    private volatile boolean isRunning;
    private Thread scriptThread;
    private Button runScriptBtn;
    private IEditorInput input;

    public RollOnEditor() {
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED,
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT,
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
    }

    @Override
    protected ISourceViewer createSourceViewer(Composite parent,
            IVerticalRuler ruler, int styles) {
        Layout gl = new GridLayout();
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
    }

    public void setLineBackground() {
        List<PgObjLocation> refs = getParser().getObjReferences().get(input.getName());
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
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        getSite().getPage().addPartListener(this);
        this.input = input;
    }

    @Override
    public void dispose() {
        getSite().getPage().removePartListener(this);
        super.dispose();
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
    }

    private String getReplacedString() {
        return getReplacedString(cmbScript.getText(), externalDbInfo);
    }

    private static String getReplacedString(String dbInfo, DbInfo externalDbInfo) {
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
                if (!runScriptBtn.isDisposed()) {
                    parentComposite.setCursor(null);

                    if (mainPrefs.getBoolean(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                        new ScriptRunResultDialog(parentComposite.getShell(), scriptOutput).open();
                    }
                    setRunButtonText(RUN_SCRIPT_LABEL);
                }
                isRunning = false;
            }
        });
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
                                    ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
                            output = new JdbcRunner(connector).runScript(textRetrieved);
                            if (JDBC_CONSTS.JDBC_SUCCESS.equals(output)) {
                                output = Messages.RollOnEditor_jdbc_success;
                                ProjectEditorDiffer.notifyDbChanged(dbInfo);
                            }
                        } catch (IOException e) {
                            throw new IllegalStateException(e.getLocalizedMessage(), e);
                        } finally {
                            // request UI change: button label changed
                            afterScriptFinished(output);
                        }
                    }
                };
            } else {
                Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$
                try {
                    history.addHistoryEntry(cmbScript.getText());
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.SqlScriptDialog_error_adding_command_history, e);
                }
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

    private void afterQuickUpdateScriptFinished(final String scriptOutput, boolean result) {
        UiSync.exec(parentComposite, new Runnable() {

            @Override
            public void run() {
                if (!runScriptBtn.isDisposed()) {
                    parentComposite.setCursor(null);

                    if (!result && mainPrefs.getBoolean(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                        new ScriptRunResultDialog(parentComposite.getShell(), scriptOutput).open();
                    }
                    setRunButtonText(RUN_SCRIPT_LABEL);
                }
                isRunning = false;
            }
        });
    }

    public boolean runQuickUpdate() {
        boolean executed = false;
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
                    return executed;
                }
            }
            // new runnable to unlock the UI thread
            Runnable launcher;

            if (!btnJdbcToggle.getSelection()){
                Log.log(Log.LOG_INFO, "Running DDL update using JDBC"); //$NON-NLS-1$

                DbInfo dbInfo = storePicker.getDbInfo();
                if (dbInfo == null){
                    ExceptionNotifier.notifyDefault(Messages.sqlScriptDialog_script_select_storage, null);
                    return executed;
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
                                    ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
                            output = new JdbcRunner(connector).runScript(textRetrieved);
                            if (JDBC_CONSTS.JDBC_SUCCESS.equals(output)) {
                                output = Messages.RollOnEditor_jdbc_success;
                                ProjectEditorDiffer.notifyDbChanged(dbInfo);
                            }
                        } catch (IOException e) {
                            throw new IllegalStateException(e.getLocalizedMessage(), e);
                        } finally {
                            // request UI change: button label changed
                            boolean result = Messages.RollOnEditor_jdbc_success.equals(output);
                            afterQuickUpdateScriptFinished(output, result);
                        }
                    }
                };
            } else {
                Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$
                try {
                    history.addHistoryEntry(cmbScript.getText());
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                            Messages.SqlScriptDialog_error_adding_command_history, e);
                }
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

        executed = true;
        return executed;
    }

    private void setRunButtonText(String text) {
        runScriptBtn.setText(text);
        runScriptBtn.getParent().layout();
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

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partClosed(IWorkbenchPartReference partRef) {
        if (partRef.getPart(false) == this && !PlatformUI.getWorkbench().isClosing()
                && input instanceof IFileEditorInput) {
            IFile f = ((IFileEditorInput) input).getFile();
            if (PROJ_PATH.MIGRATION_DIR.equals(f.getProjectRelativePath().segment(0))) {
                askDeleteScript(f);
            }
        }
    }

    private void askDeleteScript(IFile f) {
        String mode = mainPrefs.getString(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE);
        // if select "YES" with toggle
        if (mode.equals(MessageDialogWithToggle.ALWAYS)){
            deleteFile(f);
            // if not select "NO" with toggle, show choice message dialog
        } else if (!mode.equals(MessageDialogWithToggle.NEVER)){
            MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getSite().getShell(),
                    Messages.RollOnEditor_script_delete_dialog_title, Messages.RollOnEditor_script_delete_dialog_message,
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

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partHidden(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partVisible(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) {
        // no imp
    }
}
