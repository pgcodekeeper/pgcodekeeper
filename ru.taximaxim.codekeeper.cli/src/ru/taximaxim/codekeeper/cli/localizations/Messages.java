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
package ru.taximaxim.codekeeper.cli.localizations;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.cli.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    public static String CliArgs_Help;
    public static String CliArgs_Version;
    public static String CliArgs_list_charsets;
    public static String CliArgs_clear_lib_cache;
    public static String CliArgs_parse;
    public static String CliArgs_graph;
    public static String CliArgs_insert;
    public static String CliArgs_mode;
    public static String CliArgs_source;
    public static String CliArgs_target;
    public static String CliArgs_output;
    public static String CliArgs_run_on_target;
    public static String CliArgs_run_on;
    public static String CliArgs_in_charset;
    public static String CliArgs_out_charset;
    public static String CliArgs_show_error;
    public static String CliArgs_ignore_errors;
    public static String CliArgs_no_privileges;
    public static String CliArgs_keep_newlines;
    public static String CliArgs_simplify_views;
    public static String CliArgs_add_transaction;
    public static String CliArgs_no_check_function_bodies;
    public static String CliArgs_enable_function_bodies_dependencies;
    public static String CliArgs_time_zone;
    public static String CliArgs_pre_script;
    public static String CliArgs_post_script;
    public static String CliArgs_ignore_column_order;
    public static String CliArgs_generate_constraint_not_valid;
    public static String CliArgs_using_off;
    public static String CliArgs_migrate_data;
    public static String CliArgs_concurrently_mode;
    public static String CliArgs_generate_exist;
    public static String CliArgs_generate_exist_do_block;
    public static String CliArgs_drop_before_create;
    public static String CliArgs_comments_to_end;
    public static String CliArgs_safe_mode;
    public static String CliArgs_allow_danger_ddl;
    public static String CliArgs_allowed_object;
    public static String CliArgs_stop_not_allowed;
    public static String CliArgs_selected_only;
    public static String CliArgs_ignore_list;
    public static String CliArgs_ignore_schema;
    public static String CliArgs_src_lib_xml;
    public static String CliArgs_src_lib;
    public static String CliArgs_src_lib_no_priv;
    public static String CliArgs_tgt_lib_xml;
    public static String CliArgs_tgt_lib;
    public static String CliArgs_tgt_lib_no_priv;
    public static String CliArgs_lib_safe_mode;
    public static String CliArgs_ignore_concurrent_modification;
    public static String CliArgs_db_type;
    public static String CliArgs_update_project;
    public static String CliArgs_graph_depth;
    public static String CliArgs_graph_reverse;
    public static String CliArgs_graph_name;
    public static String CliArgs_graph_filter_object;
    public static String CliArgs_graph_invert_filter;
    public static String CliArgs_insert_name;
    public static String CliArgs_insert_filter;
    public static String CliArgs_verify_source;
    public static String CliArgs_verify_rule_set;

    public static String CliArgs_error_source_dest;
    public static String CliArgs_error_argument_null;
    public static String CliArgs_error_source_null;
    public static String CliArgs_error_concurrently_mode_wrong_option;
    public static String CliArgs_error_different_types;
    public static String CliArgs_error_target_non_db;
    public static String CliArgs_error_run_on_non_jdbc;
    public static String CliArgs_error_message_cannot_database_with_project;
    public static String CliArgs_error_source_non_db;
    public static String CliArgs_error_wrong_mode;
    public static String CliArgs_error_wrong_db_type;

    public static String Main_danger_statements;
    public static String Main_show_stacktrace;
    public static String Main_cach_clear;

    public static String Utils_error_get_version;

    public static String DatabaseType_unsupported_type;
    public static String UsageHelp;
    public static String Version;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
