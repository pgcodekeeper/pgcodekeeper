package ru.taximaxim.codekeeper.ui.localizations;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.localizations.messages"; //$NON-NLS-1$
    
    // common phrases
    public static String unexpected_error_while_saving_preferences;
    public static String consider_using_pgpass_file_instead;
    public static String dB_host;
    public static String dB_name;
    public static String dB_password;
    public static String dB_user;
    public static String entry_name;
    public static String providing_password_here_is_insecure;
    public static String warning;
    public static String calculating_diff;
    public static String runnable_has_not_finished;
    public static String select_all;
    public static String select_none;
    public static String create_marker_file_named;
    public static String manually_and_try_again;
    public static String missing_marker_file_in_working_directory;
    public static String this_password_will_show_up_in_logs;
    public static String bad_port;
    public static String choose_dump_file_with_changes;
    public static String db;
    public static String db_source;
    public static String differ_thread_cancelled_shouldnt_happen;
    public static String dump;
    public static String empty_selection;
    public static String error_in_differ_thread;
    public static String error_in_the_project_modifier_thread;
    public static String get_changes;
    public static String none;
    public static String please_check_at_least_one_row;
    public static String port_must_be_a_number;
    public static String project_modifier_thread_cancelled_shouldnt_happen;
    public static String undefined_source_for_db_changes;
    public static String browse;
    public static String make_sure_you_have_priv_and_public_keys;
    public static String path_to_db_schema_dump;
    public static String select_readable_db_dump_file;
    public static String dump_file;
    public static String miscellaneous;
    
    // ui
    public static String exceptionNotifier_copy_stack_trace;
    public static String exceptionNotifier_string_reader_ioexception_world_ends;
    public static String exceptionNotifier_unhandled_exception;
    public static String sqlScriptDialog_Enter_cmd_to_roll_on_sql_script;
    public static String sqlScriptDialog_error_saving_script_to_file;
    public static String sqlScriptDialog_exception_during_script_execution;
    public static String sqlScriptDialog_psql_dependencies;
    public static String sqlScriptDialog_run_script;
    public static String sqlScriptDialog_save_as;
    public static String sqlScriptDialog_script_contains_statements_that_may_modify_data;
    public static String sqlScriptDialog_script_execution_interrupted;
    public static String sqlScriptDialog_script_interrupted_by_user;
    public static String sqlScriptDialog_script_saved_to_file;
    public static String sqlScriptDialog_stop_script;
    public static String sqlScriptDialog_stop_script_before_closing_dialog;
    public static String sqlScriptDialog_this_dependencies_have_been_added_already_check_order;
    public static String sqlScriptDialog_warning;
    public static String stdStreamRedirector_completed_with_code;
    public static String manualDepciesDialog_dependant_dependency;
    public static String manualDepciesDialog_depends_on;
    public static String manualDepciesDialog_object;
    public static String manualDepciesDialog_add;
    public static String manualDepciesDialog_remove;
    public static String commitDialog_user_selected_elements;
    public static String commitDialog_depcy_elements;
    
    // ui.dbstore
    public static String dbInfo_bad_dbinfo_string;
    public static String dbInfo_too_many_parts_in_dbinfo_string;
    public static String dbPicker_port;
    public static String dbStoreEditorDialog_cannot_add_entry;
    public static String dbStoreEditorDialog_cannot_save_entry;
    public static String dbStoreEditorDialog_db_info;
    public static String dbStoreEditorDialog_db_store_editor;
    public static String dbStoreEditorDialog_entry_with_this_name_already_exists;
    public static String dbStoreEditorDialog_name_cannot_be_empty_or_whitespace;
    public static String dbStoreEditorDialog_new_entry;
    public static String dbStoreEditorDialog_not_valid_port_number;
    
    // ui.differ
    public static String dbSource_db_is_not_loaded_yet_object_is_null;
    public static String dbSource_executing_pg_dump;
    public static String dbSource_filter_on;
    public static String dbSource_loading_dump;
    public static String dbSource_loading_tree;
    public static String dbSource_repository_rev_checkout;
    public static String differ_direct_diff;
    public static String differ_reverse_diff;
    public static String diffTableViewer_change_type;
    public static String diffTableViewer_reset_sorting;
    public static String diffTableViewer_container;
    public static String diffTableViewer_delete_checked_set;
    public static String diffTableViewer_deselect_child_elements;
    public static String diffTableViewer_filtering_diff_tree_based_on_gui_selection;
    public static String diffTableViewer_Input_name_for_save_checked_elements;
    public static String diffTableViewer_invert_selection;
    public static String diffTableViewer_object_name;
    public static String diffTableViewer_object_type;
    public static String diffTableViewer_objects;
    public static String diffTableViewer_open_diff_in_new_window;
    public static String diffTableViewer_save_checked;
    public static String diffTableViewer_select_child_elements;
    public static String diffTableViewer_stored_selections;
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

    // ui.externalcalls
    public static String jGitExec_and_higher;
    public static String jGitExec_couldnt_find_git_repository_in;
    public static String jGitExec_exception_thrown_at_jgit_clone;
    public static String jGitExec_exception_thrown_at_jgit_commit;
    public static String jGitExec_exception_thrown_at_jgit_push_status_isnt_ok_or_up_to_date;
    public static String jGitExec_exception_thrown_at_jgit_repo_remove_missing_add_new;
    public static String jGitExec_exception_thrown_at_jgit_repo_update;
    public static String jGitExec_get_conflicts;
    public static String jGitExec_git_failed_cause;
    public static String jGitExec_git_result;
    public static String jGitExec_git_start;
    public static String jGitExec_git_start_url;
    public static String jGitExec_git_status;
    public static String jGitExec_git_success;
    public static String jGitExec_message;
    public static String jGitExec_repository_doesnt_have_conflicts;
    public static String jGitExec_repository_has_conflicts;
    public static String jGitExec_repository_update;
    public static String jGitExec_skip_pull_branch_does_not_exist;
    public static String jGitExec_skip_pull_branch_does_not_exist_skipped;
    public static String jGitExec_status;
    public static String jGitExec_successfull;
    public static String jGitExec_un;
    public static String pgDumper_bad_pg_dump_version_output;
    public static String svnExec_bad_svn_version_output;
    public static String svnExec_cannot_svn_rm_an_empty_file_list;
    
    // ui.handlers
    public static String loadProj_open_project;
    public static String database;

    // ui.parts
    public static String commitPartDescr_commit;
    public static String commitPartDescr_commit_confirmation;
    public static String commitPartDescr_commiting;
    public static String commitPartDescr_exporting_db_model;
    public static String commitPartDescr_get_changes_from;
    public static String commitPartDescr_modifying_db_model;
    public static String commitPartDescr_success_project_updated;
    public static String commitPartDescr_the_following_changes_be_included_in_commit;

    public static String ConsoleFactory_error_opening_console;
    public static String to;
    public static String diffPaneDialog_diff_to_selected_object;
    public static String diffPartDescr_add_dependencies;
    public static String diffPartDescr_diff_script;
    public static String diffPartDescr_from;
    public static String diffPartDescr_get_changes_for;
    public static String diffPartDescr_get_latest;
    public static String diffPartDescr_this_will_apply_selected_changes_to_your_database;
    
    // ui.pgdbproject
    public static String diffWizard_consider_using_ssh_authentication_instead;
    public static String diffWizard_db_taget;
    public static String diffWizard_Diff;
    public static String diffWizard_diff_parameters;
    public static String diffWizard_diff_result;
    public static String diffWizard_diff_target;
    public static String diffWizard_diff_tree;
    public static String diffWizard_dump_taget;
    public static String diffWizard_encoding;
    public static String diffWizard_enter_git_repo_url;
    public static String diffWizard_git_commit_hash;
    public static String diffWizard_git_password;
    public static String diffWizard_git_repo_url;
    public static String diffWizard_git_target;
    public static String diffWizard_git_user;
    public static String diffWizard_no_target_type_selection_found;
    public static String diffWizard_open_project_file;
    public static String diffWizard_path_to_target_project;
    public static String diffWizard_project;
    public static String diffWizard_project_revision_grab_from_repo;
    public static String diffWizard_project_target;
    public static String diffWizard_save;
    public static String diffWizard_save__;
    public static String diffWizard_select_valid_project_file;
    public static String diffWizard_source;
    public static String diffWizard_source_target;
    public static String diffWizard_target;
    public static String diffWizard_target_encoding;
    public static String diffWizard_target_source;
    public static String diffWizard_this_project;
    public static String diffWizard_unexpected_error_while_saving_diff;
    public static String diffWizard_unexpected_target_type_value;
    public static String diffWizard_diff;
    public static String initProjectFromSource_exporting_db_model;
    public static String initProjectFromSource_init_request_but_no_schema_source;
    public static String initProjectFromSource_initializing_project;
    public static String initProjectFromSource_ioexception_while_creating_project;
    public static String newProjWizard_bad_work_dir;
    public static String newProjWizard_db_source_settings;
    public static String newProjWizard_dump_file_source_settings;
    public static String newProjWizard_error_in_initializing_repo_from_source;
    public static String newProjWizard_init_project_subdir_from_schema_source;
    public static String newProjWizard_new_pg_db_project;
    public static String newProjWizard_no_schema_source_selected;
    public static String newProjWizard_project_encoding;
    public static String newProjWizard_project_initializer_thread_interrupted;
    public static String newProjWizard_repository_settings;
    public static String newProjWizard_schema_source;
    public static String newProjWizard_schema_source_settings;
    public static String newProjWizard_select_git_repository_root_directory;
    public static String newProjWizard_select_repo_root_directory;
    public static String newProjWizard_this_will_delete_contents_and_recreate_them;
    
    // ui.prefs
    public static String dbStorePrefPage_clear_db_store;
    public static String dbStorePrefPage_edit_db_store;
    public static String dBUpdatePrefPage_alter_column_statement;
    public static String dBUpdatePrefPage_drop_column_statement;
    public static String dBUpdatePrefPage_drop_table;
    public static String dBUpdatePrefPage_set_warning_when_next_statements_present;
    public static String DiffPaneViewer_project;

    public static String DiffPresentationPane_error_loading_changes;

    public static String DiffTableViewer_error_load_checked_set;

    public static String DiffTableViewer_error_reading_ignored_objects;

    public static String DiffTableViewer_error_save_checked_set;

    public static String DiffTableViewer_error_setting_input;

    public static String DiffTableViewer_selected;
    public static String DiffWizard_bad_target_db;

    public static String DiffWizard_error_opening_project;

    public static String DiffWizard_unexpected_error;

    public static String executableFileFieldEditor_value_must_be_file_with_execute_permission_set;
    public static String generalPrefPage_pg_dump_custom_parameters;
    public static String generalPrefPage_pg_dump_executable;
    public static String generalPrefPage_use_depcy_on_commit_page;
    public static String generalPrefPage_use_psql_depcy_on_generating_script;
    public static String gitPrefPage_copy_public_keys_to_clipboard;
    public static String gitPrefPage_either_doesnt_exist_or_inaccessible;
    public static String gitPrefPage_error_while_rsa_keys_generation;
    public static String gitPrefPage_file_not_found;
    public static String gitPrefPage_generate_keys;
    public static String gitPrefPage_private_key;
    public static String gitPrefPage_public_key_file;
    public static String gitPrefPage_save_priv_key_to_file;
    public static String gitPrefPage_select_file_to_save_priv_key;
    public static String ignoreObjectsPrefPage_add_ignore;
    public static String ignoreObjectsPrefPage_delete_ignore;
    public static String IgnoredObjectsPrefPage_error_getting_ignores_list;

    public static String IgnoredObjectsPrefPage_error_saving_ignores_list;

    public static String IgnoredObjectsPrefPage_these_objects_are_ignored_info;
    public static String JGitExec_exception_thrown_at_jgit_push;
    public static String ManualDepciesDialog_set_add_depcies;

    public static String NewProjWizard_demand_init_project;
    public static String NewProjWizard_enter_project_name;

    public static String NewProjWizard_error_adding_nature;

    public static String NewProjWizard_error_creating_project;

    public static String NewProjWizard_error_loading_old_proj;

    public static String NewProjWizard_error_saving_projprefs;

    public static String NewProjWizard_import_old_proj;

    public static String NewProjWizard_project_name;

    public static String NewProjWizard_select_old_proj;

    public static String OpenEditor_error_open_project;

    public static String OpenEditor_error_open_project_editor;

    public static String PgDbProject_error_creating_project;

    public static String PgDbProject_error_deleting_project;

    public static String PgDbProject_error_opening_project;

    public static String PreferenceInitializer_error_saving_prefs;

    public static String ProjectEditorDiffer_commit_error;

    public static String ProjectEditorDiffer_diff_error;

    public static String ProjectEditorDiffer_error_bad_input_type;

    public static String ProjectEditorDiffer_page_text_commit;

    public static String ProjectEditorDiffer_page_text_diff;

    public static String ProjectEditorDiffer_project;

    public static String ProjectEditorInput_pgcodekeeper_project;

    public static String ProjectUpdater_error_backup_restore;
    public static String ProjectUpdater_error_no_tempdir;
    public static String ProjectUpdater_error_update;
    public static String SqlScriptDialog_add_it_to_script;
    public static String SqlScriptDialog_command_to_execute;
    public static String SqlScriptDialog__results_of_script_revealed_dependent_objects;
    public static String SqlScriptDialog_error_add_depcies;

    public static String SqlScriptDialog_error_adding_command_history;

    public static String SqlScriptDialog_error_get_script;

    public static String SqlScriptDialog_error_loading_command_history;

    public static String SqlScriptDialog_will_be_replaced;
    public static String StdStreamRedirector_error_reading_std;
    public static String StdStreamRedirector_error_reading_std_external;
    public static String StdStreamRedirector_error_returncode_see_for_details;
    public static String StdStreamRedirector_process_returned_with_error;
    public static String StdStreamRedirector_wait_destroy_interrupted_unexpectedly;
    public static String StdStreamRedirector_wait_thread_interrupted_unexpectedly;
    public static String XmlHistory_read_error;
    public static String XmlHistory_write_error;
    public static String XmlStringList_root_name_invalid;

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
