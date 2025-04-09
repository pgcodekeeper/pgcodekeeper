/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.settings.ISettings;
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

    private final ISettings settings;

    public AddComment(ISettings settings) {
        super();
        this.settings = settings;
    }

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

        AbstractDatabase oldDb = UIProjectLoader.buildFiles(List.of(file), DatabaseType.PG, null);
        AbstractDatabase newDb = (AbstractDatabase) oldDb.deepCopy();

        PgStatement statement = newDb.getStatement(location.getObj());
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

        TreeDiffer treeDiffer = new TreeDiffer(newDbSource, oldDbSource, settings);
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
        if (part instanceof SQLEditor editor) {
            if (!UIProjectLoader.isInProject(editor.getEditorInput())) {
                return false;
            }

            PgObjLocation location = editor.getCurrentReference();
            if (location == null) {
                return false;
            }

            IFile file = FileUtilsUi.getFileForLocation(location);
            return OpenProjectUtils.getDatabaseType(file.getProject()) == DatabaseType.PG;
        }

        return false;
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }
}
