package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.refactoring.PgRefactory;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class RenameReference extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);

        PgRefactory.getInstance().rename(
                HandlerUtil.getActiveShell(event), editor.getCurrentReference());

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (part instanceof SQLEditor) {
            SQLEditor editor = (SQLEditor) part;
            return UIProjectLoader.isInProject(editor.getEditorInput())
                    && editor.getCurrentReference() != null;
        }

        return false;
    }
}
