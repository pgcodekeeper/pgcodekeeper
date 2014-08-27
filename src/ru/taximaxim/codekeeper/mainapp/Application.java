package ru.taximaxim.codekeeper.mainapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.UIConsts;
import cz.startnet.utils.pgdiff.Main;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

    boolean runMainClass = false;
    final static String APGDIFF_TO_CONSOLE_MODE = "--console";
    
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
	    Display display = PlatformUI.createDisplay();
        try {
            int returnCode = PlatformUI.RETURN_OK;
            List<String> pgCommands = getApgdiffarguments();
            
            if (!pgCommands.isEmpty()) {
                callApgdiffMain(pgCommands);
            } else {
                returnCode = PlatformUI.createAndRunWorkbench(display,
                        new ApplicationWorkbenchAdvisor());
            }

            if (returnCode == PlatformUI.RETURN_RESTART)
                return IApplication.EXIT_RESTART;
            else
                return IApplication.EXIT_OK;
        } finally {
            display.dispose();
        }

	}

    private void callApgdiffMain(List<String> pgCommands) {
        try {
            Main.main(pgCommands.toArray(new String[pgCommands.size()]));
        } catch (Exception e) {
            Status error = new Status(IStatus.ERROR, UIConsts.PLUGIN_ID.APGDIFF,
                    "Calling apgdiff error", e);
            Platform.getLog(Platform.getBundle(UIConsts.PLUGIN_ID.MAINAPP)).log(
                    error);
            System.out.println(error);
        }
    }

    private List<String> getApgdiffarguments() {
        List<String> args = Arrays.asList(Platform.getApplicationArgs());
        List<String> pgCommands = new ArrayList<>();
        int i;
        if ((i = args.indexOf(APGDIFF_TO_CONSOLE_MODE)) > -1) {
            for (i =  i + 1; i < args.size(); i++) {
                pgCommands.add(args.get(i));
            }
        }
        return pgCommands;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
