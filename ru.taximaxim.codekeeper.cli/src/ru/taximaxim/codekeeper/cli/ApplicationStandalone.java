package ru.taximaxim.codekeeper.cli;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * This class controls all aspects of the application's execution
 */
public class ApplicationStandalone implements IApplication {

    private static final int EXIT_ERROR = 1;

    @Override
    public Object start(IApplicationContext context) {
        return Main.main(Platform.getApplicationArgs()) ? EXIT_OK : EXIT_ERROR;
    }

    @Override
    public void stop() {
        // no impl
    }
}
