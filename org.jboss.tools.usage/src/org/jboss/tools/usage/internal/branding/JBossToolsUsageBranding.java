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
package org.jboss.tools.usage.internal.branding;

import org.jboss.tools.usage.branding.IUsageBranding;

/**
 * @author André Dietisheim
 */
public class JBossToolsUsageBranding implements IUsageBranding {

	public String getPreferencesDescription() {
		return JBossToolsUsageBrandingMessages.UsageReportPreferencePage_Description;
	}

	public String getPreferencesAllowReportingCheckboxLabel() {
		return JBossToolsUsageBrandingMessages.UsageReportPreferencePage_AllowReporting;
	}
	
	public String getStartupAllowReportingTitle() {
		return JBossToolsUsageBrandingMessages.UsageReport_DialogTitle;
	}
	
	public String getStartupAllowReportingMessage() {
		return JBossToolsUsageBrandingMessages.UsageReport_DialogMessage;
	}

	public String getStartupAllowReportingCheckboxLabel() {
		return JBossToolsUsageBrandingMessages.UsageReport_Checkbox_Text;
	}
	
//	public String getStartupAllowReportingDetailLink() {
//		return JBossToolsUsageBrandingMessages.UsageReport_ExplanationPage;
//	}
	
//	public String getGlobalRemotePropertiesUrl() {
//		return JBossToolsUsageBrandingMessages.GlobalUsageSettings_RemoteProps_URL;
//	}

	public String getGoogleAnalyticsAccount() {
		return JBossToolsUsageBrandingMessages.UsageReport_GoogleAnalytics_Account;
	}

//	public String getGoogleAnalyticsReportingHost() {
//		return JBossToolsUsageBrandingMessages.UsageReport_HostName;
//	}
}
