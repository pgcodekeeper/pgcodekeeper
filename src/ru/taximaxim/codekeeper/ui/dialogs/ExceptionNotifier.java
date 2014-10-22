package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Helper class for notifying user of exceptions thrown.<br>
 * Logs messages to log. Outputs short message to Console and displays 
 * ErrorDialog with stack trace, if requested.
 * 
 * @author ryabinin_av
 */
public class ExceptionNotifier {
    
    public static void showErrorDialog(final String message, Throwable source) {
        // TODO use default StatusHandler?
        notify(source, message, true, true);
    }
    /**
     * Outputs short message to {@link ConsoleFactory},
     * prints stack trace to log,
     * displays UI dialog with message and stack trace
     * 
     * @param shell dialog parent. Can be null if showInDialog is false
     */
    public static void notify(Throwable source, final String message, 
            boolean outputToConsole, boolean showInDialog) {
        if (source == null) {
            source = new Throwable("Throwable is null at this point!"); //$NON-NLS-1$
        }
        Log.log(Log.LOG_ERROR, source.getMessage(), source);
        
        executeNotify(source, message, outputToConsole, showInDialog);
    }

    private static void executeNotify(final Throwable source,
            final String message, boolean outputToConsole,
            boolean showInDialog) {
        String initialReason = ""; //$NON-NLS-1$
        Throwable t = source.getCause();
        while (t != null){
            initialReason = t.getMessage() == null? initialReason : t.toString();
            t = t.getCause();
        }
        
        if (outputToConsole){
            ConsoleFactory.write(message + ": " + initialReason); //$NON-NLS-1$
        }
        if (showInDialog){
            final IStatus status = new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                    initialReason, source);
            Display.getDefault().syncExec(new Runnable() {

                @Override
                public void run() {
                    new StackTraceErrorDialog(Messages.exceptionNotifier_unhandled_exception,
                            message + ": " + source.toString(), status, status //$NON-NLS-1$
                                    .getSeverity()).open();
                }
            });
        }
    }
    
    public static void notify(String message, Throwable ex) {
        Status status = new Status(IStatus.ERROR, PLUGIN_ID.THIS, 
                message, ex);
        StatusManager.getManager().handle(status, StatusManager.BLOCK);
    }
    
    private ExceptionNotifier() {}
}

class StackTraceErrorDialog extends ErrorDialog {
    
    private IStatus status;
    
    private List lstStackTrace;
    
    public StackTraceErrorDialog(String dialogTitle,
            String message, IStatus status, int displayMask) {
        super(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), dialogTitle, message, status, displayMask);
        this.status = status;
    }
    
    private String stackTraceAsString() {
        Throwable t = status.getException();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    
    @Override
    protected List createDropDownList(Composite parent) {
        lstStackTrace = super.createDropDownList(parent);
        
        if (status != null && status.getException() != null) {
            BufferedReader rdr = new BufferedReader(new StringReader(stackTraceAsString()));
            try {
                String line;
                while ((line = rdr.readLine()) != null) {
                    lstStackTrace.add(line);
                }
            } catch (IOException ex) {
                throw new IllegalStateException(
                        Messages.exceptionNotifier_string_reader_ioexception_world_ends, ex);
            }
        }
        return lstStackTrace;
    }
    
    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        createButton(parent, Integer.MAX_VALUE, Messages.exceptionNotifier_copy_stack_trace, false)
                .addSelectionListener(new SelectionAdapter() {

                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        putStackToClipboard(parent.getDisplay());
                    }
                });
        
        super.createButtonsForButtonBar(parent);
    }

    private void putStackToClipboard(Display display) {
        new Clipboard(display).setContents(
                new Object[]   { stackTraceAsString() }, 
                new Transfer[] { TextTransfer.getInstance() }
            );
    }
}
