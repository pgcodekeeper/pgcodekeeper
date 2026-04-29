/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.settings;

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
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.base.formatter.FormatConfiguration;
import org.pgcodekeeper.core.settings.ISettings;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.formatter.Formatter;
import ru.taximaxim.codekeeper.ui.prefs.PrePostScriptPrefPage;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceCategory;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public final class UISettings implements ISettings {

    private String timeZone;
    private String inCharsetName = Consts.UTF_8;

    private final IProject project;
    private final Map<String, Object> oneTimePS;
    private final DatabaseType dbType;
    private final OverridablePrefs overridablePrefs;

    public UISettings(IProject project, Map<String, Object> oneTimePS, DatabaseType dbType) {
        this.project = project;
        this.oneTimePS = oneTimePS;
        this.overridablePrefs = new OverridablePrefs(project, oneTimePS);

        if (project != null) {
            var projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
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

    public UISettings(IProject project, Map<String, Object> oneTimePS) {
        this(project, oneTimePS, null);
    }

    @Override
    public boolean isConcurrentlyMode() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY);
    }

    @Override
    public boolean isAddTransaction() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION);
    }

    @Override
    public boolean isGenerateExists() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.GENERATE_EXISTS);
    }

    @Override
    public boolean isGenerateConstraintNotValid() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID);
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK);
    }

    @Override
    public boolean isPrintUsing() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.PRINT_USING);
    }

    @Override
    public boolean isKeepNewlines() {
        return !overridablePrefs.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
    }

    @Override
    public boolean isCommentsToEnd() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.COMMENTS_TO_END);
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        return getMainBoolean(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY);
    }

    @Override
    public boolean isIgnorePrivileges() {
        return getMainBoolean(PREF.NO_PRIVILEGES);
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return getMainBoolean(PREF.IGNORE_COLUMN_ORDER);
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return getMainBoolean(PREF.ENABLE_BODY_DEPENDENCIES);
    }

    @Override
    public boolean isDataMovementMode() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.DATA_MOVEMENT_MODE);
    }

    @Override
    public boolean isDropBeforeCreate() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.DROP_BEFORE_CREATE);
    }

    @Override
    public boolean isStopNotAllowed() {
        return false;
    }

    @Override
    public boolean isSelectedOnly() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS);
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        return getMainBoolean(PREF.IGNORE_CONCURRENT_MODIFICATION);
    }

    @Override
    public boolean isParallelLoad() {
        return getMainBoolean(PREF.PARALLEL_LOADING);
    }

    @Override
    public boolean isSimplifyView() {
        return getMainBoolean(PREF.SIMPLIFY_VIEW);
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
        return getDbUpdateBoolean(DB_UPDATE_PREF.DISABLE_CHECK_FUNCTION_BODIES);
    }

    @Override
    public Collection<String> getPreFilePath() {
        if (!getDbUpdateBoolean(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.PRE_DIR, FILE.PRE_SCRIPT);
    }

    @Override
    public Collection<String> getPostFilePath() {
        if (!getDbUpdateBoolean(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.POST_DIR, FILE.POST_SCRIPT);
    }

    @Override
    public String getClusterName() {
        return (String) overridablePrefs.get(PreferenceCategory.DB_UPDATE, DB_UPDATE_PREF.CLUSTER_NAME);
    }

    private Map<String, Object> createTempPrefs() {
        Map<String, Object> temp = new HashMap<>();
        if (null != oneTimePS) {
            temp.putAll(oneTimePS);
        }
        return temp;
    }

    private boolean getMainBoolean(String key) {
        return (boolean) overridablePrefs.get(PreferenceCategory.MAIN, key);
    }

    private boolean getDbUpdateBoolean(String key) {
        return (boolean) overridablePrefs.get(PreferenceCategory.DB_UPDATE, key);
    }

    private List<String> addPathsIfExists(String dir, String script) {
        List<String> paths = new ArrayList<>();
        if (project != null) {
            addPathIfExists(paths, Paths.get(project.getLocationURI()).resolve(dir));
        }
        addPathIfExists(paths, PrePostScriptPrefPage.getScriptPath(script));
        return paths;
    }

    private void addPathIfExists(List<String> paths, Path path) {
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

    @Override
    public boolean isDisableAutoLoad() {
        return false;
    }

    @Override
    public boolean isUseActualVersionSyntax() {
        return getDbUpdateBoolean(DB_UPDATE_PREF.USE_ACTUAL_VERSION_SYNTAX);
    }

    @Override
    public boolean isSimplifyNotNull() {
        return getMainBoolean(PREF.SIMPLIFY_NOT_NULL);
    }
}
