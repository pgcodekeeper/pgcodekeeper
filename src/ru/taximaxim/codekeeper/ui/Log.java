package ru.taximaxim.codekeeper.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Log {

    public static final int LOG_ERROR = IStatus.ERROR;
    public static final int LOG_WARNING = IStatus.WARNING;
    public static final int LOG_INFO = IStatus.INFO;
    public static final int LOG_DEBUG = IStatus.OK;

    public static void log(int level, String msg) {
        logInternal(level, msg, null);
    }

    /**
     * Log an exception at {@link IStatus#ERROR} level.
     */
    public static void log(Throwable ex) {
        logInternal(IStatus.ERROR, "Unexpected Exception", ex); //$NON-NLS-1$
    }

    public static void log(int level, String msg, Throwable ex) {
        logInternal(level, msg, ex);
    }

    private static void logInternal(int severity, String message,
            Throwable exception) {
        logToPlugin(new Status(severity, UIConsts.PLUGIN_ID.THIS, message,
                exception));
    }

    private static void logToPlugin(IStatus status) {
        Activator.getDefault().getLog().log(status);
    }
}
