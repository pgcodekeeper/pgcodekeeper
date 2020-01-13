package cz.startnet.utils.pgdiff;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;

/**
 * Tests for MS SQL statements
 *
 * @author galiev_mr
 */
@RunWith(value = Parameterized.class)
public class MsDiffTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return ApgdiffTestUtils.getParameters(
                new Object[][] {
                    // Tests scenario where MS PRIVILEGES for columns is added.
                    {"add_ms_column_privileges"},
                    // Tests scenario where MS PRIVILEGES for columns is dropped.
                    {"drop_ms_column_privileges"},
                    // Tests scenario where MS PRIVILEGES for columns is modified.
                    {"modify_ms_column_privileges"},
                    // Tests scenario where MS PRIVILEGES for table is added.
                    {"add_ms_table_privileges"},
                    // Tests scenario where MS PRIVILEGES for table is dropped.
                    {"drop_ms_table_privileges"},
                    // Tests scenario where MS PRIVILEGES for table is modified.
                    {"modify_ms_table_privileges"},
                    // Tests scenario where MS PRIVILEGES for procedure is added.
                    {"add_ms_procedure_privileges"},
                    // Tests scenario where MS PRIVILEGES for procedure is dropped.
                    {"drop_ms_procedure_privileges"},
                    // Tests scenario where MS PRIVILEGES for procedure is modify.
                    {"modify_ms_procedure_privileges"},
                    // Tests scenario where MS PRIVILEGES for schema is added.
                    {"add_ms_schema_privileges"},
                    // Tests scenario where MS PRIVILEGES for schema is dropped.
                    {"drop_ms_schema_privileges"},
                    // Tests scenario where MS PRIVILEGES for schema is modified.
                    {"modify_ms_schema_privileges"},

                    // Tests scenario where OWNERS for ALL types is dropped.
                    {"drop_ms_owners"},

                    // TODO Uncomment the code when comments will be supported.
                    // Tests scenario where MS "COMMENT" is added.
                    // {"add_ms_comment"},
                    // Tests scenario where MS "COMMENT" is dropped.
                    // {"drop_ms_comment"},
                    // Tests scenario where MS "COMMENT" is modified.
                    // {"modify_ms_comment"},

                    // Tests scenario where MS SCHEMA is added.
                    {"add_ms_schema"},
                    // Tests scenario where MS SCHEMA is dropped.
                    {"drop_ms_schema"},
                    // Tests scenario where name of MS SCHEMA is modified.
                    {"modify_ms_schema_name"},
                    // Tests scenario where MS SCHEMA is modified.
                    {"modify_ms_schema"},
                    // Tests scenario where MS SCHEMA owner is modified.
                    {"modify_ms_schema_owner"},

                    // Tests scenario where MS ASSEMBLY is added.
                    {"add_ms_assembly"},
                    // Tests scenario where MS ASSEMBLY is droped.
                    {"drop_ms_assembly"},
                    // Tests scenario where MS ASSEMBLY visibility is modified.
                    {"modify_ms_assembly_visibility"},
                    // Tests scenario where MS ASSEMBLY binaries is modified.
                    {"modify_ms_assembly_binaries"},
                    // Tests scenario where MS ASSEMBLY permission is modified.
                    {"modify_ms_assembly_permission"},

                    // Tests scenario where MS USER is added.
                    {"add_ms_user"},
                    // Tests scenario where MS USER is droped.
                    {"drop_ms_user"},
                    // Tests scenario where MS USER options is modified.
                    {"modify_ms_user_options"},

                    // Tests scenario where MS ROLE is added.
                    {"add_ms_role"},
                    // Tests scenario where MS ROLE is droped.
                    {"drop_ms_role"},
                    // Tests scenario where MS ROLE members is modified.
                    {"modify_ms_role_members"},

                    // Tests scenario where MS TABLE is added.
                    {"add_ms_table"},
                    // Tests scenario where MS TABLE is dropped.
                    {"drop_ms_table"},
                    // Tests scenario where MS TABLE identity is modified.
                    {"modify_ms_table_identity"},
                    // Tests scenario where MS TABLE trigger state is modified.
                    {"modify_ms_table_disable_trigger"},
                    // Tests scenario where MS TABLE option is modified.
                    // TODO Uncomment the code when table option will be supported.
                    // {"modify_ms_table_option"},
                    // Tests scenario where MS TABLE CHANGE_TRACKING is added.
                    {"add_ms_table_tracking"},
                    // Tests scenario where MS TABLE CHANGE_TRACKING is dropped.
                    {"drop_ms_table_tracking"},
                    // Tests scenario where MS TABLE CHANGE_TRACKING is modified.
                    {"modify_ms_table_tracking"},
                    // Tests scenario where MS TABLE with partition is added.
                    {"add_ms_table_with_partition"},
                    // Tests scenario where MS TABLE with partition is dropped.
                    {"drop_ms_table_with_partition"},
                    // Tests scenario where MS TABLE with partition is modified.
                    {"modify_ms_table_with_partition"},
                    // Tests scenario where MS TABLE owner is modified.
                    {"modify_ms_table_owner"},

                    // Tests scenario where MS VIEW is added.
                    {"add_ms_view"},
                    // Tests scenario where MS VIEW with columns is added.
                    {"add_ms_view_with_columns"},
                    // Tests scenario where MS VIEW, which use table from other schema, is added.
                    {"add_ms_view_other_schema"},
                    // Tests scenario where MS VIEW is dropped.
                    {"drop_ms_view"},
                    // Tests scenario where MS VIEW is modified.
                    {"modify_ms_view"},
                    // Tests scenario where MS VIEW is modified by refresh.
                    {"modify_ms_view_by_refresh"},
                    // Tests scenario where MS VIEW trigger state is modified.
                    {"modify_ms_view_disable_trigger"},

                    // Tests scenario where MS WRAPPER TYPE is added.
                    {"add_ms_type"},
                    // Tests scenario where MS TABLE TYPE is added.
                    {"add_ms_table_type"},
                    // Tests scenario where MS EXTERNAL TYPE is added.
                    {"add_ms_external_type"},
                    // Tests scenario where MS TYPE is dropped.
                    {"drop_ms_type"},
                    // Tests scenario where MS TYPE is modified.
                    {"modify_ms_type"},
                    // Tests scenario where MS TYPE owner is modified.
                    {"modify_ms_type_owner"},
                    // Tests scenario where MS TYPE with function dep is modified.
                    {"modify_ms_type_with_dep"},

                    // Tests scenario where MS INDEX is added.
                    {"add_ms_index"},
                    // Tests scenario where MS INDEX is dropped.
                    {"drop_ms_index"},
                    // Tests scenario where MS INDEX definition is modified.
                    {"modify_ms_index"},
                    // Tests scenario where MS INDEX definition is modified.
                    {"modify_ms_index_option"},

                    // Tests scenario where MS FUNCTION without args is added.
                    {"add_ms_function_noargs"},
                    // Tests scenario where MS FUNCTION without args is dropped.
                    {"drop_ms_function_noargs"},
                    // Tests scenario where MS FUNCTION without args is modified.
                    {"modify_ms_function_noargs"},

                    // Tests scenario where MS FUNCTION with args is added.
                    {"add_ms_function_args"},
                    // Tests scenario where MS FUNCTION with args is dropped.
                    {"drop_ms_function_args"},
                    // Tests scenario where MS FUNCTION with args is modified.
                    {"modify_ms_function_args"},
                    // Tests scenario where MS FUNCTION with args return type is modified.
                    {"modify_ms_function_args_return_tbl"},
                    // Tests scenario where default argument of MS FUNCTION with args is modified.
                    {"modify_ms_function_args_default"},
                    // Tests scenario where with option of MS FUNCTION with args is modified.
                    {"modify_ms_function_args_with"},
                    // Tests scenario where external name of MS FUNCTION with args is added.
                    {"add_ms_function_args_external"},
                    // Tests scenario where external name of MS FUNCTION with args is modified.
                    {"modify_ms_function_args_external"},
                    // Tests scenario where external name of MS FUNCTION with args is dropped.
                    {"drop_ms_function_args_external"},
                    // Tests scenario where type of MS FUNCTION is modified.
                    {"modify_ms_function_type"},

                    // Tests scenario where MS TABLE CONSTRAINT of column is added.
                    {"add_ms_constraint_column"},
                    // Tests scenario where MS TABLE CONSTRAINT of column is dropped.
                    {"drop_ms_constraint_column"},
                    // Tests scenario where MS TABLE CONSTRAINT of column is modified.
                    {"modify_ms_constraint_column"},
                    // Tests scenario where MS TABLE CONSTRAINT, with default name, of column is dropped.
                    // TODO Uncomment the code when the deleting of the "default constraint" will be supported.
                    // {"drop_ms_constraint_default_column"},
                    // Tests scenario where MS TABLE CONSTRAINT is disabled.
                    {"disable_ms_constraint"},
                    // Tests scenario where MS TABLE CONSTRAINT is enabled.
                    {"enable_ms_constraint"},
                    // Tests scenario where MS TABLE FOREIGN KEY CONSTRAINT is disabled.
                    {"disable_ms_constraint_fk"},
                    // Tests scenario where MS TABLE FOREIGN KEY CONSTRAINT is enabled.
                    {"enable_ms_constraint_fk"},

                    // Tests scenario where MS SEQUENCE is added.
                    {"add_ms_sequence"},
                    // Tests scenario where MS SEQUENCE with user-definied type is added.
                    {"add_ms_sequence_with_user_type"},
                    // Tests scenario where MS SEQUENCE is dropped.
                    {"drop_ms_sequence"},
                    // Tests scenario where MS SEQUENCE is modified.
                    {"modify_ms_sequence"},
                    // Tests scenario where MS SEQUENCE data type is modified.
                    {"modify_ms_sequence_data_type"},
                    // Tests scenario where MS SEQUENCE cashe is modified.
                    {"modify_ms_sequence_cache"},

                    // Tests scenario where MS TRIGGER is added.
                    {"add_ms_trigger"},
                    // Tests scenario where MS TRIGGER is dropped.
                    {"drop_ms_trigger"},
                    // Tests scenario where MS TRIGGER is modified.
                    {"modify_ms_trigger"},

                    // Tests scenario where MS PROCEDURE without args is added.
                    {"add_ms_procedure_noargs"},
                    // Tests scenario where MS PROCEDURE without args is dropped.
                    {"add_ms_procedure_noargs"},
                    // Tests scenario where MS PROCEDURE without args is modified.
                    {"add_ms_procedure_noargs"},

                    // Tests scenario where MS PROCEDURE is added.
                    {"add_ms_procedure"},
                    // Tests scenario where external MS PROCEDURE is added.
                    {"add_external_ms_procedure"},
                    // Tests scenario where external MS PROCEDURE is dropped.
                    {"drop_external_ms_procedure"},
                    // Tests scenario where MS PROCEDURE is dropped.
                    {"drop_ms_procedure"},
                    // Tests scenario where MS PROCEDURE is modified.
                    {"modify_ms_procedure"},
                    // Tests scenario where external MS PROCEDURE is modified.
                    {"modify_external_ms_procedure"},
                    // Tests scenario where MS PROCEDURE type is modified.
                    {"modify_ms_procedure_type"},

                    // Tests scenario where MS COLUMN is added to MS TABLE definition.
                    {"add_ms_column"},
                    // Tests scenario where MS COLUMN with default and not null is added.
                    {"add_ms_column_with_default_not_null"},
                    // Tests scenario where MS COLUMN is dropped from #MS TABLE.
                    {"drop_ms_column"},
                    // Tests scenario where MS COLUMN with index dependency is dropped from MS TABLE.
                    {"drop_ms_column_with_idx"},
                    // Tests scenario where MS COLUMN not null value is added.
                    {"modify_ms_column_add_not_null"},
                    // Tests scenario where MS COLUMN not null value is dropped.
                    {"modify_ms_column_drop_not_null"},
                    // Tests scenario where MS COLUMN type is modified and default is dropped.
                    {"modify_ms_column_type_drop_default"},
                    // Tests scenario where MS COLUMN type, default, not null is modified.
                    {"modify_ms_column_type_default_not_null"},
                    // Tests scenario where MS COLUMN type is modified.
                    {"modify_ms_column_type"},
                    // Tests scenario where MS COLUMN collation is modified.
                    {"modify_ms_column_collation"},
                    // Tests scenario where MS COLUMN identity replication is modified.
                    {"modify_ms_column_replication"},
                    // Tests scenario where MS COLUMN default is modified.
                    {"modify_ms_column_default"},
                    // Tests scenario where MS COLUMN expression is modified.
                    {"modify_ms_column_expression"},
                    // Tests scenario where MS COLUMN type is modified, column has constraint.
                    // TODO Uncomment the code when dependency columns from constraint will be supported.
                    // {"modify_ms_column_type_with_constraint"},
                    // Tests scenario where MS COLUMN options is added.
                    {"add_ms_column_options"},
                    // Tests scenario where MS COLUMN options is dropped.
                    {"drop_ms_column_options"},
                    // Tests scenario where MS COLUMNS added to recreated table.
                    {"add_ms_column_and_recreate"},
                    // Tests scenario where ansi_nulls parameter is changed.
                    {"modify_ansi_nulls"},
                    // Tests scenario where quoted_identifier parameter is changed.
                    {"modify_quoted_identifier"},
                    // Tests scenario where TABLE type is changed to memory optimized.
                    {"change_ms_table_type"},
                    // Tests scenario where MS COLUMN default with dependency is added.
                    {"add_ms_column_default_with_dep"},
                    // Tests scenario where MS COLUMN default dependency is modified.
                    // TODO broken order, set default must be last
                    {"modify_ms_column_default_with_dep"},
                });
    }

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    private final String fileNameTemplate;

    public MsDiffTest(final String fileNameTemplate) {
        this.fileNameTemplate = fileNameTemplate;
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    @Test
    public void runDiff() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(true);

        PgDatabase dbOld = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, MsDiffTest.class, args);
        PgDatabase dbNew = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, MsDiffTest.class, args);

        ApgdiffTestUtils.runDiffSame(dbOld, fileNameTemplate, args);
        ApgdiffTestUtils.runDiffSame(dbNew, fileNameTemplate, args);

        String script = new PgDiff(args).diffDatabaseSchemas(dbOld, dbNew, null);

        ApgdiffTestUtils.compareResult(script, fileNameTemplate, MsDiffTest.class);
    }
}
