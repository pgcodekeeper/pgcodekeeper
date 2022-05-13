package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class OpenSQLEditor extends AbstractHandler {


    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
        openEditor(page);
        return null;
    }

    public static boolean openEditor(IWorkbenchPage page) {
        try {
            IDE.openEditor(page, SQLEditorInput.newTmpInput(), EDITOR.SQL);
            return true;
        } catch (PartInitException e) {
            ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
            return false;
        }
    }
}