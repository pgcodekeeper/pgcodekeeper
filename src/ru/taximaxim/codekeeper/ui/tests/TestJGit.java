package ru.taximaxim.codekeeper.ui.tests;


import java.io.File;
import java.nio.file.Files;

import org.junit.Before;

import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

public class TestJGit extends TestIRepoWorker{
    
    @Before
    public void setUp() throws Exception {
        //TODO Testing still relies on external git
        pathToOrigin = Files.createTempDirectory("");
        copyFilesToPath(pathToOrigin);
        // init a git repo at pathToOrigin
        File dirRepo = new File (pathToOrigin.toString());
        runRepoBinary("git", dirRepo, "init");
        runRepoBinary("git", dirRepo, "add", ".");
        runRepoBinary("git", dirRepo, "commit", "-m", "initial");
        runRepoBinary("git", dirRepo, "config", "--bool", "core.bare", "true");
        repo = new JGitExec(pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("");
    }
}
