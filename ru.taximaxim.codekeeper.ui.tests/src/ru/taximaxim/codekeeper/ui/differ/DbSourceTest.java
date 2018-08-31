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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DbSourceTest {

    private static final String DUMP = "test_dump.sql";

    private static PgDatabase dbPredefined;
    private static File workspacePath;
    private static IWorkspaceRoot workspaceRoot;

    @BeforeClass
    public static void initDb() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        dbPredefined = ApgdiffTestUtils.loadTestDump(DUMP, DbSourceTest.class, args);

        workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        workspacePath = workspaceRoot.getLocation().toFile();
        assertTrue("Workspace does not exist: " + workspacePath.getAbsolutePath(), workspacePath.exists());
    }

    @Test
    public void testDirTree() throws IOException, InterruptedException, CoreException {
        try(TempDir exportDir = new TempDir("pgcodekeeper-test")){
            File dir = exportDir.get().toFile();
            new ModelExporter(dir, dbPredefined, ApgdiffConsts.UTF_8).exportFull();

            performTest(DbSource.fromDirTree(true, dir.getAbsolutePath(), ApgdiffConsts.UTF_8, false));
        }
    }

    @Test
    public void testFile() throws IOException, URISyntaxException, InterruptedException,
    CoreException {
        URL urla = DbSourceTest.class.getResource(DUMP);

        performTest(DbSource.fromFile(true, ApgdiffUtils.getFileFromOsgiRes(urla), ApgdiffConsts.UTF_8, false));
    }

    @Test
    public void testProject() throws CoreException, IOException, PgCodekeeperUIException,
    InterruptedException{
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")){
            File dir = tempDir.get().toFile();
            // create empty project in temp dir
            IProject project = createProjectInWorkspace(dir.getName());

            // populate project with data
            new ModelExporter(dir, dbPredefined, ApgdiffConsts.UTF_8).exportFull();
            project.refreshLocal(IResource.DEPTH_INFINITE, null);

            // testing itself
            assertEquals("Project name differs", dir.getName(), project.getName());
            performTest(DbSource.fromProject(new PgDbProject(project)));
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

    private IProject createProjectInWorkspace(String projectName) throws CoreException{
        IProject project = workspaceRoot.getProject(projectName);
        PgDbProject.createPgDbProject(project, null, false);
        project.getNature(NATURE.ID).deconfigure();

        assertNotNull("Project location cannot be determined", project.getLocation());
        return project;
    }
}
