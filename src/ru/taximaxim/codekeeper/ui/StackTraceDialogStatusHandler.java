package ru.taximaxim.codekeeper.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.statushandlers.IStatusDialogConstants;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

/**
 * pgCodekeeper default error handler.<br>
 * Partly copied from org.eclipse.ui.statushandlers.WorkbenchErrorHandler
 * 
 * @author ryabinin_av
 */
public class StackTraceDialogStatusHandler extends AbstractStatusHandler{

    /**
     * Singleton instance
     */
    private static StackTraceDialogStatusHandler handler;
    /**
     * WorkbenchStatusDialogManager instance to get shell from
     */
    private WorkbenchStatusDialogManager statusDialogManager;
    
    @Override
    public void handle(final StatusAdapter statusAdapter, int style) {

        if (((style & StatusManager.SHOW) == StatusManager.SHOW)
                || ((style & StatusManager.BLOCK) == StatusManager.BLOCK)) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    showStatusAdapter(statusAdapter);
                }
            });
        }

        if ((style & StatusManager.LOG) == StatusManager.LOG) {
            StatusManager.getManager().addLoggedStatus(statusAdapter.getStatus());
            IStatus status = statusAdapter.getStatus();
            Log.log(Log.LOG_ERROR, status.getMessage(), status.getException());
        }
    }
    
    /**
     * Display the status adaptor - dialog with copyable stack trace as details
     */
    private void showStatusAdapter(StatusAdapter statusAdapter) {
        ExceptionNotifier.notify(statusAdapter.getStatus().getException(),
                statusAdapter.getStatus().getMessage(), getStatusDialogShell(), true, true);
        
    }

    /**
     * Returns singleton instance of StackTraceDialogStatusHandler
     */
    public static StackTraceDialogStatusHandler get(){
        if (handler == null){
            handler = new StackTraceDialogStatusHandler();
        }
        return handler;
    }

    /**
     * This method returns current {@link WorkbenchStatusDialogManager}.
     * <br>
     * Required only for getting shell instance. To be changed later.
     * 
     * @return current {@link WorkbenchStatusDialogManager}
     */
    // FIXME restricted access
    private WorkbenchStatusDialogManager getStatusDialogManager() {
        if (statusDialogManager == null) {
            synchronized (this) {
                if (statusDialogManager == null) {
                    statusDialogManager = new WorkbenchStatusDialogManager(null);
                    statusDialogManager.setProperty(
                            IStatusDialogConstants.SHOW_SUPPORT, Boolean.TRUE);
                    statusDialogManager.setProperty(
                            IStatusDialogConstants.HANDLE_OK_STATUSES,
                            Boolean.TRUE);
                    statusDialogManager.setProperty(
                            IStatusDialogConstants.ERRORLOG_LINK, Boolean.TRUE);
                }
            }
        }
        return statusDialogManager;
    }

    /**
     * Returns shell for dialog to be built on
     */
    private Shell getStatusDialogShell() {
        return (Shell) getStatusDialogManager().getProperty(
                IStatusDialogConstants.SHELL);
    }
    
    private StackTraceDialogStatusHandler() {
    }
}
