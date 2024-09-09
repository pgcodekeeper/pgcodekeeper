/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.differ;

import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.UiTestUtils;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.tests.ProjectUpdaterTest;

public class DifferTest {

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new DifferData1()),
                Arguments.of(new DifferData2()),
                Arguments.of(new DifferData3()),
                Arguments.of(new DifferData4()),
                Arguments.of(new DifferData5()));
    }

    @ParameterizedTest
    @MethodSource("generator")
    void testDiffer(DifferData differData) throws Exception {
        Path sourceFile = UiTestUtils.getPathToResource("old.sql", ProjectUpdaterTest.class);
        Path targetFile = UiTestUtils.getPathToResource("new.sql", ProjectUpdaterTest.class);

        Map<String, Boolean> oneTimePrefs = Map.of(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES, true);

        DbSource dbSource = DbSource.fromFile(true, sourceFile, Consts.UTF_8, DatabaseType.PG, null, oneTimePrefs);
        DbSource dbTarget = DbSource.fromFile(true, targetFile, Consts.UTF_8, DatabaseType.PG, null, oneTimePrefs);

        final TreeDiffer newDiffer = new TreeDiffer(dbSource, dbTarget);

        newDiffer.run(new NullProgressMonitor());

        TreeElement root = newDiffer.getDiffTree();

        // filtered input
        differData.setUserSelection(root);

        Differ differ = new Differ(dbSource.getDbObject(), dbTarget.getDbObject(),
                root, true, Consts.UTC, DatabaseType.PG, null, oneTimePrefs);
        differ.setAdditionalDepciesSource(differData.getAdditionalDepciesSource(dbSource.getDbObject()));
        differ.setAdditionalDepciesTarget(differData.getAdditionalDepciesTarget(dbTarget.getDbObject()));

        try {
            differ.getDiffDirect();
            Assertions.fail("Expected to throw an exception");
        } catch (IllegalStateException e) {
            // expected behavior
        }
        Job job = differ.getDifferJob();

        job.schedule();
        job.join();

        UiTestUtils.compareResult(differ.getDiffDirect(), differData.getCaseNumber() + "_direct", DifferTest.class);
        UiTestUtils.compareResult(differ.getDiffReverse(), differData.getCaseNumber() + "_reverse", DifferTest.class);
    }
}

interface DifferData {
    void setUserSelection(TreeElement root);

    int getCaseNumber();

    default List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(AbstractDatabase source) {
        return new ArrayList<>();
    }

    default List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(AbstractDatabase target) {
        return new ArrayList<>();
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet)
 */
class DifferData1 implements DifferData {

    @Override
    public int getCaseNumber() {
        return 1;
    }

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t4").getChild("t4_c2_key").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>table (with no impact)
 */
class DifferData2 implements DifferData {

    @Override
    public int getCaseNumber() {
        return 2;
    }

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(AbstractDatabase source) {
        AbstractTable t = source.getSchema(Consts.PUBLIC).getTable("t1");
        AbstractSequence s = source.getSchema(Consts.PUBLIC).getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<>(s, t);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(AbstractDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 EDIT constraint selected (parent table is expected to
 * be "auto-selected" as yet). Adds to source and target depcy: view>column
 */
class DifferData3 implements DifferData {

    @Override
    public int getCaseNumber() {
        return 3;
    }

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("t1").getChild("t1_c2_key").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource(AbstractDatabase source) {
        AbstractColumn c = source.getSchema(Consts.PUBLIC).getTable("t1").getColumn("c1");
        AbstractSequence s = source.getSchema(Consts.PUBLIC).getSequence("t1_c1_seq");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<>(s, c);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(AbstractDatabase target) {
        return this.getAdditionalDepciesSource(target);
    }
}

/**
 * DifferData implementation with 1 NEW table selected.
 */
class DifferData4 implements DifferData {

    @Override
    public int getCaseNumber() {
        return 4;
    }

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild("test").getChild("test_table").setSelected(true);
    }
}

/**
 * DifferData implementation with 1 DELETE view selected.
 * Adds to target depcy: view>new schema
 */
class DifferData5 implements DifferData {

    @Override
    public int getCaseNumber() {
        return 5;
    }

    @Override
    public void setUserSelection(TreeElement root) {
        root.getChild(Consts.PUBLIC).getChild("v1").setSelected(true);
    }

    @Override
    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesTarget(AbstractDatabase target) {
        AbstractSchema s = target.getSchema("newschema");
        AbstractView v = target.getSchema(Consts.PUBLIC).getView("v1");
        Entry<PgStatement, PgStatement> arr = new AbstractMap.SimpleEntry<>(v, s);
        List<Entry<PgStatement, PgStatement>> list = new ArrayList<>();
        list.add(arr);
        return list;
    }
}
