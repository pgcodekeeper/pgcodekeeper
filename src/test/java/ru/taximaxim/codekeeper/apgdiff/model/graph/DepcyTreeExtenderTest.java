package ru.taximaxim.codekeeper.apgdiff.model.graph;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.Assert;
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

/**
 * An abstract 'factory' that creates 'artificial' predefined objects 
 * for specific test-cases
*/
abstract class TreeElementCreator {

    abstract public TreeElement getFilteredTree();

    abstract public TreeElement getFilteredTreeForDeletion();
    
    abstract public TreeElement getFilteredTreeForConflicting();

    abstract public Set<PgStatement> getDepcySet(PgDatabase db);

    abstract public TreeElement getExtraElement();

    abstract public Set<TreeElement> getExtraElementInTree(TreeElement filtered);

    abstract public TreeElement getFilteredCopy();

    abstract public HashSet<TreeElement> getConflicting(TreeElement copy);
}

/**
 * Tests for DepcyTreeExtender class
 * 
 * @author ryabinin_av
 */
@RunWith(value = Parameterized.class)
public class DepcyTreeExtenderTest {

    private final int fileIndex;

    /**
     * Provides parameters for running the tests.
     */
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
    
    /**
     * Array of implementations of {@link TreeElementCreator}
     */
    private static final TreeElementCreator[] treeCreators = {
        new Predefined1(),
        new Predefined2(),
        new Predefined3(),
        new Predefined4()
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

    @Test
    public void testGetTreeCopyWithDepcy() {
        String filename = "depcy_schema_" + fileIndex + ".sql";
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                getClass().getResourceAsStream(filename), "UTF-8", false, false);
        
        TreeElementCreator treeCreator = treeCreators[fileIndex - 1];
        
        TreeElement filtered = treeCreator.getFilteredTreeForDeletion();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        
        TreeElement filteredCopy = dte.getTreeCopyWithDepcy();
        
        TreeElement filteredCopyPredefined = treeCreator.getFilteredCopy();
        
        Assert.assertTrue("Trees are not identical", 
                treesAreIdentical(filteredCopy, filteredCopyPredefined) && 
                treesAreIdentical(filteredCopyPredefined, filteredCopy));
    }
    
    @Test
    public void testSumAllDepcies() {
        String filename = "depcy_schema_" + fileIndex + ".sql";
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                getClass().getResourceAsStream(filename), "UTF-8", false, false);
        
        TreeElementCreator treeCreator = treeCreators[fileIndex - 1];
        
        TreeElement filtered = treeCreator.getFilteredTree();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        TreeElement filteredCopy = dte.getTreeCopyWithDepcy();
        
        TreeElement extraNotInFiltered = treeCreator.getExtraElement();
        
        HashSet<TreeElement> sum = dte.sumAllDepcies(
                new HashSet<TreeElement>(Arrays.asList(extraNotInFiltered)));
        
        Set<TreeElement> extraInFiltered = treeCreator.getExtraElementInTree(filteredCopy);
        
        Assert.assertTrue("Result differs", sum.toArray()[0] == extraInFiltered.toArray()[0]);
    }
    
    @Test
    public void testGetConflicting() {
        String filename = "depcy_schema_" + fileIndex + ".sql";
        String filenameConflicting = "depcy_schema_conflicting_" + fileIndex + ".sql";
        PgDatabase dbRemote = PgDumpLoader.loadDatabaseSchemaFromDump(
                        getClass().getResourceAsStream(filename), "UTF-8",
                        false, false);

        PgDatabase dbGit = PgDumpLoader.loadDatabaseSchemaFromDump(
                        getClass().getResourceAsStream(filenameConflicting), "UTF-8",
                        false, false);

        TreeElementCreator treeCreator = treeCreators[fileIndex - 1];
        
        TreeElement filtered = treeCreator.getFilteredTreeForConflicting();
        DepcyTreeExtender dte = new DepcyTreeExtender(dbGit, dbRemote, filtered);
        TreeElement copy = dte.getTreeCopyWithDepcy();
        HashSet<TreeElement> conflictingPredefined = treeCreator.getConflicting(copy);
        HashSet<TreeElement> conflicting = dte.getConflicting();
        Assert.assertEquals("Conflicting collections are not same", conflictingPredefined, conflicting);
    }

    /**
     * Tests whether two trees are identical not by reference but by value 
     * (four parameters are considered: name, type, containerType and side)
     * 
     * @param firstTree
     * @param secondTree
     * @return
     */
    private boolean treesAreIdentical(TreeElement firstTree, TreeElement secondTree) {
        if (secondTree == null){
            return false;
        }
        for (TreeElement child : firstTree.getChildren()){
            TreeElement childPredefined = secondTree.getChild(child.getName(), child.getType());
            boolean childIdentical = treesAreIdentical(child, childPredefined);
            if (!childIdentical){
                return false;
            }
        }
        return     Objects.equals(firstTree.getName(), secondTree.getName())
                && Objects.equals(firstTree.getType(), secondTree.getType())
                && Objects.equals(firstTree.getContainerType(), secondTree.getContainerType())
                && Objects.equals(firstTree.getSide(), secondTree.getSide());
    }
}

 class Predefined1 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(contViews);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.RIGHT);
        contViews.addChild(view);
        
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
   
    @Override
    public TreeElement getExtraElement() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.RIGHT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(contViews);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.RIGHT);
        contViews.addChild(view);
        
        return view;
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Views").getChild("v1");
        return new HashSet<TreeElement>(Arrays.asList(o));
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.LEFT);
        publicSchema.addChild(contViews);
        
        TreeElement view = new TreeElement("v2", DbObjType.VIEW, null, DiffSide.LEFT);
        contViews.addChild(view);
        
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.LEFT);
        publicSchema.addChild(contViews);
        
        TreeElement view = new TreeElement("v2", DbObjType.VIEW, null, DiffSide.LEFT);
        contViews.addChild(view);
        
        TreeElement viewDependant = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.LEFT);
        contViews.addChild(viewDependant);
        
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        
        
        TreeElement different = new TreeElement("Different", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.BOTH);
        database.addChild(different);
        
        TreeElement contSchemasBoth = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.BOTH);
        different.addChild(contSchemasBoth);
        
        TreeElement publicSchemaBoth = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemasBoth.addChild(publicSchemaBoth);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.BOTH);
        publicSchemaBoth.addChild(contViews);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.BOTH);
        contViews.addChild(view);
        
        return root;
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        TreeElement contViews = copy.getChild("Database").getChild("Different").getChild("Schemas").
                getChild("public").getChild("Views");
        // КОСТЫЛЬ - конфликтующие объекты копируются в одного парента с разными DiffSide 
        TreeElement view = contViews.getChild(1);
        return new HashSet<TreeElement>(Arrays.asList(view));
    }
}

class Predefined2 extends TreeElementCreator{

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

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
        getChild("public").getChild("Sequences").getChild("s1");
        return new HashSet<TreeElement>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Sequences").getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t1", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        return getFilteredTreeForDeletion();
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        
        
        TreeElement different = new TreeElement("Different", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.BOTH);
        database.addChild(different);
        
        TreeElement contSchemasBoth = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.BOTH);
        different.addChild(contSchemasBoth);
        
        TreeElement publicSchemaBoth = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemasBoth.addChild(publicSchemaBoth);
        
        TreeElement contSequencesBoth = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.BOTH);
        publicSchemaBoth.addChild(contSequencesBoth);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.BOTH);
        contSequencesBoth.addChild(seq);
        
        return root;
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        return new HashSet<TreeElement>();
    }
}

class Predefined3 extends TreeElementCreator{

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

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Sequences").getChild("s1");
        return new HashSet<TreeElement>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Sequences").getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t1", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = getFilteredTreeForDeletion();
        TreeElement initialPublicSchema = root.getChild("Database").
                getChild("Source only").getChild("Schemas").getChild("public");
        
        TreeElement contSeq = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.LEFT);
        initialPublicSchema.addChild(contSeq);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.LEFT);
        contSeq.addChild(seq);
        
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
       
        return new Predefined2().getFilteredTreeForConflicting();
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        TreeElement contSeq = copy.getChild("Database").getChild("Different").getChild("Schemas").
                getChild("public").getChild("Sequences");
        // КОСТЫЛЬ - конфликтующие объекты копируются в одного парента с разными DiffSide 
        TreeElement seq = contSeq.getChild(1);
        
        return new HashSet<TreeElement>(Arrays.asList(seq));
    }
}

class Predefined4 extends TreeElementCreator{

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

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Sequences").getChild("s1");
        return new HashSet<TreeElement>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild("public").getChild("Sequences").getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.LEFT);
        sourceOnly.addChild(contSchemas);
        
        TreeElement publicSchema = new TreeElement("public", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSeq = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.LEFT);
        publicSchema.addChild(contSeq);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.LEFT);
        contSeq.addChild(seq);
        
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = getFilteredTreeForDeletion();
        TreeElement initialPublicSchema = root.getChild("Database").
                getChild("Source only").getChild("Schemas").getChild("public");
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        initialPublicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t1", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        return new Predefined2().getFilteredTreeForConflicting();
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        return new Predefined3().getConflicting(copy);
    }
}