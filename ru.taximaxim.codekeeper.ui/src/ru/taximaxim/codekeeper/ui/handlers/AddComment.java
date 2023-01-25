package ru.taximaxim.codekeeper.ui.handlers;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
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

    private String oldComment;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        PgObjLocation location = null;
        if (editor.getCurrentReference() == null) {
            MessageDialog msg = new MessageDialog(HandlerUtil.getActiveShell(event),
                    Messages.AddCommentSelectionErrorDialogTitle, null,
                    Messages.AddCommentSelectionErrorDialogMessage, 0, 0);
            msg.open();
            return null;
        } else {
            location = editor.getCurrentReference();
        }
        IFile file = FileUtilsUi.getFileForLocation(location);
        PgDbParser parser = PgDbParser.getParser(file);
        MetaStatement statement = parser.getDefinitionsForObj(location).findFirst().orElse(null);

        String comment = "";
        if (statement != null && statement.getComment() != null) {
            oldComment = statement.getComment();
        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event),
                Messages.AddCommentDialogTitle, Messages.AddCommentDialogMessage, oldComment, null);
        if (dialog.open() == Window.OK && statement != null) {
            comment = dialog.getValue();
            try {
                createComment(editor, file, comment, statement);
            } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, e.getMessage(), e);
            }
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
        String commentStmt = "COMMENT ON " + statement.getStatementType().toString() +
                " " + statement.getQualifiedName() + " IS " + oldComment;
        if (editor.getEditorText().contains(commentStmt)) {
            String newComment = changeComment(editor.getEditorText(), commentStmt, comment);
            file.setContents(new ByteArrayInputStream(
                    newComment.getBytes(Charset.forName(file.getCharset()))),
                    true, false, null);
        } else {
            String addCommentStmt = addComment(editor, statement, comment);
            file.setContents(new ByteArrayInputStream(addCommentStmt.getBytes(
                    Charset.forName(file.getCharset()))), true, false, null);
        }
        openFileInEditor(file);
    }

    private String changeComment(String initialText, String oldCommentStmt, String comment) {
        if (initialText.contains(oldCommentStmt)) {
            String newCommentStmt = oldCommentStmt.replace(oldComment, "'" + comment + "'");
            return initialText.replace(oldCommentStmt, newCommentStmt);
        }
        return initialText;
    }

    private String addComment(SQLEditor editor, MetaStatement statement, String comment) {
        StringBuilder sb = new StringBuilder();
        String ls = System.lineSeparator();
        return sb.append(editor.getEditorText().strip())
            .append(ls)
            .append("COMMENT ON ")
            .append(statement.getStatementType().toString())
            .append(" ")
            .append(statement.getQualifiedName())
            .append(" IS ")
            .append("'" + comment + "';").toString();
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

}
