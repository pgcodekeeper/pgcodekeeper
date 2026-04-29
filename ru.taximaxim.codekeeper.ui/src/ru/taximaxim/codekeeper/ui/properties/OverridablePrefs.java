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
package ru.taximaxim.codekeeper.ui.properties;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.prefs.AbstractPreference;
import ru.taximaxim.codekeeper.ui.prefs.PreferenceCategory;
import ru.taximaxim.codekeeper.ui.prefs.Preferences;

/**
 * Gives the ability to override the global preferences by project preferences.
 */
public class OverridablePrefs {

    private final IPreferenceStore mainPS;
    private final IEclipsePreferences projPS;
    private final Map<String, Object> oneTimePS;

    private final boolean isEnableProjPrefRoot;
    private final boolean isEnableProjPrefDbUpdate;

    public OverridablePrefs(IProject project, Map<String, Object> oneTimePS) {
        mainPS = Activator.getDefault().getPreferenceStore();
        if (project != null) {
            projPS = new ProjectScope(project).getNode(UIConsts.PLUGIN_ID.THIS);
            this.isEnableProjPrefRoot = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_ROOT, false);
            this.isEnableProjPrefDbUpdate = projPS.getBoolean(PROJ_PREF.ENABLE_PROJ_PREF_DB_UPDATE, false);
        } else {
            projPS = null;
            this.isEnableProjPrefRoot = false;
            this.isEnableProjPrefDbUpdate = false;
        }
        this.oneTimePS = oneTimePS;
    }

    public Object get(String preferenceName) {
        return get(Preferences.getCategory(preferenceName), preferenceName);
    }

    public Object get(AbstractPreference<?> preference) {
        return get(preference.getCategory(), preference.getPreferenceName());
    }

    public Object get(PreferenceCategory category, String preferenceName) {
        if (PreferenceCategory.MAIN == category) {
            return getBoolean(preferenceName, isEnableProjPrefRoot);
        }

        if (DB_UPDATE_PREF.CLUSTER_NAME.equals(preferenceName)) {
            return getString(preferenceName, isEnableProjPrefDbUpdate);
        }

        return getBoolean(preferenceName, isEnableProjPrefDbUpdate);
    }

    private String getString(String key, boolean isEnableProjPref) {
        if (null != oneTimePS) {
            String value = (String) oneTimePS.get(key);
            if (null != value) {
                return value;
            }
        }

        var globalValue = mainPS.getString(key);
        if (isEnableProjPref) {
            return projPS.get(key, globalValue);
        }
        return globalValue;
    }

    public boolean getBoolean(String key, boolean isEnableProjPref) {
        if (oneTimePS != null) {
            Boolean value = (Boolean) oneTimePS.get(key);
            if (value != null) {
                return value;
            }
        }

        var globalValue = mainPS.getBoolean(key);
        if (isEnableProjPref && projPS != null) {
            return projPS.getBoolean(key, globalValue);
        }
        return globalValue;
    }
}
