/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.TEST.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;

/**
 * Tests for PgDiff class.
 *
 * @author fordfrog
 */
@RunWith(value = Parameterized.class)
public class PgDiffTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    // Tests scenario where COLUMN type is modified.
                    {"modify_column_type"},
                    // Tests scenario where CLUSTER is added to TABLE.
                    {"add_cluster"},
                    // Tests scenario where CLUSTER is dropped from TABLE.
                    {"drop_cluster"},
                    // Tests scenario where CLUSTER is changed on TABLE.
                    {"modify_cluster"},
                    // Tests scenario where WITH OIDS is dropped from TABLE.
                    {"drop_with_oids"},
                    // Tests scenario where INDEX is added.
                    {"add_index"},
                    // Tests scenario where INDEX is dropped.
                    {"drop_index"},
                    // Tests scenario where INDEX that TABLE CLUSTER is based
                    // on is dropped.
                    {"drop_index_with_cluster"},
                    // Tests scenario where INDEX definition is modified.
                    {"modify_index"},
                    // Tests scenario where STATISTICS information is added
                    // to COLUMN.
                    {"add_statistics"},
                    // Tests scenario where STATISTICS information is modified.
                    {"modify_statistics"},
                    // Tests scenario where STATISTICS information is dropped.
                    {"drop_statistics"},
                    // Tests scenario where DEFAULT value is set on COLUMN.
                    {"add_default_value"},
                    // Tests scenario where DEFAULT value is modified.
                    {"modify_default_value"},
                    // Tests scenario where DEFAULT value is dropped from COLUMN.
                    {"drop_default_value"},
                    // Tests scenario where NOT NULL constraint is set on COLUMN.
                    {"add_not_null"},
                    // Tests scenario where NOT NULL constraint is dropped
                    // from COLUMN.
                    {"drop_not_null"},
                    // Tests scenario where COLUMN is added to TABLE definition.
                    {"add_column"},
                    // Tests scenario where COLUMN is added to TABLE definition and has null values.
                    {"add_column_null"},
                    // Tests scenario where COLUMN is dropped from TABLE.
                    {"drop_column"},
                    // Tests scenario where new TABLE is added.
                    {"add_table"},
                    // Tests scenario where new TABLE with new SEQUENCE is added.
                    {"add_table_with_new_sequence"},
                    // Tests scenario where new TABLE with exist SEQUENCE is added.
                    {"add_table_with_exist_sequence"},
                    // Tests scenario where new TABLE with drop SEQUENCE is added.
                    {"add_table_with_drop_sequence"},
                    // Tests scenario where new TABLE with drop SEQUENCE is added.
                    {"add_table_with_not_existing_sequence"},
                    // Tests scenario where TABLE is dropped.
                    {"drop_table"},
                    // Tests scenario where TABLE CONSTRAINT is added.
                    {"add_constraint"},
                    // Tests scenario where TABLE CONSTRAINT is modified.
                    {"modify_constraint"},
                    // Tests scenario where TABLE CONSTRAINT is dropped.
                    {"drop_constraint"},
                    // Tests scenario where UNIQUE TABLE CONSTRAINT is added.
                    {"add_unique_constraint"},
                    // Tests reading of TABLE with INHERITS.
                    {"read_inherits"},
                    // Tests scenario where TABLE with INHERITS is added.
                    {"add_inherits"},
                    // Tests scenario where original and new TABLE contain
                    //different INHERITS.
                    {"modify_inherits"},
                    // Tests scenario where SEQUENCE is added.
                    {"add_sequence"},
                    // Tests scenario where SEQUENCE is dropped.
                    {"drop_sequence"},
                    // Tests scenario where INCREMENT BY is modified on SEQUENCE.
                    {"modify_sequence_increment"},
                    // Tests scenario where START WITH is modified on SEQUENCE
                    // (both with --ignore-start-with turned off and on).
                    {"modify_sequence_start_ignore_off"},
                    // Tests scenario where MINVALUE is modified on SEQUENCE
                    // (both setting and unsetting the value).
                    {"modify_sequence_minvalue_set"},
                    {"modify_sequence_minvalue_unset"},
                    // Tests scenario where MAXVALUE is modified on SEQUENCE
                    // (both setting and unsetting the value).
                    {"modify_sequence_maxvalue_set"},
                    {"modify_sequence_maxvalue_unset"},
                    // Tests scenario where CACHE is modified on SEQUENCE.
                    {"modify_sequence_cache"},
                    // Tests scenario where CYCLE is modified on SEQUENCE.
                    {"modify_sequence_cycle_on"},
                    {"modify_sequence_cycle_off"},
                    // Tests correct finding of function end.
                    {"modify_function_end_detection"},
                    // Tests scenario where new FUNCTION without args is added.
                    {"add_function_noargs"},
                    // Tests scenario where FUNCTION without args is dropped.
                    {"drop_function_noargs"},
                    // Tests scenario where FUNCTION without args is modified.
                    {"modify_function_noargs"},
                    // Tests scenario where new FUNCTION with args is added.
                    {"add_function_args"},
                    // Tests scenario where FUNCTION with args is dropped.
                    {"drop_function_args"},
                    // Tests scenario where FUNCTION with args is modified.
                    {"modify_function_args"},
                    // изменить тип out аргумента
                    {"function_out_type_chg"},
                    // изменить out параметра
                    {"function_out_name_chg"},
                    {"function_out_type_add"},
                    {"function_out_type_del"},
                    // Tests scenario where FUNCTION with args delete default.
                    {"modify_function_delete_default"},
                    // Tests scenario where FUNCTION with args add default.
                    {"modify_function_add_default"},
                    // Tests scenario where FUNCTION with args modify returns.
                    {"modify_function_modify_returns"},
                    // Tests scenario where FUNCTION with args not modify default value.
                    {"same_function_default"},
                    // Tests scenario where new FUNCTION with args is added.
                    {"add_function_args2"},
                    // Tests scenario where FUNCTION with args is dropped.
                    {"drop_function_args2"},
                    // Tests scenario where FUNCTION with args is modified.
                    {"modify_function_args2"},
                    // Tests scenario where FUNCTION with same name but
                    // different args is added.
                    {"add_function_similar"},
                    // Tests scenario where FUNCTION with same name but
                    // different args is dropped.
                    {"drop_function_similar"},
                    // Tests scenario where FUNCTION with same name but
                    // different args is modified.
                    {"modify_function_similar"},
                    // Tests scenario where TRIGGER is added.
                    {"add_trigger"},
                    // Tests scenario where TRIGGER is added in reverse add.
                    {"add_trigger_another_schema"},
                    // Tests scenario where TRIGGER is dropped.
                    {"drop_trigger"},
                    // Tests scenario where TRIGGER is dropped and func in another schema.
                    {"drop_trigger_another_schema"},
                    // Tests scenario where TRIGGER is change function.
                    {"change_trigger_function"},
                    // Tests scenario where TRIGGER is modified.
                    {"modify_trigger"},
                    // Tests scenario where VIEW is added.
                    {"add_view"},
                    // Tests scenario where VIEW is dropped.
                    {"drop_view"},
                    // Tests scenario where VIEW is modified.
                    {"modify_view"},
                    // Tests scenario where multiple schemas are in the dumps.
                    {"multiple_schemas"},
                    // Tests scenario where --add-transaction is specified.
                    {"multiple_schemas"},
                    // Tests dropping view default value
                    {"alter_view_drop_default"},
                    // Tests adding view default value
                    {"alter_view_add_default"},
                    // Tests adding of comments
                    {"add_comments"},
                    // Tests dropping of comments
                    {"drop_comments"},
                    // Tests altering of comments
                    {"alter_comments"},
                    // Tests changing view default value
                    {"alter_view_change_default"},
                    // Tests creation of sequence with bug in MINVALUE value
                    {"add_sequence_bug2100013"},
                    // Tests view with default value
                    {"view_bug3080388"},
                    // Tests function arguments beginning with in_
                    {"function_bug3084274"},
                    // Tests addition of comment when new column has been added
                    {"add_comment_new_column"},
                    // Tests handling of quoted schemas in search_path
                    {"quoted_schema"},
                    // Tests adding new column with add defaults turned on
                    {"add_column_add_defaults"},
                    // Tests adding new sequence that is owned by table
                    {"add_owned_sequence"},
                    // Tests adding empty table
                    {"add_empty_table"},
                    // Tests adding and an extension and changing it's schema
                    {"add_ext"},
                    // Test changes in the middle of a simple dependency chain
                    {"depcy_simple1"},
                    // Test changes in the middle and tail of a simple dependency chain
                    {"depcy_simple2"},
                    {"dropped_view_recreation"},
                    // Test composite type
                    {"add_type_composite"},
                    {"drop_type_composite"},
                    {"alter_type_composite_add_attr"},
                    {"alter_type_composite_drop_attr"},
                    {"alter_type_composite_alter_attr"},
                    //Test enum type
                    {"add_type_enum"},
                    {"drop_type_enum"},
                    {"type_enum_add_value"},
                    {"type_enum_drop_value"},
                    {"type_enum_swap_values"},
                    //Test range type
                    {"add_type_range"},
                    {"drop_type_range"},
                    {"type_range_chg"},
                    //Test domain
                    {"add_domain"},
                    {"drop_domain"},
                    {"alter_domain_drop_def"},
                    {"alter_domain_set_def"},
                    {"alter_domain_chg_def"},
                    {"alter_domain_set_not_null"},
                    {"alter_domain_drop_not_null"},
                    {"alter_domain_add_constr"},
                    {"alter_domain_drop_constr"},
                    {"alter_domain_add_not_valid_constr"},
                    {"alter_domain_drop_not_valid_constr"},
                    {"drop_domain_data_type"},
                    {"drop_domain_collation"},
                    // Test function type depcy
                    {"create_func_type"},
                    {"drop_func_type"},
                    {"chg_type_func"},
                    {"drop_create_type_func"},
                    // Test table type depcy
                    {"drop_create_type_tbl"},
                    // Test table domain depcy
                    {"create_dom_tbl"},
                    {"drop_dom_tbl"},
                    // Test authorization schema
                    {"authorization_schema"},
                    // Test column privilege
                    {"col_priv"},
                    {"col_revoke_priv"},
                    {"col_priv_new_tbl"},
                    {"col_priv_tbl"},
                    // Test privilege
                    {"add_privilege"},
                    {"drop_privilege"},
                    {"chg_privilege"},
                    // Test change owner
                    {"chg_owner"},
                    // Тест зависимости от колонки к функции default
                    {"col_to_func"},
                    // Тест зависимости от таблицы к функции default
                    {"tabl_to_func"},
                    // Вью со звездочкой
                    {"multiply_view"},
                    {"multiply_view_1"},
                    {"multiply_view_dif_schema"},
                    {"add_rule"},
                    {"drop_rule"}
                });
    }

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    private final String fileNameTemplate;

    public PgDiffTest(final String fileNameTemplate) {
        this.fileNameTemplate = fileNameTemplate;
        Locale.setDefault(Locale.ENGLISH);
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    public void runDiffSame(PgDatabase db) throws IOException, InterruptedException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.diffDatabaseSchemas(writer, arguments, db, db, null);
        writer.flush();

        Assert.assertEquals("File name template: " + fileNameTemplate,
                "", diffInput.toString().trim());
    }

    @Test
    public void runDiff() throws IOException, InterruptedException, LicenseException {
        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        PgDatabase dbOld = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, PgDiffTest.class, args);
        PgDatabase dbNew = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, PgDiffTest.class, args);

        runDiffSame(dbOld);
        runDiffSame(dbNew);

        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        PgDiff.diffDatabaseSchemas(writer, args, dbOld, dbNew, null);
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
