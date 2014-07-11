package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts;

/**
 * Extends {@link ScopedPreferenceStore} with app's default values.
 * Singleton.
 * 
 * @author Alexander Levsha
 */
public class UIScopedPreferenceStore extends ScopedPreferenceStore {
    
    private static UIScopedPreferenceStore instance;
    
    /**
     * Get this singletone.
     */
    public static UIScopedPreferenceStore get() {
        if (instance == null) {
            instance = new UIScopedPreferenceStore();
        }
        return instance;
    }
    
    private UIScopedPreferenceStore() {
        super(InstanceScope.INSTANCE, UIConsts.PLUGIN_ID);
        setDefaultValues();
    }
    
    private void setDefaultValues() {
        setDefault(UIConsts.PREF_PGDUMP_EXE_PATH, "pg_dump"); //$NON-NLS-1$
        setDefault(UIConsts.PREF_DB_STORE, "default\t\t\t\t\t0"); //$NON-NLS-1$
        setDefault(UIConsts.PREF_GIT_KEY_PRIVATE_FILE, new File(new File(
                System.getProperty("user.home"), ".ssh"), "id_rsa").toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        setDefault(UIConsts.PREF_RECENT_PROJECTS, ""); //$NON-NLS-1$
        setDefault(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS, ""); //$NON-NLS-1$
        setDefault(UIConsts.PREF_IGNORE_OBJECTS, ""); //$NON-NLS-1$
    }
}
