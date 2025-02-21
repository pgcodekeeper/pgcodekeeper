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
package ru.taximaxim.codekeeper.ui.localizations;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    // common phrases
    public static String dB_host;
    public static String dB_name;
    public static String dB_password;
    public static String dB_user;
    public static String entry_name;
    public static String domain;
    public static String pgpass_passwords_supported;
    public static String calculating_diff;
    public static String runnable_has_not_finished;
    public static String select_all;
    public static String select_none;
    public static String choose_dump_file_with_changes;
    public static String empty_selection;
    public static String error_in_differ_thread;
    public static String error_in_the_project_modifier_thread;
    public static String please_check_at_least_one_row;
    public static String projectEditorDiffer_save_project;
    public static String projectProperties_timezone_for_all_db_connections;
    public static String projectProperties_error_occurs_while_saving_properties;
    public static String add;
    public static String delete;

    // ui
    public static String AddCommentDialogMessage;
    public static String AddCommentDialogTitle;
    public static String sqlScriptDialog_exception_during_script_execution;
    public static String ShowConsoleParticipant_remove;

    public static String ShowConsoleParticipant_remove_all;

    public static String ShowConsoleParticipant_terminate;

    public static String SQLEditorContentOutlinePage_disabled_by_option;

    public static String SQLEditorContentOutlinePage_hide_non_dangerous;

    public static String SQLEditorContentOutlinePage_sort_alphabetically;

    public static String SQLEditorMainPage_bracket_highlighting;

    public static String SQLEditorMainPage_disable_parser;

    public static String SQLEditorMainPage_enclosing_brackets;

    public static String SQLEditorMainPage_matching_bracket_and_caret_location;

    public static String SQLEditorMainPage_matching_bracket;

    public static String SQLEditorMainPage_matching_bracket_highlighting_color;

    public static String SQLEditorStatementTypes_funcs;

    public static String SQLEditorStatementTypes_multi_comments;

    public static String SQLEditorStatementTypes_quoted_identifier;

    public static String SQLEditorStatementTypes_reserved;

    public static String SQLEditorStatementTypes_single_comments;

    public static String SQLEditorStatementTypes_string_literals;

    public static String SQLEditorStatementTypes_types;

    public static String SQLEditorStatementTypes_unreserved;

    public static String SQLEditorSytaxColoring_bold;

    public static String SQLEditorSytaxColoring_color;

    public static String SQLEditorSytaxColoring_font_and_color_prefs;

    public static String SQLEditorSytaxColoring_italic;

    public static String SQLEditorSytaxColoring_strikethrough;

    public static String SQLEditorSytaxColoring_underline;

    public static String SqlEditor_script_delete_dialog_message;
    public static String SqlEditor_script_delete_dialog_title;
    public static String SqlEditor_selected_text_error;

    public static String SQLEditorCompletionProcessor_show_templates;
    public static String SQLEditorCompletionProcessor_show_keywords;

    public static String SQLEditorFormatterPrefPage_add_whitespace_after_operators;

    public static String SQLEditorFormatterPrefPage_add_whitespace_before_operators;

    public static String SQLEditorFormatterPrefPage_disable;

    public static String SQLEditorFormatterPrefPage_indent_size;

    public static String SQLEditorFormatterPrefPage_indent_type;

    public static String SQLEditorFormatterPrefPage_remove_trailing_whitespace;

    public static String SQLEditorFormatterPrefPage_tab;

    public static String SQLEditorFormatterPrefPage_whitespace;

    public static String SQLEditorInformationControl_quick_fix_available;

    public static String SQLEditorInformationControl_multiple_quick_fix_available;

    public static String SqlEditor_update_ddl;

    public static String UiProgressReporter_warning;

    public static String UIProjectLoader_error_loading_structure;

    public static String UpdateDdl_read_only_db_message;

    public static String UpdateDdl_read_only_db_title;

    public static String UpdateDdl_select_source;
    public static String UpdateDdl_select_source_msg;

    public static String sqlScriptDialog_script_contains_statements_that_may_modify_data;
    public static String sqlScriptDialog_script_execution_interrupted;
    public static String sqlScriptDialog_warning;
    public static String stdStreamRedirector_completed_with_code;
    public static String manualDepciesDialog_dependant_dependency;
    public static String manualDepciesDialog_depends_on;
    public static String manualDepciesDialog_object;
    public static String manualDepciesDialog_add;
    public static String manualDepciesDialog_remove;
    public static String commitDialog_user_selected_elements;
    public static String commitDialog_depcy_elements;

    // ui.connectiontypepref
    public static String connectionTypePrefPage_color;
    public static String connectionTypePrefPage_copyType;
    public static String connectionTypePrefPage_createType;
    public static String connectionTypePrefPage_editType;
    public static String connectionTypePrefPage_import;
    public static String connectionTypePrefPage_export;
    public static String connectionTypePrefPage_name;
    public static String connectionTypePrefPage_opening_error;
    public static String connectionTypePrefPage_saving_error;

    // ui.dbstore
    public static String dbPicker_port;
    public static String dbStoreEditorDialog_cannot_save_entry;
    public static String dbStoreEditorDialog_db_info;
    public static String dbStoreEditorDialog_not_valid_port_number;
    public static String dbStoreEditorDialog_empty_name;

    // ui.differ
    public static String dbSource_db_is_not_loaded_yet_object_is_null;
    public static String dbSource_executing_pg_dump;
    public static String dbSource_loading_dump;
    public static String dbSource_loading_tree;
    public static String differ_direct_diff;
    public static String differ_get_differ;
    public static String differ_reverse_diff;
    public static String diffTableViewer_change_type_for_database;
    public static String diffTableViewer_change_type_for_project;
    public static String diffTableViewer_container;
    public static String diffTableViewer_db_user;
    public static String diffTableViewer_deselect_child_elements;
    public static String diffTableViewer_git_user;
    public static String diffTableViewer_mark_selected_elements;
    public static String diffTableViewer_unmark_selected_elements;
    public static String diffTableViewer_invert_selection;
    public static String diffTableViewer_object_name;
    public static String diffTableViewer_object_type;
    public static String diffTableViewer_objects;
    public static String diffTableViewer_open_diff_in_new_window;
    public static String diffTableViewer_select_child_elements;
    public static String diffTableViewer_use_java_regular_expressions_see_more;
    public static String diffTableViewer_use_regular_expressions;
    public static String diffTreeViewer_collapse_all;
    public static String diffTreeViewer_collapse_subtree;
    public static String diffTreeViewer_debug_view;
    public static String diffTreeViewer_deselect_subtree;
    public static String diffTreeViewer_expand_all;
    public static String diffTreeViewer_expand_subtree;
    public static String diffTreeViewer_select_subtree;
    public static String treeDiffer_building_diff_tree;
    public static String reading_db_from_jdbc;

    // change perspective
    public static String remember_choice_toggle;
    public static String change_perspective_message;
    public static String change_perspective_title;

    public static String clear_all;
    public static String prespective_change_status_always;
    public static String prespective_change_status_ask;
    public static String prespective_change_status_never;

    // ui.externalcalls
    public static String pgDumper_bad_pg_dump_version_output;

    // ui.handlers
    public static String database;

    public static String database_type;

    // ui.parts
    public static String commitPartDescr_show_commit_window;
    public static String commitPartDescr_commit_confirmation;
    public static String commitPartDescr_commiting;
    public static String commitPartDescr_exporting_db_model;
    public static String commitPartDescr_modifying_db_model;
    public static String commitPartDescr_the_following_changes_be_included_in_commit;

    public static String copy;
    public static String DatabaseType_unsupported_type;

    public static String CodeFilter_search_by_code;

    public static String DbUpdatePrefPage_generate_exist_do_block;

    public static String DbUpdatePrefPage_comments_to_end;

    public static String CommitDialog_privileges_must_be_saved;

    public static String CommitDialog_save_privileges;

    public static String CommitDialog_unchecked_objects_can_occur_unexpected_errors;

    public static String ConvertProject_convert_dialog_message;

    public static String ConvertProject_convert_dialog_title;

    public static String ConvertProject_select_type_desc;

    public static String ConvertProject_select_type_title;

    public static String CodekeeperWorkbenchErrorHandler_copy_all;

    public static String diffPresentationPane_getting_changes_for_diff;
    public static String project_either_closed_or_deleted;

    // ui.pgdbproject
    public static String diffWizard_Diff;
    public static String diffWizard_diff_parameters;
    public static String diffWizard_diff_tree;
    public static String diffWizard_target_encoding;
    public static String ignoredObjectPrefListEditor_ignore_contents;

    public static String ignoredObjectPrefListEditor_name;

    public static String ignoredObjectPrefListEditor_regular;

    public static String ignoredObjectPrefListEditor_type;

    public static String initProjectFromSource_exporting_db_model;
    public static String initProjectFromSource_init_request_but_no_schema_source;
    public static String initProjectFromSource_initializing_project;
    public static String initProjectFromSource_ioexception_while_creating_project;
    public static String newProjWizard_error_in_initializing_repo_from_source;
    public static String newProjWizard_new_pg_db_project;

    public static String txtNameEditingSupport_cannot_add_empty;

    // query results tabs
    public static String resultSetView_close;
    public static String resultSetView_close_others;
    public static String resultSetView_close_tabs_to_the_right;
    public static String resultSetView_close_tabs_to_the_left;
    public static String resultSetView_close_all;

    // ui.prefs
    public static String dBUpdatePrefPage_alter_column_statement;
    public static String dBUpdatePrefPage_drop_column_statement;
    public static String dBUpdatePrefPage_drop_table;
    public static String dBUpdatePrefPage_set_warning_when_next_statements_present;
    public static String dbUpdatePrefPage_check_function_bodies;
    public static String dbUpdatePrefPage_switch_on_off_using;
    public static String dbUpdatePrefPage_use_command_for_ddl_update;
    public static String dbUpdatePrefPage_Enter_cmd_to_update_ddl_with_sql_script;

    public static String DbUpdatePrefPage_script_add_transaction;

    public static String dbUpdatePrefPage_ignore_privileges;

    public static String DbMenu_no_group;

    public static String DbPropertyListEditor_properties_hint;
    public static String DbPropertyListEditor_pg_link_hint;
    public static String DbPropertyListEditor_ms_link_hint;
    public static String DbPropertyListEditor_ch_link_hint;
    public static String DbPropertyListEditor_new_property;
    public static String DbPropertyListEditor_field_name;
    public static String DbPropertyListEditor_field_value;
    public static String DbPropertyListEditor_already_present;
    public static String DbPropertyListEditor_tbl_col_name;
    public static String DbPropertyListEditor_tbl_col_value;

    public static String DbStoreCombo_db_binding_property;
    public static String DbStoreCombo_db_binding_property_title;

    public static String DbStoreEditorDialog_failed_connection;

    public static String DbStoreEditorDialog_failed_connection_reason;

    public static String DbStoreEditorDialog_ignore_file_list;

    public static String DbStoreEditorDialog_choice_db_group;

    public static String DbStoreEditorDialog_connection_properties;

    public static String DbStoreEditorDialog_connection_type;

    public static String DbStoreEditorDialog_dump_custom_parameters;

    public static String DbStoreEditorDialog_dump_executable;

    public static String DbStoreEditorDialog_dump_file_dialog_header;

    public static String DbStoreEditorDialog_dump_filter;

    public static String DbStoreEditorDialog_dump_properties;

    public static String DbStoreEditorDialog_dump_switch;

    public static String DbStoreEditorDialog_dump_browse;

    public static String DbStoreEditorDialog_pgcodekeeperignore_files_filter;

    public static String DbStoreEditorDialog_read_only;

    public static String DbStoreEditorDialog_read_only_description;

    public static String DbStoreEditorDialog_auto_generation;

    public static String DbStoreEditorDialog_auto_generation_description;

    public static String DbStoreEditorDialog_learn_more;

    public static String DbStoreEditorDialog_ms_cert;

    public static String DbStoreEditorDialog_select_ignore_file;

    public static String DbStoreEditorDialog_success;

    public static String DbStoreEditorDialog_successfull_connection;

    public static String DbStoreEditorDialog_test_connection;

    public static String DbStoreEditorDialog_trust_mssql;

    public static String DbStoreEditorDialog_use_win_auth;

    public static String DbStoreEditorDialog_warning_message;

    public static String DbStoreEditorDialog_win_auth;

    public static String DbStorePicker_choose_dir;

    public static String DbStorePicker_db_connection;

    public static String DbStorePicker_db_schema_source;

    public static String DbStorePicker_load_from_dir;

    public static String DbStorePicker_load_from_file;

    public static String DbStorePicker_open_db_store;

    public static String DbStorePrefPage_action_add_new;

    public static String DbStorePrefPage_already_present;

    public static String DbStorePrefPage_action_copy;

    public static String DbStorePrefPage_action_edit;

    public static String DbStorePrefPage_db_group;

    public static String DbStorePrefPage_db;

    public static String DbStorePrefPage_export_db;

    public static String DbStorePrefPage_import_db_list;

    public static String DbStorePrefPage_opening_error;

    public static String DbStorePrefPage_saving_error;

    public static String DbStorePrefPage_xml_files;

    public static String DbStorePrefPage_pg_pass_file_filter;

    public static String DbStorePrefPage_pg_pass_file_select_title;

    public static String DbStorePrefPage_pg_pass_import_tooltip;

    public static String DbStorePrefPage_secure_storage_error_text_linux;

    public static String DbStorePrefPage_secure_storage_error_text_other;

    public static String DbStorePrefPage_secure_storage_error;

    public static String DbStorePrefPage_secure_storage_error_title;

    public static String DbUpdatePrefPage_add_pre_post_script;

    public static String DbUpdatePrefPage_allow_data_movement;

    public static String DbUpdatePrefPage_alter_seq_restart_statement;

    public static String DbUpdatePrefPage_option_drop_object;

    public static String DbUpdatePrefPage_option_if_exists;

    public static String DbUpdatePrefPage_print_index_with_concurrently;

    public static String DbUpdatePrefPage_script_from_selected_objs;

    public static String DbUpdatePrefPage_update_statement;

    public static String dbUpdatePrefPage_create_script_project_directory;

    public static String dbUpdatePrefPage_status_alway_create;

    public static String dbUpdatePrefPage_status_ask_create;

    public static String dbUpdatePrefPage_status_never_create;

    public static String DepcyGraphView_project;

    public static String DepcyGraphView_remote;

    public static String DepcyGraphView_show_columns;

    public static String DependencyEditorDialog_name;

    public static String DependencyEditorDialog_enter_path;

    public static String DependencyEditorDialog_relative_path;

    public static String DependencyProperties_add_directory;

    public static String DependencyProperties_add_file;

    public static String DependencyProperties_attention;

    public static String DependencyProperties_clear_cache;

    public static String DependencyProperties_clear_cache_descr;

    public static String DependencyProperties_clear_cache_error;

    public static String DependencyProperties_clear_libraries_cache;

    public static String DependencyProperties_copy_dependency;

    public static String DependencyProperties_create_new_dependency;

    public static String DependencyProperties_edit_dependency;

    public static String DependencyProperties_ignore_priv_warn;

    public static String DependencyProperties_ignore_privileges;

    public static String DependencyProperties_load_dependencies;

    public static String DependencyProperties_load_nested;

    public static String DependencyProperties_owner;

    public static String DependencyProperties_path;

    public static String DependencyProperties_safe_mode;

    public static String DependencyProperties_safe_mode_desc;

    public static String DependencyProperties_select_directory;

    public static String DiffPaneViewer_btn_switch;
    public static String DiffPaneViewer_project;

    public static String DiffPresentationPane_any_file_filter;

    public static String DiffPresentationPane_attention;

    public static String DiffPresentationPane_refresh_link;
    public static String DiffPresentationPane_close_link;
    public static String DiffPresentationPane_error_loading_changes;

    public static String DiffPresentationPane_project_modified;

    public static String DiffPresentationPane_remote_changed_notification;

    public static String DiffPresentationPane_sql_file_filter;

    public static String DiffPresentationPane_zip_file_filter;

    public static String DiffTableViewer_collapse_all;
    public static String DiffTableViewer_apply_to;
    public static String DiffTableViewer_apply_to_custom;

    public static String DiffTableViewer_copy_as_regex;

    public static String DiffTableViewer_copy_object_names;

    public static String DiffTableViewer_database;

    public static String DiffTableViewer_directory;

    public static String DiffTableViewer_file;

    public static String DiffTableViewer_error_creating_graph;

    public static String DiffTableViewer_error_reading_git_history;

    public static String DiffTableViewer_expand_all;

    public static String DiffTableViewer_filter_placeholder;
    public static String DiffTableViewer_get_changes;
    public static String DiffTableViewer_get_changes_custom;

    public static String DiffTableViewer_library;

    public static String DiffTableViewer_menu_build_graph;

    public static String DiffTableViewer_path;

    public static String DiffTableViewer_reading_git_history;

    public static String DiffTableViewer_reset_sorting;

    public static String DiffTableViewer_save_to_DB;

    public static String DiffTableViewer_save_to_project;

    public static String DiffTableViewer_selected;

    public static String DiffTableViewer_selected_count;

    public static String DiffTableViewer_show_filters;

    public static String DiffTableViewer_to_database;

    public static String DiffTableViewer_to_project;

    public static String DiffTableViewer_type;

    public static String DiffTableViewer_uri;

    public static String DiffWizard_db_tz;

    public static String DiffWizard_select_db_tz;

    public static String DiffWizard_show_advanced_options;

    public static String DiffWizard_different_types;

    public static String DiffWizard_source;

    public static String DiffWizard_target;

    public static String executableFileFieldEditor_value_must_be_file_with_execute_permission_set;

    public static String ProjectProperties_force_unix_newlines;

    public static String ProjectProperties_force_unix_newlines_desc;

    public static String generalPrefPage_show_console_when_program_write_to_console;

    public static String getChangesCustomDialog_custom_prefs_description;
    public static String getChangesCustomDialog_run_with_specified_prefs;

    public static String HeapSizeChecker_heap_size_warning_title;
    public static String HeapSizeChecker_heap_size_warning;
    public static String HeapSizeChecker_do_not_ask_again;
    public static String HeapSizeCheckerDialog_set_heap_size;
    public static String HeapSizeCheckerDialog_new_heap_size;
    public static String HeapSizeCheckerDialog_manual_heap_editing_title;
    public static String Eclipse_restart_offer;
    public static String EclipseIniWriter_manual_editing_link;

    public static String IgnoredObjectPrefListEditor_already_present;

    public static String IgnoredObjectPrefListEditor_contents;

    public static String IgnoredObjectPrefListEditor_enter_name;

    public static String IgnoredObjectPrefListEditor_new_ignored;

    public static String IgnoredObjectPrefListEditor_object_name;

    public static String IgnoredObjectPrefListEditor_pattern;

    public static String IgnoredObjectPrefListEditor_qualified;

    public static String IgnoredObjectPrefListEditor_qualified_name;

    public static String IgnoredObjectsPrefPage_convert_to_white_list;
    public static String IgnoredObjectsPrefPage_convert_to_black_list;

    public static String IgnoredObjectsPrefPage_error_getting_ignores_list;
    public static String IgnoredObjectsPrefPage_error_saving_ignores_list;

    public static String IgnoredObjectsPrefPage_these_objects_are_ignored_info;
    public static String IgnoredObjectsPrefPage_these_objects_are_ignored_info_white;

    public static String IgnoredSchemaPrefListEditor_black_list_schema_ignor;

    public static String IgnoredSchemaPrefListEditor_white_list_schema_ignor;

    public static String IgnoreListProperties_create_new_file;

    public static String IgnoreListProperties_default_ignore_tooltip;

    public static String IgnoreListProperties_edit_pgcodekeeperignore;

    public static String IgnoreListEditorDialog_excluded_objects_list_editor;
    public static String IgnoreListEditorDialog_save;
    public static String IgnoreListEditorDialog_cancel;
    public static String IgnoreListEditorDialog_error_file;
    public static String IgnoreListEditorDialog_save_ignore_file;

    public static String ImportProjWizard_title;

    public static String ManualDepciesDialog_set_add_depcies;

    public static String MisplaceCompletionProposal_rename_file_to;
    public static String MockDataPage_add_column;

    public static String MockDataPage_any_value;

    public static String MockDataPage_column_down;

    public static String MockDataPage_column_generator;

    public static String MockDataPage_column_name;

    public static String MockDataPage_column_type;

    public static String MockDataPage_column;

    public static String MockDataPage_column_up;

    public static String MockDataPage_delete_column;

    public static String MockDataPage_delete_optional;

    public static String MockDataPage_description;

    public static String MockDataPage_empty_columns;

    public static String MockDataPage_empty_table_name;

    public static String MockDataPage_explicit_type_cast;

    public static String MockDataPage_generation_failed;

    public static String MockDataPage_incorrect_row_count;

    public static String MockDataPage_invalid_value;

    public static String MockDataPage_length;

    public static String MockDataPage_maximum_value;

    public static String MockDataPage_range_end;

    public static String MockDataPage_range_start;

    public static String MockDataPage_row_count;

    public static String MockDataPage_step;

    public static String MockDataPage_table_name;

    public static String MockDataWizard_create_data;

    public static String MockDataWizard_create_data_table;

    public static String NavigationLibrariesActionProvider_clear_library_cache;

    public static String NavigationLibrariesActionProvider_failed_to_clear_library_cache;

    public static String NavigationLibrariesActionProvider_failed_to_open_library;

    public static String NavigationLibrariesActionProvider_failed_to_refresh_library;

    public static String NavigationLibrariesActionProvider_open_library;

    public static String NavigationLibrariesActionProvider_refresh_library;

    public static String NavigatorRootActionProvider_open_action;

    public static String NavigatorRootLabelProvider_open_editor;

    public static String NewObjectWizard_create_object;

    public static String NewObjectWizard_invalid_input_format;

    public static String NewObjectWizard_invalid_schema_format;

    public static String NewProjWizard_error_creating_project;

    public static String NewProjWizard_error_tz_query;

    public static String NewProjWizard_cannot_delete_project;

    public static String NewProjWizard_create_project;

    public static String NewProjWizard_initializing_check;

    public static String NewProjWizard_initializing_title;

    public static String NewProjWizard_proj_init;

    public static String NewProjWizard_proj_init_src;

    public static String NewProjWizard_select_charset;

    public static String NewProjWizard_select_project_type;

    public static String NewProjWizard_select_time_zone;

    public static String NewProjWizard_get_from_db;

    public static String NewProjWizard_not_empty_dir;
    public static String NormalizeProject_are_you_sure;

    public static String NormalizeProject_error_while_updating_project;

    public static String NormalizeProject_exporting_project;

    public static String NormalizeProject_normalize_project;

    public static String NormalizeProject_normalizing_project;

    public static String NormalizeProject_project_normalized;

    public static String NormalizeProject_project_normalized_success;

    public static String SqlEditor_absent_builder_message;

    public static String SqlEditor_absent_builder_title;

    public static String SqlMergeViewer_compare_label;

    public static String OpenEditor_error_open_project_editor;
    public static String OpenProjectUtils_file;

    public static String OpenProjectUtils_high_proj_version;

    public static String OpenProjectUtils_low_proj_version;

    public static String OpenProjectUtils_proj_version_unsupported;

    public static String OpenProjectUtils_proj_version_warn;

    public static String OpenProjectUtils_schema_convert_error;

    public static String OpenProjectUtils_unexpected_version_error;

    public static String OpenProjectUtils_unknown_proj_version;

    public static String OpenProjectUtils_update_format;

    public static String OpenProjectUtils_update_warning;

    public static String OpenProjectUtils_updating_project;

    public static String OpenProjectUtils_version_error;

    public static String PgDbParser_error_loading_db;

    public static String PgImport_error_default_name;

    public static String PgImport_error_metadata;

    public static String PgImport_error_no_name;

    public static String PgImport_import_error;

    public static String PgImportWizardImportPage_already_exist;

    public static String PgImportWizardImportPage_browse;

    public static String PgImportWizardImportPage_name;

    public static String PgImportWizardImportPage_project;

    public static String PgImportWizardImportPage_select_project;

    public static String PgImportWizardImportPage_select_root_directory;

    public static String PgImportWizardImportPage_select_root_for_import;

    public static String PgNavigatorActionProvider_failed_to_open_editor;

    public static String PgNavigatorActionProvider_open_with_sql_editor;

    public static String PgObject_cant_find_projects;

    public static String Object_create_object;

    public static String PgObject_empty_name;

    public static String PgObject_file_creation_error;

    public static String PgObject_object_name;

    public static String PgObject_object_type;

    public static String PgObject_parent_type;

    public static String PgObject_project_name;

    public static String PgObject_select_project;

    public static String PgObject_table;

    public static String PgObject_view;

    public static String Object_wizard_title;

    public static String PgPassDialog_close;

    public static String PgPassDialog_import;

    public static String PgPassDialog_title;

    public static String PgRenameRefactoringInputPage_new_name;

    public static String PrefListEditor_cannot_add;

    public static String PrePostScriptPrefPage_post;

    public static String PrePostScriptPrefPage_pre;

    public static String PrePostScriptPrefPage_pre_post_descr;

    public static String ProjectEditorDiffer_apply_db;

    public static String ProjectEditorDiffer_apply_project;

    public static String ProjectEditorDiffer_apply_to;

    public static String ProjectEditorDiffer_changed_direction_of_roll_on_title;
    public static String ProjectEditorDiffer_changed_direction_of_roll_on;

    public static String ProjectEditorDiffer_commit_error;
    public static String ProjectEditorDiffer_error_bad_input_type;

    public static String ProjectEditorDiffer_error_creating_file;

    public static String ProjectEditorDiffer_error_opening_script_editor;

    public static String ProjectEditorDiffer_error_refreshing_project;

    public static String ProjectEditorDiffer_failed_egit_commit;
    public static String ProjectEditorDiffer_lib_change_error_message;

    public static String ProjectEditorDiffer_lib_change_warning_message;

    public static String ProjectEditorDiffer_lib_change_warning_title;

    public static String ProjectEditorDiffer_library_duplication_exception;

    public static String ProjectEditorDiffer_library_duplication_title;

    public static String ProjectEditorDiffer_no_differences;

    public static String ProjectEditorDiffer_database;

    public static String ProjectEditorDiffer_project;
    public static String ProjectEditorDiffer_script_creation_message;

    public static String ProjectEditorDiffer_script_creation_title;

    public static String ProjectEditorDiffer_different_types;
    public static String ProjectEditorDiffer_different_types_msg;

    public static String ProjectEditorDiffer_override_cancel;

    public static String ProjectEditorDiffer_override_objects;

    public static String ProjectEditorDiffer_override_privileges;

    public static String ProjectEditorDiffer_work_with;

    public static String ProjectEditorInput_pgcodekeeper_project;

    public static String ProjectEditorPrefPage_action_no_action;

    public static String ProjectEditorPrefPage_action_reset;

    public static String ProjectEditorPrefPage_action_type;

    public static String ProjectEditorPrefPage_action_update;

    public static String ProjectEditorPrefPage_show_git_user;

    public static String ProjectOverrideView_link_with_editor;

    public static String ProjectOverrideView_new_location;

    public static String ProjectOverrideView_old_location;

    public static String ProjectOverrideView_open_new_location;

    public static String ProjectOverrideView_open_old_location;

    public static String dbUpdatePrefPage_script_deleting_status;

    public static String dbUpdatePrefPage_status_always_delete;

    public static String dbUpdatePrefPage_status_ask_delete;

    public static String dbUpdatePrefPage_status_never_delete;

    public static String ProjectProperties_enable_proj_prefs;

    public static String ProjectProperties_use_global_ignore_list;

    public static String ProjectProperties_change_projprefs_warn;

    public static String ProjectProperties_posix_is_used_warn;

    public static String ProjectProperties_binding_to_db_connection;

    public static String ProjectProperties_disable_parser_in_external_files;

    public static String sqlScriptDialog_script_select_storage;
    public static String StdStreamRedirector_error_reading_std;
    public static String StdStreamRedirector_error_reading_std_external;
    public static String StdStreamRedirector_process_returned_with_error;
    public static String StdStreamRedirector_wait_destroy_interrupted_unexpectedly;
    public static String StdStreamRedirector_wait_thread_interrupted_unexpectedly;

    public static String StoragePrefListEditor_file_already_added;

    public static String StoragePrefListEditor_open_snapshot;

    public static String Duration_expected_format;

    public static String TreeDiffer_unknown_error;

    public static String TreeDiffer_loading_schema;

    public static String TreeDiffer_loading_schema_from;

    public static String TreeDiffer_schema_load_error;

    public static String edit;

    public static String ApplyCustomDialog_constraint_not_valid;

    public static String BuildDepsGraphDialog_build_dep_graph;

    public static String BuildDepsGraphDialog_calls;

    public static String BuildDepsGraphDialog_dependencies;

    public static String BuildDepsGraphDialog_schema_source;

    public static String BuildDepsGraphDialog_search_dep;

    public static String BuildDepsGraphDialog_show;

    public static String FilterDialog_cancel;

    public static String FilterDialog_db_user;

    public static String FilterDialog_db_user_label;

    public static String FilterDialog_git_user;

    public static String FilterDialog_git_user_label;

    public static String FilterDialog_only_local_changes;

    public static String FilterDialog_only_non_library_objects;

    public static String FilterDialog_reset;

    public static String FilterDialog_schema_filter_placeholder;

    public static String FilterDialog_search_by_container;

    public static String FilterDialog_show_change_types;

    public static String FilterDialog_show_object_types;

    public static String FilterDialog_sql_filter_placehodlder;

    public static String FilterDialog_title;

    // diff wizard
    public static String diffwizard_diffpage_source_warning;
    public static String diffwizard_diffpage_target_warning;
    public static String diffwizard_diffpage_select;
    public static String diffwizard_pagepartial_description;

    public static String generalPrefPage_perspective_changing_status;

    public static String GeneralPrefPage_body_depcy_tooltip;

    public static String GeneralPrefPage_enable_body_dependencies;

    public static String GeneralPrefPage_ignore_column_order;

    public static String GeneralPrefPage_show_full_code;

    public static String GeneralPrefPage_ignore_concurrent_modification;

    public static String GeneralPrefPage_alert_if_heap_size_less_than_necessary;

    public static String GeneralPrefPage_time_to_clean_parser_cache;

    public static String GeneralPrefPage_clean_parser_cache;

    public static String GeneralPrefPage_format_object_code_automatically;

    public static String GeneralPrefPage_number_of_loading_threads;

    public static String GeneralPrefPage_number_of_loading_threads_updated;

    public static String GeneralPrefPage_with;

    public static String GeneralPrefPage_number_of_thread;

    public static String GeneralPrefPage_reuse_open_compare_editor;

    public static String GeneralPrefPage_save_in_security_storage;

    public static String GeneralPrefPage_show_diff_errors;

    public static String GeneralPrefPage_simplify_view;

    public static String GetChanges_select_source;

    public static String GetChanges_select_source_msg;

    public static String GetSystemObjects_save_dialog_title;

    public static String GetSystemObjects_save_success_message;

    public static String GetSystemObjects_save_success_title;

    public static String GitUserReader_error_reading_local_changes;

    // usage report
    public static String EclipseEnvironment_Error_SavePreferences;

    public static String EclipseIniWriter_change_manually;

    public static String EclipseIniWriter_replace_parameter_msg;

    public static String EclipseIniWriter_updated;

    public static String LabelPicker_choice_db;

    public static String LibraryContainer_root;

    public static String UsageReport_Reporting_Usage;
    public static String UsageReport_Querying_Enablement;

    public static String UsageReportPreferencePage_Description;
    public static String UsageReportPreferencePage_AllowReporting;

    public static String UsageReport_DialogTitle;
    public static String UsageReport_DialogMessage;

    public static String UsageReportPreferencePage_ReportedValues;
    public static String UsageReportPreferencePage_CurrentUsageHit;
    public static String UsageReportPreferencePage_FirstUsageHit;
    public static String UsageReportPreferencePage_Components;
    public static String UsageReportPreferencePage_Version;
    public static String UsageReportPreferencePage_LastUsageHit;
    public static String UsageReportPreferencePage_NumberOfUsageHits;
    public static String UsageReportPreferencePage_OperatingSystem;
    public static String UsageReportPreferencePage_OperatingSystemVersion;
    public static String UsageReportPreferencePage_ProductId;
    public static String UsageReportPreferencePage_ProductVersion;

    public static String UsageReportPreferencePage_JavaVersion;

    public static String UsageReportPreferencePage_JvmName;

    public static String UsageReportPreferencePage_Events;
    public static String UsageReportPreferencePage_EventComponent;
    public static String UsageReportPreferencePage_EventVersion;
    public static String UsageReportPreferencePage_EventAction;
    public static String UsageReportPreferencePage_EventValue;

    public static String QuickUpdate_danger;

    public static String QuickUpdate_different_types;

    public static String QuickUpdate_empty_script;

    public static String QuickUpdate_error;

    public static String QuickUpdate_error_charset;

    public static String QuickUpdate_file_modified;

    public static String QuickUpdate_migration_failed;

    public static String QuickUpdate_multiple_schemas;

    public static String QuickUpdate_quick_update;

    public static String QuickUpdate_updating_db;

    public static String QuickUpdate_updating_project;

    public static String ReferenceSearchResult_matches;

    public static String RenameDefinitionChange_error_resource_already_exists;

    public static String RenameDefinitionProcessor_rename_object;

    public static String ErrorMessageDialog_dialog_title;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    public static String getBundleName() {
        return BUNDLE_NAME;
    }

    private Messages() {
    }
}
