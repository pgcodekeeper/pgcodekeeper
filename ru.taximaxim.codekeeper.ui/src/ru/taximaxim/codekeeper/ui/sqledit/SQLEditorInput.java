package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.ui.ide.FileStoreEditorInput;

public class SQLEditorInput extends FileStoreEditorInput {

    private final boolean isMsSql;

    public SQLEditorInput(IFileStore fileStore, boolean isMsSql) {
        super(fileStore);
        this.isMsSql = isMsSql;
    }

    public boolean isMsSql() {
        return isMsSql;
    }
}
