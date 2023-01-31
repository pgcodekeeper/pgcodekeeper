package ru.taximaxim.codekeeper.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgSchema;

public final class TestUtils {

    public static final String RESOURCE_DUMP = "testing_dump.sql";
    public static final String RESOURCE_MS_DUMP = "testing_ms_dump.sql";
    public static final List<String> IGNORED_SCHEMAS_LIST = List.of("worker", "country", "ignore1", "ignore4vrw");

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        return loadTestDump(resource, c, args, true);
    }

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args, boolean analysis)
            throws IOException, InterruptedException {
        PgDumpLoader loader = new PgDumpLoader(() -> c.getResourceAsStream(resource),
                "test/" + c.getName() + '/' + resource, args);
        PgDatabase db = analysis ? loader.loadAndAnalyze() : loader.load();
        if (!loader.getErrors().isEmpty()) {
            throw new IOException("Test resource caused  loader errors!");
        }
        return db;
    }

    public static PgDatabase createDumpDB(boolean isPostgres) {
        PgDatabase db = new PgDatabase();
        AbstractSchema schema;
        if (isPostgres) {
            schema = new PgSchema(Consts.PUBLIC);
        } else {
            schema = new MsSchema(Consts.DBO);
        }
        db.addSchema(schema);
        db.setDefaultSchema(schema.getName());
        PgObjLocation loc = new PgObjLocation.Builder()
            .setObject(new GenericColumn(schema.getName(), DbObjType.SCHEMA))
            .build();
        schema.setLocation(loc);
        return db;
    }

    public static void runDiffSame(PgDatabase db, String template, PgDiffArguments args)
            throws IOException, InterruptedException {
        String script = new PgDiff(args).diffDatabaseSchemas(db, db, null);
        Assertions.assertEquals("", script.trim(), "File name template: " + template);
    }

    public static void compareResult(String script, String template,
            Class<?> clazz) throws IOException {
        Assertions.assertEquals(
                TestUtils.inputStreamToString(clazz.getResourceAsStream(
                        template + FILES_POSTFIX.DIFF_SQL))
                    .trim(),
                script.trim());
    }

    /**
     * @param inputStream
     *            stream converted to string, closed after use
     * @return String read from inputStream as UTF-8
     * @throws IOException
     */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        try (InputStream is = inputStream) {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(Consts.UTF_8);
        }
    }

    public static void createIgnoredSchemaFile(Path dir) throws IOException {
        String rule = "SHOW ALL \n"
                + "HIDE NONE country \n"
                + "HIDE NONE worker  \n"
                + "HIDE REGEX 'ignore.*' ";
        Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));
    }

    private TestUtils() {
    }
}
