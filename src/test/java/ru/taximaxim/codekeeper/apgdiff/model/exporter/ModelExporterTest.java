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
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

@RunWith(value = Parameterized.class)
public class ModelExporterTest {
    private static final String encoding = ApgdiffConsts.UTF_8;
    private final int index;
    
    private static PgDatabase dbSource;
    private static PgDatabase dbTarget;
    private static TreeElement diffTree;
    
    /*
     * ------------------------------------------------------------------------
     * Data set up
     */
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][]{{1}/*,{2},{3},{4}*/});
    }
    
    /**
     * Array of implementations of {@link PartialExportInfo}
     */
    private PartialExportInfo[] EXPORT_PRESETS = {
        new PartialExportInfoImpl1(diffTree)
    };
    /*
     * ------------------------------------------------------------------------
     */
    
    public ModelExporterTest(int index) {
        this.index = index;
    }
    
    @BeforeClass
    public static void initDiff() {
        String sourceFilename = "TestPartialExportSource1.sql";
        String targetFilename = "TestPartialExportTarget1.sql";
        dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                ModelExporterTest.class.getResourceAsStream(sourceFilename),
                encoding, false, false);
        dbTarget = PgDumpLoader.loadDatabaseSchemaFromDump(
                ModelExporterTest.class.getResourceAsStream(targetFilename),
                encoding, false, false);
        
        Assert.assertNotNull(dbSource);
        Assert.assertNotNull(dbTarget);
        
        diffTree = DiffTree.create(dbSource, dbTarget);
    }
    
    @Test
    public void test1 () throws IOException{
        System.err.println("Running test with index " + index);
        
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
            Set<TreeElement> selected = new HashSet<TreeElement>(preset.getSelectedList());
            DiffTreeApplier applier = new DiffTreeApplier(dbSource, dbTarget, diffTree.getFilteredCopy(selected));
            PgDatabase dbNew = applier.apply();
            
            // full export of source to target directory
            new ModelExporter(exportDirPartial.toFile(), dbSource, encoding).exportFull();
            // full export of new to newFull directory
            new ModelExporter(exportDirNewFull.toFile(), dbNew, encoding).exportFull();
            
            new ModelExporter(exportDirPartial.toFile(), dbNew, dbTarget, preset.getSelectedList(), encoding).exportPartial();;
            
            walkAndComare(exportDirFull, exportDirPartial, exportDirNewFull, preset.modifiedFiles(), preset.newFiles(), preset.deletedFiles());
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
        
        Assert.assertNotEquals(0, index);
    }
    
    private void walkAndComare(Path exportDirFull, Path exportDirPartial, Path exportDirNewFull,
            List<String> modifiedFiles, List<String> newFiles, List<String> deletedFiles) throws IOException {
        Files.walkFileTree(exportDirFull, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(exportDirFull, exportDirPartial, exportDirNewFull, modifiedFiles, newFiles, deletedFiles, true));

        Files.walkFileTree(exportDirPartial, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(exportDirPartial, exportDirFull, exportDirNewFull, modifiedFiles, newFiles, deletedFiles, false));
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

abstract class PartialExportInfo {
    
    TreeElement diffTree;
    public abstract List<TreeElement> getSelectedList();
    
    public abstract List<String> modifiedFiles();
    public abstract List<String> newFiles();
    public abstract List<String> deletedFiles();
}

class PartialExportInfoImpl1 extends PartialExportInfo{

    public PartialExportInfoImpl1(TreeElement diffTree) {
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
    public List<String> modifiedFiles() {
        return Arrays.asList("SCHEMA/public/TABLE/table1.sql");
    }

    @Override
    public List<String> newFiles() {
        return new ArrayList<>(0);
    }

    @Override
    public List<String> deletedFiles() {
        return new ArrayList<>(0);
    }
}