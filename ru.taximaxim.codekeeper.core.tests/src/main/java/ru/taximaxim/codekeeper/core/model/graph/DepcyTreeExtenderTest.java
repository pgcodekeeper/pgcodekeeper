package ru.taximaxim.codekeeper.core.model.graph;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

/**
 * An 'factory' that creates 'artificial' predefined objects
 * for specific test-cases
 */
interface TreeElementCreator {
    /**
     * Заполняет дерево, представляющее собой выбор пользователя (фильтр дерева
     * диффа по селекшену)
     */
    void setUserSelection(TreeElement database);

    /**
     * Возвращает зависимости от объектов в дереве
     * @param db
     */
    Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree);
}

/**
 * Tests for DepcyTreeExtender class
 *
 * @author ryabinin_av
 */
@RunWith(value = Parameterized.class)
public class DepcyTreeExtenderTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
            { new Predefined1(), 1 },
            { new Predefined2(), 2 },
            { new Predefined3(), 3 },
            { new Predefined4(), 4 },
            { new Predefined5(), 5 },
            { new Predefined6(), 6 },
        });
    }

    /**
     * Index of the file that should be tested.
     */
    private final int fileIndex;
    private final TreeElementCreator predefined;

    public DepcyTreeExtenderTest(TreeElementCreator predefined, int fileIndex) {
        this.predefined = predefined;
        this.fileIndex = fileIndex;
    }

    /**
     * Тестирует зависимости от новых(и возможных edit) объектов, полученные из dte
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testGetDependencies() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(Consts.UTF_8);

        String fileName = "depcy_schema_" + fileIndex + ".sql";
        String targetFileName = "depcy_schema_new_" + fileIndex + ".sql";

        PgDatabase dbSource = TestUtils.loadTestDump(
                fileName, DepcyTreeExtenderTest.class, args);
        PgDatabase dbTarget = TestUtils.loadTestDump(
                targetFileName, DepcyTreeExtenderTest.class, args);

        TreeElement tree = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        predefined.setUserSelection(tree);
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbTarget, tree);
        Set<TreeElement> depcy = dte.getDepcies();
        Set<TreeElement> depcyPredefined = predefined.getDepcySet(dbSource, dbTarget, tree);
        assertTrue("List of dependencies is not as expected", depcy.equals(depcyPredefined));
    }
}

/**
 * Различаются объекты: добавились view v1, v2, у таблицы изменилась колонка с1,
 * пользователь выбрал v1, по зависимости подтянулась v2, и таблица t1 (т.к.
 * колонок нет в дереве)
 *
 * @author botov_av
 *
 */
class Predefined1 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement publicSchema = new TreeElement(Consts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement table = new TreeElement("t1", DbObjType.TABLE, DiffSide.BOTH);
        publicSchema.addChild(table);

        TreeElement view = new TreeElement("v2", DbObjType.VIEW, DiffSide.RIGHT);
        publicSchema.addChild(view);

        view = new TreeElement("v1", DbObjType.VIEW, DiffSide.RIGHT);
        view.setSelected(true);
        publicSchema.addChild(view);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        TreeElement table = tree.findElement(target.getDefaultSchema().getTable("t1"));
        TreeElement view = tree.findElement(target.getDefaultSchema().getView("v2"));
        TreeElement publicSchema = tree.findElement(target.getDefaultSchema());
        return new HashSet<>(Arrays.asList(table, publicSchema, view));
    }
}
/**
 * Различаются объекты: меняется сиквенс, пользователь выбрал его
 * @author botov_av
 *
 */
class Predefined2 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement publicSchema = new TreeElement(Consts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.BOTH);
        seq.setSelected(true);
        publicSchema.addChild(seq);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        return new HashSet<>();
    }
}

/**
 * Тест устарел по причине разрыва цикла зависимостей между таблицей и сиквенсом.
 * Код закомментирован по этой причине.
 *
 * Различаются объекты: новый сиквенс, пользователь выбрал его.
 */
class Predefined3 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement publicSchema = new TreeElement(Consts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        seq.setSelected(true);
        publicSchema.addChild(seq);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        //        PgSchema schema = db.getSchema(Consts.PUBLIC);
        //        PgTable table = schema.getTable("t1");
        //        PgSequence seq = schema.getSequence("s1");
        return new HashSet<>(/*Arrays.asList(schema, table, seq)*/);
    }
}

/**
 * Различаются объекты: новый сиквенс и привилегия на схему public, пользователь
 * выбрал сиквенс, по зависимости подтянулась схема
 *
 * @author botov_av
 *
 */
class Predefined4 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement publicSchema = new TreeElement(Consts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement seq = new TreeElement("s1", DbObjType.SEQUENCE, DiffSide.RIGHT);
        seq.setSelected(true);
        publicSchema.addChild(seq);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        return new HashSet<>(Arrays.asList(tree.findElement(source.getDefaultSchema())));
    }
}

/**
 * Различаются объекты: новая таблица с новым внешним ключом, пользователь
 * выбрал внешний ключ, по зависимости тянется новая таблица
 *
 * @author botov_av
 *
 */
class Predefined5 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement republicSchema = new TreeElement("republic", DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(republicSchema);

        TreeElement table = new TreeElement("t_test2foreign", DbObjType.TABLE, DiffSide.RIGHT);
        republicSchema.addChild(table);

        TreeElement cons = new TreeElement("fk_t_test2foreign", DbObjType.CONSTRAINT, DiffSide.RIGHT);
        cons.setSelected(true);
        table.addChild(cons);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        TreeElement table = tree.findElement(target.getSchema("republic").getTable("t_test2foreign"));
        return new HashSet<>(Arrays.asList(table));
    }
}

/**
 * Различаются объекты: меняется таблица, добавляется функция, пользователь
 * выбрал таблицу, по зависимости тянется новая функция
 */
class Predefined6 implements TreeElementCreator {

    @Override
    public void setUserSelection(TreeElement database) {
        TreeElement publicSchema = new TreeElement(Consts.PUBLIC, DbObjType.SCHEMA, DiffSide.BOTH);
        database.addChild(publicSchema);

        TreeElement table = new TreeElement("t1", DbObjType.TABLE, DiffSide.BOTH);
        table.setSelected(true);
        publicSchema.addChild(table);

        TreeElement func = new TreeElement("f1()", DbObjType.FUNCTION, DiffSide.RIGHT);
        publicSchema.addChild(func);
    }

    @Override
    public Set<TreeElement> getDepcySet(PgDatabase source, PgDatabase target, TreeElement tree) {
        TreeElement func = tree.findElement(target.getSchema(Consts.PUBLIC).getFunction("f1()"));
        return new HashSet<>(Arrays.asList(func));
    }
}