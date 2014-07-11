package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
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

import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.parts.Console;

public class SqlScriptDialog extends MessageDialog {
    
    private static final String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
    private static final String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
    private static final String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
    private static final String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
    private static final String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
    private static final String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$
    
    public static final String runScriptText =  Messages.sqlScriptDialog_run_script;
    public static final String stopScriptText = Messages.sqlScriptDialog_stop_script;
    
    private final static String SCRIPTS_HIST_ROOT = "scripts"; //$NON-NLS-1$
    private final static String SCRIPTS_HIST_EL = "s"; //$NON-NLS-1$
    private final static String SCRIPTS_HIST_FILENAME = "rollon_cmd_history.xml"; //$NON-NLS-1$
    private final static int SCRIPTS_HIST_MAX_STORED = 20;

    private final XmlHistory history;
    private final String text;
    
    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPass;
    
    private Text txtMain;
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
            String text) {
        super(parentShell, title, null, message, type, new String[] {
                runScriptText, Messages.sqlScriptDialog_save_as, IDialogConstants.CLOSE_LABEL }, 2);
        
        setShellStyle(getShellStyle() | SWT.RESIZE);
        
        this.text = text;
        this.history = new XmlHistory(SCRIPTS_HIST_MAX_STORED, 
                SCRIPTS_HIST_FILENAME, 
                SCRIPTS_HIST_ROOT, 
                SCRIPTS_HIST_EL);
    }
    
    @Override
    protected Control createCustomArea(Composite parent) {
        txtMain = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.MULTI);
        txtMain.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txtMain.setText(text);
        
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 600;
        gd.heightHint = 400;
        txtMain.setLayoutData(gd);
        
        Label l = new Label(parent, SWT.NONE);
        l.setText(Messages.sqlScriptDialog_Enter_cmd_to_roll_on_sql_script
                + SCRIPT_PLACEHOLDER + ' '
                + DB_NAME_PLACEHOLDER + ' '
                + DB_HOST_PLACEHOLDER + ' ' + DB_PORT_PLACEHOLDER + ' '
                + DB_USER_PLACEHOLDER + ' ' + DB_PASS_PLACEHOLDER + ')' + ':');
        gd = new GridData(GridData.FILL_HORIZONTAL);
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
        
        txtCommand = new Text(parent, SWT.BORDER);
        txtCommand.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtCommand.setEditable(false);
        txtCommand.setText(getReplacedString());
        
        return parent;
    }
    
    @Override
    protected void buttonPressed(int buttonId) {
        final String textRetrieved = txtMain.getText();
        
        // case Run script
        if (buttonId == 0 && !isRunning){
            this.runScriptBtn = getButton(0);
            final File fileTmpScript;
            try {
                // TODO remove fileTmpScript if script is done or interrupted
                fileTmpScript = new TempFile("tmp_rollon_", ".sql").get(); //$NON-NLS-1$ //$NON-NLS-2$
                
               try (PrintWriter writer = new PrintWriter(fileTmpScript)) {
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
                        StdStreamRedirector.launchAndRedirect(pb);
                    } catch (IOException ex) {
                        throw new IllegalStateException(ex);
                    } finally {
                        fileTmpScript.delete();
                        
                        // request UI change: button label changed
                        SqlScriptDialog.this.getShell().getDisplay().syncExec(
                                new Runnable() {
                                    
                                    @Override
                                    public void run() {
                                        isRunning = false;
                                        runScriptBtn.setText(runScriptText);
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
                    Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
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
                try (PrintWriter writer = new PrintWriter(script)) {
                    writer.write(textRetrieved);
                } catch (IOException ex) {
                    Status status = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID, 
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
    
    @Override
    public boolean close() {
        if (isRunning) {
            MessageBox errorDialog = new MessageBox(getShell(), SWT.OK);
            errorDialog.setMessage(Messages.sqlScriptDialog_stop_script_before_closing_dialog);
            errorDialog.open();
            return false;
        } else {
            history.addHistoryEntry(cmbScript.getText());
            return super.close();
        }
    }
}
