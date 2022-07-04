package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractStorePicker implements IStorePicker {

    protected final Composite parent;

    protected boolean useFileSources;
    protected final boolean useDirSources;
    protected boolean triggerEvent = true;

    public AbstractStorePicker(Composite parent, boolean useFileSources, boolean useDirSources) {
        this.useFileSources = useFileSources;
        this.useDirSources = useDirSources;
        this.parent = parent;
    }

    protected abstract Control getControl();

    @Override
    public void setUseFileSources(boolean useFileSources) {
        this.useFileSources = useFileSources;
    }

    @Override
    public void setSelection(Object selection, boolean triggerEvent) {
        boolean oldTriggerEvent = this.triggerEvent;
        try {
            this.triggerEvent = triggerEvent;
            setSelection(selection);
        } finally {
            this.triggerEvent = oldTriggerEvent;
        }
    }

    @Override
    public DbInfo getDbInfo() {
        Object selection = getSelection();
        return selection instanceof DbInfo ? (DbInfo) selection : null;
    }

    @Override
    public File getPath(boolean getDirectory) {
        Object selection = getSelection();
        if (selection instanceof File) {
            File f = (File) selection;
            return f.isDirectory() == getDirectory ? f : null;
        } else {
            return null;
        }
    }

    @Override
    public void dispose() {
        getControl().dispose();
    }

    @Override
    public void setEnabled(boolean enabled) {
        getControl().setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return getControl().getEnabled();
    }

    public static String getDirPath(IPreferenceStore prefStore, Shell shell) {
        DirectoryDialog dialog = new DirectoryDialog(shell);
        dialog.setText(Messages.DbStorePicker_choose_dir);
        dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
        return dialog.open();
    }

    public static String getFilePath(IPreferenceStore prefStore, Shell shell) {
        FileDialog dialog = new FileDialog(shell);
        dialog.setText(Messages.choose_dump_file_with_changes);
        dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
        dialog.setFilterNames(new String[] {
                Messages.DiffPresentationPane_sql_file_filter,
                Messages.DiffPresentationPane_any_file_filter});
        dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
        return dialog.open();
    }

    public static File chooseDbSource(IPreferenceStore prefStore, Shell shell, boolean dir) {
        String pathToDump = dir ? getDirPath(prefStore, shell) : getFilePath(prefStore, shell);
        if (pathToDump == null) {
            return null;
        }

        File dumpFile = new File(pathToDump);
        Deque<File> dumpHistory = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
        dumpHistory.addFirst(dumpFile);
        while (dumpHistory.size() > MAX_FILES_HISTORY) {
            dumpHistory.removeLast();
        }
        prefStore.setValue(PREF.DB_STORE_FILES, dumpFileHistoryToPreference(dumpHistory));
        prefStore.setValue(PREF.LAST_OPENED_LOCATION,
                dir ? dumpFile.getAbsolutePath() : dumpFile.getParent());
        return dumpFile;
    }

    public static String dumpFileHistoryToPreference(Collection<File> dumps) {
        StringBuilder sb = new StringBuilder();
        for (File path : dumps){
            sb.append(path.getAbsolutePath());
            sb.append(DELIM_ENTRY);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static Deque<File> stringToDumpFileHistory(String preference) {
        String[] coordStrings = preference.split(DELIM_ENTRY);
        Deque<File> paths = new LinkedList<>();
        for (String path : coordStrings) {
            File f = new File(path);
            if (f.exists() && !paths.contains(f)) {
                paths.add(f);
            }
        }
        return paths;
    }
}
