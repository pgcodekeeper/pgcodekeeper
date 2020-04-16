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
            String title = getUsedJVM(environment);
            reporter.trackEvent("pgCodeKeeper_version_on_startup/" + version, title, type.event(label), true); //$NON-NLS-1$
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

    private String getUsedJVM(EclipseEnvironment environment) {
        return "jvm:" + environment.getJavaVmName() + " / "; //$NON-NLS-1$ //$NON-NLS-2$
    }
}