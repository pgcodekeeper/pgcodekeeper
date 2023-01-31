package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

public class DifferTest {

    private static boolean defaultCheckBodies;

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new DifferData1(), 1),
                Arguments.of(new DifferData2(), 2),
                Arguments.of(new DifferData3(), 3),
                Arguments.of(new DifferData4(), 4),
                Arguments.of(new DifferData5(), 5));
    }

    @BeforeAll
    public static void beforeClass() {
        IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
        defaultCheckBodies = prefs.getDefaultBoolean(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES);
        prefs.setValue(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, true);
    }

    @AfterAll
    public static void afterClass() {
        IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
        prefs.setValue(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, defaultCheckBodies);
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void testDiffer(DifferData differData, int caseNumber) throws Exception {
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
            Assertions.fail("Expected to throw an exception");
        } catch(IllegalStateException e) {
            // expected behavior
        }
        Job job = differ.getDifferJob();

        job.schedule();
        job.join();

        differ.getDiffDirect();
        assertEquals(differ.getDiffDirect(),
                TestUtils.inputStreamToString(DifferTest.class.getResourceAsStream(
                        caseNumber + "_direct_diff.sql")), "Direct script differs");
        assertEquals(differ.getDiffReverse(),
                TestUtils.inputStreamToString(DifferTest.class.getResourceAsStream(
                        caseNumber + "_reverse_diff.sql")), "Reverse script differs");
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

