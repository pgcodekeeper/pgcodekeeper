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
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * A mediator that gets branding from the branding service - if available - or
 * the local (default) one if no service was registered.
 * 
 *  @author Andre Dietisheim
 */
public class UsageBrandingMediator extends ServiceTracker implements IUsageBranding {

	private IUsageBranding defaultBranding;

	public UsageBrandingMediator(IUsageBranding defaultBranding, BundleContext context) {
		super(context, IUsageBranding.class.getName(), null);
		this.defaultBranding = defaultBranding;
	}

	public String getPreferencesDescription() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getPreferencesDescription();
		} else {
			return defaultBranding.getPreferencesDescription();
		}
	}

	public String getPreferencesAllowReportingCheckboxLabel() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getPreferencesAllowReportingCheckboxLabel();
		} else {
			return defaultBranding.getPreferencesAllowReportingCheckboxLabel();
		}
	}

	public String getStartupAllowReportingTitle() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingTitle();
		} else {
			return defaultBranding.getStartupAllowReportingTitle();
		}
	}

	public String getStartupAllowReportingCheckboxLabel() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingCheckboxLabel();
		} else {
			return defaultBranding.getStartupAllowReportingCheckboxLabel();
		}
	}

	public String getStartupAllowReportingMessage() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingMessage();
		} else {
			return defaultBranding.getStartupAllowReportingMessage();
		}
	}

	public String getStartupAllowReportingDetailLink() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingDetailLink();
		} else {
			return defaultBranding.getStartupAllowReportingDetailLink();
		}

	}

	public String getGlobalRemotePropertiesUrl() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getGlobalRemotePropertiesUrl();
		} else {
			return defaultBranding.getGlobalRemotePropertiesUrl();
		}
	}

	public String getGoogleAnalyticsAccount() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getGoogleAnalyticsAccount();
		} else {
			return defaultBranding.getGoogleAnalyticsAccount();
		}
	}

	public String getGoogleAnalyticsReportingHost() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getGoogleAnalyticsReportingHost();
		} else {
			return defaultBranding.getGoogleAnalyticsReportingHost();
		}
	}
}
