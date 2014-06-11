package ru.taximaxim.codekeeper.mainapp;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.StartupThreading;
import org.eclipse.ui.internal.StartupThreading.StartupRunnable;
import org.eclipse.ui.internal.UISynchronizer;

@SuppressWarnings("restriction")
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return null;
	}
	
	@Override
    @SuppressWarnings("unchecked")
	public boolean openWindows() {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		final AtomicBoolean result = new AtomicBoolean();
		
		// spawn another init thread.  For API compatibility We guarantee this method is called from 
		// the UI thread but it could take enough time to disrupt progress reporting.
		// spawn a new thread to do the grunt work of this initialization and spin the event loop 
		// ourselves just like it's done in Workbench.
		final AtomicBoolean initDone = new AtomicBoolean();
		final AtomicReference<Throwable> error = new AtomicReference<>();
		Thread initThread = new Thread() {
			
            public void run() {
				try {
					//declare us to be a startup thread so that our syncs will be executed 
					UISynchronizer.startupThread.set(Boolean.TRUE);
					final AtomicReference<IWorkbenchConfigurer> myConfigurer = 
					        new AtomicReference<>();
					StartupThreading.runWithoutExceptions(new StartupRunnable() {
	
						public void runWithException() throws Throwable {
							myConfigurer.set(getWorkbenchConfigurer());
						}});
					
					IStatus status = myConfigurer.get().restoreState();
					if (!status.isOK()) {
						if (status.getCode() == IWorkbenchConfigurer.RESTORE_CODE_EXIT) {
							result.set(false);
							return;
						}
						if (status.getCode() == IWorkbenchConfigurer.RESTORE_CODE_RESET) {
							myConfigurer.get().openFirstTimeWindow();
						}
					}
					result.set(true);
				} catch (Throwable e) {
					error.set(e);
				}
				finally {
					initDone.set(true);
					// FIXME this whole method was copypasted to get this fix; remove this method when the fix becomes available in eclipse master branch
					// this fix prevents startup blocking caused by the display thread not waking
					// eclipse bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=429363
				//	yield();
					display.wake();
				}
			}};
			initThread.start();

			while (true) {
				// FIXME this must be a less hack-ish fix than yield() in the other thread
				if (initDone.get())
					break;
				
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			
			// can only be a runtime or error
			if (error.get() instanceof Error)
				throw (Error)error.get();
			else if (error.get() instanceof RuntimeException)
				throw (RuntimeException)error.get();
		
			return result.get();
	}
}
