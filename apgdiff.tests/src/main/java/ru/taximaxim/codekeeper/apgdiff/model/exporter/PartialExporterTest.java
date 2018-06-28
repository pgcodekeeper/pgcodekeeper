package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;

/**
 * Test for partial export
 *
 * <!--
 * Below is the list of differences between DBs in TestPartialExportSource.sql
 * and TestPartialExportTarget.sql:
 *
 * DELETED (exist in Source only):
 *      (TABLE)         public.t2
 *      (TRIGGER)       public.t2.t2_trigger
 *      (INDEX)         public.t2.t2_c5_idx
 *      (CONSTRAINT)    public.t2.constr_t2
 *
 *      (SEQUENCE)      public.t2_c1_seq
 *
 *      (FUNCTION)      public.proc(integer)
 *      (FUNCTION)      public.proc(integer, timestamp without time zone)
 *
 *      (FUNCTION)      public.fun2()
 *
 *      (SCHEMA)        test
 *      (TABLE)         test.test_table
 *      (INDEX)         test.test_table.test_table_c1_idx
 *      (INDEX)         test.test_table.test_table_c2_idx
 *      (CONSTRAINT)    test.test_table.contr_testtable_c5
 *      (TABLE)         test.test_table_2
 *
 * MODIFIED:
 *      (TABLE)         public.rep2_workpool_data
 *      (TABLE)         public.table1
 *      (INDEX)         public.table1.idx_table1
 *      (CONSTRAINT)    public.table1.chk_table1 (GROUP: table1 changed as well)
 *      (TABLE)         public.t_auto_mark
 *      (TABLE)         public.t1
 *      (CONSTRAINT)    public.t1.t1_c2_key
 *      (TRIGGER)       public.t1.t1_trigger
 *      (TABLE)         public.t3
 *      (TABLE)         public.t4
 *      (CONSTRAINT)    public.t4.t4_c2_key
 *      (TABLE)         public.t5
 *      (INDEX)         public.t5.t5_c1_idx
 *      (FUNCTION)      public.fun1()
 *
 * NEW (exist in Target only):
 *      (FUNCTION)      public.fun3()
 *      (FUNCTION)      public.fun3(integer)
 *      (SCHEMA)        newschema
 *      (CONSTRAINT)    public.t3.constr_t3
 *      (TRIGGER)       public.t3.t3_trigger
 *      (VIEW)          public.v1
 *  -->
 *
 * @author ryabinin_av
 */

@RunWith(value = Parameterized.class)
public class PartialExporterTest {

    static final String UTF_8 = ApgdiffConsts.UTF_8;
    private final int index;

    private static PgDatabase dbSource;
    private static PgDatabase dbTarget;

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][]{
            // SONAR-OFF
            {1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15},
            {16},{17},{18},{19},{20}
            // SONAR-ON
        });
    }

    private static final PartialExportInfo[] EXPORT_PRESETS = {
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
            new PartialExportInfoImpl_15(),
            new PartialExportInfoImpl_16(),
            new PartialExportInfoImpl_17(),
            new PartialExportInfoImpl_18(),
            new PartialExportInfoImpl_19(),
            new PartialExportInfoImpl_20()
    };

    public PartialExporterTest(int index) {
        this.index = index;
    }

    @BeforeClass
    public static void initDiffTree() throws InterruptedException, IOException {
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(UTF_8);
        dbSource = ApgdiffTestUtils.loadTestDump(
                sourceFilename, PartialExporterTest.class, args);
        args = new PgDiffArguments();
        args.setInCharsetName(UTF_8);
        dbTarget = ApgdiffTestUtils.loadTestDump(
                targetFilename, PartialExporterTest.class, args);

        Assert.assertNotNull(dbSource);
        Assert.assertNotNull(dbTarget);
    }

    @Before
    public void beforeTest() throws InterruptedException {
        EXPORT_PRESETS[index-1].setDiffTree(DiffTree.create(dbSource, dbTarget, null));
    }

    @Test
    public void testExportPartial() throws IOException, PgCodekeeperException {
        PartialExportInfo preset = EXPORT_PRESETS[index-1];

        Path exportDirFull = null;
        Path exportDirPartial = null;
        try{
            exportDirFull = Files.createTempDirectory("pgCodekeeper-test-export-full");
            exportDirPartial = Files.createTempDirectory("pgCodekeeper-test-export-partial");

            // full export of source
            new ModelExporter(exportDirFull.toFile(), dbSource, UTF_8).exportFull();
            // full export of source to target directory
            new ModelExporter(exportDirPartial.toFile(), dbSource, UTF_8).exportFull();

            // get new db with selected changes
            preset.setUserSelection();
            Collection<TreeElement> list = new TreeFlattener()
                    .onlySelected()
                    .onlyEdits(dbSource, dbTarget)
                    .flatten(preset.getDiffTree());
            // накатываем на полную базу частичные изменения
            new ModelExporter(exportDirPartial.toFile(), dbTarget, dbSource,
                    list, UTF_8).exportPartial();

            walkAndComare(exportDirFull, exportDirPartial, preset);
        }finally{
            if (exportDirFull != null){
                deleteRecursive(exportDirFull.toFile());
            }
            if (exportDirPartial != null){
                deleteRecursive(exportDirPartial.toFile());
            }
        }
    }

    private void walkAndComare(Path exportDirFull, Path exportDirPartial, PartialExportInfo preset) throws IOException {
        // first compare full export to partial
        Map<String, String> modifiedFiles = preset.modifiedFiles();
        LinkedList<String> newFiles = preset.newFiles();
        LinkedList<String> deletedFiles = preset.deletedFiles();
        Files.walkFileTree(exportDirFull, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(
                        exportDirFull, exportDirPartial,
                        modifiedFiles, newFiles, deletedFiles, true));

        Assert.assertTrue("Not all objects in modified/deleted lists have been walked:\n"
                + modifiedFiles + '\n' + deletedFiles,
                modifiedFiles.isEmpty() && deletedFiles.isEmpty());

        // then compare partial export to full
        modifiedFiles = preset.modifiedFiles();
        newFiles = preset.newFiles();
        deletedFiles = preset.deletedFiles();

        Files.walkFileTree(exportDirPartial, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(
                        exportDirPartial, exportDirFull,
                        modifiedFiles, newFiles, deletedFiles, false));

        Assert.assertTrue("Not all objects in modified/new lists have been walked:\n"
                + modifiedFiles + '\n' + newFiles,
                modifiedFiles.isEmpty() && newFiles.isEmpty());
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

    public Map<String, String> modifiedFiles(){
        return new HashMap<>();
    };
    public LinkedList<String> newFiles(){
        return new LinkedList<>();
    };
    public LinkedList<String> deletedFiles(){
        return new LinkedList<>();
    };
}

/**
 * Select modified constraint
 */
class PartialExportInfoImpl_1 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t4").getChild("t4_c2_key").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t4.sql", "106afb720883502cfec4ba9db5da8289");
        return m;
    }
}

/**
 * Select deleted table with constraint
 */
class PartialExportInfoImpl_2 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.setSelected(true);
        table.getChild("constr_t2").setSelected(true);

    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t2.sql"));
    }
}

/**
 * Select modified trigger
 */
class PartialExportInfoImpl_3 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t2").getChild("t2_trigger").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "46255b7358a9dff55b672275d3840285");
        return m;
    }
}

/**
 * Select deleted function
 */
class PartialExportInfoImpl_4 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("fun2()").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun2.sql"));
    }
}

/**
 * Select modified function
 */
class PartialExportInfoImpl_5 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("fun1()").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/FUNCTION/fun1.sql", "a2a5c040544ebf26c6aacadcebe938f9");
        return m;
    }
}

/**
 * Select modified table
 */
class PartialExportInfoImpl_6 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t5").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t5.sql", "96bbbc209be7a2f2075513faaac10f4e");
        return m;
    }
}

/**
 * Select new function
 */
class PartialExportInfoImpl_7 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("fun3()").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun3.sql"));
    }
}

/**
 * Select new function group
 */
class PartialExportInfoImpl_8 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("fun3()").setSelected(true);
        schema.getChild("fun3(integer)").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun3.sql"));
    }
}

/**
 * Select new view
 */
class PartialExportInfoImpl_9 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("v1").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/VIEW/v1.sql"));
    }
}

/**
 * Select new constraint in modified table
 */
class PartialExportInfoImpl_10 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t3").getChild("constr_t3").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t3.sql", "13b6c5a48316d7371be416723027aadf");
        return m;
    }
}


/**
 * Select new schema
 */
class PartialExportInfoImpl_11 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("newschema").setSelected(true);
    }

    @Override
    public LinkedList<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/newschema.sql"));
    }
}

/**
 * Select deleted table in another schema
 */
class PartialExportInfoImpl_12 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("test").getChild("test_table").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql"));
    }
}

/**
 * Select 2 deleted table
 */
class PartialExportInfoImpl_13 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("test");
        schema.getChild("test_table").setSelected(true);
        schema.getChild("test_table_2").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql", "SCHEMA/test/TABLE/test_table_2.sql"));
    }
}

/**
 * Select deleted schema
 */
class PartialExportInfoImpl_14 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("test").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql", "SCHEMA/test/TABLE/test_table_2.sql", "SCHEMA/test.sql"));
    }
}

/**
 * Select deleted function group
 */
class PartialExportInfoImpl_15 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("proc(integer)").setSelected(true);
        schema.getChild("proc(integer, timestamp without time zone)").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/proc.sql"));
    }
}

/**
 * Select deleted index
 */
class PartialExportInfoImpl_16 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t2").getChild("t2_c5_idx").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "db4dbe900e6338850a2957a9d61ef253");
        return m;
    }
}

/**
 * Select deleted constraint
 */
class PartialExportInfoImpl_17 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t2").getChild("constr_t2").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "e5fc35e43a007612b1305d65ccbeabd8");
        return m;
    }
}

/**
 * Select deleted constraint and trigger from 1 table
 */
class PartialExportInfoImpl_18 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.getChild("constr_t2").setSelected(true);
        table.getChild("t2_trigger").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "8c3e5f36294f98ff4c2b147061d33689");
        return m;
    }
}

/**
 * Select deleted constraint, index and trigger from 1 table
 */
class PartialExportInfoImpl_19 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.getChild("constr_t2").setSelected(true);
        table.getChild("t2_trigger").setSelected(true);
        table.getChild("t2_c5_idx").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "3785a71f4f8f286b41e3751046934f38");
        return m;
    }
}

/**
 * Select deleted table with constraint, index and trigger
 */

class PartialExportInfoImpl_20 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        diffTree.getChild("public").getChild("t2").setSelected(true);
    }

    @Override
    public LinkedList<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t2.sql"));
    }
}