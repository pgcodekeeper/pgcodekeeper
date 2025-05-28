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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.localizations;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.core.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    public static String AbstractAnalysisLauncher_error_prefix;

    public static String AbstractExprWithNmspc_log_ambiguos_ref;

    public static String AbstractExprWithNmspc_log_cte_contains_cols;

    public static String AbstractExprWithNmspc_log_dupl_col_alias;

    public static String AbstractExprWithNmspc_log_dupl_cte;

    public static String AbstractExprWithNmspc_log_dupl_unaliased_table;

    public static String AbstractExprWithNmspc_log_not_alternative;

    public static String AbstractPgTable_log_inherits_not_found;

    public static String AbstractPgTable_log_schemas_not_found;

    public static String AbstractStatementReader_start;

    // common
    public static String Utils_log_err_deserialize;

    public static String Utils_log_err_serialize;

    // pgdiff.loader
    public static String Connection_DatabaseJdbcAccessError;

    public static String Constraint_WarningMismatchedConstraintTypeForClusterOn;

    public static String ProjectUpdater_error_backup_restore;

    public static String ProjectUpdater_error_no_tempdir;

    public static String ProjectUpdater_error_update;

    public static String ProjectUpdater_log_err_restore_project;

    public static String ProjectUpdater_log_restoring_err;

    public static String ProjectUpdater_log_start_full_update;

    public static String ProjectUpdater_log_start_partial_update;

    public static String ProjectUpdater_log_upd_project_err;

    public static String ProjectUpdater_log_update_err_restore_proj;

    public static String ProjectUpdater_old_db_null;

    public static String PgDiff_read_error;

    public static String DatabaseType_unsupported_type;

    public static String DbObjType_unsupported_type;

    public static String DepcyGraph_log_col_is_missed;

    public static String DepcyGraph_log_no_such_table;

    public static String DepcyGraph_log_remove_deps;

    public static String FileUtils_error_while_read_uri_lib;

    public static String Function_log_variable_not_found;

    public static String IgnoreParser_log_ignor_list_analyzing_err;

    public static String IgnoreParser_log_ignor_list_parsed_obj;

    public static String IgnoreParser_log_ignor_list_parser_tree;

    public static String IgnoreParser_log_load_ignored_list;

    public static String IgnoreSchemaList_log_ignored_schema;

    public static String InsertWriter_select_size_error_message;

    public static String InsertWriter_select_size_info_message;

    public static String JdbcChLoader_log_connection_db;

    public static String JdbcLoader_log_read_db_objects;

    public static String JdbcLoader_log_reading_db_jdbc;

    public static String JdbcLoader_log_succes_queried;

    public static String JdbcLoaderBase_log_check_extension;

    public static String JdbcLoaderBase_log_check_gp_db;

    public static String JdbcLoaderBase_log_current_obj;

    public static String JdbcLoaderBase_log_event_trigger_disabled;

    public static String JdbcLoaderBase_log_get_last_oid;

    public static String JdbcLoaderBase_log_get_last_system_obj_oid;

    public static String JdbcLoaderBase_log_get_list_system_types;

    public static String JdbcLoaderBase_log_get_obj_count;

    public static String JdbcLoaderBase_log_get_result_gp;

    public static String JdbcLoaderBase_log_get_roles;

    public static String JdbcLoaderBase_log_get_total_obj_count;

    public static String JdbcLoaderBase_log_load_version;

    public static String JdbcLoaderBase_log_not_support_privil;

    public static String JdbcLoaderBase_log_old_version_used;

    public static String JdbcLoaderBase_log_reading_ms_version;

    public static String JdbcLoaderBase_log_reading_pg_version;

    public static String JdbcLoaderBase_log_waiting_antlr_tasks;

    public static String ModelExporter_log_create_dirs;

    public static String ModelExporter_log_create_dir_err_contains_dir;

    public static String ModelExporter_log_create_dir_err_no_dir;

    public static String ModelExporter_log_delete_file;

    public static String ModelExporter_log_old_database_not_null;

    public static String ModelExporter_log_output_dir_no_exist_err;

    public static String Table_TypeParameterChange;

    public static String TokenLoader_log_file_not_exist;

    public static String TreeFlattener_log_filter_obj;

    public static String TreeFlattener_log_ignore_children;

    public static String TreeFlattener_log_ignore_obj;

    public static String ScriptParser_log_load_dump;

    public static String Select_log_aster_qual_not_found;

    public static String Select_log_complex_not_found;

    public static String Select_log_not_alter_item;

    public static String Select_log_not_alter_prim;

    public static String Select_log_not_alter_right_part;

    public static String Select_log_not_alter_select;

    public static String Select_log_not_alter_selectops;

    public static String SequencesReader_log_not_found_table;

    public static String Storage_WarningUnableToDetermineStorageType;

    public static String AlterTriggerError;

    public static String VerificationFunction_body_start;

    public static String VerificationFunction_function_length;

    public static String VerificationFunction_function_params;

    public static String VerificationFunction_ncss;

    public static String VerificationFunctionTreeListener_case_block;

    public static String VerificationFunctionTreeListener_quotation_marks;

    public static String VerificationFunctionTreeListener_temp_table;

    public static String VerificationGrant_denied_grant;

    public static String VerificationIndents_body_start_rule;

    public static String VerificationIndents_cyclomatic_complexy;

    public static String VerificationIndents_eol_before_stat;

    public static String VerificationIndents_indent_size;

    public static String VerificationIndents_semicolon_after_simple_sql;

    public static String VerificationIndents_space_after_comma;

    public static String VerificationIndents_space_after_if;

    public static String VerificationIndents_space_math_operators;

    public static String XmlStore_read_error;

    public static String XmlStore_root_error;

    public static String XmlStore_write_error;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
