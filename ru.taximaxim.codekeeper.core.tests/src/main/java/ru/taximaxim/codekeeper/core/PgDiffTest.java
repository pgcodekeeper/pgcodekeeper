/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for PgDiff class.
 *
 * @author fordfrog
 */
class PgDiffTest {

    /**
     * Template name for file names that should be used for the test. Testing method adds _original.sql, _new.sql and
     * _diff.sql to the file name template.
     */
    @ParameterizedTest
    @ValueSource(strings = {
            // Tests scenario where COLUMN type is modified.
            "modify_column_type",
            // Tests scenario where COLUMN type of foreign table is modified.
            "modify_column_type_foreign_table",
            // Tests scenario where COLUMN type is modified, column has constraint.
            "modify_column_type_with_constraint",
            // Tests scenario where COLUMN type is modified, column has index.
            "modify_column_type_with_index",
            // Tests scenario where COLUMN type is modified, column linked with trigger.
            "modify_column_type_linked_with_trigger",
            // Tests scenario where COLUMN type is modified, column linked with rule.
            "modify_column_type_linked_with_rule",
            // Tests scenario where CLUSTER is added to TABLE.
            "add_cluster",
            // Tests scenario where CLUSTER is dropped from TABLE.
            "drop_cluster",
            // Tests scenario where CLUSTER is changed on TABLE.
            "modify_cluster",
            // Tests scenario where access method of TABLE is changed.
            "modify_table_access_method",
            // Tests scenario where TABLE with partition is added.
            "add_table_with_partition",
            // Tests scenario where PARTITION INDEX is added.
            "add_partition_index",
            // Tests scenario where VIEW INDEX is added.
            "add_view_index",
            // Tests scenario where INDEX that TABLE CLUSTER is based
            // on is dropped.
            "drop_index_with_cluster",
            // Tests scenario where PARTITION TABLE with index is dropped.
            "drop_partition_table_index",
            // Tests scenario where PARTITION INDEX is modified.
            "modify_partition_index",
            // Tests scenario where STATISTICS information is added
            // to COLUMN.
            "add_statistics",
            // Tests scenario where STATISTICS information is modified.
            "modify_statistics",
            // Tests scenario where STATISTICS information is dropped.
            "drop_statistics",
            // Tests scenario where DEFAULT value is set on COLUMN.
            "add_default_value",
            // Tests scenario where DEFAULT value is modified.
            "modify_default_value",
            // Tests scenario where DEFAULT value is dropped from COLUMN.
            "drop_default_value",
            // Tests scenario where NOT NULL constraint is set on COLUMN.
            "add_not_null",
            // Tests scenario where NOT NULL constraint is dropped
            // from COLUMN.
            "drop_not_null",
            // Tests scenario where COLUMN is added to TABLE definition.
            "add_column",
            // Tests scenario where COLUMN is added to TABLE definition and has null values.
            "add_column_null",
            // Tests scenario where COLUMN with index dependency is dropped from TABLE.
            "drop_column",
            // Tests scenario where COLUMNs are dropped from partitioned TABLE.
            "drop_col_from_partitioned_tbl",
            // Tests scenario where generated COLUMN is added to TABLE definition.
            "add_column_generated",
            // Tests scenario where generated COLUMN is modified.
            "modify_column_generated",
            // Test scenario where new EVENT TRIGGER is added.
            "add_event_trigger",
            // Test scenario where EVENT TRIGGER is modified.
            "modify_event_trigger",
            // Test scenario where EVENT TRIGGER is dropped.
            "drop_event_trigger",
            // Tests scenario where new FOREIGN TABLE is added.
            "add_foreign_table",
            // Test scenario for greenplum where new FOREIGN TABLE is added.
            "add_greenplum_foreign_table",
            // Test scenario for greenplum where new TABLE is added.
            "add_gp_tables",
            // Test scenario for greenplum where new EXTERNAL tables is added.
            "add_gp_external_tables",
            // Test scenario for greenplum where drop EXTERNAL table.
            "drop_gp_external_tables",
            // Test scenario for greenplum where alter column in EXTERNAL table.
            "alter_columns_gp_external_tables",
            // Test scenario for greenplum where compare EXTERNAL table.
            "compare_gp_external_table",
            // Test scenario for greenplum where altered FOREIGN TABLE.
            "alter_greenplum_foreign_table",
            // Tests scenario where new TABLE with new SEQUENCE is added.
            "add_table_with_new_sequence",
            // Tests scenario where new TABLE with exist SEQUENCE is added.
            "add_table_with_exist_sequence",
            // Tests scenario where new TABLE with drop SEQUENCE is added.
            "add_table_with_drop_sequence",
            // Tests scenario where new TYPED TABLE is added.
            "add_table_of_type",
            // Tests scenario where in TYPED TABLE new options is added.
            "add_table_of_type_options",
            // Tests scenario where TABLE and FUNCTION with reserved
            // keyword without quotes in names is added.
            "add_tbl_and_func_with_keyword_name_no_quotes",
            // Tests scenario where options of TYPED TABLE is modified.
            "modify_table_of_type_options",
            // Tests scenario where FOREIGN TABLE is modified.
            "modify_foreign_table",
            // Tests scenario where column of TYPED TABLE with TYPE is modified.
            "modify_table_of_type_column",
            // Tests scenario where TYPED TABLE is dropped.
            "drop_table_of_type",
            // Tests scenario where TABLE and FUNCTION with reserved
            // keyword without quotes in names is dropped.
            "drop_tbl_and_func_with_keyword_name_no_quotes",
            // Tests scenario where new TABLE with generated column is added.
            "add_table_with_generated_col",
            // Tests scenario where TABLE CONSTRAINT is added.
            "add_constraint",
            // Tests scenario where TABLE CONSTRAINT with tablespace is added.
            "add_constraint_with_tablespace",
            // Tests scenario where TABLE EXCLUDE CONSTRAINT is added.
            "add_exclude_constraint",
            // Tests scenario where TABLE CONSTRAINT is modified.
            "modify_constraint",
            // Tests scenario where TABLE CONSTRAINT is dropped.
            "drop_constraint",
            // Tests scenario where UNIQUE TABLE CONSTRAINT is added.
            "add_unique_constraint",
            // Tests reading of TABLE with INHERITS.
            "read_inherits",
            // Tests scenario where TABLE with generated SEQUENCE is added.
            "add_generated_sequence",
            // Tests scenario where original and new TABLE contain
            // different INHERITS.
            "modify_inherits",
            // Tests scenario where SEQUENCE is added.
            "add_sequence",
            // Tests scenario where SEQUENCE with data type is added.
            "add_sequence_with_data_type",
            // Tests scenario where SEQUENCE is dropped.
            "drop_sequence",
            // Tests scenario where INCREMENT BY is modified on SEQUENCE.
            "modify_sequence_increment",
            // Tests scenario where START WITH is modified on SEQUENCE
            // (both with --ignore-start-with turned off and on).
            "modify_sequence_start_ignore_off",
            // Tests scenario where MINVALUE is modified on SEQUENCE
            // (both setting and unsetting the value).
            "modify_sequence_minvalue_set",
            "modify_sequence_minvalue_unset",
            // Tests scenario where MAXVALUE is modified on SEQUENCE
            // (both setting and unsetting the value).
            "modify_sequence_maxvalue_set",
            "modify_sequence_maxvalue_unset",
            // Tests scenario where CACHE is modified on SEQUENCE.
            "modify_sequence_cache",
            // Tests scenario where SEQUENCE with data type is modified.
            "modify_sequence_data_type",
            // Tests scenario where new PARTITION TABLE is modified.
            // TODO при формировании скрипта не учитываются пересечения партиций
            // ATTACH PARTITION public.cities_fg FOR VALUES IN ('e', 'g');
            // выполняется раньше чем
            // DROP FOREIGN TABLE public.f_cities_e;
            "modify_partition_table",
            // Tests scenario where compared PARTITION TABLE.
            "compare_partition_table",
            // Tests scenario where new PARTITION TABLE is converted to TYPED TABLE.
            "chg_table_type",
            // Tests scenario where CYCLE is modified on SEQUENCE.
            "modify_sequence_cycle_on",
            "modify_sequence_cycle_off",
            // Tests scenario where TABLE with generated SEQUENCE is modified.
            "modify_generated_sequence",
            // Tests correct finding of function end.
            "modify_function_end_detection",
            // Tests scenario where new FUNCTION is added.
            "add_function",
            // Tests scenario where FUNCTION without args is dropped.
            "drop_function_noargs",
            // Tests scenario where FUNCTION without args is modified.
            "modify_function_noargs",
            // Tests scenario where FUNCTION with args is dropped.
            "drop_function_args",
            // Tests scenario where FUNCTION with args is modified.
            "modify_function_args",
            // Tests scenario where the arg mode in FUNCTION is modified.
            "modify_function_args_mode",
            // Tests scenario where new FUNCTION with support function is added.
            "add_function_with_support_function",
            // Tests scenario where FUNCTION with support function is modified.
            "modify_function_with_support_function",
            // изменить тип out аргумента
            "function_out_type_chg",
            // изменить out параметра
            "function_out_name_chg",
            "function_out_type_add",
            "function_out_type_del",
            // Tests scenario where FUNCTION with args delete default.
            "modify_function_delete_default",
            // Tests scenario where FUNCTION with args add default.
            "modify_function_add_default",
            // Tests scenario where FUNCTION with args modify returns.
            "modify_function_modify_returns",
            // Tests scenario where FUNCTION with args is dropped.
            "drop_function_args2",
            // Tests scenario where FUNCTION with args is modified.
            "modify_function_args2",
            // Tests scenario where FUNCTION with same name but
            // different args is dropped.
            "drop_function_similar",
            // Tests scenario where FUNCTION with same name but
            // different args is modified.
            "modify_function_similar",
            // Tests scenario where FUNCTION with parallel mode is modified
            "modify_function_parallel",
            // Test scenario where checks that FUNCTION definition depends on the COLUMN of TABLE
            "depcy_function_defin_from_tbl_col",
            // Tests scenario where FUNCTION with depended column is modified
            "modify_function_depcy_col",
            // Test scenario where Greenplum FUNCTION is added
            "add_greenplum_function",
            // Tests scenario where TRIGGER is added.
            "add_trigger",
            // Tests scenario where TRIGGER with referencing is added.
            "add_trigger_referencing",
            // Tests scenario where TRIGGER is added in reverse add.
            "add_trigger_another_schema",
            // Tests scenario where TRIGGER is dropped.
            "drop_trigger",
            // Tests scenario where TRIGGER is dropped and func in another schema.
            "drop_trigger_another_schema",
            // Tests scenario where TRIGGER is change function.
            "change_trigger_function",
            // Tests scenario where TRIGGER is modified.
            "modify_trigger",
            // Tests scenario where CONSTRAINT TRIGGER is added.
            "add_constraint_trigger",
            // Tests scenario where TRIGGER with 'differable initially' parameter is added.
            "add_differable_initially_trigger",
            // Tests scenario where COLUMN CONSTRAINT is compared.
            "compare_column_constraints",
            // Tests scenario where FOREIGN TABLE COLUMN OPTIONS is compared.
            "compare_ftable_column_options",
            // Tests scenario where VIEW is added.
            "add_view",
            // Tests scenario where VIEW is dropped.
            "drop_view",
            // Tests scenario where VIEW is modified.
            "modify_view",
            // Tests scenario where VIEW is modified by addition of an option.
            "add_view_option",
            // Tests scenario where VIEW is modified by removal option.
            "delete_view_option",
            // Tests scenario where VIEW is modified by changing of an option.
            "modify_view_option",
            // Tests dropping view default value
            "alter_view_drop_default",
            // Tests adding view default value
            "alter_view_add_default",
            // Tests adding of comments
            "add_comments",
            // Tests dropping of comments
            "drop_comments",
            // Tests altering of comments
            "alter_comments",
            // Tests changing view default value
            "alter_view_change_default",
            // Tests view with default value
            "view_bug3080388",
            // Tests function arguments beginning with in_
            "function_bug3084274",
            // Tests addition of comment when new column has been added
            "add_comment_new_column",
            // Tests handling of quoted schemas in search_path
            "quoted_schema",
            // Tests adding new column with add defaults turned on
            "add_column_add_defaults",
            // Tests set, reset attributes of column
            "alter_table_alter_column_set_reset",
            // Tests set storage for column
            "alter_table_alter_column_set_storage",
            // Tests triggers with disable/enable options in table
            "alter_table_trigger",
            // Tests adding new sequence that is owned by table
            "add_owned_sequence",
            // Tests adding empty table
            "add_empty_table",
            // Tests adding and an extension and changing it's schema
            "add_ext",
            // Test changes in the middle of a simple dependency chain
            "depcy_simple1",
            // Test changes in the middle and tail of a simple dependency chain
            "depcy_simple2",
            "dropped_view_recreation",
            // Test composite type
            "add_type_composite",
            "drop_type_composite",
            "alter_type_composite_add_attr",
            "alter_type_composite_drop_attr",
            "alter_type_composite_alter_attr",
            // Test enum type
            "add_type_enum",
            "drop_type_enum",
            "type_enum_add_value",
            "type_enum_drop_value",
            "type_enum_swap_values",
            // Test range type
            "add_type_range",
            "drop_type_range",
            "type_range_chg",
            // Test base type
            "add_type_base",
            "drop_type_base",
            "type_base_chg",
            // Test domain
            "add_domain",
            "drop_domain",
            "alter_domain_drop_def",
            "alter_domain_set_def",
            "alter_domain_chg_def",
            "alter_domain_set_not_null",
            "alter_domain_drop_not_null",
            "alter_domain_add_constr",
            "alter_domain_drop_constr",
            "alter_domain_add_not_valid_constr",
            "alter_domain_drop_not_valid_constr",
            "drop_domain_data_type",
            "drop_domain_collation",
            // Test function type depcy
            "create_func_type",
            "drop_func_type",
            "chg_type_func",
            "drop_create_type_func",
            // Test table type depcy
            "drop_create_type_tbl",
            // Test table domain depcy
            "create_dom_tbl",
            "drop_dom_tbl",
            // Test column privilege
            "col_priv",
            "col_revoke_priv",
            "col_priv_new_tbl",
            "col_priv_tbl",
            // Test privilege
            "add_privilege",
            "drop_privilege",
            "chg_privilege",
            // Test restoring the default owner privilege
            "chg_def_owner_privilege",
            // Test restoring the default PUBLIC privilege
            "chg_def_public_privilege",
            // Test restoring the default PUBLIC privilege even if the owner is unavailable
            "chg_def_public_privilege_no_owner",
            // Test restoring the default owner and PUBLIC privilege
            "chg_def_owner_public_privilege",
            // Test restoring the default privileges of AGGREGATE
            "chg_def_privilege_aggr",
            // Test change owner
            "chg_owner",
            // Тест зависимости от колонки к функции default
            "col_to_func",
            // Тест зависимости от таблицы к функции default
            "tabl_to_func",
            // Dependency test in a scenario where one of the overloaded FUNCTION will be deleted.
            "depcy_drop_overloaded_function",
            // Вью со звездочкой
            "multiply_view",
            "multiply_view_1",
            "multiply_view_dif_schema",
            "add_rule",
            "add_rule_2",
            "drop_rule",
            "modify_constraint_validate",
            "modify_rule_enable",
            // Tests scenario where typed TABLE type is changed.
            "modify_typed_table_type",
            // Tests scenario where partition TABLE type is changed.
            "modify_partition_table_type",
            // Tests scenario where foreign TABLE type is changed.
            "modify_foreign_table_type",
            // Tests scenario where empty foreign TABLE is changed.
            "modify_empty_foreign_table",
            // Tests scenario where materialized VIEW options is changed.
            "modify_materialized_view_options",
            // Tests scenario where materialized VIEW access method is changed.
            "modify_materialized_view_access_method",
            // Tests scenario where materialized VIEW is changed.
            "modify_materialized_view",
            // Tests scenario where empty SEQUENCE is compared.
            "compare_empty_sequence",
            // Tests scenario where TRIGGER with multiple events is added.
            "add_multiple_events_trigger",
            // Tests scenario where RULE is disabled.
            "disable_rule",
            // Tests scenario where REGULAR TABLE is converted to PARTITION TABLE.
            "chg_reg_table_to_partition",
            // Tests scenario where PARTITION FOREIGN TABLE inherit is modified.
            "modify_partition_ftable_inherit",
            // Tests scenario where FTS PARSER is added, modified and deleted.
            "modify_fts_parser",
            // Tests scenario where FTS TEMPLATE is added, modified and deleted.
            "modify_fts_template",
            // Tests scenario where FTS DICTIONARY is added, modified and deleted.
            "modify_fts_dictionary",
            // Tests scenario where FTS DICTIONARY OPTIONS is added, modified and deleted.
            "modify_fts_dictionary_options",
            // Tests scenario where FTS CONFIGURATION is added, modified and deleted.
            "modify_fts_configuration",
            // Tests scenario where FTS CONFIGURATION OPTIONS is added, modified and deleted.
            "modify_fts_configuration_options",
            // Tests scenario where differable initially trigger is added.
            "add_differable_initially_trigger",
            // Tests scenario where COLUMN type and default is modified.
            "modify_column_type_and_default",
            // Tests scenario where COLUMN type is modified and default is deleted.
            "modify_column_type_and_drop_default",
            // Tests scenario where type in COLUMN of partitioned TABLE is changed.
            "modify_col_type_in_partitioned_tbl",
            // Tests scenario where type in COLUMN of inherited TABLE is changed.
            "modify_col_type_in_inherited_tbl",
            // Tests scenario where new OPERATOR is added.
            "add_operator",
            // Tests scenario where new overloaded OPERATOR is added.
            "add_operator_overloaded",
            // Tests scenario where new OPERATOR with using elements from other schemas is added.
            "add_operator_use_other_schema",
            // Tests scenario where OPERATOR is dropped.
            "drop_operator",
            // Tests scenario where options of OPERATOR is modified.
            "modify_operator",
            // Tests scenario where only RESTRICT and JOIN options of OPERATOR is modified.
            "modify_operator_restr_join",
            // Tests scenario where function (from other schema) of OPERATOR is modified.
            "modify_operator_use_other_schema",
            // Tests scenario where COLUMN is added to middle of TABLE definition.
            "add_column_middle",
            // Tests scenario where COLUMNS order is modified.
            "modify_column_order",
            // Tests scenario where new PROCEDURE is added.
            "add_procedure",
            // Tests scenario where new PROCEDURE without args is added.
            "add_procedure_noargs",
            // Tests scenario where new overloaded PROCEDURE is added.
            "add_procedure_overloaded",
            // Tests scenario where PROCEDURE is dropped.
            "drop_procedure",
            // Tests scenario where count of arguments in PROCEDURE is modified.
            "modify_procedure_count_args",
            // Tests scenario where body of PROCEDURE is modified.
            "modify_procedure",
            // Tests scenario where configuration of PROCEDURE is modified.
            "modify_procedure_configuration",
            // Tests scenario where new AGGREGATE is added.
            "add_aggregate",
            // Tests scenario where new overloaded AGGREGATE is added.
            "add_aggregate_overloaded",
            // Tests scenario where new AGGREGATE with using elements from other schemas is added.
            "add_aggregate_use_other_schema",
            // Tests scenario where new AGGREGATE with VARIADIC "any" arguments is added.
            "add_aggregate_variadic_any_args",
            // Tests scenario where AGGREGATE is dropped.
            "drop_aggregate",
            // Tests scenario where options of AGGREGATE is modified.
            "modify_aggregate",
            // Tests scenario for AGGREGATE where new privileges is added.
            "add_aggregate_privileges",
            // Tests scenario where COLUMN types compared with aliases.
            "compare_column_type_aliases",
            // Tests scenario where generated SEQUENCE is compared.
            "compare_generated_sequence",
            // Tests scenario where PRIVILEGE added to object with quoted name.
            "add_privilege_quoted_name",
            // Tests scenario where MATERIALIZED VIEW is refreshed.
            "refresh_materialized_view",
            // Tests scenario where table is recreated and its column dependency is dropped.
            "tabl_to_func_drop",
            // Tests scenario where owner and its privileges are both changed.
            "chg_owner_grant",
            // Tests scenario where AGGREGATE is compared.
            "compare_aggregate",
            // Tests scenario where TABLE is compared.
            "compare_tables",
            // Tests scenario where greenplum distribution TABLE clause is compared.
            "compare_greenplum_tables",
            // Test scenario where greenplum ALTER TABLE TEMPLATE is compared
            "compare_greenplum_tables_partition",
            // Test scenario where in composit type changed position columns
            "compare_type_composite",
            // Test scenario for where greenplum base type changed encoding options
            "compare_GP_base_type",
            // Tests scenario where greenplum table column encoding is compared.
            "compare_greenplum_table_column_encoding",
            // Tests scenario where INDEX is compared.
            "compare_indices",
            // Tests scenario where FUNCTION is compared.
            "compare_functions",
            // Tests scenario where CAST is compared.
            "compare_casts",
            // Tests scenario where FOREIGN DATA WRAPPER is compared.
            "compare_fdw",
            // Tests scenario where GP FOREIGN DATA WRAPPER is compared.
            "compare_greenplum_fdw",
            // Tests scenario where SERVER is compared.
            "compare_servers",
            // Test scenario where changes type of type from composite to enum
            "compare_different_types",
            // Tests scenario where USER MAPPING is compared.
            "compare_user_mapping",
            // Tests scenario where USER MAPPING is added.
            "add_user_mapping",
            // Tests scenario where USER MAPPING is dropped.
            "drop_user_mapping",
            // Tests scenario where FOREIGN DATA WRAPPER is dropped.
            "drop_fdw",
            // Tests scenario where SERVER is dropped.
            "drop_server",
            // Tests scenario where POLICY is compared.
            "compare_policies",
            // Tests scenario where COLLATION is compared.
            "compare_collation",
            // Tests scenario where COLUMN is added to modified table.
            "add_column_and_change_table",
            // Tests scenario where view column comments is reordered.
            "change_view_column_comment_order",
            // Tests scenario where logging of sequences changed.
            "alter_sequence_logged",
            // Tests scenario where OWNED BY of sequences changed.
            "alter_sequence_owned_by",
            // Tests scenario where NULLS DISTINCT option of index is altered.
            "alter_index_nulls_distinction",
            // Tests scenario where FUNCTION with comment is altered.
            "alter_function_with_comment",
            // Tests scenario where generated COLUMN with function is altered.
            "alter_column_generated_function",
            // Test scenario where FK common options for constraint is altered.
            "alter_foreign_constraint",
            // Test scenario where INDEX columns order is altered.
            "alter_index_columns_order",
            // Test scenario where CONSTRAINT columns order is altered.
            "alter_constraint_columns_order",
            // Test scenario where objects with quoted names is added.
            "add_objects_with_quoted_name",
            // Test scenario where objects with quoted names is added.
            "compare_statistics",
            // Test scenario where the option logged in sequences is changed
            "modify_logged_generated_sequence",
            // Test scenarios where original saved in Unix and new saved in Windows lines ending
            "test_encoding_table",
            "test_encoding_function",
            // Tests scenario where SCHEMAS is compared.
            "compare_schemas",
            // Test scenario where domain with constraints is altered.
            "alter_domain_with_constraints",
            // Test scenario where defaults are added and removed to procedure arguments
            "modify_procedure_args_default",
            // Test scenario where name of procedure argument is changed
            "modify_procedure_args_name",
            // Test scenario where type of procedure argument is changed
            "modify_procedure_args_type",
            // Test scenario where mode of procedure argument is changed
            "modify_procedure_args_mode",
            // Test scenario where object has unicode encoded identifier
            "compare_pg_unicode_identifiers",
            // Test scenario when one child partition index is dropped
            "drop_pg_child_partition_index"
    })
    void runDiff(String fileNameTemplate) throws IOException, InterruptedException {
        TestUtils.runDiff(fileNameTemplate, DatabaseType.PG, PgDiffTest.class);
    }

    /**
     * Comparing two objects that have no differences
     */
    @ParameterizedTest(name = "[{0}]: {1}")
    @CsvSource(delimiter = ';', value = {
            "compare_table;                 Comparing a table sugar",
            "compare_view;                  Comparing a query in a view",
            "compare_function;              Comparing a signature in a function",
    })
    void runCompare(String fileNameTemplate, String description) throws IOException, InterruptedException {
        String script = TestUtils.getScript(fileNameTemplate, new PgDiffArguments(), PgDiffTest.class);
        assertEquals(script.trim(), "");
    }

    /**
     * test adding comments in the end of the script
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "add_comments_in_end",
            "alter_comments_in_end",
            "alter_children_comments_in_end"
    })
    void testCommentsInScriptEnd(String fileNameTemplate) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setCommentsToEnd(true);
        String script = TestUtils.getScript(fileNameTemplate, args, PgDiffTest.class);
        TestUtils.compareResult(script, fileNameTemplate, PgDiffTest.class);
    }

    /**
     * test generation exeption block for table with identity & costraint in migration script
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "add_sequence_with_exeption_block",
            "add_costraints_with_exeption_block"
    })
    void testGenerateExistDoBlock(String fileNameTemplate) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setGenerateExistDoBlock(true);

        String script = TestUtils.getScript(fileNameTemplate, args, PgDiffTest.class);
        TestUtils.compareResult(script, fileNameTemplate, PgDiffTest.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "alter_greenplum_table"
    })
    void testCorrectOrderScript(String fileNameTamplate) throws IOException, InterruptedException {
        String script = TestUtils.getScript(fileNameTamplate, new PgDiffArguments(), PgDiffTest.class, true);
        TestUtils.compareResult(script, fileNameTamplate, PgDiffTest.class);
    }
}
