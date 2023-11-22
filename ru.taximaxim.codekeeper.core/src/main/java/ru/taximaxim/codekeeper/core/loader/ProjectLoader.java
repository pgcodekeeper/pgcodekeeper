/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;

public class ProjectLoader extends DatabaseLoader {

    protected static final String MS_SCHEMAS_FOLDER = "Schemas";
    protected static final String MS_ROLES_FOLDER = "Roles";
    protected static final String MS_USERS_FOLDER = "Users";

    /**
     * Loading order and directory names of the objects in exported DB schemas.
     * NOTE: constraints, triggers and indexes are now stored in tables,
     * those directories are here for backward compatibility only
     */
    protected static final EnumSet<DbObjType> DIR_LOAD_ORDER = EnumSet.of(DbObjType.COLLATION, DbObjType.TYPE,
            DbObjType.DOMAIN, DbObjType.SEQUENCE, DbObjType.FUNCTION, DbObjType.PROCEDURE,
            DbObjType.AGGREGATE, DbObjType.OPERATOR, DbObjType.TABLE, DbObjType.CONSTRAINT,
            DbObjType.INDEX, DbObjType.TRIGGER, DbObjType.VIEW, DbObjType.FTS_PARSER,
            DbObjType.FTS_TEMPLATE, DbObjType.FTS_DICTIONARY, DbObjType.FTS_CONFIGURATION);

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
        loadDbStructure(dir, db);
        return db;
    }

    public void loadOverrides(PgDatabase db) throws InterruptedException, IOException {
        Path dir = Paths.get(dirPath, Consts.OVERRIDES_DIR);
        if (arguments.isIgnorePrivileges() || !Files.isDirectory(dir)) {
            return;
        }
        isOverrideMode = true;
        try {
            loadDbStructure(dir, db);
            replaceOverrides();
        } finally {
            isOverrideMode = false;
        }
    }

    private void loadDbStructure(Path dir, PgDatabase db) throws InterruptedException, IOException {
        switch (arguments.getDbType()) {
        case MS:
            loadMsStructure(dir, db);
            break;
        case PG:
            loadPgStructure(dir, db);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
        }
        finishLoaders();
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
                    for (DbObjType dirSub : DIR_LOAD_ORDER) {
                        loadSubdir(schemaDir, dirSub.name(), db);
                    }
                }
            }
        }
    }

    private void loadMsStructure(Path dir, PgDatabase db) throws InterruptedException, IOException {
        Path securityFolder = dir.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName());

        loadSubdir(securityFolder, MS_SCHEMAS_FOLDER, db, this::checkIgnoreSchemaList);
        // DBO schema check requires schema loads to finish first
        AntlrParser.finishAntlr(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder, MS_ROLES_FOLDER, db);
        loadSubdir(securityFolder, MS_USERS_FOLDER, db);

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
        if (!db.containsSchema(Consts.DBO)) {
            MsSchema schema = new MsSchema(Consts.DBO);
            PgObjLocation loc = new PgObjLocation.Builder()
                    .setObject(new GenericColumn(Consts.DBO, DbObjType.SCHEMA))
                    .build();

            schema.setLocation(loc);
            db.addSchema(schema);
            db.setDefaultSchema(Consts.DBO);
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
