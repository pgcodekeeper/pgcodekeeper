package ru.taximaxim.codekeeper.ui.externalcalls.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.externalcalls.utils.messages"; //$NON-NLS-1$
    public static String StdStreamRedirector_error_while_reading_from_stdout_stderr;
    public static String StdStreamRedirector_exception_thrown_while_external_command_output;
    public static String StdStreamRedirector_external_command;
    public static String StdStreamRedirector_interrrupted_wait_on_redirector_thread;
    public static String StdStreamRedirector_output;
    public static String StdStreamRedirector_process_returned_with_error;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
