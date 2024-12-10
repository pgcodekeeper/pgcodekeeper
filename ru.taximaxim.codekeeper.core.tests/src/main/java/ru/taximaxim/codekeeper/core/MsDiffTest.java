/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for MS SQL statements
 *
 * @author galiev_mr
 */
class MsDiffTest {

    @ParameterizedTest
    @ValueSource(strings = {
            // Tests scenario where MS PRIVILEGES for columns is added.
            "add_ms_column_privileges",
            // Tests scenario where MS PRIVILEGES for columns is dropped.
            "drop_ms_column_privileges",
            // Tests scenario where MS PRIVILEGES for columns is modified.
            "modify_ms_column_privileges",
            // Tests scenario where MS PRIVILEGES for table is added.
            "add_ms_table_privileges",
            // Tests scenario where MS PRIVILEGES for table is dropped.
            "drop_ms_table_privileges",
            // Tests scenario where MS PRIVILEGES for table is modified.
            "modify_ms_table_privileges",
            // Tests scenario where MS PRIVILEGES for procedure is added.
            "add_ms_procedure_privileges",
            // Tests scenario where MS PRIVILEGES for procedure is dropped.
            "drop_ms_procedure_privileges",
            // Tests scenario where MS PRIVILEGES for procedure is modify.
            "modify_ms_procedure_privileges",
            // Tests scenario where MS PRIVILEGES for schema is added.
            "add_ms_schema_privileges",
            // Tests scenario where MS PRIVILEGES for schema is dropped.
            "drop_ms_schema_privileges",
            // Tests scenario where MS PRIVILEGES for schema is modified.
            "modify_ms_schema_privileges",

            // Tests scenario where OWNERS for ALL types is dropped.
            "drop_ms_owners",

            // TODO Uncomment the code when comments will be supported.
            // Tests scenario where MS "COMMENT" is added.
            // "add_ms_comment",
            // Tests scenario where MS "COMMENT" is dropped.
            // "drop_ms_comment",
            // Tests scenario where MS "COMMENT" is modified.
            // "modify_ms_comment",

            // Tests scenario where MS ASSEMBLY is added.
            "add_ms_assembly",
            // Tests scenario where MS ASSEMBLY is droped.
            "drop_ms_assembly",
            // Tests scenario where MS ASSEMBLY visibility is modified.
            "modify_ms_assembly_visibility",
            // Tests scenario where MS ASSEMBLY binaries is modified.
            "modify_ms_assembly_binaries",
            // Tests scenario where MS ASSEMBLY permission is modified.
            "modify_ms_assembly_permission",

            // Tests scenario where MS USER is added.
            "add_ms_user",
            // Tests scenario where MS USER is droped.
            "drop_ms_user",
            // Tests scenario where MS USER options is modified.
            "modify_ms_user_options",

            // Tests scenario where MS ROLE is added.
            "add_ms_role",
            // Tests scenario where MS ROLE is droped.
            "drop_ms_role",
            // Tests scenario where MS ROLE members is modified.
            "modify_ms_role_members",

            // Tests scenario where MS TABLE is added.
            "add_ms_table",
            // Tests scenario where MS TABLE is dropped.
            "drop_ms_table",
            // Tests scenario where MS TABLE identity is modified.
            "modify_ms_table_identity",
            // Tests scenario where MS TABLE trigger state is modified.
            "modify_ms_table_disable_trigger",
            // Tests scenario where MS TABLE option is modified.
            // TODO Uncomment the code when table option will be supported.
            // "modify_ms_table_option",
            // Tests scenario where MS TABLE CHANGE_TRACKING is dropped.
            "drop_ms_table_tracking",
            // Tests scenario where MS TABLE CHANGE_TRACKING is modified.
            "modify_ms_table_tracking",
            // Tests scenario where MS TABLE with partition is added.
            "add_ms_table_with_partition",
            // Tests scenario where MS TABLE with partition is dropped.
            "drop_ms_table_with_partition",
            // Tests scenario where MS TABLE with partition is modified.
            "modify_ms_table_with_partition",
            // Tests scenario where MS TABLE owner is modified.
            "modify_ms_table_owner",

            // Tests scenario where MS VIEW is added.
            "add_ms_view",
            // Tests scenario where MS VIEW with columns is added.
            "add_ms_view_with_columns",
            // Tests scenario where MS VIEW, which use table from other schema, is added.
            "add_ms_view_other_schema",
            // Tests scenario where MS VIEW is dropped.
            "drop_ms_view",
            // Tests scenario where MS VIEW is modified.
            "modify_ms_view",
            // Tests scenario where MS VIEW is modified by refresh.
            "modify_ms_view_by_refresh",
            // Tests scenario where MS VIEW trigger state is modified.
            "modify_ms_view_disable_trigger",

            // Tests scenario where MS WRAPPER TYPE is added.
            "add_ms_type",
            // Tests scenario where MS TABLE TYPE is added.
            "add_ms_table_type",
            // Tests scenario where MS EXTERNAL TYPE is added.
            "add_ms_external_type",
            // Tests scenario where MS TYPE is dropped.
            "drop_ms_type",
            // Tests scenario where MS TYPE is modified.
            "modify_ms_type",
            // Tests scenario where MS TYPE owner is modified.
            "modify_ms_type_owner",
            // Tests scenario where MS TYPE with function dep is modified.
            "modify_ms_type_with_dep",
            // Tests scenario where modified MS TABLE with FUNCTION dep & MS TYPE dep is tested.
            "modify_ms_table_with_type_dep",
            // Tests scenario where MS TYPE compared with no diff
            "compare_ms_table_type",

            // Tests scenario where MS INDEX is added.
            "add_ms_index",
            // Tests scenario where MS INDEX is dropped.
            "drop_ms_index",
            // Tests scenario where MS INDEX field columns modified.
            "modify_ms_index",
            // Tests scenario where MS INDEX field options modified.
            "modify_ms_index_option",
            // Tests scenario where MS INDEX compared with no diff
            "compare_ms_index",

            // Tests scenario where MS FUNCTION without args is added.
            "add_ms_function_noargs",
            // Tests scenario where MS FUNCTION without args is dropped.
            "drop_ms_function_noargs",
            // Tests scenario where MS FUNCTION without args is modified.
            "modify_ms_function_noargs",

            // Tests scenario where MS FUNCTION with args is added.
            "add_ms_function_args",
            // Tests scenario where MS FUNCTION with args is dropped.
            "drop_ms_function_args",
            // Tests scenario where MS FUNCTION with args is modified.
            "modify_ms_function_args",
            // Tests scenario where MS FUNCTION with args return type is modified.
            "modify_ms_function_args_return_tbl",
            // Tests scenario where default argument of MS FUNCTION with args is modified.
            "modify_ms_function_args_default",
            // Tests scenario where with option of MS FUNCTION with args is modified.
            "modify_ms_function_args_with",
            // Tests scenario where external name of MS FUNCTION with args is added.
            "add_ms_function_args_external",
            // Tests scenario where external name of MS FUNCTION with args is modified.
            "modify_ms_function_args_external",
            // Tests scenario where external name of MS FUNCTION with args is dropped.
            "drop_ms_function_args_external",
            // Tests scenario where type of MS FUNCTION is modified.
            "modify_ms_function_type",

            // Tests scenario where MS TABLE CONSTRAINT of column is added.
            "add_ms_constraint_column",
            // Tests scenario where MS TABLE CONSTRAINT of column is dropped.
            "drop_ms_constraint_column",
            // Tests scenario where MS TABLE CONSTRAINT, with default name, of column is dropped.
            "drop_ms_constraint_default_column",
            // Tests scenario where MS TABLE CONSTRAINT is disabled.
            "disable_ms_constraint",
            // Tests scenario where MS TABLE CONSTRAINT is enabled.
            "enable_ms_constraint",
            // Tests scenario where MS TABLE FOREIGN KEY CONSTRAINT is disabled.
            "disable_ms_constraint_fk",
            // Tests scenario where MS TABLE FOREIGN KEY CONSTRAINT is enabled.
            "enable_ms_constraint_fk",

            // Tests scenario where MS SEQUENCE is added.
            "add_ms_sequence",
            // Tests scenario where MS SEQUENCE with user-definied type is added.
            "add_ms_sequence_with_user_type",
            // Tests scenario where MS SEQUENCE is dropped.
            "drop_ms_sequence",
            // Tests scenario where MS SEQUENCE is modified.
            "modify_ms_sequence",
            // Tests scenario where MS SEQUENCE data type is modified.
            "modify_ms_sequence_data_type",
            // Tests scenario where MS SEQUENCE cashe is modified.
            "modify_ms_sequence_cache",

            // Tests scenario where MS TRIGGER is added.
            "add_ms_trigger",
            // Tests scenario where MS TRIGGER is dropped.
            "drop_ms_trigger",
            // Tests scenario where MS TRIGGER is modified.
            "modify_ms_trigger",

            // Tests scenario where MS PROCEDURE without args is added.
            "add_ms_procedure_noargs",
            // Tests scenario where MS PROCEDURE without args is dropped.
            "add_ms_procedure_noargs",
            // Tests scenario where MS PROCEDURE without args is modified.
            "add_ms_procedure_noargs",

            // Tests scenario where MS PROCEDURE is added.
            "add_ms_procedure",
            // Tests scenario where external MS PROCEDURE is added.
            "add_external_ms_procedure",
            // Tests scenario where external MS PROCEDURE is dropped.
            "drop_external_ms_procedure",
            // Tests scenario where MS PROCEDURE is dropped.
            "drop_ms_procedure",
            // Tests scenario where MS PROCEDURE is modified.
            "modify_ms_procedure",
            // Tests scenario where external MS PROCEDURE is modified.
            "modify_external_ms_procedure",
            // Tests scenario where MS PROCEDURE type is modified.
            "modify_ms_procedure_type",

            // Tests scenario where MS COLUMN is added to MS TABLE definition.
            "add_ms_column",
            // Tests scenario where MS COLUMN with default and not null is added.
            "add_ms_column_with_default_not_null",
            // Tests scenario where MS COLUMN is dropped from #MS TABLE.
            "drop_ms_column",
            // Tests scenario where MS COLUMN with index dependency is dropped from MS TABLE.
            "drop_ms_column_with_idx",
            // Tests scenario where MS COLUMN with default dependency is dropped from MS TABLE.
            "drop_ms_column_with_default",
            // Tests scenario where MS COLUMN not null value is added.
            "modify_ms_column_add_not_null",
            // Tests scenario where MS COLUMN not null value is dropped.
            "modify_ms_column_drop_not_null",
            // Tests scenario where MS COLUMN type is modified and default is dropped.
            "modify_ms_column_type_drop_default",
            // Tests scenario where MS COLUMN type, default, not null is modified.
            "modify_ms_column_type_default_not_null",
            // Tests scenario where MS COLUMN type is modified.
            "modify_ms_column_type",
            // Tests scenario where MS COLUMN collation is modified.
            "modify_ms_column_collation",
            // Tests scenario where MS COLUMN identity replication is modified.
            "modify_ms_column_replication",
            // Tests scenario where MS COLUMN default is modified.
            "modify_ms_column_default",
            // Tests scenario where MS COLUMN expression is modified.
            "modify_ms_column_expression",
            // Tests scenario where MS COLUMN type is modified, column has constraint.
            // TODO Uncomment the code when dependency columns from constraint will be supported.
            // "modify_ms_column_type_with_constraint",
            // Tests scenario where MS COLUMN options is added.
            "add_ms_column_options",
            // Tests scenario where MS COLUMN options is dropped.
            "drop_ms_column_options",
            // Tests scenario where MS COLUMNS added to recreated table.
            "add_ms_column_and_recreate",
            // Tests scenario where ansi_nulls parameter is changed.
            "modify_ansi_nulls",
            // Tests scenario where quoted_identifier parameter is changed.
            "modify_quoted_identifier",
            // Tests scenario where TABLE type is changed to memory optimized.
            "change_ms_table_type",
            // Tests scenario where MS COLUMN default with dependency is added.
            "add_ms_column_default_with_dep",
            // Tests scenario where MS COLUMN default dependency is modified.
            // TODO broken order, set default must be last
            "modify_ms_column_default_with_dep",
            // Tests scenario where MS FUNCTION with grant is altered.
            "alter_ms_function_with_grant",
            // Tests scenario where MS CONSTRAINTS is compared.
            "compare_ms_constraints",
            // Test scenario where MS COLUMN options is altered
            "alter_ms_column",
            // Test scenario where MS COLUMN with expression as type and dependent column is changed
            "alter_ms_column_expr",
            // Tests scenario where MS VIEW with xmlnamespace is compared.
            "modify_ms_view_xmlnamespace",
            // Tests scenario where MS TABLE on which MS VIEW depends with SCHEMABINDING is changed..
            "modify_ms_table_schemabinding",
            // Tests scenario where MS SCHEMAS is compared.
            "compare_ms_schemas",
            // Tests scenario where MS STATISTICS added
            "add_ms_statistics",
            // Tests scenario where MS STATISTICS altered
            "alter_ms_statistics",
            // Test scenario where MS STATISTICS compared without diffs
            "compare_ms_statistics",
            // Test scenario where MS STATISTICS dropped
            "drop_ms_statistics",
    })
    void runDiff(String fileNameTemplate) throws IOException, InterruptedException {
        TestUtils.runDiff(fileNameTemplate, DatabaseType.MS, MsDiffTest.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // Tests scenario where MS TABLE CHANGE_TRACKING is added.
            "add_ms_table_tracking",
            // Tests scenario where MS TABLE CONSTRAINT of column is modified.
            "modify_ms_constraint_column",
    })
    void testCorrectOrderScript(String fileNameTamplate) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(DatabaseType.MS);
        String script = TestUtils.getScript(fileNameTamplate, args, PgDiffTest.class, true);
        TestUtils.compareResult(script, fileNameTamplate, PgDiffTest.class);
    }
}
