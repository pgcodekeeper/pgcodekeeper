package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class OpenSQLEditor extends AbstractHandler {

    private static int number = 1;

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
        openEditor(page);
        return null;
    }

    public static boolean openEditor(IWorkbenchPage page) {
        IFileStore externalFile = EFS.getNullFileSystem()
                .getStore(new Path("/pgCodeKeeper/new query " + number++)); //$NON-NLS-1$
        IEditorInput input = new SQLEditorInput(externalFile, false);
        try {
            IDE.openEditor(page, input, EDITOR.SQL);
            return true;
        } catch (PartInitException e) {
            ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            return false;
        }
    }
}