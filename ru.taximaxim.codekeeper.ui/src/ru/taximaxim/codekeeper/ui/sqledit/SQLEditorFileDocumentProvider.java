package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

/**
 * This class need IFile input to save changes
 * @author botov_av
 *
 */
public class SQLEditorFileDocumentProvider extends TextFileDocumentProvider {

    private static final SQLEditorCommonDocumentProvider prov = new SQLEditorCommonDocumentProvider();

    @Override
    protected FileInfo createFileInfo(Object element) throws CoreException{
        FileInfo info = super.createFileInfo(element);
        if(info == null){
            info = createEmptyFileInfo();
        }
        IDocument document = info.fTextFileBuffer.getDocument();
        if (document != null) {
            prov.setupDocument(document);
        }
        return info;
    }
}