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
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * An abstract 'factory' that creates 'artificial' predefined objects 
 * for specific test-cases
*/
abstract class TreeElementCreator {

    /**
     * Возвращает дерево, представляющее собой выбор пользователя (фильтр дерева диффа по селекшену) 
     */
    public abstract TreeElement getFilteredTree();

    /**
     * Возвращает дерево, представляющее собой выбор пользователя. Ожидается, что оно содержит удаляемые объекты.
     */
    public abstract TreeElement getFilteredTreeForDeletion();
    
    /**
     * Возвращает дерево, представляющее собой выбор пользователя. 
     * Ожидается, что оно должно генерировать конфликты 
     * (выбран объект edit, но по зависимостям мы хотим его удалить, и наоборот)
     */
    public abstract TreeElement getFilteredTreeForConflicting();

    /**
     * Возвращает зависимости от новых объектов в дереве, которое скормили dte
     * @param db
     */
    public abstract Set<PgStatement> getDepcySet(PgDatabase db);

    /**
     * Возвращает предопределенный элемент-зависимость от new/edit.
     */
    public abstract TreeElement getExtraElement();

    /**
     * Возвращает некоторые элементы из дерева filtered
     */
    public abstract Set<TreeElement> getExtraElementInTree(TreeElement filtered);

    /**
     * Возвращает предустановленное дерево - исходное filtered-дерево + зависимости от удаляемых
     */
    public abstract TreeElement getFilteredCopy();

    /**
     * Возвращает предустановленный набор элементов, которые находятся в конфликтном состоянии
     * @see DepcyTreeExtenderTest#testGetConflicting()
     */
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
    
    private final TreeElementCreator predefined;
    private final ParserClass parserType = ParserClass.getAntlr(null, 1);
    
    private final String filename;
    private final String conflictingFilename;

    public DepcyTreeExtenderTest(TreeElementCreator predefined) {
        this.predefined = predefined;
        
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
                    {new Predefined1()},
                    {new Predefined2()},
                    {new Predefined3()},
                    {new Predefined4()},
                    {new Predefined5()}
// SONAR-ON
                });
    }
    
    
    /**
     * Тестирует зависимости от новых(и возможных edit) объектов, полученные из dte
     * @throws InterruptedException 
     */
    @Test
    public void testGetDependenciesOfNew() throws PgCodekeeperException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase dbTarget = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                args, parserType);
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbTarget, dbTarget, predefined.getFilteredTree());
        Set<PgStatement> depcy = dte.fetchDependenciesOfNewEdit();
        Set<PgStatement> depcyPredefined = predefined.getDepcySet(dbTarget);
        assertTrue("List of dependencies is not as expected", depcy.equals(depcyPredefined));
    }
    
    /**
     * Тестирует дерево, получаемое из dte, которое должно быть расширено зависимостями от удаляемых элементов
     * @throws InterruptedException 
     */
    @Test
    public void testGetTreeCopyWithDepcy() throws PgCodekeeperException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                args, parserType);
        
        TreeElement filtered = predefined.getFilteredTreeForDeletion();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        
        TreeElement filteredCopy = dte.copyInitialTreeWithDependantsOfDeleted();
        
        TreeElement filteredCopyPredefined = predefined.getFilteredCopy();
        
        Assert.assertTrue("Trees are not identical", 
                treesAreIdentical(filteredCopy, filteredCopyPredefined) && 
                treesAreIdentical(filteredCopyPredefined, filteredCopy));
    }
    
    
    /**
     * Тестирует метод "суммирования" зависимостей (те что delete И те что new/edit) 
     * Здесь filteredCopy - исходное дерево, расширенное зависимостями от удаляемых, 
     * а predefined.getExtraElement() *типа* возвращает зависимости от new/edit)
     * @throws InterruptedException 
     */
    @Test
    public void testSumAllDepcies() throws PgCodekeeperException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase dbSource = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                args, parserType);
        
        TreeElement filtered = predefined.getFilteredTree();
        
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbSource, filtered);
        TreeElement filteredCopy = dte.copyInitialTreeWithDependantsOfDeleted();
        
        Set<TreeElement> sum = dte.sumNewEditWithInternalDeleted(
                new HashSet<>(Arrays.asList(predefined.getExtraElement())));
        
        Set<TreeElement> extraInFiltered = predefined.getExtraElementInTree(filteredCopy);
        
        Assert.assertTrue("Result differs", sum.equals(extraInFiltered));
    }
    
    /**
     * Тестирует dte на предмет правильного обнаружения конфликтов.
     * Тут есть 2 бд, и есть предопределенный выбор пользователя, который должен
     * генерить конфликты 
     * (например, пользователь выбрал таблицу на удаление, и зависящую от нее вьюху на редактирование. 
     * Но по зависимостям от дропнутой таблицы ожидается дроп и зависимой вьюхи. 
     * Эта вьюха существует как edit, так и delete => конфликтъ).
     * @throws InterruptedException 
     */
    @Test
    public void testGetConflicting() throws PgCodekeeperException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase dbRemote = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(filename),
                args, parserType);

        args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        PgDatabase dbGit = PgDumpLoader.loadDatabaseSchemaFromDump(
                DepcyTreeExtenderTest.class.getResourceAsStream(conflictingFilename), args,
                parserType);

        TreeElement filtered = predefined.getFilteredTreeForConflicting();
        DepcyTreeExtender dte = new DepcyTreeExtender(dbGit, dbRemote, filtered);
        TreeElement copy = dte.copyInitialTreeWithDependantsOfDeleted();
        
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
                && Objects.equals(firstTree.getSide(), secondTree.getSide());
    }
}

// SONAR-OFF
class Predefined1 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(view);
        
        return database;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        PgView view = schema.getView("v2");
        PgTable table = schema.getTable("t1");
        PgColumn column = table.getColumn("c1");
        return new HashSet<>(Arrays.asList(schema, view, table, column));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(view);
        
        return view;
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild(ApgdiffConsts.PUBLIC).getChild("v1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement view = new TreeElement("v2", DbObjType.VIEW, DiffSide.LEFT);
        publicSchema.addChild(view);
        
        return database;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement view = new TreeElement("v2", DbObjType.VIEW, DiffSide.LEFT);
        publicSchema.addChild(view);
        
        TreeElement viewDependant = new TreeElement("v1", DbObjType.VIEW, DiffSide.LEFT);
        publicSchema.addChild(viewDependant);
        
        return database;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(table);
        
        TreeElement view = new TreeElement("v1", DbObjType.VIEW, DiffSide.BOTH);
        publicSchema.addChild(view);
        
        return database;
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
        TreeElement contViews = copy.getChild(ApgdiffConsts.PUBLIC);
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
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.RIGHT);
        database.addChild(publicSchema);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(seq);
        
        return database;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        return new HashSet<>();
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement table = new TreeElement("t1", DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(table);
        
        return database;
    }

    @Override
    public TreeElement getFilteredCopy() {
        return getFilteredTreeForDeletion();
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement table = new TreeElement("t2", DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(table);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.BOTH);
        publicSchema.addChild(seq);
        
        return database;
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

/**
 * Тест устарел по причине разрыва цикла зависимостей между таблицей и сиквенсом.
 * Код закомментирован по этой причине.
 */
class Predefined3 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.RIGHT);
        database.addChild(publicSchema);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(seq);
        
        return database;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
//        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
//        PgTable table = schema.getTable("t1");
//        PgSequence seq = schema.getSequence("s1");
        return new HashSet<>(/*Arrays.asList(schema, table, seq)*/);
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);
        
        TreeElement table = new TreeElement("t1", DbObjType.TABLE, DiffSide.LEFT);
        publicSchema.addChild(table);
        return database;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = getFilteredTreeForDeletion();
//        TreeElement initialPublicSchema = root.getChild("Database").
//                getChild("Source only").getChild("Schemas").getChild(ApgdiffConsts.PUBLIC);
//        
//        TreeElement contSeq = new TreeElement("Sequences", DbObjType.CONTAINER, DbObjType.SEQUENCE, DiffSide.LEFT);
//        initialPublicSchema.addChild(contSeq);
//
//        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, null, DiffSide.LEFT);
//        contSeq.addChild(seq);
        
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        return new Predefined2().getFilteredTreeForConflicting();
    }

    @Override
    public HashSet<TreeElement> getConflicting(TreeElement copy) {
//        TreeElement contSeq = copy.getChild("Database").getChild("Different").getChild("Schemas").
//                getChild(ApgdiffConsts.PUBLIC).getChild("Sequences");
//        // КОСТЫЛЬ - конфликтующие объекты копируются в одного парента с разными DiffSide 
//        TreeElement seq = contSeq.getChild(1);
//        
        return new HashSet<>(/*Arrays.asList(seq)*/);
    }

    @Override
    public int getFileIndex() {
        return 3;
    }
}

class Predefined4 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.RIGHT);
        database.addChild(publicSchema);
        
        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        publicSchema.addChild(seq);
        
        return database;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        return new HashSet<>();
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        TreeElement o = filtered.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
        return new HashSet<>(Arrays.asList(o));
    }

    @Override
    public TreeElement getExtraElement() {
        TreeElement root = getFilteredTree();
        return root.getChild(ApgdiffConsts.PUBLIC).getChild("s1");
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.LEFT);
        publicSchema.addChild(seq);
        
        return database;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = getFilteredTreeForDeletion();
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
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement republicSchema = new TreeElement("republic", DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(republicSchema);
        
        TreeElement table = new TreeElement("t_test2foreign", DbObjType.TABLE, DiffSide.RIGHT);
        republicSchema.addChild(table);
        
        TreeElement cons = new TreeElement("fk_t_test2foreign", DbObjType.CONSTRAINT, DiffSide.RIGHT);
        table.addChild(cons);
        
        return database;
    }

    @Override
    public Set<PgStatement> getDepcySet(PgDatabase db) {
        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        PgTable table = schema.getTable("t_test2");
        PgSchema schemaRep = db.getSchema("republic");
        PgColumn col = table.getColumn("c_name_t_test2");
        return new HashSet<>(Arrays.asList(schema, table, schemaRep, col));
    }
   
    @Override
    public TreeElement getExtraElement() {
        TreeElement root = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public Set<TreeElement> getExtraElementInTree(TreeElement filtered) {
        return new HashSet<>(Arrays.asList(filtered));
    }

    @Override
    public TreeElement getFilteredTreeForDeletion() {
        TreeElement root = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public TreeElement getFilteredCopy() {
        TreeElement root = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        return root;
    }

    @Override
    public TreeElement getFilteredTreeForConflicting() {
        TreeElement root = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
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
