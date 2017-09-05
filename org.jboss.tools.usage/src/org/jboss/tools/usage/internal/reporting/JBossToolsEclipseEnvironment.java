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

import java.util.Random;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.usage.JbossUtils;
import org.jboss.tools.usage.googleanalytics.EclipseUserAgent;
import org.jboss.tools.usage.googleanalytics.IGoogleAnalyticsParameters;
import org.jboss.tools.usage.googleanalytics.LinuxSystem;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.preferences.IUsageReportPreferenceConstants;
import org.jboss.tools.usage.localizations.Messages;
import org.osgi.framework.Bundle;

/**
 * @author Andre Dietisheim
 */
public class JBossToolsEclipseEnvironment implements IGoogleAnalyticsParameters {

	private static final String NOT_INSTALLED = "N/A";  //$NON-NLS-1$
	private static final String TRUE = "true";  //$NON-NLS-1$
	private static final String FALSE = "false";  //$NON-NLS-1$
	private static final String SYSPROP_JAVA_VERSION = "java.version";
	private static final String SYSPROP_JAVA_NAME = "java.vm.name";
	private static final String SYSPROP_JAVA_BIT_VERSION = "sun.arch.data.model";
	private static final String UNKNOWN_JAVA_BIT_VERSION = "unknown";

	private static final String JBOSS_CENTRAL_PLUGIN_ID = "org.jboss.tools.central"; //$NON-NLS-1$
	private static final String SHOW_JBOSS_CENTRAL_ON_STARTUP = "showJBossCentralOnStartup"; //$NON-NLS-1$
	private static final boolean SHOW_JBOSS_CENTRAL_ON_STARTUP_DEFAULT_VALUE = true;
	private String keyWord;

	private volatile String screenResolution;
	private volatile String screenColorDepth;
	private final IEclipsePreferences preferences;
	private String firstVisit;
	private String lastVisit;
	private String currentVisit;
	private long visitCount;
	private final EclipseUserAgent eclipseUserAgent = new EclipseUserAgent();
	private final String accountName;
	private final String hostName;
	private boolean justInitialized = true;

	public JBossToolsEclipseEnvironment(String accountName, String hostName, IEclipsePreferences preferences) {
		this.accountName = accountName;
		this.hostName = hostName;
		this.preferences = preferences;
		initScreenSettings();
		initVisits();
	}

	@Override
	public String getKeyword() {
		if(keyWord == null) {
			keyWord = getComponentIds();
		}
		return keyWord;
	}

	private String getComponentIds() {
		String featureId = "ru.taximaxim.codekeeper.feature";
		String pluginId = "ru.taximaxim.codekeeper.ui";
		String pluginName = "codekeeperUI";

		if (Platform.getBundle(pluginId) != null) {
			return pluginName;
		} else {
			for (IBundleGroupProvider bundleGroupProvider : Platform.getBundleGroupProviders()) {
				for (IBundleGroup group : bundleGroupProvider.getBundleGroups()) {
					if (group.getIdentifier().equals(featureId)) {
						return pluginName;
					}
				}
			}
		}

		return "";
	}

	@Override
	public String getReferral() {
		return IGoogleAnalyticsParameters.VALUE_NO_REFERRAL;
	}

	@Override
	public String getAccountName() {
		return accountName;
	}

	@Override
	public String getHostname() {
		return hostName;
	}

	@Override
	public String getBrowserLanguage() {
		return eclipseUserAgent.getBrowserLanguage();
	}

	@Override
	public String getScreenResolution() {
		if (screenResolution == null) {
			return "notInitialized";
		}
		return screenResolution;
	}

	@Override
	public String getScreenColorDepth() {
		if (screenColorDepth == null) {
			return "notInitialized";
		}
		return screenColorDepth;
	}

	private Display getDisplay() {
		if (PlatformUI.isWorkbenchRunning()) {
			return PlatformUI.getWorkbench().getDisplay();
		}

		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		return display;
	}

	@Override
	public String getUserAgent() {
		return eclipseUserAgent.toString();
	}

	@Override
	public String getUserId() {
		String userId = preferences.get(IUsageReportPreferenceConstants.ECLIPSE_INSTANCE_ID, null);
		if (userId == null) {
			userId = createIdentifier();
			preferences.put(IUsageReportPreferenceConstants.ECLIPSE_INSTANCE_ID, userId);
			JbossUtils.checkedSavePreferences(preferences, JBossToolsUsageActivator.getDefault(),
					Messages.EclipseEnvironment_Error_SavePreferences);
		}
		return userId;
	}

	/**
	 * Creates an unique identifier.
	 *
	 * @return the identifier
	 */
	private String createIdentifier() {
		StringBuilder builder = new StringBuilder();
		builder.append(Math.abs(new Random().nextLong()));
		builder.append(System.currentTimeMillis());
		return builder.toString();
	}

	@Override
	public synchronized String getCurrentVisit() {
		return currentVisit;
	}

	@Override
	public synchronized String getFirstVisit() {
		return firstVisit;
	}

	@Override
	public synchronized String getLastVisit() {
		return lastVisit;
	}

	@Override
	public synchronized long getVisitCount() {
		return visitCount;
	}

	@Override
	public synchronized void startNewVisitSession() {
		// Check if we need to start a new visit session since it might have already been started during initialization
		if (!justInitialized) {
			initVisits();
		}
		justInitialized = false;
	}

	@Override
	public String getFlashVersion() {
		return getJavaVersion();
	}

	private String getJavaVersion() {
		return System.getProperty(SYSPROP_JAVA_VERSION);
	}

	@Override
	public String getJavaVmName() {
		return System.getProperty(SYSPROP_JAVA_NAME);
	}

	@Override
	public String getJavaBitVersion() {
		String version = System.getProperty(SYSPROP_JAVA_BIT_VERSION);
		return version != null ? version : UNKNOWN_JAVA_BIT_VERSION;
	}

	public EclipseUserAgent getEclipseUserAgent() {
		return eclipseUserAgent;
	}

	public String getUserDefined() {
		return LinuxSystem.INSTANCE.getDistroNameAndVersion();
	}

	private void initScreenSettings() {
		final Display display = getDisplay();
		display.asyncExec(new Runnable() {

			@Override
			public void run() {
				screenColorDepth = display.getDepth() + SCREENCOLORDEPTH_POSTFIX;

				Rectangle bounds = display.getBounds();
				screenResolution = bounds.width + SCREERESOLUTION_DELIMITER + bounds.height;
			}
		});
	}

	private void initVisits() {
		String currentTime = String.valueOf(System.currentTimeMillis());
		this.currentVisit = currentTime;
		this.firstVisit = preferences.get(IUsageReportPreferenceConstants.FIRST_VISIT, null);
		if (firstVisit == null) {
			this.firstVisit = currentTime;
			preferences.put(IUsageReportPreferenceConstants.FIRST_VISIT, firstVisit);
		}
		lastVisit = preferences.get(IUsageReportPreferenceConstants.LAST_VISIT, currentTime);
		visitCount = preferences.getLong(IUsageReportPreferenceConstants.VISIT_COUNT, 1);

		preferences.put(IUsageReportPreferenceConstants.LAST_VISIT, currentTime);
		preferences.putLong(IUsageReportPreferenceConstants.VISIT_COUNT, visitCount+1);
		JbossUtils.checkedSavePreferences(preferences, JBossToolsUsageActivator.getDefault(),
				Messages.EclipseEnvironment_Error_SavePreferences);
	}


	public String getJBossToolsVersion() {
		return JBossToolsUsageActivator.getDefault().getBundle().getVersion().toString();
	}

	public boolean isLinuxDistro() {
		return getUserDefined() != null;
	}

	public String getEventValue() {
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
}