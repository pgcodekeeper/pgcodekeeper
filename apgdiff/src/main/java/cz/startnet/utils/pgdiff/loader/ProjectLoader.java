package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;

public class ProjectLoader extends DatabaseLoader {
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
    private final IgnoreSchemaList ignoreSchemaList;
    protected final Map<PgStatement, StatementOverride> overrides = new LinkedHashMap<>();

    protected boolean isOverrideMode;

    public ProjectLoader(String dirPath, PgDiffArguments arguments) {
        this(dirPath, arguments, null, new ArrayList<>(), null);
    }

    public ProjectLoader(String dirPath, PgDiffArguments arguments, List<Object> errors) {
        this(dirPath, arguments, null, errors, null);
    }

    public ProjectLoader(String dirPath, PgDiffArguments arguments,
            IProgressMonitor monitor, List<Object> errors, IgnoreSchemaList ignoreSchemaList) {
        super(errors);
        this.dirPath = dirPath;
        this.arguments = arguments;
        this.monitor = monitor;
        this.ignoreSchemaList = ignoreSchemaList;
    }

    @Override
    public PgDatabase load() throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase(arguments);

        Path dir = Paths.get(dirPath);
        if (arguments.isMsSql()) {
            loadMsStructure(dir, db);
        } else {
            loadPgStructure(dir, db);
        }

        finishLoaders();

        return db;
    }

    public void loadOverrides(PgDatabase db) throws InterruptedException, IOException {
        Path dir = Paths.get(dirPath, ApgdiffConsts.OVERRIDES_DIR);
        if (arguments.isIgnorePrivileges() || !Files.isDirectory(dir)) {
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

    private void loadPgStructure(Path dir, PgDatabase db) throws InterruptedException, IOException {
        // step 1
        // read files in schema folder, add schemas to db
        for (WORK_DIR_NAMES dirEnum : WORK_DIR_NAMES.values()) {
            // legacy schemas
            loadSubdir(dir, dirEnum.name(), db, this::checkIgnoreSchemaList);
        }

        Path schemasCommonDir = dir.resolve(WORK_DIR_NAMES.SCHEMA.name());
        // skip walking SCHEMA folder if it does not exist
        if (!Files.isDirectory(schemasCommonDir)) {
            return;
        }

        // new schemas + content
        // step 2
        // read out schemas names, and work in loop on each
        try (Stream<Path> schemas = Files.list(schemasCommonDir)) {
            for (Path schemaDir : PgDiffUtils.sIter(schemas)) {
                if (Files.isDirectory(schemaDir) &&
                        checkIgnoreSchemaList(schemaDir.getFileName().toString())) {
                    loadSubdir(schemasCommonDir, schemaDir.getFileName().toString(), db);
                    for (String dirSub : DIR_LOAD_ORDER) {
                        loadSubdir(schemaDir, dirSub, db);
                    }
                }
            }
        }
    }

    private void loadMsStructure(Path dir, PgDatabase db) throws InterruptedException, IOException {
        Path securityFolder = dir.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName());

        loadSubdir(securityFolder, "Schemas", db, this::checkIgnoreSchemaList);
        // DBO schema check requires schema loads to finish first
        AntlrParser.finishAntlr(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder, "Roles", db);
        loadSubdir(securityFolder, "Users", db);

        for (MS_WORK_DIR_NAMES dirSub : MS_WORK_DIR_NAMES.values()) {
            if (dirSub.isInSchema()) {
                // get schema name from file names and filter
                loadSubdir(dir, dirSub.getDirName(), db,
                        msFileName -> checkIgnoreSchemaList(msFileName.substring(0, msFileName.indexOf('.'))));
            } else {
                loadSubdir(dir, dirSub.getDirName(), db);
            }
        }
    }

    protected void addDboSchema(PgDatabase db) {
        if (!db.containsSchema(ApgdiffConsts.DBO)) {
            MsSchema schema = new MsSchema(ApgdiffConsts.DBO);
            schema.setLocation(new PgObjLocation(
                    new GenericColumn(ApgdiffConsts.DBO, DbObjType.SCHEMA)));
            db.addSchema(schema);
            db.setDefaultSchema(ApgdiffConsts.DBO);
        }
    }
    private void loadSubdir(Path dir, String sub, PgDatabase db) throws InterruptedException, IOException {
        loadSubdir(dir, sub, db, null);
    }

    /**
     * @param checkFilename filter for file names without extensions. Can be null.
     */
    private void loadSubdir(Path dir, String sub, PgDatabase db, Predicate<String> checkFilename) throws InterruptedException, IOException {
        Path subDir = dir.resolve(sub);
        if (!Files.isDirectory(subDir)) {
            return;
        }
        try (Stream<Path> files = Files.list(subDir)
                .filter(f -> filterFile(f, checkFilename))
                .sorted()) {
            for (Path f : PgDiffUtils.sIter(files)) {
                PgDumpLoader loader = new PgDumpLoader(f, arguments, monitor);
                if (isOverrideMode) {
                    loader.setOverridesMap(overrides);
                }
                loader.loadDatabase(db, antlrTasks);
                launchedLoaders.add(loader);
            }
        }
    }

    private boolean filterFile(Path f, Predicate<String> checkFilename) {
        String fileName = f.getFileName().toString();
        if (!fileName.toLowerCase(Locale.ROOT).endsWith(".sql") || !Files.isRegularFile(f)) {
            return false;
        }
        return checkFilename == null || checkFilename.test(fileName.substring(0, fileName.length()-4));
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

    protected boolean checkIgnoreSchemaList(String schemaName) {
        return ignoreSchemaList == null || ignoreSchemaList.getNameStatus(schemaName);
    }
}
