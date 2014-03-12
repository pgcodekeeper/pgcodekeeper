package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ru.taximaxim.codekeeper.ui.externalcalls.GitExec;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;

public class TestGitExec {

    IRepoWorker repo;
    String dirTo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        repo = new GitExec("git", "git@dev.core:ryabinin_av/ttt.git", "", "");
        dirTo = "/home/ryabinin_av/anothergitdir";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGitExecCheckOutFileString() {
        try {
            File dirRepo = new File(dirTo);
            if (dirRepo.exists()) {
                Dir.deleteRecursive(dirRepo);
            }
            Files.createDirectory(dirRepo.toPath());
            repo.repoCheckOut(dirRepo, null);
            File repoMeta = new File(dirRepo.getPath().concat("/").concat(
                    repo.getRepoMetaFolder()));
            assertTrue("error here", repoMeta.exists()
                    && repoMeta.list() != null && repoMeta.list().length > 0);

            ProcessBuilder git = new ProcessBuilder("git", "status", "--porcelain", ".");
            git.redirectErrorStream(true);
            git.directory(dirRepo);
            Process p = git.start();
            try {
                StringBuilder sb = new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                p.waitFor();
                String line;
                while((line = in.readLine()) != null) {
                    sb.append(line);
                }
                String out = sb.toString();
                assertTrue("Not empty git status --porcelain", out.equals(""));
            } catch (InterruptedException e) {
                fail("InterruptedException");
            }
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Ignore
    @Test
    public void testRepoCommit() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testHasConflicts() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testRepoUpdate() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testRepoGetVersion() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testGetRepoMetaFolder() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testRepoRemoveMissingAddNew() {
        fail("Not yet implemented");
    }

}
