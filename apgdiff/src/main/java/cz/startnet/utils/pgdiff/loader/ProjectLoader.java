package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ProjectLoader {
    /**
     * Loading order and directory names of the objects in exported DB schemas.
     * NOTE: constraints, triggers and indexes are now stored in tables,
     * those directories are here for backward compatibility only
     */
    protected static final String[] DIR_LOAD_ORDER = new String[] { "TYPE",
            "DOMAIN", "SEQUENCE", "FUNCTION", "PROCEDURE", "AGGREGATE", "OPERATOR",
            "TABLE", "CONSTRAINT", "INDEX", "TRIGGER", "VIEW", "FTS_PARSER",
            "FTS_TEMPLATE", "FTS_DICTIONARY", "FTS_CONFIGURATION" };

    private final String dirPath;
    protected final PgDiffArguments arguments;
    protected final IProgressMonitor monitor;
    protected final List<AntlrError> errors;
    protected final Map<PgStatement, StatementOverride> overrides = new LinkedHashMap<>();

    protected boolean isOverrideMode;

    protected final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    protected final Queue<PgDumpLoader> launchedLoaders = new ArrayDeque<>();

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
        PgDatabase db = loadSchemaOnly();
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
    public PgDatabase loadSchemaOnly() throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase(arguments);

        File dir = new File(dirPath);
        if (arguments.isMsSql()) {
            loadMsStructure(dir, db);
        } else {
            loadPgStructure(dir, db);
        }

        finishLoaders();

        return db;
    }

    public void loadOverrides(PgDatabase db) throws InterruptedException, IOException {
        File dir = new File(dirPath, ApgdiffConsts.OVERRIDES_DIR);
        if (arguments.isIgnorePrivileges() || !dir.exists() || !dir.isDirectory()) {
            return;
        }
        isOverrideMode = true;
        try {
            if (arguments.isMsSql()) {
                loadMsStructure(dir, db);
            } else {
                loadPgStructure(dir, db);
            }
            finishLoaders();
            replaceOverrides();
        } finally {
            isOverrideMode = false;
        }
    }

    private void loadPgStructure(File dir, PgDatabase db) throws InterruptedException, IOException {
        // step 1
        // read files in schema folder, add schemas to db
        for (WORK_DIR_NAMES dirEnum : WORK_DIR_NAMES.values()) {
            // legacy schemas
            loadSubdir(dir, dirEnum.name(), db);
        }

        File schemasCommonDir = new File(dir, WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (schemasCommonDir.isDirectory()) {
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
        }
    }

    private void loadMsStructure(File dir, PgDatabase db) throws InterruptedException, IOException {
        File securityFolder = new File(dir, MS_WORK_DIR_NAMES.SECURITY.getDirName());

        loadSubdir(securityFolder, "Schemas", db);
        // DBO schema check requires schema loads to finish first
        AntlrParser.finishAntlr(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder, "Roles", db);
        loadSubdir(securityFolder, "Users", db);

        for (MS_WORK_DIR_NAMES dirSub : MS_WORK_DIR_NAMES.values()) {
            loadSubdir(dir, dirSub.getDirName(), db);
        }
    }

    protected void addDboSchema(PgDatabase db) {
        if (!db.containsSchema(ApgdiffConsts.DBO)) {
            db.addSchema(new MsSchema(ApgdiffConsts.DBO));
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

    private void loadFiles(File[] files, PgDatabase db) throws InterruptedException {
        Arrays.sort(files);
        for (File f : files) {
            if (f.isFile() && f.getName().toLowerCase(Locale.ROOT).endsWith(".sql")) {
                PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor);
                try {
                    if (isOverrideMode) {
                        loader.setOverridesMap(overrides);
                    }
                    loader.loadDatabase(db, antlrTasks);
                } finally {
                    if (errors != null) {
                        errors.addAll(loader.getErrors());
                    }
                }
            }
        }
    }

    public Map<PgStatement, StatementOverride> getOverridesFromPath(Path path, PgDatabase db)
            throws IOException, InterruptedException {
        isOverrideMode = true;
        try {
            loadFiles(new File[] {path.toFile()}, db);
            AntlrParser.finishAntlr(antlrTasks);
        } finally {
            isOverrideMode = false;
        }
        return overrides;
    }

    protected void replaceOverrides() {
        Iterator<Entry<PgStatement, StatementOverride>> iterator = overrides.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<PgStatement, StatementOverride> entry = iterator.next();
            iterator.remove();

            PgStatement st = entry.getKey();
            StatementOverride override = entry.getValue();
            if (override.getOwner() != null) {
                st.setOwner(override.getOwner());
            }

            if (!override.getPrivileges().isEmpty()) {
                st.clearPrivileges();
                if (st.getStatementType() == DbObjType.TABLE) {
                    for (AbstractColumn col : ((AbstractTable) st).getColumns()) {
                        col.clearPrivileges();
                    }
                }
                for (PgPrivilege privilege : override.getPrivileges()) {
                    st.addPrivilege(privilege);
                }
            }
        }
    }

    protected void finishLoaders() throws InterruptedException, IOException {
        AntlrParser.finishAntlr(antlrTasks);
        PgDumpLoader l;
        while ((l = launchedLoaders.poll()) != null) {
            finishLoader(l);
        }
    }

    protected void finishLoader(PgDumpLoader l) {
        if (errors != null) {
            errors.addAll(l.getErrors());
        }
    }
}
