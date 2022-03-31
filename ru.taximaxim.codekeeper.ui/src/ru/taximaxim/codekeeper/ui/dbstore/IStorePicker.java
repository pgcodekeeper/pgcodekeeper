package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;

public interface IStorePicker {

    public static final String DELIM_ENTRY = "\n"; //$NON-NLS-1$
    public static final int MAX_FILES_HISTORY = 10;

    void setUseFileSources(boolean useFileSources);

    DbInfo getDbInfo();

    default File getPathOfFile() {
        return getPath(false);
    }

    default File getPathOfDir() {
        return getPath(false);
    }

    File getPath(boolean getDirectory);

    Object getSelection();

    void setSelection(Object selection);

    void setSelection(Object selection, boolean triggerEvent);

    default void clearSelection() {
        setSelection(null);
    }

    void setEnabled(boolean enabled);

    boolean isEnabled();

    void addSelectionListener(Runnable runnable);

    void filter(boolean isMsSql);

    void dispose();
}