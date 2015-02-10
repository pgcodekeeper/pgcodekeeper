package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * This class need IFile input to save changes
 * @author botov_av
 *
 */
public class SQLEditorFileDocumentProvider extends FileDocumentProvider {

    private static final SQLEditorCommonDocumentProvider prov = new SQLEditorCommonDocumentProvider();

    @Override
    protected void setupDocument(Object element, IDocument document) {
        prov.setupDocument(element, document);
    }
}
