package ru.taximaxim.codekeeper.ui.differ;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.PartialExporterTest;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

@RunWith(value = Parameterized.class)
public class DifferTest {
    
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
    
    public DifferTest(int param) {
        this.differData = DB_OBJS[param - 1];
        differData.setCaseNumber(param);
    }
    
    @Test
    public void testDiffer() throws PgCodekeeperUIException, URISyntaxException, 
            IOException, InvocationTargetException{
        String sourceFilename = "exporter/TestPartialExportSource.sql";
        String targetFilename = "exporter/TestPartialExportTarget.sql";
        
        File sourceFile = ApgdiffTestUtils.getFileFromRes(PartialExporterTest.class.getResource(sourceFilename));
        File targetFile = ApgdiffTestUtils.getFileFromRes(PartialExporterTest.class.getResource(targetFilename));

        DbSource dbSource = 
                DbSource.fromFile(ParserClass.getLegacy(null, 1), sourceFile.getAbsolutePath(), UIConsts.UTF_8);
        DbSource dbTarget = 
                DbSource.fromFile(ParserClass.getLegacy(null, 1), targetFile.getAbsolutePath(), UIConsts.UTF_8);
        
        final TreeDiffer newDiffer = new TreeDiffer(dbSource, dbTarget);
        
        newDiffer.run(new NullProgressMonitor());
        
        TreeElement root = newDiffer.getDiffTree();
        
        // filtered input
        final TreeElement filtered = root.getFilteredCopy(differData.getUserSelection(root));

        final Differ differ = new Differ(
                DbSource.fromFilter(dbSource, filtered, DiffSide.LEFT),
                DbSource.fromFilter(dbTarget, filtered, DiffSide.RIGHT),
                true, UIConsts.UTC);
        differ.setFullDbs(dbSource.getDbObject(), dbTarget.getDbObject());
        
        differ.setAdditionalDepciesSource(differData.getAdditionalDepciesSource(dbSource.getDbObject()));
        differ.setAdditionalDepciesTarget(differData.getAdditionalDepciesTarget(dbTarget.getDbObject()));
        
        try{
            differ.getScript();
            Assert.fail("Expected to throw an exception");
        }catch(PgCodekeeperUIException e){
            // expected behavior
        }
        Job job = differ.getDifferJob();
        
        job.addJobChangeListener(new JobChangeAdapter() {
            
            @Override
            public void done(IJobChangeEvent event) {
                if (event.getResult().isOK()) {
                    try {
                        differ.getScript();
                        assertEquals("Direct script differs", 
                                differData.getPredefinedDirectDiff(), differ.getDiffDirect());
                        assertEquals("Reverse script differs", 
                                differData.getPredefinedReverseDiff(), differ.getDiffReverse());
                    } catch (PgCodekeeperUIException | IOException e) {
                        Assert.fail(e.getMessage());
                    }
                }
            }
        });

        job.schedule();
    }
}

abstract class DifferData{
    int caseNumber = -1;

    abstract Set<TreeElement> getUserSelection(TreeElement root);
    
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source){
        return new ArrayList<Entry<PgStatement,PgStatement>>();
    }
    
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target){
        return new ArrayList<Entry<PgStatement,PgStatement>>();
    }
    
    final void setCaseNumber(int caseNumber) {
       this.caseNumber = caseNumber;
    }

    final String getPredefinedDirectDiff() throws UnsupportedEncodingException, IOException{
        return readResourceToString(DifferTest.class.getResourceAsStream(caseNumber + "_direct_diff.sql"));
    }
    
    final String getPredefinedReverseDiff() throws UnsupportedEncodingException, IOException{
        return readResourceToString(DifferTest.class.getResourceAsStream(caseNumber + "_reverse_diff.sql"));
    }
    
    private final String readResourceToString(InputStream resourceStream) 
            throws UnsupportedEncodingException, IOException{
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
    Set<TreeElement> getUserSelection(TreeElement root) {
        Set<TreeElement> selection = new HashSet<>();
        TreeElement schema = root.getChild("Database").getChild("Different").getChild("Schemas").getChild("public");
        selection.add(schema.getChild("Tables").getChild("table1").getChild("Constraints").getChild("chk_table1"));
        return selection;
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>table (with no impact)
 */
class DifferData_2 extends DifferData{

    @Override
    Set<TreeElement> getUserSelection(TreeElement root) {
        Set<TreeElement> selection = new HashSet<>();
        TreeElement schema = root.getChild("Database").getChild("Different").getChild("Schemas").getChild("public");
        selection.add(schema.getChild("Tables").getChild("table1").getChild("Constraints").getChild("chk_table1"));
        return selection;
    }
    
    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        PgTable t = source.getSchema("public").getTable("table1");
        PgView v = source.getSchema("public").getView("v_auto_mark");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<PgStatement, PgStatement> (v, t);
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
    Set<TreeElement> getUserSelection(TreeElement root) {
        Set<TreeElement> selection = new HashSet<>();
        TreeElement schema = root.getChild("Database").getChild("Different").getChild("Schemas").getChild("public");
        selection.add(schema.getChild("Tables").getChild("table1").getChild("Constraints").getChild("chk_table1"));
        return selection;
    }
    
    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(PgDatabase source) {
        PgColumn c = source.getSchema("public").getTable("table1").getColumn("col2");
        PgView v = source.getSchema("public").getView("v_auto_mark");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<PgStatement, PgStatement> (v, c);
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
    Set<TreeElement> getUserSelection(TreeElement root) {
        Set<TreeElement> selection = new HashSet<>();
        TreeElement schema = root.getChild("Database").getChild("Source only").getChild("Schemas").getChild("audit");
        selection.add(schema.getChild("Tables").getChild("logged_actions"));
        return selection;
    }
}

/**
 * DifferData implementation with 1 DELETE view selected.
 * Adds to target depcy: view>new schema
 */
class DifferData_5 extends DifferData{

    @Override
    Set<TreeElement> getUserSelection(TreeElement root) {
        Set<TreeElement> selection = new HashSet<>();
        TreeElement schema = root.getChild("Database").getChild("Target only").getChild("Schemas").getChild("public");
        selection.add(schema.getChild("Views").getChild("v_auto_mark_two"));
        return selection;
    }
    
    @Override
    List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(PgDatabase target) {
        PgSchema s = target.getSchema("newschema");
        PgView v = target.getSchema("public").getView("v_auto_mark_two");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<PgStatement, PgStatement> (v, s);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }
}

