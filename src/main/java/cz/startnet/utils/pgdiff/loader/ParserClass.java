package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
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
    
    public static ParserClass getParserAntlrReferences(IProgressMonitor monitor, int monitoringLevel, List<FunctionBodyContainer> funcBodyes) {
        return new ParserAntlrReferences(monitor, monitoringLevel, funcBodyes);
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
    
    private List<FunctionBodyContainer> funcBodyes;

    public ParserAntlrReferences(IProgressMonitor monitor, int monitoringLevel, List<FunctionBodyContainer> funcBodyes) {
        super(monitor, monitoringLevel);
        this.funcBodyes = funcBodyes;
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, String charsetName,
            boolean outputIgnoredStatements, boolean ignoreSlonyTriggers,
            PgDatabase database, Path path) {
        return PgDumpLoader.getObjReferences(
                inputStream, charsetName,
                outputIgnoredStatements, ignoreSlonyTriggers, database, path, monitor, monitoringLevel, funcBodyes);
    }
}
