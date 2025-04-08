package ru.taximaxim.codekeeper.ui.properties;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.SourceFormat;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.formatter.Formatter;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.prefs.PrePostScriptPrefPage;

public class UISettings implements ISettings {

    private String timeZone;
    private DatabaseType dbType = DatabaseType.PG;
    private boolean keepNewlines;
    private boolean isEnableProjPrefRoot;
    private boolean isEnableProjPrefDbUpdate;
    private final IProject project;

    private final IPreferenceStore mainPS = Activator.getDefault().getPreferenceStore();;
    private final IEclipsePreferences projPS;
    private final Map<String, Boolean> oneTimePS;

    public UISettings(IProject project, Map<String, Boolean> oneTimePS) {
        this.project = project;
        this.oneTimePS = oneTimePS;
        projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
        this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
        this.isEnableProjPrefDbUpdate = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);
        this.timeZone = projPS.get(PROJ_PREF.TIMEZONE, Consts.UTC);
        this.keepNewlines = projPS.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true);
        this.dbType = OpenProjectUtils.getDatabaseType(project);
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
    public boolean isConstraintNotValid() {
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
        return keepNewlines;
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
        try {
            return project.getDefaultCharset(true);
        } catch (CoreException e) {
//            e.printStackTrace();
            return Consts.UTF_8;
        }
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
        return null;
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return getBooleanOfDbUpdatePref(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES);
    }

    @Override
    public Collection<String> getPreFilePath() {
        if (getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.PRE_DIR, FILE.PRE_SCRIPT);
    }

    @Override
    public Collection<String> getPostFilePath() {
        if (getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            return Collections.emptyList();
        }
        return addPathsIfExists(FILE.POST_DIR, FILE.POST_SCRIPT);
    }

    @Override
    public void setInCharsetName(String charset) {
    }

    @Override
    public void setIsAddTransaction(boolean isAddTransaction) {
    }

    @Override
    public void setIgnorePrivileges(boolean isIgnorePriv) {
    }

    @Override
    public boolean isLibSafeMode() {
        return false;
    }

    @Override
    public boolean isIgnoreErrors() {
        return false;
    }

    @Override
    public String getNewSrc() {
        return null;
    }

    @Override
    public String getOldSrc() {
        return null;
    }

    @Override
    public String getIgnoreSchemaList() {
        return null;
    }

    @Override
    public SourceFormat getNewSrcFormat() {
        return null;
    }

    @Override
    public SourceFormat getOldSrcFormat() {
        return null;
    }

    @Override
    public Collection<String> getIgnoreLists() {
        return null;
    }

    @Override
    public Collection<String> getTargetLibXmls() {
        return null;
    }

    @Override
    public Collection<String> getTargetLibs() {
        return null;
    }

    @Override
    public Collection<String> getTargetLibsWithoutPriv() {
        return null;
    }

    @Override
    public Collection<String> getSourceLibXmls() {
        return null;
    }

    @Override
    public Collection<String> getSourceLibs() {
        return null;
    }

    @Override
    public Collection<String> getSourceLibsWithoutPriv() {
        return null;
    }

    @Override
    public boolean isUsingTypeCastOff() {
        return false;
    }

    @Override
    public ISettings copy() {
        return new UISettings(project, oneTimePS);
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

    private List<String> addPathsIfExists(String postDir, String postScript) {
        List<String> paths = new ArrayList<>();
        if (project != null) {
            addPathIfExists(paths, Paths.get(project.getLocationURI()).resolve(FILE.POST_DIR));
        }
        addPathIfExists(paths, PrePostScriptPrefPage.getScriptPath(FILE.POST_SCRIPT));
        return paths;
    }

    private static void addPathIfExists(List<String> paths, Path path) {
        if (Files.exists(path)) {
            paths.add(path.toString());
        }
    }
}
