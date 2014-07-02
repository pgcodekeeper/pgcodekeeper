package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class SvnExec implements IRepoWorker {

    private static final Pattern PATTERN_MISSING_FILE = Pattern.compile(
            "^(?:!.{6}[\\s]+)(.*)$", Pattern.MULTILINE); //$NON-NLS-1$

    private static final Pattern PATTERN_UNVERSIONED = Pattern.compile(
            "^(?:\\?.{6}[\\s]+)(.*)$", Pattern.MULTILINE); //$NON-NLS-1$

    private static final Pattern PATTERN_ST_CONFLICTED = Pattern.compile(
            "^(?:C.{6}[\\s]+)(.*)$", Pattern.MULTILINE); //$NON-NLS-1$

    private static final Pattern PATTERN_UP_CONFLICTED = Pattern.compile(
            "^(?:C.{3}[\\s]+)(.*)$", Pattern.MULTILINE); //$NON-NLS-1$

    private static final Pattern PATTERN_VERSION = Pattern
            .compile("^[\\d]+\\.[\\d]+\\.[\\d]+$"); //$NON-NLS-1$

    private static final Pattern PATTERN_SVN_URL = Pattern.compile("svn(\\+ssh)?://.+"); //$NON-NLS-1$
    private static final Pattern PATTERN_HTTP_URL = Pattern.compile("http(s)?://.+"); //$NON-NLS-1$
    
    private final String svnExec;

    private final String url, user, pass;

    public SvnExec(String svnExec, String url, String user, String pass) {
        this.svnExec = svnExec;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public SvnExec(String svnExec, PgDbProject proj) {
        this(svnExec, proj.getString(UIConsts.PROJ_PREF_REPO_URL), proj
                .getString(UIConsts.PROJ_PREF_REPO_USER), proj
                .getString(UIConsts.PROJ_PREF_REPO_PASS));
    }

    /**
     * Constructs an object for simple operations, not requiring credentials
     * and/or repository URL.
     * 
     * Such operations WILL THROW NPEs when performed on this object.
     * 
     * @param svnExec
     */
    public SvnExec(String svnExec) {
        this.svnExec = svnExec;

        url = user = pass = null;
    }

    @Override
    public void repoCheckOut(File dirTo) throws IOException {
        repoCheckOut(dirTo, null);
    }

    @Override
    public void repoCheckOut(File dirTo, String rev) throws IOException {
        ProcessBuilder svn = new ProcessBuilder(svnExec, "co", //$NON-NLS-1$
                "--non-interactive"); //$NON-NLS-1$
        addCredentials(svn);
        if (rev != null && !rev.isEmpty()) {
            svn.command().add("-r"); //$NON-NLS-1$
            svn.command().add(rev);
        }
        addUrl(svn);
        svn.command().add("."); //$NON-NLS-1$

        svn.directory(dirTo);

        StdStreamRedirector.launchAndRedirect(svn);
    }

    @Override
    public void repoCommit(File dirFrom, String comment) throws IOException {
        ProcessBuilder svn = new ProcessBuilder(svnExec, "ci", //$NON-NLS-1$
                "--non-interactive"); //$NON-NLS-1$
        addCredentials(svn);
        svn.command().add("--message"); //$NON-NLS-1$
        svn.command().add(comment);
        svn.command().add("."); //$NON-NLS-1$

        svn.directory(dirFrom);

        StdStreamRedirector.launchAndRedirect(svn);
    }

    private void repoRemoveMissing(File dirIn) throws IOException {
        List<String> files = svnGetMissing(dirIn);
        if (!files.isEmpty()) {
            repoRemove(dirIn, files);
        }
    }

    private List<String> svnGetMissing(File dirIn) throws IOException {
        List<String> files = new ArrayList<>();
        Matcher m = PATTERN_MISSING_FILE.matcher(repoStatus(dirIn));
        while (m.find()) {
            files.add(m.group(1));
        }
        return files;
    }

    private void repoRemove(File dirIn, List<String> files) throws IOException {
        if (files.isEmpty()) {
            throw new IllegalArgumentException(
                    Messages.SvnExec_cannot_svn_rm_an_empty_file_list);
        }

        ProcessBuilder svn = new ProcessBuilder(svnExec, "rm", //$NON-NLS-1$
                "--non-interactive"); //$NON-NLS-1$
        svn.command().addAll(files);
        svn.directory(dirIn);

        StdStreamRedirector.launchAndRedirect(svn);
    }


    private void repoAddAll(File dirIn) throws IOException {
        List<String> files = repoGetUnversioned(dirIn);

        while (!files.isEmpty()) {
            ProcessBuilder svn = new ProcessBuilder(svnExec, "add", //$NON-NLS-1$
                    "--non-interactive", "--depth", "infinity", "--force", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    "--parents"); //$NON-NLS-1$
            svn.command().addAll(files);
            svn.directory(dirIn);

            StdStreamRedirector.launchAndRedirect(svn);

            files = repoGetUnversioned(dirIn);
        }
    }

    private List<String> repoGetUnversioned(File dirIn) throws IOException {
        List<String> files = new ArrayList<>();
        Matcher m = PATTERN_UNVERSIONED.matcher(repoStatus(dirIn));
        while (m.find()) {
            files.add(m.group(1));
        }
        return files;
    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        return !repoGetConflicted(dirIn).isEmpty();
    }

    private List<String> repoGetConflicted(File dirIn) throws IOException {
        List<String> files = new ArrayList<>();
        Matcher m = PATTERN_ST_CONFLICTED.matcher(repoStatus(dirIn));
        while (m.find()) {
            files.add(m.group(1));
        }
        return files;
    }

    private String repoStatus(File dirIn) throws IOException {
        return repoStatus(dirIn, false);
    }

    private String repoStatus(File dirIn, boolean showUpdates)
            throws IOException {
        ProcessBuilder svn = new ProcessBuilder(svnExec, "st", //$NON-NLS-1$
                "--non-interactive"); //$NON-NLS-1$
        if (showUpdates) {
            svn.command().add("--show-updates"); //$NON-NLS-1$
        }

        svn.directory(dirIn);
        return StdStreamRedirector.launchAndRedirect(svn);
    }

    /**
     * Performs svn update on dirIn.
     * 
     * @param dirIn
     * @return false if opration generated item conflicts
     * @throws IOException
     */
    @Override
    public boolean repoUpdate(File dirIn) throws IOException {
        ProcessBuilder svn = new ProcessBuilder(svnExec, "up", //$NON-NLS-1$
                "--non-interactive"); //$NON-NLS-1$
        addCredentials(svn);
        svn.directory(dirIn);

        return !PATTERN_UP_CONFLICTED.matcher(
                StdStreamRedirector.launchAndRedirect(svn)).find();
    }

    private void addCredentials(ProcessBuilder pb) {
        if (user != null && !user.isEmpty()) {
            pb.command().add("--username"); //$NON-NLS-1$
            pb.command().add(user);
        }
        if (pass != null && !pass.isEmpty()) {
            pb.command().add("--password"); //$NON-NLS-1$
            pb.command().add(pass);
        }
    }

    private void addUrl(ProcessBuilder pb) {
        if (url != null && !url.isEmpty()) {
            if (PATTERN_SVN_URL.matcher(url).matches() || PATTERN_HTTP_URL.matcher(url).matches()) {
                pb.command().add(url);
            } else {
                pb.command().add("file:///" + url); //$NON-NLS-1$
            }
        }
    }

    @Override
    public String repoGetVersion() throws IOException {
        ProcessBuilder svn = new ProcessBuilder(svnExec, "--version", //$NON-NLS-1$
                "--quiet", "--non-interactive"); //$NON-NLS-1$ //$NON-NLS-2$
        String version = StdStreamRedirector.launchAndRedirect(svn).trim();
        if (!PATTERN_VERSION.matcher(version).matches()) {
            throw new IOException(Messages.SvnExec_bad_svn_version_output + version);
        }
        return version;
    }

    @Override
    public String getRepoMetaFolder() {

        return ".svn"; //$NON-NLS-1$
    }

    @Override
    public void repoRemoveMissingAddNew(File dirIn) throws IOException {
        repoRemoveMissing(dirIn);
        repoAddAll(dirIn);
    }
}
