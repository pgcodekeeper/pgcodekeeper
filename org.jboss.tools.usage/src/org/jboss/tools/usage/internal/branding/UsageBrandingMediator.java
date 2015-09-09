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

	private final IUsageBranding defaultBranding;

	public UsageBrandingMediator(IUsageBranding defaultBranding, BundleContext context) {
		super(context, IUsageBranding.class.getName(), null);
		this.defaultBranding = defaultBranding;
	}

	@Override
	public String getPreferencesDescription() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getPreferencesDescription();
		} else {
			return defaultBranding.getPreferencesDescription();
		}
	}

	@Override
	public String getPreferencesAllowReportingCheckboxLabel() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getPreferencesAllowReportingCheckboxLabel();
		} else {
			return defaultBranding.getPreferencesAllowReportingCheckboxLabel();
		}
	}

	@Override
	public String getStartupAllowReportingTitle() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingTitle();
		} else {
			return defaultBranding.getStartupAllowReportingTitle();
		}
	}

	@Override
	public String getStartupAllowReportingMessage() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getStartupAllowReportingMessage();
		} else {
			return defaultBranding.getStartupAllowReportingMessage();
		}
	}

	@Override
	public String getGoogleAnalyticsAccount() {
		IUsageBranding service = (IUsageBranding) getService();
		if (service != null) {
			return service.getGoogleAnalyticsAccount();
		} else {
			return defaultBranding.getGoogleAnalyticsAccount();
		}
	}
}
