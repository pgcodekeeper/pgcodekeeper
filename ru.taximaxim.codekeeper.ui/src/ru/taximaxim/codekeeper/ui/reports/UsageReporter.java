package ru.taximaxim.codekeeper.ui.reports;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.USAGE_REPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.reports.EventRegister.Result;

public class UsageReporter {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    public static final String NOT_APPLICABLE_LABEL = "N/A"; //$NON-NLS-1$

    private static final String PATH_PREFIX = "/tools/"; //$NON-NLS-1$

    private static final UsageReporter INSTANCE = new UsageReporter();

    private UsageRequest usageRequest;
    private final Lock lockToAskUser = new ReentrantLock();

    public static UsageReporter getInstance() {
        return INSTANCE;
    }

    /**
     * Registers the event type
     *
     * @param type
     */
    public void registerEvent(final UsageEventType type) {
        try {
            EventRegister.getInstance().registerEvent(type);
            if (isEnabled()) {
                ReportingJob job = new ReportingJob() {

                    @Override
                    public void report() {
                        checkCountEventInternal(type);
                    }
                };
                job.schedule();
            }
        } catch(Exception t) {
            // Catch all Exceptions to make sure, in case of bugs, Usage doesn't prevent JBT from working
            Log.log(Log.LOG_ERROR, t.getMessage());
        }
    }

    /**
     * Tracks a user's event
     */
    public void trackEvent(final String pagePath,
            final String title,
            final UsageEvent event,
            final boolean startNewVisitSession) {
        try {
            if (isEnabled()) {
                ReportingJob job = new ReportingJob() {

                    @Override
                    public void report() {
                        if (isEnabled()) {
                            sendRequest(pagePath, title, event, startNewVisitSession, false);
                        }
                    }
                };
                job.schedule();
            }
        } catch(Exception t) {
            // Catch all Exceptions to make sure, in case of bugs, Usage doesn't prevent JBT from working
            Log.log(Log.LOG_ERROR, t.getMessage());
        }
    }

    /**
     * Sends a tracking request for all daily events if it's time to send them
     */
    public void trackCountEvents() {
        try {
            if (isEnabled()) {
                ReportingJob job = new ReportingJob() {

                    @Override
                    public void report() {
                        for (UsageEventType type : EventRegister.getInstance().getRegisteredEventTypes()) {
                            checkCountEventInternal(type);
                        }
                    }
                };
                job.schedule();
            }
        } catch(Exception t) {
            // Catch all Exceptions to make sure, in case of bugs, Usage doesn't prevent JBT from working
            Log.log(Log.LOG_ERROR, t.getMessage());
        }
    }

    private boolean isEnabled() {
        return mainPrefs.getBoolean(USAGE_REPORT_PREF.USAGEREPORT_ENABLED_ID);
    }

    /**
     * Checks if the corresponding daily event should be sent. If yes then that daily event(s) is sent.
     * @param type
     * @return the number of sent events
     */
    private int checkCountEventInternal(UsageEventType type) {
        int sent = 0;
        if (isEnabled()) {
            Set<Result> results = EventRegister.getInstance().checkCountEvent(type);
            for (Result result : results) {
                if (result.isOkToSend()) {
                    int value = result.getPreviousSumOfValues();
                    String label = result.getCountEventLabel();
                    UsageEvent event = type.event(label, value);
                    if (getUsageRequest().sendRequest(getPagePath(event), event.getType().getComponentName(), event, false)) {
                        sent++;
                    }
                }
            }
        }
        return sent;
    }

    /**
     * Sends a tracking request
     * @param environment
     * @param pagePath
     * @param title may be null
     * @param event may not be null if onceADayOnly==true
     * @param type if null, RequestType.PAGE is used
     * @param startNewVisitSession if false, the current session from environment is used
     * @param onceADayOnly if true, send a request only once a day
     */
    private synchronized void sendRequest(String pagePath,
            String title,
            UsageEvent event,
            boolean startNewVisitSession,
            boolean onceADayOnly) {
        UsageEvent ev = onceADayOnly ? event.copy() : event;
        if (onceADayOnly) {
            if (ev.getLabel() == null) {
                ev.setLabel(UsageReporter.NOT_APPLICABLE_LABEL);
            }
            if (ev.getValue() == null) {
                ev.setValue(1);
            }
        }
        EventRegister.Result result = EventRegister.getInstance().checkTrackData(ev, onceADayOnly);
        if (result.isOkToSend()) {
            int value = result.getPreviousSumOfValues();
            if (onceADayOnly && value > 0) {
                ev.setValue(value);
                ev.setLabel(result.getCountEventLabel());
            }
            getUsageRequest().sendRequest(pagePath, title, ev, startNewVisitSession);
        }
    }

    private String getPagePath(UsageEvent event) {
        return PATH_PREFIX + event.getType().getComponentName() + "/" + event.getType().getComponentVersion(); //$NON-NLS-1$
    }

    private UsageRequest getUsageRequest() {
        if(usageRequest == null) {
            usageRequest = new UsageRequest();
        }
        return usageRequest;
    }

    private abstract class ReportingJob extends Job {

        private ReportingJob() {
            super(Messages.UsageReport_Reporting_Usage);
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            if (monitor.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
            monitor.beginTask(Messages.UsageReport_Querying_Enablement, 2);

            if (monitor.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
            monitor.worked(1);
            try {
                lockToAskUser.lock();

                if (mainPrefs.getBoolean(USAGE_REPORT_PREF.ASK_USER_USAGEREPORT_ID)) {
                    if (monitor.isCanceled()) {
                        return Status.CANCEL_STATUS;
                    }
                    askUser();
                }
            } finally {
                lockToAskUser.unlock();
            }
            report();
            monitor.worked(2);
            monitor.done();

            return Status.OK_STATUS;
        }

        abstract void report();


        /**
         * Asks the user is he allows us to report usage. Opens a dialog for this sake.
         */
        private void askUser() {

            Display.getDefault().syncExec(() -> {
                Shell shell = PlatformUI.getWorkbench().getModalDialogShellProvider().getShell();
                boolean isEnabled =  MessageDialog.openQuestion(shell,
                        Messages.UsageReport_DialogTitle, Messages.UsageReport_DialogMessage);
                mainPrefs.setValue(USAGE_REPORT_PREF.USAGEREPORT_ENABLED_ID, isEnabled);
                mainPrefs.setValue(USAGE_REPORT_PREF.ASK_USER_USAGEREPORT_ID, false);
            });
        }
    }
}