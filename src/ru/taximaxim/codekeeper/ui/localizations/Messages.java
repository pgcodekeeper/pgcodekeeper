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
    public static String directory_isnt_valid_project;
    public static String load_failed;
    public static String manually_and_try_again;
    public static String missing_marker_file_in_working_directory;
    public static String consider_using_ssh_authentication_instead_use_git;
    public static String repo_url;
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
    public static String user_;
    public static String dump_file;
    public static String miscellaneous;
    
    // ui
    public static String exceptionNotifier_copy_stack_trace;
    public static String exceptionNotifier_open_log_file;
    public static String exceptionNotifier_string_reader_ioexception_world_ends;
    public static String exceptionNotifier_unhandled_exception;
    public static String partContextInjector_empty_values_map;
    public static String partContextInjector_only_class_and_string_are_allowed;
    public static String sqlScriptDialog_Enter_cmd_to_roll_on_sql_script;
    public static String sqlScriptDialog_error_saving_script_to_file;
    public static String sqlScriptDialog_error_saving_script_to_tmp_file;
    public static String sqlScriptDialog_exception_during_script_execution;
    public static String sqlScriptDialog_run_script;
    public static String sqlScriptDialog_save_as;
    public static String sqlScriptDialog_script_execution_interrupted;
    public static String sqlScriptDialog_script_interrupted_by_user;
    public static String sqlScriptDialog_script_saved_to_file;
    public static String sqlScriptDialog_stop_script;
    public static String sqlScriptDialog_stop_script_before_closing_dialog;
    public static String stdStreamRedirector_completed_with_code;
    public static String manualDepciesDialog_dependant_dependency;
    public static String manualDepciesDialog_depends_on;
    public static String manualDepciesDialog_object;
    public static String manualDepciesDialog_add;
    public static String manualDepciesDialog_remove;
    
    // ui.addons
    public static String addonExternalTools_error_while_trying_to_run_pg_admin;
    public static String addonExternalTools_version_check_paths_in_program_preferences;
    
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
    public static String dbStorePickerDialog_choose_db_from_store;
    
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
    public static String diffTableViewer_deselect_child_elements;
    public static String diffTableViewer_filtering_diff_tree_based_on_gui_selection;
    public static String diffTableViewer_object_name;
    public static String diffTableViewer_object_type;
    public static String diffTableViewer_objects;
    public static String diffTableViewer_select_child_elements;
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
    public static String jGitExec_failed;
    public static String jGitExec_get_conflicts;
    public static String jGitExec_git_failed_cause;
    public static String jGitExec_git_result;
    public static String jGitExec_git_setting_creditials;
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
    public static String jGitExec_success;
    public static String pgDumper_bad_pg_dump_version_output;
    public static String svnExec_bad_svn_version_output;
    public static String svnExec_cannot_svn_rm_an_empty_file_list;
    
    // ui.handlers
    public static String about_about_pgcodekeeper;
    public static String about_pg_dump_version;
    public static String about_pgcodekeeper_version;
    public static String about_version;
    public static String about_version_n;
    public static String loadProj_bad_project;
    public static String loadProj_because_working_directory;
    public static String loadProj_couldnt_open_project;
    public static String loadProj_either_doesnt_exist_or_not_a_directory;
    public static String loadProj_ok;
    public static String loadProj_open_project;
    public static String projProps_db_port;
    public static String projProps_encoding_of_existing_files_willnt_be_changed;
    public static String projProps_password;
    public static String projProps_project_encoding;
    public static String projProps_settings_for_database_schema_source;
    public static String projProps_database;
    public static String projProps_source_of_the_db_schema;
    public static String projSyncSrc_checking_conflicts;
    public static String projSyncSrc_couldnt_synchronize_repository_with_remote;
    public static String projSyncSrc_error_while_checking;
    public static String projSyncSrc_repository_cache_has_conflict_resolve_them_manually;
    public static String projSyncSrc_repository_sync_uncancellable_thread_interrupted;
    public static String projSyncSrc_sync_error;
    public static String projSyncSrc_syncing_repository_cache;
    public static String projSyncSrc_updating_cache;
    public static String switchBranch_exception_during_switching_branch;
    public static String switchBranch_wrong_repository_or_ref_name;
    public static String switchPerspective_open_perspective;

    // ui.parts
    public static String commitPartDescr_branch;
    public static String commitPartDescr_cannot_get_branch_name;
    public static String commitPartDescr_comment_required;
    public static String commitPartDescr_commit;
    public static String commitPartDescr_commit_confirmation;
    public static String commitPartDescr_commiting;
    public static String commitPartDescr_exporting_db_model;
    public static String commitPartDescr_from_database;
    public static String commitPartDescr_get_changes_from;
    public static String commitPartDescr_ioexception_while_modifying_project;
    public static String commitPartDescr_modifying_db_model;
    public static String commitPartDescr_no_previous_comments;
    public static String commitPartDescr_please_enter_a_comment_for_the_commit;
    public static String commitPartDescr_success_project_updated;
    public static String commitPartDescr_the_following_changes_be_included_in_commit;
    public static String commitPartDescr_to;
    public static String diffPartDescr_add_dependencies;
    public static String diffPartDescr_diff_script;
    public static String diffPartDescr_from;
    public static String diffPartDescr_get_changes_for;
    public static String diffPartDescr_get_latest;
    public static String diffPartDescr_this_will_apply_selected_changes_to_your_database;
    public static String diffPartDescr_to_database;
    public static String projectExplorer_generating_object_hashes;
    public static String projectExplorer_loading_project;
    public static String projectExplorer_project_explorer;
    
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
    public static String newProjWizard_cloning_get_repo;
    public static String newProjWizard_cloning_thread_interrupted;
    public static String newProjWizard_cloning_wasnt_successful;
    public static String newProjWizard_cannt_be_saved_in_working;
    public static String newProjWizard_couldnt_create_empty_database_in;
    public static String newProjWizard_db_source_settings;
    public static String newProjWizard_dump_file_source_settings;
    public static String newProjWizard_enter;
    public static String newProjWizard_error_cloning_repository;
    public static String newProjWizard_error_in_initializing_repo_from_source;
    public static String newProjWizard_error_while_saving_project_properties;
    public static String newProjWizard_init_project_subdir_from_schema_source;
    public static String newProjWizard_new_pg_db_project;
    public static String newProjWizard_no_schema_source_selected;
    public static String newProjWizard_password;
    public static String newProjWizard_project_encoding;
    public static String newProjWizard_project_fiel;
    public static String newProjWizard_project_initializer_thread_interrupted;
    public static String newProjWizard_repo_url_demand;
    public static String newProjWizard_repository_settings;
    public static String newProjWizard_schema_source;
    public static String newProjWizard_schema_source_settings;
    public static String newProjWizard_select_a_dir_inside_the_repo;
    public static String newProjWizard_select_correct_subdir_of_the_git_repo;
    public static String newProjWizard_select_git_repository_root_directory;
    public static String newProjWizard_select_project_directory_demand;
    public static String newProjWizard_select_project_filename_demand;
    public static String newProjWizard_select_project_name;
    public static String newProjWizard_select_repo_root_directory;
    public static String newProjWizard_selected_directory_is_empty;
    public static String newProjWizard_selecterd_dir_must_be_empty_or_be_a_root_dir_of;
    public static String newProjWizard_target_dir_isnt_git_repository_root_dir;
    public static String newProjWizard_this_will_delete_contents_and_recreate_them;
    public static String newProjWizard_to_selected_dir_now;
    public static String newProjWizard_workdirectory_settings;
    public static String pgDbProject_error_loading_project_file;
    
    // ui.prefs
    public static String dbStorePrefPage_clear_db_store;
    public static String dbStorePrefPage_edit_db_store;

    public static String DiffTableViewer_selected;
    public static String executableFileFieldEditor_value_must_be_file_with_execute_permission_set;
    public static String generalPrefPage_open_last_project_on_startup;
    public static String generalPrefPage_pg_dump_custom_parameters;
    public static String generalPrefPage_pg_dump_executable;
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
    
    // ui.recentprojs
    public static String dynamicMenuRecent_recent_list_is_empty;

    public static String IgnoredObjectsPrefPage_these_objects_are_ignored_info;
    public static String JGitExec_exception_thrown_at_jgit_push;

    public static String ManualDepciesDialog_set_add_depcies;
    public static String NewProjWizard_settings;
    public static String ProjProps_settings;

    public static String SqlScriptDialog_command_to_execute;

    public static String SqlScriptDialog_will_be_replaced;

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
