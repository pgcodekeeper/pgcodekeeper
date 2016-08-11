/**
 * Copyright 2010 StartNet s.r.o.
 */
package cz.startnet.utils.pgdiff;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;

/**
 * Tests {@link #ParserUtils}.
 *
 * @author fordfrog
 */
public class PgDiffUtilsTest {
    // SONAR-OFF
    @Test(timeout = 1000)
    public void testParseSchemaBothQuoted() {
        Assert.assertThat(
                new QNameParser("\"juzz_system\".\"f_obj_execute_node_select\"").getSchemaName(null),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaFirstQuoted() {
        Assert.assertThat(
                new QNameParser("\"juzz_system\".f_obj_execute_node_select").getSchemaName(null),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaSecondQuoted() {
        Assert.assertThat(
                new QNameParser("juzz_system.\"f_obj_execute_node_select\"").getSchemaName(null),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaNoneQuoted() {
        Assert.assertThat(
                new QNameParser("juzz_system.f_obj_execute_node_select").getSchemaName(null),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseSchemaThreeQuoted() {
        Assert.assertThat(
                new QNameParser("\"juzz_system\".\"f_obj_execute_node_select\".\"test\"").getSchemaName(null),
                IsEqual.equalTo("juzz_system"));
    }

    @Test(timeout = 1000)
    public void testParseObjectBothQuoted() {
        Assert.assertThat(new QNameParser(
                "\"juzz_system\".\"f_obj_execute_node_select\"").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectFirstQuoted() {
        Assert.assertThat(new QNameParser(
                "\"juzz_system\".f_obj_execute_node_select").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectSecondQuoted() {
        Assert.assertThat(new QNameParser(
                "juzz_system.\"f_obj_execute_node_select\"").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectNoneQuoted() {
        Assert.assertThat(new QNameParser(
                "juzz_system.f_obj_execute_node_select").getFirstName(),
                IsEqual.equalTo("f_obj_execute_node_select"));
    }

    @Test(timeout = 1000)
    public void testParseObjectThreeQuoted() {
        Assert.assertThat(new QNameParser(
                "\"juzz_system\".\"f_obj_execute_node_select\".\"test\"").getFirstName(),
                IsEqual.equalTo("test"));
    }
    // SONAR-ON
}
