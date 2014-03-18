package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.eclipse.e4.core.services.log.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.EnumSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ru.taximaxim.codekeeper.ui.externalcalls.GitExec;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.Log;

import java.nio.file.attribute.*;
public class TestGitExec {

    private IRepoWorker repo;
    private Path pathToWorking;
    private Path pathToOrigin;
    // TODO fix platform-dependent filenames
    private final static String[] fileNames = { "resources/EXTENSION/file1.sql",
            "resources/EXTENSION/file2.sql", "resources/EXTENSION/file3.sql",
            "resources/SCHEMA/file4.sql", "resources/SCHEMA/file5.sql",
            "resources/SCHEMA/file6.sql" };

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger log = mock(Logger.class);
        Log.setLog(log);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        
    }
    
    @Before
    public void setUp() throws Exception {
        prepareRepository();
        repo = new GitExec("git", pathToOrigin.toString(), "", "");
        pathToWorking = Files.createTempDirectory("a-working");
    }

    @After
    public void tearDown() throws Exception {
        destroyRepository(pathToWorking);
        destroyRepository(pathToOrigin);
    }
    
    /**
     * Creates temporary dir pathToOrigin, copies files from resources there,
     * inits git repo there and commits copied files
     */
    private void prepareRepository() {
        try {
            pathToOrigin = Files.createTempDirectory("a-origin");
            final Path source = FileSystems.getDefault().getPath("resources");
            Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                     new SimpleFileVisitor<Path>() {
                         @Override
                         public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                             throws IOException
                         {
                             Path targetdir = pathToOrigin.resolve(source.relativize(dir));
                             try {
                                 Files.copy(dir, targetdir);
                             } catch (FileAlreadyExistsException e) {
                                  if (!Files.isDirectory(targetdir))
                                      throw e;
                             }
                             return FileVisitResult.CONTINUE;
                         }
                         @Override
                         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                             throws IOException
                         {
                             Files.copy(file, pathToOrigin.resolve(source.relativize(file)));
                             return FileVisitResult.CONTINUE;
                         }
                     });
            File dirRepo = new File (pathToOrigin.toString());
            runGit(dirRepo, "init");
            runGit(dirRepo, "add", ".");
            runGit(dirRepo, "commit", "-m", "initial");
            runGit(dirRepo, "config", "--bool", "core.bare", "true");
            System.out.println("Repository created at " + pathToOrigin);
        } catch (IOException e) {
            fail("Error initializing original repository at " + pathToOrigin);
            throw new IllegalStateException(e);
        }
    }

    /**
     * Removes file tree with starting point at start 
     */
    private void destroyRepository(Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });
    }

    /**
     * Runs git command with specified params, returns output of command
     * Assumes that git binary file is git (should work for UNIX/Windows)
     *  
     */
    private String runGit(File workingDir, String... params) {
        ProcessBuilder git = new ProcessBuilder("git");
        for (int i = 0; i < params.length; i++) {
            git.command().add(params[i]);
        }
        git.redirectErrorStream(true);
        git.directory(workingDir);
    
        try {
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
        } catch (IOException ex) {
            fail("IOException while running git command");
            return null;
        } catch (InterruptedException e) {
            fail("InterruptedException while running git command");
            return null;
        }
    }

    @Test
    public void testGitExecCheckOut() {
        try {
            File dirRepo = new File(pathToWorking.toString());
            repo.repoCheckOut(dirRepo, null);
            File repoMeta = new File(dirRepo.getPath().concat("/")
                    .concat(repo.getRepoMetaFolder()));
            assertTrue("error here", repoMeta.exists()
                    && repoMeta.list() != null && repoMeta.list().length > 0);

            String out = runGit(dirRepo, "status", "--porcelain", ".");
            assertTrue("Not empty git status --porcelain", out.equals(""));
        } catch (IOException e) {
            fail("IOException");
        }
    }

    /**
     * Test behaviour of checkOut from non-existent origin
     */
    @Test
    public void testGitExecCheckOutWrongUrl() {
       File dirRepo = new File(pathToWorking.toString());
       try {
            repo = new GitExec("git", Files.createTempDirectory("").toString(),
                    "", "");
        } catch (IOException e) {
            fail("IOException while creating temp dir" + e.getMessage());
        }
       
        try {
            repo.repoCheckOut(dirRepo, null);
        } catch (IOException e) {
           if (e.getMessage().startsWith("Process returned with error:")){
               assertTrue(true);
           }else {
               fail("Some IOError at repoCheckOut");
           }
        }
    }
    
    @Test
    public void testRepoCommit() {
        try {
            File dirRepo = new File(pathToWorking.toString());
            String out = runGit (dirRepo, "clone", pathToOrigin.toString(), ".");
            // check if cloned successfully
            out = runGit(dirRepo, "status", "--porcelain", ".");
            assertTrue("Not empty git status --porcelain", out.equals(""));
            // modify file in repo
            FileWriter fw = new FileWriter(pathToWorking.toString()+System.getProperty("file.separator")
                    + "EXTENSION/file1.sql", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println("added");
            printWriter.close();
            repo.repoCommit(dirRepo, "test");
            assertTrue("Not empty git status --porcelain", runGit(dirRepo, "status", "--porcelain").equals(""));
        } catch (IOException e) {
            fail("IOException at testRepoCommit" + e.getMessage());
        }
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
