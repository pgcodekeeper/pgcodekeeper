package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;
import java.nio.file.Path;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class ParserClass {

    public static final ParserClass ANTLR = new ParserClassAntlr();
    public static final ParserClass LEGACY = new ParserClassLegacy();
    
    public abstract PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path);
}

class ParserClassAntlr extends ParserClass {
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCoreAntLR(
                inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database, path);
    }
}

class ParserClassLegacy extends ParserClass {
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCore(inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database);
    }
}