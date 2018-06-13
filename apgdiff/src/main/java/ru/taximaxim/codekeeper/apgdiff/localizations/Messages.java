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

    // pgdiff.parsers.antlr.statements

    public static String ParserAbstract_no_schema;

    // pgdiff

    public static String JdbcConnector_in_jdbc_connection;

    public static String JdbcReader_helper_function_error;
    public static String Table_TypeParameterChange;
    public static String Storage_WarningUnableToDetermineStorageType;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
