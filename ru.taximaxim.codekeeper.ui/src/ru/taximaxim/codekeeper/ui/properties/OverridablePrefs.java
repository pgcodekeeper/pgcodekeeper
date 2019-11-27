package ru.taximaxim.codekeeper.ui.properties;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;

/**
 * Gives the ability to override the global preferences by project preferences.
 */
public class OverridablePrefs {

    public static final int MAIN_PREF = 1;
    public static final int DB_UPDATE_PREF = 2;

    private final IPreferenceStore mainPS;
    private IEclipsePreferences projPS;
    private final Map<String, Boolean> oneTimePS;

    private boolean isEnableProjPrefRoot;
    private boolean isEnableProjPrefDbUpdate;

    public OverridablePrefs(IProject project, Map<String, Boolean> oneTimePS) {
        mainPS = Activator.getDefault().getPreferenceStore();
        if (project != null) {
            projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
            this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
            this.isEnableProjPrefDbUpdate = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);
        }
        this.oneTimePS = oneTimePS;
    }

    public boolean isUseGlobalIgnoreList() {
        if (oneTimePS != null) {
            Boolean value = oneTimePS.get(PROJ_PREF.USE_GLOBAL_IGNORE_LIST);
            if (value != null) {
                return value;
            }
        }
        return !isEnableProjPrefRoot ||
                projPS.getBoolean(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, true);
    }

    public boolean getBoolean(String key, int prefType) {
        if (oneTimePS != null) {
            Boolean value = oneTimePS.get(key);
            if (value != null) {
                return value;
            }
        }

        boolean isEnableProjPref;

        switch (prefType) {
        case MAIN_PREF:
            isEnableProjPref = isEnableProjPrefRoot;
            break;
        case DB_UPDATE_PREF:
            isEnableProjPref = isEnableProjPrefDbUpdate;
            break;
        default:
            throw new IllegalArgumentException("Unsupported pref type"); //$NON-NLS-1$
        }

        return isEnableProjPref ? projPS.getBoolean(key, false) : mainPS.getBoolean(key);
    }
}
