package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.e4.core.commands.ExpressionContext;
import org.eclipse.e4.core.commands.internal.SetEnabled;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.ui.PlatformUI;

/**
 * This class wraps e4 handlers into a eclipse 3.x handler.<br>
 * Clients can subclass e4 handlers from this class and use them in eclipse 3.x API.<br><br>
 * 
 * Internally an object of this class has an instance of itself created using DI and WorkbenchContext.
 * All 3.x handler calls are redirected into client's DI-annotated methods in that instance,
 * thus client e4 code is executed.<br><br>
 * 
 * Logic here is a simplified version of {@link #HandlerServiceHandler}.
 * 
 * @author Alexander Levsha
 */
@SuppressWarnings("restriction")
public abstract class E4HandlerWrapper extends AbstractHandler {
    
    private E4HandlerWrapper diInstance;
    
    private E4HandlerWrapper getDIHandler() {
        if (diInstance == null) {
            // this.getClass() returns not E4HandlerWrapper.class
            // but the actual derived class (due to method override)
            diInstance = ContextInjectionFactory.make(this.getClass(), getWorkbenchE4Context());
        }
        return diInstance;
    }
    
    private IEclipseContext getWorkbenchE4Context() {
        return (IEclipseContext) PlatformUI.getWorkbench().getService(IEclipseContext.class);
    }
    
    private IEclipseContext getExecutionContext(Object evalObj) {
        if (evalObj instanceof IEclipseContext) {
            return (IEclipseContext) evalObj;
        }
        if (evalObj instanceof ExpressionContext) {
            return ((ExpressionContext) evalObj).eclipseContext;
        }
        if (evalObj instanceof IEvaluationContext) {
            return getExecutionContext(((IEvaluationContext) evalObj).getParent());
        }
        return getWorkbenchE4Context().getActiveLeaf();
    }

    @Override
    public final Object execute(ExecutionEvent event) throws ExecutionException {
        ContextInjectionFactory.invoke(getDIHandler(), Execute.class,
                getExecutionContext(event.getApplicationContext()));
        return null;
    }
    
    @Override
    public final boolean isEnabled() {
        Boolean result = (Boolean) ContextInjectionFactory.invoke(
                getDIHandler(), CanExecute.class, getExecutionContext(null));
        boolean enabled = result == null ? false : result;
        
        setBaseEnabled(enabled);
        return enabled;
    }
    
    @Override
    public final void setEnabled(Object evaluationContext) {
        ContextInjectionFactory.invoke(getDIHandler(), SetEnabled.class,
                getExecutionContext(evaluationContext), null);
    }
}
