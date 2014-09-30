package ru.taximaxim.codekeeper.ui.parts;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ConsoleFactory implements IConsoleFactory {

    private static MessageConsoleStream outer;
    
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
            throw new IllegalStateException("Cannot activate a console", e);
        }
    }

    public static void write(String msg) {
        if (outer == null) {
            findConsole();
        }
        outer.println(msg);
    }
    
    private static MessageConsole findConsole() {
        String name = "PgCodekeeper console";
        MessageConsole myConsole = null;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++) {
            if (name.equals(existing[i].getName())) {
                myConsole = (MessageConsole) existing[i];
            }
        }
        if (myConsole == null) {
            myConsole = new MessageConsole(name, null);
        }
        conMan.addConsoles(new IConsole[] { myConsole });
        outer = myConsole.newMessageStream();
        return myConsole;
     }
}
