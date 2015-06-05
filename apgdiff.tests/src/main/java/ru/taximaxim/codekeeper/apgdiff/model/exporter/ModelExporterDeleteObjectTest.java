package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

/**
 * Test for partial export
 * 
 * <!-- 
 * Below is the list of differences between DBs in TestPartialExportSource.sql 
 * and TestPartialExportTarget.sql:
 * 
 * DELETED (exist in Source only):
 *      (TABLE)         public.rep2_statistics
 *      (CONSTRAINT)    public.rep2_workpool_data.pk_rep2_workpool_data
 *      (TRIGGER)       public.tz_worker_group.trd_tz_worker_group (GROUP: table left)
 *      (FUNCTION)      public.autocategorydel(integer)
 *      (FUNCTION)      public.test(integer)
 *      (FUNCTION)      public.test()
 *      (TABLE)         public.test_table
 *      (FUNCTION)      public.atsqueuedel(integer, integer, integer) (GROUP: 2 same named funcs left)
 *      (SCHEMA)        audit
 *      (TABLE)         audit.logged_actions
 *      (TABLE)         audit.tz_audit_201305
 * 
 * MODIFIED:
 *      (TABLE)         public.rep2_workpool_data
 *      (TABLE)         public.table1
 *      (CONSTRAINT)    public.table1.chk_table1 (GROUP: table1 changed as well)
 * 
 * NEW (exist in Target only):
 *      (FUNCTION)      public.automarkdel_new(integer)
 *      (FUNCTION)      public.automarkdel_new_new(integer) (GROUP: 2 new funcs)
 *      (SCHEMA)        newschema
 *      (CONSTRAINT)    public.t_auto_mark.chk_t_auto_mark (GROUP: table exists)
 *      (VIEW)          public.v_auto_mark_two
 *      (FUNCTION)      public.automarkdel_new_new(integer) (GROUP: 2 new funcs)
 *  -->
 * 
 * @author menshenin_aa
 */

@RunWith(value = Parameterized.class)
public class ModelExporterDeleteObjectTest {
    private static final String encoding = ApgdiffConsts.UTF_8;
    private final int index;
    
    private static PgDatabase dbSource;
    private static PgDatabase dbTarget;
    
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][]{
// SONAR-OFF
                    {1},{2},{3},{4},{5},{6},{6}
// SONAR-ON
                });
    }
    
    /**
     * Array of implementations of {@link PartialExportInfo}
     */
    private PartialExportInfo[] EXPORT_PRESETS = {
            new PartialExportInfoImpl_1(),
            new PartialExportInfoImpl_2(),
            new PartialExportInfoImpl_3(),
            new PartialExportInfoImpl_4(),
            new PartialExportInfoImpl_5(),
            new PartialExportInfoImpl_6(),
            new PartialExportInfoImpl_7()
        };
        
    public ModelExporterDeleteObjectTest(int index) {
        this.index = index;
    }
        
    @BeforeClass
    public static void initDiffTree() throws InterruptedException {
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(encoding);
        dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                PartialExporterTest.class.getResourceAsStream(sourceFilename),
                args, ParserClass.getLegacy(null, 1));
        args = new PgDiffArguments();
        args.setInCharsetName(encoding);
        dbTarget = PgDumpLoader.loadDatabaseSchemaFromDump(
                PartialExporterTest.class.getResourceAsStream(targetFilename),
                args, ParserClass.getLegacy(null, 1));
          
        Assert.assertNotNull(dbSource);
        Assert.assertNotNull(dbTarget);
    }
        
    @Before
    public void beforeTest() {
    EXPORT_PRESETS[index-1].setDiffTree(DiffTree.create(dbSource, dbTarget));
    }
    @Test
    public void testExportPartial () throws IOException{
        PartialExportInfo preset = EXPORT_PRESETS[index-1];
        TreeElement diffTree = preset.getDiffTree();
        
        Path exportDirFull = null;
        Path exportDirPartial = null;
        Path exportDirNewFull = null;
        try{
            exportDirFull = Files.createTempDirectory("pgCodekeeper-test-export-full");
            exportDirPartial = Files.createTempDirectory("pgCodekeeper-test-export-partial");
            exportDirNewFull = Files.createTempDirectory("pgCodekeeper-test-export-new-full");
            
            // full export of source
            new ModelExporter(exportDirFull.toFile(), dbSource, encoding).exportFull();
            
            // get new db with selected changes
            preset.setUserSelection();
            
            Collection<TreeElement> list = diffTree.flattenAlteredElements(
                    new ArrayList<TreeElement>(), dbSource, dbTarget, true, null);
            // full export of source to target directory
            new ModelExporter(exportDirPartial.toFile(), dbSource, encoding).exportFull();
            // full export of new to newFull directory
            new ModelExporter(exportDirNewFull.toFile(), dbSource, encoding).exportFull();
            // накатываем на полную базу частичные изменения
            new ModelExporter(exportDirPartial.toFile(), dbTarget, dbSource,
                    list, encoding).exportPartial();
            
            checkFile(exportDirPartial, exportDirNewFull, preset);
        }finally{
            if (exportDirFull != null){
                deleteRecursive(exportDirFull.toFile());
            }
            if (exportDirPartial != null){
                deleteRecursive(exportDirPartial.toFile());
            }
            if (exportDirNewFull != null){
                deleteRecursive(exportDirNewFull.toFile());
            }
        }
        
    }
    
    private void checkFile(Path exportDirPartial, Path exportDirNewFull,
            PartialExportInfo preset) throws IOException {
        // first compare full export to partial
        LinkedList<String> modifiedFiles = preset.modifiedFiles();
        LinkedList<String> deletedFiles = preset.deletedFiles();
        Path newFilePath = exportDirPartial, oldFilePath = exportDirNewFull;
        if (modifiedFiles.size() > 0){
            if (Files.readAllLines(Paths.get(newFilePath.toString() + "/", modifiedFiles.get(0)))
                    .equals(Files.readAllLines(Paths.get(oldFilePath.toString() + "/", modifiedFiles.get(0))))){
                Assert.fail(null);
            }
        }
        if (deletedFiles.size() > 0){
            if (!(!Files.isReadable(Paths.get(newFilePath.toString() + "/", deletedFiles.get(0)))
                    && Files.isReadable(Paths.get(oldFilePath.toString() + "/", deletedFiles.get(0))))){
                Assert.fail(null);
            }
        }
    }

    private static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.deleteIfExists(f.toPath());
    }

    abstract class PartialExportInfo {
        
        TreeElement diffTree;
        
        public TreeElement getDiffTree() {
            return diffTree;
        }

        public void setDiffTree(TreeElement diffTree) {
            this.diffTree = diffTree;
        }

        public abstract void setUserSelection();
        
        public LinkedList<String> modifiedFiles(){
            return new LinkedList<>();
        };
        public LinkedList<String> deletedFiles(){
            return new LinkedList<>();
        };
    }

    class PartialExportInfoImpl_1 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test()").setSelected(true);
        }

        @Override
        public LinkedList<String> modifiedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/test.sql"));
        }
    }

    class PartialExportInfoImpl_2 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test()").setSelected(true);
            schema.getChild("test(integer)").setSelected(true);
        }

        @Override
        public LinkedList<String> deletedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/test.sql"));
        }
    }
    
    class PartialExportInfoImpl_3 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test_table").getChild("idx_test_table_id").setSelected(true);
        }

        @Override
        public LinkedList<String> modifiedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/test_table.sql"));
        }
    }

    class PartialExportInfoImpl_4 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test_table").getChild("constr_test").setSelected(true);
        }

        @Override
        public LinkedList<String> modifiedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/test_table.sql"));
        }
    }
    
    class PartialExportInfoImpl_5 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test_table").getChild("constr_test").setSelected(true);
            schema.getChild("test_table").getChild("tri_test_table").setSelected(true);
        }

        @Override
        public LinkedList<String> modifiedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/test_table.sql"));
        }
    }
    
    class PartialExportInfoImpl_6 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test_table").getChild("idx_test_table_id").setSelected(true);
            schema.getChild("test_table").getChild("constr_test").setSelected(true);
            schema.getChild("test_table").getChild("tri_test_table").setSelected(true);
        }

        @Override
        public LinkedList<String> modifiedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/test_table.sql"));
        }
    }
    
    class PartialExportInfoImpl_7 extends PartialExportInfo{

        @Override
        public void setUserSelection() {
            TreeElement schema = diffTree.getChild("public");
            schema.getChild("test_table").setSelected(true);
        }

        @Override
        public LinkedList<String> deletedFiles() {
            return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/test_table.sql"));
        }
    }
}
