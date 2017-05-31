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
import java.text.MessageFormat;
import java.util.Random;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.service.prefs.BackingStoreException;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.TEST;
import cz.startnet.utils.pgdiff.loader.JdbcLoaderTest;
import cz.startnet.utils.pgdiff.loader.JdbcTestUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DbSourceTest {

    private static final String dbName = MessageFormat.format(
            TEST.REMOTE_DB_PATTERN,
            String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
    private static PgDatabase dbPredefined;
    private static File workspacePath;
    private static IWorkspaceRoot workspaceRoot;

    @BeforeClass
    public static void initDb() throws IOException, InterruptedException, LicenseException {
        JdbcTestUtils.createDb(dbName);
        ApgdiffTestUtils.fillDB(dbName);

        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        dbPredefined = ApgdiffTestUtils.loadTestDump(
                TEST.RESOURCE_DUMP, JdbcLoaderTest.class, args);

        workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        workspacePath = workspaceRoot.getLocation().toFile();
        assertTrue("Workspace does not exist: " + workspacePath.getAbsolutePath(), workspacePath.exists());

        IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
        prefs.setValue(PREF.LICENSE_PATH, ApgdiffTestUtils.getTestLicenseUrl().toString());
    }

    @Test
    public void testJdbc() throws IOException, LicenseException, InterruptedException, CoreException {
        performTest(DbSource.fromJdbc(TEST.REMOTE_HOST,
                TEST.REMOTE_PORT,
                TEST.REMOTE_USERNAME,
                TEST.REMOTE_PASSWORD,
                dbName,
                ApgdiffConsts.UTC,
                true));
    }

    @Test
    public void testDirTree() throws IOException, LicenseException, InterruptedException, CoreException {
        try(TempDir exportDir = new TempDir("pgcodekeeper-test")){
            new ModelExporter(exportDir.get(), dbPredefined, ApgdiffConsts.UTF_8).exportFull();

            performTest(DbSource.fromDirTree(true, exportDir.get().getAbsolutePath(), ApgdiffConsts.UTF_8));
        }
    }

    @Test
    public void testFile() throws IOException, LicenseException, URISyntaxException, InterruptedException,
    CoreException {
        URL urla = JdbcLoaderTest.class.getResource(TEST.RESOURCE_DUMP);

        performTest(DbSource.fromFile(true, ApgdiffUtils.getFileFromOsgiRes(urla), ApgdiffConsts.UTF_8));
    }

    @Test
    public void testProject() throws CoreException, IOException, LicenseException,
    PgCodekeeperUIException, InterruptedException{
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceProjectTest")){
            // create empty project in temp dir
            IProject project = createProjectInWorkspace(tempDir.get());

            // populate project with data
            new ModelExporter(tempDir.get(), dbPredefined, ApgdiffConsts.UTF_8).exportFull();

            // testing itself
            PgDbProject proj = new PgDbProject(project);
            proj.openProject();

            assertEquals("Project name differs", tempDir.get().getName(), proj.getProjectName());

            performTest(DbSource.fromProject(proj));

            proj.deleteFromWorkspace();
        }
    }

    @Test
    public void testJdbcFromProject()
            throws CoreException, IOException, LicenseException, PgCodekeeperUIException,
            URISyntaxException, BackingStoreException, InterruptedException {
        try(TempDir tempDir = new TempDir(workspacePath.toPath(), "dbSourceJdbcTest")){
            // create empty project in temp dir
            IProject project = createProjectInWorkspace(tempDir.get());

            // populate project with data
            new ModelExporter(tempDir.get(), dbPredefined, ApgdiffConsts.UTF_8).exportFull();

            // set required settings
            PgDbProject proj = new PgDbProject(project);
            proj.openProject();

            assertEquals("Project name differs", tempDir.get().getName(), proj.getProjectName());

            // testing itself
            performTest(DbSource.fromJdbc(TEST.REMOTE_HOST, TEST.REMOTE_PORT,
                    TEST.REMOTE_USERNAME, TEST.REMOTE_PASSWORD, dbName, ApgdiffConsts.UTC, true));

            proj.deleteFromWorkspace();
        }
    }

    @AfterClass
    public static void complete() throws IOException {
        // ApgdiffTestUtils.dropContents(dbName);
        ApgdiffTestUtils.dropDB(dbName);
    }

    private void performTest(DbSource source)
            throws IOException, InterruptedException, LicenseException, CoreException {
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

    private IProject createProjectInWorkspace(File projectPath) throws CoreException{
        IProject project = workspaceRoot.getProject(projectPath.getName());
        project.create(null);

        assertNotNull("Project location cannot be determined", project.getLocation());
        return project;
    }
}
