package ru.taximaxim.codekeeper.apgdiff;

import java.io.IOException;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;

public final class ApgdiffTestUtils {

    public static PgDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        try (PgDumpLoader loader = new PgDumpLoader(c.getResourceAsStream(resource),
                "test:/" + c.getName() + '/' + resource, args)) {
            return loader.load();
        }
    }

    public static PgDatabase createDumpDB() {
        PgDatabase db = new PgDatabase();
        PgSchema schema = new PgSchema(ApgdiffConsts.PUBLIC, "");
        db.addSchema(schema);
        db.setDefaultSchema(ApgdiffConsts.PUBLIC);
        return db;
    }

    private ApgdiffTestUtils() {
    }
}
