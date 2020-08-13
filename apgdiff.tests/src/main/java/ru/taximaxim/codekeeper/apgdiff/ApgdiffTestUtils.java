package ru.taximaxim.codekeeper.apgdiff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        return loadTestDump(resource, c, args, true);
    }

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args, boolean analysis)
            throws IOException, InterruptedException {
        PgDumpLoader loader =  new PgDumpLoader(() -> c.getResourceAsStream(resource),
                "test:/" + c.getName() + '/' + resource, args);
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
        String sbExpDiff = getResourceFileAsString(template + FILES_POSTFIX.DIFF_SQL, clazz);

        Assert.assertEquals("File name template: " + template,
                sbExpDiff.trim(), script.trim());
    }

    public static String getResourceFileAsString(String resource, Class<?> clazz)
            throws IOException {
        try (InputStreamReader isr = new InputStreamReader(
                clazz.getResourceAsStream(resource), StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
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


    private ApgdiffTestUtils() {
    }
}
