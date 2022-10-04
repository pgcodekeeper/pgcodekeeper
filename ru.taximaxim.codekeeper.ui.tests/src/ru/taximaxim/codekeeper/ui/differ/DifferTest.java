package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.exporter.PartialExporterTest;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;

@RunWith(value = Parameterized.class)
public class DifferTest {

    private static boolean defaultCheckBodies;

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
            { new DifferData1(), 1 },
            { new DifferData2(), 2 },
            { new DifferData3(), 3 },
            { new DifferData4(), 4 },
            { new DifferData5(), 5 },
        });
    }

    @BeforeClass
    public static void beforeClass() {
        IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
        defaultCheckBodies = prefs.getDefaultBoolean(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES);
        prefs.setValue(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, true);
    }

    @AfterClass
    public static void afterClass() {
        IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
        prefs.setValue(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, defaultCheckBodies);
    }

    private final DifferData differData;
    private final int caseNumber;

    public DifferTest(DifferData differData, int caseNumber) {
        this.differData = differData;
        this.caseNumber = caseNumber;
    }

    @Test
    public void testDiffer() throws URISyntaxException,
    IOException, InvocationTargetException, InterruptedException{
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";

        Path sourceFile = Utils.getFileFromOsgiRes(PartialExporterTest.class.getResource(sourceFilename));
        Path targetFile = Utils.getFileFromOsgiRes(PartialExporterTest.class.getResource(targetFilename));

        DbSource dbSource = DbSource.fromFile(true, sourceFile, Consts.UTF_8, false, null);
        DbSource dbTarget = DbSource.fromFile(true, targetFile, Consts.UTF_8, false, null);

        final TreeDiffer newDiffer = new TreeDiffer(dbSource, dbTarget);

        newDiffer.run(new NullProgressMonitor());

        TreeElement root = newDiffer.getDiffTree();

        // filtered input
        differData.setUserSelection(root);

        Differ differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                root, true, Consts.UTC, false, null);
        differ.setAdditionalDepciesSource(differData.getAdditionalDepciesSource(dbSource.getDbObject()));
        differ.setAdditionalDepciesTarget(differData.getAdditionalDepciesTarget(dbTarget.getDbObject()));

        try{
            differ.getDiffDirect();
            Assert.fail("Expected to throw an exception");
        } catch(IllegalStateException e) {
            // expected behavior
        }
        Job job = differ.getDifferJob();

        job.schedule();
        job.join();

        differ.getDiffDirect();
        assertEquals("Direct script differs", differ.getDiffDirect(),
                TestUtils.inputStreamToString(DifferTest.class.getResourceAsStream(
                        caseNumber + "_direct_diff.sql")));
        assertEquals("Reverse script differs", differ.getDiffReverse(),
                TestUtils.inputStreamToString(DifferTest.class.getResourceAsStream(
                        caseNumber + "_reverse_diff.sql")));
    }
}

interface DifferData {
    void setUserSelection(TreeElement root);

    default List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        return new ArrayList<>();
    }

    default List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        return new ArrayList<>();
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet)
 */
class DifferData1 implements DifferData {

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t4").getChild("t4_c2_key").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>table (with no impact)
 */
class DifferData2 implements DifferData {

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        AbstractTable t = source.getSchema(Consts.PUBLIC).getTable("t1");
        AbstractSequence s = source.getSchema(Consts.PUBLIC).getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (s, t);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>column
 */
class DifferData3 implements DifferData {

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        AbstractColumn c = source.getSchema(Consts.PUBLIC).getTable("t1").getColumn("c1");
        AbstractSequence s = source.getSchema(Consts.PUBLIC).getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (s, c);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 NEW table selected.
 */
class DifferData4 implements DifferData {

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild("test").getChild("test_table").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 DELETE view selected.
 * Adds to target depcy: view>new schema
 */
class DifferData5 implements DifferData {

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("v1").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        AbstractSchema s = target.getSchema("newschema");
        AbstractView v = target.getSchema(Consts.PUBLIC).getView("v1");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (v, s);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }
}

