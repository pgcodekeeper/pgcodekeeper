/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.pgcodekeeper.core.DatabaseType;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class DBStoreMenu {

    private final boolean useFileSources;
    private final boolean useDirSources;
    private final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
    private final List<File> projects = new ArrayList<>();

    private final MenuManager menuMgr;
    private final DatabaseType dbType;
    private final Shell shell;
    private final Object selection;
    private final ListenerList<Consumer<Object>> listeners = new ListenerList<>();

    public DBStoreMenu(MenuManager menuMgr, boolean useFileSources,
            boolean useDirSources, DatabaseType dbType, Shell shell, Object selection) {
        this.useFileSources = useFileSources;
        this.useDirSources = useDirSources;
        this.menuMgr = menuMgr;
        this.dbType = dbType;
        this.shell = shell;
        this.selection = selection;

        if (useDirSources) {
            // load projects in ctor for now, Workspace listener and dynamic list may be added later
            IProject[] projs = ResourcesPlugin.getWorkspace().getRoot().getProjects();
            for (var proj : projs) {
                if (ProjectUtils.isPgCodeKeeperProject(proj)
                        && ProjectUtils.getDatabaseType(proj) == dbType) {
                    projects.add(proj.getLocation().toFile());
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
            MenuManager submenu;
            if (map.size() > 1) {
                submenu = new MenuManager(k.isEmpty() ? Messages.DbMenu_no_group : k);
                menuMgr.add(submenu);
            } else {
                submenu = menuMgr;
            }

            for (DbInfo dbInfo : v) {
                if (dbType == null || dbInfo.getDbType() == dbType) {
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
                    File dumpFile = AbstractStorePicker.chooseDbSource(prefStore, shell, false);
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
                    File dir = AbstractStorePicker.chooseDbSource(prefStore, shell, true);
                    if (dir != null) {
                        notifyListeners(dir);
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
                if (isChecked()) {
                    notifyListeners(file);
                }
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
                if (isChecked()) {
                    notifyListeners(dbInfo);
                }
            }
        };
        submenu.add(dbAction);
        ProjectIcon projectIcon = switch (dbInfo.getDbType()) {
            case MS -> ProjectIcon.MS_ICON;
            case PG -> ProjectIcon.PG_ICON;
            case CH -> ProjectIcon.CH_ICON;
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbInfo.getDbType());
        };
        dbAction.setImageDescriptor(Activator.getRegisteredDescriptor(projectIcon));
        if (dbInfo.equals(selection)) {
            dbAction.setChecked(true);
            String group = dbInfo.getDbGroup();
            submenu.setMenuText((group.isEmpty() ? Messages.DbMenu_no_group : group) + " \u2022"); //$NON-NLS-1$
        }
    }
}
