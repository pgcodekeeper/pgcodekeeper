package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;



/*
 * make this a 'non-static-singleton'
 * 
 * each instance contains another that's made w/ DI
 * DI calls are redirected into that instance
 * 
 * needed for field injection to work
 */



public class E4HandlerWrapper extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
       // ContextInjectionFactory.invoke(object, qualifier, context)
        return null;
    }
}
