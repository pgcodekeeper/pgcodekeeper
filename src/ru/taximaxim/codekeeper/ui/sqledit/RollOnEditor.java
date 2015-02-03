package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
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

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class RollOnEditor extends SQLEditor implements IPartListener2 {

    public static final String ID = "ru.taximaxim.codekeeper.ui.RollOnEditor";
    
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
    private DepcyFromPSQLOutput addDepcy;
    
    private IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private Color colorPink;
    
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPass;
    
    private Text txtCommand;
    private Combo cmbScript;
    private Button btnJdbcToggle;
    private Button btnHidePicker;
    private DbPicker picker;
    
    private volatile boolean isRunning;
    private Thread scriptThread;
    private String scriptFileEncoding = UIConsts.UTF_8;
    private String connectionTimezone = UIConsts.UTC;

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
        
        
        return sw;
    }
    
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        try {
            if (checkDangerDdl()) {
                if (showDangerWarning() == SWT.OK) {
                    getSourceViewer().getTextWidget().setBackground(colorPink);
                } else {
                    close(false);
                }
            }
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.notifyDefault(
                    Messages.SqlScriptDialog_error_get_script, e);
        }
    }
    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        // открыть с помощью кодкипера на каком-то скрипте
        if (input instanceof DepcyFromPSQLOutput) {
            DepcyFromPSQLOutput in = (DepcyFromPSQLOutput)input;
            initializeDepcyInput(in);
            try {
                if (this.getSourceViewer() != null) {
                    in.updateScript(this.getSourceViewer().getDocument().get());
                }
                in.updateParser(null);
            } catch (CoreException e) {
               throw new PartInitException(e.getLocalizedMessage(), e);
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
            } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, "Cannot parse Editor input");
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
        addDepcy = (DepcyFromPSQLOutput)input;
        this.differ = addDepcy.getDiffer();
        
        this.oldDepcy = differ.getAdditionalDepciesSource();
        differ.setAdditionalDepciesSource(new ArrayList<>(oldDepcy));
        IEclipsePreferences projPrefs = new ProjectScope(addDepcy.getProject())
                .getNode(UIConsts.PLUGIN_ID.THIS);
        this.history = new XmlHistory.Builder(XML_TAGS.DDL_UPDATE_COMMANDS_MAX_STORED, 
                FILE.DDL_UPDATE_COMMANDS_HIST_FILENAME, 
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ROOT, 
                XML_TAGS.DDL_UPDATE_COMMANDS_HIST_ELEMENT).build();
        this.connectionTimezone = projPrefs.get(PROJ_PREF.TIMEZONE, UIConsts.UTC);
        this.scriptFileEncoding = projPrefs.get(PROJ_PREF.ENCODING, UIConsts.UTF_8);
        setDbParams(addDepcy.dbHost, addDepcy.dbPort, addDepcy.dbName,
                addDepcy.dbUser, addDepcy.dbPass);
    }
    public void setDbParams(String dbHost, String dbPort, String dbName,
            String dbUser, String dbPass) {
        this.dbHost = dbHost;
        this.dbName = dbName; 
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbPort = dbPort;
    }
    
    protected Control createDialogArea(final Composite parent) {
        GridLayout lay = new GridLayout();
        parent.setLayout(lay);
        
        Composite buttons = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);;
        buttons.setLayoutData(gd);
        
        GridLayout gl = new GridLayout(2, false);
        gl.marginHeight = gl.marginWidth = 0;
        buttons.setLayout(gl);
        
        btnJdbcToggle = new Button(buttons, SWT.CHECK);
        btnJdbcToggle.setText(Messages.sqlScriptDialog_use_jdbc_for_ddl_update);
        boolean isDdlUpdateOverJdbc = 
                Activator.getDefault().getPreferenceStore().getBoolean(PREF.IS_DDL_UPDATE_OVER_JDBC);
        btnJdbcToggle.setSelection(isDdlUpdateOverJdbc);
        
        btnHidePicker = new Button(buttons, SWT.CHECK); 
        btnHidePicker.setText(Messages.sqlScriptDialog_hide_picker);
        btnHidePicker.setSelection(false);
        btnHidePicker.addSelectionListener(new SelectionAdapter() {
        
            @Override
            public void widgetSelected(SelectionEvent e) {
                picker.setVisible(!btnHidePicker.getSelection());
                ((GridData)picker.getLayoutData()).exclude = btnHidePicker.getSelection();
                parent.layout();
            }
        });
        // picker
        picker = new DbPicker(parent, SWT.BORDER, mainPrefs, false);
        picker.setText(Messages.SqlScriptDialog_jdbc_connection_details);
        
        picker.getTxtDbName().setText(dbName == null ? "" : dbName); //$NON-NLS-1$
        picker.getTxtDbUser().setText(dbUser == null ? "" : dbUser); //$NON-NLS-1$
        picker.getTxtDbHost().setText(dbHost == null ? "" : dbHost); //$NON-NLS-1$
        picker.getTxtDbPort().setText(dbPort == null || dbPort.isEmpty() ? "0" : dbPort); //$NON-NLS-1$
        
        gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.exclude = !isDdlUpdateOverJdbc;
        gd.heightHint = 230;
        gd.minimumHeight = 230;
        picker.setLayoutData(gd);
        picker.setVisible(isDdlUpdateOverJdbc);
        
        final Composite notJdbc = new Composite(parent, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = isDdlUpdateOverJdbc;
        notJdbc.setLayoutData(gd);
        notJdbc.setVisible(!isDdlUpdateOverJdbc);
        
        gl = new GridLayout();
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
        cmbScript.setToolTipText(DB_NAME_PLACEHOLDER + '=' +dbName + UIConsts.LINE_SEP +
                DB_HOST_PLACEHOLDER + '=' + dbHost + UIConsts.LINE_SEP + 
                DB_PORT_PLACEHOLDER + '=' + dbPort + UIConsts.LINE_SEP + 
                DB_USER_PLACEHOLDER + '=' + dbUser + UIConsts.LINE_SEP + 
                DB_PASS_PLACEHOLDER + '=' + dbPass);

        List<String> prev;
        try {
            prev = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.notifyDefault(Messages.SqlScriptDialog_error_loading_command_history, e1);
            prev = new ArrayList<>();
        }
        if (prev != null && !prev.isEmpty()) {
            for (String el : prev) {
                cmbScript.add(el);
            }
            cmbScript.select(0);
        }
        
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
        
        btnJdbcToggle.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean isJdbc = btnJdbcToggle.getSelection();
                notJdbc.setVisible(!isJdbc);
                ((GridData)notJdbc.getLayoutData()).exclude = isJdbc;
                
                picker.setVisible(isJdbc && !btnHidePicker.getSelection());
                ((GridData)picker.getLayoutData()).exclude = !isJdbc || btnHidePicker.getSelection();
                
                btnHidePicker.setVisible(isJdbc);
                ((GridData)btnHidePicker.getLayoutData()).exclude = !isJdbc;
                
                parent.layout();
                
                PreferenceInitializer.savePreference(Activator.getDefault().getPreferenceStore(), 
                        PREF.IS_DDL_UPDATE_OVER_JDBC, String.valueOf(btnJdbcToggle.getSelection()));
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        createButtonsForButtonBar(parent);
//        PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), HELP.SQL_SCRIPT_DIALOG);
        return parent;
    }
    
    protected void createButtonsForButtonBar(Composite parent) {
        Composite comp = new Composite(parent, SWT.None);
        comp.setLayout(new GridLayout(3, true));
        
        runScriptBtn = new Button(comp, SWT.NONE);
        runScriptBtn.setText(RUN_SCRIPT_LABEL);
        runScriptBtn.addSelectionListener(new RunButtonHandler());
        
        saveAsBtn = new Button(comp, SWT.NONE);
        saveAsBtn.setText(Messages.sqlScriptDialog_save_as);
        saveAsBtn.addSelectionListener(new SaveButtonHandler());
    }
    
    private int showDangerWarning() {
        MessageBox mb = new MessageBox(this.getEditorSite().getShell(), SWT.ICON_WARNING
                | SWT.OK | SWT.CANCEL);
        mb.setText(Messages.sqlScriptDialog_warning);
        mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data);
        return mb.open();
    }
    
    private String getReplacedString() {
        String s = cmbScript.getText();
        if (dbHost != null) {
            s = s.replace(DB_HOST_PLACEHOLDER, dbHost);
        }
        if (dbName != null) {
            s = s.replace(DB_NAME_PLACEHOLDER, dbName);
        }
        if (dbUser != null) {
            s = s.replace(DB_USER_PLACEHOLDER, dbUser);
        }
        if (dbPass != null) {
            s = s.replace(DB_PASS_PLACEHOLDER, dbPass);
        }
        if (dbPort != null) {
            s = s.replace(DB_PORT_PLACEHOLDER, dbPort);
        }
        return s;
    }
    
    private void afterScriptFinished(final String scriptOutput) {
        this.getEditorSite().getShell().getDisplay().syncExec(new Runnable() {

            @Override
            public void run() {
                if (!runScriptBtn.isDisposed()) {
                    if (addDepcy != null) {
                        if (mainPrefs
                                .getBoolean(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                            new ScriptRunResultDialog(RollOnEditor.this
                                    .getEditorSite().getShell(), scriptOutput)
                                    .open();
                        }
                        showAddDepcyDialog();
                    }
                    runScriptBtn.setText(RUN_SCRIPT_LABEL);
                }
                isRunning = false;
            }
        });
    }
    
    private void showAddDepcyDialog() {
        if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY) && addDepcy != null && !addDepcy.isAddDepcyEmpty()) {
            MessageBox mb = new MessageBox(this.getEditorSite().getShell(), 
                    SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
            mb.setText(Messages.sqlScriptDialog_psql_dependencies);
            mb.setMessage(Messages.SqlScriptDialog__results_of_script_revealed_dependent_objects +
                    addDepcy.depcyToString() + UIConsts.LINE_SEP);
            String repeats = addDepcy.getRepeatedDepcy();
            if (repeats.length() > 0) {
                mb.setMessage(mb.getMessage() + 
                        Messages.sqlScriptDialog_this_dependencies_have_been_added_already_check_order + repeats);  
            }
            mb.setMessage(mb.getMessage() + UIConsts.LINE_SEP +
                    Messages.SqlScriptDialog_add_it_to_script);
            if (mb.open() == SWT.OK) {
                List<Entry<PgStatement, PgStatement>> saveToRestore = addDepcy
                        .addAdditionalDepciesSource();
                Job job = differ.getDifferJob();
                job.addJobChangeListener(new DiffReGenerationListener(saveToRestore));
                job.setUser(true);
                job.schedule();
            }
        }
    }

    private boolean checkDangerDdl() throws PgCodekeeperUIException {
        if (differ == null) {
            return false;
        }
        return differ.getScript().isDangerDdl(
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
                !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT));
    }
    
    private class RunButtonHandler extends SelectionAdapter{
        @Override
        public void widgetSelected(SelectionEvent e) {
         // case Run script
            if (!isRunning) {
                final String textRetrieved = RollOnEditor.this.getSourceViewer().getDocument().get();
                // new runnable to unlock the UI thread
                Runnable launcher;
                
                if (btnJdbcToggle.getSelection()){
                    Log.log(Log.LOG_INFO, "Running DDL update using JDBC"); //$NON-NLS-1$
                    
                    final String jdbcHost = picker.getTxtDbHost().getText();
                    final int jdbcPort = Integer.valueOf(picker.getTxtDbPort().getText());
                    final String jdbcUser = picker.getTxtDbUser().getText();
                    final String jdbcPass = picker.getTxtDbPass().getText();
                    final String jdbcDbName = picker.getTxtDbName().getText();
                    
                    launcher = new Runnable() {
                        
                        @Override
                        public void run() {
                            String output = Messages.sqlScriptDialog_script_has_not_been_run_yet;
                            try{
                                JdbcConnector connector = new JdbcConnector(
                                        jdbcHost, jdbcPort, jdbcUser, jdbcPass, jdbcDbName, 
                                        scriptFileEncoding, connectionTimezone);
                                output = new JdbcRunner(connector).runScript(textRetrieved);
                                if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                                    addDepcy.getDependenciesFromOutput(output);
                                }
                            } catch (IOException e) {
                                throw new IllegalStateException(e);
                            } finally {
                                // request UI change: button label changed
                                afterScriptFinished(output);
                            }
                        }
                    };
                }else{
                    Log.log(Log.LOG_INFO, "Running DDL update using external command"); //$NON-NLS-1$
                    final List<String> command = new ArrayList<>(Arrays.asList(
                            getReplacedString().split(Pattern.quote(" ")))); //$NON-NLS-1$
                    
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
                runScriptBtn.setText(STOP_SCRIPT_LABEL);
             // case Stop script
            } else {
                ConsoleFactory.write(Messages.sqlScriptDialog_script_execution_interrupted);
                Log.log(Log.LOG_INFO, "Script execution interrupted by user"); //$NON-NLS-1$
                
                scriptThread.interrupt();
                runScriptBtn.setText(RUN_SCRIPT_LABEL);
                isRunning = false;
            }
        }
    }
    
    private class SaveButtonHandler extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent e) {
            String textRetrieved = RollOnEditor.this.getSourceViewer().getDocument().get();
            FileDialog fd = new FileDialog(RollOnEditor.this.getEditorSite().getShell(), SWT.SAVE);
            fd.setText(Messages.sqlScriptDialog_save_as);
            fd.setOverwrite(true);
            fd.setFilterExtensions(new String[] {"*.sql", "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
            String scriptFileName = fd.open();
            
            if (scriptFileName != null) {
                File script = new File(scriptFileName);
                try (PrintWriter writer = new PrintWriter(script, UIConsts.UTF_8)) {
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
            try (TempFile tempFile = new TempFile("tmp_rollon_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
                File outFile = tempFile.get();
                try (PrintWriter writer = 
                        new PrintWriter(outFile, scriptFileEncoding)) {
                    writer.write(textRetrieved);
                }
   
                String filepath = outFile.getAbsolutePath();
                ListIterator<String> it = command.listIterator();
                while (it.hasNext()) {
                    it.set(it.next().replace(SCRIPT_PLACEHOLDER, filepath));
                }
                
                ProcessBuilder pb = new ProcessBuilder(command);
                sr.launchAndRedirect(pb);
                if (addDepcy!=null && mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                    addDepcy.getDependenciesFromOutput(sr.getStorage());
                }
            } catch (IOException ex) {
                if (addDepcy!=null && mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                    addDepcy.getDependenciesFromOutput(sr.getStorage());
                    if (!addDepcy.isAddDepcyEmpty()) {
                        // actually parsed some depcies, do not rethrow
                        return;
                    }
                }
                throw new IllegalStateException(ex);
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
                Display.getDefault().asyncExec(new Runnable() {

                    @Override
                    public void run() {
                        if (RollOnEditor.this.getEditorSite().getShell().isDisposed()) {
                            return;
                        }
                        checkAskDanger();
                    }
                });
            }
        }

        private void checkAskDanger() {
            try {
                if (checkDangerDdl()) {
                    if (showDangerWarning() != SWT.OK) {
                        differ.setAdditionalDepciesSource(saveToRestore);
                        return;
                    } else {
                        RollOnEditor.this.getSourceViewer().getTextWidget().setBackground(colorPink);
                    }
                }
                RollOnEditor.this.setInput(RollOnEditor.this.getEditorInput());
                
            } catch (PgCodekeeperUIException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.SqlScriptDialog_error_add_depcies, e);
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
            filed.setLayoutData(new GridData(GridData.FILL_BOTH));
            return comp;
        }

        @Override
        protected void createButtonsForButtonBar(Composite parent) {
                createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
                        true);
        }
    }

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partClosed(IWorkbenchPartReference partRef) {
        if (addDepcy != null) {
            if (isRunning) {
                MessageBox errorDialog = new MessageBox(this.getEditorSite()
                        .getShell(), SWT.OK);
                errorDialog.setMessage(Messages.sqlScriptDialog_stop_script_before_closing_dialog);
                errorDialog.open();
            } else {
                differ.setAdditionalDepciesSource(oldDepcy);
                try {
                    history.addHistoryEntry(cmbScript.getText());
                } catch (IOException e) {
                    ExceptionNotifier.notifyDefault(
                                    Messages.SqlScriptDialog_error_adding_command_history,
                                    e);
                }
            }
        }
    }
    @Override
    public void partDeactivated(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partHidden(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partVisible(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
        
    }
}
