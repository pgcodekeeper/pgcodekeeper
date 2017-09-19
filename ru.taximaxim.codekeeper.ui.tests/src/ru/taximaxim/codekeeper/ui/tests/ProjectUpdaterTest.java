package ru.taximaxim.codekeeper.ui.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectUpdaterTest {

    private static final String ENCODING = ApgdiffConsts.UTF_8;
    private PgDatabase dbOld, dbNew;
    private TempDir workingDir, referenceDir;

    @Before
    public void before() throws IOException, InterruptedException, LicenseException {
        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(ENCODING);
        dbOld = ApgdiffTestUtils.loadTestDump(
                "old.sql", ProjectUpdaterTest.class, args);

        args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(ENCODING);
        dbNew = ApgdiffTestUtils.loadTestDump(
                "new.sql", ProjectUpdaterTest.class, args);

        workingDir = new TempDir("test_new"); //$NON-NLS-1$
        referenceDir = new TempDir("test_old"); //$NON-NLS-1$

        new ModelExporter(workingDir.get().toFile(), dbOld, ENCODING).exportFull();
    }

    @Test
    public void updateSuccessTest() throws IOException, PgCodekeeperUIException, CoreException{
        File dir = workingDir.get().toFile();
        PgDbProject proj = PgDbProject.createPgDbProject(ResourcesPlugin.getWorkspace()
                .getRoot().getProject(dir.getName()), dir.toURI());
        proj.getProject().open(null);
        proj.getProject().setDefaultCharset(ENCODING, null);
        new ProjectUpdater(dbNew, null, null, proj).updateFull();

        new ModelExporter(referenceDir.get().toFile(), dbOld, ENCODING).exportFull();
        if (compareFilesInPaths(workingDir.get(), referenceDir.get())){
            fail("ProjectUpdate fail: expected bases to differ");
        }
        proj.getProject().close(null);
    }

    @After
    public void after(){
        try{
            workingDir.close();
        }catch(Exception ex){
            Log.log(Log.LOG_WARNING, "Could not delete folder " +
                    (workingDir.get() == null ? "null" : workingDir.get()), ex);
        }
        try{
            referenceDir.close();
        }catch(Exception ex){
            Log.log(Log.LOG_WARNING, "Could not delete folder " +
                    (referenceDir.get() == null ? "null" : referenceDir.get()), ex);
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
        private final Path pathToBeCompared;
        private final Path pathToCompareTo;
        private final AtomicBoolean differs;
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
            if (!file2.exists() || file2.isDirectory() ||
                    !Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2.toPath()))){
                differs.set(true);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
