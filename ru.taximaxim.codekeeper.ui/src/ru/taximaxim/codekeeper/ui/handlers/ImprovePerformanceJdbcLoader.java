package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;

public class ImprovePerformanceJdbcLoader extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IEditorInput input;
        try {
            input = new FileStoreEditorInput(EFS.getLocalFileSystem().fromLocalFile(
                    ApgdiffUtils.getFileFromOsgiRes(JdbcQueries.class.getResource(
                            "QUERY_IMPROVE_JDBC_PERFORMANCE.sql"))));
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .openEditor(input, EDITOR.ROLLON);
        } catch (URISyntaxException | IOException | PartInitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
