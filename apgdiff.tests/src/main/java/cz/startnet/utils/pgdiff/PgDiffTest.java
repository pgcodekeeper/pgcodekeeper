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

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;

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
                    // Tests scenario where COLUMN type is modified, column has constraint.
                    {"modify_column_type_with_constraint"},
                    // Tests scenario where COLUMN type is modified, column has index.
                    {"modify_column_type_with_index"},
                    // Tests scenario where COLUMN type is modified, column linked with trigger.
                    {"modify_column_type_linked_with_trigger"},
                    // Tests scenario where COLUMN type is modified, column linked with rule.
                    {"modify_column_type_linked_with_rule"},
                    // Tests scenario where CLUSTER is added to TABLE.
                    {"add_cluster"},
                    // Tests scenario where CLUSTER is dropped from TABLE.
                    {"drop_cluster"},
                    // Tests scenario where CLUSTER is changed on TABLE.
                    {"modify_cluster"},
                    // Tests scenario where TABLE is modified by addition of an option.
                    {"add_table_option"},
                    // Tests scenario where TABLE is modified by removal option.
                    {"delete_table_option"},
                    // Tests scenario where TABLE is modified by changing of an option.
                    {"modify_table_option"},
                    // Tests scenario where TABLE with partition is added.
                    {"add_table_with_partition"},
                    // Tests scenario where WITH OIDS is dropped from TABLE.
                    {"drop_with_oids"},
                    // Tests scenario where INDEX is added.
                    {"add_index"},
                    // Tests scenario where INDEX is dropped.
                    {"drop_index"},
                    // Tests scenario where INDEX with including is added.
                    {"add_index_with_including"},
                    // Tests scenario where INDEX that TABLE CLUSTER is based
                    // on is dropped.
                    {"drop_index_with_cluster"},
                    // Tests scenario where INDEX definition is modified.
                    {"modify_index"},
                    // Tests scenario where INDEX option is modified.
                    {"modify_index_option"},
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
                    // Tests scenario where COLUMN with index dependency is dropped from TABLE.
                    {"drop_column"},
                    // Tests scenario where new TABLE is added.
                    {"add_table"},
                    // Tests scenario where new FOREIGN TABLE is added.
                    {"add_foreign_table"},
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
                    // Tests scenario where new TYPED TABLE is added.
                    {"add_table_of_type"},
                    // Tests scenario where in TYPED TABLE new options is added.
                    {"add_table_of_type_options"},
                    // Tests scenario where options of TYPED TABLE is modified.
                    {"modify_table_of_type_options"},
                    // Tests scenario where FOREIGN TABLE is modified.
                    {"modify_foreign_table"},
                    // Tests scenario where column of TYPED TABLE with TYPE is modified.
                    {"modify_table_of_type_column"},
                    // Tests scenario where TYPED TABLE is dropped.
                    {"drop_table_of_type"},
                    // Tests scenario where TABLE row security is changed.
                    {"modify_table_row_security"},
                    // Tests scenario where TABLE logged status is changed.
                    {"modify_table_unlogged"},
                    // Tests scenario where TABLE CONSTRAINT is added.
                    {"add_constraint"},
                    // Tests scenario where TABLE EXCLUDE CONSTRAINT is added.
                    {"add_exclude_constraint"},
                    // Tests scenario where TABLE CONSTRAINT is modified.
                    {"modify_constraint"},
                    // Tests scenario where TABLE CONSTRAINT is dropped.
                    {"drop_constraint"},
                    // Tests scenario where UNIQUE TABLE CONSTRAINT is added.
                    {"add_unique_constraint"},
                    // Tests reading of TABLE with INHERITS.
                    {"read_inherits"},
                    // Tests scenario where TABLE with generated SEQUENCE is added.
                    {"add_generated_sequence"},
                    // Tests scenario where TABLE with INHERITS is added.
                    {"add_inherits"},
                    // Tests scenario where original and new TABLE contain
                    //different INHERITS.
                    {"modify_inherits"},
                    // Tests scenario where SEQUENCE is added.
                    {"add_sequence"},
                    // Tests scenario where SEQUENCE with data type is added.
                    {"add_sequence_with_data_type"},
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
                    // Tests scenario where SEQUENCE with data type is modified.
                    {"modify_sequence_data_type"},
                    // Tests scenario where new PARTITION TABLE is modified.
                    // TODO при формировании скрипта не учитываются пересечения партиций
                    // ATTACH PARTITION public.cities_fg FOR VALUES IN ('e', 'g');
                    // выполняется раньше чем
                    // DROP FOREIGN TABLE public.f_cities_e;
                    {"modify_partition_table"},
                    // Tests scenario where new PARTITION TABLE is converted to TYPED TABLE.
                    {"chg_table_type"},
                    // Tests scenario where CYCLE is modified on SEQUENCE.
                    {"modify_sequence_cycle_on"},
                    {"modify_sequence_cycle_off"},
                    // Tests scenario where TABLE with generated SEQUENCE is modified.
                    {"modify_generated_sequence"},
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
                    // Tests scenario where FUNCTION with parallel mode is modified
                    {"modify_function_parallel"},
                    // Tests scenario where TRIGGER is added.
                    {"add_trigger"},
                    // Tests scenario where TRIGGER with referencing is added.
                    {"add_trigger_referencing"},
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
                    // Tests scenario where CONSTRAINT TRIGGER is added.
                    {"add_constraint_trigger"},
                    // Tests scenario where TRIGGER with 'differable initially' parameter is added.
                    {"add_differable_initially_trigger"},
                    // Tests scenario where COLUMN CONSTRAINT is compared.
                    {"compare_column_constraints"},
                    // Tests scenario where FOREIGN TABLE COLUMN OPTIONS is compared.
                    {"compare_ftable_column_options"},
                    // Tests scenario where VIEW is added.
                    {"add_view"},
                    // Tests scenario where VIEW is dropped.
                    {"drop_view"},
                    // Tests scenario where VIEW is modified.
                    {"modify_view"},
                    // Tests scenario where VIEW is modified by addition of an option.
                    {"add_view_option"},
                    // Tests scenario where VIEW is modified by removal option.
                    {"delete_view_option"},
                    // Tests scenario where VIEW is modified by changing of an option.
                    {"modify_view_option"},
                    // Tests scenario where multiple schemas are in the dumps.
                    {"multiple_schemas"},
                    // Tests scenario where --add-transaction is specified.
                    {"multiple_schemas"},
                    // Tests dropping view default value
                    {"alter_view_drop_default"},
                    // Tests adding view default value
                    {"alter_view_add_default"},
                    // Tests adding of comments
                    // TODO function 'current_database()' in this line does not work:
                    // COMMENT ON DATABASE current_database() IS 'comments database';
                    {"add_comments"},
                    // Tests dropping of comments
                    // TODO function 'current_database()' in this line does not work:
                    // COMMENT ON DATABASE current_database() IS NULL;
                    {"drop_comments"},
                    // Tests altering of comments
                    // TODO function 'current_database()' in this line does not work:
                    // COMMENT ON DATABASE current_database() IS 'comments database 2';
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
                    // Tests set, reset attributes of column
                    {"alter_table_alter_column_set_reset"},
                    // Tests set storage for column
                    {"alter_table_alter_column_set_storage"},
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
                    //Test base type
                    {"add_type_base"},
                    {"drop_type_base"},
                    {"type_base_chg"},
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
                    // Dependency test in a scenario where one of the overloaded FUNCTION will be deleted.
                    {"depcy_drop_overloaded_function"},
                    // Вью со звездочкой
                    {"multiply_view"},
                    {"multiply_view_1"},
                    {"multiply_view_dif_schema"},
                    {"add_rule"},
                    {"add_rule_2"},
                    {"drop_rule"},
                    {"modify_constraint_validate"},
                    {"modify_rule_enable"},
                    // Tests scenario where typed TABLE type is changed.
                    {"modify_typed_table_type"},
                    // Tests scenario where partition TABLE type is changed.
                    {"modify_partition_table_type"},
                    // Tests scenario where foreign TABLE type is changed.
                    {"modify_foreign_table_type"},
                    // Tests scenario where empty foreign TABLE is changed.
                    {"modify_empty_foreign_table"},
                    // Tests scenario where materialized VIEW options is changed.
                    {"modify_materialized_view_options"},
                    // Tests scenario where materialized VIEW is changed.
                    // TODO изменить после добавления поддержки ALTER MATERIALIZED VIEW
                    {"modify_materialized_view"},
                    //Tests scenario where empty SEQUENCE is compared.
                    {"compare_empty_sequence"},
                    //Tests scenario where TRIGGER with multiple events is added.
                    {"add_multiple_events_trigger"},
                    // Tests scenario where RULE is disabled.
                    {"disable_rule"},
                    // Tests scenario where REGULAR TABLE is converted to PARTITION TABLE.
                    {"chg_reg_table_to_partition"},
                    // Tests scenario where PARTITION FOREIGN TABLE inherit is modified.
                    {"modify_partition_ftable_inherit"},
                    // Tests scenario where FTS PARSER is added, modified and deleted.
                    {"modify_fts_parser"},
                    // Tests scenario where FTS TEMPLATE is added, modified and deleted.
                    {"modify_fts_template"},
                    // Tests scenario where FTS DICTIONARY is added, modified and deleted.
                    {"modify_fts_dictionary"},
                    // Tests scenario where FTS DICTIONARY OPTIONS is added, modified and deleted.
                    {"modify_fts_dictionary_options"},
                    // Tests scenario where FTS CONFIGURATION is added, modified and deleted.
                    {"modify_fts_configuration"},
                    // Tests scenario where FTS CONFIGURATION OPTIONS is added, modified and deleted.
                    {"modify_fts_configuration_options"},
                    // Tests scenario where differable initially trigger is added.
                    {"add_differable_initially_trigger"},
                    // Tests scenario where COLUMN type and default is modified.
                    {"modify_column_type_and_default"},
                    // Tests scenario where COLUMN type is modified and default is deleted.
                    {"modify_column_type_and_drop_default"},
                    // Tests scenario where new OPERATOR is added.
                    {"add_operator"},
                    // Tests scenario where new overloaded OPERATOR is added.
                    {"add_operator_overloaded"},
                    // Tests scenario where new OPERATOR with using elements from other schemas is added.
                    {"add_operator_use_other_schema"},
                    // Tests scenario where OPERATOR is dropped.
                    {"drop_operator"},
                    // Tests scenario where options of OPERATOR is modified.
                    {"modify_operator"},
                    // Tests scenario where only RESTRICT and JOIN options of OPERATOR is modified.
                    {"modify_operator_restr_join"},
                    // Tests scenario where function (from other schema) of OPERATOR is modified.
                    // TODO uncomment this code when dependencies for OPERATOR will be fixed
                    // {"modify_operator_use_other_schema"},
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
    public void runDiff() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
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
