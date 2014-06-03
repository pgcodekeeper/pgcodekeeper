package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.Resources;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;

public class AlterSchemaParser {
    
    public static void parse(final PgDatabase database, final String statement,
            final boolean outputIgnoredStatements) {
        Parser p = new Parser(statement);
        p.expect("ALTER", "SCHEMA");

        String schemaName = ParserUtils.getObjectName(p.parseIdentifier());
        PgSchema schema = database.getSchema(schemaName);
        if (schema == null) {
            throw new RuntimeException(MessageFormat.format(
                    Resources.getString("CannotFindSchema"), schemaName,
                    statement));
        }
        
        if (p.expectOptional("OWNER", "TO")) {
            schema.setOwner(p.parseIdentifier());
        } else {
            database.addIgnoredStatement(statement);
        }
    }
    
    private AlterSchemaParser() {
    }
}
