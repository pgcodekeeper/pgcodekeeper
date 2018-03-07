/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.ReferenceListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.SecondAnalyze;

/**
 * Loads PostgreSQL dump into classes.
 *
 * @author fordfrog
 */
public class PgDumpLoader implements AutoCloseable {

    /**
     * Loading order and directory names of the objects in exported DB schemas.
     * NOTE: constraints, triggers and indexes are now stored in tables,
     * those directories are here for backward compatibility only
     */
    protected static final String[] DIR_LOAD_ORDER = new String[] { "TYPE",
            "DOMAIN", "SEQUENCE", "FUNCTION", "TABLE", "CONSTRAINT", "INDEX",
            "TRIGGER", "VIEW" };

    private final InputStream input;
    private final String inputObjectName;
    private final PgDiffArguments args;

    private final IProgressMonitor monitor;
    private final int monitoringLevel;

    private final List<AntlrError> errors = new ArrayList<>();

    private boolean loadSchema = true;
    private boolean loadReferences;
    private List<FunctionBodyContainer> funcBodyReferences;

    public List<AntlrError> getErrors() {
        return errors;
    }

    public void setLoadSchema(boolean loadSchema) {
        this.loadSchema = loadSchema;
    }

    public void setLoadReferences(boolean loadReferences) {
        this.loadReferences = loadReferences;
    }

    public List<FunctionBodyContainer> getFuncBodyReferences() {
        return funcBodyReferences;
    }

    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel) {
        this.input = input;
        this.inputObjectName = inputObjectName;
        this.args = args;
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel;
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     */
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor) {
        this(input, inputObjectName, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     */
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args) {
        this(input, inputObjectName, args, new NullProgressMonitor(), 0);
    }

    /**
     * This constructor creates {@link InputStream} using inputFile parameter.
     * Call {@link #close()} after this {@link PgDumpLoader} instance is no longer needed,
     * or wrap usage of the instance with try-with-resources.
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args,
            IProgressMonitor monitor, int monitoringLevel) throws IOException {
        this(new FileInputStream(inputFile), inputFile.toString(), args,
                monitor, monitoringLevel);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments, IProgressMonitor)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args,
            IProgressMonitor monitor) throws IOException {
        this(inputFile, args, monitor, 1);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args) throws IOException {
        this(inputFile, args, new NullProgressMonitor(), 0);
    }

    /**
     * The same as {@link #load(boolean)} with <code>false<code> argument.
     */
    public PgDatabase load() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);
        load(d);
        dbAnalyze(d);
        return d;
    }

    protected PgDatabase load(PgDatabase intoDb) throws IOException, InterruptedException {
        PgDiffUtils.checkCancelled(monitor);

        List<SQLParserBaseListener> listeners = new ArrayList<>();
        if (loadSchema) {
            listeners.add(new CustomSQLParserListener(intoDb, inputObjectName, errors, monitor));
        }
        if (loadReferences) {
            ReferenceListener refListener = new ReferenceListener(intoDb, inputObjectName, monitor);
            funcBodyReferences = refListener.getFunctionBodies();
            listeners.add(refListener);
        }
        AntlrParser.parseSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                monitor, monitoringLevel, listeners);
        return intoDb;
    }

    @Override
    public void close() throws IOException {
        input.close();
    }

    /**
     * Loads database schema from a ModelExporter directory tree.
     *
     * @param dirPath path to the directory tree root
     *
     * @return database schema
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromDirTree(String dirPath,
            PgDiffArguments arguments, IProgressMonitor monitor, List<AntlrError> errors)
                    throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase(false);
        db.setArguments(arguments);
        File dir = new File(dirPath);

        // step 1
        // read files in schema folder, add schemas to db
        for (ApgdiffConsts.WORK_DIR_NAMES dirEnum : ApgdiffConsts.WORK_DIR_NAMES.values()) {
            loadSubdir(dir, arguments, dirEnum.name(), db, monitor, errors);
        }

        File schemasCommonDir = new File(dir, ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.isDirectory()) {
            return db;
        }

        // step 2
        // read out schemas names, and work in loop on each
        for (PgSchema schema : db.getSchemas()) {
            File schemaFolder = new File(schemasCommonDir, ModelExporter.getExportedFilename(schema));
            if (schemaFolder.isDirectory()) {
                for (String dirSub : DIR_LOAD_ORDER) {
                    loadSubdir(schemaFolder, arguments, dirSub, db, monitor, errors);
                }
            }
        }

        dbAnalyze(db);
        return db;
    }

    private static void loadSubdir(File dir, PgDiffArguments arguments, String sub, PgDatabase db,
            IProgressMonitor monitor, List<AntlrError> errors)
                    throws InterruptedException, IOException {
        File subDir = new File(dir, sub);
        if (subDir.exists() && subDir.isDirectory()) {
            File[] files = subDir.listFiles();
            loadFiles(files, arguments, db, monitor, errors);
        }
    }

    private static void loadFiles(File[] files, PgDiffArguments arguments,
            PgDatabase db, IProgressMonitor monitor, List<AntlrError> errors)
                    throws IOException, InterruptedException {
        Arrays.sort(files);
        for (File f : files) {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".sql")) {
                List<AntlrError> errList = null;
                try (PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor)) {
                    errList = loader.getErrors();
                    loader.load(db);
                } finally {
                    if (errors != null && errList != null && !errList.isEmpty()) {
                        errors.addAll(errList);
                    }
                }
            }
        }
    }

    protected static void dbAnalyze(PgDatabase db) {
        for (SimpleEntry<PgStatement, ParserRuleContext> entry : db.getContextsForAnalyze()) {
            PgStatement stmt = entry.getKey();
            ParserRuleContext ctx = entry.getValue();
            DbObjType stmtType = stmt.getStatementType();

            String schemaName = ((PgStatementWithSearchPath) stmt).getContainingSchema().getName();

            switch (stmtType) {
            case VIEW:
                UtilAnalyzeExpr.analyze(new SelectStmt((Select_stmtContext) ctx),
                        new Select(schemaName), stmt);
                break;
            case RULE:
                Create_rewrite_statementContext createRuleCtx = (Create_rewrite_statementContext) ctx;
                PgRule rule = (PgRule)stmt;

                UtilAnalyzeExpr.analyzeRulesWhere(createRuleCtx, rule, schemaName);

                if (!rule.getCommands().isEmpty()) {
                    for (Rewrite_commandContext cmd : createRuleCtx.commands) {
                        UtilAnalyzeExpr.analyzeRulesCommand(cmd, rule, schemaName);
                    }
                }
                break;
            case TRIGGER:
                UtilAnalyzeExpr.analyzeTriggersWhen((VexContext) ctx, (PgTrigger)stmt, schemaName);
                break;
            case INDEX:
                ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(schemaName, db);
                valExptWithNmspc.addRawTableReference(new GenericColumn(
                        schemaName, ((PgIndex)stmt).getTableName(), DbObjType.TABLE));
                UtilAnalyzeExpr.analyzeSecond((VexContext)ctx, valExptWithNmspc, stmt);
                break;
            case FUNCTION:
            case DOMAIN:
            case COLUMN:
                UtilAnalyzeExpr.analyze((VexContext)ctx, new ValueExpr(schemaName), stmt);
                break;
            case CONSTRAINT:
                UtilAnalyzeExpr.analyzeConstraint((Constr_bodyContext)ctx, schemaName, (PgConstraint)stmt, db);
                break;
            default:
                throw new IllegalStateException("The analyze for the case is not defined!"); //$NON-NLS-1$
            }
        }

        SecondAnalyze.goThroughGraphForAnalyze(db);
    }
}