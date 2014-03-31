 
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class CloseActiveProj {
    
    @Execute
    private void execute(IEclipseContext ctx) {
        close(ctx);
    }
    
    @CanExecute
    private boolean canExecute(PgDbProject proj) {
        return proj != null;
    }
    
    public static void close(IEclipseContext ctx) {
        ctx.modify(PgDbProject.class, null);
    }
}