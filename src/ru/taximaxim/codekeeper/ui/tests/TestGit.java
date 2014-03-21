package ru.taximaxim.codekeeper.ui.tests;

import java.io.File;
import java.nio.file.Files;

import org.junit.Before;

import ru.taximaxim.codekeeper.ui.externalcalls.GitExec;

public class TestGit extends TestIRepoWorker{

    @Before
    public void setUp() throws Exception {
        pathToOrigin = Files.createTempDirectory("");
        copyFilesToPath(pathToOrigin);
        // init a git repo at pathToOrigin
        File dirRepo = new File (pathToOrigin.toString());
        runRepoBinary("git", dirRepo, "init");
        runRepoBinary("git", dirRepo, "add", ".");
        runRepoBinary("git", dirRepo, "commit", "-m", "initial");
        runRepoBinary("git", dirRepo, "config", "--bool", "core.bare", "true");
        //System.out.println("Git repository created at " + pathToOrigin);
        repo = new GitExec("git", pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("");
    }
}
