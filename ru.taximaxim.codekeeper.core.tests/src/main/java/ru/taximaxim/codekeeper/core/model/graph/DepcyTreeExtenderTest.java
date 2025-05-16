/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.model.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.TestCoreSettings;

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
    Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree);
}

/**
 * Tests for DepcyTreeExtender class
 *
 * @author ryabinin_av
 */

class DepcyTreeExtenderTest {
    /**
     * Тестирует зависимости от новых(и возможных edit) объектов, полученные из dte
     * @throws IOException
     * @throws InterruptedException
     */
    @ParameterizedTest
    @MethodSource("generator")
    void testGetDependencies(TreeElementCreator predefined, int fileIndex) throws IOException, InterruptedException {
        /**
         * Index of the file that should be tested.
         */

        var settings = new TestCoreSettings();

        String fileName = "depcy_schema_" + fileIndex + ".sql";
        String targetFileName = "depcy_schema_new_" + fileIndex + ".sql";

        AbstractDatabase dbSource = TestUtils.loadTestDump(
                fileName, DepcyTreeExtenderTest.class, settings);
        AbstractDatabase dbTarget = TestUtils.loadTestDump(
                targetFileName, DepcyTreeExtenderTest.class, settings);

        TreeElement tree = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        predefined.setUserSelection(tree);
        DepcyTreeExtender dte = new DepcyTreeExtender(dbSource, dbTarget, tree);
        Set<TreeElement> depcy = dte.getDepcies();
        Set<TreeElement> depcyPredefined = predefined.getDepcySet(dbSource, dbTarget, tree);
        Assertions.assertEquals(depcyPredefined, depcy, "List of dependencies is not as expected");
    }

    private static Stream<Arguments> generator() {

        return Stream.of(
                Arguments.of(new Predefined1(), 1),
                Arguments.of(new Predefined2(), 2),
                Arguments.of(new Predefined3(), 3),
                Arguments.of(new Predefined4(), 4),
                Arguments.of(new Predefined5(), 5),
                Arguments.of(new Predefined6(), 6));
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
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
    public Set<TreeElement> getDepcySet(AbstractDatabase source, AbstractDatabase target, TreeElement tree) {
        TreeElement func = tree.findElement(target.getSchema(Consts.PUBLIC).getFunction("f1()"));
        return new HashSet<>(Arrays.asList(func));
    }
}