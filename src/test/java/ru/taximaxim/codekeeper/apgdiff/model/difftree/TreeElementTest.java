package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoaderTest;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;

@RunWith(value = Parameterized.class)
public class TreeElementTest {

    private final String dbDumpName;
    
    final private List<String> FUNC_NAMES = 
            Arrays.asList(new String[]{"abcdefg1()", "abcdefg2()", "abcdefg3()"});
    
    public TreeElementTest(String dbName) {
        this.dbDumpName = dbName;
    }
    
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    {"schema_1.sql"},{"schema_2.sql"},{"schema_3.sql"},
                    {"schema_4.sql"},{"schema_5.sql"},{"schema_6.sql"}
                });
    }
   
    @Test
    public void testGetFilteredCopy() {
        PgDatabase dbFull = PgDumpLoader.loadDatabaseSchemaFromDump(
                PgDumpLoaderTest.class.getResourceAsStream(dbDumpName),
                "UTF8", false, false);
        PgDatabase dbPartial = new PgDatabase();
        
        if (dbDumpName.equals("schema_6.sql")) {
            PgSchema schema = dbPartial.getDefaultSchema();
            schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM PUBLIC", ""));
            schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM postgres", ""));
            schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO postgres", ""));
            schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO PUBLIC", ""));
        }
        
        for (String function : FUNC_NAMES){
            String name = function.substring(0, function.length()-2);
            dbFull.getSchema("public").addFunction(new PgFunction(name, "", ""));
            dbPartial.getSchema("public").addFunction(new PgFunction(name, "", ""));
        }

        TreeElement tree_full = DiffTree.create(dbFull, new PgDatabase());
        
        Set<TreeElement> checked = new HashSet<TreeElement>();
        visitAndFindNew(tree_full, checked);
        
        TreeElement tree_filtered = tree_full.getFilteredCopy(checked);
        
        PgDatabase dbFiltered = new PgDbFilter2(dbFull, tree_filtered, DiffSide.LEFT).apply();
        
        assertEquals("filtered database is not equal to the reference one",
                dbPartial, dbFiltered);
    }
    
    private void visitAndFindNew (TreeElement element, Set<TreeElement> set){
        if (element.getType() == DbObjType.FUNCTION && FUNC_NAMES.contains(element.getName())){
            set.add(element);
        }
        for (TreeElement e : element.getChildren()){
            visitAndFindNew(e, set);
        }
    }
}
