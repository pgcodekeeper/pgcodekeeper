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
package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.ContextLocation;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public final class FileUtilsUi {

    /**
     * Saves the content as a temp-file, opens it using SQL-editor
     * and ensures that UTF-8 is used for everything.
     */
    public static void saveOpenTmpSqlEditor(String content, String filenamePrefix, DatabaseType dbType)
            throws IOException, CoreException {
        Log.log(Log.LOG_INFO, "Creating file " + filenamePrefix); //$NON-NLS-1$
        Path path = Files.createTempFile(filenamePrefix + '_', ".sql"); //$NON-NLS-1$
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        IEditorInput input = new SQLEditorInput(path, dbType, false);

        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(input, EDITOR.SQL);
        if (part instanceof ITextEditor editor) {
            IDocumentProvider prov = editor.getDocumentProvider();
            if (prov instanceof TextFileDocumentProvider textProv) {
                textProv.setEncoding(input, Consts.UTF_8);
                prov.resetDocument(input);
            }
        }
    }

    public static void openFileInSqlEditor(PgObjLocation loc, String project,
            DatabaseType dbType, boolean isReadOnly) throws PartInitException {
        if (loc != null && loc.getFilePath() != null) {
            IEditorPart part = openFileInSqlEditor(
                    Paths.get(loc.getFilePath()), project, dbType, isReadOnly);
            if (part instanceof ITextEditor editor) {
                editor.selectAndReveal(loc.getOffset(), loc.getObjLength());
            }
        }
    }

    public static IEditorPart openFileInSqlEditor(Path path, String project,
            DatabaseType dbType, boolean isReadOnly) throws PartInitException {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IFile[] files = workspace.getRoot().findFilesForLocationURI(path.toUri());
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        for (IFile f : files) {
            IProject proj = f.getProject();
            if (proj.isOpen()) {
                return IDE.openEditor(page, f, EDITOR.SQL);
            }
        }
        IEditorInput input = new SQLEditorInput(path, project, dbType, isReadOnly);
        return IDE.openEditor(page, input, EDITOR.SQL);
    }

    public static IFile getFileForLocation(ContextLocation loc) {
        if (loc == null) {
            return null;
        }
        return getFileForLocation(loc.getFilePath());
    }

    public static IFile getFileForLocation(String location) {
        if (location == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
                new org.eclipse.core.runtime.Path(location));
    }

    private FileUtilsUi() {
    }
}
