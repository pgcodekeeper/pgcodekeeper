package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.services.log.Logger;
import org.osgi.service.log.LogService;

public class Log {
    
    private LogService s;
    private static Logger log = null;
    
    public static Logger getLog() {
        return log;
    }
    
    public static void setLog(Logger log) {
        if(Log.log == null) {
            Log.log = log;
        }
    }
}
