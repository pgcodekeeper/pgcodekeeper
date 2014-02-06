package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.services.log.Logger;

public class Log {
    
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
