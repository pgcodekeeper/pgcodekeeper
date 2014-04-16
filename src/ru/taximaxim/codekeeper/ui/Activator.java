package ru.taximaxim.codekeeper.ui;

import org.eclipse.equinox.log.ExtendedLogService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private static ServiceTracker<ExtendedLogService, ExtendedLogService> tracker;
    
    private static BundleContext context;

    public static BundleContext getContext() {
        return context;
    }

    public static ServiceTracker<ExtendedLogService,ExtendedLogService> getLogTracker() {
        return tracker;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        tracker = new ServiceTracker<>(context, ExtendedLogService.class, null);
        tracker.open();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        if (tracker != null){
            tracker.close();
        }
    }

}
