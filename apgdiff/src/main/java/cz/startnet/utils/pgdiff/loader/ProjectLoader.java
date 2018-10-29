package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;

public class ProjectLoader {
    /**
     * Loading order and directory names of the objects in exported DB schemas.
     * NOTE: constraints, triggers and indexes are now stored in tables,
     * those directories are here for backward compatibility only
     */
    protected static final String[] DIR_LOAD_ORDER = new String[] { "TYPE", "DOMAIN",
            "SEQUENCE", "FUNCTION", "OPERATOR", "TABLE", "CONSTRAINT", "INDEX", "TRIGGER", "VIEW",
            "FTS_PARSER", "FTS_TEMPLATE", "FTS_DICTIONARY", "FTS_CONFIGURATION" };

    private final String dirPath;
    protected final PgDiffArguments arguments;
    protected final IProgressMonitor monitor;
    protected final List<AntlrError> errors;

    public ProjectLoader(String dirPath, PgDiffArguments arguments) {
        this(dirPath, arguments, null, null);
    }

    public ProjectLoader(String dirPath, PgDiffArguments arguments,
            IProgressMonitor monitor, List<AntlrError> errors) {
        this.dirPath = dirPath;
        this.arguments = arguments;
        this.monitor = monitor;
        this.errors = errors;
    }

    /**
     * Loads database schema from a ModelExporter directory tree.
     *
     * @param dirPath path to the directory tree root
     *
     * @return database schema
     * @throws InterruptedException
     */
    public PgDatabase loadDatabaseSchemaFromDirTree() throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);
        db = loadDatabaseSchemaFromDirTree(db);
        FullAnalyze.fullAnalyze(db, errors);
        return db;
    }

    /**
     * Loads database schema from a ModelExporter directory tree without analyze.
     *
     * @param dirPath path to the directory tree root
     *
     * @return database schema
     * @throws InterruptedException
     */
    public PgDatabase loadDatabaseSchemaFromDirTree(PgDatabase db) throws InterruptedException, IOException {
        File dir = new File(dirPath);

        // step 1
        // read files in schema folder, add schemas to db
        for (WORK_DIR_NAMES dirEnum : WORK_DIR_NAMES.values()) {
            // legacy schemas
            loadSubdir(dir, dirEnum.name(), db);
        }

        File schemasCommonDir = new File(dir, WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!schemasCommonDir.isDirectory()) {
            return db;
        }

        // new schemas + content
        // step 2
        // read out schemas names, and work in loop on each
        try (Stream<Path> schemas = Files.list(schemasCommonDir.toPath())) {
            for (Path schemaDir : PgDiffUtils.sIter(schemas)) {
                if (Files.isDirectory(schemaDir)) {
                    loadSubdir(schemasCommonDir, schemaDir.getFileName().toString(), db);
                    for (String dirSub : DIR_LOAD_ORDER) {
                        loadSubdir(schemaDir.toFile(), dirSub, db);
                    }
                }
            }
        }

        return db;
    }

    /**
     * Loads database schema from a MS SQL ModelExporter directory tree.
     */
    public PgDatabase loadMsDatabaseSchemaFromDirTree() throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);
        File dir = new File(dirPath);

        File securityFolder = new File(dir, MS_WORK_DIR_NAMES.SECURITY.getDirName());
        loadSubdir(securityFolder, "Roles", db);
        loadSubdir(securityFolder, "Users", db);
        loadSubdir(securityFolder, "Schemas", db);
        addDboSchema(db);

        for (MS_WORK_DIR_NAMES dirSub : MS_WORK_DIR_NAMES.values()) {
            loadSubdir(dir, dirSub.getDirName(), db);
        }

        return db;
    }

    protected void addDboSchema(PgDatabase db) {
        if (!db.containsSchema(ApgdiffConsts.DBO)) {
            db.addSchema(new MsSchema(ApgdiffConsts.DBO, ""));
            db.setDefaultSchema(ApgdiffConsts.DBO);
        }
    }

    private void loadSubdir(File dir, String sub, PgDatabase db)
            throws InterruptedException, IOException {
        File subDir = new File(dir, sub);
        if (subDir.exists() && subDir.isDirectory()) {
            File[] files = subDir.listFiles();
            loadFiles(files, db);
        }
    }

    private void loadFiles(File[] files, PgDatabase db)
            throws IOException, InterruptedException {
        Arrays.sort(files);
        for (File f : files) {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".sql")) {
                List<AntlrError> errList = null;
                try (PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor)) {
                    errList = loader.getErrors();
                    loader.loadDatabase(db);
                } finally {
                    if (errors != null && errList != null && !errList.isEmpty()) {
                        errors.addAll(errList);
                    }
                }
            }
        }
    }
}
