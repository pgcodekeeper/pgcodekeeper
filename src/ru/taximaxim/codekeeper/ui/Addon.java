 
package ru.taximaxim.codekeeper.ui;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class Addon {
		
	@PostConstruct
	private void start(IEclipseContext ctx) {
		ctx.set(UIConsts.PREF_STORE, 
				new ScopedPreferenceStore(
						InstanceScope.INSTANCE, UIConsts.PLUGIN_ID));
	}
	
}