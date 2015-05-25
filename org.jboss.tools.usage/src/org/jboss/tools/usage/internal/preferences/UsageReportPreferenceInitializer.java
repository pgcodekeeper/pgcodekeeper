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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

/**
 * @author Andre Dietisheim
 */
public class UsageReportPreferenceInitializer extends
		AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		UsageReportPreferencesUtils.getStore().setDefault(
				IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_ID,
				IUsageReportPreferenceConstants.ASK_USER_USAGEREPORT_DEFAULTVALUE);
	}
}
