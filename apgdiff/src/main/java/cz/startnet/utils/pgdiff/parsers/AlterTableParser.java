/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * Parses ALTER TABLE statements.
 *
 * @author fordfrog
 */
public final class AlterTableParser {
    
    private static final String ALTER_TABLE = "ALTER TABLE ";

    /**
     * Parses ALTER TABLE statement.
     *
     * @param database                database
     * @param statement               ALTER TABLE statement
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     */
    public static void parse(final PgDatabase database,
            final String statement, final boolean outputIgnoredStatements,
            final String searchPath) {
        final Parser parser = new Parser(statement);
        parser.expect("ALTER", "TABLE");
        parser.expectOptional("ONLY");

        final String tableName = parser.parseIdentifier();
        final String schemaName =
                ParserUtils.getSchemaName(tableName, database);
        final PgSchema schema = database.getSchema(schemaName);

        if (schema == null) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotFindSchema, schemaName,
                    statement));
        }

        final String objectName = ParserUtils.getObjectName(tableName);
        final PgTable table = schema.getTable(objectName);

        if (table == null) {
            final PgView view = schema.getView(objectName);

            if (view != null) {
                parseView(parser, view);
                return;
            }

            final PgSequence sequence = schema.getSequence(objectName);

            if (sequence != null) {
                parseSequence(parser, sequence);
                return;
            }

            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotFindObject, tableName,
                    statement));
        }

        while (!parser.expectOptional(";")) {
            if (parser.expectOptional("ALTER")) {
                parseAlterColumn(parser, table);
            } else if (parser.expectOptional("CLUSTER", "ON")) {
                table.getIndex(
                        ParserUtils.getObjectName(parser.parseIdentifier()))
                        .setClusterIndex(true);
            } else if (parser.expectOptional("OWNER", "TO")) {
                table.setOwner(parser.parseIdentifier());
            } else if (parser.expectOptional("ADD")) {
                if (parser.expectOptional("CONSTRAINT")) {
                    parseAddConstraint(parser, table, searchPath);
                } else {
                    parser.throwUnsupportedCommand();
                }
            } else if (parser.expectOptional("ENABLE")) {
                parseEnable(
                        parser, outputIgnoredStatements, tableName, database);
            } else if (parser.expectOptional("DISABLE")) {
                parseDisable(
                        parser, outputIgnoredStatements, tableName, database);
            } else {
                parser.throwUnsupportedCommand();
            }

            if (parser.expectOptional(";")) {
                break;
            } else {
                parser.expect(",");
            }
        }
    }

    /**
     * Parses ENABLE statements.
     *
     * @param parser                  parser
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     * @param tableName               table name as it was specified in the
     *                                statement
     * @param database                database information
     */
    private static void parseEnable(final Parser parser,
            final boolean outputIgnoredStatements, final String tableName,
            final PgDatabase database) {
        if (parser.expectOptional("REPLICA")) {
            if (parser.expectOptional("TRIGGER")) {
                if (outputIgnoredStatements) {
                    database.addIgnoredStatement(ALTER_TABLE + tableName
                            + " ENABLE REPLICA TRIGGER "
                            + parser.parseIdentifier() + ';');
                } else {
                    parser.parseIdentifier();
                }
            } else if (parser.expectOptional("RULE")) {
                if (outputIgnoredStatements) {
                    database.addIgnoredStatement(ALTER_TABLE + tableName
                            + " ENABLE REPLICA RULE "
                            + parser.parseIdentifier() + ';');
                } else {
                    parser.parseIdentifier();
                }
            } else {
                parser.throwUnsupportedCommand();
            }
        } else if (parser.expectOptional("ALWAYS")) {
            if (parser.expectOptional("TRIGGER")) {
                if (outputIgnoredStatements) {
                    database.addIgnoredStatement(ALTER_TABLE + tableName
                            + " ENABLE ALWAYS TRIGGER "
                            + parser.parseIdentifier() + ';');
                } else {
                    parser.parseIdentifier();
                }
            } else if (parser.expectOptional("RULE")) {
                if (outputIgnoredStatements) {
                    database.addIgnoredStatement(ALTER_TABLE + tableName
                            + " ENABLE RULE " + parser.parseIdentifier() + ';');
                } else {
                    parser.parseIdentifier();
                }
            } else {
                parser.throwUnsupportedCommand();
            }
        }
    }

    /**
     * Parses DISABLE statements.
     *
     * @param parser                  parser
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     * @param tableName               table name as it was specified in the
     *                                statement
     * @param database                database information
     */
    private static void parseDisable(final Parser parser,
            final boolean outputIgnoredStatements, final String tableName,
            final PgDatabase database) {
        if (parser.expectOptional("TRIGGER")) {
            if (outputIgnoredStatements) {
                database.addIgnoredStatement(ALTER_TABLE + tableName
                        + " DISABLE TRIGGER " + parser.parseIdentifier() + ';');
            } else {
                parser.parseIdentifier();
            }
        } else if (parser.expectOptional("RULE")) {
            if (outputIgnoredStatements) {
                database.addIgnoredStatement(ALTER_TABLE + tableName
                        + " DISABLE RULE " + parser.parseIdentifier() + ';');
            } else {
                parser.parseIdentifier();
            }
        } else {
            parser.throwUnsupportedCommand();
        }
    }

    /**
     * Parses ADD CONSTRAINT action.
     *
     * @param parser parser
     * @param table  table
     * @param schema schema
     */
    private static void parseAddConstraint(final Parser parser,
            final PgTable table, final String searchPath) {
        final String constraintName =
                ParserUtils.getObjectName(parser.parseIdentifier());
        final PgConstraint constraint = new PgConstraint(constraintName, null);
        int posBefore = parser.getPosition();
        if (parser.expectOptional("FOREIGN", "KEY")){
            parseAddConstraintForeignKey(parser, table, constraint);
        }
        parser.setPosition(posBefore);
        constraint.setDefinition(parser.getExpression());
        constraint.setTableName(table.getName());
        table.addConstraint(constraint);
    }

    /**
     * Parses ALTER COLUMN action.
     *
     * @param parser parser
     * @param table  pg table
     */
    private static void parseAlterColumn(final Parser parser,
            final PgTable table) {
        parser.expectOptional("COLUMN");

        final String columnName =
                ParserUtils.getObjectName(parser.parseIdentifier());
        
        PgColumn column = table.getColumn(columnName);
        if (column == null) {
            // костыль
            // ignore columns not found in inherited tables
            // as they are not correctly supported
            if(!table.getInherits().isEmpty()) {
                // consume the statement into a fake column object
                column = new PgColumn(columnName);
            }
            
            // if table is not inherited throw an error as we're supposed to
            else {
                throw new ParserException(MessageFormat.format(
                        Messages.Parser_CannotFindTableColumn,
                        columnName, table.getName(), parser.getString()));
            }
        }

        if (parser.expectOptional("SET")) {
            if (parser.expectOptional("STATISTICS")) {
                column.setStatistics(parser.parseInteger());
            } else if (parser.expectOptional("DEFAULT")) {
                String defaultValue = parser.getExpression();
                column.setDefaultValue(defaultValue);
                if (column.getParent() != null) {
                    table.addSequence(column.parseSequence(defaultValue));
                }
            } else if (parser.expectOptional("STORAGE")) {
                if (parser.expectOptional("PLAIN")) {
                    column.setStorage("PLAIN");
                } else if (parser.expectOptional("EXTERNAL")) {
                    column.setStorage("EXTERNAL");
                } else if (parser.expectOptional("EXTENDED")) {
                    column.setStorage("EXTENDED");
                } else if (parser.expectOptional("MAIN")) {
                    column.setStorage("MAIN");
                } else {
                    parser.throwUnsupportedCommand();
                }
            } else {
                parser.throwUnsupportedCommand();
            }
        } else {
            parser.throwUnsupportedCommand();
        }
    }

    /**
     * Parses ADD CONSTRAINT constrName FOREIGN KEY action.
     *
     * @param parser parser
     * @param table  pg table
     * @param searchPath searchPath
     * @param constraint 
     */
    private static void parseAddConstraintForeignKey(final Parser parser,
            final PgTable table, PgConstraint constraint) {
        parser.expect("(");

        // parse dependent column names
        while (!parser.expectOptional(")")) {
            // consume referencing column name
            ParserUtils.getObjectName(parser.parseIdentifier());
            
            if (parser.expectOptional(")")) {
                break;
            } else {
                parser.expect(",");
            }
        }// end parse

        parser.expect("REFERENCES");
        String ref = parser.parseIdentifier();
        
        String schemaName = ParserUtils.getSchemaName(ref,
                (PgDatabase) table.getParent().getParent());
        String tableName = ParserUtils.getObjectName(ref);
        
        parser.expect("(");
        
        // parse referenced column names
        while (!parser.expectOptional(")")) {
            constraint.addForeignColumn(new GenericColumn(schemaName, tableName,
                            ParserUtils.getObjectName(parser.parseIdentifier())));
            
            if (parser.expectOptional(")")) {
                break;
            } else {
                parser.expect(",");
            }
        }// end parse
    }
    
    /**
     * Parses ALTER TABLE view.
     *
     * @param parser                  parser
     * @param view                    view
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     * @param viewName                view name as it was specified in the
     *                                statement
     * @param database                database information
     */
    private static void parseView(final Parser parser, final PgView view) {
        while (!parser.expectOptional(";")) {
            if (parser.expectOptional("ALTER")) {
                parser.expectOptional("COLUMN");

                final String columnName =
                        ParserUtils.getObjectName(parser.parseIdentifier());

                if (parser.expectOptional("SET", "DEFAULT")) {
                    final String expression = parser.getExpression();
                    view.addColumnDefaultValue(columnName, expression);
                } else if (parser.expectOptional("DROP", "DEFAULT")) {
                    view.removeColumnDefaultValue(columnName);
                } else {
                    parser.throwUnsupportedCommand();
                }
            } else if (parser.expectOptional("OWNER", "TO")) {
                view.setOwner(parser.parseIdentifier());
            } else {
                parser.throwUnsupportedCommand();
            }
        }
    }

    /**
     * Parses ALTER TABLE sequence.
     *
     * @param parser                  parser
     * @param sequence                sequence
     * @param outputIgnoredStatements whether ignored statements should be
     *                                output in the diff
     * @param sequenceName            sequence name as it was specified in the
     *                                statement
     * @param database                database information
     */
    private static void parseSequence(Parser parser, PgSequence sequence) {
        while (!parser.expectOptional(";")) {
            if (parser.expectOptional("OWNER", "TO")) {
                sequence.setOwner(parser.parseIdentifier());
            } else {
                parser.throwUnsupportedCommand();
            }
        }
    }

    /**
     * Creates a new instance of AlterTableParser.
     */
    private AlterTableParser() {
    }
}
