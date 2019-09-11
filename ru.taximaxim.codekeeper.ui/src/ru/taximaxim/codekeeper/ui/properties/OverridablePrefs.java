package ru.taximaxim.codekeeper.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;

/**
 * Gives the ability to override the global preferences by project preferences.
 */
public class OverridablePrefs {

    private final IPreferenceStore mainPS;
    private IEclipsePreferences projPS;

    private boolean isEnableProjPrefRoot;
    private boolean isEnableProjPrefDbUpdate;

    public OverridablePrefs(IProject project) {
        mainPS = Activator.getDefault().getPreferenceStore();
        if (project != null) {
            projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
            this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
            this.isEnableProjPrefDbUpdate = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);
        }
    }

    public boolean isIgnorePrivileges() {
        return isEnableProjPrefRoot ? projPS.getBoolean(PREF.NO_PRIVILEGES, false)
                : mainPS.getBoolean(PREF.NO_PRIVILEGES);
    }

    public boolean isEnableBodyDependencies() {
        return isEnableProjPrefRoot ? projPS.getBoolean(PREF.ENABLE_BODY_DEPENDENCIES, false)
                : mainPS.getBoolean(PREF.ENABLE_BODY_DEPENDENCIES);
    }

    public boolean isUseGlobalIgnoreList() {
        return isEnableProjPrefRoot ? projPS.getBoolean(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, true)
                : true;
    }

    public boolean isSimplifyView() {
        return isEnableProjPrefRoot ? projPS.getBoolean(PREF.SIMPLIFY_VIEW, false)
                : mainPS.getBoolean(PREF.SIMPLIFY_VIEW);
    }

    public boolean getBoolean(String key) {
        return isEnableProjPrefDbUpdate ? projPS.getBoolean(key, false) : mainPS.getBoolean(key);
    }
}
