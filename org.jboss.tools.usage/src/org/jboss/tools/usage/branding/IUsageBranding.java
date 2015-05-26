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
package org.jboss.tools.usage.branding;

/**
 * Provides branding for usage reporting. Branding providers may register a
 * service that provides a service that implements this interface. If there are
 * several providers registered, the usage reporting picks the one with the
 * highest <code>service.ranking<code> property.
 * 
 * @author Andre Dietisheim
 * 
 */
public interface IUsageBranding {

	public String getPreferencesDescription();

	public String getPreferencesAllowReportingCheckboxLabel();

	public String getStartupAllowReportingTitle();

	public String getStartupAllowReportingCheckboxLabel();

	public String getStartupAllowReportingMessage();

//	public String getStartupAllowReportingDetailLink();

//	public String getGlobalRemotePropertiesUrl();

	public String getGoogleAnalyticsAccount();

//	public String getGoogleAnalyticsReportingHost();
}
