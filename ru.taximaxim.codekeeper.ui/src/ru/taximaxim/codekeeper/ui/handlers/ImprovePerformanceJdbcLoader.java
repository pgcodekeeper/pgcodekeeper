package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.sqledit.StringEditorInput;

public class ImprovePerformanceJdbcLoader extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(
                    new StringEditorInput(JdbcQueries.QUERY_IMPROVE_JDBC_PERFORMANCE,
                            "pgCodeKeeper Performance Helpers"), EDITOR.ROLLON);
        } catch (PartInitException e) {
            throw new ExecutionException(e.getLocalizedMessage(), e);
        }
        return null;
    }
}
