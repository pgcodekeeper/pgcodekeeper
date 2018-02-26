package ru.taximaxim.codekeeper.ui.reports;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

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