package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.util.FS;
import org.osgi.framework.Bundle;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.Session;

public class JGitExec implements IRepoWorker{

    private final String url, user, pass;
    public static final Pattern PATTERN_HTTP_URL = Pattern.compile(
            "http(s)?://.+", Pattern.CASE_INSENSITIVE);
    public static final Pattern PATTERN_FILE_URL = Pattern.compile("(file://).*",
            Pattern.CASE_INSENSITIVE);
    private static final int RSA_KEY_LENGTH = 2048;
    
    public JGitExec() {
        url = user = pass = null;
    }

    public JGitExec(PgDbProject proj, String privateKeyFile) {
        this(proj.getString(UIConsts.PROJ_PREF_REPO_URL),
                proj.getString(UIConsts.PROJ_PREF_REPO_USER),
                proj.getString(UIConsts.PROJ_PREF_REPO_PASS), privateKeyFile);
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
        
        Log.log(Log.LOG_INFO, "git clone " + url);
        
        try {
            cloneCom.setURI(url).setDirectory(dirTo).call().close();
        } catch (GitAPIException e) {
            throw new IOException ("Exception thrown at JGit clone.", e);
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
            Log.log(Log.LOG_INFO, "git commit " + url);
            
            git.commit().setMessage(comment).call();
            PushCommand pushCom = git.push();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pushCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }

            Log.log(Log.LOG_INFO, "git push " + url);
            
            for (PushResult pushRes : pushCom.call()){
                for (RemoteRefUpdate b : pushRes.getRemoteUpdates()){
                    if (b.getStatus() !=  RemoteRefUpdate.Status.OK && 
                            b.getStatus() !=  RemoteRefUpdate.Status.UP_TO_DATE){
                        throw new IOException(
                                "Exception thrown at JGit commit: status is not ok or up_to_date");
                    }
                }
            }
        } catch (GitAPIException e){
            throw new IOException ("Exception thrown at JGit commit: ", e);
        }finally{
            git.close();
        }
    }

    @Override
    public void repoRemoveMissingAddNew(File dirIn) throws IOException {
        File gitRoot = getGitRoot(dirIn);
        Git git = Git.open(gitRoot);
        
        String subDir = gitRoot.toPath().relativize(dirIn.toPath()).toString();
        if (subDir.isEmpty()) {
            subDir = ".";
        }
        
        try {

            Log.log(Log.LOG_INFO, "git add update " + url);
            
            git.add().addFilepattern(subDir).setUpdate(true).call();

            Log.log(Log.LOG_INFO, "git add " + url);
            
            git.add().addFilepattern(subDir).call();
        } catch (GitAPIException e) {
            throw new IOException(
                    "Exception thrown at JGit repoRemoveMissingAddNew.", e);
        } finally {
            git.close();
        }
    }

    @Override
    public String getRepoMetaFolder() {
        // TODO replace magic strings ".git" by call to this method
        return ".git";
    }

    @Override
    public boolean hasConflicts(File dirIn) throws IOException {
        File gitRoot = getGitRoot(dirIn);
        Git git = Git.open(gitRoot);
        try {
            IndexDiff id = new IndexDiff(git.getRepository(), "HEAD",
                    new FileTreeIterator(git.getRepository()));

            Log.log(Log.LOG_INFO, "git indexdiff " + url);
            
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
        try {
            PullCommand pullCom = git.pull();
            if (PATTERN_HTTP_URL.matcher(url).matches()) {
                pullCom.setCredentialsProvider(new UsernamePasswordCredentialsProvider(user, pass));
            }

            Log.log(Log.LOG_INFO, "git pull " + url);
            
            PullResult pr =  pullCom.call();
            return pr.getMergeResult().getMergeStatus().isSuccessful();
        } catch (GitAPIException e){
            throw new IOException("Exception thrown at JGit repoUpdate.", e);
        }finally{
            git.close();
        }
    }

    @Override
    public String repoGetVersion() throws IOException {
        for (Bundle b : Activator.getContext().getBundles()){
            if (b.getSymbolicName().equals(UIConsts.JGIT_PLUGIN_ID)){
                return b.getVersion().toString();
            }
        }
        return null;
    }
    
    public static boolean isGitRepo(String path){
        try {
            Git.open(new File(path));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public static void genKeys(String privateFileName)
            throws JSchException, IOException {
        JSch jsch = new JSch();

        Log.log(Log.LOG_INFO, "Generating RSA key pair");
        
        KeyPair keys = KeyPair.genKeyPair(jsch, KeyPair.RSA, RSA_KEY_LENGTH);
        
        Log.log(Log.LOG_INFO, "Writing RSA key pair");
        
        File privateKeyFile = new File(privateFileName);
        File publicKeyFile = new File(privateFileName + ".pub");
        Files.deleteIfExists(privateKeyFile.toPath());
        Files.deleteIfExists(publicKeyFile.toPath());
        privateKeyFile.createNewFile();
        publicKeyFile.createNewFile();
        keys.writePrivateKey(privateKeyFile.getAbsolutePath());
        keys.writePublicKey(publicKeyFile.getAbsolutePath(), "");
    }

    private File getGitRoot(File subDir) {
        File gitSubDir = subDir;
        while (gitSubDir != null) {
            gitSubDir = new File(gitSubDir, ".git");
            if (gitSubDir.exists()) {
                return gitSubDir.getParentFile();
            } else {
                gitSubDir = gitSubDir.getParentFile().getParentFile();
            }
        }
        throw new IllegalStateException("Could not find .git repository in " 
                                            + subDir + " and higher");
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
            session.setConfig("StrictHostKeyChecking", "no");
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
