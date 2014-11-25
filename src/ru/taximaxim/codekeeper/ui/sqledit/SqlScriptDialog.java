package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.HELP;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceInitializer;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class SqlScriptDialog extends TrayDialog {

    private static final Pattern PATTERN_ERROR = Pattern.compile(
            "^.*(ERROR|ОШИБКА):.+$"); //$NON-NLS-1$
    private static final Pattern PATTERN_DROP_CASCADE = Pattern.compile(
            "^(HINT|ПОДСКАЗКА):.+(DROP \\.\\.\\. CASCADE).+$",  //$NON-NLS-1$
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); 
    
    private static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    private static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    private static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    private static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    private static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    private static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$
    
    private static final String RUN_SCRIPT_LABEL =  Messages.sqlScriptDialog_run_script;
    private static final String STOP_SCRIPT_LABEL = Messages.sqlScriptDialog_stop_script;
    private static final String[] BUTTONS = new String[] {
        RUN_SCRIPT_LABEL, Messages.sqlScriptDialog_save_as, IDialogConstants.CLOSE_LABEL }; 
    
    private static final String SCRIPTS_HIST_ROOT = "scripts"; //$NON-NLS-1$
    private static final String SCRIPTS_HIST_EL = "s"; //$NON-NLS-1$
    private static final String SCRIPTS_HIST_FILENAME = "rollon_cmd_history.xml"; //$NON-NLS-1$
    private static final int SCRIPTS_HIST_MAX_STORED = 20;

    private static final String LINE_SEP = System.lineSeparator();
    
    private final XmlHistory history;
    private final Differ differ;
    private List<Entry<String, String>> addDepcy;
    private final List<Entry<PgStatement, PgStatement>> oldDepcy;
    private List<PgStatement> objList;
    private final IPreferenceStore mainPrefs;
    private Color colorPink;
    
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPass;
    
    private SqlSourceViewerExtender sqlEditor;
    private Text txtCommand;
    private Combo cmbScript;
    private Button btnJdbcToggle;
    
    private volatile boolean isRunning;
    private Thread scriptThread;
    private String title;
    private String message;
    private int type;

    public void setDbParams(String dbHost, String dbPort, String dbName,
            String dbUser, String dbPass) {
        this.dbHost = dbHost;
        this.dbName = dbName; 
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbPort = dbPort;
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
    
    public SqlScriptDialog(Shell parentShell, int type, String title, String message,
            Differ differ, List<PgStatement> objList, IPreferenceStore mainPrefs) {
        super(parentShell);
        this.title = title;
        this.message = message;
        this.type = type;
        this.differ = differ;
        this.oldDepcy = differ.getAdditionalDepciesSource();
        differ.setAdditionalDepciesSource(new ArrayList<>(oldDepcy));
        this.objList = objList;
        this.mainPrefs = mainPrefs;
        this.history = new XmlHistory.Builder(SCRIPTS_HIST_MAX_STORED, 
                SCRIPTS_HIST_FILENAME, 
                SCRIPTS_HIST_ROOT, 
                SCRIPTS_HIST_EL).build();
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        newShell.setText(title);
        super.configureShell(newShell);
    }
    
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        for (int i = 0; i< BUTTONS.length; i++) {
            createButton(parent, i, BUTTONS[i],
                    i == BUTTONS.length - 1);
        }
    }
    private Control createMessageArea(Composite composite) {
        // create composite
        // create image
        Image image = composite.getDisplay().getSystemImage(type);
        Composite comp = new Composite(composite, SWT.FILL);
        Layout layout = new GridLayout(2, false);
        comp.setLayout(layout);
        
        if (image != null) {
            Label imageLabel = new Label(comp, SWT.NULL);
            image.setBackground(imageLabel.getBackground());
            imageLabel.setImage(image);
//            addAccessibleListeners(imageLabel, image);
            GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BEGINNING)
                    .applyTo(imageLabel);
        }
        // create message
        if (message != null) {
            Label messageLabel = new Label(comp, SWT.WRAP);
            messageLabel.setText(message);
            GridDataFactory
                    .fillDefaults()
                    .align(SWT.FILL, SWT.BEGINNING)
                    .grab(true, false)
                    .hint(
                            convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH),
                            SWT.DEFAULT).applyTo(messageLabel);
        }
        return composite;
    }
    
    @Override
    protected boolean isResizable() {
        return true;
    }
    
    @Override
    protected Control createDialogArea(final Composite parent) {
        GridLayout lay = new GridLayout();
        parent.setLayout(lay);
        
        createMessageArea(parent);
        createSQLViewer(parent);
        
        btnJdbcToggle = new Button(parent, SWT.CHECK);
        btnJdbcToggle.setText(Messages.sqlScriptDialog_use_jdbc_for_ddl_update);
        boolean isDdlUpdateOverJdbc = 
                Activator.getDefault().getPreferenceStore().getBoolean(PREF.IS_DDL_UPDATE_OVER_JDBC);
        btnJdbcToggle.setSelection(isDdlUpdateOverJdbc);
        
        final Composite notJdbc = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.exclude = isDdlUpdateOverJdbc;
        notJdbc.setLayoutData(gd);
        notJdbc.setVisible(!isDdlUpdateOverJdbc);
        
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
        cmbScript.setToolTipText(DB_NAME_PLACEHOLDER + '=' +dbName + LINE_SEP +
                DB_HOST_PLACEHOLDER + '=' + dbHost + LINE_SEP + 
                DB_PORT_PLACEHOLDER + '=' + dbPort + LINE_SEP + 
                DB_USER_PLACEHOLDER + '=' + dbUser + LINE_SEP + 
                DB_PASS_PLACEHOLDER + '=' + dbPass);

        List<String> prev;
        try {
            prev = history.getHistory();
        } catch (IOException e1) {
            ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_loading_command_history, e1);
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
        txtCommand.setBackground(getShell().getDisplay()
                .getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        getShell().addListener(SWT.Activate, new Listener() {
            
            @Override
            public void handleEvent(Event event) {
                getShell().removeListener(SWT.Activate, this);
                
                try {
                    if (differ.getScript().isDangerDdl(
                            !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
                            !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                            !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT))) {
                        if (showDangerWarning() == SWT.OK) {
                            sqlEditor.getTextWidget().setBackground(colorPink);
                        } else {
                            close();
                        }
                    }
                } catch (PgCodekeeperUIException e) {
                    ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_get_script, e);
                }
            }
        });
        
        colorPink = new Color(getShell().getDisplay(), new RGB(0xff, 0xe1, 0xff));
        parent.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                colorPink.dispose();
            }
        });
        
        btnJdbcToggle.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean isJdbc = btnJdbcToggle.getSelection();
                notJdbc.setVisible(!isJdbc);
                ((GridData)notJdbc.getLayoutData()).exclude = isJdbc;
                
                parent.layout();
                parent.redraw();
                
                PreferenceInitializer.savePreference(Activator.getDefault().getPreferenceStore(), 
                        PREF.IS_DDL_UPDATE_OVER_JDBC, String.valueOf(btnJdbcToggle.getSelection()));
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), HELP.SQL_SCRIPT_DIALOG); 
        
        return parent;
    }

    private void createSQLViewer(Composite parent) {
        sqlEditor = new SqlSourceViewerExtender(parent, SWT.NONE);
        sqlEditor.addLineNumbers();
        sqlEditor.setEditable(true);
        try {
            sqlEditor.setDocument(new Document(differ.getDiffDirect()));
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_get_script, e);
        }
        sqlEditor.activateAutocomplete();
        
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 600;
        gd.heightHint = 400;
        sqlEditor.getControl().setLayoutData(gd);
    }
    
    private int showDangerWarning() {
        MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING
                | SWT.OK | SWT.CANCEL);
        mb.setText(Messages.sqlScriptDialog_warning);
        mb.setMessage(Messages.sqlScriptDialog_script_contains_statements_that_may_modify_data);
        return mb.open();
    }

    @Override
    protected void buttonPressed(int buttonId) {
        final String textRetrieved = sqlEditor.getDocument().get();
        
        // case Run script
        if (buttonId == 0 && !isRunning) {
            // new runnable to unlock the UI thread
            Runnable launcher;
            
            if (btnJdbcToggle.getSelection()){
                launcher = new Runnable() {
                    
                    @Override
                    public void run() {
                        String output = Messages.sqlScriptDialog_script_has_not_been_run_yet;
                        try{
                            JdbcConnector connector = new JdbcConnector(
                                    dbHost, Integer.valueOf(dbPort), dbUser, dbPass, dbName, UIConsts.UTF_8);
                            output = new JdbcRunner(connector).runScript(textRetrieved);
                            if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                                addDepcy = getDependenciesFromOutput(output);
                            }
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        } finally {
                            // request UI change: button label changed
                            SqlScriptDialog.this.afterScriptFinished(output);
                        }
                    }
                };
            }else{
                final List<String> command = new ArrayList<>(Arrays.asList(
                        getReplacedString().split(Pattern.quote(" ")))); //$NON-NLS-1$
                
                launcher = new Runnable() {
    
                    @Override
                    public void run() {
                        final StdStreamRedirector sr = new StdStreamRedirector();
                        try (TempFile tempFile = new TempFile("tmp_rollon_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
                            File outFile = tempFile.get();
                            try (PrintWriter writer = new PrintWriter(outFile, UIConsts.UTF_8)) {
                                writer.write(textRetrieved);
                            }
    
                            String filepath = outFile.getAbsolutePath();
                            ListIterator<String> it = command.listIterator();
                            while (it.hasNext()) {
                                it.set(it.next().replace(SCRIPT_PLACEHOLDER, filepath));
                            }
                            
                            ProcessBuilder pb = new ProcessBuilder(command);
                            sr.launchAndRedirect(pb);
                            if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                                addDepcy = getDependenciesFromOutput(sr.getStorage());
                            }
                        } catch (IOException ex) {
                            if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY)) {
                                addDepcy = getDependenciesFromOutput(sr.getStorage());
                                if (!addDepcy.isEmpty()) {
                                    // actually parsed some depcies, do not rethrow
                                    return;
                                }
                            }
                            throw new IllegalStateException(ex);
                        } finally {
                            // request UI change: button label changed
                            SqlScriptDialog.this.afterScriptFinished(sr.getStorage());
                        }
                    }
                };
            }
            // run thread that calls StdStreamRedirector.launchAndRedirect()
            scriptThread = new Thread(launcher);
            scriptThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    ExceptionNotifier.showErrorDialog(
                            Messages.sqlScriptDialog_exception_during_script_execution,e);
                }
            });
            scriptThread.start();
            
            isRunning = true;
            getButton(0).setText(STOP_SCRIPT_LABEL);
        }
        // case Stop script
        else if (buttonId == 0 && isRunning){
            ConsoleFactory.write(Messages.sqlScriptDialog_script_execution_interrupted);
            Log.log(Log.LOG_INFO, Messages.sqlScriptDialog_script_interrupted_by_user);
            
            scriptThread.interrupt();
            getButton(0).setText(RUN_SCRIPT_LABEL);
            isRunning = false;
        }
        // case Save to a file
        else if (buttonId == 1){
            FileDialog fd = new FileDialog(getShell(), SWT.SAVE);
            fd.setText(Messages.sqlScriptDialog_save_as);
            fd.setOverwrite(true);
            fd.setFilterExtensions(new String[] {"*.sql", "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
            String scriptFileName = fd.open();
            
            if (scriptFileName != null) {
                File script = new File(scriptFileName);
                try (PrintWriter writer = new PrintWriter(script, UIConsts.UTF_8)) {
                    writer.write(textRetrieved);
                } catch (IOException ex) {
                    ExceptionNotifier.showErrorDialog(
                            Messages.sqlScriptDialog_error_saving_script_to_file, ex);
                    return;
                }
                
                String fileSaved = Messages.sqlScriptDialog_script_saved_to_file + script.getAbsolutePath();
                ConsoleFactory.write(fileSaved);
                Log.log(Log.LOG_INFO, fileSaved);
            }
        } else {
            this.close();
        }
    }
    
    private void afterScriptFinished(final String scriptOutput){
        final Button runScriptBtn = getButton(0);
        this.getShell().getDisplay().syncExec(
                new Runnable() {

                    @Override
                    public void run() {
                        if (!runScriptBtn.isDisposed()) {
                            if (mainPrefs.getBoolean(
                                    DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY)) {
                                new ScriptRunResultDialog(
                                        getShell(), scriptOutput).open();
                            }
                            runScriptBtn.setText(RUN_SCRIPT_LABEL);
                            showAddDepcyDialog();
                        }
                        isRunning = false;
                    }
                });
    }
    
    private void showAddDepcyDialog() {
        if (mainPrefs.getBoolean(DB_UPDATE_PREF.USE_PSQL_DEPCY) && addDepcy != null && !addDepcy.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), 
                    SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
            mb.setText(Messages.sqlScriptDialog_psql_dependencies);
            mb.setMessage(Messages.SqlScriptDialog__results_of_script_revealed_dependent_objects +
                    depcyToString() + LINE_SEP);
            List<Entry<PgStatement, PgStatement>> depcyToAdd = 
                    getAdditionalDepcyFromNames(addDepcy);
            String repeats = getRepeatedDepcy(depcyToAdd);
            if (repeats.length() > 0) {
                mb.setMessage(mb.getMessage() + 
                        Messages.sqlScriptDialog_this_dependencies_have_been_added_already_check_order + repeats);  
            }
            mb.setMessage(mb.getMessage() + LINE_SEP +
                    Messages.SqlScriptDialog_add_it_to_script);
            if (mb.open() == SWT.OK) {
                final List<Entry<PgStatement, PgStatement>> saveToRestore = new ArrayList<>(
                        differ.getAdditionalDepciesSource());
                differ.addAdditionalDepciesSource(depcyToAdd);
                
                Job job = differ.getDifferJob();
                job.addJobChangeListener(new JobChangeAdapter() {
                    
                    @Override
                    public void done(IJobChangeEvent event) {
                        if (event.getResult().isOK()) {
                            Display.getDefault().asyncExec(new Runnable() {

                                @Override
                                public void run() {
                                    if (getShell().isDisposed()) {
                                        return;
                                    }
                                    checkAskDanger(saveToRestore);
                                }
                            });
                        }
                    }
                    
                    private void checkAskDanger(
                            List<Entry<PgStatement, PgStatement>> saveToRestore) {
                        try {
                            if (differ.getScript().isDangerDdl(
                                    !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_TABLE_STATEMENT), 
                                    !mainPrefs.getBoolean(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT),
                                    !mainPrefs.getBoolean(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT))) {
                                if (showDangerWarning() != SWT.OK) {
                                    differ.setAdditionalDepciesSource(saveToRestore);
                                    return;
                                } else {
                                    sqlEditor.getTextWidget().setBackground(colorPink);
                                }
                            }
                            sqlEditor.setDocument(new Document(differ.getDiffDirect()));
                            sqlEditor.refresh();
                        } catch (PgCodekeeperUIException e) {
                            ExceptionNotifier.showErrorDialog(
                                    Messages.SqlScriptDialog_error_add_depcies, e);
                        }
                    }
                });
                job.setUser(true);
                job.schedule();
            }
        }
    }
    
    private String getRepeatedDepcy(List<Entry<PgStatement, PgStatement>> depcyToAdd) {
        List<Entry<PgStatement, PgStatement>> existingDepcy = differ.getAdditionalDepciesSource();
        StringBuilder sb = new StringBuilder();
        for (Entry<PgStatement, PgStatement> entry : depcyToAdd) {
            if (existingDepcy.contains(entry)) {
                sb.append(entry.getKey().getName())
                    .append(" -> ") //$NON-NLS-1$
                    .append(entry.getValue().getName())
                    .append(LINE_SEP);
            }
        }
        return sb.toString();
    }
    
    private List<Entry<PgStatement, PgStatement>> getAdditionalDepcyFromNames(
            List<Entry<String, String>> addDepcy) {
        List<Entry<PgStatement, PgStatement>> result = new ArrayList<>();
        for (Entry<String, String> entry : addDepcy) {
            PgStatement depcy1 = getPgObjByName(entry.getKey());
            PgStatement depcy2 = getPgObjByName(entry.getValue());
            if (depcy1 != null && depcy2 != null) {
                result.add(new AbstractMap.SimpleEntry<>(
                    depcy1, depcy2));
            }
        }
        return result; 
    }

    private PgStatement getPgObjByName(String objName) {
        for (PgStatement obj : objList) {
            if (obj.getName().equals(objName)) {
                return obj; 
            }
        }
        return null;
    }
    
    private String depcyToString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String> entry : addDepcy) {
            sb.append(' '); 
            sb.append(entry.getKey());
            sb.append(" -> "); //$NON-NLS-1$
            sb.append(entry.getValue());
            sb.append(LINE_SEP); 
        }
        return sb.toString();
    }
    
    private List<Entry<String, String>> getDependenciesFromOutput(String output) {
        List<Entry<String, String>> depciesList = new ArrayList<>();
        if (output == null || output.isEmpty()) {
            return depciesList;
        }
        
        int begin, end;
        begin = end = -1;
        
        // replacing all multiple spaces by single one, replacing CRLF by LF, 
        // replacing all leading spaces for every line in the string 
        String replaced = output.replaceAll("[ ]{2,}", " ") //$NON-NLS-1$ //$NON-NLS-2$
                .replaceAll("\r\n", "\n") //$NON-NLS-1$ //$NON-NLS-2$
                .replaceAll("(\n[ ]+)", "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        String[] lines = replaced.split(Pattern.quote("\n")); //$NON-NLS-1$
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (PATTERN_ERROR.matcher(line).matches()) {
                begin = i;
            } 
            if (PATTERN_DROP_CASCADE.matcher(line).matches()) {
                end = i;
                break;
            }
        }
        
        if (begin != -1 && end != -1 && (end - begin) >= 2) {
            String words[] = lines[begin + 1].split(Pattern.quote(" ")); //$NON-NLS-1$
            // parse first case separately, as it starts from extra word "details"
            depciesList.add(new AbstractMap.SimpleEntry<>(
                    words[2], words[words.length - 1]));
            // parse rest of dependencies
            parseDependencies(lines, begin + 2, end, depciesList);
        }
        
        return depciesList;
    }

    private void parseDependencies(String[] lines, int begin, int end,
            List<Entry<String, String>> listToFill) {
        String space = Pattern.quote(" "); //$NON-NLS-1$
        for (int i = begin; i < end; i++) {
            String words[] = lines[i].split(space); 
            listToFill.add(new AbstractMap.SimpleEntry<>(
                    words[1], words[words.length - 1]));
        }
    }

    @Override
    public boolean close() {
        if (isRunning) {
            MessageBox errorDialog = new MessageBox(getShell(), SWT.OK);
            errorDialog.setMessage(Messages.sqlScriptDialog_stop_script_before_closing_dialog);
            errorDialog.open();
            return false;
        } else {
            differ.setAdditionalDepciesSource(oldDepcy);
            try {
                history.addHistoryEntry(cmbScript.getText());
            } catch (IOException e) {
                ExceptionNotifier.showErrorDialog(Messages.SqlScriptDialog_error_adding_command_history, e);
            }
            return super.close();
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
}
