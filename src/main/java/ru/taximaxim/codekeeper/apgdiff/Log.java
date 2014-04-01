package ru.taximaxim.codekeeper.apgdiff;

import org.eclipse.equinox.log.ExtendedLogService;
import org.eclipse.equinox.log.Logger;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Log {

    private static final String EQUINOX_LOGGER = "org.eclipse.equinox.logger";
    
    public static final int LOG_ERROR = LogService.LOG_ERROR;
    public static final int LOG_WARNING = LogService.LOG_WARNING;
    public static final int LOG_INFO = LogService.LOG_INFO;
    public static final int LOG_DEBUG = LogService.LOG_DEBUG;
    
    public static void log(int level, String msg) {
        logInternal(level, msg, null);
    }
    
    /**
     * Log an exception at ERROR level.
     */
    public static void log(Throwable ex) {
        logInternal(LOG_ERROR, null, ex);
    }
    
    public static void log(int level, String msg, Throwable ex) {
        logInternal(level, msg, ex);
    }
    
    private static void logInternal(int level, String msg, Throwable ex) {
        boolean failedToGetLog = false;
        try {
            ServiceTracker<ExtendedLogService, ExtendedLogService> logTracker 
                    = Activator.getLogTracker();
            if (logTracker == null) {
                failedToGetLog = true;
                throw new NullPointerException();
            }
            
            ExtendedLogService logService = logTracker.getService();
            if (logService == null) {
                failedToGetLog = true;
                throw new NullPointerException();
            }
            
            Logger logger = logService.getLogger(EQUINOX_LOGGER);
            if (logger == null) {
                failedToGetLog = true;
                throw new NullPointerException();
            }
            logger.log(level, msg, ex);
        } catch (Exception exLog) {
            if (failedToGetLog) {
                System.out.println("LogService not found! Logging to stdout.");
            } else {
                System.out.println("ERROR while trying to log!");
                exLog.printStackTrace();
            }
            
            System.out.println("Attempted to log:");
            System.out.println("Message: " + msg);
            System.out.println("Exception: ");
            if (ex != null) {
                ex.printStackTrace();
            }
        }
    }
}
