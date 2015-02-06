/**
 * Copyright 2010 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;

/**
 * Parses ALTER SEQUENCE statements.
 *
 * @author mix86
 */
public final class AlterSequenceParser {

    /**
     * Parses ALTER SEQUENCE statement.
     *
     * @param database                database
     * @param statement               ALTER SEQUENCE statement
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     */
    public static void parse(final PgDatabase database,
            final String statement, final boolean outputIgnoredStatements) {
        final Parser parser = new Parser(statement);

        parser.expect("ALTER", "SEQUENCE");

        final String sequenceName = parser.parseIdentifier();
        final String schemaName =
                ParserUtils.getSchemaName(sequenceName, database);
        final PgSchema schema = database.getSchema(schemaName);

        if (schema == null) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotFindSchema, schemaName,
                    statement));
        }

        final String objectName = ParserUtils.getObjectName(sequenceName);
        final PgSequence sequence = schema.getSequence(objectName);

        if (sequence == null) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotFindSequence, sequenceName,
                    statement));
        }

        while (!parser.expectOptional(";")) {

            if (parser.expectOptional("OWNED", "BY")) {
                if (parser.expectOptional("NONE")) {
                    sequence.setOwnedBy(null);
                } else {
                    sequence.setOwnedBy(parser.getExpression());
                }
            } else if (parser.expectOptional("OWNER", "TO")) {
                sequence.setOwner(parser.parseIdentifier());
            } else {
                parser.throwUnsupportedCommand();
            }
        }
    }

    /**
     * Creates new instance of AlterSequenceParser.
     */
    private AlterSequenceParser() {
    }
}
