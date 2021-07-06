package ru.taximaxim.codekeeper.apgdiff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import cz.startnet.utils.pgdiff.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class ApgdiffTestUtils {

    public static final String RESOURCE_DUMP = "testing_dump.sql";
    public static final String RESOURCE_MS_DUMP = "testing_ms_dump.sql";
    public static final List<String> IGNORED_SCHEMAS_LIST = Collections.unmodifiableList(Arrays.asList(
            "worker", "country", "ignore1", "ignore4vrw"));

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        return loadTestDump(resource, c, args, true);
    }

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args, boolean analysis)
            throws IOException, InterruptedException {
        PgDumpLoader loader =  new PgDumpLoader(() -> c.getResourceAsStream(resource),
                "test/" + c.getName() + '/' + resource, args);
        PgDatabase db = analysis ? loader.loadAndAnalyze() : loader.load();
        if (!loader.getErrors().isEmpty()) {
            throw new IOException("Test resource caused  loader errors!");
        }
        return db;
    }

    public static PgDatabase createDumpDB() {
        PgDatabase db = new PgDatabase();
        AbstractSchema schema = new PgSchema(ApgdiffConsts.PUBLIC);
        db.addSchema(schema);
        db.setDefaultSchema(ApgdiffConsts.PUBLIC);
        schema.setLocation(new PgObjLocation(
                new GenericColumn(schema.getName(), DbObjType.SCHEMA)));
        return db;
    }

    public static PgDatabase createDumpMsDB() {
        PgDatabase db = new PgDatabase();
        AbstractSchema schema = new MsSchema(ApgdiffConsts.DBO);
        db.addSchema(schema);
        db.setDefaultSchema(ApgdiffConsts.DBO);
        schema.setLocation(new PgObjLocation(
                new GenericColumn(schema.getName(), DbObjType.SCHEMA)));
        return db;
    }

    public static void runDiffSame(PgDatabase db, String template, PgDiffArguments args)
            throws IOException, InterruptedException {
        String script = new PgDiff(args).diffDatabaseSchemas(db, db, null);
        Assert.assertEquals("File name template: " + template, "", script.trim());
    }

    public static void compareResult(String script, String template,
            Class<?> clazz) throws IOException {
        Assert.assertEquals("File name template: " + template,
                ApgdiffTestUtils.inputStreamToString(clazz.getResourceAsStream(
                        template + FILES_POSTFIX.DIFF_SQL)).trim(),
                script.trim());
    }

    public static Iterable<Object[]> getParameters(Object[][] objects) {
        List<Object[]> p = Arrays.asList(objects);
        int maxLength = p.stream()
                .mapToInt(oo -> oo.length)
                .max().getAsInt();
        return p.stream()
                .map(oo -> oo.length < maxLength ? Arrays.copyOf(oo, maxLength) : oo)
                ::iterator;
    }

    /**
     * @param inputStream stream converted to string, closed after use
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
            return result.toString(ApgdiffConsts.UTF_8);
        }
    }

    private ApgdiffTestUtils() {
    }

    public static void createIgnoredSchemaFile(Path dir) throws IOException {
        String rule = "SHOW ALL \n"
                + "HIDE NONE country \n"
                + "HIDE NONE worker  \n"
                + "HIDE REGEX 'ignore.*' ";
        Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));
    }
}
