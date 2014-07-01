package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.handlers.messages"; //$NON-NLS-1$
    public static String About_about_pgcodekeeper;
    public static String About_pg_dump_version;
    public static String About_pgcodekeeper_version;
    public static String About_version;
    public static String About_version_n;
    public static String LoadProj_bad_project;
    public static String LoadProj_because_working_directory;
    public static String LoadProj_couldnt_open_project;
    public static String LoadProj_create_marker_file_named;
    public static String LoadProj_directory_isnt_valid_project;
    public static String LoadProj_either_doesnt_exist_or_not_a_directory;
    public static String LoadProj_loadl_failed;
    public static String LoadProj_manually_and_try_again;
    public static String LoadProj_missing_marker_file_in_working_directory;
    public static String LoadProj_ok;
    public static String LoadProj_open_project;
    public static String LoadProj_properties_file_not_found;
    public static String OpenRecent_directory_isnt_valid_project;
    public static String OpenRecent_loadl_failed;
    public static String OpenRecent_properties_file_not_found;
    public static String ProjProps_consider_using_pgpass_instead;
    public static String ProjProps_consider_using_ssh_authentication_instead;
    public static String ProjProps_db_host;
    public static String ProjProps_db_name;
    public static String ProjProps_db_password;
    public static String ProjProps_db_port;
    public static String ProjProps_db_user;
    public static String ProjProps_encoding_of_existing_files_willnt_be_changed;
    public static String ProjProps_password;
    public static String ProjProps_project_encoding;
    public static String ProjProps_providing_password_here_is_insecure;
    public static String ProjProps_repo_url;
    public static String ProjProps_settings_for_database_schema_source;
    public static String ProjProps_this_password_will_show_up_in_logs;
    public static String ProjProps_user;
    public static String ProjProps_warning;
    public static String ProjProps_warning_providing_password_here_is_insecure;
    public static String ProjSyncSrc_and_reload_project_before_continuing;
    public static String ProjSyncSrc_checking_conflicts;
    public static String ProjSyncSrc_conflicts_or_update_repository;
    public static String ProjSyncSrc_couldnt_synchronize_repository_with_remote;
    public static String ProjSyncSrc_error_while_checking;
    public static String ProjSyncSrc_repository_cache_has_conflict_resolve_them_manually;
    public static String ProjSyncSrc_repository_sync_uncancellable_thread_interrupted;
    public static String ProjSyncSrc_sync_error;
    public static String ProjSyncSrc_syncing_repository_cache;
    public static String ProjSyncSrc_updating_cache;
    public static String ProjSyncSrc_with_repo_url;
    public static String SwitchBranch_exception_during_switching_branch;
    public static String SwitchBranch_exception_waiting_for_checkout_job;
    public static String SwitchBranch_wrong_repository_or_ref_name;
    public static String SwitchPerspective_about_to_show_perspective;
    public static String SwitchPerspective_open_perspective;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
