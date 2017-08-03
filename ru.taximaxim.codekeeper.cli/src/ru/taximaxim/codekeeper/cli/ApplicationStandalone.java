package ru.taximaxim.codekeeper.cli;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

/**
 * This class controls all aspects of the application's execution
 */
public class ApplicationStandalone implements IApplication {

    private static final int EXIT_ERROR = 1;

    @Override
    public Object start(IApplicationContext context) {
        try {
            return Main.main(Platform.getApplicationArgs()) ? EXIT_OK : EXIT_ERROR;
        }   catch (Exception e) {
            e.printStackTrace(System.err);
            Status error = new Status(IStatus.ERROR, ApgdiffConsts.APGDIFF_PLUGIN_ID,
                    "pgCodeKeeper error", e);
            Platform.getLog(Activator.getContext().getBundle()).log(error);
            return EXIT_ERROR;
        } finally {
            // only needed when org.apache.felix.gogo.shell bundle is present
            /*try {
                // see bug #514338
                Thread.sleep(110);
            } catch (InterruptedException ex) {
                // no action
            }*/
        }
    }

    @Override
    public void stop() {
        // no impl
    }
}
