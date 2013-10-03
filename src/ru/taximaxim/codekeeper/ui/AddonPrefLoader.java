 
package ru.taximaxim.codekeeper.ui;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;

import ru.taximaxim.codekeeper.ui.prefs.UIScopedPreferenceStore;

public class AddonPrefLoader {
		
	@PostConstruct
	private void start(IEclipseContext ctx) {
		ctx.set(UIConsts.PREF_STORE, new UIScopedPreferenceStore());
	}
	
}