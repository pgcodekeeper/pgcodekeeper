 
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class CloseActiveProj extends E4HandlerWrapper {
    
    @Execute
    private void execute(IEclipseContext ctx) {
        close(ctx);
    }
    
    @CanExecute
    private boolean canExecute(PgDbProject proj) {
        return proj != null;
    }
    
    public static void close(IEclipseContext ctx) {
        PgDbProject projClosed = ctx.get(PgDbProject.class);
        Log.log(Log.LOG_INFO, "Project about to close: " + projClosed.getProjectName()); //$NON-NLS-1$
        
        ctx.modify(PgDbProject.class, null);
    }
}