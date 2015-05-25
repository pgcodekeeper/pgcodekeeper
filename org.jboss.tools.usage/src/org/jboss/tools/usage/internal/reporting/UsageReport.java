/*******************************************************************************
 * Copyright (c) 2010-2012 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.internal.reporting;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.jboss.tools.usage.googleanalytics.GoogleAnalyticsUrlStrategy;
import org.jboss.tools.usage.googleanalytics.IJBossToolsEclipseEnvironment;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.http.HttpGetRequest;
import org.jboss.tools.usage.internal.preferences.GlobalUsageSettings;
import org.jboss.tools.usage.internal.preferences.UsageReportPreferences;
import org.jboss.tools.usage.tracker.IFocusPoint;
import org.jboss.tools.usage.tracker.ITracker;
import org.jboss.tools.usage.tracker.IURLBuildingStrategy;
import org.jboss.tools.usage.tracker.internal.FocusPoint;
import org.jboss.tools.usage.tracker.internal.SuffixFocusPoint;
import org.jboss.tools.usage.tracker.internal.Tracker;
import org.jboss.tools.usage.tracker.internal.UsagePluginLogger;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Andre Dietisheim
 */
public class UsageReport {

	private IFocusPoint focusPoint;

	private GlobalUsageSettings globalSettings;

	private IJBossToolsEclipseEnvironment eclipseEnvironment;

	UsagePluginLogger logger = JBossToolsUsageActivator.getDefault().getLogger();

	public UsageReport() {
		this(JBossToolsUsageActivator.getDefault().getJBossToolsEclipseEnvironment());

	}

	/**
	 * Instantiates a new usage report.
	 * 
	 * @param eclipseEnvironment
	 *            the eclipse environment
	 */
	protected UsageReport(IJBossToolsEclipseEnvironment eclipseEnvironment) {
		this(
				new SuffixFocusPoint("tools", eclipseEnvironment.getJBossToolsVersion()) //$NON-NLS-1$ 
						.setChild(new FocusPoint("usage") //$NON-NLS-1$ 
								.setChild(new FocusPoint("action") //$NON-NLS-1$ 
										.setChild(new FocusPoint("wsstartup")))), //$NON-NLS-1$
				eclipseEnvironment,
				new GlobalUsageSettings(JBossToolsUsageActivator.getDefault()));
	}

	/**
	 * Instantiates a new usage report.
	 * 
	 * @param focusPoint
	 *            the focus point
	 * @param eclipseEnvironment
	 *            the eclipse environment
	 * @param globalSettings
	 *            the global settings
	 */
	protected UsageReport(IFocusPoint focusPoint, IJBossToolsEclipseEnvironment eclipseEnvironment,
			GlobalUsageSettings globalSettings) {
		this.eclipseEnvironment = eclipseEnvironment;
		this.focusPoint = focusPoint;
		this.globalSettings = globalSettings;
	}

	/**
	 * Reports the usage of this eclipse/jboss tools instance.
	 */
	public void report() {
		if (!UsageReportPreferences.isEnablementSet()
				|| UsageReportPreferences.isEnabled()) {
			new ReportingJob().schedule();
		}
	}

	protected boolean isReportingGloballyEnabled() {
		return globalSettings.isReportingEnabled();
	}

	/**
	 * Asks the user is he allows us to report usage. Opens a dialog for this
	 * sake.
	 */
	private void askUser() {
		Boolean isEnabled = askUserForEnablement();
		if (isEnabled != null) {
			UsageReportPreferences.setEnabled(isEnabled);
			UsageReportPreferences.setAskUser(false);
			flushPreferences();
		}
	}

	/**
	 * Checks reporting shall ask the user (which is the case if this was never
	 * done before. Asking user shall only be done once per eclipse
	 * installation)
	 * 
	 * @return true, if is ask user
	 */
	protected boolean isAskUser() {
		return UsageReportPreferences.isAskUser();
	}

	/**
	 * Asks the user if he allows us to report.
	 * 
	 * @return the boolean
	 */
	protected Boolean askUserForEnablement() {
		final Boolean[] userResponse = new Boolean[1];
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Shell shell = PlatformUI.getWorkbench().getModalDialogShellProvider().getShell();
				UsageReportEnablementDialog dialog =
						new UsageReportEnablementDialog(
								shell,
								JBossToolsUsageActivator.getDefault().getUsageBranding());
				if (dialog.open() == Window.OK) {
					userResponse[0] = dialog.isReportEnabled();
				} else {
					userResponse[0] = false;
				}
			}
		});
		return userResponse[0];
	}

	private void flushPreferences() {
		try {
			UsageReportPreferences.flush();
		} catch (BackingStoreException e) {
			logger.error(ReportingMessages.UsageReport_Error_SavePreferences);
		}
	}

	/**
	 * Reports the usage of the current JBoss Tools / JBoss Developer Studio
	 * installation.
	 */
	protected void doReport() {
		if (UsageReportPreferences.isEnabled()) {
			IURLBuildingStrategy urlBuildingStrategy = new GoogleAnalyticsUrlStrategy(eclipseEnvironment);
			ITracker tracker = new Tracker(
					urlBuildingStrategy
					, new HttpGetRequest(eclipseEnvironment.getUserAgent(), logger)
					, logger);
			tracker.trackAsynchronously(focusPoint);
		}
	}

	private class ReportingJob extends Job {

		private ReportingJob() {
			super(ReportingMessages.UsageReport_Reporting_Usage);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.beginTask(ReportingMessages.UsageReport_Querying_Enablement, 2);
			if (isReportingGloballyEnabled()) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				monitor.worked(1);
				if (isAskUser()) {
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					askUser();
				}
				doReport();
				monitor.worked(2);
				monitor.done();
			}
			return Status.OK_STATUS;
		}
	}
}
