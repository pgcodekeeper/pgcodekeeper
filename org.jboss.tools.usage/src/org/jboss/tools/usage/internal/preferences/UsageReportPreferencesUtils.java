/*******************************************************************************
 * Copyright (c) 2010 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.preferences;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.util.StatusUtils;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Andre Dietisheim
 */
public class UsageReportPreferencesUtils {
		
	private UsageReportPreferencesUtils() {
		// inhibit instantiation
	}

	public static IEclipsePreferences getPreferences() {
		return ConfigurationScope.INSTANCE.getNode(JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static IEclipsePreferences getDefaultPreferences() {
		return DefaultScope.INSTANCE.getNode(JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static IPersistentPreferenceStore getStore() {
		return new ScopedPreferenceStore(ConfigurationScope.INSTANCE, JBossToolsUsageActivator.PLUGIN_ID);
	}

	public static void checkedSavePreferences(IEclipsePreferences preferences, Plugin plugin, String message) {
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			IStatus status = StatusUtils.getErrorStatus(plugin.getBundle().getSymbolicName(),
					message,
					e, preferences.absolutePath());
			plugin.getLog().log(status);
		}

	}
}
