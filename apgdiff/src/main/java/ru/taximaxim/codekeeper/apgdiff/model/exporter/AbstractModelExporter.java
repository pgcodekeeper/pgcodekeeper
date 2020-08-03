package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

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
     * Objects that we need to operate on.<br>
     * Remove the entry from this list after it has been processed.
     */
    protected final Deque<TreeElement> changeList;

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
        this.changeList = changedObjects == null ? null : new LinkedList<>(changedObjects);
    }

    /**
     * Starts the {@link #newDb} export process.
     */
    public abstract void exportFull() throws IOException;

    public void exportPartial() throws IOException, PgCodekeeperException {
        if (oldDb == null){
            throw new PgCodekeeperException("Old database should not be null for partial export.");
        }
        if (Files.notExists(outDir) || !Files.isDirectory(outDir)) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.toAbsolutePath()));
        }

        while (!changeList.isEmpty()) {
            TreeElement el = changeList.pop();
            switch(el.getSide()) {
            case LEFT:
                deleteObject(el);
                break;
            case BOTH:
                editObject(el);
                break;
            case RIGHT:
                createObject(el);
                break;
            }
        }
        writeProjVersion(outDir.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    protected abstract void deleteObject(TreeElement el) throws IOException;

    protected abstract void editObject(TreeElement el) throws IOException, PgCodekeeperException;

    protected abstract void createObject(TreeElement el) throws IOException, PgCodekeeperException;

    protected void dumpSQL(CharSequence sql, Path path) throws IOException {
        Files.createDirectories(path.getParent());
        try (PrintWriter outFile = new UnixPrintWriter(Files.newOutputStream(path,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), sqlEncoding)) {
            outFile.println(sql);
        }
    }

    protected String getDumpSql(PgStatement statement) {
        return statement.getFullSQL();
    }

    /**
     * @param elCause The element that caused the container processing.
     * It is expected to be popped from the {@link #changeList}.
     */
    protected void processContainer(TreeElement el, PgStatement st,
            TreeElement elCause) throws IOException {
        if (el.getSide() == DiffSide.LEFT && el.isSelected()) {
            // table is dropped entirely
            return;
        }
        TreeElement elParent = el.getParent();
        if (elParent.getSide() == DiffSide.LEFT && elParent.isSelected()) {
            // the entire schema is dropped
            return;
        }

        // same as in processFunction
        // we need to have every related element on the list
        changeList.push(elCause);

        deleteStatementIfExists(st);

        PgStatementContainer oldContainer = getOldContainer(st);

        List<PgStatement> contents = new LinkedList<>();
        if (oldContainer != null) {
            oldContainer.getChildren().forEach(contents::add);
        }

        processChanges(st, oldContainer, contents);
    }

    private PgStatementContainer getOldContainer(PgStatement st) {
        AbstractSchema oldSchema = oldDb.getSchema(st.getParent().getName());
        if (oldSchema != null) {
            return oldSchema.getStatementContainer(st.getName());
        }

        return null;
    }

    private void processChanges(PgStatement st, PgStatementContainer oldContainer,
            List<PgStatement> contents) throws IOException {

        AbstractSchema newSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldSchema = oldDb.getSchema(st.getParent().getName());

        // container to dump, initially assume old unmodified state
        PgStatementContainer containerPrimary = oldContainer;

        // modify the dump state as requested by the changeList elements
        Iterator<TreeElement> it = changeList.iterator();
        while (it.hasNext()) {
            TreeElement elChange = it.next();
            TreeElement elContainerChange;
            switch (elChange.getType()) {
            case TABLE:
            case VIEW:
                elContainerChange = elChange;
                break;
            case CONSTRAINT:
            case INDEX:
            case TRIGGER:
            case RULE:
            case POLICY:
                elContainerChange = elChange.getParent();
                break;
            default:
                continue;
            }

            PgStatementContainer containerChange = (elContainerChange.getSide() == DiffSide.LEFT ?
                    oldSchema : newSchema).getStatementContainer(elContainerChange.getName());
            if (containerChange == null || !containerChange.getName().equals(st.getName())
                    || !containerChange.getParent().getName().equals(elContainerChange.getParent().getName())) {
                continue;
            }

            if (elChange.getType() == DbObjType.TABLE || elChange.getType() == DbObjType.VIEW) {
                containerPrimary = containerChange;
            } else {
                PgStatement stChange = null;
                PgStatement stChangeOld = null;
                // now get the table based on the child's DiffSide
                // otherwise BOTH (new) table may be chosen to get LEFT children
                // which it does not contain
                containerChange = (elChange.getSide() == DiffSide.LEFT ?
                        oldSchema : newSchema).getTable(elChange.getParent().getName());
                DbObjType type = elChange.getType();
                switch (type) {
                case CONSTRAINT:
                case INDEX:
                case TRIGGER:
                case RULE:
                case POLICY:
                    String name = elChange.getName();
                    stChange = containerChange.getChild(name, type);

                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldContainer.getChild(name, type);
                    }
                    break;
                default:
                    continue;
                }

                switch (elChange.getSide()) {
                case LEFT:
                    contents.remove(stChange);
                    break;
                case RIGHT:
                    contents.add(stChange);
                    break;
                case BOTH:
                    contents.set(contents.indexOf(stChangeOld), stChange);
                    break;
                }
            }

            it.remove();
        }

        dumpContainer(containerPrimary, contents);
    }

    private void dumpContainer(PgStatementContainer obj, List<PgStatement> contents)
            throws IOException {
        Collections.sort(contents, ExportTableOrder.INSTANCE);

        StringBuilder groupSql = new StringBuilder(getDumpSql(obj));

        for (PgStatement st : contents) {
            groupSql.append(GROUP_DELIMITER).append(getDumpSql(st));
        }

        dumpSQL(groupSql, outDir.resolve(getRelativeFilePath(obj, true)));
    }

    protected void dumpOverrides(PgStatement st) throws IOException {
        StringBuilder sb = new StringBuilder();
        PgStatement.appendOwnerSQL(st, st.getOwner(), false, sb);
        PgPrivilege.appendPrivileges(st.getPrivileges(), st.isPostgres(), sb);
        if (st.getPrivileges().isEmpty()) {
            PgPrivilege.appendDefaultPrivileges(st, sb);
        }

        if (DbObjType.TABLE == st.getStatementType()) {
            for (AbstractColumn col : ((AbstractTable)st).getColumns()) {
                PgPrivilege.appendPrivileges(col.getPrivileges(), col.isPostgres(), sb);
            }
        }

        if (sb.length() > 0) {
            dumpSQL(sb.toString(), outDir.resolve(getRelativeFilePath(st, true)));
        }
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
        case INDEX:     return 0;
        case TRIGGER:   return 1;
        case RULE:      return 2;
        case CONSTRAINT:return 3;
        case POLICY:    return 4;
        default: throw new IllegalArgumentException("Illegal table subelement: " + el.getName());
        }
    }

    private ExportTableOrder() {}
}
