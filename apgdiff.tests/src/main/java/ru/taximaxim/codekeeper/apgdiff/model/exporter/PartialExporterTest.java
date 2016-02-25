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
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Test for partial export
 *
 * <!--
 * Below is the list of differences between DBs in TestPartialExportSource.sql
 * and TestPartialExportTarget.sql:
 *
 * DELETED (exist in Source only):
 *      (TABLE)         public.rep2_statistics
 *      (CONSTRAINT)    public.rep2_statistics.rep2_statistics_pkey
 *      (SEQUENCE)      public.rep2_statistics_id_statistics_seq
 *
 *      (CONSTRAINT)    public.rep2_workpool_data.pk_rep2_workpool_data
 *
 *      (TRIGGER)       public.tz_worker_group.trd_tz_worker_group (GROUP: table stays)
 *
 *      (FUNCTION)      public.autocategorydel(integer)
 *      (FUNCTION)      public.atsqueuedel(integer, integer, integer) (GROUP: 2 same named funcs left)
 *
 *      (FUNCTION)      public.test(integer)
 *      (FUNCTION)      public.test()
 *
 *      (TABLE)         public.test_table
 *      (INDEX)         public.test_table.idx_test_table_id
 *      (TRIGGER)       public.test_table.tri_test_table
 *      (CONSTRAINT)    public.test_table.constr_test
 *
 *      (SCHEMA)        audit
 *      (TABLE)         audit.logged_actions
 *      (INDEX)         audit.logged_actions.logged_actions_action_idx
 *      (INDEX)         audit.logged_actions.logged_actions_action_tstamp_idx
 *      (INDEX)         audit.logged_actions.logged_actions_schema_table_idx
 *      (CONSTRAINT)    audit.logged_actions.logged_actions_action_check
 *      (TABLE)         audit.tz_audit_201305
 *      (INDEX)         audit.tz_audit_201305.ix_tz_audit_201305_c_date
 *      (INDEX)         audit.tz_audit_201305.ix_tz_audit_201305_id
 *      (INDEX)         audit.tz_audit_201305.ix_tz_audit_201305_id_obj
 *      (CONSTRAINT)    audit.tz_audit_201305.chk_jdbc_noset
 *      (CONSTRAINT)    audit.tz_audit_201305.chk_tz_audit_201305
 *      (CONSTRAINT)    audit.tz_audit_201305.tz_audit_201305_pkey
 *
 * MODIFIED:
 *      (TABLE)         public.rep2_workpool_data
 *      (TABLE)         public.table1
 *      (INDEX)         public.table1.idx_table1
 *      (CONSTRAINT)    public.table1.chk_table1 (GROUP: table1 changed as well)
 *      (TABLE)         public.t_auto_mark
 *      (TABLE)         public.tz_worker_group
 *
 * NEW (exist in Target only):
 *      (FUNCTION)      public.automarkdel_new(integer)
 *      (FUNCTION)      public.automarkdel_new_new(integer) (GROUP: 2 new funcs)
 *      (SCHEMA)        newschema
 *      (CONSTRAINT)    public.t_auto_mark.chk_t_auto_mark (GROUP: table exists)
 *      (VIEW)          public.v_auto_mark_two
 *      (FUNCTION)      public.automarkdel_new_new(integer, integer) (GROUP: 2 new funcs)
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
            {16},{17},{18},{19},{20},{21},{22}
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
            new PartialExportInfoImpl_20(),
            new PartialExportInfoImpl_21(),
            new PartialExportInfoImpl_22()
    };

    public PartialExporterTest(int index) {
        this.index = index;
    }

    @BeforeClass
    public static void initDiffTree() throws InterruptedException, IOException, LicenseException {
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";
        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(UTF_8);
        dbSource = ApgdiffTestUtils.loadTestDump(
                sourceFilename, PartialExporterTest.class, args);
        args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(UTF_8);
        dbTarget = ApgdiffTestUtils.loadTestDump(
                targetFilename, PartialExporterTest.class, args);

        Assert.assertNotNull(dbSource);
        Assert.assertNotNull(dbTarget);
    }

    @Before
    public void beforeTest() {
        EXPORT_PRESETS[index-1].setDiffTree(DiffTree.create(dbSource, dbTarget));
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
            Collection<TreeElement> list = preset.getDiffTree().flattenAlteredElements(
                    new ArrayList<TreeElement>(), dbSource, dbTarget, true, null);
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

class PartialExportInfoImpl_1 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("table1").getChild("chk_table1").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/table1.sql", "48c9e72c3232a045e4e318c0f8758c2e");
        return m;
    }
}

class PartialExportInfoImpl_2 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement table = diffTree.getChild("public").getChild("rep2_statistics");
        table.setSelected(true);
        table.getChild("rep2_statistics_pkey").setSelected(true);

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
        schema.getChild("tz_worker_group").getChild("trd_tz_worker_group").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/tz_worker_group.sql", "c771b2398f8dd96aafacbda3f2440dcb");
        return m;
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
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/FUNCTION/atsqueuedel.sql", "e7997c7da7a4ca598dbbc7c819577918");
        return m;
    }
}

class PartialExportInfoImpl_6 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("rep2_workpool_data").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/rep2_workpool_data.sql", "26b549a466c739138d7a9b5c707017eb");
        return m;
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
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t_auto_mark.sql", "057e390cbc38830bc600ecf16b12e3d9");
        return m;
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


class PartialExportInfoImpl_16 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("test()").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/FUNCTION/test.sql", "8d11dce1fb9c245f283e5b58eaa4e1a6");
        return m;
    }
}

class PartialExportInfoImpl_17 extends PartialExportInfo{

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

class PartialExportInfoImpl_18 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("test_table").getChild("idx_test_table_id").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/test_table.sql", "61a6f6f9372e49abddd95ae033ce3134");
        return m;
    }
}

class PartialExportInfoImpl_19 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("test_table").getChild("constr_test").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/test_table.sql", "092c7e4c1c711c261ec0ffde587a7f1e");
        return m;
    }
}

class PartialExportInfoImpl_20 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("test_table").getChild("constr_test").setSelected(true);
        schema.getChild("test_table").getChild("tri_test_table").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/test_table.sql", "ba30379ce57af95cb8757e8b13e9339b");
        return m;
    }
}

class PartialExportInfoImpl_21 extends PartialExportInfo{

    @Override
    public void setUserSelection() {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("test_table").getChild("idx_test_table_id").setSelected(true);
        schema.getChild("test_table").getChild("constr_test").setSelected(true);
        schema.getChild("test_table").getChild("tri_test_table").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/test_table.sql", "6337578a5426a0e53aeda8fc84ac18c2");
        return m;
    }
}

class PartialExportInfoImpl_22 extends PartialExportInfo{

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