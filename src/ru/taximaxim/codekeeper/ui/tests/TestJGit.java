package ru.taximaxim.codekeeper.ui.tests;


import java.io.File;
import java.nio.file.Files;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.junit.Before;

import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

public class TestJGit extends TestIRepoWorker{
    
    @Before
    public void setUp() throws Exception {
        pathToOrigin = Files.createTempDirectory("");
        copyFilesToPath(pathToOrigin);
        // init a git repo at pathToOrigin
        File dirRepo = new File (pathToOrigin.toString());
        InitCommand initCom = Git.init();
        initCom.setDirectory(dirRepo).call();
        Git git = Git.open(dirRepo);
        git.add().addFilepattern(".").call();
        git.commit().setMessage("init").setAll(true).call();
        //TODO replace external git call
        runRepoBinary("git", dirRepo, "config", "--bool", "core.bare", "true");
        repo = new JGitExec(pathToOrigin.toString(), "", "", "");
        pathToWorking = Files.createTempDirectory("");
    }
}
