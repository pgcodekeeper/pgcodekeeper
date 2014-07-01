package ru.taximaxim.codekeeper.ui.externalcalls;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.ui.externalcalls.messages"; //$NON-NLS-1$
    public static String JGitExec_and_higher;
    public static String JGitExec_couldnt_find_git_repository_in;
    public static String JGitExec_eception_thrown_at_jgit_clone;
    public static String JGitExec_exception_thrown_at_jgit_commit;
    public static String JGitExec_exception_thrown_at_jgit_commit_status_isnt_ok_or_up_to_date;
    public static String JGitExec_exception_thrown_at_jgit_repo_remove_missing_add_new;
    public static String JGitExec_exception_thrown_at_jgit_repo_update;
    public static String PgDumper_bad_pg_dump_version_output;
    public static String SvnExec_bad_svn_version_output;
    public static String SvnExec_cannot_svn_rm_an_empty_file_list;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
