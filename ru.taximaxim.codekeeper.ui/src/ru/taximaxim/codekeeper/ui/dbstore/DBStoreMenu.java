package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DBStoreMenu {
    private final MenuManager menuMgrGetChangesCustom;
    private Object currentRemote;
    private Shell shell;
    private static final int MAX_FILES_HISTORY = 10;
    private ProjectEditorDiffer editor;
    private static final String DELIM_ENTRY = "\n"; //$NON-NLS-1$
    private final IPreferenceStore prefStore = Activator.getDefault()
            .getPreferenceStore();

    public DBStoreMenu(MenuManager menuMgrGetChangesCustom) {
        this.menuMgrGetChangesCustom = menuMgrGetChangesCustom;
    }

    public void loadStore() {
        editor = (ProjectEditorDiffer) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        menuMgrGetChangesCustom.add(new Separator());
        List<DbInfo> store = DbInfo.readStoreFromXml();

        Collection<File> files;
        files = stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));

        for (DbInfo dbInfo : store) {
            Action dbAction = new Action(dbInfo.getName(), IAction.AS_RADIO_BUTTON) {
                @Override
                public void run() {
                    currentRemote = dbInfo;
                    editor.setCurrentDb(dbInfo);
                }
            };
            if (dbInfo.equals(editor.getCurrentDb())) {
                dbAction.setChecked(true);
            }
            menuMgrGetChangesCustom.add(dbAction);
        }

        menuMgrGetChangesCustom.add(new Action(Messages.DbStorePicker_open_db_store) {
            @Override
            public void run() {
                PreferencesUtil
                .createPreferenceDialogOn(shell, PREF_PAGE.DB_STORE, null, null)
                .open();
            }
        });
        Action separator = new Action("─────────────────") {};
        separator.setEnabled(false);
        menuMgrGetChangesCustom.add(separator);

        menuMgrGetChangesCustom.add(new Action(Messages.DbStorePicker_load_from_file, IAction.AS_RADIO_BUTTON) {
            @Override
            public void run() {
                File dumpFile = chooseDbSource();
                if (dumpFile != null) {
                    currentRemote = dumpFile;
                    editor.setCurrentDb(currentRemote);
                }
            }
        });

        for (File f : files) {
            if (f.isFile()) {
                Action fileAction = new Action(f.getName(), IAction.AS_RADIO_BUTTON) {
                    @Override
                    public void run() {
                        editor.setCurrentDb(f);
                    }
                };
                menuMgrGetChangesCustom.add(fileAction);
                if (f.equals(editor.getCurrentDb())) {
                    fileAction.setChecked(true);
                }
            }
        }
    }

    private Deque<File> stringToDumpFileHistory(String preference) {
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

    private File chooseDbSource() {
        String pathToDump = getFilePath();
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
                dumpFile.getParent());
        return dumpFile;
    }

    private String getFilePath() {
        FileDialog dialog = new FileDialog(menuMgrGetChangesCustom.getMenu().getShell() );
        dialog.setText(Messages.choose_dump_file_with_changes);
        dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
        dialog.setFilterNames(new String[] {
                Messages.DiffPresentationPane_sql_file_filter,
                Messages.DiffPresentationPane_any_file_filter});
        dialog.setFilterPath(prefStore.getString(PREF.LAST_OPENED_LOCATION));
        return dialog.open();
    }
    private String dumpFileHistoryToPreference(Collection<File> dumps) {
        StringBuilder sb = new StringBuilder();
        for (File path : dumps){
            sb.append(path.getAbsolutePath());
            sb.append(DELIM_ENTRY);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
