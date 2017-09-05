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

import java.io.IOException;

import org.jboss.tools.usage.JbossUtils;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.localizations.Messages;
import org.jboss.tools.usage.tracker.internal.UsagePluginLogger;
import org.osgi.service.prefs.BackingStoreException;

/**
 * The Class UsageReportPreferences.
 *
 * @author Andre Dietisheim
 */
public class UsageReportPreferences {

	private UsageReportPreferences() {
	}

	/**
	 * Enables (<code>true</code>) or disables (<code>false</code>) usage
	 * reporting preferences.
	 *
	 * @param enabled
	 *            the new enabled
	 */
	public static void setEnabled(boolean enabled) {
		JbossUtils.getStore().putValue(
				IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_ID, String.valueOf(enabled));
		save();
	}

	/**
	 * Returns <code>true</code> if the usage reporting enablement is set in the
	 * preferences. Returns <code>false</code> otherwise. It is intentionally not set
	 * by UsageReportPreferenceInitializer
	 *
	 * @return
	 */
	public static boolean isEnablementSet() {
		String defaultValue = "undefinedValue";
		String value = JbossUtils.getPreferences().get(
				IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_ID, defaultValue);
		return value != defaultValue;
	}

	/**
	 * Returns <code>true</code> if usage reporting is enabled
	 *
	 * @return true, if is enabled
	 */
	public static boolean isEnabled() {
		return JbossUtils.getPreferences().getBoolean(
				IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_ID,
				getEnabledDefault());
	}

	/**
	 * Returns <code>true</code> if the user shall get asked if he agrees to report its usage.
	 *
	 * @return true, if the user shall get asked
	 */
	public static boolean isAskUser() {
		return JbossUtils.getPreferences().getBoolean(
				IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_ID,
				getAskUserDefault());
	}

	/**
	 * Returns the default value for {@link #isAskUser()}
	 *
	 * @return
	 */
	static boolean getAskUserDefault() {
		return JbossUtils.getDefaultPreferences().getBoolean(
				IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_ID,
				IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_DEFAULTVALUE);
	}

	/**
	 * Returns the default value for the enablement of usage reporting
	 *
	 * @return default value that is set in plugin_customization.ini file or
	 * IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_DEFAULTVALUE otherwise
	 *
	 */
	public static boolean getEnabledDefault() {
		return JbossUtils.getDefaultPreferences().getBoolean(
				IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_ID,
				IUsageReportPreferenceConstants.USAGEREPORT_ENABLED_DEFAULTVALUE);
	}
	/**
	 * Sets the value for {@link #isAskUser()}
	 *
	 * @param askUser
	 *            the new ask user
	 */
	public static void setAskUser(boolean askUser) {
		JbossUtils.getStore().putValue(IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_ID,
				String.valueOf(askUser));
		save();
	}

	/**
	 * Save.
	 */
	private static void save() {
		try {
			JbossUtils.getStore().save();
		} catch (IOException e) {
			new UsagePluginLogger(JBossToolsUsageActivator.getDefault()).error(
					Messages.UsageReport_Error_SavePreferences);
		}

	}

	/**
	 * Flushes the preferences.
	 *
	 * @throws BackingStoreException
	 *             the backing store exception
	 */
	public static void flush() throws BackingStoreException {
		JbossUtils.getPreferences().flush();
	}
}
