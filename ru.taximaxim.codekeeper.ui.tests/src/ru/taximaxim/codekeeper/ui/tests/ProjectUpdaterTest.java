/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.tests;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.fileutils.TempDir;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.fileutils.UIProjectUpdater;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectUpdaterTest {

    private static final String ENCODING = Consts.UTF_8;
    private AbstractDatabase dbOld;
    private AbstractDatabase dbNew;
    private TempDir workingDir;
    private TempDir referenceDir;

    @BeforeEach
    public void before() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ENCODING);
        dbOld = TestUtils.loadTestDump(
                "old.sql", ProjectUpdaterTest.class, args);

        args = new PgDiffArguments();
        args.setInCharsetName(ENCODING);
        dbNew = TestUtils.loadTestDump(
                "new.sql", ProjectUpdaterTest.class, args);

        workingDir = new TempDir("test_new"); //$NON-NLS-1$
        referenceDir = new TempDir("test_old"); //$NON-NLS-1$

        new ModelExporter(workingDir.get(), dbOld, ENCODING).exportFull();
    }

    @Test
    void updateSuccessTest() throws IOException, CoreException {
        File dir = workingDir.get().toFile();
        PgDbProject proj = PgDbProject.createPgDbProject(ResourcesPlugin.getWorkspace()
                .getRoot().getProject(dir.getName()), dir.toURI(), DatabaseType.PG);
        proj.getProject().getNature(NATURE.ID).deconfigure();
        proj.getProject().open(null);
        proj.getProject().setDefaultCharset(ENCODING, null);
        new UIProjectUpdater(dbNew, proj).updateFull(false);

        new ModelExporter(referenceDir.get(), dbOld, ENCODING).exportFull();
        if (compareFilesInPaths(workingDir.get(), referenceDir.get())){
            Assertions.fail("ProjectUpdate fail: expected bases to differ");
        }
        proj.getProject().close(null);
        proj.getProject().delete(false, true, null);
    }

    @AfterEach
    public void after() {
        try {
            workingDir.close();
        } catch(Exception ex){
            Log.log(Log.LOG_WARNING, "Could not delete folder " +
                    (workingDir.get() == null ? "null" : workingDir.get()), ex);
        }
        try {
            referenceDir.close();
        } catch(Exception ex){
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

    private static class CompareHashFileVisitor extends SimpleFileVisitor<Path> {
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
                throws IOException {
            if (file1.endsWith(PROJECT_FILE_NAME )) {
                return FileVisitResult.CONTINUE;
            }
            File file2 = new File(pathToCompareTo.toFile(),pathToBeCompared.relativize(file1).toString());
            if (!file2.exists() || file2.isDirectory() ||
                    !Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2.toPath()))) {
                differs.set(true);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
