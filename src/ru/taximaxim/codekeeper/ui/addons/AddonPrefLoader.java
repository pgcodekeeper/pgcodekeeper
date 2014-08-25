 
package ru.taximaxim.codekeeper.ui.addons;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.UIScopedPreferenceStore;

// migration TODO is this needed? rework prefstore
public class AddonPrefLoader {
        
    @PostConstruct
    private void start(IEclipseContext ctx) {
        ctx.set(UIConsts.PREF_STORE, UIScopedPreferenceStore.get());
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