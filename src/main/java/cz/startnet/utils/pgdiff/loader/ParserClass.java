package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;
import java.nio.file.Path;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class ParserClass {

    IProgressMonitor monitor;
    int monitoringLevel;
    
    public static ParserClass getAntlr(IProgressMonitor monitor, int monitoringLevel){
        return new ParserClassAntlr(monitor, monitoringLevel);
    }
    
    public static ParserClass getLegacy(IProgressMonitor monitor, int monitoringLevel){
        return new ParserClassLegacy(monitor, monitoringLevel);
    }
    
    public static ParserClass getParserAntlrReferences(IProgressMonitor monitor, int monitoringLevel) {
        return new ParserAntlrReferences(monitor, monitoringLevel);
    }
    
    public ParserClass(IProgressMonitor monitor, int monitoringLevel) {
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel > 0 ? monitoringLevel : 1;
    }
    
    public abstract PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path);

    public void setMonitor(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    public void setMonitoringLevel(int monitoringLevel) {
        this.monitoringLevel = monitoringLevel;
    }
}

class ParserClassAntlr extends ParserClass {
    
    public ParserClassAntlr(IProgressMonitor monitor, int monitoringLevel) {
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
    
    public ParserClassLegacy(IProgressMonitor monitor, int monitoringLevel) {
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

class ParserAntlrReferences extends ParserClass {
    
    public ParserAntlrReferences(IProgressMonitor monitor, int monitoringLevel) {
        super(monitor, monitoringLevel);
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.getObjReferences(
                inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database, path, monitor, monitoringLevel);
    }
}
