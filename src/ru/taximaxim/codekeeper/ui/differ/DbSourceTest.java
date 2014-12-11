package ru.taximaxim.codekeeper.ui.differ;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.TEST;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoaderTest;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class DbSourceTest {

    private static JdbcConnector connector;
    private static final String RESOURCE_DUMP = "remote/testing_dump.sql";
    private static final String RESOURCE_CLEANUP = "remote/testing_cleanup.sql";
    private static PgDatabase dbPredefined;
    
    @BeforeClass
    public static void initDb() throws IOException{
        connector = new JdbcConnector(  TEST.REMOTE_HOST, 
                                        TEST.REMOTE_PORT, 
                                        TEST.REMOTE_USERNAME, 
                                        TEST.REMOTE_PASSWORD, 
                                        TEST.REMOTE_DB, 
                                        ApgdiffConsts.UTF_8, 
                                        ApgdiffConsts.UTC);
        
        // remove old schemas
        try(InputStreamReader isr = new InputStreamReader(
                JdbcLoaderTest.class.getResourceAsStream(RESOURCE_CLEANUP), "UTF-8");
                BufferedReader reader = new BufferedReader(isr)){
            
            StringBuilder script = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                script.append(line);
            }
            
            String res = new JdbcRunner(connector).runScript(script.toString());
            Assert.assertEquals("DB cleanup script returned an error: " + res, "success", res);
        }
        
        // dump schemas back
        try(InputStreamReader isr = new InputStreamReader(
                JdbcLoaderTest.class.getResourceAsStream(RESOURCE_DUMP), "UTF-8");
                BufferedReader reader = new BufferedReader(isr)){
            
            StringBuilder script = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                script.append(line);
                script.append("\n");
            }
            
            String res = new JdbcRunner(connector).runScript(script.toString());
            Assert.assertEquals("DDL update over JDBC exited with an error: " + res, "success", res);
        }
        
        dbPredefined = PgDumpLoader.loadDatabaseSchemaFromDump(
                JdbcLoaderTest.class.getResourceAsStream(RESOURCE_DUMP),
                ApgdiffConsts.UTF_8, false, false);
    }
    
    @Test
    public void testJdbc() throws IOException{
        final DbSource source = DbSource.fromJdbc(TEST.REMOTE_HOST, 
                                            TEST.REMOTE_PORT, 
                                            TEST.REMOTE_USERNAME, 
                                            TEST.REMOTE_PASSWORD, 
                                            TEST.REMOTE_DB, 
                                            UIConsts.UTF_8, 
                                            UIConsts.UTC);
        Assert.assertFalse("DB source should not be loaded", source.isLoaded());
        
        PgDatabase dbJdbc = source.get(SubMonitor.convert(new NullProgressMonitor(), "", 1));
        
        Assert.assertTrue("DB source should be loaded", source.isLoaded());
        
        Assert.assertEquals("Db loaded from JDBC not equal to predefined db", dbPredefined, dbJdbc);
    }
    
    @Test
    public void testDirTree() throws IOException{
        try(TempDir exportDir = new TempDir("pgcodekeeper-test")){
            new ModelExporter(exportDir.get(), dbPredefined, UIConsts.UTF_8).exportFull();
            
            final DbSource source = DbSource.fromDirTree(exportDir.get().getAbsolutePath(), UIConsts.UTF_8);
            Assert.assertFalse("DB source should not be loaded", source.isLoaded());
            
            PgDatabase dbDirTree = source.get(SubMonitor.convert(new NullProgressMonitor(), "", 1));
            
            Assert.assertTrue("DB source should be loaded", source.isLoaded());
            
            Assert.assertEquals("Db loaded from dir tree not equal to predefined db", dbPredefined, dbDirTree);
        }
    }
    
    @Test
    public void testFilter () throws InvocationTargetException, PgCodekeeperUIException, IOException{
        DbSource predefined = DbSource.fromDbObject(dbPredefined, "predefined");
        final TreeDiffer differ = new TreeDiffer(predefined, 
                DbSource.fromDbObject(new PgDatabase(), "empty"));
        differ.run(new NullProgressMonitor());
        TreeElement diff = differ.getDiffTree();
        
        DbSource source = DbSource.fromFilter(predefined, diff, DiffSide.LEFT);
        
        Assert.assertFalse("DB source should not be loaded", source.isLoaded());
        
        PgDatabase dbFiltered = source.get(SubMonitor.convert(new NullProgressMonitor(), "", 1));

        Assert.assertTrue("DB source should be loaded", source.isLoaded());
        
        Assert.assertEquals("Db loaded from filter not equal to predefined db", dbPredefined, dbFiltered);
    }
    
    @Test
    public void testFile () throws IOException, URISyntaxException {
        URL urla = JdbcLoaderTest.class.getResource(RESOURCE_DUMP);
        
        final DbSource source = DbSource.fromFile(new File(FileLocator.toFileURL(urla).toURI()).getCanonicalPath(), UIConsts.UTF_8);
        
        Assert.assertFalse("DB source should not be loaded", source.isLoaded());
        
        PgDatabase dbFile = source.get(SubMonitor.convert(new NullProgressMonitor(), "", 1));
        
        Assert.assertTrue("DB source should be loaded", source.isLoaded());
        
        Assert.assertEquals("Db loaded from file not equal to predefined db", dbPredefined, dbFile);
    }
}
