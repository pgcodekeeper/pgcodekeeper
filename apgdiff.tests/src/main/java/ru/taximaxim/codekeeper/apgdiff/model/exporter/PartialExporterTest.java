package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

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
 * @author ryabinin_av
 */

@RunWith(value = Parameterized.class)
public class PartialExporterTest {
    private static final String encoding = ApgdiffConsts.UTF_8;
    private final int index;
    
    private static PgDatabase dbSource;
    private static PgDatabase dbTarget;
    
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][]{
// SONAR-OFF
                    {1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15}
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
        new PartialExportInfoImpl_7(),
        new PartialExportInfoImpl_8(),
        new PartialExportInfoImpl_9(),
        new PartialExportInfoImpl_10(),
        new PartialExportInfoImpl_11(),
        new PartialExportInfoImpl_12(),
        new PartialExportInfoImpl_13(),
        new PartialExportInfoImpl_14(),
        new PartialExportInfoImpl_15()
    };
    
    public PartialExporterTest(int index) {
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
            
            List<TreeElement> list = (List<TreeElement>) diffTree.flattenAlteredElements(
                    new ArrayList<TreeElement>(), dbSource, dbTarget, true, null);
            // full export of source to target directory
            new ModelExporter(exportDirPartial.toFile(), dbSource, encoding).exportFull();
            // full export of new to newFull directory
            new ModelExporter(exportDirNewFull.toFile(), dbTarget, encoding).exportFull();
            // накатываем на полную базу частичные изменения
            new ModelExporter(exportDirPartial.toFile(), dbTarget, dbSource,
                    list, encoding).exportPartial();
            
            walkAndComare(exportDirFull, exportDirPartial, exportDirNewFull, preset);
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
    
    private void walkAndComare(Path exportDirFull, Path exportDirPartial, Path exportDirNewFull,
            PartialExportInfo preset) throws IOException {
        // first compare full export to partial
        LinkedList<String> modifiedFiles = preset.modifiedFiles();
        LinkedList<String> newFiles = preset.newFiles();
        LinkedList<String> deletedFiles = preset.deletedFiles();
        
        Files.walkFileTree(exportDirFull, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(exportDirFull, exportDirPartial, 
                        exportDirNewFull, modifiedFiles, newFiles, deletedFiles, true));

        if (modifiedFiles.size() != 0 || deletedFiles.size() != 0){
            Assert.assertTrue("Not all objects in modified/deleted lists have been walked", false);
        }

        // then compare partial export to full
        modifiedFiles = preset.modifiedFiles();
        newFiles = preset.newFiles();
        deletedFiles = preset.deletedFiles();
        
        Files.walkFileTree(exportDirPartial, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(exportDirPartial, exportDirFull, 
                        exportDirNewFull, modifiedFiles, newFiles, deletedFiles, false));
        
        if (modifiedFiles.size() != 0 || newFiles.size() != 0){
            Assert.assertTrue("Not all objects in modified/new lists have been walked", false);
        }
    }

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    private static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.deleteIfExists(f.toPath());
    }
}

/**
 * Helper class that returns list of "user-selected" TreeElements and lists of
 * relative filenames of objects that should have been affected by partial export
 */
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
    public LinkedList<String> newFiles(){
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
        schema.getChild("table1").getChild("chk_table1").setSelected(true);
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/table1.sql"));
    }
}

class PartialExportInfoImpl_2 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("rep2_statistics").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/rep2_statistics.sql"));
    }
}

class PartialExportInfoImpl_3 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("tz_worker_group").getChild("trd_tz_worker_group")
                .setSelected(true);
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/tz_worker_group.sql"));
    }
}

class PartialExportInfoImpl_4 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("autocategorydel(integer)").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/autocategorydel.sql"));
    }
}

class PartialExportInfoImpl_5 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("atsqueuedel(integer, integer, integer)").setSelected(true);
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/atsqueuedel.sql"));
    }
}

class PartialExportInfoImpl_6 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("rep2_workpool_data").setSelected(true);
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/rep2_workpool_data.sql"));
    }
}

class PartialExportInfoImpl_7 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("automarkdel_new(integer)").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new.sql"));
    }
}

class PartialExportInfoImpl_8 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("automarkdel_new_new(integer)").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new_new.sql"));
    }
}

class PartialExportInfoImpl_9 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("automarkdel_new_new(integer)").setSelected(true);
        schema.getChild("automarkdel_new_new(integer, integer)").setSelected(true); 
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new_new.sql"));
    }
}

class PartialExportInfoImpl_10 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("v_auto_mark_two").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/VIEW/v_auto_mark_two.sql"));
    }
}

class PartialExportInfoImpl_11 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("t_auto_mark").getChild("chk_t_auto_mark").setSelected(true);
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t_auto_mark.sql"));
    }
}

class PartialExportInfoImpl_12 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("newschema").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/newschema.sql"));
    }
}

class PartialExportInfoImpl_13 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("audit");
        schema.getChild("logged_actions").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql"));
    }
}

class PartialExportInfoImpl_14 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("audit");
        schema.getChild("logged_actions").setSelected(true);
        schema.getChild("tz_audit_201305").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql", "SCHEMA/audit/TABLE/tz_audit_201305.sql"));
    }
}

class PartialExportInfoImpl_15 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("audit").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql", "SCHEMA/audit/TABLE/tz_audit_201305.sql", "SCHEMA/audit.sql"));
    }
}