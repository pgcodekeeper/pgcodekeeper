package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;


public abstract class AbstractModelExporter {

    protected static final int HASH_LENGTH = 10;
    protected static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n";

    /**
     * Objects of the export directory;
     */
    protected final File outDir;

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
    protected final LinkedList<TreeElement> changeList;

    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb}
     * and {@link #sqlEncoding}.
     *
     * @param outDir outDir, directory should be empty or not exist
     * @param newDb database
     */
    public AbstractModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = db;
        this.oldDb = null;
        this.sqlEncoding = sqlEncoding;
        this.changeList = null;
    }

    public AbstractModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding){
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changeList = new LinkedList<>(changedObjects);
    }

    /**
     * Starts the {@link #newDb} export process.
     */
    public abstract void exportFull() throws IOException;

    public void exportPartial() throws IOException, PgCodekeeperException {
        if (oldDb == null){
            throw new PgCodekeeperException("Old database should not be null for partial export.");
        }
        if (!outDir.exists() || !outDir.isDirectory()) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.getAbsolutePath()));
        }

        while (!changeList.isEmpty()) {
            TreeElement el = changeList.pop();
            Log.log(Log.LOG_DEBUG, "Exporting object: " + el);
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
        writeProjVersion(new File(outDir.getPath(), ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    protected abstract void deleteObject(TreeElement el) throws IOException;

    protected abstract void editObject(TreeElement el) throws IOException, PgCodekeeperException;

    protected abstract void createObject(TreeElement el) throws IOException, PgCodekeeperException;

    protected void dumpSQL(CharSequence sql, File file) throws IOException {
        Files.createDirectories(file.toPath().getParent());
        try (PrintWriter outFile = new UnixPrintWriter(Files.newOutputStream(file.toPath(),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), sqlEncoding)) {
            outFile.println(sql);
        }
    }

    protected String getDumpSql(PgStatement statement) {
        return statement.getFullSQL();
    }

    /**
     * @param elCause The element that caused the table processing.
     * It is expected to be popped from the {@link #changeList}.
     */
    protected void processViewAndContents(TreeElement el, PgStatement st,
            TreeElement elCause) throws IOException{
        if (el.getSide() == DiffSide.LEFT && el.isSelected()) {
            // view is dropped entirely
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

        // prepare the dump data, old state
        List<PgStatementWithSearchPath> contents = new LinkedList<>();
        AbstractSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());
        AbstractView oldView = null;
        if (oldParentSchema != null) {
            oldView = oldParentSchema.getView(st.getName());
            if (oldView != null) {
                contents.addAll(oldView.getChildren().map(
                        e -> (PgStatementWithSearchPath)e).collect(Collectors.toList()));
            }
        }
        // view to dump, initially assume old unmodified state
        AbstractView viewPrimary = oldView;

        // modify the dump state as requested by the changeList elements
        Iterator<TreeElement> it = changeList.iterator();
        while (it.hasNext()) {
            TreeElement elChange = it.next();
            TreeElement elViewChange;
            switch (elChange.getType()) {
            case VIEW:
                elViewChange = elChange;
                break;
            case RULE:
            case TRIGGER:
                elViewChange = elChange.getParent();
                break;
            default:
                continue;
            }
            AbstractView viewChange = (elViewChange.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema).getView(elViewChange.getName());
            if (viewChange == null || !viewChange.getName().equals(st.getName())
                    || !viewChange.getParent().getName().equals(elViewChange.getParent().getName())) {
                continue;
            }

            if (elChange.getType() == DbObjType.VIEW) {
                viewPrimary = viewChange;
            } else {
                PgStatementWithSearchPath stChange = null;
                PgStatementWithSearchPath stChangeOld = null;
                // now get the view based on the child's DiffSide
                // otherwise BOTH (new) view may be chosen to get LEFT children
                // which it does not contain
                viewChange = (elChange.getSide() == DiffSide.LEFT ?
                        oldParentSchema : newParentSchema).getView(elChange.getParent().getName());
                switch (elChange.getType()) {
                case RULE:
                    stChange = viewChange.getRule(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldView.getRule(elChange.getName());
                    }
                    break;
                case TRIGGER:
                    stChange = viewChange.getTrigger(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldView.getTrigger(elChange.getName());
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

        dumpContainer(viewPrimary, contents,
                newParentSchema == null ? oldParentSchema : newParentSchema);
    }

    /**
     * @param elCause The element that caused the table processing.
     * It is expected to be popped from the {@link #changeList}.
     */
    protected void processTableAndContents(TreeElement el, PgStatement st,
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

        // prepare the dump data, old state
        List<PgStatementWithSearchPath> contents = new LinkedList<>();
        AbstractSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());
        AbstractTable oldTable = null;
        if (oldParentSchema != null) {
            oldTable = oldParentSchema.getTable(st.getName());
            if (oldTable != null) {
                contents.addAll(oldTable.getChildren().map(
                        e -> (PgStatementWithSearchPath)e).collect(Collectors.toList()));
            }
        }
        // table to dump, initially assume old unmodified state
        AbstractTable tablePrimary = oldTable;

        // modify the dump state as requested by the changeList elements
        Iterator<TreeElement> it = changeList.iterator();
        while (it.hasNext()) {
            TreeElement elChange = it.next();
            TreeElement elTableChange;
            switch (elChange.getType()) {
            case TABLE:
                elTableChange = elChange;
                break;
            case CONSTRAINT:
            case INDEX:
            case TRIGGER:
            case RULE:
                elTableChange = elChange.getParent();
                break;
            default:
                continue;
            }
            AbstractTable tableChange = (elTableChange.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema).getTable(elTableChange.getName());
            if (tableChange == null || !tableChange.getName().equals(st.getName())
                    || !tableChange.getParent().getName().equals(elTableChange.getParent().getName())) {
                continue;
            }

            if (elChange.getType() == DbObjType.TABLE) {
                tablePrimary = tableChange;
            } else {
                PgStatementWithSearchPath stChange = null;
                PgStatementWithSearchPath stChangeOld = null;
                // now get the table based on the child's DiffSide
                // otherwise BOTH (new) table may be chosen to get LEFT children
                // which it does not contain
                tableChange = (elChange.getSide() == DiffSide.LEFT ?
                        oldParentSchema : newParentSchema).getTable(elChange.getParent().getName());
                switch (elChange.getType()) {
                case CONSTRAINT:
                    stChange = tableChange.getConstraint(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldTable.getConstraint(elChange.getName());
                    }
                    break;
                case INDEX:
                    stChange = tableChange.getIndex(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldTable.getIndex(elChange.getName());
                    }
                    break;
                case TRIGGER:
                    stChange = tableChange.getTrigger(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldTable.getTrigger(elChange.getName());
                    }
                    break;
                case RULE:
                    stChange = tableChange.getRule(elChange.getName());
                    if (elChange.getSide() == DiffSide.BOTH) {
                        stChangeOld = oldTable.getRule(elChange.getName());
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

        dumpContainer(tablePrimary, contents, newParentSchema == null ? oldParentSchema : newParentSchema);
    }

    protected abstract void dumpContainer(PgStatement obj, List<PgStatementWithSearchPath> contents,
            AbstractSchema schema) throws IOException;

    /**
     * Removes file if it exists.
     */
    protected abstract void deleteStatementIfExists(PgStatement st) throws IOException;


    public static String getExportedFilename(String name) {
        Matcher m = FileUtils.INVALID_FILENAME.matcher(name);
        if (m.find()) {
            String hash = PgDiffUtils.md5(name)
                    // 2^40 variants, should be enough for this purpose
                    .substring(0, HASH_LENGTH);
            return m.replaceAll("") + '_' + hash; //$NON-NLS-1$
        } else {
            return name;
        }
    }

    protected File mkdirObjects(File parentOutDir, String outDirName)
            throws NotDirectoryException, DirectoryException {
        File objectDir = new File(parentOutDir, outDirName);

        if (objectDir.exists()) {
            if (!objectDir.isDirectory()) {
                throw new NotDirectoryException(objectDir.getAbsolutePath());
            }
        } else {
            if (!objectDir.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create objects directory: {0}",
                        objectDir.getAbsolutePath()));
            }
        }

        return objectDir;
    }


    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        return getExportedFilename(statement.getBareName());
    }

    public static String getExportedFilenameSql(PgStatement statement) {
        return getExportedFilenameSql(getExportedFilename(statement));
    }

    public static String getExportedFilenameSql(String name) {
        return getExportedFilename(name) + ".sql"; //$NON-NLS-1$
    }

    public static void writeProjVersion(File f) throws FileNotFoundException {
        try (PrintWriter pw = new UnixPrintWriter(f, StandardCharsets.UTF_8)) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }
}

/**
 * Sets fixed order for table subelements export as historically defined by DiffTree.create().
 */
class ExportTableOrder implements Comparator<PgStatementWithSearchPath> {

    public static final ExportTableOrder INSTANCE = new ExportTableOrder();

    @Override
    public int compare(PgStatementWithSearchPath o1, PgStatementWithSearchPath o2) {
        return getTableSubelementRank(o1) - getTableSubelementRank(o2);
    }

    private int getTableSubelementRank(PgStatementWithSearchPath el) {
        switch (el.getStatementType()) {
        case INDEX:     return 0;
        case TRIGGER:   return 1;
        case RULE:      return 2;
        case CONSTRAINT:return 3;
        default: throw new IllegalArgumentException("Illegal table subelement: " + el.getName());
        }
    }
}
