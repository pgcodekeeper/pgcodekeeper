package ru.taximaxim.codekeeper.ui.tests;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Before;

import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;

public class TestSvn extends TestIRepoWorker{

    @Before
    public void setUp() throws Exception {
        Path temp = Files.createTempDirectory("");
        pathToOrigin = Files.createTempDirectory("");
        copyFilesToPath(temp);
        // init a git repo at pathToOrigin
        runRepoBinary("svnadmin", pathToOrigin.toFile(), "create", pathToOrigin.toString());
        // import resources to repository at pathToOrigin 
        runRepoBinary("svn", temp.toFile(), "import", "file://" + pathToOrigin.toString(), "-m", "\"init\"");
        repo = new SvnExec("svn", pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("");
        Dir.deleteRecursive(temp.toFile());
    }
}
