package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeResult.MergeStatus;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.FileTreeIterator;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class JGitExec implements IRepoWorker{

    private final String url, user, pass;
    public static final Pattern PATTERN_HTTP_URL = Pattern.compile("http(s)?://.+");
    
    public JGitExec() {
        url = user = pass = null;
    }

    public JGitExec(PgDbProject proj) {
        this(proj.getString(UIConsts.PROJ_PREF_REPO_URL), proj
                .getString(UIConsts.PROJ_PREF_REPO_USER), proj
                .getString(UIConsts.PROJ_PREF_REPO_PASS));
    }

    public JGitExec(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void repoCheckOut(File dirTo) throws IOException {
        repoCheckOut(dirTo, null);
    }

    @Override
    public void repoCheckOut(File dirTo, String rev) throws IOException {
        CloneCommand cloneCom = new CloneCommand();
        if (PATTERN_HTTP_URL.matcher(url).matches()) {
            cloneCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
        }
        try {
            cloneCom.setURI(url).setDirectory(dirTo).call();
        } catch (GitAPIException e) {
            throw new IOException ("Exception thrown at JGit clone.", e);
        }
    }

    @Override
    public void repoCommit(File dirFrom, String comment) throws IOException {
        Git git = Git.open(dirFrom);
        try {
            git.commit().setMessage(comment).setAll(true).call();
            PushCommand pushCom = git.push();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pushCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }
            for (PushResult pushRes : pushCom.call()){
                for (RemoteRefUpdate b : pushRes.getRemoteUpdates()){
                    if (b.getStatus() !=  RemoteRefUpdate.Status.OK && b.getStatus() !=  RemoteRefUpdate.Status.UP_TO_DATE){
                        throw new IOException ("Exception thrown at JGit commit: status is not ok or up_to_date");
                    }
                }
            }
        } catch (GitAPIException e){
            throw new IOException ("Exception thrown at JGit commit: ", e);
        }
    }

    @Override
    public void repoRemoveMissingAddNew(File dirIn) throws IOException {
        Git git = Git.open(dirIn);
        try {
            git.add().addFilepattern(".").setUpdate(true).call();
            git.add().addFilepattern(".").call();
        } catch (GitAPIException e) {
            throw new IOException(
                    "Exception thrown at JGit repoRemoveMissingAddNew.", e);
        }

    }

    @Override
    public String getRepoMetaFolder() {
        return ".git";
    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        Git git = Git.open(dirIn);
        IndexDiff id = new IndexDiff(git.getRepository(), "HEAD",
                new FileTreeIterator(git.getRepository()));
        id.diff();
        return !id.getConflicting().isEmpty();
    }

    @Override
    public boolean repoUpdate(File dirIn) throws IOException  {
        try {
            PullCommand pullCom = Git.open(dirIn).pull();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pullCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }
            PullResult pr =  pullCom.call();
            return pr.getMergeResult().getMergeStatus() == MergeStatus.MERGED || pr.getMergeResult().getMergeStatus() == MergeStatus.ALREADY_UP_TO_DATE;
        } catch (GitAPIException e){
            throw new IOException("Exception thrown at JGit repoUpdate.", e);
        }
    }

    @Override
    public String repoGetVersion() throws IOException {
        // TODO return Eclipse plugin version
        return "JGit version";
    }
}
