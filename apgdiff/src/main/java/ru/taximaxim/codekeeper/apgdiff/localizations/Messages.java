package ru.taximaxim.codekeeper.apgdiff.localizations;

import org.eclipse.osgi.util.NLS;

@javax.annotation.Generated("externalized-strings")
public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.apgdiff.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    // common
    public static String UnknownDBFormat;

    // pgdiff.loader
    public static String Connection_DatabaseJdbcAccessError;
    public static String Connection_JdbcDriverClassNotFound;

    // pgdiff

    public static String JdbcConnector_in_jdbc_connection;
    public static String Table_TypeParameterChange;
    public static String Storage_WarningUnableToDetermineStorageType;

    public static String License_caps_full;

    public static String License_caps_none;

    public static String License_descr_template;

    public static String License_version_any;

    public static String LicensingInternal_current_license;

    public static String LicensingInternal_expired;

    public static String LicensingInternal_inactive;

    public static String LicensingInternal_malformed_license;

    public static String LicensingInternal_no_cli;

    public static String LicensingInternal_no_cli_but_no_gui_present;

    public static String LicensingInternal_no_gui;

    public static String LicensingInternal_no_gui_but_module_present;

    public static String LicensingInternal_schema_objects_exceeded;

    public static String PgDiffArguments_no_license_set;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
