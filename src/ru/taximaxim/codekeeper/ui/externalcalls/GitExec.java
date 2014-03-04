package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

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
    public void repoCheckOut(File dirTo) throws IOException {
        repoCheckOut(dirTo, null);
    }

    @Override
    /**
     * 
     */
    public void repoCheckOut(File dirTo, String commitHash) throws IOException {
        ProcessBuilder git = new ProcessBuilder(gitExec, "clone");
        if (commitHash != null && !commitHash.isEmpty()) {
            // TODO implement checking out specified commit
        }
        try {
            git.command().add(getRepoUrlWithAuth());
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        git.directory(dirTo);

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

    @Override
    public void repoCommit(File dirFrom, String comment) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void repoRemoveMissing(File dirIn) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void repoAddAll(File dirIn) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean repoUpdate(File dirIn) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String repoGetVersion() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

}
