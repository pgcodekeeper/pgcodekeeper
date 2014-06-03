package ru.taximaxim.codekeeper.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.parts.Console;

/**
 * Helper class for notifying user of exceptions thrown.<br>
 * Logs messages to log. Outputs short message to Console and displays 
 * ErrorDialog with stack trace, if requested.
 * <br><br>
 * This class calls should be synchronized by the caller if UI interaction 
 * is requested.
 * 
 * @author ryabinin_av
 *
 */
public class ExceptionNotifier {
    
    /**
     * Outputs ex.getMessage() to console
     * Prints stack trace to log
     * Displays UI dialog with message and stack trace
     * 
     * @param ex
     * @param parent
     * @param outputToConsole
     * @param showInDialog
     */
    public static void notify(RuntimeException ex, Shell parent, 
            boolean outputToConsole, boolean showInDialog) {
        Log.log(Log.LOG_ERROR, ex.getMessage(), ex);
        
        String initReason = "";
        Throwable t = ex.getCause();
        while (t != null){
            initReason = t.getMessage() == null? "" : t.getMessage();
            t = t.getCause();
        }
        
        if (outputToConsole){
            Console.addMessage(ex.getMessage() + ": " + initReason);
        }
        if (showInDialog){
            IStatus status = new Status(IStatus.ERROR, "<unknown>", initReason, ex);
            StackTraceErrorDialog errorDialog = new ExceptionNotifier().
                    new StackTraceErrorDialog(parent, "Exception thrown", ex.getMessage(), status, 4);
            errorDialog.open();
        }
    }
    
    /**
     * Default constructor
     */
    public ExceptionNotifier() {
        
    }
    
    private class StackTraceErrorDialog extends ErrorDialog {
        
        private IStatus status;
        
        public StackTraceErrorDialog(Shell parentShell, String dialogTitle,
                String message, IStatus status, int displayMask) {
            super(parentShell, dialogTitle, message, status, displayMask);
            this.status = status;
        }
        
        @Override
        protected List createDropDownList(Composite parent) {
            List rtc = super.createDropDownList(parent);
            if (status != null && status.getException() != null) {
                
                Throwable t = status.getException();
                while(t != null){
                    StackTraceElement[] ste = t.getStackTrace();
                    rtc.add("caused by: " + t.getClass() + ": " + t.getMessage());
                    for (int i = 0; i < ste.length; i++) {
                        rtc.add("\t" + ste[i].toString());
                    }
                    t = t.getCause();
                }
            }
            return rtc;
        }
        
    }
}