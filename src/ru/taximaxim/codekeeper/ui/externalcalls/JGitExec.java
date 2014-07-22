package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.LsRemoteCommand;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.util.FS;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.parts.Console;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.Session;

public class JGitExec implements IRepoWorker{

    private final String url, user, pass;
    public static final Pattern PATTERN_HTTP_URL = Pattern.compile(
            "http(s)?://.+", Pattern.CASE_INSENSITIVE); //$NON-NLS-1$
    public static final Pattern PATTERN_FILE_URL = Pattern.compile("(file://).*", //$NON-NLS-1$
            Pattern.CASE_INSENSITIVE);
    private static final int RSA_KEY_LENGTH = 2048;
    
    public JGitExec() {
        url = user = pass = null;
    }

    public JGitExec(PgDbProject proj, String privateKeyFile) {
        this(proj.getString(PROJ_PREF.REPO_URL),
                proj.getString(PROJ_PREF.REPO_USER),
                proj.getString(PROJ_PREF.REPO_PASS), privateKeyFile);
    }

    public JGitExec(String url, String user, String pass, String privateKeyFile) {
        CustomJschConfigSessionFactory jschConfigSessionFactory = 
                new CustomJschConfigSessionFactory(privateKeyFile);
        SshSessionFactory.setInstance(jschConfigSessionFactory);
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
        
        Log.log(Log.LOG_INFO, "git clone " + url); //$NON-NLS-1$
        
        try {
            cloneCom.setURI(url).setDirectory(dirTo).call().close();
        } catch (GitAPIException e) {
            throw new IOException (Messages.jGitExec_exception_thrown_at_jgit_clone, e);
        }
    }

    /**
     * This method does not stage changes in the working copy.<br>
     * {@link #repoRemoveMissingAddNew(File)} does that.
     */
    @Override
    public void repoCommit(File dirIn, String comment) throws IOException {
        Git git = Git.open(getGitRoot(dirIn));
        try {
            StoredConfig config = git.getRepository().getConfig();
            String urlRepo = config.getString("remote", "origin", "url"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

            Log.log(Log.LOG_INFO, "git commit " + urlRepo); //$NON-NLS-1$
            try {
                git.commit().setMessage(comment).call();
            } catch (GitAPIException ex) {
                throw new IOException(Messages.jGitExec_exception_thrown_at_jgit_commit, ex);
            }
            
            PushCommand pushCom = git.push();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pushCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }
            Ref head = git.getRepository().getRef(Constants.HEAD);
            if (head != null){
                pushCom.add(head);
            }
            
            Log.log(Log.LOG_INFO, "git push " + urlRepo); //$NON-NLS-1$
            Iterable<PushResult> pushResult;
            try {
                 pushResult = pushCom.call();
            } catch (GitAPIException ex) {
                throw new IOException(Messages.JGitExec_exception_thrown_at_jgit_push, ex);
            }
            
            for (PushResult pushRes : pushResult) {
                for (RemoteRefUpdate b : pushRes.getRemoteUpdates()){
                    if (b.getStatus() !=  RemoteRefUpdate.Status.OK && 
                            b.getStatus() !=  RemoteRefUpdate.Status.UP_TO_DATE){
                        Log.log(Log.LOG_ERROR, "git push failed. Cause: " +  //$NON-NLS-1$
                            b.getRemoteName() + 
                            "\n                Status: " + b.getStatus() +  //$NON-NLS-1$
                            "\n               Message: " + b.getMessage()); //$NON-NLS-1$
                        throw new IOException(
                                Messages.jGitExec_exception_thrown_at_jgit_push_status_isnt_ok_or_up_to_date
                                        + Messages.jGitExec_git_status + b.getStatus());
                    }
                }
            }
        } finally {
            git.close();
        }
    }

    @Override
    public void repoRemoveMissingAddNew(File dirIn) throws IOException {
        File gitRoot = getGitRoot(dirIn);
        Git git = Git.open(gitRoot);
        
        String subDir = gitRoot.toPath().relativize(dirIn.toPath()).toString();
        if (subDir.isEmpty()) {
            subDir = "."; //$NON-NLS-1$
        }
        
        try {

            Log.log(Log.LOG_INFO, "git add update " + url); //$NON-NLS-1$
            
            git.add().addFilepattern(subDir).setUpdate(true).call();

            Log.log(Log.LOG_INFO, "git add " + url); //$NON-NLS-1$
            
            git.add().addFilepattern(subDir).call();
        } catch (GitAPIException e) {
            throw new IOException(
                    Messages.jGitExec_exception_thrown_at_jgit_repo_remove_missing_add_new, e);
        } finally {
            git.close();
        }
    }

    @Override
    public String getRepoMetaFolder() {
        // TODO replace magic strings ".git" by call to this method
        return ".git"; //$NON-NLS-1$
    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        File gitRoot = getGitRoot(dirIn);
        Git git = Git.open(gitRoot);
        try {
            IndexDiff id = new IndexDiff(git.getRepository(), "HEAD", //$NON-NLS-1$
                    new FileTreeIterator(git.getRepository()));

            Log.log(Log.LOG_INFO, "git indexdiff " + url); //$NON-NLS-1$
            
            id.diff();
            return !id.getConflicting().isEmpty();
        } finally {
            git.close();
        }
    }

    @Override
    public boolean repoUpdate(File dirIn) throws IOException  {
        File gitRoot = getGitRoot(dirIn);
        Git git = Git.open(gitRoot);
        
        boolean hasRemoteBranch = false;
        
        // current branch
        String workingBranchName = git.getRepository().getBranch();
        try {
            // first check if local branch exists in tracked remote branches
            List<Ref> branches = git.branchList().setListMode(ListMode.REMOTE).call();
            for (Ref ref : branches) {
                String remoteBranch = git.getRepository().
                        shortenRemoteBranchName(ref.getLeaf().getName());
                
                if (workingBranchName.equals(remoteBranch)){
                    hasRemoteBranch = true;
                    break;
                }
            }
            
            // if does not exist, check not tracked branches on remote side
            if (!hasRemoteBranch){
                LsRemoteCommand lsRemotes = git.lsRemote();
                for (Ref ref : lsRemotes.call()) {
                    String remoteBranch = Repository.shortenRefName(ref.getName());
                    if (!ref.getName().equals(Constants.HEAD) && 
                            workingBranchName.equals(remoteBranch)){
                        hasRemoteBranch = true;
                        break;
                    }
                }
            }
            
            // if no (un)tracked remote ref with local branch name, skip pull quietly
            if (!hasRemoteBranch){
                String pullSkipped = Messages.jGitExec_skip_pull_branch_does_not_exist + 
                        workingBranchName + Messages.jGitExec_skip_pull_branch_does_not_exist_skipped;
                Console.addMessage(pullSkipped);
                Log.log(Log.LOG_INFO, pullSkipped);
                return true;
            }
            
            PullCommand pullCom = git.pull();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pullCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }

            Log.log(Log.LOG_INFO, "git pull " + url); //$NON-NLS-1$
            
            PullResult pr =  pullCom.call();
            return pr.getMergeResult().getMergeStatus().isSuccessful();
        } catch (GitAPIException e){
            throw new IOException(Messages.jGitExec_exception_thrown_at_jgit_repo_update, e);
        }finally{
            git.close();
        }
    }

    @Override
    public String repoGetVersion() throws IOException {
        return Activator.getPluginVersions().get(PLUGIN_ID.JGIT).get(0);
    }
    
    public static boolean isGitRepo(String path){
        try {
            Git.open(new File(path)).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public static void genKeys(String privateFileName)
            throws JSchException, IOException {
        JSch jsch = new JSch();

        Log.log(Log.LOG_INFO, "Generating RSA key pair"); //$NON-NLS-1$
        
        KeyPair keys = KeyPair.genKeyPair(jsch, KeyPair.RSA, RSA_KEY_LENGTH);
        
        Log.log(Log.LOG_INFO, "Writing RSA key pair"); //$NON-NLS-1$
        
        File privateKeyFile = new File(privateFileName);
        File publicKeyFile = new File(privateFileName + ".pub"); //$NON-NLS-1$
        Files.deleteIfExists(privateKeyFile.toPath());
        Files.deleteIfExists(publicKeyFile.toPath());
        privateKeyFile.createNewFile();
        publicKeyFile.createNewFile();
        keys.writePrivateKey(privateKeyFile.getAbsolutePath());
        keys.writePublicKey(publicKeyFile.getAbsolutePath(), ""); //$NON-NLS-1$
    }

    public String getCurrentBranch(String repoRoot) throws IOException{
        Git git = Git.open(new File(repoRoot));
        try {
            return git.getRepository().getBranch();
        } finally {
            git.close();
        }
    }
    
    private File getGitRoot(File subDir) {
        File gitSubDir = subDir;
        while (gitSubDir != null) {
            gitSubDir = new File(gitSubDir, ".git"); //$NON-NLS-1$
            if (gitSubDir.exists()) {
                return gitSubDir.getParentFile();
            } else {
                gitSubDir = gitSubDir.getParentFile().getParentFile();
            }
        }
        throw new IllegalStateException(Messages.jGitExec_couldnt_find_git_repository_in 
                                            + subDir + Messages.jGitExec_and_higher);
    }
    
    private static class CustomJschConfigSessionFactory extends JschConfigSessionFactory {
        private String privateKeyFile;
        
        public CustomJschConfigSessionFactory(String privateKeyFile) {
            super();
            this.privateKeyFile = privateKeyFile;
        }
        
        @Override
        protected void configure(OpenSshConfig.Host host, Session session) {
            // TODO strict known_hosts check
            session.setConfig("StrictHostKeyChecking", "no"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        @Override
        protected JSch getJSch(final OpenSshConfig.Host hc, FS fs) throws JSchException {
            JSch jsch = super.getJSch(hc, fs);
            jsch.removeAllIdentity();
            jsch.addIdentity(privateKeyFile);
            return jsch;
        }
    }
}
