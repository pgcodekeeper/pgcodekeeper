package ru.taximaxim.codekeeper.apgdiff.localizations;

import org.eclipse.osgi.util.NLS;

@javax.annotation.Generated("externalized-strings")
public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.apgdiff.localizations.messages"; //$NON-NLS-1$

// SONAR-OFF

    // common 
    public static String UsageHelp;
    public static String Version;
    public static String UnknownDBFormat;
    
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
    
    // pgdiff
    public static String Argument_ErrorUnknownOption;
    public static String Database_NewDatabaseIgnoredStatements;
    public static String Database_OriginalDatabaseIgnoredStatements;
    public static String Table_TypeParameterChange;
    public static String Storage_WarningUnableToDetermineStorageType;
    
    // pgdiff/loader    
    public static String Loader_CannotReadFile;
    public static String Loader_EndOfStatementNotFound;
    public static String Loader_FileNotFound;
    public static String Loader_UnsupportedEncoding;  
    
    // pgdiff/parsers
    public static String Parser_CannotFindColumnInTable;
    public static String Parser_CannotFindFunction;
    public static String Parser_CannotFindObject;
    public static String Parser_CannotFindSchema;
    public static String Parser_CannotFindSequence;
    public static String Parser_CannotFindTable;
    public static String Parser_CannotFindTableColumn;
    public static String Parser_CannotFindView;
    public static String Parser_CannotParseStringExpectedDataType;
    public static String Parser_CannotParseStringExpectedExpression;
    public static String Parser_CannotParseStringExpectedInteger;
    public static String Parser_CannotParseStringExpectedString;
    public static String Parser_CannotParseStringExpectedWord;
    public static String Parser_CannotParseStringUnsupportedCommand;
    
// SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
