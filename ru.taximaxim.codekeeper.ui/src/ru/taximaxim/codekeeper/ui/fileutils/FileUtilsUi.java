package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
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

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public final class FileUtilsUi {

    /**
     * Saves the content as a temp-file, opens it using SQL-editor
     * and ensures that UTF-8 is used for everything.
     */
    public static void saveOpenTmpSqlEditor(String content, String filenamePrefix, boolean isMsSql)
            throws IOException, CoreException {
        Log.log(Log.LOG_INFO, "Creating file " + filenamePrefix); //$NON-NLS-1$
        Path path = Files.createTempFile(filenamePrefix + '_', ".sql"); //$NON-NLS-1$
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        IFileStore externalFile = EFS.getLocalFileSystem().fromLocalFile(path.toFile());
        IEditorInput input = new SQLEditorInput(externalFile, isMsSql);

        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(input, EDITOR.SQL);
        if (part instanceof ITextEditor) {
            IDocumentProvider prov = ((ITextEditor) part).getDocumentProvider();
            if (prov instanceof TextFileDocumentProvider) {
                ((TextFileDocumentProvider) prov).setEncoding(input, ApgdiffConsts.UTF_8);
                prov.resetDocument(input);
            }
        }
    }

    public static void openFileInSqlEditor(PgObjLocation loc, boolean isMsSql) throws PartInitException {
        if (loc != null && loc.getFilePath() != null) {
            IEditorPart part = openFileInSqlEditor(Paths.get(loc.getFilePath()), isMsSql);
            if (part instanceof ITextEditor) {
                ((ITextEditor) part).selectAndReveal(loc.getOffset(), loc.getObjLength());
            }
        }
    }

    public static IEditorPart openFileInSqlEditor(Path path, boolean isMsSql) throws PartInitException {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IFile[] files = workspace.getRoot().findFilesForLocationURI(path.toUri());
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        for (IFile f : files) {
            IProject proj = f.getProject();
            if (proj.isOpen()) {
                return IDE.openEditor(page, f, EDITOR.SQL);
            }
        }
        IFileStore externalFile = EFS.getLocalFileSystem().fromLocalFile(path.toFile());
        IEditorInput input = new SQLEditorInput(externalFile, isMsSql);
        return IDE.openEditor(page, input, EDITOR.SQL);
    }

    private FileUtilsUi() {
    }
}
