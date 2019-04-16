package ru.taximaxim.codekeeper.ui.consoles;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

import cz.startnet.utils.pgdiff.IProgressReporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.VIEW;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.views.ResultSetView;

public class UiProgressReporter implements IProgressReporter {

    private final CodekeeperConsole console;

    public UiProgressReporter(IProgressMonitor monitor) {
        IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
        console = CodekeeperConsole.createInstance(monitor);
        manager.addConsoles(new IConsole[] { console });
    }

    /**
     * Initial, write one error message and terminate console
     */
    public static void writeSingleError(String error) {
        try (UiProgressReporter reporter = new UiProgressReporter(new NullProgressMonitor())) {
            reporter.writeError(error);
        }
    }

    @Override
    public void writeMessage(String message) {
        console.write(message);
    }

    @Override
    public void writeWarning(String message) {
        console.writeWarning(Messages.UiProgressReporter_warning + message);
    }

    @Override
    public void writeError(String message) {
        console.writeError(message);
    }

    @Override
    public void terminate() {
        console.terminate();
    }

    @Override
    public void showData(String query, List<List<Object>> results) {
        UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            try {
                ResultSetView viewPart = (ResultSetView) page.showView(VIEW.RESULT_SET_VIEW);
                viewPart.addData(query, results);
            } catch (PartInitException e) {
                Log.log(e);
            }
        });

    }
}
