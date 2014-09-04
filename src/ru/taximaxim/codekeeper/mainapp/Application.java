package ru.taximaxim.codekeeper.mainapp;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import cz.startnet.utils.pgdiff.Main;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

    private static final String APGDIFF_TO_CONSOLE_MODE = "--apgdiff";
    
    /* (non-Javadoc)
     * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
     */
    @Override
    public Object start(IApplicationContext context) throws Exception {
        String[] pgCommands = getApgdiffArguments();
        if (pgCommands.length != 0) {
            callApgdiffMain(pgCommands);
            return IApplication.EXIT_OK;
        }
        
        Display display = PlatformUI.createDisplay();
        try {
            int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());

            if (returnCode == PlatformUI.RETURN_RESTART)
                return IApplication.EXIT_RESTART;
            else
                return IApplication.EXIT_OK;
        } finally {
            display.dispose();
        }

    }

    private void callApgdiffMain(String[] pgCommands) {
        try {
            Main.main(pgCommands);
        } catch (Exception e) {
            Status error = new Status(IStatus.ERROR, ApgdiffConsts.APGDIFF_PLUGIN_ID,
                    "Calling apgdiff error", e);
            Platform.getLog(Platform.getBundle(Activator.PLUGIN_ID)).log(
                    error);
        }
    }

    private String[] getApgdiffArguments() {
        String[] args = Platform.getApplicationArgs();
        int arg = Arrays.asList(args).indexOf(APGDIFF_TO_CONSOLE_MODE);
        if (arg != -1) {
            return Arrays.copyOfRange(args, ++arg, args.length);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.equinox.app.IApplication#stop()
     */
    @Override
    public void stop() {
        if (!PlatformUI.isWorkbenchRunning())
            return;
        final IWorkbench workbench = PlatformUI.getWorkbench();
        final Display display = workbench.getDisplay();
        display.syncExec(new Runnable() {
            @Override
            public void run() {
                if (!display.isDisposed())
                    workbench.close();
            }
        });
    }
}
