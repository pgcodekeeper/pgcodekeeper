package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Exports PgDatabase model as a directory tree with
 * sql files with objects' code as leaves.<br><br>
 *
 * For historical reasons we expect a filtered user-selection-only list in {@link #exportPartial()}
 * but we use the new API {@link TreeElement#isSelected()} for selection checks
 * instead of calling {@link Collection#contains(Object)} for performance reasons.
 *
 * @author Alexander Levsha
 */
public abstract class AbstractModelExporter {

    protected static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n";

    /**
     * Objects of the export directory;
     */
    protected final Path outDir;

    /**
     * Database to export.
     */
    protected final PgDatabase newDb;

    /**
     * Old state db to fetch filenames from
     */
    protected final PgDatabase oldDb;

    /**
     * SQL files encoding.
     */
    protected final String sqlEncoding;

    /**
     * Objects that we need to operate on.
     */
    protected final Collection<TreeElement> changeList;

    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb}
     * and {@link #sqlEncoding}.
     *
     * @param outDir outDir, directory should be empty or not exist
     * @param newDb database
     */
    public AbstractModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        this(outDir, db, null, null, sqlEncoding);
    }

    public AbstractModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changeList = changedObjects;
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

        writeProjVersion(outDir.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    protected abstract void createOutDir() throws IOException;

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
                paths.add(getRelativeFilePath(stInOld, true));
                deleteStatementIfExists(stInOld);
                break;
            case RIGHT:
                PgStatement stInNew = el.getPgStatement(newDb);
                list.add(stInNew);
                paths.add(getRelativeFilePath(stInNew, true));
                deleteStatementIfExists(stInNew);
                break;
            case BOTH:
                stInNew = el.getPgStatement(newDb);
                stInOld = el.getPgStatement(oldDb);
                list.set(list.indexOf(stInOld), stInNew);
                paths.add(getRelativeFilePath(stInNew, true));
                deleteStatementIfExists(stInNew);
                break;
            }
        }

        Map<Path, StringBuilder> dumps = new HashMap<>();
        list.stream()
        .filter(st -> paths.contains(getRelativeFilePath(st, true)))
        .sorted(ExportTableOrder.INSTANCE)
        .forEach(st -> dumpStatement(st, dumps));

        for (Entry<Path, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), dump.getKey());
        }

        writeProjVersion(outDir.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    protected void dumpStatement(PgStatement st, Map<Path, StringBuilder> dumps) {
        Path path = outDir.resolve(getRelativeFilePath(st, true));
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
        Path toDelete = outDir.resolve(getRelativeFilePath(st, true));

        if (Files.deleteIfExists(toDelete)) {
            Log.log(Log.LOG_INFO, "Deleted file " + toDelete +
                    " for object " + st.getStatementType() + ' ' + st.getName());
        }
    }

    /**
     * @param addExtension whether to add .sql extension to the path
     *      for schemas, no extension also means to get schema dir path,
     *      one segment shorter than file location since schema files
     *      are now stored in schema dirs
     */
    protected abstract Path getRelativeFilePath(PgStatement st, boolean addExtension);

    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        return  FileUtils.getValidFilename(statement.getBareName());
    }

    public static String getExportedFilenameSql(PgStatement statement) {
        return getExportedFilenameSql(getExportedFilename(statement));
    }

    public static String getExportedFilenameSql(String name) {
        return FileUtils.getValidFilename(name) + ".sql"; //$NON-NLS-1$
    }

    public static void writeProjVersion(Path path) throws IOException {
        try (UnixPrintWriter pw = new UnixPrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }

    public static Path getRelativeFilePath(PgStatement st) {
        AbstractModelExporter exporter = st.isPostgres() ? new ModelExporter(null, null, null)
                : new MsModelExporter(null, null, null);

        return exporter.getRelativeFilePath(st, true);
    }
}

/**
 * Sets fixed order for table subelements export as historically defined by DiffTree.create().
 */
class ExportTableOrder implements Comparator<PgStatement> {

    public static final ExportTableOrder INSTANCE = new ExportTableOrder();

    @Override
    public int compare(PgStatement o1, PgStatement o2) {
        return getTableSubelementRank(o1) - getTableSubelementRank(o2);
    }

    private int getTableSubelementRank(PgStatement el) {
        switch (el.getStatementType()) {
        case INDEX:     return 1;
        case TRIGGER:   return 2;
        case RULE:      return 3;
        case CONSTRAINT:return 4;
        case POLICY:    return 5;
        default:        return 0;
        }
    }

    private ExportTableOrder() {}
}
