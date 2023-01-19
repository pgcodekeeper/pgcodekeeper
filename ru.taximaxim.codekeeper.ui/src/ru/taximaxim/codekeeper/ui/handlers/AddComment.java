package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class AddComment extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        PgDbParser parser = PgDbParser
            .getParser(FileUtilsUi.getFileForLocation(editor.getCurrentReference()
                .getFilePath()));

        return null;
    }

    @Override
    public boolean isEnabled() {

        return false;
    }
}
