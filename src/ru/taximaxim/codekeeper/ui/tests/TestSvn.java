package ru.taximaxim.codekeeper.ui.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
        runRepoBinary("svn", temp.toFile(), "import", 
        		"file:///" + pathToOrigin.toString(), "-m", "\"init\"");
        repo = new SvnExec("svn", pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("");
        Dir.deleteRecursive(temp.toFile());
    }
    
    /**
     * Runs git command with specified params, returns output of command  
     * @throws IOException 
     * @throws InterruptedException 
     */
    private String runRepoBinary(String repoBinary, File workingDir, String... params) throws IOException, InterruptedException {
        ProcessBuilder git = new ProcessBuilder(repoBinary);
        for (int i = 0; i < params.length; i++) {
            git.command().add(params[i]);
        }
        git.redirectErrorStream(true);
        git.directory(workingDir);

        Process p = git.start();
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        p.waitFor();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
