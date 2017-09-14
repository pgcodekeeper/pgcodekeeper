package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.FileStoreEditorInput;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ImprovePerformanceJdbcLoader extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            Path p = Files.createTempFile(Messages.ImprovePerformanceJdbcLoader_performance_helpers + '_', ".sql"); //$NON-NLS-1$
            Files.write(p, JdbcQueries.QUERY_IMPROVE_JDBC_PERFORMANCE.getBytes());
            HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(
                    new FileStoreEditorInput(EFS.getLocalFileSystem().fromLocalFile(p.toFile())), EDITOR.SQL);
        } catch (PartInitException | IOException e) {
            throw new ExecutionException(e.getLocalizedMessage(), e);
        }
        return null;
    }
}
