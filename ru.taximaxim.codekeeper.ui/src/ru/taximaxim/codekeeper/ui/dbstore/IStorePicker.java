package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;

public interface IStorePicker {

    void setUseFileSources(boolean useFileSources);

    DbInfo getDbInfo();

    default File getPathOfFile() {
        return getPath(false);
    }

    default File getPathOfDir() {
        return getPath(true);
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

    void filter(Boolean isMsSql);

    void dispose();
}