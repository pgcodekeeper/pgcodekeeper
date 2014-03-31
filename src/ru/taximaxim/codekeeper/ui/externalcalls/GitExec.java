package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

@Deprecated
public class GitExec implements IRepoWorker {
    private final String gitExec;
    public static final Pattern PATTERN_SHORT_SSH_URL = Pattern
            .compile("[\\w\\.'_-]+@[\\w\\.-]+:[\\w\\._-]+/[\\w\\._-]+");
    public static final Pattern PATTERN_SSH_URL = Pattern.compile("ssh://.+");
    public static final Pattern PATTERN_HTTP_URL = Pattern.compile("http(s)?://.+");

    private final String url, user, pass;

    /**
     * Constructs an object for simple operations, not requiring credentials
     * and/or repository URL.
     * 
     * Such operations WILL THROW NPEs when performed on this object.
     * 
     * @param gitExec
     */
    public GitExec(String gitExec) {
        this.gitExec = gitExec;
        url = user = pass = null;
    }

    public GitExec(String gitExec, PgDbProject proj) {
        this(gitExec, proj.getString(UIConsts.PROJ_PREF_REPO_URL), proj
                .getString(UIConsts.PROJ_PREF_REPO_USER), proj
                .getString(UIConsts.PROJ_PREF_REPO_PASS));
    }

    public GitExec(String gitExec, String url, String user, String pass) {
        this.gitExec = gitExec;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    /**
     * Clones repository from server to local directory
     */
    public void repoCheckOut(File dirTo) throws IOException {
        repoCheckOut(dirTo, null);
    }

    @Override
    /**
     * Clones repository from server to local directory, pulls required commit
     * 
     */
    public void repoCheckOut(File dirTo, String commitHash) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "clone");
        if (PATTERN_HTTP_URL.matcher(url).matches()) {
            git.command().add(getRepoUrlWithAuth());
        } else {
            if (PATTERN_SSH_URL.matcher(url).matches() || PATTERN_SHORT_SSH_URL.matcher(url).matches())
                checkSshAuthentificated();
            git.command().add(url);
        }
        git.directory(dirTo);
        git.command().add(".");
        StdStreamRedirector.launchAndRedirect(git);
        setGitSupportNonAnsii(dirTo);
        if (commitHash != null && !commitHash.isEmpty()) {
            git = new ProcessBuilder(gitExec, "checkout", commitHash, ".");
            git.directory(dirTo);
            StdStreamRedirector.launchAndRedirect(git);
        }
    }

    /**
     * Tries to connect to remote server via ssh to check whether ssh rsa key is stored
     * TODO replace git@dev.core below by parsed host address
     *  
     * @throws IOException
     */
    private void checkSshAuthentificated() throws IOException{
        try(TempDir td = new TempDir("")){
            ProcessBuilder ssh = new ProcessBuilder("ssh", "-o", "NumberOfPasswordPrompts=0", "-o","StrictHostKeyChecking=yes","git@dev.core");
            ssh.redirectErrorStream(true);
            ssh.directory(td.get());
            Process p = ssh.start();
            p.waitFor();
            if (p.exitValue() != 0){
                throw new IllegalStateException ("Error connecting to server through ssh. Exit code is " + p.exitValue());
            }
        }catch(InterruptedException e){
            throw new IllegalStateException ("Error connecting to server through ssh.");
        }
    }

    @Override
    public void repoCommit(File dirFrom, String comment) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "commit", "-a", "-m",
                comment);
        git.directory(dirFrom);
        StdStreamRedirector.launchAndRedirect(git);
        git = new ProcessBuilder(gitExec, "push");
        git.directory(dirFrom);
        StdStreamRedirector.launchAndRedirect(git);
    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "ls-files", "-u");
        git.directory(dirIn);
        return StdStreamRedirector.launchAndRedirect(git).trim().length() > 0;
    }

    @Override
    public boolean repoUpdate(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "pull");
        git.directory(dirIn);
        StdStreamRedirector.launchAndRedirect(git);
        return !this.hasConflicts(dirIn);
    }

    @Override
    public String repoGetVersion() throws IOException {
        ProcessBuilder svn = new ProcessBuilder(gitExec, "version");
        String version = StdStreamRedirector.launchAndRedirect(svn).trim();
        if (!version.startsWith("git version")) {
            throw new IOException("Bad git version output: " + version);
        }
        return version.replaceAll("git version ", "");
    }

    @Override
    public String getRepoMetaFolder() {
        return ".git";
    }

    @Override
    public void repoRemoveMissingAddNew(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "add", "-A");
        git.directory(dirIn);
        StdStreamRedirector.launchAndRedirect(git);
    }

    /**
     * Represents git storage url to include uname and password
     * 
     * @return repo url as "http://uname:pass@host/path.git"
     * @throws URISyntaxException
     * @throws UnsupportedEncodingException
     */
    private String getRepoUrlWithAuth(){
        try {
            URI uri = new URI(url);
            return uri.getScheme() + "://" + URLEncoder.encode(user, "UTF8") + ":"
                    + URLEncoder.encode(pass, "UTF8") + "@" + uri.getHost()
                    + uri.getPath();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unsupported encoding: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Wrong URI syntax: " + e.getMessage());
        }
    }

    /**
     * Prevents git from converting russian file names to escape sequence (as in
     * "файл" = "\321\204\320\260\320\271\320\273")
     * 
     * @url http://stackoverflow.com/a/4416780
     * 
     * @param dirIn
     * @throws IOException
     */
    private void setGitSupportNonAnsii(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "config",
                "core.quotepath", "false");
        git.directory(dirIn);
        StdStreamRedirector.launchAndRedirect(git);
    }
}
