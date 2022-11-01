package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.junit.Assert;
import org.junit.Test;

public class QNameParserTest {

    private static final String SCHEMA = "schema";
    private static final String TABLE = "table";
    private static final Object COLUMN = "column";

    @Test
    public void testParseSchemaBothQuoted() {
        Assert.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\"").getSchemaName());
    }

    @Test
    public void testParseSchemaFirstQuoted() {
        Assert.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".table").getSchemaName());
    }

    @Test
    public void testParseSchemaSecondQuoted() {
        Assert.assertEquals(SCHEMA, QNameParser.parsePg("schema.\"table\"").getSchemaName());
    }

    @Test
    public void testParseSchemaNoneQuoted() {
        Assert.assertEquals(SCHEMA, QNameParser.parsePg("schema.table").getSchemaName());
    }

    @Test
    public void testParseSchemaThreeQuoted() {
        Assert.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getSchemaName());
    }

    @Test
    public void testParseObjectBothQuoted() {
        Assert.assertEquals(TABLE, QNameParser.parsePg("\"schema\".\"table\"").getFirstName());
    }

    public void testParseObjectFirstQuoted() {
        Assert.assertEquals(TABLE, QNameParser.parsePg("\"schema\".table").getFirstName());
    }

    @Test
    public void testParseObjectSecondQuoted() {
        Assert.assertEquals(TABLE, QNameParser.parsePg("schema.\"table\"").getFirstName());
    }

    @Test
    public void testParseObjectNoneQuoted() {
        Assert.assertEquals(TABLE, QNameParser.parsePg("schema.table").getFirstName());
    }

    @Test
    public void testParseObjectThreeQuoted() {
        Assert.assertEquals(COLUMN, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getFirstName());
    }
}
