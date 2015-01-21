package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.RGB;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorStatementTypes;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorSyntaxModel;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        
        store.setDefault(PREF.USE_ANTLR, true);
        store.setDefault(PREF.PGDUMP_EXE_PATH, "pg_dump"); //$NON-NLS-1$
        store.setDefault(PREF.DB_STORE, "default\t\t\t\t\t0"); //$NON-NLS-1$
        store.setDefault(PREF.PGDUMP_CUSTOM_PARAMS, ""); //$NON-NLS-1$
        store.setDefault(PREF.IGNORE_OBJECTS, ""); //$NON-NLS-1$
        store.setDefault(PREF.FORCE_SHOW_CONSOLE, true);
        store.setDefault(COMMIT_PREF.USE_PARTIAL_EXPORT_ON_COMMIT, true);
        
        store.setDefault(DB_UPDATE_PREF.USE_PSQL_DEPCY, true);
        store.setDefault(DB_UPDATE_PREF.ALTER_COLUMN_STATEMENT, true);
        store.setDefault(DB_UPDATE_PREF.DROP_COLUMN_STATEMENT, true);
        store.setDefault(DB_UPDATE_PREF.DROP_TABLE_STATEMENT, true);
        store.setDefault(DB_UPDATE_PREF.SHOW_SCRIPT_OUTPUT_SEPARATELY, true);
        
        store.setDefault(COMMIT_PREF.CONSIDER_DEPCY_IN_COMMIT, true);
        setSQLSyntaxColorDefaults(store);
    }
    
    private void setSQLSyntaxColorDefaults(IPreferenceStore store) {
        for (SQLEditorStatementTypes type : SQLEditorStatementTypes.values()) {
            SQLEditorSyntaxModel syntax = new SQLEditorSyntaxModel(type, store);
            switch (type) {
            case CONSTANTS:
                syntax.setBold(false);
                syntax.setColor(new RGB(0, 0, 128));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case FUNCTIONS:
                syntax.setBold(false);
                syntax.setColor(new RGB(0, 0, 128));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case GLOBAL_VARIABLES:
                syntax.setBold(false);
                syntax.setColor(new RGB(0, 0, 128));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case PREDICATES:
                syntax.setBold(false);
                syntax.setColor(new RGB(0, 0, 128));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case RESERVED_WORDS:
                syntax.setBold(true);
                syntax.setColor(new RGB(127, 0, 85));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case SINGLE_LINE_COMMENTS:
                syntax.setBold(false);
                syntax.setColor(new RGB(64, 128, 128));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case TYPES:
                syntax.setBold(true);
                syntax.setColor(new RGB(64, 0, 200));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            case UN_RESERVED_WORDS:
                syntax.setBold(true);
                syntax.setColor(new RGB(127, 0, 85));
                syntax.setItalic(false);
                syntax.setStrikethrough(false);
                syntax.setUnderline(false);
                break;
            }
            syntax.setDefault();
        }
    }

    public static void savePreference(IPreferenceStore mainPrefs, String preference, String value){
        mainPrefs.setValue(preference, value);
        
        if(mainPrefs.needsSaving() && mainPrefs instanceof IPersistentPreferenceStore) {
            try {
                ((IPersistentPreferenceStore) mainPrefs).save();
            } catch (IOException ex) {
                ExceptionNotifier.notifyDefault(Messages.PreferenceInitializer_error_saving_prefs, ex);
            }
        }
    }
}
