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
package ru.taximaxim.codekeeper.ui.properties;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.formatter.FormatConfiguration;
import org.pgcodekeeper.core.model.difftree.DbObjType;
import org.pgcodekeeper.core.settings.ISettings;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.formatter.Formatter;
import ru.taximaxim.codekeeper.ui.prefs.PrePostScriptPrefPage;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class UISettings implements ISettings {

    private String timeZone;
    private String inCharsetName = Consts.UTF_8;
    private boolean isEnableProjPrefRoot;
    private boolean isEnableProjPrefDbUpdate;
    private IEclipsePreferences projPS;

    private final IProject project;
    private final Map<String, Boolean> oneTimePS;
    private final DatabaseType dbType;
    private final IPreferenceStore mainPS = Activator.getDefault().getPreferenceStore();

    public UISettings(IProject project, Map<String, Boolean> oneTimePS, DatabaseType dbType) {
        this.project = project;
        this.oneTimePS = oneTimePS;
        if (project != null) {
            this.projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
            this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
            this.isEnableProjPrefDbUpdate = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);
            this.timeZone = projPS.get(PROJ_PREF.TIMEZONE, Consts.UTC);
        }

        if (dbType != null) {
            this.dbType = dbType;
        } else if (project != null) {
            this.dbType = ProjectUtils.getDatabaseType(project);
        } else {
            this.dbType = DatabaseType.PG;
        }
    }

    public UISettings(IProject project, Map<String, Boolean> oneTimePS) {
        this(project, oneTimePS, null);
    }

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    @Override
    public boolean isConcurrentlyMode() {
        return getBoolean(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY);
    }

    @Override
    public boolean isAddTransaction() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION);
    }

    @Override
    public boolean isGenerateExists() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.GENERATE_EXISTS);
    }

    @Override
    public boolean isGenerateConstraintNotValid() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID);
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK);
    }

    @Override
    public boolean isPrintUsing() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.USING_ON_OFF);
    }

    @Override
    public boolean isKeepNewlines() {
        if (null == projPS) {
            return false;
        }

        return !projPS.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
    }

    @Override
    public boolean isCommentsToEnd() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.COMMENTS_TO_END);
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        return getBooleanOfRootPref(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY);
    }

    @Override
    public boolean isIgnorePrivileges() {
        return getBooleanOfRootPref(PREF.NO_PRIVILEGES);
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return getBooleanOfRootPref(PREF.IGNORE_COLUMN_ORDER);
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return getBooleanOfRootPref(PREF.ENABLE_BODY_DEPENDENCIES);
    }

    @Override
    public boolean isDataMovementMode() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.DATA_MOVEMENT_MODE);
    }

    @Override
    public boolean isDropBeforeCreate() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.DROP_BEFORE_CREATE);
    }

    @Override
    public boolean isStopNotAllowed() {
        return false;
    }

    @Override
    public boolean isSelectedOnly() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS);
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        return getBoolean(PREF.IGNORE_CONCURRENT_MODIFICATION);
    }

    @Override
    public boolean isSimplifyView() {
        return getBooleanOfRootPref(PREF.SIMPLIFY_VIEW);
    }

    @Override
    public String getInCharsetName() {
        return inCharsetName;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        return Formatter.getFormatterConfig();
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return Collections.emptyList();
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES);
    }

    @Override
    public Collection<String> getPreFilePath() {
        if (!getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.PRE_DIR, FILE.PRE_SCRIPT);
    }

    @Override
    public Collection<String> getPostFilePath() {
        if (!getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.POST_DIR, FILE.POST_SCRIPT);
    }

    private Map<String, Boolean> createTempPrefs() {
        Map<String, Boolean> temp = new HashMap<>();
        if (null != oneTimePS) {
            temp.putAll(oneTimePS);
        }
        return temp;
    }

    public boolean isUseGlobalIgnoreList() {
        if (oneTimePS != null) {
            Boolean value = oneTimePS.get(PROJ_PREF.USE_GLOBAL_IGNORE_LIST);
            if (value != null) {
                return value;
            }
        }
        return !isEnableProjPrefRoot || projPS.getBoolean(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, true);
    }

    private boolean getBooleanOfRootPref(String key) {
        return getBoolean(key, isEnableProjPrefRoot);
    }

    private boolean getBooleanOfDbUpdatePref(String key) {
        return getBoolean(key, isEnableProjPrefDbUpdate);
    }

    private boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    private boolean getBoolean(String key, boolean isEnableProjPref) {
        if (oneTimePS != null) {
            Boolean value = oneTimePS.get(key);
            if (value != null) {
                return value;
            }
        }
        return isEnableProjPref ? projPS.getBoolean(key, false) : mainPS.getBoolean(key);
    }

    private List<String> addPathsIfExists(String dir, String script) {
        List<String> paths = new ArrayList<>();
        if (project != null) {
            addPathIfExists(paths, Paths.get(project.getLocationURI()).resolve(dir));
        }
        addPathIfExists(paths, PrePostScriptPrefPage.getScriptPath(script));
        return paths;
    }

    private static void addPathIfExists(List<String> paths, Path path) {
        if (Files.exists(path)) {
            paths.add(path.toString());
        }
    }

    @Override
    public UISettings copy() {
        return new UISettings(project, createTempPrefs(), dbType);
    }

    @Override
    public void setIgnorePrivileges(boolean ignorePrivileges) {
        oneTimePS.put(PREF.NO_PRIVILEGES, ignorePrivileges);
    }

    public void setCharsetName(String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }
}
