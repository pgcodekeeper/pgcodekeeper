package ru.taximaxim.codekeeper.ui.dbstore;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.dbstore.messages"; //$NON-NLS-1$
    public static String DbInfo_bad_dbinfo_string;
    public static String DbInfo_too_many_parts_in_dbinfo_string;
    public static String DbPicker_consider_using_pgpass_file_instead;
    public static String DbPicker_db_host;
    public static String DbPicker_db_name;
    public static String DbPicker_db_password;
    public static String DbPicker_db_user;
    public static String DbPicker_entry_name;
    public static String DbPicker_port;
    public static String DbPicker_providing_password_here_is_insecure;
    public static String DbPicker_warning;
    public static String DbStoreEditorDialog_cannot_add_entry;
    public static String DbStoreEditorDialog_cannot_save_entry;
    public static String DbStoreEditorDialog_db_info;
    public static String DbStoreEditorDialog_db_store_editor;
    public static String DbStoreEditorDialog_entry_name;
    public static String DbStoreEditorDialog_entry_with_this_name_already_exists;
    public static String DbStoreEditorDialog_name_cannot_be_empty_or_whitespace;
    public static String DbStoreEditorDialog_new_entry;
    public static String DbStoreEditorDialog_not_valid_port_number;
    public static String DbStoreEditorDialog_unexpected_error_while_saving_preferences;
    public static String DbStorePickerDialog_choose_db_from_store;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
