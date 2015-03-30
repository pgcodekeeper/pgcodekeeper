package cz.startnet.utils.pgdiff.loader;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class ParserClass {

    protected IProgressMonitor monitor;
    protected int monitoringLevel;
    
    public static ParserClass getAntlr(IProgressMonitor monitor, int monitoringLevel){
        return new ParserClassAntlr(monitor, monitoringLevel);
    }
    
    public static ParserClass getLegacy(IProgressMonitor monitor, int monitoringLevel){
        return new ParserClassLegacy(monitor, monitoringLevel);
    }
    
    public static ParserClass getParserAntlrReferences(IProgressMonitor monitor,
            int monitoringLevel, List<FunctionBodyContainer> funcBodies) {
        return new ParserAntlrReferences(monitor, monitoringLevel, funcBodies);
    }
    
    protected ParserClass(IProgressMonitor monitor, int monitoringLevel) {
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel > 0 ? monitoringLevel : 1;
    }
    
    public abstract PgDatabase parse(InputStream inputStream, PgDiffArguments arguments,
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
    public PgDatabase parse(InputStream inputStream, PgDiffArguments arguments,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCoreAntLR(
                inputStream, arguments, database, path,
                monitor, monitoringLevel);
    }
}

class ParserClassLegacy extends ParserClass {
    
    public ParserClassLegacy(IProgressMonitor monitor, int monitoringLevel) {
        super(monitor, monitoringLevel);
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, PgDiffArguments arguments,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadDatabaseSchemaCore(inputStream, arguments, database);
    }
}

class ParserAntlrReferences extends ParserClass {
    
    private List<FunctionBodyContainer> funcBodies;

    public ParserAntlrReferences(IProgressMonitor monitor, int monitoringLevel,
            List<FunctionBodyContainer> funcBodies) {
        super(monitor, monitoringLevel);
        this.funcBodies = funcBodies;
    }
    
    @Override
    public PgDatabase parse(InputStream inputStream, PgDiffArguments arguments,
            PgDatabase database, Path path) {
        return PgDumpLoader.loadObjReferences(
                inputStream, arguments, database, path,
                monitor, monitoringLevel, funcBodies);
    }
}
