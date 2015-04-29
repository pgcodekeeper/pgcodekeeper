package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.StorageDocumentProvider;
/**
 * This class does not save changes in input, it uses cache input in memory 
 * @author botov_av
 *
 */
public class SQLEditorStorageDocumentProvider extends StorageDocumentProvider {

    private static final SQLEditorCommonDocumentProvider prov = new SQLEditorCommonDocumentProvider();
    
    @Override
    protected void setupDocument(Object element,IDocument document) {
        prov.setupDocument(element, document);
    }
}
