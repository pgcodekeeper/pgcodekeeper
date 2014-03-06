package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class GitExec implements IRepoWorker {
    private final String gitExec;

    private final String url, user, pass;

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
    public void repoCheckOut(File dirTo) throws IOException, InvocationTargetException {
        repoCheckOut(dirTo, null);
    }

    @Override
    /**
     * Clones repository from server to local directory, pulls required commit
     * 
     */
    public void repoCheckOut(File dirTo, String commitHash) throws IOException, InvocationTargetException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "clone");
        if (commitHash != null && !commitHash.isEmpty()) {
            // TODO implement checking out specified commit
        }
        try {
            git.command().add(getRepoUrlWithAuth());
        } catch (URISyntaxException e) {
            throw new InvocationTargetException(new IllegalStateException(
                    "URISyntaxException: Error converting username:password@host to URI"));
        }
        git.directory(dirTo);
        git.command().add(".");
        StdStreamRedirector.launchAndRedirect(git);
        setGitSupportNonAnsii(dirTo);
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
        if (StdStreamRedirector.launchAndRedirect(git).length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean repoUpdate(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "pull");
        git.directory(dirIn);
        StdStreamRedirector.launchAndRedirect(git);
        return this.hasConflicts(dirIn);
    }

    @Override
    public String repoGetVersion() throws IOException {
        // TODO Auto-generated method stub
        return null;
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
    private String getRepoUrlWithAuth() throws URISyntaxException,
            UnsupportedEncodingException {
        URI uri = new URI(url);
        // requires URI encoding for uname and password when those contain
        // special signs
        return uri.getScheme() + "://" + URLEncoder.encode(user, "UTF8") + ":"
                + URLEncoder.encode(pass, "UTF8") + "@" + uri.getHost()
                + uri.getPath();
    }

    private String[] gitGetMissing(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "ls-files", "-d");
        git.directory(dirIn);
        return StdStreamRedirector.launchAndRedirect(git).split(
                System.getProperty("line.separator"));
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

    private String[] gitGetOther(File dirIn) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "ls-files", "-o");
        git.directory(dirIn);
        return StdStreamRedirector.launchAndRedirect(git).split(
                System.getProperty("line.separator"));
    }

}
