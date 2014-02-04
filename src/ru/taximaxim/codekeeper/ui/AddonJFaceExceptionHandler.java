 
package ru.taximaxim.codekeeper.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.window.Window.IExceptionHandler;

public class AddonJFaceExceptionHandler implements IExceptionHandler{
    
    private volatile Logger log = null;
    
	@PostConstruct
	private void postConstruct(Logger log) {
	    this.log = log;
	    Window.setExceptionHandler(this);
	}
	
	@PreDestroy
	private void preDestroy() {
	    this.log = null;
	}
	
	@Override
	public void handleException(Throwable t) {
	    if(t instanceof Error) {
	        throw (Error) t; // do not handle Errors
	    }
	    
	    if(this.log != null) {
	        this.log.error(t);
	    } else {
	        t.printStackTrace();
	    }
	}
}