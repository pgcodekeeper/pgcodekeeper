package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
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
                    Messages.Parser_CannotFindSchema, schemaName,
                    statement));
        }
        
        String functionName = ParserUtils.getObjectName(id);
        PgFunction tmp = new PgFunction(functionName, null);
        CreateFunctionParser.parseArguments(p, tmp);
        
        PgFunction function = schema.getFunction(tmp.getSignature());
        if (function == null) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotFindFunction, tmp.getSignature(),
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
