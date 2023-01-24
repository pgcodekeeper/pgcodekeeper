package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaStatement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class AddComment extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        PgObjLocation location = editor.getCurrentReference();
        IFile file = FileUtilsUi.getFileForLocation(location);
        PgDbParser parser = PgDbParser.getParser(file);
        MetaStatement statement = parser.getDefinitionsForObj(location).findFirst().orElse(null);

        String comment = new String();
        if (statement != null) {
            comment = statement.getComment();
            if (comment == null) {
                comment = "";
            }
        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event),
                Messages.AddCommentDialogTitle, Messages.AddCommentDialogMessage, comment, null);
        if (dialog.open() == Window.OK && statement != null) {
            comment = dialog.getValue();
        }
        try {
            createComment(editor, file, comment, statement);
        } catch (CoreException e) {
            Log.log(Log.LOG_ERROR, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof SQLEditor;
    }

    private void createComment(SQLEditor editor, IFile file, String comment, MetaStatement statement)
            throws CoreException {
        String ls = System.lineSeparator();
        String lineRegex = "COMMENT ON " + statement.getStatementType().toString() + " " + statement.getQualifiedName();
        if (editor.getEditorText().contains(lineRegex)) {
            Scanner scanner = new Scanner(editor.getEditorText());
            String commentRegex = "('([^']*)')";
            Pattern pattern = Pattern.compile(commentRegex);
            Matcher matcher = pattern.matcher(editor.getEditorText());
            // while (scanner.)) { Обнаружил проблему с заменой существующих комментов, ищу способ исправления
            // scanner.
            // }
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                String newEditorText = editor.getEditorText().replace(matcher.group(), comment);
                sb.append(newEditorText);
                file.setContents(new ByteArrayInputStream(sb.toString().getBytes(
                        Charset.forName(file.getCharset()))), false, false, null);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(editor.getEditorText().strip())
                .append(ls)
                .append("COMMENT ON ")
                .append(statement.getStatementType().toString())
                .append(" ")
                .append(statement.getQualifiedName())
                .append(" IS ")
                .append("'" + comment + "';");
            file.setContents(new ByteArrayInputStream(sb.toString().getBytes(
                    Charset.forName(file.getCharset()))), false, false, null);
        }
        openFileInEditor(file);
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

}
