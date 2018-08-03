package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.PartialExporterTest;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;

@RunWith(value = Parameterized.class)
public class DifferTest {

    private static boolean defaultCheckBodies;
    private final DifferData differData;

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    {1},
                    {2},
                    {3},
                    {4},
                    {5}
                });
    }

    private static final DifferData[] DB_OBJS = {
            new DifferData_1(), new DifferData_2(), new DifferData_3(), new DifferData_4(), new DifferData_5()
    };

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

    public DifferTest(int param) {
        this.differData = DB_OBJS[param - 1];
        differData.setCaseNumber(param);
    }

    @Test
    public void testDiffer() throws URISyntaxException,
    IOException, InvocationTargetException, InterruptedException{
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";

        File sourceFile = ApgdiffUtils.getFileFromOsgiRes(PartialExporterTest.class.getResource(sourceFilename));
        File targetFile = ApgdiffUtils.getFileFromOsgiRes(PartialExporterTest.class.getResource(targetFilename));

        DbSource dbSource = DbSource.fromFile(true, sourceFile, ApgdiffConsts.UTF_8);
        DbSource dbTarget = DbSource.fromFile(true, targetFile, ApgdiffConsts.UTF_8);

        final TreeDiffer newDiffer = new ClassicTreeDiffer(dbSource, dbTarget, false);

        newDiffer.run(new NullProgressMonitor());

        TreeElement root = newDiffer.getDiffTree();

        // filtered input
        differData.setUserSelection(root);

        Differ differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                root, true, ApgdiffConsts.UTC);
        differ.setAdditionalDepciesSource(differData.getAdditionalDepciesSource(dbSource.getDbObject()));
        differ.setAdditionalDepciesTarget(differData.getAdditionalDepciesTarget(dbTarget.getDbObject()));

        try{
            differ.getScript();
            Assert.fail("Expected to throw an exception");
        }catch(IllegalStateException e){
            // expected behavior
        }
        Job job = differ.getDifferJob();

        job.schedule();
        job.join();

        differ.getScript();
        assertEquals("Direct script differs",
                differData.getPredefinedDirectDiff(), differ.getDiffDirect());
        assertEquals("Reverse script differs",
                differData.getPredefinedReverseDiff(), differ.getDiffReverse());
    }
}

abstract class DifferData{
    int caseNumber = -1;

    abstract void setUserSelection(TreeElement root);

    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source){
        return new ArrayList<>();
    }

    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target){
        return new ArrayList<>();
    }

    final void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    final String getPredefinedDirectDiff() throws IOException {
        return readResourceToString(DifferTest.class.getResourceAsStream(caseNumber + "_direct_diff.sql"));
    }

    final String getPredefinedReverseDiff() throws IOException {
        return readResourceToString(DifferTest.class.getResourceAsStream(caseNumber + "_reverse_diff.sql"));
    }

    private final String readResourceToString(InputStream resourceStream)
            throws IOException {
        StringBuilder script = new StringBuilder();
        try(InputStreamReader isr = new InputStreamReader(resourceStream, "UTF-8");
                BufferedReader reader = new BufferedReader(isr)) {

            String line = reader.readLine();
            while(line != null) {
                script.append(line);
                line = reader.readLine();
                script.append(line == null ? "" : '\n');
            }
        }
        return script.toString();
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet)
 */
class DifferData_1 extends DifferData{

    @Override
    void setUserSelection(TreeElement root) {
        root.getChild("public").getChild("t4").getChild("t4_c2_key").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>table (with no impact)
 */
class DifferData_2 extends DifferData{

    @Override
    void setUserSelection(TreeElement root) {
        root.getChild("public").getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        PgTable t = source.getSchema("public").getTable("t1");
        AbstractSequence s = source.getSchema("public").getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (s, t);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>column
 */
class DifferData_3 extends DifferData{

    @Override
    void setUserSelection(TreeElement root) {
        root.getChild("public").getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        AbstractColumn c = source.getSchema("public").getTable("t1").getColumn("c1");
        AbstractSequence s = source.getSchema("public").getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (s, c);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 NEW table selected.
 */
class DifferData_4 extends DifferData{

    @Override
    void setUserSelection(TreeElement root) {
        root.getChild("test").getChild("test_table").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 DELETE view selected.
 * Adds to target depcy: view>new schema
 */
class DifferData_5 extends DifferData{

    @Override
    void setUserSelection(TreeElement root) {
        root.getChild("public").getChild("v1").setSelected(true);
    }

    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        AbstractSchema s = target.getSchema("newschema");
        AbstractView v = target.getSchema("public").getView("v1");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<> (v, s);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }
}

