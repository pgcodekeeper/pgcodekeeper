package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;

public class SQLEditor extends AbstractDecoratedTextEditor {

    public SQLEditor() {
        super();
        setSourceViewerConfiguration(new SQLSourceViewerConfiguration(getSharedColors(), getPreferenceStore()));
        setDocumentProvider(new SQLDocumentProvider());
    }

}
