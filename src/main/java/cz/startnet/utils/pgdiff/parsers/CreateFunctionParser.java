/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.Resources;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;

/**
 * Parses CREATE FUNCTION and CREATE OR REPLACE FUNCTION statements.
 *
 * @author fordfrog
 */
public final class CreateFunctionParser {
    
    private static final String[] RETURNS_TERMINATORS = {
        "LANGUAGE",
        "WINDOW",
        "IMMUTABLE", "STABLE", "VOLATILE", "NOT", "LEAKPROOF",
        "CALLED", "RETURNS", "STRICT",
        "EXTERNAL", "SECURITY",
        "COST",
        "ROWS",
        "SET",
        "AS"
    };

    /**
     * Parses CREATE FUNCTION and CREATE OR REPLACE FUNCTION statement.
     *
     * @param database  database
     * @param statement CREATE FUNCTION statement
     */
    public static void parse(final PgDatabase database,
            final String statement, final String searchPath) {
        final Parser parser = new Parser(statement);
        parser.expect("CREATE");
        parser.expectOptional("OR", "REPLACE");
        parser.expect("FUNCTION");

        final String functionName = parser.parseIdentifier();
        final String schemaName =
                ParserUtils.getSchemaName(functionName, database);
        final PgSchema schema = database.getSchema(schemaName);

        if (schema == null) {
            throw new ParserException(MessageFormat.format(
                    Resources.getString("CannotFindSchema"), schemaName,
                    statement));
        }

        final PgFunction function = new PgFunction(
                ParserUtils.getObjectName(functionName), statement, searchPath);
        schema.addFunction(function);
        
        parseArguments(parser, function);
        
        parseReturns(parser, function);
        
        function.setBody(parser.getRest());
    }
    
    static void parseReturns(Parser parser, PgFunction function) {
        int posBefore = parser.getPosition();
        if (parser.expectOptional("RETURNS")) {
            if (parser.expectOptional("NULL", "ON", "NULL", "INPUT")) {
                // in case function does not return a value 
                // and the args are immediately followed by RETURNS NULL ON NULL INPUT
                
                // also reset position
                // because this clause should be stored in body not consumed and lost
                parser.setPosition(posBefore);
            } else {
                function.setReturns(parser.getExpression(RETURNS_TERMINATORS));
            }
        }
    }

    public static void parseArguments(Parser parser, PgFunction function) {
        parser.expect("(");

        while (!parser.expectOptional(")")) {
            final String mode;

            if (parser.expectOptional("IN")) {
                mode = "IN";
            } else if (parser.expectOptional("OUT")) {
                mode = "OUT";
            } else if (parser.expectOptional("INOUT")) {
                mode = "INOUT";
            } else if (parser.expectOptional("VARIADIC")) {
                mode = "VARIADIC";
            } else {
                mode = null;
            }

            final int position = parser.getPosition();
            String argumentName = null;
            String dataType = parser.parseDataType();

            final int position2 = parser.getPosition();

            if (!parser.expectOptional(")") && !parser.expectOptional(",")
                    && !parser.expectOptional("=")
                    && !parser.expectOptional("DEFAULT")) {
                parser.setPosition(position);
                argumentName = ParserUtils.getObjectName(parser.parseIdentifier());
                dataType = parser.parseDataType();
            } else {
                parser.setPosition(position2);
            }

            final String defaultExpression;

            if (parser.expectOptional("=") || parser.expectOptional("DEFAULT")) {
                defaultExpression = parser.getExpression();
            } else {
                defaultExpression = null;
            }

            final PgFunction.Argument argument = new PgFunction.Argument();
            argument.setDataType(dataType);
            argument.setDefaultExpression(defaultExpression);
            argument.setMode(mode);
            argument.setName(argumentName);
            function.addArgument(argument);

            if (parser.expectOptional(")")) {
                break;
            } else {
                parser.expect(",");
            }
        }
    }

    /**
     * Creates a new instance of CreateFunctionParser.
     */
    private CreateFunctionParser() {
    }
}
