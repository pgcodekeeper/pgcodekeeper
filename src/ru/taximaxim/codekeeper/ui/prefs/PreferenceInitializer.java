package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

    public PreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault()
                .getPreferenceStore();
        store.setDefault(PREF.PGDUMP_EXE_PATH, "pg_dump"); //$NON-NLS-1$
        store.setDefault(PREF.DB_STORE, "default\t\t\t\t\t0"); //$NON-NLS-1$
        store.setDefault(PREF.GIT_KEY_PRIVATE_FILE, new File(new File(
                System.getProperty("user.home"), ".ssh"), "id_rsa").toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        store.setDefault(PREF.RECENT_PROJECTS, ""); //$NON-NLS-1$
        store.setDefault(PREF.PGDUMP_CUSTOM_PARAMS, ""); //$NON-NLS-1$
        store.setDefault(PREF.IGNORE_OBJECTS, ""); //$NON-NLS-1$
        store.setDefault(DB_UPDATE_PREF.USE_PSQL_DEPCY, true);
        store.setDefault(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT, true);
        store.setDefault(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT, true);
        store.setDefault(DB_UPDATE_PREF.DROP_TABLE_STATEMENT, true);
    }

    public static void savePreference(IPreferenceStore mainPrefs, String preference, String value){
        mainPrefs.setValue(preference, value);
        
        if(mainPrefs.needsSaving() && mainPrefs instanceof IPersistentPreferenceStore) {
            try {
                ((IPersistentPreferenceStore) mainPrefs).save();
            } catch (IOException ex) {
                throw new IllegalStateException(
                        Messages.unexpected_error_while_saving_preferences, ex);
            }
        }
    }

}
