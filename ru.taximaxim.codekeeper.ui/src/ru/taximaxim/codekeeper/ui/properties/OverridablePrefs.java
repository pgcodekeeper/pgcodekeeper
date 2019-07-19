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

    public OverridablePrefs(IProject project) {
        mainPS = Activator.getDefault().getPreferenceStore();
        if (project != null) {
            projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
            this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
        }
    }

    public void setEnableProjPrefRoot(boolean isEnableProjPrefRoot) {
        this.isEnableProjPrefRoot = isEnableProjPrefRoot;
        projPS.putBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, isEnableProjPrefRoot);
    }

    public boolean isIgnorePrivileges() {
        return isEnableProjPrefRoot ? projPS.getBoolean(PREF.NO_PRIVILEGES, false)
                : mainPS.getBoolean(PREF.NO_PRIVILEGES);
    }
}
