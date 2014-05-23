 
package ru.taximaxim.codekeeper.ui.addons;

import javax.annotation.PostConstruct;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.window.Window.IExceptionHandler;

import ru.taximaxim.codekeeper.ui.Log;

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
        Log.log(t);
    }
}