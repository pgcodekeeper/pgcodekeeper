package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public interface IRepoWorker {

    public enum RepoType {
        SVN, GIT
    }

    /**
     * Check out last version of the repository
     * 
     */
    public void repoCheckOut(File dirTo) throws IOException, InvocationTargetException;

    /**
     * Check out specified version of the repository
     */
    public void repoCheckOut(File dirTo, String rev) throws IOException, InvocationTargetException;

    /**
     * Commit (and push) changes to repository
     */
    public void repoCommit(File dirFrom, String comment) throws IOException;

    /**
     * 1. Remove missing files (that 've been deleted from filesystem)
     * 2. Add unversioned (untracked) files
     * 
     * @param dirIn
     * @throws IOException 
     */
    public void repoRemoveMissingAddNew (File dirIn) throws IOException;
    
//    /**
//     * Remove missing files
//     */
//    public void repoRemoveMissing(File dirIn) throws IOException;

    public String getRepoMetaFolder();
//    /**
//     * PRIVATE Remove files in directory specified
//     */
//    void repoRemove(File dirIn, List<String> files) throws IOException;

//    /**
//     * Add (commit to local repo - git) unversioned (new) files
//     */
//    public void repoAddAll(File dirIn) throws IOException;

//    /**
//     * PRIVATE Get filenames of files that never been added to VCS
//     */
//    public List<String> repoGetUnversioned(File dirIn) throws IOException;

    public boolean hasConflicts(File dirIn) throws IOException;

//    /**
//     * PRIVATE Get filenames of files that caused conflict
//     */
//    List<String> repoGetConflicted(File dirIn) throws IOException;

//    /**
//     * PRIVATE Is this required by git?
//     */
//    String repoStatus(File dirIn) throws IOException;

//    /**
//     * PRIVATE Is this required by git?
//     */
//    String repoStatus(File dirIn, boolean showUpdates) throws IOException;

    /**
     * Performs repo update on dirIn.
     * 
     * @param dirIn
     * @return false if opration generated item conflicts
     * @throws IOException
     */
    public boolean repoUpdate(File dirIn) throws IOException;

//    /**
//     * PRIVATE
//     * 
//     * @param pb
//     */
//    void addCredentials(ProcessBuilder pb);

//    /**
//     * PRIVATE
//     * 
//     * @param pb
//     */
//    void addUrl(ProcessBuilder pb);

    public String repoGetVersion() throws IOException;
    
    public String getRepoTypeName();
}
