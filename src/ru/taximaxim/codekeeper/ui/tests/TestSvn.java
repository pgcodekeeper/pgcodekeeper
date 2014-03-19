package ru.taximaxim.codekeeper.ui.tests;

import java.io.File;
import java.nio.file.Files;

import org.junit.Before;

import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;

public class TestSvn extends TestIRepoWorker{

    @Before
    public void setUp() throws Exception {
        copyFilesToOrigin();
        // init a git repo at pathToOrigin
        File dirRepo = new File (pathToOrigin.toString());
        runRepoBinary("svn", dirRepo, "init");
        runRepoBinary("svn", dirRepo, "add", ".");
        runRepoBinary("svn", dirRepo, "commit", "-m", "initial");
        runRepoBinary("svn", dirRepo, "config", "--bool", "core.bare", "true");
        repo = new SvnExec("svn", pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("a-working");
    }
}
