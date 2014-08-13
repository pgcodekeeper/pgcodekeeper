package ru.taximaxim.codekeeper.apgdiff.model.graph;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

abstract class TreeElementCreator {

    abstract public TreeElement getFilteredTree();
    abstract public Set<PgStatement> getDepcySet(PgDatabase db); 
}

@RunWith(value = Parameterized.class)
public class DepcyTreeExtenderTest {

    private final int fileIndex;

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    {1},
                    {2},
                    {3},
                    {4}
                });
    }
    
    private static final TreeElementCreator[] treeCreators = {
        new TreeElement1(),
        new TreeElement2(),
        new TreeElement3(),
        new TreeElement4()
    };
    
    public DepcyTreeExtenderTest(final int fileIndex) {
        this.fileIndex = fileIndex;
    }
    
    @Test
    public void testGetDependenciesOfNew() {
        String filename = "depcy_schema_" + fileIndex + ".sql";
        PgDatabase dbTarget = PgDumpLoader.loadDatabaseSchemaFromDump(
                getClass().getResourceAsStream(filename), "UTF-8", false, false);
        
        TreeElement filtered = treeCreators[fileIndex - 1].getFilteredTree();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbTarget, dbTarget, filtered);
        
        HashSet<PgStatement> depcy = dte.getDependenciesOfNew();
        Set<PgStatement> depcyPredefined = treeCreators[fileIndex - 1].getDepcySet(dbTarget);
        assertTrue("List of dependencies is not as expected", depcy.equals(depcyPredefined));
    }

    @Ignore
    @Test
    public void testGetTreeCopyWithDepcy() {
        fail("Not yet implemented");
    }
    @Ignore
    @Test
    public void testGetDepcyTargetDb() {
        fail("Not yet implemented");
    }
    @Ignore
    @Test
    public void testSumAllDepcies() {
        fail("Not yet implemented");
    }
    @Ignore
    @Test
    public void testGetConflicting() {
        fail("Not yet implemented");
    }
}

class TreeElement1 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(contViews);
        
        TreeElement viewV1 = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.RIGHT);
        contViews.addChild(viewV1);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema("public");
        PgView view = schema.getView("v2");
        PgTable table = schema.getTable("t1");
        PgColumn column = table.getColumn("c1");
        return new HashSet<PgStatement>(Arrays.asList(db, schema, view, table, column));
    }
}

class TreeElement2 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        return new HashSet<PgStatement>(Arrays.asList(db, db.getSchema("public")));
    }
}

class TreeElement3 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema("public");
        PgTable table = schema.getTable("t1");
        PgSequence seq = schema.getSequence("s1");
        return new HashSet<PgStatement>(Arrays.asList(db, schema, table, seq));
    }
}

class TreeElement4 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema("public");
        return new HashSet<PgStatement>(Arrays.asList(db, schema));
    }
}