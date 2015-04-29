package ru.taximaxim.codekeeper.ui.consoles;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;

import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ConsoleFactory implements IConsoleFactory {
    
    private static CodekeeperConsole console;
    
    @Override
    public void openConsole() {
        IConsole myConsole = findConsole();
        IWorkbenchPage page = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage();
        String id = IConsoleConstants.ID_CONSOLE_VIEW;
        IConsoleView view;
        try {
            view = (IConsoleView) page.showView(id);
            view.display(myConsole);
        } catch (PartInitException e) {
            ExceptionNotifier.notifyDefault(Messages.ConsoleFactory_error_opening_console, e);
        }
    }

    public static void write(String msg) {
        if (PlatformUI.isWorkbenchRunning()) {
            if (console == null) {
                console = findConsole();
            }
            console.write(msg);
        }
    }
    
    private static CodekeeperConsole findConsole() {
        CodekeeperConsole myConsole = null;
        IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
        for (IConsole c : conMan.getConsoles()) {
            if (c instanceof CodekeeperConsole) {
                myConsole = (CodekeeperConsole) c;
            }
        }
        if (myConsole == null) {
            myConsole = new CodekeeperConsole();
        }
        conMan.addConsoles(new IConsole[] { myConsole });
        return myConsole;
     }
}
