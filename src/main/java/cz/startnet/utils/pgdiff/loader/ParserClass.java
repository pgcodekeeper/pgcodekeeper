package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;
import java.nio.file.Path;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class ParserClass {

    final SubMonitor monitor;
    final int monitoringLevel;
    
    public static ParserClass getAntlr(SubMonitor monitor, int monitoringLevel){
        return new ParserClassAntlr(monitor, monitoringLevel);
    }
    
    public static ParserClass getLegacy(SubMonitor monitor, int monitoringLevel){
        return new ParserClassLegacy(monitor, monitoringLevel);
    }
    
    public ParserClass(SubMonitor monitor, int monitoringLevel) {
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel > 0 ? monitoringLevel : 1;
    }
    
    public abstract PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path);
}

class ParserClassAntlr extends ParserClass {
    
    public ParserClassAntlr(SubMonitor monitor, int monitoringLevel) {
        super(monitor, monitoringLevel);
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCoreAntLR(
                inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database, path, monitor, monitoringLevel);
    }
}

class ParserClassLegacy extends ParserClass {
    
    public ParserClassLegacy(SubMonitor monitor, int monitoringLevel) {
        super(monitor, monitoringLevel);
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCore(inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database);
    }
}