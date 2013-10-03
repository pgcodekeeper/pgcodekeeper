package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts;

/**
 * Extends {@link ScopedPreferenceStore} with app's default values.
 * 
 * @author Alexander Levsha
 */
public class UIScopedPreferenceStore extends ScopedPreferenceStore {
	
	public UIScopedPreferenceStore() {
		super(InstanceScope.INSTANCE, UIConsts.PLUGIN_ID);
		setDefaultValues();
	}
	
	private void setDefaultValues() {
		setDefault(UIConsts.PREF_SVN_EXE_PATH, "svn");
		setDefault(UIConsts.PREF_PGDUMP_EXE_PATH, "pg_dump");
	}
}
