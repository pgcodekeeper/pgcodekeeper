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

import org.eclipse.core.internal.resources.PreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.junit.Test;

import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class ProjectUpdaterTest {
    private final String ENCODING = "UTF-8";
    
    @Test
    public void updateSuccessTest() throws IOException, PgCodekeeperUIException{
        String filenameOld = "old.sql";
        String filenameNew = "new.sql";
        PgDatabase dbOld = PgDumpLoader.loadDatabaseSchemaFromDump(
                ProjectUpdaterTest.class.getResourceAsStream(filenameOld), ENCODING, false, false);
        PgDatabase dbNew = PgDumpLoader.loadDatabaseSchemaFromDump(
                ProjectUpdaterTest.class.getResourceAsStream(filenameNew), ENCODING, false, false);
        
        try (TempDir td = new TempDir("test_new")) { //$NON-NLS-1$
            File workingDirectory = td.get();
            new ModelExporter(workingDirectory, dbOld, ENCODING).export();
                    
            PgDbProject proj = PgDbProject.getProjFromFile("/home/ryabinin_av/aaaqs");
            proj.getPrefs().put(UIConsts.PROJ_PREF.ENCODING, ENCODING);
            new ProjectUpdater(dbNew, proj).update();
            
            try (TempDir td_old = new TempDir("test_old")) { //$NON-NLS-1$
                File referenceDirectory = td_old.get();
                new ModelExporter(referenceDirectory, dbOld, ENCODING).export();
                boolean areSame = compareFilesInPaths(workingDirectory.toPath(), referenceDirectory.toPath());
                if (areSame){
                    fail("ProjectUpdate fail: expected bases to differ");
                }
            }
        }
    }
 /*   
//    @Test
    public void updateFailTest() throws IOException{
        String filenameOld = "old.sql";
        String filenameNew = "new.sql";
        PgDatabase dbOld = PgDumpLoader.loadDatabaseSchemaFromDump(
                ProjectUpdaterTest.class.getResourceAsStream(filenameOld), ENCODING, false, false);
        PgDatabase dbNew = PgDumpLoader.loadDatabaseSchemaFromDump(
                ProjectUpdaterTest.class.getResourceAsStream(filenameNew), ENCODING, false, false);
        
        try (TempDir td = new TempDir("test_new")) { //$NON-NLS-1$
            File workingDirectory = td.get();
            new ModelExporter(workingDirectory, dbOld, ENCODING).export();
            
            // mocking PgDbProject instance
            IEclipsePreferences prefs = mock(IEclipsePreferences.class);
            Mockito.when(prefs.get(PROJ_PREF.ENCODING, "")).thenReturn("kokoko");
            PgDbProject proj = mock(PgDbProject.class);
            Mockito.when(proj.getPrefs()).thenReturn(prefs);
            Mockito.when(proj.getPathToProject()).thenReturn(workingDirectory.toPath());
//            
//            ru.taximaxim.codekeeper.ui.Activator act = new ru.taximaxim.codekeeper.ui.Activator();
//
//            
//            act.getDefault().getDefault();
            
            try{
                new ProjectUpdater(dbNew, proj).update();
            }
            catch(IOException ex){
                if (!ex.getMessage().equals(Messages.ProjectUpdater_error_no_tempdir)){
                    fail("ProjectUpdater failed with not expected exception: " + ex.getMessage());
                }
            }
            
            try (TempDir td_old = new TempDir("test_old")) { //$NON-NLS-1$
                File referenceDirectory = td_old.get();
                new ModelExporter(referenceDirectory, dbOld, ENCODING).export();
                boolean areSame = compareFilesInPaths(workingDirectory.toPath(), referenceDirectory.toPath());
                if (!areSame){
                    fail("ProjectUpdate fail: expected bases to be the same");
                }
            }
        }
    }*/
    
    private boolean compareFilesInPaths(Path path1, Path path2) throws IOException {
        Boolean differs = new Boolean(false);
        Files.walkFileTree(path1, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
        new CompareHashFileVisitor(path1, path2, differs));

        Files.walkFileTree(path2, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
        new CompareHashFileVisitor(path2, path1, differs));
        return differs;
    }
    
    private class CompareHashFileVisitor extends SimpleFileVisitor<Path>{
        private Path pathToBeCompared;
        private Path pathToCompareTo;
        private Boolean differs;
        
        public CompareHashFileVisitor(Path pathToBeCompared, Path pathToCompareTo, Boolean differs) {
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
            File file2 = new File(pathToCompareTo.toFile(),pathToBeCompared.relativize(file1).toString());
            if (!file2.exists() || file2.isDirectory() || !Arrays.equals(computeChecksum(file1), computeChecksum(file2.toPath()))){
                differs = true;
            }
            return FileVisitResult.CONTINUE;
        }
        
        private byte[] computeChecksum(Path filename) throws IOException {
            InputStream fis = new FileInputStream(filename.toFile());

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
