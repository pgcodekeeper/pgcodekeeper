package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.statushandlers.IStatusDialogConstants;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

import ru.taximaxim.codekeeper.ui.ExceptionNotifier;

/**
 * pgCodekeeper default error handler.<br>
 * Partly copied from org.eclipse.ui.statushandlers.WorkbenchErrorHandler
 * 
 * @author ryabinin_av
 *
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
    
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.statushandlers.AbstractStatusHandler#handle(org.eclipse.ui.statushandlers.StatusAdapter,
     *      int)
     */
    @Override
    public void handle(final StatusAdapter statusAdapter, int style) {

        if (((style & StatusManager.SHOW) == StatusManager.SHOW)
                || ((style & StatusManager.BLOCK) == StatusManager.BLOCK)) {

            final boolean block = ((style & StatusManager.BLOCK) == StatusManager.BLOCK);
            
            if (Display.getCurrent() != null) {
                showStatusAdapter(statusAdapter, block);
            } else {
                if (block) {
                    Display.getDefault().syncExec(new Runnable() {
                        @Override
                        public void run() {
                            showStatusAdapter(statusAdapter, true);
                        }
                    });

                } else {
                    Display.getDefault().asyncExec(new Runnable() {
                        @Override
                        public void run() {
                            showStatusAdapter(statusAdapter, false);
                        }
                    });
                }
            }
        }

        if ((style & StatusManager.LOG) == StatusManager.LOG) {
            StatusManager.getManager().addLoggedStatus(
                    statusAdapter.getStatus());
            WorkbenchPlugin.getDefault().getLog()
                    .log(statusAdapter.getStatus());
        }
    }
    
    /**
     * Display the status adaptor - dialog with copyable stack trace as details
     * 
     * @param statusAdapter
     *            the status adapter to show
     * @param block
     *            Ignored. <code>true</code> to request a modal dialog and suspend the
     *            calling thread till the dialog is closed, <code>false</code>
     *            otherwise.
     */
    private void showStatusAdapter(StatusAdapter statusAdapter, boolean block) {
        Throwable t = statusAdapter.getStatus().getException();
        ExceptionNotifier.notify(t, statusAdapter.getStatus().getMessage(), getStatusDialogShell(), true, true);
    }

    /**
     * Returns singleton instance of StackTraceDialogStatusHandler
     * @return
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
     * 
     * @return
     */
    private Shell getStatusDialogShell() {
        return (Shell) getStatusDialogManager().getProperty(
                IStatusDialogConstants.SHELL);
    }
}
