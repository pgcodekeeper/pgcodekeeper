/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.TEST.FILES_POSTFIX;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;

/**
 * Tests for PgDiff class.
 *
 * @author fordfrog
 */
@RunWith(value = Parameterized.class)
public class PgDiffTest {

    /**
     * Provides parameters for running the tests.
     *
     * @return parameters for the tests
     */
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    // Tests scenario where COLUMN type is modified.
                    {"modify_column_type", false},
                    // Tests scenario where CLUSTER is added to TABLE.
                    {"add_cluster", false},
                    // Tests scenario where CLUSTER is dropped from TABLE.
                    {"drop_cluster", false},
                    // Tests scenario where CLUSTER is changed on TABLE.
                    {"modify_cluster", false},
                    // Tests scenario where WITH OIDS is dropped from TABLE.
                    {"drop_with_oids", false},
                    // Tests scenario where INDEX is added.
                    {"add_index", false},
                    // Tests scenario where INDEX is dropped.
                    {"drop_index", false},
                    // Tests scenario where INDEX that TABLE CLUSTER is based
                    // on is dropped.
                    {"drop_index_with_cluster", false},
                    // Tests scenario where INDEX definition is modified.
                    {"modify_index", false},
                    // Tests scenario where STATISTICS information is added
                    // to COLUMN.
                    {"add_statistics", false},
                    // Tests scenario where STATISTICS information is modified.
                    {"modify_statistics", false},
                    // Tests scenario where STATISTICS information is dropped.
                    {"drop_statistics", false},
                    // Tests scenario where DEFAULT value is set on COLUMN.
                    {"add_default_value", false},
                    // Tests scenario where DEFAULT value is modified.
                    {"modify_default_value", false},
                    // Tests scenario where DEFAULT value is dropped from COLUMN.
                    {"drop_default_value", false},
                    // Tests scenario where NOT NULL constraint is set on COLUMN.
                    {"add_not_null", false},
                    // Tests scenario where NOT NULL constraint is dropped
                    // from COLUMN.
                    {"drop_not_null", false},
                    // Tests scenario where COLUMN is added to TABLE definition.
                    {"add_column", false},
                    // Tests scenario where COLUMN is added to TABLE definition and has null values.
                    {"add_column_null", false},
                    // Tests scenario where COLUMN is dropped from TABLE.
                    {"drop_column", false},
                    // Tests scenario where new TABLE is added.
                    {"add_table", false},
                    // Tests scenario where new TABLE with new SEQUENCE is added.
                    {"add_table_with_new_sequence", false},
                    // Tests scenario where new TABLE with exist SEQUENCE is added.
                    {"add_table_with_exist_sequence", false},
                    // Tests scenario where new TABLE with drop SEQUENCE is added.
                    {"add_table_with_drop_sequence", false},
                    // Tests scenario where new TABLE with drop SEQUENCE is added.
                    {"add_table_with_not_existing_sequence", false},
                    // Tests scenario where TABLE is dropped.
                    {"drop_table", false},
                    // Tests scenario where TABLE CONSTRAINT is added.
                    {"add_constraint", false},
                    // Tests scenario where TABLE CONSTRAINT is modified.
                    {"modify_constraint", false},
                    // Tests scenario where TABLE CONSTRAINT is dropped.
                    {"drop_constraint", false},
                    // Tests scenario where UNIQUE TABLE CONSTRAINT is added.
                    {"add_unique_constraint", false},
                    // Tests reading of TABLE with INHERITS.
                    {"read_inherits", false},
                    // Tests scenario where TABLE with INHERITS is added.
                    {"add_inherits", false},
                    // Tests scenario where original and new TABLE contain
                    //different INHERITS.
                    {"modify_inherits", false},
                    // Tests scenario where SEQUENCE is added.
                    {"add_sequence", false},
                    // Tests scenario where SEQUENCE is dropped.
                    {"drop_sequence", false},
                    // Tests scenario where INCREMENT BY is modified on SEQUENCE.
                    {"modify_sequence_increment", false},
                    // Tests scenario where START WITH is modified on SEQUENCE
                    // (both with --ignore-start-with turned off and on).
                    {"modify_sequence_start_ignore_off", false},
                    // Tests scenario where MINVALUE is modified on SEQUENCE
                    // (both setting and unsetting the value).
                    {"modify_sequence_minvalue_set", false},
                    {"modify_sequence_minvalue_unset", false},
                    // Tests scenario where MAXVALUE is modified on SEQUENCE
                    // (both setting and unsetting the value).
                    {"modify_sequence_maxvalue_set", false},
                    {"modify_sequence_maxvalue_unset", false},
                    // Tests scenario where CACHE is modified on SEQUENCE.
                    {"modify_sequence_cache", false},
                    // Tests scenario where CYCLE is modified on SEQUENCE.
                    {"modify_sequence_cycle_on", false},
                    {"modify_sequence_cycle_off", false},
                    // Tests correct finding of function end.
                    {"modify_function_end_detection", false},
                    // Tests scenario where new FUNCTION without args is added.
                    {"add_function_noargs", false},
                    // Tests scenario where FUNCTION without args is dropped.
                    {"drop_function_noargs", false},
                    // Tests scenario where FUNCTION without args is modified.
                    {"modify_function_noargs", false},
                    // Tests scenario where new FUNCTION with args is added.
                    {"add_function_args", false},
                    // Tests scenario where FUNCTION with args is dropped.
                    {"drop_function_args", false},
                    // Tests scenario where FUNCTION with args is modified.
                    {"modify_function_args", false},
                    // Tests scenario where FUNCTION with args delete default.
                    {"modify_function_delete_default", false},
                    // Tests scenario where FUNCTION with args add default.
                    {"modify_function_add_default", false},
                    // Tests scenario where FUNCTION with args modify returns.
                    {"modify_function_modify_returns", false},
                    // Tests scenario where FUNCTION with args not modify default value.
                    {"same_function_default", false},
                    // Tests scenario where new FUNCTION with args is added.
                    {"add_function_args2", false},
                    // Tests scenario where FUNCTION with args is dropped.
                    {"drop_function_args2", false},
                    // Tests scenario where FUNCTION with args is modified.
                    {"modify_function_args2", false},
                    // Tests scenario where FUNCTION with same name but
                    // different args is added.
                    {"add_function_similar", false},
                    // Tests scenario where FUNCTION with same name but
                    // different args is dropped.
                    {"drop_function_similar", false},
                    // Tests scenario where FUNCTION with same name but
                    // different args is modified.
                    {"modify_function_similar", false},
                    // Tests scenario where TRIGGER is added.
                    {"add_trigger", false},
                    // Tests scenario where TRIGGER is added in reverse add.
                    {"add_trigger_another_schema", false},
                    // Tests scenario where TRIGGER is dropped.
                    {"drop_trigger", false},
                    // Tests scenario where TRIGGER is dropped and func in another schema.
                    {"drop_trigger_another_schema", false},
                    // Tests scenario where TRIGGER is change function.
                    {"change_trigger_function", false},
                    // Tests scenario where TRIGGER is modified.
                    {"modify_trigger", false},
                    // Tests scenario where VIEW is added.
                    {"add_view", false},
                    // Tests scenario where VIEW is dropped.
                    {"drop_view", false},
                    // Tests scenario where VIEW is modified.
                    {"modify_view", false},
                    // Tests scenario where multiple schemas are in the dumps.
                    {"multiple_schemas", false},
                    // Tests scenario where --add-transaction is specified.
                    {"multiple_schemas", true},
                    // Tests dropping view default value
                    {"alter_view_drop_default", true},
                    // Tests adding view default value
                    {"alter_view_add_default", true},
                    // Tests adding of comments
                    {"add_comments", true},
                    // Tests dropping of comments
                    {"drop_comments", true},
                    // Tests altering of comments
                    {"alter_comments", true},
                    // Tests changing view default value
                    {"alter_view_change_default", true},
                    // Tests creation of sequence with bug in MINVALUE value
                    {"add_sequence_bug2100013", true},
                    // Tests view with default value
                    {"view_bug3080388", true},
                    // Tests function arguments beginning with in_
                    {"function_bug3084274", true},
                    // Tests addition of comment when new column has been added
                    {"add_comment_new_column", true},
                    // Tests handling of quoted schemas in search_path
                    {"quoted_schema", true},
                    // Tests adding new column with add defaults turned on
                    {"add_column_add_defaults", true},
                    // Tests adding new sequence that is owned by table
                    {"add_owned_sequence", true},
                    // Tests adding empty table
                    {"add_empty_table", false},
                    // Tests adding and an extension and changing it's schema
                    {"add_ext", false},
                    // Test changes in the middle of a simple dependency chain
                    {"depcy_simple1", false},
                    // Test changes in the middle and tail of a simple dependency chain
                    {"depcy_simple2", false},
                    {"dropped_view_recreation", false},
                    // Test composite type
                    {"add_type_composite", false},
                    {"drop_type_composite", false},
                    {"alter_type_composite_add_attr", false},
                    {"alter_type_composite_drop_attr", false},
                    {"alter_type_composite_alter_attr", false},
                    //Test enum type
                    {"add_type_enum", false},
                    {"drop_type_enum", false},
                    {"type_enum_add_value", false},
                    {"type_enum_drop_value", false},
                    {"type_enum_swap_values", false},
                    //Test range type
                    {"add_type_range", false},
                    {"drop_type_range", false},
                    {"type_range_chg", false},
                    //Test domain
                    {"add_domain", false},
                    {"drop_domain", false},
                    {"alter_domain_drop_def", false},
                    {"alter_domain_set_def", false},
                    {"alter_domain_chg_def", false},
                    {"alter_domain_set_not_null", false},
                    {"alter_domain_drop_not_null", false},
                    {"alter_domain_add_constr", false},
                    {"alter_domain_drop_constr", false},
                    {"alter_domain_add_not_valid_constr", false},
                    {"alter_domain_drop_not_valid_constr", false},
                    {"drop_domain_data_type", false},
                    {"drop_domain_collation", false},
                    // Test function type depcy
                    {"create_func_type", false},
                    {"drop_func_type", false},
                    {"chg_type_func", false},
                    {"drop_create_type_func", false},
                    // Test table type depcy
                    {"drop_create_type_tbl", false},
                    // Test table domain depcy
                    {"create_dom_tbl", false},
                    {"drop_dom_tbl", false},
                });
    }
    
    private static final List<String> RUN_DIFF_SKIP_FILES = Arrays.asList(
            // FIXME modify_inherits_drop_oldparent
            "modify_inherits_drop_oldparent"
            );
    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    private final String fileNameTemplate;

    /**
     * Creates a new PgDiffTest object.
     *
     * @param fileNameTemplate         {@link #fileNameTemplate}
     * @param addDefaults              {@link #addDefaults}
     * @param ignoreFunctionWhitespace {@link #ignoreFunctionWhitespace}
     * @param ignoreStartWith          {@link #ignoreStartWith}
     */
    public PgDiffTest(final String fileNameTemplate,
            final boolean addTransaction) {
        super();
        this.fileNameTemplate = fileNameTemplate;
        Locale.setDefault(Locale.ENGLISH);
    }

    /**
     * Runs single test on original schema.
     */
    @Test(timeout = 5000)
    public void runDiffSameOriginal() throws IOException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.createDiff(writer, arguments,
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL),
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL));
        writer.flush();

        Assert.assertEquals("File name template: " + fileNameTemplate,
                "", diffInput.toString().trim());
    }

    /**
     * Runs single test on new schema.
     */
    @Test(timeout = 5000)
    public void runDiffSameNew() throws IOException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.createDiff(writer, arguments,
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL),
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL));
        writer.flush();

        Assert.assertEquals("File name template: " + fileNameTemplate,
                "", diffInput.toString().trim());
    }

    /**
     * Runs single test using class member variables.
     */
    @Test(timeout = 5000)
    public void runDiff() throws IOException {
        
        Assume.assumeThat(RUN_DIFF_SKIP_FILES, not(hasItem(fileNameTemplate)));
        
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.createDiff(writer, arguments,
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL),
                PgDiffTest.class.getResourceAsStream(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL));
        writer.flush();

        StringBuilder sbExpDiff;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                PgDiffTest.class.getResourceAsStream(fileNameTemplate 
                        + FILES_POSTFIX.DIFF_SQL)))) {
            sbExpDiff = new StringBuilder(1024);

            String line;
            while ((line = reader.readLine()) != null) {
                sbExpDiff.append(line);
                sbExpDiff.append('\n');
            }
        }

        Assert.assertEquals("File name template: " + fileNameTemplate,
                sbExpDiff.toString().trim(),
                diffInput.toString().trim());
    }
}
