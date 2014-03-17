package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import org.eclipse.e4.core.services.log.Logger;
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
import ru.taximaxim.codekeeper.ui.Log;

public class TestGitExec {

    private IRepoWorker repo;
    private String dirTo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	prepareRepository();
    }

    private static void prepareRepository() {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
    public static void tearDownAfterClass() throws Exception {
		destroyRepository();
    }

    private static void destroyRepository() {
		// TODO Auto-generated method stub
		
	}

	@Before
    public void setUp() throws Exception {
        repo = new GitExec("git", "git@dev.core:ryabinin_av/ttt.git", "", "");
        dirTo = "/home/ryabinin_av/anothergitdir";
        Logger log = mock(Logger.class);
        Log.setLog(log);
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
    //    fail("Not yet implemented");
    	try{Thread.sleep(2000);}catch(Exception ex){}
    	
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
