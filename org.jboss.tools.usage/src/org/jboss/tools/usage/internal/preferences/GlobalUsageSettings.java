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
package org.jboss.tools.usage.internal.preferences;

/**
 * A class that implements a global reporting enablement setting. The current
 * implementation queries a given url and extracts the enablement value out of
 * the response.
 *
 * @author Andre Dietisheim
 */
public class GlobalUsageSettings {

	/**
	 * system property that enables/disables reporting for current eclipse
	 * instance
	 */
	public static final String USAGE_REPORTING_ENABLED_KEY = "usage_reporting_enabled"; //$NON-NLS-1$

	/**
	 * system property that enables/disables reporting for all eclipse
	 * instances
	 */
	public static final String REMOTEPROPS_USAGE_REPORTING_ENABLED_KEY = USAGE_REPORTING_ENABLED_KEY;

	/** the enablement default for the local instance */
	private static final boolean INSTANCE_USAGE_REPORTING_ENABLED_DEFAULT = true;

	/**
	 * Returns <code>true</code> if is reporting is enabled for this eclipse
	 * instance.
	 *
	 * @return true, if this instance shall report usage
	 *
	 * @see #USAGE_REPORTING_ENABLED_KEY
	 * @see #INSTANCE_USAGE_REPORTING_ENABLED_DEFAULT
	 */
	public boolean isReportingEnabled() {
		return Boolean.valueOf(
				System.getProperty(USAGE_REPORTING_ENABLED_KEY,
						String.valueOf(INSTANCE_USAGE_REPORTING_ENABLED_DEFAULT)));
	}
}