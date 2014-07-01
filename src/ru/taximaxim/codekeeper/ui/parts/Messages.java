package ru.taximaxim.codekeeper.ui.parts;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.parts.messages"; //$NON-NLS-1$
    public static String CommitPartDescr_bad_port;
    public static String CommitPartDescr_choose_dump_file_with_changes;
    public static String CommitPartDescr_comment_required;
    public static String CommitPartDescr_commit;
    public static String CommitPartDescr_commiting;
    public static String CommitPartDescr_db;
    public static String CommitPartDescr_db_source;
    public static String CommitPartDescr_differ_thread_cancelled_shouldnt_happen;
    public static String CommitPartDescr_dump;
    public static String CommitPartDescr_empty_selection;
    public static String CommitPartDescr_error_in_differ_thread;
    public static String CommitPartDescr_error_in_project_modifier_thread;
    public static String CommitPartDescr_exporting_db_model;
    public static String CommitPartDescr_from_database;
    public static String CommitPartDescr_get_changes;
    public static String CommitPartDescr_get_changes_from;
    public static String CommitPartDescr_getting_changes_to_commit;
    public static String CommitPartDescr_ioexception_while_modifying_project;
    public static String CommitPartDescr_modifying_db_model;
    public static String CommitPartDescr_no_previous_comments;
    public static String CommitPartDescr_none;
    public static String CommitPartDescr_please_check_at_least_one_row;
    public static String CommitPartDescr_please_enter_a_comment_for_the_commit;
    public static String CommitPartDescr_port_must_be_a_number;
    public static String CommitPartDescr_project_modifier_thread_cancelled_shouldnt_happen;
    public static String CommitPartDescr_success_project_updated;
    public static String CommitPartDescr_to;
    public static String CommitPartDescr_undefined_surce_for_db_changes;
    public static String DiffPartDescr_bad_port;
    public static String DiffPartDescr_choose_dump_file_with_changes;
    public static String DiffPartDescr_db;
    public static String DiffPartDescr_db_source;
    public static String DiffPartDescr_diff_script;
    public static String DiffPartDescr_differ_thread_cancelled_shouldnt_happen;
    public static String DiffPartDescr_dump;
    public static String DiffPartDescr_empty_selection;
    public static String DiffPartDescr_error_in_differ_thread;
    public static String DiffPartDescr_error_in_the_project_modifier_thread;
    public static String DiffPartDescr_from;
    public static String DiffPartDescr_get_changes;
    public static String DiffPartDescr_get_changes_for;
    public static String DiffPartDescr_get_latest;
    public static String DiffPartDescr_Getting_changes_to_generate_script;
    public static String DiffPartDescr_none;
    public static String DiffPartDescr_please_check_at_least_one_row;
    public static String DiffPartDescr_port_must_be_a_number;
    public static String DiffPartDescr_project_modifier_thread_cancelled_shouldnt_happen;
    public static String DiffPartDescr_this_will_apply_selected_changes_to_your_database;
    public static String DiffPartDescr_to_database;
    public static String DiffPartDescr_undefined_source_for_db_changes;
    public static String ProjectExplorer_generating_object_hashes;
    public static String ProjectExplorer_loading_project;
    public static String SqlEditorDescr_about_to_show_editor;
    public static String TestPart_qwe;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
