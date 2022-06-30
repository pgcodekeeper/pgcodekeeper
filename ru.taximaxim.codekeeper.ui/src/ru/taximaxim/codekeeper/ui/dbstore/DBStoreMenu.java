package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DBStoreMenu {

    private static final int MAX_FILES_HISTORY = 10;

    private final boolean useFileSources;
    private final boolean useDirSources;
    private final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
    private final List<File> projects = new ArrayList<>();

    private final MenuManager menuMgr;
    private final boolean isMssql;
    private final Shell shell;
    private final Object selection;
    private final ListenerList<Consumer<Object>> listeners = new ListenerList<>();

    public DBStoreMenu(MenuManager menuMgr, boolean useFileSources,
            boolean useDirSources, boolean isMssql, Shell shell, Object selection) {
        this.useFileSources = useFileSources;
        this.useDirSources = useDirSources;
        this.menuMgr = menuMgr;
        this.isMssql = isMssql;
        this.shell = shell;
        this.selection = selection;

        if (useDirSources) {
            // load projects in ctor for now, Workspace listener and dynamic list may be added later
            IProject[] projs = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (int i = 0; i < MAX_FILES_HISTORY && i < projs.length; ++i) {
                try {
                    if (projs[i].isOpen() && projs[i].hasNature(NATURE.ID)) {
                        this.projects.add(projs[i].getLocation().toFile());
                    }
                } catch (CoreException ex) {
                    Log.log(ex);
                }
            }
        }
    }

    public void addSelectionListener(Consumer<Object> listener) {
        listeners.add(listener);
    }

    public void removeSelectionListener(Consumer<Object> listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(Object selection) {
        for (Consumer<Object> listener : listeners) {
            listener.accept(selection);
        }
    }

    public void fillDbMenu(List<DbInfo> store) {
        Map<String, List<DbInfo>> map = DbInfo.groupDbs(store);
        map.forEach((k, v) -> {
            MenuManager submenu = new MenuManager("".equals(k) ? Messages.DbMenu_no_group : k); //$NON-NLS-1$
            menuMgr.add(submenu);
            for (DbInfo dbInfo : v) {
                if (isMssql == dbInfo.isMsSql()) {
                    addAction(dbInfo, submenu);
                }
            }
        });

        Collection<File> files;
        if (useFileSources || useDirSources) {
            files = AbstractStorePicker.stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
        } else {
            files = Collections.emptyList();
        }

        menuMgr.add(new Action(Messages.DbStorePicker_open_db_store) {

            @Override
            public void run() {
                PreferencesUtil
                .createPreferenceDialogOn(shell, PREF_PAGE.DB_STORE, null, null)
                .open();
            }
        });
        if (useFileSources) {
            menuMgr.add(new Separator());
            menuMgr.add(new Action(Messages.DbStorePicker_load_from_file) {

                @Override
                public void run() {
                    File dumpFile = DbStorePicker.chooseDbSource(prefStore, shell, false);
                    if (dumpFile != null) {
                        notifyListeners(dumpFile);
                    }
                }
            });

            for (File f : files) {
                if (f.isFile()) {
                    addAction(f);
                }
            }
        }
        if (useDirSources) {
            menuMgr.add(new Separator());
            menuMgr.add(new Action(Messages.DbStorePicker_load_from_dir) {

                @Override
                public void run() {
                    File dumpFile = DbStorePicker.chooseDbSource(prefStore, shell, false);
                    if (dumpFile != null) {
                        notifyListeners(dumpFile);
                    }
                }
            });
            for (File f : files) {
                if (f.isDirectory()) {
                    addAction(f);
                }
            }
            for (File project : projects) {
                addAction(project);
            }
        }
    }

    private void addAction(File file) {
        Action fileAction = new Action(file.getName(), IAction.AS_RADIO_BUTTON) {

            @Override
            public void run() {
                notifyListeners(file);
            }
        };
        menuMgr.add(fileAction);
        if (file.equals(selection)) {
            fileAction.setChecked(true);
        }
    }

    private void addAction(DbInfo dbInfo, MenuManager submenu) {
        Action dbAction = new Action(dbInfo.getName() + "@", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$

            @Override
            public void run() {
                notifyListeners(dbInfo);
            }
        };
        submenu.add(dbAction);
        if (dbInfo.equals(selection)) {
            dbAction.setChecked(true);
        }
    }
}
