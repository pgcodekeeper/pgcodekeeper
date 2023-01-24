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

        String comment = "";
        if (statement != null && statement.getComment() != null) {
            comment = statement.getComment();

        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event),
                Messages.AddCommentDialogTitle, Messages.AddCommentDialogMessage, comment, null);
        if (dialog.open() == Window.OK && statement != null) {
            comment = dialog.getValue();
            statement.setComment(comment);
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
        String commentStmt = "COMMENT ON " + statement.getStatementType().toString() +
                " " + statement.getQualifiedName() + " IS \"('([^']*)')\"";

        if (editor.getEditorText().contains(commentStmt)) {

            file.setContents(new ByteArrayInputStream(
                    changeComment(editor.getEditorText(), commentStmt, comment)
                        .getBytes(Charset.forName(file.getCharset()))),
                    true, false, null);
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
                    Charset.forName(file.getCharset()))), true, false, null);
        }
        openFileInEditor(file);
    }

    private String changeComment(String initialText, String oldCommentStmt, String comment, String regex) {
        int lineNumber;
        String newCommentStmt;
        try (Scanner scanner = new Scanner(initialText)) {
            Pattern pattern = Pattern.compile(oldCommentStmt);
            Matcher matcher = pattern.matcher(regex);
            for (String line : initialText.split(System.lineSeparator())) {
                if (matcher.matches()) {

                }
            }
        }
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

}
