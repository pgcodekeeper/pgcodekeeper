package ru.taximaxim.codekeeper.ui.addons;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.addons.messages"; //$NON-NLS-1$
    public static String AddonBindingConflict_trying_to_deactivate_conflicting_bind;
    public static String AddonBindingConflict_with_command_id;
    public static String AddonExternalTools_error_while_trying_to_run_pg_admin;
    public static String AddonExternalTools_uknown;
    public static String AddonExternalTools_version_check_paths_in_program_preferences;
    public static String AddonPrefLoader_unexpected_error_while_saving_preferences;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
