/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.pgcodekeeper.core.api.PgCodeKeeperApi;
import org.pgcodekeeper.core.database.api.IDatabaseProvider;
import org.pgcodekeeper.core.database.api.loader.IDumpLoader;
import org.pgcodekeeper.core.database.api.schema.IDatabase;
import org.pgcodekeeper.core.database.api.schema.IStatement;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.database.pg.utils.PgDiffUtils;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.settings.DiffSettings;
import org.pgcodekeeper.core.utils.Utils;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.StubDatabaseLoader;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.utils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class AddComment extends AbstractHandler {

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
        ObjectLocation location = editor.getCurrentReference();
        IFile file = FileUtilsUi.getFileForLocation(location);
        if ((file == null) || !IDE.saveAllEditors(new IResource[] { file.getProject() }, true)) {
            return;
        }

        IDumpLoader fileLoader = ProjectUtils.getDatabaseType(file.getProject()).getDatabaseProvider().getDumpLoader(
                file.getLocation().toFile().toPath(), new DiffSettings(new UISettings(file.getProject(), null)));
        IDatabase oldDb = fileLoader.loadAndAnalyze();
        IDatabase newDb = (IDatabase) oldDb.deepCopy();

        IStatement statement = newDb.getStatement(location.getObjectReference());
        if (statement == null) {
            return;
        }
        // for statements from other files
        file = FileUtilsUi.getFileForLocation(statement.getLocation());

        String oldComment = statement.getComment();
        if (oldComment != null) {
            oldComment = PgDiffUtils.unquoteQuotedString(oldComment, 1);
        }

        InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event), Messages.AddCommentDialogTitle,
                Messages.AddCommentDialogMessage, oldComment, null);

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
            statement.setComment(Utils.quoteString(newComment));
        } else {
            return;
        }

        var oldDbSource = new StubDatabaseLoader(oldDb, "old"); //$NON-NLS-1$
        var newDbSource = new StubDatabaseLoader(newDb, "new"); //$NON-NLS-1$

        var project = file.getProject();
        IDatabaseProvider provider = ProjectUtils.getDatabaseType(project).getDatabaseProvider();
        DiffSettings diffSettings = new DiffSettings(new UISettings(project, null));
        TreeElement el = PgCodeKeeperApi.createTree(newDbSource, oldDbSource, diffSettings).findElement(statement);

        PgDbProject proj = new PgDbProject(project);
        var updaterSettings = new UISettings(project, null);
        provider.getProjectUpdater(newDb, oldDb, List.of(el), proj.getPathToProject(), false, updaterSettings)
                .updatePartial();
        file.refreshLocal(IResource.DEPTH_INFINITE, null);
        openFileInEditor(file);
    }

    @Override
    public boolean isEnabled() {
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (part instanceof SQLEditor editor) {
            if (!ProjectUtils.isInProject(editor.getEditorInput())) {
                return false;
            }

            ObjectLocation location = editor.getCurrentReference();
            if (location == null) {
                return false;
            }

            IFile file = FileUtilsUi.getFileForLocation(location);
            return ProjectUtils.getDatabaseType(file.getProject()) == DatabaseType.PG;
        }

        return false;
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }
}
