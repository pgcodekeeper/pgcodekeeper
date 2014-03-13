 
package ru.taximaxim.codekeeper.ui;

import javax.annotation.PostConstruct;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.window.Window.IExceptionHandler;

public class AddonJFaceExceptionHandler implements IExceptionHandler{
    
    @PostConstruct
    private void postConstruct() {
        Window.setExceptionHandler(this);
    }
    
    @Override
    public void handleException(Throwable t) {
        if(t instanceof Error) {
            throw (Error) t; // do not handle Errors
        }
        Log.getLog().error(t); // TODO finally { t.printStackTrace(); } ?
    }
}