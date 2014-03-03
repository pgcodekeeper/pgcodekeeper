package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;

public class GitExec implements IRepoWorker {

    @Override
    public void repoCheckOut(File dirTo) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void repoCheckOut(File dirTo, String rev) throws IOException {
        // TODO Auto-generated method stub

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
