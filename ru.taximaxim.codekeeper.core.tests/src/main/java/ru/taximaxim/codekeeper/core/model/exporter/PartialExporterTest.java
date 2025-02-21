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
package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.fileutils.TempDir;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;

/**
 * Test for partial export
 *
 * <!--
 * Below is the list of differences between DBs in TestPartialExportSource.sql
 * and TestPartialExportTarget.sql:
 *
 * DELETED (exist in Source only):
 *      (TABLE)         public.t2
 *      (TRIGGER)       public.t2.t2_trigger
 *      (INDEX)         public.t2.t2_c5_idx
 *      (CONSTRAINT)    public.t2.constr_t2
 *
 *      (SEQUENCE)      public.t2_c1_seq
 *
 *      (FUNCTION)      public.proc(integer)
 *      (FUNCTION)      public.proc(integer, timestamp without time zone)
 *
 *      (FUNCTION)      public.fun2()
 *
 *      (SCHEMA)        test
 *      (TABLE)         test.test_table
 *      (INDEX)         test.test_table.test_table_c1_idx
 *      (INDEX)         test.test_table.test_table_c2_idx
 *      (CONSTRAINT)    test.test_table.contr_testtable_c5
 *      (TABLE)         test.test_table_2
 *
 * MODIFIED:
 *      (TABLE)         public.rep2_workpool_data
 *      (TABLE)         public.table1
 *      (INDEX)         public.table1.idx_table1
 *      (CONSTRAINT)    public.table1.chk_table1 (GROUP: table1 changed as well)
 *      (TABLE)         public.t_auto_mark
 *      (TABLE)         public.t1
 *      (CONSTRAINT)    public.t1.t1_c2_key
 *      (TRIGGER)       public.t1.t1_trigger
 *      (TABLE)         public.t3
 *      (TABLE)         public.t4
 *      (CONSTRAINT)    public.t4.t4_c2_key
 *      (TABLE)         public.t5
 *      (INDEX)         public.t5.t5_c1_idx
 *      (FUNCTION)      public.fun1()
 *
 * NEW (exist in Target only):
 *      (FUNCTION)      public.fun3()
 *      (FUNCTION)      public.fun3(integer)
 *      (SCHEMA)        newschema
 *      (CONSTRAINT)    public.t3.constr_t3
 *      (TRIGGER)       public.t3.t3_trigger
 *      (VIEW)          public.v1
 *      (TABLE)         public.t/1
 *      (TABLE)         public.t_1
 *      (TABLE)         public.t?1
 *  -->
 *
 * @author ryabinin_av
 */
public class PartialExporterTest {

    private static AbstractDatabase dbSource;
    private static AbstractDatabase dbTarget;

    @BeforeAll
    static void initDiffTree() throws InterruptedException, IOException {
        String sourceFilename = "TestPartialExportSource.sql";
        String targetFilename = "TestPartialExportTarget.sql";
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(Consts.UTF_8);
        dbSource = TestUtils.loadTestDump(sourceFilename, PartialExporterTest.class, args, false);
        args = new PgDiffArguments();
        args.setInCharsetName(Consts.UTF_8);
        dbTarget = TestUtils.loadTestDump(targetFilename, PartialExporterTest.class, args, false);

        Assertions.assertNotNull(dbSource);
        Assertions.assertNotNull(dbTarget);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void testExportPartial(PartialExportInfo info) throws Exception {
        TreeElement tree = DiffTree.create(dbSource, dbTarget, null);
        Path exportDirFull = null;
        Path exportDirPartial = null;
        try  (TempDir dirFull = new TempDir("pgCodekeeper-test-files");
                TempDir dirPartial = new TempDir("pgCodekeeper-test-export-partial")) {
            exportDirFull = dirFull.get();
            exportDirPartial = dirPartial.get();

            // full export of source
            new ModelExporter(exportDirFull, dbSource, DatabaseType.PG, Consts.UTF_8).exportFull();
            // full export of source to target directory
            new ModelExporter(exportDirPartial, dbSource, DatabaseType.PG, Consts.UTF_8).exportFull();

            // get new db with selected changes
            info.setUserSelection(tree);
            Collection<TreeElement> list = new TreeFlattener()
                    .onlySelected()
                    .onlyEdits(dbSource, dbTarget)
                    .flatten(tree);
            // apply partial changes to the full database
            new ModelExporter(exportDirPartial, dbTarget, dbSource, DatabaseType.PG, list, Consts.UTF_8)
            .exportPartial();

            walkAndComare(exportDirFull, exportDirPartial, info);
        }
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new PartialExportInfoImpl1()),
                Arguments.of(new PartialExportInfoImpl2()),
                Arguments.of(new PartialExportInfoImpl3()),
                Arguments.of(new PartialExportInfoImpl4()),
                Arguments.of(new PartialExportInfoImpl5()),
                Arguments.of(new PartialExportInfoImpl6()),
                Arguments.of(new PartialExportInfoImpl7()),
                Arguments.of(new PartialExportInfoImpl8()),
                Arguments.of(new PartialExportInfoImpl9()),
                Arguments.of(new PartialExportInfoImpl10()),
                Arguments.of(new PartialExportInfoImpl11()),
                Arguments.of(new PartialExportInfoImpl12()),
                Arguments.of(new PartialExportInfoImpl13()),
                Arguments.of(new PartialExportInfoImpl14()),
                Arguments.of(new PartialExportInfoImpl15()),
                Arguments.of(new PartialExportInfoImpl16()),
                Arguments.of(new PartialExportInfoImpl17()),
                Arguments.of(new PartialExportInfoImpl18()),
                Arguments.of(new PartialExportInfoImpl19()),
                Arguments.of(new PartialExportInfoImpl20()),
                Arguments.of(new PartialExportInfoImpl21()));
    }

    private void walkAndComare(Path exportDirFull, Path exportDirPartial, PartialExportInfo info) throws IOException {
        // first compare full export to partial
        Map<String, String> modifiedFiles = info.modifiedFiles();
        List<String> newFiles = info.newFiles();
        List<String> deletedFiles = info.deletedFiles();
        Files.walkFileTree(exportDirFull, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(
                        exportDirFull, exportDirPartial,
                        modifiedFiles, newFiles, deletedFiles, true));

        Assertions.assertTrue(
                modifiedFiles.isEmpty() && deletedFiles.isEmpty(), "Not all objects in modified/deleted lists have been walked:\n"
                        + modifiedFiles + '\n' + deletedFiles);

        // then compare partial export to full
        modifiedFiles = info.modifiedFiles();
        newFiles = info.newFiles();
        deletedFiles = info.deletedFiles();

        Files.walkFileTree(exportDirPartial, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new PartialExportTestFileVisitor(
                        exportDirPartial, exportDirFull,
                        modifiedFiles, newFiles, deletedFiles, false));

        Assertions.assertTrue(
                modifiedFiles.isEmpty() && newFiles.isEmpty(), "Not all objects in modified/new lists have been walked:\n"
                        + modifiedFiles + '\n' + newFiles);
    }
}

/**
 * Helper class that returns list of "user-selected" TreeElements and lists of
 * relative filenames of objects that should have been affected by partial export
 */
abstract class PartialExportInfo {

    public abstract void setUserSelection(TreeElement diffTree);

    public Map<String, String> modifiedFiles(){
        return new HashMap<>();
    }
    public List<String> newFiles(){
        return Collections.emptyList();
    }
    public List<String> deletedFiles(){
        return Collections.emptyList();
    }
}

/**
 * Select modified constraint
 */
class PartialExportInfoImpl1 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t4").getChild("t4_c2_key").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t4.sql", "106afb720883502cfec4ba9db5da8289");
        return m;
    }
}

/**
 * Select deleted table with constraint
 */
class PartialExportInfoImpl2 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.setSelected(true);
        table.getChild("constr_t2").setSelected(true);

    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t2.sql"));
    }
}

/**
 * Select modified trigger
 */
class PartialExportInfoImpl3 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t2").getChild("t2_trigger").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "46255b7358a9dff55b672275d3840285");
        return m;
    }
}

/**
 * Select deleted function
 */
class PartialExportInfoImpl4 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("fun2()").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun2.sql"));
    }
}

/**
 * Select modified function
 */
class PartialExportInfoImpl5 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("fun1()").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/FUNCTION/fun1.sql", "a2a5c040544ebf26c6aacadcebe938f9");
        return m;
    }
}

/**
 * Select modified table
 */
class PartialExportInfoImpl6 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t5").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t5.sql", "96bbbc209be7a2f2075513faaac10f4e");
        return m;
    }
}

/**
 * Select new function
 */
class PartialExportInfoImpl7 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("fun3()").setSelected(true);
    }

    @Override
    public List<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun3.sql"));
    }
}

/**
 * Select new function group
 */
class PartialExportInfoImpl8 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("fun3()").setSelected(true);
        schema.getChild("fun3(integer)").setSelected(true);
    }

    @Override
    public List<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/fun3.sql"));
    }
}

/**
 * Select new view
 */
class PartialExportInfoImpl9 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("v1").setSelected(true);
    }

    @Override
    public List<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/VIEW/v1.sql"));
    }
}

/**
 * Select new constraint in modified table
 */
class PartialExportInfoImpl10 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t3").getChild("constr_t3").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t3.sql", "13b6c5a48316d7371be416723027aadf");
        return m;
    }
}


/**
 * Select new schema
 */
class PartialExportInfoImpl11 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("newschema").setSelected(true);
    }

    @Override
    public List<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/newschema/newschema.sql"));
    }
}

/**
 * Select deleted table in another schema
 */
class PartialExportInfoImpl12 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("test").getChild("test_table").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql"));
    }
}

/**
 * Select 2 deleted table
 */
class PartialExportInfoImpl13 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement schema = diffTree.getChild("test");
        schema.getChild("test_table").setSelected(true);
        schema.getChild("test_table_2").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql", "SCHEMA/test/TABLE/test_table_2.sql"));
    }
}

/**
 * Select deleted schema
 */
class PartialExportInfoImpl14 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("test").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/test/TABLE/test_table.sql", "SCHEMA/test/TABLE/test_table_2.sql", "SCHEMA/test/test.sql"));
    }
}

/**
 * Select deleted function group
 */
class PartialExportInfoImpl15 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("proc(integer)").setSelected(true);
        schema.getChild("proc(integer, timestamp without time zone)").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/FUNCTION/proc.sql"));
    }
}

/**
 * Select deleted index
 */
class PartialExportInfoImpl16 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t2").getChild("t2_c5_idx").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "db4dbe900e6338850a2957a9d61ef253");
        return m;
    }
}

/**
 * Select deleted constraint
 */
class PartialExportInfoImpl17 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t2").getChild("constr_t2").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "e5fc35e43a007612b1305d65ccbeabd8");
        return m;
    }
}

/**
 * Select deleted constraint and trigger from 1 table
 */
class PartialExportInfoImpl18 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.getChild("constr_t2").setSelected(true);
        table.getChild("t2_trigger").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "8c3e5f36294f98ff4c2b147061d33689");
        return m;
    }
}

/**
 * Select deleted constraint, index and trigger from 1 table
 */
class PartialExportInfoImpl19 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement table = diffTree.getChild("public").getChild("t2");
        table.getChild("constr_t2").setSelected(true);
        table.getChild("t2_trigger").setSelected(true);
        table.getChild("t2_c5_idx").setSelected(true);
    }

    @Override
    public Map<String, String> modifiedFiles() {
        Map<String, String> m = new HashMap<>(1);
        m.put("SCHEMA/public/TABLE/t2.sql", "3785a71f4f8f286b41e3751046934f38");
        return m;
    }
}

/**
 * Select deleted table with constraint, index and trigger
 */

class PartialExportInfoImpl20 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        diffTree.getChild("public").getChild("t2").setSelected(true);
    }

    @Override
    public List<String> deletedFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t2.sql"));
    }
}

/**
 * Select new tables
 */
class PartialExportInfoImpl21 extends PartialExportInfo {

    @Override
    public void setUserSelection(TreeElement diffTree) {
        TreeElement schema = diffTree.getChild("public");
        schema.getChild("t?1").setSelected(true);
        schema.getChild("t/1").setSelected(true);
        schema.getChild("t_1").setSelected(true);
    }

    @Override
    public List<String> newFiles() {
        return new LinkedList<>(Arrays.asList("SCHEMA/public/TABLE/t_1.sql"));
    }
}