package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QNameParserTest {

    private static final String SCHEMA = "schema";
    private static final String TABLE = "table";
    private static final Object COLUMN = "column";

    @Test
    void testParseSchemaBothQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\"").getSchemaName());
    }

    @Test
    void testParseSchemaFirstQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".table").getSchemaName());
    }

    @Test
    void testParseSchemaSecondQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("schema.\"table\"").getSchemaName());
    }

    @Test
    void testParseSchemaNoneQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("schema.table").getSchemaName());
    }

    @Test
    void testParseSchemaThreeQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getSchemaName());
    }

    @Test
    void testParseObjectBothQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("\"schema\".\"table\"").getFirstName());
    }

    void testParseObjectFirstQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("\"schema\".table").getFirstName());
    }

    @Test
    void testParseObjectSecondQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("schema.\"table\"").getFirstName());
    }

    @Test
    void testParseObjectNoneQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("schema.table").getFirstName());
    }

    @Test
    void testParseObjectThreeQuoted() {
        Assertions.assertEquals(COLUMN, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getFirstName());
    }
}
