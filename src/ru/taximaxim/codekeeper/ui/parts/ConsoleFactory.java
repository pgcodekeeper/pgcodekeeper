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

import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;

public class ConsoleFactory implements IConsoleFactory {

    private static final String NAME = "pgCodeKeeper";
    
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
            ExceptionNotifier.showErrorDialog("Cannot activate a console", e);
        }
    }

    public static void write(String msg) {
        if (PlatformUI.isWorkbenchRunning()) {
            if (outer == null) {
                findConsole();
            }
            outer.println(msg);
        }
    }
    
    private static MessageConsole findConsole() {
        MessageConsole myConsole = null;
        IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
        for (IConsole c : conMan.getConsoles()) {
            if (NAME.equals(c.getName()) && (c instanceof MessageConsole)) {
                myConsole = (MessageConsole) c;
            }
        }
        if (myConsole == null) {
            myConsole = new MessageConsole(NAME, null);
        }
        conMan.addConsoles(new IConsole[] { myConsole });
        outer = myConsole.newMessageStream();
        return myConsole;
     }
}
