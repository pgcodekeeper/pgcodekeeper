/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.UnixPrintWriter;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * Exports AbstractDatabase model as a directory tree with sql files with objects' code as leaves.<br>
 * <br>
 *
 * For historical reasons we expect a filtered user-selection-only list in {@link #exportPartial()} but we use the new
 * API {@link TreeElement#isSelected()} for selection checks instead of calling {@link Collection#contains(Object)} for
 * performance reasons.
 *
 * @author Alexander Levsha
 */
public class ModelExporter {

    private static final Logger LOG = LoggerFactory.getLogger(ModelExporter.class);

    public static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n";

    /**
     * Objects of the export directory
     */
    protected final Path outDir;

    /**
     * Database to export
     */
    protected final AbstractDatabase newDb;

    /**
     * Old state db to fetch filenames from
     */
    protected final AbstractDatabase oldDb;

    /**
     * SQL files encoding
     */
    private final String sqlEncoding;

    /**
     * Objects that we need to operate on
     */
    protected final Collection<TreeElement> changeList;

    /**
     * Database type for defining directory structure
     */
    private final DatabaseType databaseType;

    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb} and {@link #sqlEncoding}.
     *
     * @param outDir
     *            outDir, directory should be empty or not exist
     * @param db
     *            database
     * @param sqlEncoding
     *            encoding
     */
    public ModelExporter(Path outDir, AbstractDatabase db, DatabaseType databaseType, String sqlEncoding) {
        this(outDir, db, null, databaseType, null, sqlEncoding);
    }

    public ModelExporter(Path outDir, AbstractDatabase newDb, AbstractDatabase oldDb,
            DatabaseType databaseType, Collection<TreeElement> changedObjects, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changeList = changedObjects;
        this.databaseType = databaseType;
    }

    /**
     * Starts the {@link #newDb} export process.
     */
    public void exportFull() throws IOException {
        createOutDir();

        Map<Path, StringBuilder> dumps = new HashMap<>();
        newDb.getDescendants().sorted(ExportTableOrder.INSTANCE).forEach(st -> dumpStatement(st, dumps));

        for (Entry<Path, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), dump.getKey());
        }

        writeProjVersion(outDir.resolve(Consts.FILENAME_WORKING_DIR_MARKER));
    }

    private void createOutDir() throws IOException {
        if (Files.exists(outDir)) {
            if (!Files.isDirectory(outDir)) {
                throw new NotDirectoryException(outDir.toString());
            }

            for (String subdirName : WorkDirs.getDirectoryNames(databaseType)) {
                if (Files.exists(outDir.resolve(subdirName))) {
                    throw new DirectoryException(
                            MessageFormat.format("Output directory already contains {0} directory.", subdirName));
                }
            }
        } else {
            Files.createDirectories(outDir);
        }
    }

    public void exportPartial() throws IOException, PgCodekeeperException {
        if (oldDb == null) {
            throw new PgCodekeeperException("Old database should not be null for partial export.");
        }
        if (Files.notExists(outDir) || !Files.isDirectory(outDir)) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.toAbsolutePath()));
        }

        List<PgStatement> list = oldDb.getDescendants().collect(Collectors.toList());
        Set<Path> paths = new HashSet<>();

        for (TreeElement el : changeList) {
            if (el.getType() == DbObjType.DATABASE) {
                continue;
            }
            switch(el.getSide()) {
            case LEFT:
                PgStatement stInOld = el.getPgStatement(oldDb);
                list.remove(stInOld);
                for (PgStatement child : PgDiffUtils.sIter(stInOld.getChildren())) {
                    list.remove(child);
                    deleteStatementIfExists(child);
                }
                paths.add(getRelativeFilePath(stInOld));
                deleteStatementIfExists(stInOld);
                break;
            case RIGHT:
                PgStatement stInNew = el.getPgStatement(newDb);
                list.add(stInNew);
                paths.add(getRelativeFilePath(stInNew));
                deleteStatementIfExists(stInNew);
                break;
            case BOTH:
                stInNew = el.getPgStatement(newDb);
                stInOld = el.getPgStatement(oldDb);
                list.set(list.indexOf(stInOld), stInNew);
                paths.add(getRelativeFilePath(stInNew));
                deleteStatementIfExists(stInNew);
                break;
            }
        }

        Map<Path, StringBuilder> dumps = new HashMap<>();
        list.stream()
        .filter(st -> paths.contains(getRelativeFilePath(st)))
        .sorted(ExportTableOrder.INSTANCE)
        .forEach(st -> dumpStatement(st, dumps));

        for (Entry<Path, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), dump.getKey());
        }

        writeProjVersion(outDir.resolve(Consts.FILENAME_WORKING_DIR_MARKER));
    }

    protected void dumpStatement(PgStatement st, Map<Path, StringBuilder> dumps) {
        Path path = outDir.resolve(getRelativeFilePath(st));
        StringBuilder sb = dumps.computeIfAbsent(path, e -> new StringBuilder());
        String dump = getDumpSql(st);

        if (dump.isEmpty()) {
            return;
        }

        if (sb.length() != 0) {
            sb.append(GROUP_DELIMITER);
        }

        sb.append(dump);
    }

    protected void dumpSQL(CharSequence sql, Path path) throws IOException {
        Files.createDirectories(path.getParent());
        try (PrintWriter outFile = new UnixPrintWriter(Files.newOutputStream(path,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), sqlEncoding)) {
            outFile.println(sql);
        }
    }

    protected String getDumpSql(PgStatement statement) {
        return statement.getFullFormattedSQL();
    }

    /**
     * Removes file if it exists.
     */
    protected void deleteStatementIfExists(PgStatement st) throws IOException {
        Path toDelete = outDir.resolve(getRelativeFilePath(st));

        if (Files.deleteIfExists(toDelete)) {
            LOG.info("Deleted file {} for object {} {}", toDelete, st.getStatementType(), st.getName());
        }
    }

    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        return FileUtils.getValidFilename(statement.getBareName());
    }

    public static String getExportedFilenameSql(String name) {
        return FileUtils.getValidFilename(name) + ".sql"; //$NON-NLS-1$
    }

    public static void writeProjVersion(Path path) throws IOException {
        try (UnixPrintWriter pw = new UnixPrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
            pw.println(Consts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                    + Consts.EXPORT_CURRENT_VERSION);
        }
    }

    public static Path getRelativeFilePath(PgStatement st) {
        if (st.isSubElement()) {
            st = st.getParent();
        }
        Path path = WorkDirs.getRelativeFolderPath(st, Paths.get(""));

        String fileName = getExportedFilenameSql(getExportedFilename(st));
        if (st.getDbType() == DatabaseType.MS && st instanceof ISearchPath sp) {
            fileName = FileUtils.getValidFilename(sp.getSchemaName()) + '.' + fileName;
        }

        return path.resolve(fileName);
    }
}

/**
 * Sets fixed order for table subelements export as historically defined by DiffTree.create().
 */
class ExportTableOrder implements Comparator<PgStatement> {

    public static final ExportTableOrder INSTANCE = new ExportTableOrder();

    @Override
    public int compare(PgStatement o1, PgStatement o2) {
        int result = Integer.compare(getTableSubelementRank(o1), getTableSubelementRank(o2));
        if (result != 0) {
            return result;
        }

        return o1.getBareName().compareTo(o2.getBareName());
    }

    private int getTableSubelementRank(PgStatement el) {
        return switch (el.getStatementType()) {
        case INDEX -> 1;
        case TRIGGER -> 2;
        case RULE -> 3;
        case CONSTRAINT -> 4;
        case POLICY -> 5;
        case STATISTICS -> 6;
        default -> 0;
        };
    }

    private ExportTableOrder() {}
}
