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

import java.util.ListResourceBundle;

public final class CliArgsLocalizationsBunble extends ListResourceBundle {

    public static final String PATH = "<path>"; //$NON-NLS-1$
    public static final String JDBC = "<JDBC>"; //$NON-NLS-1$
    public static final String PATH_OR_JDBC = "<path or JDBC>"; //$NON-NLS-1$
    public static final String CHARSET = "<charset>"; //$NON-NLS-1$
    public static final String N = "<n>"; //$NON-NLS-1$
    public static final String NAME = "<name>"; //$NON-NLS-1$
    public static final String FILTER = "<filter>"; //$NON-NLS-1$
    public static final String TIMEZONE = "<timezone>"; //$NON-NLS-1$
    public static final String SOURCE = "SOURCE"; //$NON-NLS-1$
    public static final String DEST = "DEST"; //$NON-NLS-1$

    @Override
    protected Object[][] getContents() {
        return new String[][] {
            {PATH, PATH},
            {JDBC, JDBC},
            {PATH_OR_JDBC, PATH_OR_JDBC},
            {CHARSET, CHARSET},
            {N, N},
            {NAME, NAME},
            {FILTER, FILTER},
            {TIMEZONE, TIMEZONE},
            {SOURCE, SOURCE},
            {DEST, DEST},
            {"Help", Messages.CliArgs_Help}, //$NON-NLS-1$
            {"Version", Messages.CliArgs_Version}, //$NON-NLS-1$
            {"ListCharsets", Messages.CliArgs_list_charsets}, //$NON-NLS-1$
            {"ClearLibCache", Messages.CliArgs_clear_lib_cache}, //$NON-NLS-1$
            {"parse", Messages.CliArgs_parse}, //$NON-NLS-1$
            {"graph", Messages.CliArgs_graph}, //$NON-NLS-1$
            {"insert", Messages.CliArgs_insert}, //$NON-NLS-1$
            {"mode", Messages.CliArgs_mode}, //$NON-NLS-1$
            {"source", Messages.CliArgs_source}, //$NON-NLS-1$
            {"target", Messages.CliArgs_target}, //$NON-NLS-1$
            {"output", Messages.CliArgs_output}, //$NON-NLS-1$
            {"run-on-target", Messages.CliArgs_run_on_target}, //$NON-NLS-1$
            {"run-on", Messages.CliArgs_run_on}, //$NON-NLS-1$
            {"in-charset", Messages.CliArgs_in_charset}, //$NON-NLS-1$
            {"out-charset", Messages.CliArgs_out_charset}, //$NON-NLS-1$
            {"error", Messages.CliArgs_show_error}, //$NON-NLS-1$
            {"ignore-errors", Messages.CliArgs_ignore_errors}, //$NON-NLS-1$
            {"no-privileges", Messages.CliArgs_no_privileges}, //$NON-NLS-1$
            {"keep-newlines", Messages.CliArgs_keep_newlines}, //$NON-NLS-1$
            {"simplify-views", Messages.CliArgs_simplify_views}, //$NON-NLS-1$
            {"add-transaction", Messages.CliArgs_add_transaction}, //$NON-NLS-1$
            {"no-check-function-bodies", Messages.CliArgs_no_check_function_bodies}, //$NON-NLS-1$
            {"enable-function-bodies-dependencies", Messages.CliArgs_enable_function_bodies_dependencies}, //$NON-NLS-1$
            {"time-zone", Messages.CliArgs_time_zone}, //$NON-NLS-1$
            {"pre-script", Messages.CliArgs_pre_script}, //$NON-NLS-1$
            {"post-script", Messages.CliArgs_post_script}, //$NON-NLS-1$
            {"ignore-column-order", Messages.CliArgs_ignore_column_order}, //$NON-NLS-1$
            {"generate-constraint-not-valid", Messages.CliArgs_generate_constraint_not_valid}, //$NON-NLS-1$
            {"using-off", Messages.CliArgs_using_off}, //$NON-NLS-1$
            {"migrate-data", Messages.CliArgs_migrate_data}, //$NON-NLS-1$
            {"concurrently-mode", Messages.CliArgs_concurrently_mode}, //$NON-NLS-1$
            {"generate-exist", Messages.CliArgs_generate_exist}, //$NON-NLS-1$
            {"generate-exist-do-block", Messages.CliArgs_generate_exist_do_block}, //$NON-NLS-1$
            {"drop-before-create", Messages.CliArgs_drop_before_create}, //$NON-NLS-1$
            {"comments-to-end", Messages.CliArgs_comments_to_end}, //$NON-NLS-1$
            {"safe-mode", Messages.CliArgs_safe_mode}, //$NON-NLS-1$
            {"allow-danger-ddl", Messages.CliArgs_allow_danger_ddl}, //$NON-NLS-1$
            {"allowed-object", Messages.CliArgs_allowed_object}, //$NON-NLS-1$
            {"stop-not-allowed", Messages.CliArgs_stop_not_allowed}, //$NON-NLS-1$
            {"selected-only", Messages.CliArgs_selected_only}, //$NON-NLS-1$
            {"ignore-list", Messages.CliArgs_ignore_list}, //$NON-NLS-1$
            {"ignore-schema", Messages.CliArgs_ignore_schema}, //$NON-NLS-1$
            {"src-lib-xml", Messages.CliArgs_src_lib_xml}, //$NON-NLS-1$
            {"src-lib", Messages.CliArgs_src_lib}, //$NON-NLS-1$
            {"src-lib-no-priv", Messages.CliArgs_src_lib_no_priv}, //$NON-NLS-1$
            {"tgt-lib-xml", Messages.CliArgs_tgt_lib_xml}, //$NON-NLS-1$
            {"tgt-lib", Messages.CliArgs_tgt_lib}, //$NON-NLS-1$
            {"tgt-lib-no-priv", Messages.CliArgs_tgt_lib_no_priv}, //$NON-NLS-1$
            {"lib-safe-mode", Messages.CliArgs_lib_safe_mode}, //$NON-NLS-1$
            {"ignore-concurrent-modification", Messages.CliArgs_ignore_concurrent_modification}, //$NON-NLS-1$
            {"db-type", Messages.CliArgs_db_type}, //$NON-NLS-1$
            {"update-project", Messages.CliArgs_update_project}, //$NON-NLS-1$
            {"graph-depth", Messages.CliArgs_graph_depth}, //$NON-NLS-1$
            {"graph-reverse", Messages.CliArgs_graph_reverse}, //$NON-NLS-1$
            {"graph-name", Messages.CliArgs_graph_name}, //$NON-NLS-1$
            {"graph-filter-object", Messages.CliArgs_graph_filter_object}, //$NON-NLS-1$
            {"graph-invert-filter", Messages.CliArgs_graph_invert_filter}, //$NON-NLS-1$
            {"insert-name", Messages.CliArgs_insert_name}, //$NON-NLS-1$
            {"insert-filter", Messages.CliArgs_insert_filter}, //$NON-NLS-1$
            {"verify-source", Messages.CliArgs_verify_source}, //$NON-NLS-1$
            {"verify-rule-set", Messages.CliArgs_verify_rule_set} //$NON-NLS-1$
            };
    }
}
