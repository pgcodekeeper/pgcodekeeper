package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.parts.Console;

public class SqlScriptDialog extends MessageDialog {
    
    private static final String SCRIPT_PLACEHOLDER = "%script";
    public static final String runScriptText =  "\u25B6 run script";
    public static final String stopScriptText = "\u25A0 stop script";
    
    private final String text;
    private String execScript = "";
    
    private Text txtMain;
    private Text txtScript;
    private boolean isRunning = false;
    private Button runScriptBtn;
    
    private Thread scriptThread;

    public void setScript(String rollScript) {
        this.execScript = rollScript;
    }
    
    public String getScript() {
        return execScript;
    }
    
    public SqlScriptDialog(Shell parentShell, int type, String title, String message,
            String text) {
        super(parentShell, title, null, message, type, new String[] {
                runScriptText, "Save as...", IDialogConstants.CLOSE_LABEL }, 2);
        
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.text = text;
    }
    
    @Override
    protected Control createCustomArea(Composite parent) {
        txtMain = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | /*SWT.READ_ONLY |*/ SWT.MULTI);
        txtMain.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        /*txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));*/
        
        txtMain.setText(text);
        
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 600;
        gd.heightHint = 400;
        txtMain.setLayoutData(gd);
        
        Label l = new Label(parent, SWT.NONE);
        l.setText("Enter command to roll on this SQL script ("
                + SCRIPT_PLACEHOLDER + " is replaced by the SQL script file):");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 12;
        l.setLayoutData(gd);
        
        txtScript = new Text(parent, SWT.BORDER);
        txtScript.setText(execScript);
        txtScript.setToolTipText("Use " + SCRIPT_PLACEHOLDER
                + " to denote a place where SQL script filename will be inserted.");
        txtScript.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
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
                fileTmpScript = new TempFile("tmp_rollon_", ".sql").get();
                
                PrintWriter writer = new PrintWriter(fileTmpScript);
                writer.write(textRetrieved);
                writer.close();
            } catch (IOException ex) {
                ExceptionNotifier.notify(new IllegalStateException("Error saving "
                        + "rollon script to temporary file" , ex), getShell(), true, true);
                return;
            }
                
            List<String> command = Arrays.asList(txtScript.getText()
                    .replaceFirst(SCRIPT_PLACEHOLDER, fileTmpScript.getAbsolutePath())
                    .split(Pattern.quote(" ")));
            final ProcessBuilder pb = new ProcessBuilder(command);
            
            // new runnable to unlock the UI thread
            Runnable launcher = new Runnable() {
                
                @Override
                public void run() {
                    try {
                        StdStreamRedirector.launchAndRedirect(pb);
                    } catch (final IOException ex) {
                        // in case of exception sync call to notify user via UI
                        SqlScriptDialog.this.getShell().getDisplay().syncExec(
                                new Runnable() {
                                    
                                    @Override
                                    public void run() {
                                        ExceptionNotifier.notify(
                                                new IllegalStateException(
                                                        "Exception during script execution", ex),
                                                        getShell(), true, true);
                                    }
                                });
                    } finally {
                        fileTmpScript.delete();
                        
                        // request UI change: button label changed
                        SqlScriptDialog.this.getShell().getDisplay().asyncExec(
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
            scriptThread.start();
            getButton(0).setText(stopScriptText);
            isRunning = true;
        }
        // case Stop script
        else if (buttonId == 0 && isRunning){
            Console.addMessage("Script execution interrupted!");
            Log.log(Log.LOG_INFO, "Script execution interrupted by user.");
            
            scriptThread.interrupt();
            getButton(0).setText(runScriptText);
            isRunning = false;
        }
        // case Save to a file
        else if (buttonId == 1){
            FileDialog fd = new FileDialog(getShell(), SWT.SAVE);
            fd.setText("Save as...");
            fd.setOverwrite(true);
            fd.setFilterExtensions(new String[] {"*.sql", "*.*"});
            String scriptFileName = fd.open();
            
            if (scriptFileName != null) {
                File script = new File(scriptFileName);
                try (PrintWriter writer = new PrintWriter(script)) {
                    writer.write(textRetrieved);
                } catch (IOException ex) {
                    ExceptionNotifier.notify(new IllegalStateException("Error saving "
                            + "script to a file", ex), getShell(), true, true);
                    return;
                }
                
                String fileSaved = "Script saved to file " + script.getAbsolutePath();
                Console.addMessage(fileSaved);
                Log.log(Log.LOG_INFO, fileSaved);
            }
        }
        // case Ok
        else if (buttonId == 2){
            execScript = txtScript.getText();
            super.buttonPressed(buttonId);
        }
    }
    
    @Override
    public boolean close() {
        if (isRunning) {
            MessageBox errorDialog = new MessageBox(getShell(), SWT.OK);
            errorDialog.setMessage("Stop the script before closing dialog");
            errorDialog.open();
            return false;
        } else {
            return super.close();
        }
    }
}