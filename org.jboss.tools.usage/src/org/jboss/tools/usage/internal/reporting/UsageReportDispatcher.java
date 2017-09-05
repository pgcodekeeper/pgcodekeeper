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
package org.jboss.tools.usage.internal.reporting;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.jboss.tools.usage.event.UsageEventType;
import org.jboss.tools.usage.event.UsageReporter;
import org.jboss.tools.usage.googleanalytics.RequestType;
import org.jboss.tools.usage.internal.JBossToolsUsageActivator;
import org.jboss.tools.usage.internal.event.CountEventTimer;

/**
 * @author Andre Dieitsheim
 * @author Alexey Kazakov
 */
public class UsageReportDispatcher implements IStartup {

	@Override
	public void earlyStartup() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				UsageReporter reporter = UsageReporter.getInstance();
				JBossToolsUsageActivator plugin = JBossToolsUsageActivator.getDefault();
				String version = getVersion();
				String platformVer = Platform.getBundle("org.eclipse.platform").getVersion().toString();
				JBossToolsEclipseEnvironment environment = plugin.getJBossToolsEclipseEnvironment();
				UsageEventType type = new UsageEventType("Pg_codekeeper", version, "Eclipse", platformVer, "Eclipse", null);
				String label = environment.getEventValue();
				reporter.registerEvent(type);
				String title = getUsedJVM(environment);
				reporter.trackEvent("PgCodekeeper_version_on_startup/" + version, title, type.event(label), RequestType.PAGE, true);
				CountEventTimer.getInstance().start();
			}
		});
	}

	private String getVersion() {
		IBundleGroupProvider[] providers = Platform.getBundleGroupProviders();
		if (providers != null) {
			for (IBundleGroupProvider provider : providers) {
				IBundleGroup[] bundleGroups = provider.getBundleGroups();
				for (IBundleGroup group : bundleGroups) {
					if (group.getIdentifier().equals("ru.taximaxim.codekeeper.feature")) {
						return group.getVersion();
					}
				}
			}
		}
		return "version_unavalable";
	}

	private String getUsedJVM(JBossToolsEclipseEnvironment environment) {
		return "jvm:" + environment.getJavaVmName() + " / " + environment.getJavaBitVersion();
	}
}