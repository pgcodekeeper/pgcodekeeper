package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class ParserClass {

    public static final ParserClass ANTLR = new ParserClassAntlr();
    public static final ParserClass LEGACY = new ParserClassLegacy();
    
    public abstract PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database);
}

class ParserClassAntlr extends ParserClass {
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database) {
        return PgDumpLoader.loadDatabaseSchemaCoreAntLR(
                inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database);
    }
}

class ParserClassLegacy extends ParserClass {
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database) {
        return PgDumpLoader.loadDatabaseSchemaCore(inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database);
    }
}