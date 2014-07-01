package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.prefs.messages"; //$NON-NLS-1$
    public static String DbStorePrefPage_clear_db_store;
    public static String DbStorePrefPage_edit_db_store;
    public static String ExecutableFileFieldEditor_value_must_be_file_with_execute_permission_set;
    public static String GeneralPrefPage_open_last_project_on_startup;
    public static String GeneralPrefPage_pg_dump_custom_parameters;
    public static String GeneralPrefPage_pg_dump_executable;
    public static String GitPrefPage_copy_public_keys_to_clipboard;
    public static String GitPrefPage_either_doesnt_exist_or_inaccessible;
    public static String GitPrefPage_error_while_rsa_keys_generation;
    public static String GitPrefPage_file_not_found;
    public static String GitPrefPage_generate_keys;
    public static String GitPrefPage_private_key;
    public static String GitPrefPage_public_key_file;
    public static String GitPrefPage_save_priv_key_to_file;
    public static String GitPrefPage_select_file_to_save_priv_key;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
