package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.differ.Differ;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.parts.Console;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class SqlScriptDialog extends MessageDialog {

    private static final Pattern PATTERN_ERROR = Pattern.compile(
            "^.+(ERROR|ОШИБКА):.+$"); //$NON-NLS-1$
    private static final Pattern PATTERN_DROP_CASCADE = Pattern.compile(
            "^(HINT|ПОДСКАЗКА):.+(DROP \\.\\.\\. CASCADE).+$"); //$NON-NLS-1$
    
    private static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    private static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    private static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    private static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    private static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    private static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$
    
    public static final String runScriptText =  Messages.sqlScriptDialog_run_script;
    public static final String stopScriptText = Messages.sqlScriptDialog_stop_script;
    
    private static final String SCRIPTS_HIST_ROOT = "scripts"; //$NON-NLS-1$
    private static final String SCRIPTS_HIST_EL = "s"; //$NON-NLS-1$
    private static final String SCRIPTS_HIST_FILENAME = "rollon_cmd_history.xml"; //$NON-NLS-1$
    private static final int SCRIPTS_HIST_MAX_STORED = 20;

    private final XmlHistory history;
    private final Differ differ;
    private List<Entry<String, String>> addDepcy;
    private final List<Entry<PgStatement, PgStatement>> oldDepcy;
    private List<PgStatement> objList;
    private final boolean usePsqlDepcy;
    
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPass;
    
    private SqlSourceViewerExtender sqlEditor;
    private Text txtCommand;
    private Combo cmbScript;
    private Button runScriptBtn;
    
    private boolean isRunning;
    private Thread scriptThread;

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
            Differ differ, List<PgStatement> objList, boolean usePsqlDepcy) {
        super(parentShell, title, null, message, type, new String[] {
                runScriptText, Messages.sqlScriptDialog_save_as, IDialogConstants.CLOSE_LABEL }, 2);
        
        this.differ = differ;
        this.oldDepcy = differ.getAdditionalDepcies();
        differ.setAdditionalDepcies(new ArrayList<>(oldDepcy));
        this.objList = objList;
        this.usePsqlDepcy = usePsqlDepcy;
        this.history = new XmlHistory.Builder(SCRIPTS_HIST_MAX_STORED, 
                SCRIPTS_HIST_FILENAME, 
                SCRIPTS_HIST_ROOT, 
                SCRIPTS_HIST_EL).build();
    }
    
    @Override
    protected boolean isResizable() {
        return true;
    }
    
    @Override
    protected Control createCustomArea(Composite parent) {
        createSQLViewer(parent);
        
        Label l = new Label(parent, SWT.NONE);
        l.setText(Messages.sqlScriptDialog_Enter_cmd_to_roll_on_sql_script
                + SCRIPT_PLACEHOLDER + ' '
                + DB_NAME_PLACEHOLDER + ' '
                + DB_HOST_PLACEHOLDER + ' ' + DB_PORT_PLACEHOLDER + ' '
                + DB_USER_PLACEHOLDER + ' ' + DB_PASS_PLACEHOLDER + ')' + ':');
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        cmbScript = new Combo(parent, SWT.DROP_DOWN);
        cmbScript.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        String n = System.lineSeparator();
        cmbScript.setToolTipText(DB_NAME_PLACEHOLDER + '=' +dbName + n +
                DB_HOST_PLACEHOLDER + '=' + dbHost + n + 
                DB_PORT_PLACEHOLDER + '=' + dbPort + n + 
                DB_USER_PLACEHOLDER + '=' + dbUser + n + 
                DB_PASS_PLACEHOLDER + '=' + dbPass);

        List<String> prev = history.getHistory();
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
        
        l = new Label(parent, SWT.NONE);
        l.setText(Messages.SqlScriptDialog_command_to_execute + SCRIPT_PLACEHOLDER
                + Messages.SqlScriptDialog_will_be_replaced);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        txtCommand = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
        txtCommand.setText(getReplacedString());
        txtCommand.setBackground(getShell().getDisplay()
                .getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        return parent;
    }

    private void createSQLViewer(Composite parent) {
        sqlEditor = new SqlSourceViewerExtender(parent, SWT.NONE);
        sqlEditor.addLineNumbers();
        sqlEditor.setEditable(true);
        sqlEditor.setDocument(new Document(differ.getDiffDirect()));
        sqlEditor.activateAutocomplete();
        
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 600;
        gd.heightHint = 400;
        sqlEditor.getControl().setLayoutData(gd);
    }
    
    @Override
    protected void buttonPressed(int buttonId) {
        final String textRetrieved = sqlEditor.getDocument().get();
        
        // case Run script
        if (buttonId == 0 && !isRunning){
            this.runScriptBtn = getButton(0);
            final File fileTmpScript;
            try {
                // TODO remove fileTmpScript if script is done or interrupted
                fileTmpScript = new TempFile("tmp_rollon_", ".sql").get(); //$NON-NLS-1$ //$NON-NLS-2$
                
               try (PrintWriter writer = new PrintWriter(fileTmpScript, "UTF-8")) { //$NON-NLS-1$
                   writer.write(textRetrieved);
               }
            } catch (IOException ex) {
                throw new IllegalStateException(
                        Messages.sqlScriptDialog_error_saving_script_to_tmp_file, ex);
            }
                
            List<String> command = Arrays.asList(getReplacedString()
                    .replace(SCRIPT_PLACEHOLDER, fileTmpScript.getAbsolutePath())
                    .split(Pattern.quote(" "))); //$NON-NLS-1$
            final ProcessBuilder pb = new ProcessBuilder(command);
            
            // new runnable to unlock the UI thread
            Runnable launcher = new Runnable() {
                
                @Override
                public void run() {
                    try {
                        String scriptOutputRes =
                                StdStreamRedirector.launchAndRedirect(pb);
                        if (usePsqlDepcy) {
                            addDepcy = getDependenciesFromOutput(scriptOutputRes);
                        }
                    } catch (IOException ex) {
                        throw new IllegalStateException(ex);
                    } finally {
                        fileTmpScript.delete();
                        
                        // request UI change: button label changed
                        SqlScriptDialog.this.getShell().getDisplay().syncExec(
                                new Runnable() {
                                    
                                    @Override
                                    public void run() {
                                        if (!runScriptBtn.isDisposed()) {
                                            runScriptBtn.setText(runScriptText);
                                            showAddDepcyDialog();
                                        }
                                        isRunning = false;
                                    }
                                });
                    }
                }
            };
            // run thread that calls StdStreamRedirector.launchAndRedirect
            scriptThread = new Thread(launcher);
            scriptThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    Status status = new Status(IStatus.ERROR, PLUGIN_ID.THIS, 
                            Messages.sqlScriptDialog_exception_during_script_execution, e);
                    StatusManager.getManager().handle(status, StatusManager.BLOCK);
                }
            });
            scriptThread.start();
            getButton(0).setText(stopScriptText);
            isRunning = true;
        }
        // case Stop script
        else if (buttonId == 0 && isRunning){
            Console.addMessage(Messages.sqlScriptDialog_script_execution_interrupted);
            Log.log(Log.LOG_INFO, Messages.sqlScriptDialog_script_interrupted_by_user);
            
            scriptThread.interrupt();
            getButton(0).setText(runScriptText);
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
                try (PrintWriter writer = new PrintWriter(script, "UTF-8")) { //$NON-NLS-1$
                    writer.write(textRetrieved);
                } catch (IOException ex) {
                    Status status = new Status(IStatus.ERROR, PLUGIN_ID.THIS, 
                            Messages.sqlScriptDialog_error_saving_script_to_file, ex);
                    StatusManager.getManager().handle(status, StatusManager.BLOCK);
                    return;
                }
                
                String fileSaved = Messages.sqlScriptDialog_script_saved_to_file + script.getAbsolutePath();
                Console.addMessage(fileSaved);
                Log.log(Log.LOG_INFO, fileSaved);
            }
        } else {
            super.buttonPressed(buttonId);
        }
    }
    
    private void showAddDepcyDialog() {
        if (usePsqlDepcy && addDepcy != null && !addDepcy.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), 
                    SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
            mb.setText(Messages.sqlScriptDialog_psql_dependencies);
            mb.setMessage(Messages.SqlScriptDialog__results_of_script_revealed_dependent_objects +
                    depcyToString() + System.lineSeparator());
            List<Entry<PgStatement, PgStatement>> depcyToAdd = 
                    getAdditionalDepcyFromNames(addDepcy);
            String repeats = getRepeatedDepcy(depcyToAdd);
            if (repeats.length() > 0) {
                mb.setMessage(mb.getMessage() + 
                        Messages.sqlScriptDialog_this_dependencies_have_been_added_already_check_order + repeats);  
            }
            mb.setMessage(mb.getMessage() + System.lineSeparator() +
                    Messages.SqlScriptDialog_add_it_to_script);
            if (mb.open() == SWT.OK) {
                differ.addAdditionDepcies(depcyToAdd);
                differ.runProgressMonitorDiffer(getParentShell());
                sqlEditor.setDocument(new Document(differ.getDiffDirect()));
                sqlEditor.refresh();
            }
        }
    }

    private String getRepeatedDepcy(List<Entry<PgStatement, PgStatement>> depcyToAdd) {
        List<Entry<PgStatement, PgStatement>> existingDepcy = differ.getAdditionalDepcies();
        StringBuilder sb = new StringBuilder();
        for (Entry<PgStatement, PgStatement> entry : depcyToAdd) {
            if (existingDepcy.contains(entry)) {
                sb.append(entry.getKey().getName() + " -> " + //$NON-NLS-1$
                        entry.getValue().getName() + System.lineSeparator());
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
            sb.append(System.lineSeparator()); 
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
        String[] lines = output.replaceAll("\\s{2,}", " ").split( //$NON-NLS-1$ //$NON-NLS-2$
                Pattern.quote(System.lineSeparator()));
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
            depciesList.add(new AbstractMap.SimpleEntry<>(
                    words[2], words[words.length - 1]));
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
            differ.setAdditionalDepcies(oldDepcy);
            history.addHistoryEntry(cmbScript.getText());
            return super.close();
        }
    }
}
