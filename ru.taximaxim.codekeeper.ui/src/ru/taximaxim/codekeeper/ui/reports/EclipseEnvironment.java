package ru.taximaxim.codekeeper.ui.reports;

import java.text.MessageFormat;
import java.util.Random;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.Bundle;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.USAGE_REPORT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class EclipseEnvironment {

    private static final String ECLIPSE_RUNTIME_BULDEID = "org.eclipse.core.runtime"; //$NON-NLS-1$

    private static final String USERAGENT_WIN = "{0}/{1} (Windows; U; Windows NT {2};)"; //$NON-NLS-1$
    private static final String USERAGENT_WIN_64 = "{0}/{1} (Windows; U; Windows NT {2}; Win64; x64;)"; //$NON-NLS-1$
    private static final String USERAGENT_MAC = "{0}/{1} (Macintosh; U; Intel Mac OS X {2};)"; //$NON-NLS-1$
    private static final String USERAGENT_LINUX = "{0}/{1} (X11; U; Linux i686;)"; //$NON-NLS-1$
    private static final String USERAGENT_LINUX_64 = "{0}/{1} (X11; U; Linux x86_64;)"; //$NON-NLS-1$

    public static final char VERSION_DELIMITER = '.';

    private static final String PROP_OS_VERSION = "os.version"; //$NON-NLS-1$
    private static final String PROP_SUN_ARCH = "sun.arch.data.model"; //$NON-NLS-1$

    private static final CharSequence ARCHITECTURE_64 = "64";


    private static final String NOT_INSTALLED = "N/A";  //$NON-NLS-1$
    private static final String TRUE = "true";  //$NON-NLS-1$
    private static final String FALSE = "false";  //$NON-NLS-1$
    private static final String SYSPROP_JAVA_NAME = "java.vm.name";
    private static final String SHOW_BOX_ON_STARTUP = "showBoxOnStartup"; //$NON-NLS-1$
    private String keyWord;

    // move to keeper preference?
    private final IEclipsePreferences preferences = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID.THIS);

    private String firstVisit;
    private String lastVisit;
    private String currentVisit;
    private long visitCount;
    private boolean justInitialized = true;

    public EclipseEnvironment() {
        initVisits();
    }

    public String getKeyword() {
        if(keyWord == null) {
            keyWord = getComponentIds();
        }
        return keyWord;
    }

    private String getComponentIds() {
        String featureId = "ru.taximaxim.codekeeper.feature";
        String pluginId = "ru.taximaxim.codekeeper.ui";
        String pluginName = "codekeeperUI";

        if (Platform.getBundle(pluginId) != null) {
            return pluginName;
        } else {
            for (IBundleGroupProvider bundleGroupProvider : Platform.getBundleGroupProviders()) {
                for (IBundleGroup group : bundleGroupProvider.getBundleGroups()) {
                    if (group.getIdentifier().equals(featureId)) {
                        return pluginName;
                    }
                }
            }
        }

        return "";
    }

    public String getUserId() {
        String userId = preferences.get(USAGE_REPORT_PREF.ECLIPSE_INSTANCE_ID, null);
        if (userId == null) {
            userId = createIdentifier();
            preferences.put(USAGE_REPORT_PREF.ECLIPSE_INSTANCE_ID, userId);
            try {
                preferences.flush();
            } catch (BackingStoreException e) {
                Log.log(Log.LOG_ERROR,  Messages.EclipseEnvironment_Error_SavePreferences, e);
            }
        }
        return userId;
    }

    /**
     * Creates an unique identifier.
     *
     * @return the identifier
     */
    private String createIdentifier() {
        StringBuilder builder = new StringBuilder();
        builder.append(Math.abs(new Random().nextLong()));
        builder.append(System.currentTimeMillis());
        return builder.toString();
    }

    public synchronized String getCurrentVisit() {
        return currentVisit;
    }

    public synchronized String getFirstVisit() {
        return firstVisit;
    }

    public synchronized String getLastVisit() {
        return lastVisit;
    }

    public synchronized long getVisitCount() {
        return visitCount;
    }

    public synchronized void startNewVisitSession() {
        // Check if we need to start a new visit session since it might have already been started during initialization
        if (!justInitialized) {
            initVisits();
        }
        justInitialized = false;
    }

    public String getJavaVmName() {
        return System.getProperty(SYSPROP_JAVA_NAME);
    }

    private void initVisits() {
        String currentTime = String.valueOf(System.currentTimeMillis());
        this.currentVisit = currentTime;
        this.firstVisit = preferences.get(USAGE_REPORT_PREF.FIRST_VISIT, null);
        if (firstVisit == null) {
            this.firstVisit = currentTime;
            preferences.put(USAGE_REPORT_PREF.FIRST_VISIT, firstVisit);
        }
        lastVisit = preferences.get(USAGE_REPORT_PREF.LAST_VISIT, currentTime);
        visitCount = preferences.getLong(USAGE_REPORT_PREF.VISIT_COUNT, 1);

        preferences.put(USAGE_REPORT_PREF.LAST_VISIT, currentTime);
        preferences.putLong(USAGE_REPORT_PREF.VISIT_COUNT, visitCount+1);
        try {
            preferences.flush();
        } catch (BackingStoreException e) {
            Log.log(Log.LOG_ERROR, Messages.EclipseEnvironment_Error_SavePreferences, e);
        }
    }

    public String getEventValue() {
        Bundle bundle = Platform.getBundle(PLUGIN_ID.THIS);
        if (bundle == null) {
            return NOT_INSTALLED;
        }
        IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(PLUGIN_ID.THIS);
        boolean showOnStartup = prefs.getBoolean(SHOW_BOX_ON_STARTUP, true);
        if (showOnStartup) {
            return TRUE;
        }
        return FALSE;
    }

    public String getOSVersion() {
        return System.getProperty(PROP_OS_VERSION);
    }

    private String getUserAgentPattern() {
        String os = Platform.getOS();
        if (Platform.OS_LINUX.equals(os)) {
            if (is64()) {
                return USERAGENT_LINUX_64;
            } else {
                return USERAGENT_LINUX;
            }
        } else if (Platform.OS_MACOSX.equals(os)) {
            return USERAGENT_MAC;
        } else if (Platform.OS_WIN32.equals(os)) {
            if (is64()) {
                return USERAGENT_WIN_64;
            } else {
                return USERAGENT_WIN;
            }
        }
        return ""; //$NON-NLS-1$
    }

    /**
     * Returns <code>true</code> if the jvm this is running in is a 64bit jvm.
     *
     * @param architecture
     * @return
     *
     * @see <a href="// http://stackoverflow.com/questions/807263/how-do-i-detect-which-kind-of-jre-is-installed-32bit-vs-64bit">stackoverflow</a>
     */
    private boolean is64() {
        String architecture = System.getProperty(PROP_SUN_ARCH);
        return architecture != null && architecture.equals(ARCHITECTURE_64);
    }

    public String getApplicationName() {
        return getApplicationBundle().getSymbolicName();
    }

    public String getApplicationVersion() {
        String fullVersion = getApplicationBundle().getVersion().toString();
        int productVersionStart = fullVersion.lastIndexOf(VERSION_DELIMITER);
        if (productVersionStart > 0) {
            return fullVersion.substring(0, productVersionStart);
        } else {
            return fullVersion;
        }
    }

    /**
     * Returns the bundle that launched the application that this class runs in.
     *
     * @return the defining bundle
     */
    private Bundle getApplicationBundle() {
        IProduct product = Platform.getProduct();
        if (product != null) {
            return product.getDefiningBundle();
        } else {
            return Platform.getBundle(ECLIPSE_RUNTIME_BULDEID);
        }
    }

    public String getUserAgent() {
        return MessageFormat.format(getUserAgentPattern(), getApplicationName(),
                getApplicationVersion(), getOSVersion());
    }

}