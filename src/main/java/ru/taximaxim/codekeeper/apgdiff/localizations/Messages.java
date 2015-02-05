package ru.taximaxim.codekeeper.apgdiff.localizations;

import org.eclipse.osgi.util.NLS;

@javax.annotation.Generated("externalized-strings")
public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.apgdiff.localizations.messages"; //$NON-NLS-1$

// SONAR-OFF

    // pgdiff.loader
    public static String Connection_DatabaseJdbcAccessError;
    public static String Connection_JdbcDriverClassNotFound;

    public static String jdbcConnector_error_reading_pgpass_file;
    
    // apgdiff.model.graph
    public static String RefColumn_CannotFindSchema;
    public static String RefColumn_CannotFindTable;
    public static String RefColumn_CannotFindColumn;
    public static String View_CannotFindSchema;
    public static String View_CannotFindColumn;
    
// SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
