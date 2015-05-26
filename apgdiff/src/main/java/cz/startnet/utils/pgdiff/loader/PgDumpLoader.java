/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.FunctionBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.ReferenceListener;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;

/**
 * Loads PostgreSQL dump into classes.
 *
 * @author fordfrog
 */
public final class PgDumpLoader { // NOPMD

    /**
     * Loading order and directory names of the objects in exported DB schemas.
     */
    // NOTE: constraints, triggers and indexes are now stored in tables,
    // those directories are here for backward compatibility only
    private static final String[] DIR_LOAD_ORDER = new String[] { "TYPE",
            "DOMAIN", "SEQUENCE", "FUNCTION", "TABLE", "CONSTRAINT", "INDEX",
            "TRIGGER", "VIEW" };

    /**
     * Loads database schema from dump file.
     *
     * @param inputStream
     *            input stream that should be read
     * @param database
     *            {@link PgDatabase} to load into
     *
     * @return database schema from dump file
     */
    private static PgDatabase loadDatabaseSchemaCore(
            InputStream inputStream, PgDiffArguments arguments,
            PgDatabase database, Path path, IProgressMonitor monitor,
            int monitoringLevel) {
        try {
            database.setArguments(arguments);
            new AntlrParser(monitor, monitoringLevel).parseInputStream(
                    inputStream, arguments.getInCharsetName(),
                    new CustomSQLParserListener(database, path), path);
        } catch (IOException e) {
            throw new FileException(MessageFormat.format(
                    "Exception while closing dump file: {0}",
                    e.getLocalizedMessage()), e);
        }
        return database;
    }

    /**
     * Loads database schema from a ModelExporter directory tree. The root
     * directory must contain a listing.lst file for ordered list of files.
     * 
     * @param dirPath
     *            path to the directory tree root
     * @param charsetName
     *            charset that should be used to read the file
     * @param outputIgnoredStatements
     *            whether ignored statements should be included in the output
     * @param ignoreSlonyTriggers
     *            whether Slony triggers should be ignored
     *
     * @return database schema
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromDirTree(String dirPath,
            PgDiffArguments arguments, IProgressMonitor monitor, int monLvl, List<FunctionBodyContainer> funcBodies)
            throws InterruptedException {
        final PgDatabase db = new PgDatabase();
        File dir = new File(dirPath);

        // step 1
        // read files in schema folder, add schemas to db
        ApgdiffConsts.WORK_DIR_NAMES[] dirEnums = ApgdiffConsts.WORK_DIR_NAMES
                .values();
        String[] dirs = new String[dirEnums.length];
        for (int i = 0; i < dirEnums.length; ++i) {
            dirs[i] = dirEnums[i].toString();
        }
        walkSubdirsRunCore(dir, arguments, dirs, db, monitor, monLvl, funcBodies);

        File schemasCommonDir = new File(dir,
                ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
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
                walkSubdirsRunCore(schemaFolder, arguments, DIR_LOAD_ORDER, db,
                        monitor, monLvl, funcBodies);
            }
        }
        return db;
    }

    private static PgDatabase loadObjReferences(InputStream inputStream,
            PgDiffArguments arguments, PgDatabase database, Path path,
            IProgressMonitor monitor, int monitoringLevel,
            List<FunctionBodyContainer> funcBodies) {
        try {
            database.setArguments(arguments);
            ReferenceListener refListener = new ReferenceListener(database,
                    path);
            new AntlrParser(monitor, monitoringLevel).parseInputStream(
                    inputStream, arguments.getInCharsetName(), refListener,
                    path);
            funcBodies.addAll(refListener.getFunctionBodies());
        } catch (IOException e) {
            throw new FileException(MessageFormat.format(
                    "Exception while parsing dump file: {0}",
                    e.getLocalizedMessage()), e);
        }
        return database;
    }

    private static void walkSubdirsRunCore(File dir, PgDiffArguments arguments,
            String[] subDir, PgDatabase db, IProgressMonitor monitor, int monLvl, List<FunctionBodyContainer> funcBodies)
            throws InterruptedException {
        for (String s : subDir) {
            File folder = new File(dir, s);

            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();
                Arrays.sort(files);

                for (File f : files) {
                    parseFile(arguments, db, monitor, monLvl, funcBodies, f);
                }
            }
        }
    }

    /**
     * Разбирает файл и заполняет базу
     * @param arguments
     * @param db база для заполнения
     * @param monitor
     * @param monLvl
     * @param funcBodies указывает на необходимость прочитать только ссылки
     * @param f файл
     * @throws InterruptedException
     */
    private static void parseFile(PgDiffArguments arguments, PgDatabase db,
            IProgressMonitor monitor, int monLvl, List<FunctionBodyContainer> funcBodies, File f)
            throws InterruptedException {
        if (f.exists() && !f.isDirectory()
                && f.getName().toLowerCase().endsWith(".sql")) {
            try (FileInputStream inputStream = new FileInputStream(f)) {
                if (funcBodies != null) {
                    parseReferences(inputStream, arguments, db, f.toPath(), monitor, monLvl, funcBodies);
                } else {
                    parse(inputStream, arguments, db, f.toPath(), monitor, monLvl);
                }
            } catch (FileNotFoundException ex) {
                throw new FileException(MessageFormat.format(
                        Messages.Loader_FileNotFound, f.getAbsolutePath()), ex);
            } catch (IOException ex) {
                throw new FileException(MessageFormat.format(
                        Messages.Loader_CannotReadFile,
                        ex.getLocalizedMessage()), ex);
            }
        }
    }

    /**
     * Loads database schema from dump file.
     *
     * @param file
     *            name of file containing the dump
     * @param charsetName
     *            charset that should be used to read the file
     * @param outputIgnoredStatements
     *            whether ignored statements should be included in the output
     * @param ignoreSlonyTriggers
     *            whether Slony triggers should be ignored
     *
     * @return database schema from dump file
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromDump(
            InputStream inputStream, PgDiffArguments arguments,
            IProgressMonitor monitor, int monLvl) throws InterruptedException {
        return parse(inputStream, arguments, new PgDatabase(), Paths.get("/"),
                monitor, monLvl);
    }

    private static PgDatabase parse(InputStream inputStream,
            PgDiffArguments arguments, PgDatabase database, Path path,
            IProgressMonitor monitor, int monitoringLevel)
            throws InterruptedException {
        checkCancelled(monitor);
        return loadDatabaseSchemaCore(inputStream, arguments,
                database, path, monitor, monitoringLevel);
    }

    /**
     * Loads database schema from dump file.
     *
     * @param file
     *            name of file containing the dump
     * @param charsetName
     *            charset that should be used to read the file
     * @param outputIgnoredStatements
     *            whether ignored statements should be included in the output
     * @param ignoreSlonyTriggers
     *            whether Slony triggers should be ignored
     *
     * @return database schema from dump file
     * @throws InterruptedException
     */
    public static PgDatabase loadDatabaseSchemaFromDump(String file,
            PgDiffArguments arguments, IProgressMonitor monitor,
            int monitoringLevel) throws InterruptedException {
        try {
            return loadDatabaseSchemaFromDump(new FileInputStream(file),
                    arguments, monitor, monitoringLevel);
        } catch (final FileNotFoundException ex) {
            throw new FileException(MessageFormat.format(
                    Messages.Loader_FileNotFound, file), ex);
        }
    }

    public static void checkCancelled(IProgressMonitor monitor)
            throws InterruptedException {
        if (monitor != null && monitor.isCanceled()) {
            throw new InterruptedException();
        }
    }

    /**
     * Uses to parse only one file
     * 
     * @param projPath
     *            path to root folder of project
     * @param filePath
     *            path to file
     * @return database with schemas, extensions and parsed file contents
     */
    public static PgDatabase loadFromFile(String filePath,
            PgDiffArguments arguments, IProgressMonitor monitor,
            int monitoringLevel, List<FunctionBodyContainer> funcBodies)
            throws InterruptedException {
        final PgDatabase db = new PgDatabase();

        parseFile(arguments, db, monitor, monitoringLevel, funcBodies,
                new File(filePath));

        return db;
    }

    public static PgDatabase loadRefsFromInputStream(InputStream inputStream,
            Path path, PgDiffArguments arguments, IProgressMonitor monitor,
            int monitoringLevel, List<FunctionBodyContainer> funcBodies)
            throws InterruptedException {
        final PgDatabase db = new PgDatabase();
        parseReferences(inputStream, arguments, db, path, monitor,
                monitoringLevel, funcBodies);
        return db;
    }

    private static PgDatabase parseReferences(InputStream inputStream,
            PgDiffArguments arguments, PgDatabase database, Path path,
            IProgressMonitor monitor, int monitoringLevel,
            List<FunctionBodyContainer> funcBodies) throws InterruptedException {
        checkCancelled(monitor);
        return loadObjReferences(inputStream, arguments, database,
                path, monitor, monitoringLevel, funcBodies);
    }

    /**
     * Creates a new instance of PgDumpLoader.
     */
    private PgDumpLoader() {
    }
}
