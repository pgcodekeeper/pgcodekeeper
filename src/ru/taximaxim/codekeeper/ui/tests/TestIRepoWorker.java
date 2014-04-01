package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.EnumSet;

import org.eclipse.e4.core.services.log.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;

public abstract class TestIRepoWorker {

    protected IRepoWorker repo;
    protected Path pathToWorking;
    protected Path pathToOrigin;
    private File dirTempRepo;
    
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
        if(dirTempRepo != null)
            Dir.deleteRecursive(dirTempRepo);
    }
    
    @Test
    public void testRepoCheckOut() throws IOException {
            repo.repoCheckOut(pathToWorking.toFile(), null);
            Path pathToOriginalFiles = FileSystems.getDefault().getPath("resources").toAbsolutePath();
            compareFilesInPaths(pathToOriginalFiles, pathToWorking);
            assertTrue(true);
    }
    
    @Test
    public void testRepoCommit() throws IOException {
            File dirRepo = new File(pathToWorking.toString());
            repo.repoCheckOut(dirRepo);
            // modify file in repo
            appendToFile(pathToWorking.toString()
                    + System.getProperty("file.separator") + "EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql", "added");
            repo.repoCommit(dirRepo, "test");
            dirTempRepo = Files.createTempDirectory("").toFile();
            repo.repoCheckOut(dirTempRepo);
            compareFilesInPaths(dirTempRepo.toPath(), pathToWorking); 
            assertTrue(true);
    }
    
    @Test
    public void testHasConflicts() throws IOException {
            File dirRepoA = pathToWorking.toFile();
            repo.repoCheckOut(dirRepoA);
            dirTempRepo = Files.createTempDirectory("").toFile();
            repo.repoCheckOut(dirTempRepo);
            appendToFile(dirRepoA.toString()
                    + System.getProperty("file.separator") + "EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql", "A");
            appendToFile(
                    dirTempRepo.toString() + System.getProperty("file.separator")
                            + "EXTENSION"
                            + System.getProperty("file.separator")
                            + "file1.sql", "B");
            // commit changes from A to origin
            repo.repoCommit(dirRepoA, "AAA");
            // Throws Exception, since there is conflict. We call it, because it's the 
            // only way for GitExec to stage files using IRepoWorker available methods
            if (repo instanceof JGitExec) {
                try {
                    repo.repoCommit(dirTempRepo, "BBB");
                } catch (IllegalStateException | IOException e ) {
                    // Exception expected
                }
            }
            repo.repoUpdate(dirTempRepo);
            assertTrue(repo.hasConflicts(dirTempRepo));
    }

    @Test
    public void testRepoUpdate() throws IOException {
            File dirRepo = pathToWorking.toFile();
            repo.repoCheckOut(dirRepo);
            dirTempRepo = Files.createTempDirectory("").toFile();
            repo.repoCheckOut(dirTempRepo);
            appendToFile(dirTempRepo.toString()
                    + System.getProperty("file.separator") + "EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql", "added");
            repo.repoCommit(dirTempRepo, "test");
            repo.repoUpdate(dirRepo);
            compareFilesInPaths(dirTempRepo.toPath(), dirRepo.toPath());
            assertTrue(true);
    }

    @Test
    public void testGetRepoMetaFolder() {
        if (repo.getRepoMetaFolder().equals(".git") || repo.getRepoMetaFolder().equals(".svn")){
            assertTrue(true);
        }else{
            fail("Repo meta folder differs from .svn or .git");
        }
    }

    @Test
    public void testRepoRemoveMissingAddNew() throws IOException {
            File dirRepoA = pathToWorking.toFile();
            repo.repoCheckOut(dirRepoA);
            Files.delete(pathToWorking.resolve(new File("EXTENSION"
                    + System.getProperty("file.separator") + "file1.sql")
                    .toPath()));
            
            Path path = pathToWorking.resolve(new File("EXTENSION"
                    + System.getProperty("file.separator") + "newfile")
                    .toPath());
            Files.createFile(path);
            repo.repoRemoveMissingAddNew(dirRepoA);
            repo.repoCommit(dirRepoA, "1 removed, 1 added");
            dirTempRepo = Files.createTempDirectory("").toFile();
            repo.repoCheckOut(dirTempRepo);
            compareFilesInPaths(dirRepoA.toPath(), dirTempRepo.toPath());
            assertTrue(true);
    }
       
    private void compareFilesInPaths(Path path1, Path path2) throws IOException{
        Files.walkFileTree(path1, EnumSet
                .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new CompareHashFileVisitor(path1, path2));
        Files.walkFileTree(path2, EnumSet
                .of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new CompareHashFileVisitor(path2, path1));
    }

    /**
     * Creates temporary dir pathToOrigin, copies files from resources there,
     * inits git repo there and commits copied files
     * @throws IOException 
     */
    protected void copyFilesToPath(Path destination) throws IOException {
        final Path source = FileSystems.getDefault().getPath("resources");
        Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                Integer.MAX_VALUE, new CopyFileVisitor(source, destination));
    }

    private static void appendToFile(String file, String textToAppend) throws IOException{
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bw);
        printWriter.println(textToAppend);
        printWriter.close();
        bw.close();
        fw.close();
    }
    
    private class CopyFileVisitor extends SimpleFileVisitor<Path>{
        private Path source;
        private Path destination;
        
        CopyFileVisitor(Path source, Path destination) {
            super();
            this.source = source;
            this.destination = destination;
        }
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException
        {
            Path targetdir = destination.resolve(source.relativize(dir));
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
            Files.copy(file, destination.resolve(source.relativize(file)));
            return FileVisitResult.CONTINUE;
        }
    }
    
    private class CompareHashFileVisitor extends SimpleFileVisitor<Path>{
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
