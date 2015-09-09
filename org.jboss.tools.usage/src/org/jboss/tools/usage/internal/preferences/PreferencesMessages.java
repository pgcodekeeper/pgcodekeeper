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

import org.eclipse.osgi.util.NLS;

public class PreferencesMessages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.usage.internal.preferences.messages"; //$NON-NLS-1$

	public static String UsageReportPreferencePage_ReportedValues;
	public static String UsageReportPreferencePage_CurrentUsageHit;
	public static String UsageReportPreferencePage_FirstUsageHit;
	public static String UsageReportPreferencePage_JBossToolsComponents;
	public static String UsageReportPreferencePage_JBossToolsVersion;
	public static String UsageReportPreferencePage_LastUsageHit;
	public static String UsageReportPreferencePage_Locale;
	public static String UsageReportPreferencePage_NumberOfUsageHits;
	public static String UsageReportPreferencePage_OperatingSystem;
	public static String UsageReportPreferencePage_OperatingSystemVersion;
	public static String UsageReportPreferencePage_LinuxDistro;
	public static String UsageReportPreferencePage_ProductId;
	public static String UsageReportPreferencePage_ProductVersion;
	public static String UsageReportPreferencePage_ScreenColors;
	public static String UsageReportPreferencePage_ScreenResolution;
	public static String UsageReportPreferencePage_Error_Saving;

	public static String UsageReportPreferencePage_JvmName;
	public static String UsageReportPreferencePage_JvmVersion;
	public static String UsageReportPreferencePage_JvmArchitecture;

	public static String UsageReportPreferencePage_Events;
	public static String UsageReportPreferencePage_EventComponent;
	public static String UsageReportPreferencePage_EventVersion;
	public static String UsageReportPreferencePage_EventCategory;
	public static String UsageReportPreferencePage_EventAction;
	public static String UsageReportPreferencePage_EventLabel;
	public static String UsageReportPreferencePage_EventValue;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, PreferencesMessages.class);
	}

	private PreferencesMessages() {
	}
}