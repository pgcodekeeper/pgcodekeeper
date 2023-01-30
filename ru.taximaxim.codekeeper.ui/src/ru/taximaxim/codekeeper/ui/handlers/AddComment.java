package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Log;
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
        } catch (InvocationTargetException | InterruptedException | CoreException | IOException e) {
            Log.log(Log.LOG_ERROR, e.getMessage(), e);
        }

        return null;
    }

    private void addComment(ExecutionEvent event)
            throws InvocationTargetException, InterruptedException, CoreException, IOException {
        SQLEditor editor = (SQLEditor) HandlerUtil.getActiveEditor(event);
        PgObjLocation location = editor.getCurrentReference();
        IFile file = FileUtilsUi.getFileForLocation(location);
        PgDbProject proj = new PgDbProject(file.getProject());
        boolean isMsSql = OpenProjectUtils.checkMsSql(file.getProject());

        PgDatabase dbProjectFragment;
        dbProjectFragment = UIProjectLoader
            .buildFiles(Arrays.asList(file), isMsSql, null);

        PgDatabase bufferDb = (PgDatabase) dbProjectFragment.deepCopy();

        PgStatement statement = location.getObj().getStatement(bufferDb);
        if (statement == null) {
            return;
        }

        String oldComment = statement.getComment();
        if (oldComment != null) {
            oldComment = isMsSql ? MsDiffUtils.unquoteQuotedName(oldComment)
                    : PgDiffUtils.unquoteQuotedString(oldComment, 1);
        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event),
                Messages.AddCommentDialogTitle, Messages.AddCommentDialogMessage, oldComment, null);

        if (dialog.open() != Window.OK) {
            return;
        }

        String newComment = dialog.getValue();
        if (newComment.isBlank()) {
            statement.setComment(null);
        } else if (!newComment.equals(oldComment)) {
            statement.setComment(isMsSql ? MsDiffUtils.quoteName(newComment) : PgDiffUtils.quoteString(newComment));
        } else {
            return;
        }

        DbSource dbOld = DbSource.fromProject(new PgDbProject(file.getProject()));
        DbSource dbNew = DbSource.fromDbObject(bufferDb, null);

        TreeDiffer treeDiffer = new TreeDiffer(dbNew, dbOld);
        treeDiffer.run(new NullProgressMonitor());
        TreeElement treeFull = treeDiffer.getDiffTree();
        TreeElement el = treeFull.findElement(statement);

        ProjectUpdater updater = new UIProjectUpdater(dbNew.getDbObject(), dbOld.getDbObject(), List.of(el),
                proj, false);
        updater.updatePartial();
        file.refreshLocal(IResource.DEPTH_INFINITE, null);
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
