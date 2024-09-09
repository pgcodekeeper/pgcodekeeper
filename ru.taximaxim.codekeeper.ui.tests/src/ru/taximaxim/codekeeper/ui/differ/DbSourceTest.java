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
package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.fileutils.TempDir;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.ui.UiTestUtils;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DbSourceTest {

    private static AbstractDatabase dbPredefined;
    private static File workspacePath;
    private static IWorkspaceRoot workspaceRoot;

    @BeforeAll
    public static void initDb() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(Consts.UTF_8);
        dbPredefined = UiTestUtils.loadTestDump(UiTestUtils.RESOURCE_DUMP, UiTestUtils.class, args);

        workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        workspacePath = workspaceRoot.getLocation().toFile();
        assertTrue(workspacePath.exists(), "Workspace does not exist: " + workspacePath.getAbsolutePath());
    }

    @Test
    void testDirTree() throws IOException, InterruptedException, CoreException {
        try (TempDir exportDir = new TempDir("pgcodekeeper-test")) {
            Path dir = exportDir.get();
            new ModelExporter(dir, dbPredefined, DatabaseType.PG, Consts.UTF_8).exportFull();

            performTest(DbSource.fromDirTree(true, dir.toAbsolutePath().toString(),
                    Consts.UTF_8, DatabaseType.PG, null));
        }
    }

    @Test
    void testFile() throws IOException, URISyntaxException, InterruptedException, CoreException {
        Path path = UiTestUtils.getPathToResource(UiTestUtils.RESOURCE_DUMP, UiTestUtils.class);
        performTest(DbSource.fromFile(true, path, Consts.UTF_8, DatabaseType.PG, null));
    }

    @Test
    void testProject() throws CoreException, IOException, InterruptedException {
        try (TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")) {
            Path dir = tempDir.get();
            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), DatabaseType.PG);

            // populate project with data
            new ModelExporter(dir, dbPredefined, DatabaseType.PG, Consts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create pgcodekeeperignoreschema file in tempDir
            String rule = "SHOW ALL";
            Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));

            // testing itself
            assertEquals(dir.getFileName().toString(), project.getName(), "Project name differs");
            performTest(DbSource.fromProject(new PgDbProject(project)));
            project.delete(false, true, null);
        }
    }

    @Test
    void testDbSourceWithIgnoreSchemas() throws CoreException, IOException, InterruptedException {
        try (TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")) {
            Path dir = tempDir.get();

            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), DatabaseType.PG);

            // populate project with data
            new ModelExporter(dir, dbPredefined, DatabaseType.PG, Consts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create .pgcodekeeperignoreschema file with black list rule in tempDir
            UiTestUtils.createIgnoredSchemaFile(dir);

            DbSource dbSourceProj = DbSource.fromProject(new PgDbProject(project));
            AbstractDatabase db = dbSourceProj.get(SubMonitor.convert(null, "", 1));

            for (AbstractSchema dbSchema : db.getSchemas()) {
                if (UiTestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assertions.fail("Ignored Schema loaded " + dbSchema.getName());
                }

                Assertions.assertEquals(dbPredefined.getSchema(dbSchema.getName()), dbSchema,
                        "Schema from dump isn't equal schema from loader");
            }
            project.delete(false, true, null);
        }
    }

    @Test
    void testMsDbSourceWithIgnoreSchemas() throws CoreException, IOException, InterruptedException {
        try (TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")) {
            Path dir = tempDir.get();
            PgDiffArguments args = new PgDiffArguments();
            args.setDbType(DatabaseType.MS);

            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), DatabaseType.MS);

            // populate project with data
            AbstractDatabase msDb = UiTestUtils.loadTestDump(UiTestUtils.RESOURCE_MS_DUMP, UiTestUtils.class, args);
            new ModelExporter(dir, msDb, DatabaseType.MS, Consts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create .pgcodekeeperignoreschema file with black list rule in tempDir
            UiTestUtils.createIgnoredSchemaFile(dir);

            DbSource dbSourceProj = DbSource.fromProject(new PgDbProject(project));
            AbstractDatabase db = dbSourceProj.get(SubMonitor.convert(null, "", 1));

            for (AbstractSchema dbSchema : db.getSchemas()) {
                if (UiTestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assertions.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assertions.assertEquals(msDb.getSchema(dbSchema.getName()), dbSchema,
                            "Schema from ms dump isn't equal schema from loader");
                }
            }
            project.delete(false, true, null);
        }
    }

    private void performTest(DbSource source) throws IOException, InterruptedException, CoreException {
        assertFalse(source.isLoaded(), "DB source should not be loaded");

        try {
            source.getDbObject();
            fail("Source is not loaded yet, exception expected");
        } catch (IllegalStateException ex) {
            // do nothing: expected behavior
        }
        AbstractDatabase dbSource = source.get(SubMonitor.convert(null, "", 1));

        assertTrue(source.isLoaded(), "DB source should be loaded");

        assertEquals(dbPredefined, dbSource, "Db loaded not equal to predefined db");
    }

    private IProject createProjectInWorkspace(String projectName, DatabaseType dbType) throws CoreException {
        IProject project = workspaceRoot.getProject(projectName);
        PgDbProject.createPgDbProject(project, null, dbType);
        project.getNature(NATURE.ID).deconfigure();
        if (dbType == DatabaseType.MS) {
            project.getNature(NATURE.MS).deconfigure();
        } else if (dbType == DatabaseType.CH) {
            project.getNature(NATURE.CH).deconfigure();
        }

        assertNotNull(project.getLocation(), "Project location cannot be determined");
        return project;
    }
}
