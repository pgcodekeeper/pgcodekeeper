/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UiSync;

public class UsageReportDispatcher implements IStartup {

    @Override
    public void earlyStartup() {

        UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
            UsageReporter reporter = UsageReporter.getInstance();
            Activator plugin = Activator.getDefault();
            String version = getVersion();
            String platformVer = Platform.getBundle("org.eclipse.platform").getVersion().toString(); //$NON-NLS-1$
            EclipseEnvironment environment = plugin.getEclipseEnvironment();
            UsageEventType type = new UsageEventType("pgCodeKeeper", version, platformVer, null); //$NON-NLS-1$
            String label = environment.getEventValue();
            reporter.registerEvent(type);
            reporter.trackEvent(type.event(label));
            CountEventTimer.getInstance().start();
        });
    }

    private String getVersion() {
        IBundleGroupProvider[] providers = Platform.getBundleGroupProviders();
        if (providers != null) {
            for (IBundleGroupProvider provider : providers) {
                IBundleGroup[] bundleGroups = provider.getBundleGroups();
                for (IBundleGroup group : bundleGroups) {
                    if ("ru.taximaxim.codekeeper.feature".equals(group.getIdentifier())) { //$NON-NLS-1$
                        return group.getVersion();
                    }
                }
            }
        }
        return "version_unavalable"; //$NON-NLS-1$
    }
}