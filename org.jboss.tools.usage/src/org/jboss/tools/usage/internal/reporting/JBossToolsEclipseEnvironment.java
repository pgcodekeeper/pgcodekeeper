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
package org.jboss.tools.usage.internal.reporting;

import java.util.Collection;

import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.jboss.tools.usage.googleanalytics.IJBossToolsEclipseEnvironment;
import org.jboss.tools.usage.googleanalytics.eclipse.AbstractEclipseEnvironment;
import org.jboss.tools.usage.googleanalytics.eclipse.IEclipseUserAgent;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.reporting.JBossToolsComponents.IBundleProvider;
import org.osgi.framework.Bundle;

/**
 * @author Andre Dietisheim
 */
public class JBossToolsEclipseEnvironment extends AbstractEclipseEnvironment implements IJBossToolsEclipseEnvironment {

	private static final String NOT_INSTALLED = "N/A";  //$NON-NLS-1$
	private static final String TRUE = "true";  //$NON-NLS-1$
	private static final String FALSE = "false";  //$NON-NLS-1$
	private static final char JBOSS_COMPONENTS_DELIMITER = '-';

	private static final String JBOSS_CENTRAL_PLUGIN_ID = "org.jboss.tools.central"; //$NON-NLS-1$
	private static final String SHOW_JBOSS_CENTRAL_ON_STARTUP = "showJBossCentralOnStartup"; //$NON-NLS-1$
	private static final boolean SHOW_JBOSS_CENTRAL_ON_STARTUP_DEFAULT_VALUE = true;
	private String keyWord;

	public JBossToolsEclipseEnvironment(String accountName, String hostName, IEclipsePreferences preferences) {
		super(accountName, hostName, preferences);
	}

	protected JBossToolsEclipseEnvironment(String accountName, String hostName, IEclipsePreferences preferences,
			IEclipseUserAgent userAgent) {
		super(accountName, hostName, preferences, userAgent);
	}

	@Override
	public String getKeyword() {
		if(keyWord==null) {
			Collection<String> jbossComponentNames = 
					JBossToolsComponents.getComponentIds(
							getBundleGroupProviders(),
							new EclipsePlatformBundleQuery());
			keyWord = bundleGroupsToKeywordString(jbossComponentNames);
		}
		return keyWord;
	}

	protected IBundleGroupProvider[] getBundleGroupProviders() {
		return Platform.getBundleGroupProviders();
	}

	private String bundleGroupsToKeywordString(Collection<String> jbossComponentNames) {
		char delimiter = JBOSS_COMPONENTS_DELIMITER;
		StringBuilder builder = new StringBuilder();
		for (String componentName : jbossComponentNames) {
			builder.append(componentName)
					.append(delimiter);
		}
		if(builder.length()>0) {
			builder.deleteCharAt(builder.length()-1); // Remove the last delimiter
		}
		return builder.toString();
	}

	@Override
	public String getJBossToolsVersion() {
		return JBossToolsUsageActivator.getDefault().getBundle().getVersion().toString();
	}

	@Override
	public boolean isLinuxDistro() {
		return getLinuxDistroNameAndVersion() != null;
	}

	@Override
	public GoogleAnalyticsEvent getEvent() {
		return new GoogleAnalyticsEvent("central", "showOnStartup", getCentralEnabledValue());
	}

	@Override
	public String getCentralEnabledValue() {
		Bundle bundle = Platform.getBundle(JBOSS_CENTRAL_PLUGIN_ID);
		if (bundle == null) {
			return NOT_INSTALLED;
		}
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(JBOSS_CENTRAL_PLUGIN_ID);
		boolean showOnStartup = prefs.getBoolean(SHOW_JBOSS_CENTRAL_ON_STARTUP,
				SHOW_JBOSS_CENTRAL_ON_STARTUP_DEFAULT_VALUE);
		if (showOnStartup) {
			return TRUE;
		}
		return FALSE;
	}

	private class EclipsePlatformBundleQuery implements IBundleProvider {

		@Override
		public boolean isInstalled(String symbolicName) {
			return Platform.getBundle(symbolicName) != null;
		}
	}
}