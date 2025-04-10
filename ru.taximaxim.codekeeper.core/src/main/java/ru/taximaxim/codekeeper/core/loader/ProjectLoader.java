/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.ms.MsSchema;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class ProjectLoader extends DatabaseLoader {

    protected ISettings settings;
    private final String dirPath;
    protected final IProgressMonitor monitor;
    private final IgnoreSchemaList ignoreSchemaList;
    protected final Map<PgStatement, StatementOverride> overrides = new LinkedHashMap<>();

    protected boolean isOverrideMode;

    public ProjectLoader(String dirPath, ISettings settings) {
        this(dirPath, settings, null, new ArrayList<>(), null);
    }

    public ProjectLoader(String dirPath, ISettings settings, List<Object> errors) {
        this(dirPath, settings, null, errors, null);
    }

    public ProjectLoader(String dirPath, ISettings settings,
            IProgressMonitor monitor, List<Object> errors, IgnoreSchemaList ignoreSchemaList) {
        super(errors);
        this.dirPath = dirPath;
        this.settings = settings;
        this.monitor = monitor;
        this.ignoreSchemaList = ignoreSchemaList;
    }

    @Override
    public AbstractDatabase load() throws InterruptedException, IOException {
        AbstractDatabase db = createDb(settings);

        Path dir = Paths.get(dirPath);
        loadDbStructure(dir, db);
        return db;
    }

    public void loadOverrides(AbstractDatabase db) throws InterruptedException, IOException {
        Path dir = Paths.get(dirPath, WorkDirs.OVERRIDES);
        if (settings.isIgnorePrivileges() || !Files.isDirectory(dir)) {
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

    private void loadDbStructure(Path dir, AbstractDatabase db) throws InterruptedException, IOException {
        switch (settings.getDbType()) {
        case MS:
            loadMsStructure(dir, db);
            break;
        case PG:
            loadPgStructure(dir, db);
            break;
        case CH:
            loadChStructure(dir, db);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
        }
        finishLoaders();
    }

    private void loadChStructure(Path dir, AbstractDatabase db) throws InterruptedException, IOException {
        for (String dirName : WorkDirs.getDirectoryNames(DatabaseType.CH)) {
            if (WorkDirs.CH_DATABASE.equals(dirName)) {
                loadPgChStructure(dir, db, dirName);
            } else {
                loadSubdir(dir, dirName, db);
            }
        }
    }

    private void loadPgStructure(Path dir, AbstractDatabase db) throws InterruptedException, IOException {
        for (String dirName : WorkDirs.getDirectoryNames(DatabaseType.PG)) {
            if (WorkDirs.PG_SCHEMA.equals(dirName)) {
                loadPgChStructure(dir, db, dirName);
            } else {
                loadSubdir(dir, dirName, db);
            }
        }
    }

    private void loadPgChStructure(Path baseDir, AbstractDatabase db, String commonDir)
            throws InterruptedException, IOException {

        Path schemasCommonDir = baseDir.resolve(commonDir);
        // skip walking SCHEMA folder if it does not exist
        if (!Files.isDirectory(schemasCommonDir)) {
            return;
        }

        // new schemas + content
        // step 2
        // read out schemas names, and work in loop on each
        try (Stream<Path> schemas = Files.list(schemasCommonDir)) {
            for (Path schemaDir : PgDiffUtils.sIter(schemas)) {
                if (Files.isDirectory(schemaDir) && checkIgnoreSchemaList(schemaDir.getFileName().toString())) {
                    loadSubdir(schemasCommonDir, schemaDir.getFileName().toString(), db);
                    for (DbObjType dirSub : WorkDirs.getDirLoadOrder()) {
                        loadSubdir(schemaDir, dirSub.name(), db);
                    }
                }
            }
        }
    }

    private void loadMsStructure(Path dir, AbstractDatabase db) throws InterruptedException, IOException {
        Path securityFolder = dir.resolve(WorkDirs.MS_SECURITY);

        loadSubdir(securityFolder, WorkDirs.MS_SCHEMAS, db, this::checkIgnoreSchemaList);
        // DBO schema check requires schema loads to finish first
        AntlrParser.finishAntlr(antlrTasks);
        addDboSchema(db);

        loadSubdir(securityFolder, WorkDirs.MS_ROLES, db);
        loadSubdir(securityFolder, WorkDirs.MS_USERS, db);

        for (String dirSub : WorkDirs.getDirectoryNames(DatabaseType.MS)) {
            if (WorkDirs.isInMsSchema(dirSub)) {
                // get schema name from file names and filter
                loadSubdir(dir, dirSub, db, this::checkIgnoreSchemaList);
                continue;
            }
            loadSubdir(dir, dirSub, db);
        }
    }

    protected void addDboSchema(AbstractDatabase db) {
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

    private void loadSubdir(Path dir, String sub, AbstractDatabase db) throws InterruptedException, IOException {
        loadSubdir(dir, sub, db, null);
    }

    /**
     * @param checkFilename filter for file names without extensions. Can be null.
     */
    private void loadSubdir(Path dir, String sub, AbstractDatabase db, Predicate<String> checkFilename)
            throws InterruptedException, IOException {
        Path subDir = dir.resolve(sub);
        if (!Files.isDirectory(subDir)) {
            return;
        }
        try (Stream<Path> files = Files.list(subDir)
                .filter(f -> filterFile(f, checkFilename))
                .sorted()) {
            for (Path f : PgDiffUtils.sIter(files)) {
                PgDumpLoader loader = new PgDumpLoader(f, settings, monitor);
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
        return checkFilename == null || checkFilename.test(fileName);
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

    protected boolean checkIgnoreSchemaList(String resourceName) {
        return ignoreSchemaList == null || ignoreSchemaList.getNameStatus(resourceName.split("\\.")[0]);
    }
}
