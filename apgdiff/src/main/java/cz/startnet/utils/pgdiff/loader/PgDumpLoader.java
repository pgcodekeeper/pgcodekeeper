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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.RulesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TriggersReader;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.ReferenceListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

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

    protected IFile file;

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
     * This constructor sets the monitoring level to the default of 1.
     * @throws CoreException
     */
    public PgDumpLoader(IFile ifile, PgDiffArguments args, IProgressMonitor monitor)
            throws CoreException {
        this(ifile.getContents(), ifile.getLocation().toOSString(), args, monitor, 1);
        file = ifile;
    }

    /**
     * The same as {@link #load(boolean)} with <code>false<code> argument.
     */
    public PgDatabase load() throws IOException, InterruptedException, LicenseException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);
        load(d);
        args.getLicense().verifyDb(d);
        return d;
    }

    protected PgDatabase load(PgDatabase intoDb) throws IOException, InterruptedException {
        PgDiffUtils.checkCancelled(monitor);

        List<SQLParserBaseListener> listeners = new ArrayList<>();
        if (loadSchema) {
            listeners.add(new CustomSQLParserListener(intoDb, errors, monitor));
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
            PgDiffArguments arguments, IProgressMonitor monitor, Map<String, List<AntlrError>> errors)
                    throws InterruptedException, IOException, LicenseException {
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

        arguments.getLicense().verifyDb(db);
        return db;
    }

    private static void loadSubdir(File dir, PgDiffArguments arguments, String sub, PgDatabase db,
            IProgressMonitor monitor, Map<String, List<AntlrError>> errors)
                    throws InterruptedException, IOException {
        File subDir = new File(dir, sub);
        if (subDir.exists() && subDir.isDirectory()) {
            File[] files = subDir.listFiles();
            loadFiles(files, arguments, db, monitor, errors);
        }
    }

    private static void loadFiles(File[] files, PgDiffArguments arguments,
            PgDatabase db, IProgressMonitor monitor, Map<String, List<AntlrError>> errors)
                    throws IOException, InterruptedException {
        Arrays.sort(files);
        for (File f : files) {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".sql")) {
                try (PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor)) {
                    loader.load(db);
                    if (errors != null) {
                        errors.put(f.getPath(), loader.getErrors());
                    }
                }
            }
        }
    }

    /**
     * Loads database schema from a ModelExporter directory tree.
     *
     * @return database schema
     */
    public static PgDatabase loadDatabaseSchemaFromIProject(IProject iProject,
            PgDiffArguments arguments, IProgressMonitor monitor,
            List<FunctionBodyContainer> funcBodies, Map<String, List<AntlrError>> errors)
                    throws InterruptedException, IOException, LicenseException, CoreException {
        PgDatabase db = new PgDatabase(false);
        db.setArguments(arguments);
        for (WORK_DIR_NAMES workDirName : WORK_DIR_NAMES.values()) {
            IFolder iFolder = iProject.getFolder(workDirName.name());
            if (iFolder.exists()) {
                loadSubdir(iFolder, db, monitor, funcBodies, errors);
            }
        }

        IFolder schemasCommonDir = iProject.getFolder(WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.exists()) {
            return db;
        }

        // step 2
        // read out schemas names, and work in loop on each
        for (PgSchema schema : db.getSchemas()) {
            IFolder schemaFolder = schemasCommonDir.getFolder(ModelExporter.getExportedFilename(schema));
            for (String dirSub : DIR_LOAD_ORDER) {
                IFolder iFolder = schemaFolder.getFolder(dirSub);
                if (iFolder.exists()) {
                    loadSubdir(iFolder, db, monitor, funcBodies, errors);
                }
            }
        }

        dbAnalyze(db);

        arguments.getLicense().verifyDb(db);
        return db;
    }

    public static void dbAnalyze(PgDatabase db) {
        List<SimpleEntry<PgStatement, Set<ParserRuleContext>>> stmtCtxList = db.getContextsForAnalyze();

        Map<PgStatement, Set<ParserRuleContext>> stmtCtxMap = new HashMap<>();
        for (SimpleEntry<PgStatement, Set<ParserRuleContext>> entry : stmtCtxList) {
            stmtCtxMap.put(entry.getKey(), entry.getValue());
        }

        Set<ParserRuleContext> setCtx = null;
        for (PgSchema s : db.getSchemas()) {
            for (PgView v : s.getViews()) {
                setCtx = stmtCtxMap.get(v);

                if (!setCtx.isEmpty()) {
                    UtilExpr.analyze(new SelectStmt((Select_stmtContext) setCtx.iterator().next()),
                            new Select(s.getName()), v);
                }
            }

            for (PgTable t : s.getTables()) {
                for (PgRule r : t.getRules()) {
                    setCtx = stmtCtxMap.get(r);
                    Create_rewrite_statementContext createRuleCtx = (Create_rewrite_statementContext) setCtx.iterator().next();

                    RulesReader.analyzeRewriteCreateStmtCtx(createRuleCtx, r, s.getName());

                    if (!r.getCommands().isEmpty()) {
                        for (Rewrite_commandContext cmd : createRuleCtx.commands) {
                            RulesReader.analyzeRewriteCommandCtx(cmd, r, s.getName());
                        }
                    }
                }

                for (PgTrigger tr : t.getTriggers()) {
                    setCtx = stmtCtxMap.get(tr);
                    if (setCtx != null && !setCtx.isEmpty()) {
                        TriggersReader.analyzeWhenVexCtx((VexContext) setCtx.iterator().next(), tr, s.getName());
                    }
                }
            }

            for (PgFunction f : s.getFunctions()) {
                setCtx = stmtCtxMap.get(f);

                if (setCtx != null && !setCtx.isEmpty()) {
                    ValueExpr vex = new ValueExpr(s.getName());

                    setCtx.stream().map(ctx -> (VexContext)ctx)
                    .forEach(vCtx -> {
                        vex.analyze(new Vex(vCtx));
                        f.addAllDeps(vex.getDepcies());
                    });
                }
            }
        }
    }

    private static void loadSubdir(IFolder folder, PgDatabase db, IProgressMonitor monitor,
            List<FunctionBodyContainer> funcBodies, Map<String, List<AntlrError>> errors)
                    throws InterruptedException, IOException, CoreException {
        for (IResource resource : folder.members()) {
            if (resource.getType() == IResource.FILE && "sql".equals(resource.getFileExtension())) { //$NON-NLS-1$
                loadFile((IFile) resource, monitor, db, funcBodies, errors);
            }
        }
    }

    protected static void loadFile(IFile file, IProgressMonitor monitor, PgDatabase db,
            List<FunctionBodyContainer> funcBodies, Map<String, List<AntlrError>> errors)
                    throws IOException, CoreException, InterruptedException {
        PgDiffArguments arguments = new PgDiffArguments();
        arguments.setInCharsetName(file.getCharset());

        try (PgDumpLoader loader = new PgDumpLoader(file, arguments, monitor)) {
            loader.setLoadReferences(funcBodies != null);
            loader.loadFile(db);
            if (funcBodies != null) {
                funcBodies.addAll(loader.getFuncBodyReferences());
            }
            if (errors != null) {
                errors.put(file.getFullPath().toOSString(), loader.getErrors());
            }
        }
    }

    public PgDatabase loadFile(PgDatabase db) throws InterruptedException, IOException, CoreException {
        load(db);

        // !!!!!!!!!
        // = UIConsts =
        // MARKER.ERROR = "ru.taximaxim.codekeeper.ui" + ".sql.errormarker"
        String markerError = "ru.taximaxim.codekeeper.ui.sql.errormarker";

        file.deleteMarkers(markerError, false, IResource.DEPTH_ZERO);
        IDocument doc = null;
        for (AntlrError antlrError : getErrors()) {
            IMarker marker = file.createMarker(markerError);
            int line = antlrError.getLine();
            marker.setAttribute(IMarker.LINE_NUMBER, line);
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
            try {
                int start = antlrError.getStart();
                int stop = antlrError.getStop();
                if (start == -1 || stop == -1) {
                    if (doc == null) {
                        // load only when this case actually happens
                        IDocumentProvider provider = new TextFileDocumentProvider();
                        provider.connect(file);
                        doc = provider.getDocument(file);
                    }
                    int lineOffset = doc.getLineOffset(line - 1);
                    start = lineOffset + antlrError.getCharPositionInLine();
                    stop = start;
                }
                marker.setAttribute(IMarker.CHAR_START, start);
                marker.setAttribute(IMarker.CHAR_END, stop + 1);

                // !!!!!!!!!
                // catch (org.eclipse.jface.text.BadLocationException ex)
            } catch (org.eclipse.jface.text.BadLocationException ex) {
                Log.log(ex);
            }
        }

        return db;
    }
}