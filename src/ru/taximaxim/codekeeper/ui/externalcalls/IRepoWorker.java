package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public interface IRepoWorker {

    /**
     * Check out last version of the repository
     * 
     */
    public void repoCheckOut(File dirTo) throws IOException,
            InvocationTargetException;

    /**
     * Check out specified version of the repository
     */
    public void repoCheckOut(File dirTo, String rev) throws IOException,
            InvocationTargetException;

    /**
     * Commit (and push) changes to repository
     */
    public void repoCommit(File dirFrom, String comment) throws IOException;

    /**
     * 1. Remove missing files (that 've been deleted from filesystem) 2. Add
     * unversioned (untracked) files
     * 
     * @param dirIn
     * @throws IOException
     */
    public void repoRemoveMissingAddNew(File dirIn) throws IOException;

    public String getRepoMetaFolder();

    public boolean hasConflicts(File dirIn) throws IOException;

    /**
     * Performs repo update on dirIn.
     * 
     * @param dirIn
     * @return false if opration generated item conflicts
     * @throws IOException
     */
    public boolean repoUpdate(File dirIn) throws IOException;

    public String repoGetVersion() throws IOException;
}
