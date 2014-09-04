package ru.taximaxim.codekeeper.mainapp;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.eclipse.ui.statushandlers.StatusManager;

import ru.taximaxim.codekeeper.ui.StackTraceDialogStatusHandler;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    @Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	@Override
    public String getInitialWindowPerspectiveId() {
		return UIConsts.PERSP.MAIN;
	}
	
	@Override
	public synchronized AbstractStatusHandler getWorkbenchErrorHandler() {
	    return StackTraceDialogStatusHandler.get();
	}
	
    @Override
    public void eventLoopException(Throwable exception) {
        // Protection from client doing super(null) call
        if (exception == null) {
            return;
        }

        try {
            StatusManager.getManager().handle(
                    new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                            "Unhandled event loop exception", exception),
                    StatusManager.BLOCK);

            if (WorkbenchPlugin.DEBUG) {
                exception.printStackTrace();
            }
        } catch (Throwable e) {
            // One of the log listeners probably failed. Core should have logged
            // the
            // exception since its the first listener.
            System.err.println("Error while logging event loop exception:");
            exception.printStackTrace();
            System.err.println("Logging exception:");
            e.printStackTrace();
        }
    }
}
