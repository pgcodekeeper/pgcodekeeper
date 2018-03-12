package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public final class FileUtilsUi {

    /**
     * Saves the content as a temp-file, opens it using SQL-editor
     * and ensures that UTF-8 is used for everything.
     */
    public static void saveOpenTmpSqlEditor(String content, String filenamePrefix) throws IOException, CoreException {
        Log.log(Log.LOG_INFO, "Creating file " + filenamePrefix); //$NON-NLS-1$
        Path path = Files.createTempFile(filenamePrefix + '_', ".sql"); //$NON-NLS-1$
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        IFileStore externalFile = EFS.getLocalFileSystem().fromLocalFile(path.toFile());
        IEditorInput input = new FileStoreEditorInput(externalFile);

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

    public static Path getPathToTimeObject(String proj, String db, String hash) throws URISyntaxException {
        return Paths.get(URIUtil.toURI(Platform.getInstanceLocation().getURL()))
                .resolve(".metadata").resolve(".plugins").resolve(PLUGIN_ID.THIS) //$NON-NLS-1$ //$NON-NLS-2$
                .resolve("projects").resolve(proj + '-' + db + '-' + hash + ".time"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private FileUtilsUi() {
    }
}
