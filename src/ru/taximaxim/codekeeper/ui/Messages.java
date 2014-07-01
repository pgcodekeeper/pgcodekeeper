package ru.taximaxim.codekeeper.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.messages"; //$NON-NLS-1$
    public static String ExceptionNotifier_copy_stack_trace;
    public static String ExceptionNotifier_open_log_file;
    public static String ExceptionNotifier_string_reader_ioexception_world_ends;
    public static String ExceptionNotifier_unhandled_exception;
    public static String PartContextInjector_as_key_in_ieclipsecontext;
    public static String PartContextInjector_empty_values_map;
    public static String PartContextInjector_only_class_and_string_are_allowed;
    public static String SqlScriptDialog_denote_place_where_sql_script_fname_be_inserted;
    public static String SqlScriptDialog_Enter_cmd_to_roll_on_sql_script;
    public static String SqlScriptDialog_error_saving_script_to_file;
    public static String SqlScriptDialog_error_saving_script_to_tmp_file;
    public static String SqlScriptDialog_exception_during_script_execution;
    public static String SqlScriptDialog_replaced_by_sql_script_file;
    public static String SqlScriptDialog_run_script;
    public static String SqlScriptDialog_save_as;
    public static String SqlScriptDialog_script_execution_interrupted;
    public static String SqlScriptDialog_script_interrupted_by_user;
    public static String SqlScriptDialog_script_saved_to_file;
    public static String SqlScriptDialog_stop_script;
    public static String SqlScriptDialog_stop_script_before_closing_dialog;
    public static String SqlScriptDialog_use;
    public static String UIConsts_icons_add_obj;
    public static String UIConsts_icons_delete_obj;
    public static String UIConsts_icons_editor;
    public static String UIConsts_icons_exportdir_wiz;
    public static String UIConsts_icons_file_obj;
    public static String UIConsts_icons_pgadmin;
    public static String UIConsts_icons_save_edit;
    public static String UIConsts_icons_warning;
    public static String XmlCommitCommentHistory_error_reading_comment_history_xml;
    public static String XmlCommitCommentHistory_error_while_trying_to_write_comment;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
