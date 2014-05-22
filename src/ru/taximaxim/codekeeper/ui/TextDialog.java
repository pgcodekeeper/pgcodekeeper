package ru.taximaxim.codekeeper.ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.parts.Console;

public class TextDialog extends MessageDialog {
    
    final private String text;
    
    final int type;

    private Text txtScript;
    
    public TextDialog(Shell parentShell, int type, String title, String message,
            String text, String[] buttonLabels, int defaultButton) {
        super(parentShell, title, null, message, type, buttonLabels, defaultButton);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.text = text;
        this.type = type;
    }
    
    @Override
    protected Control createCustomArea(Composite parent) {
        Text txt = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.READ_ONLY | SWT.MULTI);
        txt.setText(text);
        
        txt.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 600;
        gd.heightHint = 400;
        txt.setLayoutData(gd);
        
        txtScript = new Text(parent, SWT.BORDER);
        txtScript.setText("");
        
        txtScript.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        txtScript.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        txtScript.setToolTipText("Use %script to denote a place where SQL script filename will be inserted.");
        gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        txtScript.setLayoutData(gd);
        
        return parent;
    }
    
    @Override
    protected void buttonPressed(int buttonId) {
        // case Run script
        if (buttonId == 0){
            try(TempFile tf = new TempFile("", ".sql")){
                PrintWriter writer = new PrintWriter(tf.get());
                writer.write(text);
                writer.close();
                List<String> command = Arrays.asList(
                        txtScript.getText().replaceFirst("%script", 
                                tf.get().getAbsolutePath()).split(" "));
                ProcessBuilder pb = new ProcessBuilder(command);
                StdStreamRedirector.launchAndRedirect(pb);
                close();
            }catch(IOException e){
                MessageBox errorDialog = new MessageBox(getShell(), SWT.OK);
                errorDialog.setMessage("IOException thrown: " + e.getMessage());
                errorDialog.open();
            }
        }
        // case Save to a file
        else if (buttonId == 1){
            FileDialog fd = new FileDialog(getShell(), SWT.SAVE);
            fd.setText("Select file to save script");
            fd.setOverwrite(true);
            fd.setFilterExtensions(new String[]{"*.sql", "*.*"});
            String scriptFileName = fd.open();
            if (scriptFileName != null){
                try{
                    File script = new File(scriptFileName);
                    PrintWriter writer = new PrintWriter(script);
                    writer.write(text);
                    writer.close();
                    String fileSaved = "Script saved to file " + script.getAbsolutePath();
                    Console.addMessage(fileSaved);
                    Log.log(Log.LOG_INFO, fileSaved);
                    close();
                }catch(IOException e){
                    MessageBox errorDialog = new MessageBox(getShell(), SWT.OK);
                    errorDialog.setMessage("Could not save file: " + e.getMessage());
                    errorDialog.open();
                }
            }
        }
        // case Ok
        else{
            super.buttonPressed(buttonId);
        }
    }
}