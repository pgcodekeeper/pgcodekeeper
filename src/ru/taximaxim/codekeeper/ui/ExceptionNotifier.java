package ru.taximaxim.codekeeper.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
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
     * Outputs short to console
     * Prints stack trace to log
     * Displays UI dialog with message and stack trace
     * 
     * @param source
     * @param message
     * @param shell Shell to display dialog on. Can be null if showInDialog is false
     * @param outputToConsole
     * @param showInDialog
     */
    public static void notify(final Throwable source, final String message, final Shell shell, 
            boolean outputToConsole, boolean showInDialog) {
        Log.log(Log.LOG_ERROR, source.getMessage(), source);
        
        String initReason = "";
        Throwable t = source.getCause();
        while (t != null){
            initReason = t.getMessage() == null? initReason : t.toString();
            t = t.getCause();
        }
        
        if (outputToConsole){
            Console.addMessage(message + ": " + initReason);
        }
        if (showInDialog){
            final IStatus status = new Status(IStatus.ERROR, "<unknown>", initReason, source);
            Display.getDefault().syncExec(
                    new Runnable() {
                        
                        @Override
                        public void run() {
                            new ExceptionNotifier().new StackTraceErrorDialog(shell,
                                    "Exception thrown", message + ": " + 
                                            source.toString(), status, 4).open();
                        }
                    });
        }
    }
    
    /**
     * Default constructor
     */
    public ExceptionNotifier() {
        
    }
    
    private class StackTraceErrorDialog extends ErrorDialog {
        
        private IStatus status;
        
        private List rtc;
        
        public StackTraceErrorDialog(Shell parentShell, String dialogTitle,
                String message, IStatus status, int displayMask) {
            super(parentShell, dialogTitle, message, status, displayMask);
            this.status = status;
        }
        
        @Override
        protected List createDropDownList(Composite parent) {
            rtc = super.createDropDownList(parent);
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
        
        @Override
        protected void createButtonsForButtonBar(final Composite parent) {
            Layout layout = parent.getLayout();
            if (layout instanceof GridLayout){
                GridLayout gl = (GridLayout) layout;
                gl.numColumns++;
                parent.setLayout(gl);
            }
            createButton(parent, IDialogConstants.NO_ID, "Copy stack trace",true).
                    addSelectionListener(new SelectionListener() {

                @Override
                public void widgetSelected(SelectionEvent arg0) {
                    putStackToClipboard(parent);
                }

                @Override
                public void widgetDefaultSelected(SelectionEvent arg0) {
                    putStackToClipboard(parent);
                }
            });
            
            super.createButtonsForButtonBar(parent);
        }

        private void putStackToClipboard(Composite parent) {
            // generate list to fetch strings from
            if (rtc == null){
                createDropDownList(getShell());
            }
            StringBuilder sBuilder = new StringBuilder();
            for (String l : rtc.getItems()){
                sBuilder.append(l + "\n");
            }
            new Clipboard(parent.getDisplay()).setContents(new Object[]{sBuilder.toString()}, 
                    new Transfer[] { TextTransfer.getInstance() });
        }
    }
}