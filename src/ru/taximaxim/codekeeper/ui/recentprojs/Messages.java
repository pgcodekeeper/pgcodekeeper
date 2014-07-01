package ru.taximaxim.codekeeper.ui.recentprojs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.recentprojs.messages"; //$NON-NLS-1$
    public static String DynamicMenuRecent_recent_list_is_empty;
    public static String RecentProjects_unexpected_error_while_saving_preferences;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
