package ru.taximaxim.codekeeper.apgdiff.localizations;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.apgdiff.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    // common
    public static String UnknownDBFormat;

    // pgdiff.loader
    public static String Connection_DatabaseJdbcAccessError;

    public static String Table_TypeParameterChange;
    public static String Storage_WarningUnableToDetermineStorageType;

    public static String XmlStore_read_error;

    public static String XmlStore_root_error;

    public static String XmlStore_write_error;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
