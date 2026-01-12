/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.reports;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class CountEventTimer {

    private static final long PERIOD = 1000*60*60*24L;

    private static final CountEventTimer INSTANCE = new CountEventTimer();

    private Job job;

    private CountEventTimer() {
    }

    public static CountEventTimer getInstance() {
        return INSTANCE;
    }

    public synchronized void start() {
        if (job == null) {
            job = new Job("Daily usage event reporting") { //$NON-NLS-1$

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