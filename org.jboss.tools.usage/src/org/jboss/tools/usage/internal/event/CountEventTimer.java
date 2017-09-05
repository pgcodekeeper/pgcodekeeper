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
package org.jboss.tools.usage.internal.event;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.jboss.tools.usage.event.UsageReporter;

/**
 * @author Alexey Kazakov
 */
public class CountEventTimer {

	private static final long PERIOD = 1000*60*60*24;

	private static final CountEventTimer INSTANCE = new CountEventTimer();

	private Job job;

	private CountEventTimer() {
	}

	public static CountEventTimer getInstance() {
		return INSTANCE;
	}

	public synchronized void start() {
		if (job == null) {
			job = new Job("Daily usage event reporting") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						UsageReporter.getInstance().trackCountEvents();
						return Status.OK_STATUS;
					} finally {
						job.schedule(PERIOD);
					}
				}
			};
			job.setSystem(true);
			job.schedule(PERIOD);
		}
	}

	public synchronized void stop() {
		if (job != null) {
			job.cancel();
			job = null;
		}
	}
}