package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

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
        super(InstanceScope.INSTANCE, PLUGIN_ID.THIS);
        setDefaultValues();
    }
    
    private void setDefaultValues() {
        setDefault(PREF.PGDUMP_EXE_PATH, "pg_dump"); //$NON-NLS-1$
        setDefault(PREF.DB_STORE, "default\t\t\t\t\t0"); //$NON-NLS-1$
        setDefault(PREF.GIT_KEY_PRIVATE_FILE, new File(new File(
                System.getProperty("user.home"), ".ssh"), "id_rsa").toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        setDefault(PREF.RECENT_PROJECTS, ""); //$NON-NLS-1$
        setDefault(PREF.PGDUMP_CUSTOM_PARAMS, ""); //$NON-NLS-1$
        setDefault(PREF.IGNORE_OBJECTS, ""); //$NON-NLS-1$
        setDefault(PREF.USE_PSQL_DEPCY, true);
    }
}
