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
import org.jboss.tools.usage.googleanalytics.IJBossToolsEclipseEnvironment;
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
				IJBossToolsEclipseEnvironment environment = plugin.getJBossToolsEclipseEnvironment();
				UsageEventType type = new UsageEventType("Pg_codekeeper", version, "Eclipse", platformVer, "Eclipse");
				String label = environment.getEvent().getValue();
				reporter.registerEvent(type);
				String title = getUsedJVM(environment);
				reporter.trackEvent("PgCodekeeper_version_on_startup/" + version, title, type.event(label), RequestType.PAGE, true);

//				type = createFinishWizardType();
//				reporter.registerEvent(type);
//				initWizardListener(type);
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

	private String getUsedJVM(IJBossToolsEclipseEnvironment environment) {
		return "jvm:" + environment.getJavaVmName() + " / " + environment.getJavaBitVersion();
	}

//	public static UsageEventType createFinishWizardType() {
//		JBossToolsUsageActivator plugin = JBossToolsUsageActivator.getDefault();
//		String shortVersion = UsageEventType.getVersion(plugin);
//		return new UsageEventType("usage", shortVersion, "jbt", "finishWizard", "Wizard class name", "How many times the 'Finish' button pressed during the day");
//	}

//	private void initWizardListener(UsageEventType type) {
//		final IWorkbench workbench = PlatformUI.getWorkbench();
//		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
//		window.getShell().addListener(SWT.Deactivate, new WizardListener(type));
//	}
}