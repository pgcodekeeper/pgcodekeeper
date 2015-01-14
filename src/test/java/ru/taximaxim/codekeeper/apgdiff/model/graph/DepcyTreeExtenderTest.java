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

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.loader.ParserClass;
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

    public abstract TreeElement getFilteredTree();

    public abstract TreeElement getFilteredTreeForDeletion();
    
    public abstract TreeElement getFilteredTreeForConflicting();

    public abstract Set<PgStatement> getDepcySet(PgDatabase db);

    public abstract TreeElement getExtraElement();

    public abstract Set<TreeElement> getExtraElementInTree(TreeElement filtered);

    public abstract TreeElement getFilteredCopy();

    public abstract Set<TreeElement> getConflicting(TreeElement copy);
    
    public abstract int getFileIndex();
    
    public String getFilename(){
        return "depcy_schema_" + getFileIndex() + ".sql";
    }
    
    public String getConflictingFilename(){
        return "depcy_schema_conflicting_" + getFileIndex() + ".sql";
    }
}

/**
 * Tests for DepcyTreeExtender class
 * 
 * @author ryabinin_av
 */
@RunWith(value = Parameterized.class)
public class DepcyTreeExtenderTest {
    
    private TreeElementCreator predefined;
    private ParserClass parserType;
    
    private String filename;
    private String conflictingFilename;

    public DepcyTreeExtenderTest(TreeElementCreator predefined, ParserClass parserType) {
        this.predefined = predefined;
        this.parserType = parserType;
        
        this.conflictingFilename = predefined.getConflictingFilename();
        this.filename = predefined.getFilename();
    }

    /**
     * Provides parameters for running the tests.
     */
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
// SONAR-OFF
                    {new Predefined1(), ParserClass.LEGACY},
                    {new Predefined1(), ParserClass.ANTLR},
                    
                    {new Predefined2(), ParserClass.LEGACY},
                    {new Predefined2(), ParserClass.ANTLR},
                    
                    {new Predefined3(), ParserClass.LEGACY},
                    {new Predefined3(), ParserClass.ANTLR},
                    
                    {new Predefined4(), ParserClass.LEGACY},
                    {new Predefined4(), ParserClass.ANTLR},
                    
                    {new Predefined5(), ParserClass.LEGACY},
                    {new Predefined5(), ParserClass.ANTLR}
// SONAR-ON
                });
    }
    
    @Test
    public void testGetDependenciesOfNew() {
        PgDatabase dbTarget = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                ApgdiffConsts.UTF_8, false, false, parserType);
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbTarget, dbTarget, predefined.getFilteredTree());
        
        Set<PgStatement> depcy = dte.getDependenciesOfNew();
        Set<PgStatement> depcyPredefined = predefined.getDepcySet(dbTarget);
        assertTrue("List of dependencies is not as expected", depcy.equals(depcyPredefined));
    }
    
    @Test
    public void testGetTreeCopyWithDepcy() {
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                ApgdiffConsts.UTF_8, false, false, parserType);
        
        TreeElement filtered = predefined.getFilteredTreeForDeletion();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        
        TreeElement filteredCopy = dte.getTreeCopyWithDepcy();
        
        TreeElement filteredCopyPredefined = predefined.getFilteredCopy();
        
        Assert.assertTrue("Trees are not identical", 
                treesAreIdentical(filteredCopy, filteredCopyPredefined) && 
                treesAreIdentical(filteredCopyPredefined, filteredCopy));
    }
    
    @Test
    public void testSumAllDepcies() {
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                ApgdiffConsts.UTF_8, false, false, parserType);
        
        TreeElement filtered = predefined.getFilteredTree();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        TreeElement filteredCopy = dte.getTreeCopyWithDepcy();
        
        Set<TreeElement> sum = dte.sumAllDepcies(
                new HashSet<>(Arrays.asList(predefined.getExtraElement())));
        
        Set<TreeElement> extraInFiltered = predefined.getExtraElementInTree(filteredCopy);
        
        Assert.assertTrue("Result differs", sum.toArray()[0] == extraInFiltered.toArray()[0]);
    }
    
    @Test
    public void testGetConflicting() {
        PgDatabase dbRemote = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename), ApgdiffConsts.UTF_8,
                false, false, parserType);

        PgDatabase dbGit = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(conflictingFilename), ApgdiffConsts.UTF_8,
                false, false, parserType);

        TreeElement filtered = predefined.getFilteredTreeForConflicting();
        DepcyTreeExtender dte = new DepcyTreeExtender(dbGit, dbRemote, filtered);
        TreeElement copy = dte.getTreeCopyWithDepcy();
        
        Set<TreeElement> conflictingPredefined = predefined.getConflicting(copy);
        Set<TreeElement> conflicting = dte.getConflicting();
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

// SONAR-OFF
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contViews = new TreeElement("Views", DbObjType.CONTAINER, DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(contViews);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, null, DiffSide.RIGHT);
        contViews.addChild(view);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        PgView view = schema.getView("v2");
        PgTable table = schema.getTable("t1");
        PgColumn column = table.getColumn("c1");
        return new HashSet<>(Arrays.asList(db, schema, view, table, column));
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
                getChild(ApgdiffConsts.PUBLIC).getChild("Views").getChild("v1");
        return new HashSet<>(Arrays.asList(o));
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        
        
        TreeElement different = new TreeElement("Different", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.BOTH);
        database.addChild(different);
        
        TreeElement contSchemasBoth = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.BOTH);
        different.addChild(contSchemasBoth);
        
        TreeElement publicSchemaBoth = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
                getChild(ApgdiffConsts.PUBLIC).getChild("Views");
        // КОСТЫЛЬ - конфликтующие объекты копируются в одного парента с разными DiffSide 
        TreeElement view = contViews.getChild(1);
        return new HashSet<>(Arrays.asList(view));
    }

    @Override
    public int getFileIndex() {
        return 1;
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        return new HashSet<>(Arrays.asList(db, db.getSchema(ApgdiffConsts.PUBLIC)));
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
        getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(publicSchema);
        
        TreeElement contTable = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(contTable);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, null, DiffSide.LEFT);
        contTable.addChild(table);
        
        
        TreeElement different = new TreeElement("Different", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.BOTH);
        database.addChild(different);
        
        TreeElement contSchemasBoth = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.BOTH);
        different.addChild(contSchemasBoth);
        
        TreeElement publicSchemaBoth = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemasBoth.addChild(publicSchemaBoth);
        
        TreeElement contSequencesBoth = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.BOTH);
        publicSchemaBoth.addChild(contSequencesBoth);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.BOTH);
        contSequencesBoth.addChild(seq);
        
        return root;
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        return new HashSet<>();
    }

    @Override
    public int getFileIndex() {
        return 2;
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        PgTable table = schema.getTable("t1");
        PgSequence seq = schema.getSequence("s1");
        return new HashSet<>(Arrays.asList(db, schema, table, seq));
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
                getChild("Source only").getChild("Schemas").getChild(ApgdiffConsts.PUBLIC);
        
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
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences");
        // КОСТЫЛЬ - конфликтующие объекты копируются в одного парента с разными DiffSide 
        TreeElement seq = contSeq.getChild(1);
        
        return new HashSet<>(Arrays.asList(seq));
    }

    @Override
    public int getFileIndex() {
        return 3;
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.RIGHT);
        contSchemas.addChild(publicSchema);
        
        TreeElement contSequences = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(contSequences);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.RIGHT);
        contSequences.addChild(seq);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        return new HashSet<>(Arrays.asList(db, schema));
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild("Database").getChild("Target only").getChild("Schemas").
                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences").getChild("s1");
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
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, null, DiffSide.BOTH);
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
                getChild("Source only").getChild("Schemas").getChild(ApgdiffConsts.PUBLIC);
        
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

    @Override
    public int getFileIndex() {
        return 4;
    }
}

class Predefined5 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(database);
        
        TreeElement sourceOnly = new TreeElement("Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        database.addChild(sourceOnly);
        
        TreeElement contSchemas = new TreeElement("Schemas", DbObjType.CONTAINER, DbObjType.SCHEMA, DiffSide.BOTH);
        sourceOnly.addChild(contSchemas);
        
        TreeElement republicSchema = new TreeElement("republic", DbObjType.SCHEMA, null, DiffSide.BOTH);
        contSchemas.addChild(republicSchema);
        
        TreeElement contTables = new TreeElement("Tables", DbObjType.CONTAINER, DbObjType.TABLE, DiffSide.BOTH);
        republicSchema.addChild(contTables);
        
        TreeElement table = new TreeElement("t_test2foreign", DbObjType.TABLE, null, DiffSide.RIGHT);
        contTables.addChild(table);
        
        TreeElement consCont = new TreeElement("Constraints", DbObjType.CONTAINER, null, DiffSide.RIGHT);
        table.addChild(consCont);
        
        TreeElement cons = new TreeElement("fk_t_test2foreign", DbObjType.CONSTRAINT, null, DiffSide.RIGHT);
        consCont.addChild(cons);
        
        return root;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        PgTable table = schema.getTable("t_test2");
        PgSchema schemaRep = db.getSchema("republic");
        PgTable tableConstr = schemaRep.getTable("t_test2foreign");
        PgColumn col = table.getColumn("c_name_t_test2");
        return new HashSet<>(Arrays.asList(db, schema, table, tableConstr, schemaRep, col));
    }
   
    @Override
    public TreeElement getExtraElement() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        return new HashSet<>(Arrays.asList(filtered));
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement root = new TreeElement("<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        return new HashSet<>();
    }

    @Override
    public int getFileIndex() {
        return 5;
    }
}
// SONAR-ON