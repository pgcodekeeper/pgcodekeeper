package cz.startnet.utils.pgdiff.parsers;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;

/**
 * Parses CREATE EXTENSION statements.
 *
 * @author Alexander Levsha
 */
public final class CreateExtensionParser {
    
    /**
     * Parses CREATE EXTENSION statement.
     * 
     * @param database database
     * @param statement CREATE EXTENSION statement
     */
    public static void parse(final PgDatabase database,
            final String statement) {
        final Parser parser = new Parser(statement);
        parser.expect("CREATE", "EXTENSION");
        
        parser.expectOptional("IF", "NOT", "EXISTS");
        
        final PgExtension ext = new PgExtension(
                ParserUtils.getObjectName(parser.parseIdentifier()), statement);
        database.addExtension(ext);
        
        parser.expectOptional("WITH");
        
        if(parser.expectOptional("SCHEMA")) {
            ext.setSchema(ParserUtils.getObjectName(parser.parseIdentifier()));
        }
        
        if(parser.expectOptional("VERSION")) {
            ext.setVersion(parser.parseString());
        }
        
        if(parser.expectOptional("FROM")) {
            ext.setOldVersion(parser.parseString());
        }
    }
    
    private CreateExtensionParser() {
    }
}
