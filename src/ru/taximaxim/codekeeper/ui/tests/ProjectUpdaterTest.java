package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class ProjectUpdaterTest {
    
    private static final String ENCODING = UIConsts.UTF_8;
    private PgDatabase dbOld, dbNew;
    private TempDir workingDir, referenceDir;
    
    @Before
    public void before() throws IOException{
        try(InputStream isOld = ProjectUpdaterTest.class.getResourceAsStream("old.sql"); //$NON-NLS-1$
                InputStream isNew = ProjectUpdaterTest.class.getResourceAsStream("new.sql");){ //$NON-NLS-1$
            Assert.assertNotNull("Could not load resource", isOld); //$NON-NLS-1$
            Assert.assertNotNull("Could not load resource", isNew); //$NON-NLS-1$
            
            dbOld = PgDumpLoader.loadDatabaseSchemaFromDump(isOld, ENCODING, false, false);
            dbNew = PgDumpLoader.loadDatabaseSchemaFromDump(isNew, ENCODING, false, false);
        }
        
        workingDir = new TempDir("test_new"); //$NON-NLS-1$
        referenceDir = new TempDir("test_old"); //$NON-NLS-1$
        
        new ModelExporter(workingDir.get(), dbOld, ENCODING).exportFull();
    }
    
    @Test
    public void updateSuccessTest() throws IOException, PgCodekeeperUIException{
        PgDbProject proj = PgDbProject.getProjFromFile(workingDir.get().getAbsolutePath());
        proj.getPrefs().put(UIConsts.PROJ_PREF.ENCODING, ENCODING);
        new ProjectUpdater(dbNew, null, null, proj).updateFull();

        new ModelExporter(referenceDir.get(), dbOld, ENCODING).exportFull();
        if (compareFilesInPaths(workingDir.get().toPath(), referenceDir.get().toPath())){
            fail("ProjectUpdate fail: expected bases to differ");
        }
    }
    
    @Test
    public void updateFailTest() throws IOException, PgCodekeeperUIException{
        try{
            PgDbProject proj = PgDbProject.getProjFromFile(workingDir.get().getAbsolutePath());
            proj.getPrefs().put(UIConsts.PROJ_PREF.ENCODING, "");
            new ProjectUpdater(dbNew, null, null, proj).updateFull();
        }catch(IOException ex){
            // expected behavior
        }
            
        new ModelExporter(referenceDir.get(), dbOld, ENCODING).exportFull();
        if (!compareFilesInPaths(workingDir.get().toPath(), referenceDir.get().toPath())){
            fail("ProjectUpdate fail: expected bases to be the same");
        }
    }
    
    @After
    public void after(){
        try{
            workingDir.close();
        }catch(Exception ex){
            Log.log(Log.LOG_WARNING, "Could not delete folder " + 
                    (workingDir.get() == null ? "null" : workingDir.get().getAbsolutePath()), ex);
        }
        try{
            referenceDir.close();
        }catch(Exception ex){
            Log.log(Log.LOG_WARNING, "Could not delete folder " + 
                    (referenceDir.get() == null ? "null" : referenceDir.get().getAbsolutePath()), ex);
        }
    }
    
    /**
     * Returns whether these two paths' content is the same
     */
    private boolean compareFilesInPaths(Path path1, Path path2) throws IOException {
        AtomicBoolean differs = new AtomicBoolean(false);
        Files.walkFileTree(path1, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
        new CompareHashFileVisitor(path1, path2, differs));

        Files.walkFileTree(path2, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
        new CompareHashFileVisitor(path2, path1, differs));
        return !differs.get();
    }
    
    private static class CompareHashFileVisitor extends SimpleFileVisitor<Path>{
        private Path pathToBeCompared;
        private Path pathToCompareTo;
        private AtomicBoolean differs;
        private static final String PROJECT_FILE_NAME = ".project";
        
        public CompareHashFileVisitor(Path pathToBeCompared, Path pathToCompareTo, AtomicBoolean differs) {
            super();
            this.differs = differs;
            this.pathToBeCompared = pathToBeCompared;
            this.pathToCompareTo = pathToCompareTo;
        }
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFile(Path file1, BasicFileAttributes attrs)
            throws IOException
        {
            if (file1.endsWith(PROJECT_FILE_NAME )){
                return FileVisitResult.CONTINUE;
            }
            File file2 = new File(pathToCompareTo.toFile(),pathToBeCompared.relativize(file1).toString());
            if (!file2.exists() || file2.isDirectory() || !Arrays.equals(computeChecksum(file1), computeChecksum(file2.toPath()))){
                differs.set(true);
            }
            return FileVisitResult.CONTINUE;
        }
        
        private byte[] computeChecksum(Path filename) throws IOException {
            try(InputStream fis = new FileInputStream(filename.toFile())) {

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
                return complete.digest();
            }
        }
    }
}
