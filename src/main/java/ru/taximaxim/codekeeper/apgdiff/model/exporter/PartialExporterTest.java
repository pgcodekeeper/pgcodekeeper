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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTreeApplier;
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
    private static TreeElement diffTree;
    
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
        new PartialExportInfoImpl_1(diffTree),
        new PartialExportInfoImpl_2(diffTree),
        new PartialExportInfoImpl_3(diffTree),
        new PartialExportInfoImpl_4(diffTree),
        new PartialExportInfoImpl_5(diffTree),
        new PartialExportInfoImpl_6(diffTree),
        new PartialExportInfoImpl_7(diffTree),
        new PartialExportInfoImpl_8(diffTree),
        new PartialExportInfoImpl_9(diffTree),
        new PartialExportInfoImpl_10(diffTree),
        new PartialExportInfoImpl_11(diffTree),
        new PartialExportInfoImpl_12(diffTree),
        new PartialExportInfoImpl_13(diffTree),
        new PartialExportInfoImpl_14(diffTree),
        new PartialExportInfoImpl_15(diffTree)
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
        
        diffTree = DiffTree.create(dbSource, dbTarget);
    }
    
    @Test
    public void testExportPartial () throws IOException{
        PartialExportInfo preset = EXPORT_PRESETS[index-1];
        
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
            Set<TreeElement> selected = new HashSet<>(preset.getSelectedList());
            DiffTreeApplier applier = new DiffTreeApplier(dbSource, dbTarget, diffTree.getFilteredCopy(selected));
            PgDatabase dbNew = applier.apply();
            
            // full export of source to target directory
            new ModelExporter(exportDirPartial.toFile(), dbSource, encoding).exportFull();
            // full export of new to newFull directory
            new ModelExporter(exportDirNewFull.toFile(), dbNew, encoding).exportFull();
            
            new ModelExporter(exportDirPartial.toFile(), dbNew, dbSource, preset.getSelectedList(), encoding).exportPartial();
            
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
    
    public abstract List<TreeElement> getSelectedList();
    
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

    public PartialExportInfoImpl_1(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Different").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Tables").getChild("table1").getChild("Constraints").getChild("chk_table1"));
        return selected;
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/table1.sql"));
    }
}

class PartialExportInfoImpl_2 extends PartialExportInfo{

    public PartialExportInfoImpl_2(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Tables").getChild("rep2_statistics"));
        return selected;
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/rep2_statistics.sql"));
    }
}

class PartialExportInfoImpl_3 extends PartialExportInfo{

    public PartialExportInfoImpl_3(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Tables").getChild("tz_worker_group").getChild("Triggers").getChild("trd_tz_worker_group"));
        return selected;
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/tz_worker_group.sql"));
    }
}

class PartialExportInfoImpl_4 extends PartialExportInfo{

    public PartialExportInfoImpl_4(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Functions").getChild("autocategorydel(integer)"));
        return selected;
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/autocategorydel.sql"));
    }
}

class PartialExportInfoImpl_5 extends PartialExportInfo{

    public PartialExportInfoImpl_5(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Functions").getChild("atsqueuedel(integer, integer, integer)"));
        return selected;
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/atsqueuedel.sql"));
    }
}

class PartialExportInfoImpl_6 extends PartialExportInfo{

    public PartialExportInfoImpl_6(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Different").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Tables").getChild("rep2_workpool_data"));
        return selected;
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/rep2_workpool_data.sql"));
    }
}

class PartialExportInfoImpl_7 extends PartialExportInfo{

    public PartialExportInfoImpl_7(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Functions").getChild("automarkdel_new(integer)"));
        return selected;
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new.sql"));
    }
}

class PartialExportInfoImpl_8 extends PartialExportInfo{

    public PartialExportInfoImpl_8(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Functions").getChild("automarkdel_new_new(integer)"));
        return selected;
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new_new.sql"));
    }
}

class PartialExportInfoImpl_9 extends PartialExportInfo{

    public PartialExportInfoImpl_9(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Functions").getChild("automarkdel_new_new(integer)"));
        selected.add(schema.getChild("Functions").getChild("automarkdel_new_new(integer, integer)"));
        return selected;
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/automarkdel_new_new.sql"));
    }
}

class PartialExportInfoImpl_10 extends PartialExportInfo{

    public PartialExportInfoImpl_10(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Views").getChild("v_auto_mark_two"));
        return selected;
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/VIEW/v_auto_mark_two.sql"));
    }
}

class PartialExportInfoImpl_11 extends PartialExportInfo{

    public PartialExportInfoImpl_11(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selected.add(schema.getChild("Tables").getChild("t_auto_mark").getChild("Constraints").getChild("chk_t_auto_mark"));
        return selected;
    }

    @Override
    public LinkedList<String> modifiedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t_auto_mark.sql"));
    }
}

class PartialExportInfoImpl_12 extends PartialExportInfo{

    public PartialExportInfoImpl_12(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Target only").getChild("Schemas").getChild("newschema");
        selected.add(schema);
        return selected;
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/newschema.sql"));
    }
}

class PartialExportInfoImpl_13 extends PartialExportInfo{

    public PartialExportInfoImpl_13(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("audit");
        selected.add(schema.getChild("Tables").getChild("logged_actions"));
        return selected;
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql"));
    }
}

class PartialExportInfoImpl_14 extends PartialExportInfo{

    public PartialExportInfoImpl_14(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("audit");
        selected.add(schema.getChild("Tables").getChild("logged_actions"));
        selected.add(schema.getChild("Tables").getChild("tz_audit_201305"));
        return selected;
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql", "SCHEMA/audit/TABLE/tz_audit_201305.sql"));
    }
}

class PartialExportInfoImpl_15 extends PartialExportInfo{

    public PartialExportInfoImpl_15(TreeElement diffTree) {
        this.diffTree = diffTree;
    }

    @Override
    public List<TreeElement> getSelectedList() {
        List<TreeElement> selected = new ArrayList<>();
        TreeElement schema = diffTree.getChild("Database").getChild("Source only").getChild("Schemas").getChild("audit");
        selected.add(schema);
        return selected;
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/audit/TABLE/logged_actions.sql", "SCHEMA/audit/TABLE/tz_audit_201305.sql", "SCHEMA/audit.sql"));
    }
}