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
package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.junit.jupiter.api.Assertions;

import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ch.ChSchema;
import ru.taximaxim.codekeeper.core.schema.ms.MsSchema;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;

public final class TestUtils {

    static {
        // explicit locale for tests with localization
        Locale.setDefault(Locale.ENGLISH);
    }

    public static final String RESOURCE_DUMP = "testing_dump.sql";
    public static final String RESOURCE_MS_DUMP = "testing_ms_dump.sql";
    public static final List<String> IGNORED_SCHEMAS_LIST = List.of("worker", "country", "ignore1", "ignore4vrw");

    public static AbstractDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        return loadTestDump(resource, c, args, true);
    }

    public static AbstractDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args, boolean analysis)
            throws IOException, InterruptedException {
        PgDumpLoader loader = new PgDumpLoader(() -> c.getResourceAsStream(resource),
                "test/" + c.getName() + '/' + resource, args);
        AbstractDatabase db = analysis ? loader.loadAndAnalyze() : loader.load();
        Assertions.assertEquals("[]", loader.getErrors().toString(), "Test resource caused loader errors!");
        return db;
    }

    public static AbstractDatabase createDumpDB(DatabaseType dbType) {
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(dbType);
        AbstractDatabase db = DatabaseLoader.createDb(args);
        AbstractSchema schema;
        switch (dbType) {
        case PG:
            schema = new PgSchema(Consts.PUBLIC);
            break;
        case MS:
            schema = new MsSchema(Consts.DBO);
            break;
        case CH:
            schema = new ChSchema(Consts.CH_DEFAULT_DB);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
        db.addSchema(schema);
        db.setDefaultSchema(schema.getName());
        PgObjLocation loc = new PgObjLocation.Builder()
                .setObject(new GenericColumn(schema.getName(), DbObjType.SCHEMA))
                .build();
        schema.setLocation(loc);
        return db;
    }

    public static void runDiffSame(AbstractDatabase db, String template, PgDiffArguments args)
            throws IOException, InterruptedException {
        String script = new PgDiff(args).diff(db, db, null);
        Assertions.assertEquals("", script.trim(), "File name template: " + template);
    }

    public static void compareResult(String script, String template,
            Class<?> clazz) throws IOException {
        Assertions.assertEquals(
                readResource(template + FILES_POSTFIX.DIFF_SQL, clazz).trim(),
                script.trim());
    }

    public static String readResource(String resourceName, Class<?> clazz) throws IOException {
        try (InputStream is = clazz.getResourceAsStream(resourceName)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static void createIgnoredSchemaFile(Path dir) throws IOException {
        String rule = """
            SHOW ALL
            HIDE NONE country
            HIDE NONE worker
            HIDE REGEX 'ignore.*'""";
        Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));
    }

    public static Path getPathToResource(String resourceName, Class<?> clazz) throws URISyntaxException, IOException {
        URL url = clazz.getResource(resourceName);
        return Paths.get(URIUtil.toURI("file".equals(url.getProtocol()) ? url : FileLocator.toFileURL(url)));
    }

    static void runDiff(String fileNameTemplate, DatabaseType dbType, Class<?> clazz) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(dbType);
        String script = getScript(fileNameTemplate, args, clazz);
        TestUtils.compareResult(script, fileNameTemplate, clazz);
    }

    static String getScript(String fileNameTemplate, PgDiffArguments args, Class<?> clazz)
            throws IOException, InterruptedException {
        return getScript(fileNameTemplate, args, clazz, false);
    }

    static String getScript(String fileNameTemplate, PgDiffArguments args, Class<?> clazz, boolean needTransaction)
            throws IOException, InterruptedException {
        AbstractDatabase dbOld = TestUtils.loadTestDump(fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, clazz, args);
        TestUtils.runDiffSame(dbOld, fileNameTemplate, args);

        AbstractDatabase dbNew = TestUtils.loadTestDump(fileNameTemplate + FILES_POSTFIX.NEW_SQL, clazz, args);
        TestUtils.runDiffSame(dbNew, fileNameTemplate, args);

        args.setAddTransaction(needTransaction);
        return new PgDiff(args).diff(dbOld, dbNew, null);
    }

    /**
     * Diff test with partial selection, required 5 file: <br>
     *  - file_name_original.sql - old database state <br>
     *  - file_name_new.sql - new database state<br>
     *  - file_name_usr_sel_original.sql - old selected objects state<br>
     *  - file_name_usr_sel_new.sql - new selected objects state<br>
     *  - file_name_usr_sel_diff.sql - expected diff script<br>
     * <br>
     * file_name_usr_sel = userSelTemplate
     */
    public static void testDepcy(String userSelTemplate, boolean isEnableFunctionBodiesDependencies,
            DatabaseType dbType, Class<?> clazz)
                    throws IOException, InterruptedException {
        AbstractDatabase oldDatabase;
        AbstractDatabase newDatabase;
        AbstractDatabase oldDbFull;
        AbstractDatabase newDbFull;
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(dbType);
        args.setEnableFunctionBodiesDependencies(isEnableFunctionBodiesDependencies);

        String dbTemplate = userSelTemplate.replaceAll("_usr.*", "");
        if (userSelTemplate.equals(dbTemplate)) {
            oldDatabase = TestUtils.loadTestDump(
                    userSelTemplate + FILES_POSTFIX.ORIGINAL_SQL, clazz, args);
            newDatabase = TestUtils.loadTestDump(
                    userSelTemplate + FILES_POSTFIX.NEW_SQL, clazz, args);
            oldDbFull = oldDatabase;
            newDbFull = newDatabase;
        } else {
            oldDatabase = TestUtils.loadTestDump(
                    userSelTemplate + FILES_POSTFIX.ORIGINAL_SQL, clazz, args, false);
            newDatabase = TestUtils.loadTestDump(
                    userSelTemplate + FILES_POSTFIX.NEW_SQL, clazz, args, false);
            oldDbFull = TestUtils.loadTestDump(
                    dbTemplate + FILES_POSTFIX.ORIGINAL_SQL, clazz, args);
            newDbFull = TestUtils.loadTestDump(
                    dbTemplate + FILES_POSTFIX.NEW_SQL, clazz, args);
        }

        TestUtils.runDiffSame(oldDbFull, dbTemplate, args);
        TestUtils.runDiffSame(newDbFull, dbTemplate, args);

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase, null);
        tree.setAllChecked();
        String script = new PgDiff(args).diffDatabaseSchemasAdditionalDepcies(
                tree, oldDbFull, newDbFull, null, null);

        TestUtils.compareResult(script, userSelTemplate, clazz);
    }

    private TestUtils() {
    }
}
