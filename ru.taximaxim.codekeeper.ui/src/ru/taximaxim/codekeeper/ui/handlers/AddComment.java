package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.differ.TreeDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.fileutils.UIProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class AddComment extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            addComment(event);
        } catch (Exception e) {
            Log.log(Log.LOG_ERROR, e.getMessage(), e);
        }

        return null;
    }

    private void addComment(ExecutionEvent event)
            throws InvocationTargetException, InterruptedException, CoreException, IOException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        PgObjLocation location = editor.getCurrentReference();
        IFile file = FileUtilsUi.getFileForLocation(location);
        if (file == null || !IDE.saveAllEditors(new IResource[] { file.getProject() }, true)) {
            return;
        }

        PgDatabase oldDb = UIProjectLoader.buildFiles(List.of(file), false, null);
        PgDatabase newDb = (PgDatabase) oldDb.deepCopy();

        PgStatement statement = location.getObj().getStatement(newDb);
        if (statement == null) {
            return;
        }
        // for statements from other files
        file = FileUtilsUi.getFileForLocation(statement.getLocation());

        String oldComment = statement.getComment();
        if (oldComment != null) {
            oldComment = PgDiffUtils.unquoteQuotedString(oldComment, 1);
        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event),
                Messages.AddCommentDialogTitle, Messages.AddCommentDialogMessage, oldComment, null);

        if (dialog.open() != Window.OK) {
            return;
        }

        String newComment = dialog.getValue();
        if (newComment.isBlank()) {
            if (oldComment == null) {
                return;
            }
            statement.setComment(null);
        } else if (!newComment.equals(oldComment)) {
            statement.setComment(PgDiffUtils.quoteString(newComment));
        } else {
            return;
        }

        DbSource oldDbSource = DbSource.fromDbObject(oldDb, "old");
        DbSource newDbSource = DbSource.fromDbObject(newDb, "new");

        TreeDiffer treeDiffer = new TreeDiffer(newDbSource, oldDbSource);
        treeDiffer.run(new NullProgressMonitor());
        TreeElement el = treeDiffer.getDiffTree().findElement(statement);

        PgDbProject proj = new PgDbProject(file.getProject());
        new UIProjectUpdater(newDb, oldDb, List.of(el), proj, false).updatePartial();
        file.refreshLocal(IResource.DEPTH_INFINITE, null);
        openFileInEditor(file);
    }

    @Override
    public boolean isEnabled() {
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (part instanceof SQLEditor) {
            SQLEditor editor = (SQLEditor) part;
            if (!UIProjectLoader.isInProject(editor.getEditorInput())) {
                return false;
            }

            PgObjLocation location = editor.getCurrentReference();
            if (location == null) {
                return false;
            }

            IFile file = FileUtilsUi.getFileForLocation(location);
            return !OpenProjectUtils.checkMsSql(file.getProject());
        }

        return false;
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }
}
