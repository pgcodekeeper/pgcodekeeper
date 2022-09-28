/**
 * Copyright 2010 StartNet s.r.o.
 */
package ru.taximaxim.codekeeper.core;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;

/**
 * Tests {@link #ParserUtils}.
 *
 * @author fordfrog
 */
public class PgDiffUtilsTest {
    // SONAR-OFF
    @Test(timeout = 1000)
    public void testParseSchemaBothQuoted() {
        MatcherAssert.assertThat(
                QNameParser.parsePg("\"juzz_system\".\"f_obj_execute_node_select\"").getSchemaName(),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaFirstQuoted() {
        MatcherAssert.assertThat(
                QNameParser.parsePg("\"juzz_system\".f_obj_execute_node_select").getSchemaName(),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaSecondQuoted() {
        MatcherAssert.assertThat(
                QNameParser.parsePg("juzz_system.\"f_obj_execute_node_select\"").getSchemaName(),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaNoneQuoted() {
        MatcherAssert.assertThat(
                QNameParser.parsePg("juzz_system.f_obj_execute_node_select").getSchemaName(),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaThreeQuoted() {
        MatcherAssert.assertThat(
                QNameParser.parsePg("\"juzz_system\".\"f_obj_execute_node_select\".\"test\"").getSchemaName(),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseObjectBothQuoted() {
        MatcherAssert.assertThat(QNameParser.parsePg(
                "\"juzz_system\".\"f_obj_execute_node_select\"").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectFirstQuoted() {
        MatcherAssert.assertThat(QNameParser.parsePg(
                "\"juzz_system\".f_obj_execute_node_select").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectSecondQuoted() {
        MatcherAssert.assertThat(QNameParser.parsePg(
                "juzz_system.\"f_obj_execute_node_select\"").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectNoneQuoted() {
        MatcherAssert.assertThat(QNameParser.parsePg(
                "juzz_system.f_obj_execute_node_select").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectThreeQuoted() {
        MatcherAssert.assertThat(QNameParser.parsePg(
                "\"juzz_system\".\"f_obj_execute_node_select\".\"test\"").getFirstName(),
                IsEqual.equalTo("test"));
    }
    // SONAR-ON
}
