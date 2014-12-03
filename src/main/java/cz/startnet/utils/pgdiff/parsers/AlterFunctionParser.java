package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.Resources;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;

public final class AlterFunctionParser {
    
    public static void parse(final PgDatabase database, final String statement,
            final boolean outputIgnoredStatements) {
        Parser p = new Parser(statement);
        p.expect("ALTER", "FUNCTION");
        
        String id = p.parseIdentifier();

        String schemaName = ParserUtils.getSchemaName(id, database);
        PgSchema schema = database.getSchema(schemaName);
        if (schema == null) {
            throw new ParserException(MessageFormat.format(
                    Resources.getString("CannotFindSchema"), schemaName,
                    statement));
        }
        
        String functionName = ParserUtils.getObjectName(id);
        PgFunction tmp = new PgFunction(functionName, null, null);
        CreateFunctionParser.parseArguments(p, tmp);
        
        PgFunction function = schema.getFunction(tmp.getSignature());
        if (function == null) {
            throw new ParserException(MessageFormat.format(
                    Resources.getString("CannotFindFunction"), tmp.getSignature(),
                    statement));
        }
        
        if (p.expectOptional("OWNER", "TO")) {
            function.setOwner(p.parseIdentifier());
        } else {
            database.addIgnoredStatement(statement);
        }
    }
    
    private AlterFunctionParser() {
    }
}
