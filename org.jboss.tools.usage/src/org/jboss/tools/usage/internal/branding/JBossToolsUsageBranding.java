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

import org.jboss.tools.usage.localizations.Messages;

/**
 * @author André Dietisheim
 */
public class JBossToolsUsageBranding implements IUsageBranding {

	@Override
	public String getPreferencesDescription() {
		return Messages.UsageReportPreferencePage_Description;
	}

	@Override
	public String getPreferencesAllowReportingCheckboxLabel() {
		return Messages.UsageReportPreferencePage_AllowReporting;
	}

	@Override
	public String getStartupAllowReportingTitle() {
		return Messages.UsageReport_DialogTitle;
	}

	@Override
	public String getStartupAllowReportingMessage() {
		return Messages.UsageReport_DialogMessage;
	}

	@Override
	public String getGoogleAnalyticsAccount() {
		return GA_ACCOUNT;
	}

	@Override
	public String getGoogleAnalyticsReportingHost() {
		return GA_HOSTNAME;
	}
}
