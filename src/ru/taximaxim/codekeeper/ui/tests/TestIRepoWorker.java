package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.eclipse.e4.core.services.log.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

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

import java.nio.file.attribute.*;
public abstract class TestIRepoWorker {

    protected IRepoWorker repo;
    protected Path pathToWorking;
    protected Path pathToOrigin;
    
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
        
    }

    @After
    public void tearDown() throws IOException {
        Dir.deleteRecursive(pathToWorking.toFile());
        Dir.deleteRecursive(pathToOrigin.toFile());
    }
    
    /**
     * Creates temporary dir pathToOrigin, copies files from resources there,
     * inits git repo there and commits copied files
     */
    protected void copyFilesToOrigin() {
        try {
            pathToOrigin = Files.createTempDirectory("a-origin");
            final Path source = FileSystems.getDefault().getPath("resources");
            Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, new CopyFileVisitor(source));
        } catch (IOException e) {
            fail("Error copying files to " + pathToOrigin);
        }
    }

    /**
     * Runs git command with specified params, returns output of command  
     */
    protected String runRepoBinary(String repoBinary, File workingDir, String... params) {
        ProcessBuilder git = new ProcessBuilder(repoBinary);
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
    public void testRepoCheckOut() {
        try {
            File dirRepo = pathToWorking.toFile();
            repo.repoCheckOut(dirRepo, null);
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(pathToOrigin, pathToWorking));
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(pathToWorking, pathToOrigin));
            assertTrue(true);
        } catch (IOException e) {
            fail("IOException at testRepoCheckOut " + e.getMessage());
        }
    }
    
    @Test
    public void testRepoCommit() {
        try {
            File dirRepo = new File(pathToWorking.toString());
            repo.repoCheckOut(dirRepo);
            // modify file in repo
            FileWriter fw = new FileWriter(pathToWorking.toString()
                    + System.getProperty("file.separator") + "EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println("added");
            printWriter.close();
            repo.repoCommit(dirRepo, "test");
            File dirTempRepo = Files.createTempDirectory("a-origin").toFile();
            repo.repoCheckOut(dirTempRepo);
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(dirTempRepo.toPath(), pathToWorking));
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(pathToWorking, dirTempRepo.toPath()));
            assertTrue(true);
        } catch (IOException e) {
            fail("IOException at testRepoCommit" + e.getMessage());
        }
    }
    
    @Ignore
    @Test
    public void testHasConflicts() {
        fail("Not yet implemented");
    }

    @Test
    public void testRepoUpdate() {
        try {
            File dirRepo = pathToWorking.toFile();
            repo.repoCheckOut(dirRepo);
            File dirTempRepo = Files.createTempDirectory("a-origin").toFile();
            repo.repoCheckOut(dirTempRepo);
            // modify file in repo temp
            FileWriter fw = new FileWriter(dirTempRepo.toString()
                    + System.getProperty("file.separator") + "EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println("added");
            printWriter.close();
            repo.repoCommit(dirTempRepo, "test");
            repo.repoUpdate(dirRepo);
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(dirTempRepo.toPath(), dirRepo.toPath()));
            Files.walkFileTree(pathToOrigin, EnumSet
                    .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new CompareHashFileVisitor(dirRepo.toPath(), dirTempRepo.toPath()));
            assertTrue(true);
        } catch (IOException e) {
            fail("IOException at testRepoCommit" + e.getMessage());
        }
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

    class CopyFileVisitor extends SimpleFileVisitor<Path>{
        private Path source;

        CopyFileVisitor(Path source) {
            super();
            this.source = source;
        }
        
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
    }
    
    class CompareHashFileVisitor extends SimpleFileVisitor<Path>{
        private Path pathToBeCompared;
        private Path pathToCompareTo;
        
        public CompareHashFileVisitor(Path pathToBeCompared, Path pathToCompareTo) {
            super();
            this.pathToBeCompared = pathToBeCompared;
            this.pathToCompareTo = pathToCompareTo;
        }
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) throws IOException {
            if (dir.endsWith(".svn") || dir.endsWith(".git")) {
                return FileVisitResult.SKIP_SUBTREE;
            } else {
                return FileVisitResult.CONTINUE;
            }
        }
        
        @Override
        public FileVisitResult visitFile(Path file1, BasicFileAttributes attrs)
            throws IOException
        {
            File file2 = new File(pathToCompareTo.toFile(),pathToBeCompared.relativize(file1).toString());
            if (!file2.exists() || file2.isDirectory() || !Arrays.equals(computeChecksum(file1), computeChecksum(file2.toPath()))){
                fail ("md5 hashes differ at testRepoCheckOut");
            }
            return FileVisitResult.CONTINUE;
        }
        
        private byte[] computeChecksum(Path filename) throws IOException {
            InputStream fis =  new FileInputStream(filename.toFile());

            byte[] buffer = new byte[1024];
            MessageDigest complete = null;
            try {
                complete = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                fail("No MD5 checksum method available");
            }
            int numRead;

            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    complete.update(buffer, 0, numRead);
                }
            } while (numRead != -1);

            fis.close();
            return complete.digest();
        }
    }
}
