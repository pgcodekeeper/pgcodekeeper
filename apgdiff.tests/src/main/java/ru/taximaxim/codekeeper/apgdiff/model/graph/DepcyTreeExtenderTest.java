package ru.taximaxim.codekeeper.apgdiff.model.graph;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

/**
 * An abstract 'factory' that creates 'artificial' predefined objects
 * for specific test-cases
 */
abstract class TreeElementCreator {

    /**
     * Возвращает дерево, представляющее собой выбор пользователя (фильтр дерева
     * диффа по селекшену)
     */
    public abstract TreeElement getFilteredTree();

    /**
     * Возвращает зависимости от объектов в дереве
     * @param db
     */
    public abstract Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree);

    public abstract int getFileIndex();

    public String getFilename(){
        return "depcy_schema_" + getFileIndex() + ".sql";
    }

    public String getTargetFileName() {
        return "depcy_schema_new_"+getFileIndex() + ".sql";
    }
}

/**
 * Tests for DepcyTreeExtender2 class
 *
 * @author ryabinin_av
 */
@RunWith(value = Parameterized.class)
public class DepcyTreeExtenderTest {

    private final TreeElementCreator predefined;

    private final PgDatabase dbSource;
    private final PgDatabase dbTarget;

    public DepcyTreeExtenderTest(TreeElementCreator predefined) throws InterruptedException, IOException {
        this.predefined = predefined;
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(ApgdiffConsts.UTF_8);
        this.dbSource = ApgdiffTestUtils.loadTestDump(
                predefined.getFilename(), DepcyTreeExtenderTest.class, args);
        this.dbTarget = ApgdiffTestUtils.loadTestDump(
                predefined.getTargetFileName(), DepcyTreeExtenderTest.class, args);
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
    public void testGetDependencies() throws PgCodekeeperException, InterruptedException {
        TreeElement tree = predefined.getFilteredTree();
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbTarget, tree);
        Set<TreeElement> depcy = dte.getDepcies();
        Set<TreeElement> depcyPredefined = predefined.getDepcySet(dbSource, dbTarget, tree);
        assertTrue("List of dependencies is not as expected", depcy.equals(depcyPredefined));
    }
}

// SONAR-OFF
/**
 * Различаются объекты: добавились view v1, v2, у таблицы изменилась колонка с1,
 * пользователь выбрал v1, по зависимости подтянулась v2, и таблица t1 (т.к.
 * колонок нет в дереве)
 *
 * @author botov_av
 *
 */
class Predefined1 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement table = new TreeElement("t1", DbObjType.TABLE, DiffSide.BOTH);
        publicSchema.addChild(table);

        TreeElement view = new TreeElement("v2", DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(view);

        view = new TreeElement("v1", DbObjType.VIEW, DiffSide.RIGHT);
        view.setSelected(true);
        publicSchema.addChild(view);

        return database;
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        TreeElement table = tree.findElement(target.getDefaultSchema().getTable("t1"));
        TreeElement view = tree.findElement(target.getDefaultSchema().getView("v2"));
        TreeElement publicSchema = tree.findElement(target.getDefaultSchema());
        return new HashSet<>(Arrays.asList(table, publicSchema, view));
    }

    @Override
    public int getFileIndex() {
        return 1;
    }
}
/**
 * Различаются объекты: меняется сиквенс, пользователь выбрал его
 * @author botov_av
 *
 */
class Predefined2 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.BOTH);
        seq.setSelected(true);
        publicSchema.addChild(seq);

        return database;
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
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
 *
 * Различаются объекты: новый сиквенс, пользователь выбрал его.
 */
class Predefined3 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        seq.setSelected(true);
        publicSchema.addChild(seq);

        return database;
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        //        PgSchema schema = db.getSchema(ApgdiffConsts.PUBLIC);
        //        PgTable table = schema.getTable("t1");
        //        PgSequence seq = schema.getSequence("s1");
        return new HashSet<>(/*Arrays.asList(schema, table, seq)*/);
    }

    @Override
    public int getFileIndex() {
        return 3;
    }
}

/**
 * Различаются объекты: новый сиквенс и привилегия на схему public, пользователь
 * выбрал сиквенс, по зависимости подтянулась схема
 *
 * @author botov_av
 *
 */
class Predefined4 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        TreeElement publicSchema = new TreeElement(ApgdiffConsts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        seq.setSelected(true);
        publicSchema.addChild(seq);

        return database;
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        return new HashSet<>(Arrays.asList(tree.findElement(source.getDefaultSchema())));
    }

    @Override
    public int getFileIndex() {
        return 4;
    }
}

/**
 * Различаются объекты: новая таблица с новым внешним ключом, пользователь
 * выбрал внешний ключ, по зависимости тянется новая таблица
 *
 * @author botov_av
 *
 */
class Predefined5 extends TreeElementCreator{

    @Override
    public TreeElement getFilteredTree() {
        TreeElement database = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        TreeElement republicSchema = new TreeElement("republic", DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(republicSchema);

        TreeElement table = new TreeElement("t_test2foreign", DbObjType.TABLE, DiffSide.RIGHT);
        republicSchema.addChild(table);

        TreeElement cons = new TreeElement("fk_t_test2foreign", DbObjType.CONSTRAINT, DiffSide.RIGHT);
        cons.setSelected(true);
        table.addChild(cons);

        return database;
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        TreeElement table = tree.findElement(target.getSchema("republic").getTable("t_test2foreign"));
        return new HashSet<>(Arrays.asList(table));
    }

    @Override
    public int getFileIndex() {
        return 5;
    }
}
// SONAR-ON
