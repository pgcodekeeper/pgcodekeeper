package ru.taximaxim.codekeeper.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.equinox.log.ExtendedLogService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private static ServiceTracker<ExtendedLogService, ExtendedLogService> logTracker;
    
    private static BundleContext context;

    public static BundleContext getContext() {
        return context;
    }

    public static ServiceTracker<ExtendedLogService,ExtendedLogService> getLogTracker() {
        return logTracker;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        logTracker = new ServiceTracker<>(context, ExtendedLogService.class, null);
        logTracker.open();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        if (logTracker != null){
            logTracker.close();
        }
    }
    
    /**
     * @return a Map in which keys are bundle names
     * and values are Lists of available versions for those bundles
     */
    public static Map<String, List<String>> getPluginVersions() {
        Bundle[] bundles = context.getBundles();
        
        Map<String, List<String>> versions = new HashMap<>(bundles.length);
        
        for (Bundle b : bundles) {
            List<String> versionSet = versions.get(b.getSymbolicName());
            if (versionSet == null) {
                versionSet = new ArrayList<String>(1);
                versions.put(b.getSymbolicName(), versionSet);
            }
            
            versionSet.add(b.getVersion().toString());
        }
        
        return versions;
    }
}
