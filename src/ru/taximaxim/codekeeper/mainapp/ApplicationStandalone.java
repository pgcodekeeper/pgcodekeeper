package ru.taximaxim.codekeeper.mainapp;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import cz.startnet.utils.pgdiff.Main;

/**
 * This class controls all aspects of the application's execution
 */
public class ApplicationStandalone implements IApplication {

    private static final String APGDIFF_TO_CONSOLE_MODE = "--apgdiff";
    private static final String EXECUTABLE_NAME = "pgcodekeeper-standalone";
    
    @Override
    public Object start(IApplicationContext context) throws Exception {
        String[] pgCommands = getApgdiffArguments();
        if (pgCommands != null) {
            callApgdiffMain(pgCommands);
        } else {
            System.err.println("Usage: " + 
                    EXECUTABLE_NAME + ' ' + APGDIFF_TO_CONSOLE_MODE +
                    " apgdiff_arguments");
        }
        return IApplication.EXIT_OK;
    }

    private void callApgdiffMain(String[] pgCommands) {
        try {
            Main.main(pgCommands);
        } catch (Exception e) {
            Status error = new Status(IStatus.ERROR, ApgdiffConsts.APGDIFF_PLUGIN_ID,
                    "Calling apgdiff error", e);
            Platform.getLog(Platform.getBundle(Activator.PLUGIN_ID)).log(error);
        }
    }

    /**
     * @return arrays of arguments that go after --apgdiff,
     *          or null if --apgdiff is not found in args
     */
    private String[] getApgdiffArguments() {
        String[] args = Platform.getApplicationArgs();
        int arg = Arrays.asList(args).indexOf(APGDIFF_TO_CONSOLE_MODE);
        if (arg != -1) {
            return Arrays.copyOfRange(args, ++arg, args.length);
        }
        return null;
    }

    @Override
    public void stop() {
    }
}
