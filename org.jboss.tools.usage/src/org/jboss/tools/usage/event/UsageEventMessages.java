/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.event;

import org.eclipse.osgi.util.NLS;

/**
 * @author Alexey Kazakov
 */
public class UsageEventMessages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.usage.event.messages"; //$NON-NLS-1$

	public static String UsageEvent_SuccesfullValueDescription;
	public static String UsageEvent_HowManyTimesValueDescription;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, UsageEventMessages.class);
	}

	private UsageEventMessages() {
	}
}