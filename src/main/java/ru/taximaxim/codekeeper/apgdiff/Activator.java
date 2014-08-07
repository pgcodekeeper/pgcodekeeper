package ru.taximaxim.codekeeper.apgdiff;

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
    
    private static BundleContext bundleContext;
    
    private static ServiceTracker<ExtendedLogService, ExtendedLogService> logTracker;
    
    public static ServiceTracker<ExtendedLogService, ExtendedLogService> getLogTracker() {
        return logTracker;
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        bundleContext = context;
        logTracker = new ServiceTracker<>(context, ExtendedLogService.class, null);
        logTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if(logTracker != null) {
            logTracker.close();
        }
    }

    /**
     * @return a Map in which keys are bundle names
     * and values are Lists of available versions for those bundles
     */
    public static Map<String, List<String>> getPluginVersions() {
        Bundle[] bundles = bundleContext.getBundles();
        
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
