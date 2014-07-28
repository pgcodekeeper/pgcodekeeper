package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.parts.Console;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class TestPopup3xHandler extends E4HandlerWrapper {

    @Inject
    private IEclipseContext _ctx;
    
    @Execute
    private void execute(
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            IEclipseContext ctx) {
        Console.addMessage(_ctx.toString());
        Console.addMessage(ctx.toString());
        Console.addMessage(shell.toString());
    }
    
    @CanExecute
    private boolean canExecute(IEclipseContext ctx, PgDbProject proj) {
        Console.addMessage(_ctx.toString());
        Console.addMessage(ctx.toString());
        Console.addMessage(proj.toString());
        return proj != null;
    }
}
