package ru.taximaxim.codekeeper.cli.localizations;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.cli.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    public static String Main_danger_statements;
    public static String UsageHelp;
    public static String Version;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
