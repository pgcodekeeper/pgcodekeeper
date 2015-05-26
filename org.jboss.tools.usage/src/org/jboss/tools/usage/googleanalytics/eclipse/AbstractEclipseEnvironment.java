/*******************************************************************************
 * Copyright (c) 2010-2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.googleanalytics.eclipse;

import java.util.Random;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.usage.googleanalytics.AbstractGoogleAnalyticsParameters;
import org.jboss.tools.usage.googleanalytics.IGoogleAnalyticsParameters;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.preferences.IUsageReportPreferenceConstants;
import org.jboss.tools.usage.internal.preferences.UsageReportPreferencesUtils;

/**
 * @author Andre Dietisheim
 */
public abstract class AbstractEclipseEnvironment extends AbstractGoogleAnalyticsParameters implements
		IEclipseEnvironment {

	private static final String SYSPROP_JAVA_VERSION = "java.version";
	private static final String SYSPROP_JAVA_NAME = "java.vm.name";
	private static final String SYSPROP_JAVA_VENDOR = "java.vendor";
	private static final String SYSPROP_JAVA_BIT_VERSION = "sun.arch.data.model";
	private static final String UNKNOWN_JAVA_BIT_VERSION = "unknown";

	private volatile String screenResolution;
	private volatile String screenColorDepth;
	private Random random;
	private IEclipsePreferences preferences;
	private String firstVisit;
	private String lastVisit;
	private String currentVisit;
	private long visitCount;
	protected IEclipseUserAgent eclipseUserAgent;

	protected AbstractEclipseEnvironment(String accountName, String hostName, IEclipsePreferences preferences) {
		this(accountName, hostName, IGoogleAnalyticsParameters.VALUE_NO_REFERRAL, preferences);
	}

	protected AbstractEclipseEnvironment(String accountName, String hostName, IEclipsePreferences preferences, IEclipseUserAgent userAgent) {
		this(accountName, hostName, IGoogleAnalyticsParameters.VALUE_NO_REFERRAL, preferences, userAgent);
	}

	protected AbstractEclipseEnvironment(String accountName, String hostName, String referral,
			IEclipsePreferences preferences) {
		this(accountName, hostName, referral, preferences, new EclipseUserAgent());
	}

	protected AbstractEclipseEnvironment(String accountName, String hostName, String referral,
			IEclipsePreferences preferences, IEclipseUserAgent eclipseUserAgent) {
		super(accountName, hostName, referral);
		this.random = new Random();
		this.preferences = preferences;
		this.eclipseUserAgent = eclipseUserAgent;
		initScreenSettings();
		initVisits();
	}

	protected void initScreenSettings() {
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
		UsageReportPreferencesUtils.checkedSavePreferences(preferences, JBossToolsUsageActivator.getDefault(),
				GoogleAnalyticsEclipseMessages.EclipseEnvironment_Error_SavePreferences);
	}

	@Override
	public String getBrowserLanguage() {
		return eclipseUserAgent.getBrowserLanguage();
	}

	@Override
	public String getScreenResolution() {
		if(screenResolution==null) {
			return "notInitialized";
		}
		return screenResolution;
	}

	@Override
	public String getScreenColorDepth() {
		if(screenColorDepth==null) {
			return "notInitialized";
		}
		return screenColorDepth;
	}

	protected Display getDisplay() {
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
			UsageReportPreferencesUtils.checkedSavePreferences(preferences, JBossToolsUsageActivator.getDefault(),
					GoogleAnalyticsEclipseMessages.EclipseEnvironment_Error_SavePreferences);
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
		builder.append(Math.abs(random.nextLong()));
		builder.append(System.currentTimeMillis());
		return builder.toString();
	}

	@Override
	public abstract String getKeyword();

	@Override
	synchronized public String getCurrentVisit() {
		return currentVisit;
	}

	@Override
	synchronized public String getFirstVisit() {
		return firstVisit;
	}

	@Override
	synchronized public String getLastVisit() {
		return lastVisit;
	}

	@Override
	synchronized public long getVisitCount() {
		return visitCount;
	}

	@Override
	synchronized public void visit() {
		lastVisit = currentVisit;
		preferences.put(IUsageReportPreferenceConstants.LAST_VISIT, lastVisit);
		currentVisit = String.valueOf(System.currentTimeMillis());
		visitCount++;
		preferences.putLong(IUsageReportPreferenceConstants.VISIT_COUNT, visitCount);
		UsageReportPreferencesUtils.checkedSavePreferences(preferences, JBossToolsUsageActivator.getDefault(),
				GoogleAnalyticsEclipseMessages.EclipseEnvironment_Error_SavePreferences);
	}

	private boolean justInitialized = true;

	@Override
	synchronized public void startNewVisitSession() {
		// Check if we need to start a new visit session since it might have already been started during initialization
		if(!justInitialized) {
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
	public String getJavaVendor() {
		return System.getProperty(SYSPROP_JAVA_VENDOR);
	}

	@Override
	public String getJavaBitVersion() {
		String version = System.getProperty(SYSPROP_JAVA_BIT_VERSION);
		return version!=null?version:UNKNOWN_JAVA_BIT_VERSION;
	}

	@Override
	public IEclipseUserAgent getEclipseUserAgent() {
		return eclipseUserAgent;
	}

	@Override
	public String getUserDefined() {
		return getLinuxDistroNameAndVersion();
	}

	protected String getLinuxDistroNameAndVersion() {
		return LinuxSystem.INSTANCE.getDistroNameAndVersion();
	}
}