package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.MsModelExporter;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DbSourceTest {

    private static PgDatabase dbPredefined;
    private static File workspacePath;
    private static IWorkspaceRoot workspaceRoot;

    @BeforeClass
    public static void initDb() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        dbPredefined = ApgdiffTestUtils.loadTestDump(ApgdiffTestUtils.RESOURCE_DUMP, ApgdiffTestUtils.class, args);

        workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        workspacePath = workspaceRoot.getLocation().toFile();
        assertTrue("Workspace does not exist: " + workspacePath.getAbsolutePath(), workspacePath.exists());
    }

    @Test
    public void testDirTree() throws IOException, InterruptedException, CoreException {
        try(TempDir exportDir = new TempDir("pgcodekeeper-test")){
            Path dir = exportDir.get();
            new ModelExporter(dir, dbPredefined, ApgdiffConsts.UTF_8).exportFull();

            performTest(DbSource.fromDirTree(true, dir.toAbsolutePath().toString(),
                    ApgdiffConsts.UTF_8, false, null));
        }
    }

    @Test
    public void testFile() throws IOException, URISyntaxException, InterruptedException,
    CoreException {
        URL urla = ApgdiffTestUtils.class.getResource(ApgdiffTestUtils.RESOURCE_DUMP);

        performTest(DbSource.fromFile(true, ApgdiffUtils.getFileFromOsgiRes(urla),
                ApgdiffConsts.UTF_8, false, null));
    }

    @Test
    public void testProject() throws CoreException, IOException, PgCodekeeperUIException,
    InterruptedException{
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")){
            Path dir = tempDir.get();
            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), false);

            // populate project with data
            new ModelExporter(dir, dbPredefined, ApgdiffConsts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create pgcodekeeperignoreschema file in tempDir
            String rule = "SHOW ALL";
            Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));

            // testing itself
            assertEquals("Project name differs", dir.getFileName().toString(), project.getName());
            performTest(DbSource.fromProject(new PgDbProject(project)));
            project.delete(false, true, null);
        }
    }

    @Test
    public void testDbSourceWithIgnoreSchemas() throws CoreException, IOException, PgCodekeeperUIException,
    InterruptedException{
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")){
            Path dir = tempDir.get();

            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), false);

            // populate project with data
            new ModelExporter(dir, dbPredefined, ApgdiffConsts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create .pgcodekeeperignoreschema file with black list rule in tempDir
            ApgdiffTestUtils.createIgnoredSchemaFile(dir);

            DbSource dbSourceProj =  DbSource.fromProject(new PgDbProject(project));
            PgDatabase db = dbSourceProj.get(SubMonitor.convert(null, "", 1));

            for (AbstractSchema dbSchema : db.getSchemas()) {
                if (ApgdiffTestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assert.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assert.assertEquals("Schema from dump isn't equal schema from loader",
                            dbPredefined.getSchema(dbSchema.getName()), dbSchema);
                }
            }
            project.delete(false, true, null);
        }
    }

    @Test
    public void testMsDbSourceWithIgnoreSchemas() throws CoreException, IOException, PgCodekeeperUIException,
    InterruptedException{
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")){
            Path dir = tempDir.get();
            PgDiffArguments args = new PgDiffArguments();
            args.setMsSql(true);

            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getFileName().toString(), true);

            // populate project with data
            PgDatabase msDb = ApgdiffTestUtils.loadTestDump(ApgdiffTestUtils.RESOURCE_MS_DUMP, ApgdiffTestUtils.class, args);
            new MsModelExporter(dir, msDb, ApgdiffConsts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // create .pgcodekeeperignoreschema file with black list rule in tempDir
            ApgdiffTestUtils.createIgnoredSchemaFile(dir);

            DbSource dbSourceProj =  DbSource.fromProject(new PgDbProject(project));
            PgDatabase db = dbSourceProj.get(SubMonitor.convert(null, "", 1));

            for (AbstractSchema dbSchema : db.getSchemas()) {
                if (ApgdiffTestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assert.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assert.assertEquals("Schema from ms dump isn't equal schema from loader",
                            msDb.getSchema(dbSchema.getName()), dbSchema);
                }
            }
            project.delete(false, true, null);
        }
    }

    private void performTest(DbSource source)
            throws IOException, InterruptedException, CoreException {
        assertFalse("DB source should not be loaded", source.isLoaded());

        try{
            source.getDbObject();
            fail("Source is not loaded yet, exception expected");
        }catch(IllegalStateException ex){
            // do nothing: expected behavior
        }
        PgDatabase dbSource = source.get(SubMonitor.convert(null, "", 1));

        assertTrue("DB source should be loaded", source.isLoaded());

        assertEquals("Db loaded not equal to predefined db", dbPredefined, dbSource);
    }

    private IProject createProjectInWorkspace(String projectName, boolean isMsSql) throws CoreException{
        IProject project = workspaceRoot.getProject(projectName);
        PgDbProject.createPgDbProject(project, null, isMsSql);
        project.getNature(NATURE.ID).deconfigure();
        if (isMsSql) {
            project.getNature(NATURE.MS).deconfigure();
        }

        assertNotNull("Project location cannot be determined", project.getLocation());
        return project;
    }
}
