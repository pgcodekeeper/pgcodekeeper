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
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.ReferenceListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
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
    private static final String[] DIR_LOAD_ORDER = new String[] { "TYPE",
            "DOMAIN", "SEQUENCE", "FUNCTION", "TABLE", "CONSTRAINT", "INDEX",
            "TRIGGER", "VIEW" };

    private final InputStream input;
    private final String inputObjectName;
    private final PgDiffArguments args;

    private final IProgressMonitor monitor;
    private final int monitoringLevel;

    private List<FunctionBodyContainer> funcBodyReferences;

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
    public PgDatabase load() throws IOException, InterruptedException, LicenseException {
        return load(false);
    }

    public PgDatabase load(boolean loadReferences)
            throws IOException, InterruptedException, LicenseException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);
        load(loadReferences, d);
        args.getLicense().verifyDb(d);
        return d;
    }

    private PgDatabase load(boolean loadReferences, PgDatabase intoDb)
            throws IOException, InterruptedException {
        checkCancelled(monitor);
        SQLParserBaseListener listener = (loadReferences ?
                new ReferenceListener(intoDb, inputObjectName)
                : new CustomSQLParserListener(intoDb, inputObjectName));
        AntlrParser.parseInputStream(input, args.getInCharsetName(), inputObjectName,
                listener, monitor, monitoringLevel);

        if (loadReferences) {
            funcBodyReferences = ((ReferenceListener) listener).getFunctionBodies();
        }
        return intoDb;
    }

    @Override
    public void close() throws IOException {
        input.close();
    }

    public static void checkCancelled(IProgressMonitor monitor)
            throws InterruptedException {
        if (monitor != null && monitor.isCanceled()) {
            throw new InterruptedException();
        }
    }

    /**
     * Loads database schema from a ModelExporter directory tree. The root
     * directory must contain a listing.lst file for ordered list of files.
     *
     * @param dirPath path to the directory tree root
     *
     * @return database schema
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromDirTree(String dirPath,
            PgDiffArguments arguments, IProgressMonitor monitor, int monLvl,
            List<FunctionBodyContainer> funcBodies)
                    throws InterruptedException, IOException, LicenseException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);
        File dir = new File(dirPath);

        // step 1
        // read files in schema folder, add schemas to db
        ApgdiffConsts.WORK_DIR_NAMES[] dirEnums = ApgdiffConsts.WORK_DIR_NAMES.values();
        String[] dirs = new String[dirEnums.length];
        for (int i = 0; i < dirEnums.length; ++i) {
            dirs[i] = dirEnums[i].toString();
        }
        loadSubdirs(dir, arguments, dirs, db, monitor, monLvl, funcBodies);

        File schemasCommonDir = new File(dir, ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.exists()) {
            return db;
        }

        // step 2
        // read out schemas names, and work in loop on each
        for (PgSchema schema : db.getSchemas()) {
            File schemaFolder = new File(schemasCommonDir,
                    ModelExporter.getExportedFilename(schema));
            if (schemaFolder.isDirectory()) {
                loadSubdirs(schemaFolder, arguments, DIR_LOAD_ORDER, db,
                        monitor, monLvl, funcBodies);
            }
        }

        arguments.getLicense().verifyDb(db);
        return db;
    }

    private static void loadSubdirs(File dir, PgDiffArguments arguments,
            String[] subDirs, PgDatabase db, IProgressMonitor monitor, int monLvl,
            List<FunctionBodyContainer> funcBodies) throws InterruptedException, IOException {
        for (String sub : subDirs) {
            File subDir = new File(dir, sub);

            if (subDir.exists() && subDir.isDirectory()) {
                File[] files = subDir.listFiles();
                Arrays.sort(files);

                for (File f : files) {
                    if (f.isFile() && f.getName().toLowerCase().endsWith(".sql")) {
                        try (PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor, monLvl)) {
                            loader.load(funcBodies != null, db);
                            if (funcBodies != null) {
                                funcBodies.addAll(loader.getFuncBodyReferences());
                            }
                        }
                    }
                }
            }
        }
    }
}