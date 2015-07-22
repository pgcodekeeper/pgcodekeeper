package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
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
public class ModelExporter {

    private static final int HASH_LENGTH = 10;
    private static final Pattern INVALID_FILENAME = Pattern.compile("[\\/:*?\"<>|]");
    private static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n";

    /**
     * Objects of the export directory;
     */
    private final File outDir;

    /**
     * Database to export.
     */
    private final PgDatabase newDb;

    /**
     * Old state db to fetch filenames from
     */
    private final PgDatabase oldDb;

    /**
     * SQL files encoding.
     */
    private final String sqlEncoding;

    /**
     * Objects that we need to operate on.<br>
     * Remove the entry from this list after it has been processed.
     */
    private final LinkedList<TreeElement> changeList;

    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb}
     * and {@link #sqlEncoding}.
     *
     * @param outDir outDir, directory should be empty or not exist
     * @param newDb database
     */
    public ModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = db;
        this.oldDb = null;
        this.sqlEncoding = sqlEncoding;
        this.changeList = null;
    }

    public ModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb, Collection<TreeElement> changedObjects, String sqlEncoding){
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changeList = new LinkedList<>(changedObjects);
    }

    /**
     * Removes file if it exists.
     */
    private void deleteStatementIfExists(PgStatement st) throws IOException {
        Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true));
        Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() +
                " for object " + st.getStatementType() + ' ' + st.getName());
        Files.deleteIfExists(toDelete);
    }

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    public void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.getFileAttributeView(f.toPath(), DosFileAttributeView.class).setReadOnly(false);
        Files.deleteIfExists(f.toPath());
    }

    public void exportPartial() throws IOException {
        if (oldDb == null){
            throw new IOException("Old database should not be null for partial export.");
        }
        if(!outDir.exists() || !outDir.isDirectory()) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.getAbsolutePath()));
        }

        while (!changeList.isEmpty()){
            TreeElement el = changeList.pop();
            switch(el.getSide()){
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

    private void deleteObject(TreeElement el) throws IOException{
        PgStatement st = el.getPgStatement(oldDb);

        switch (st.getStatementType()) {
        case SCHEMA:
            // delete schema sql file
            deleteStatementIfExists(st);

            // delete schema's folder content
            File schemaFolder = new File(outDir, getRelativeFilePath(st, false));
            if (schemaFolder.exists()) {
                Log.log(Log.LOG_INFO, "Deleting schema folder for schema " + el.getName());
                deleteRecursive(schemaFolder);
            }
            break;

        case FUNCTION:
            processFunction(el, st);
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
            // as required by processTableAndContents()
            changeList.push(el);
            TreeElement elParent = el.getParent();
            processTableAndContents(elParent, elParent.getPgStatement(oldDb));
            break;

        default:
            deleteStatementIfExists(st);
        }
    }

    private void editObject(TreeElement el) throws IOException{
        PgStatement stInNew = el.getPgStatement(newDb);

        switch (stInNew.getStatementType()) {
        case SCHEMA:
        case EXTENSION:
            // delete sql file
            deleteStatementIfExists(stInNew);

            // dump new version
            dumpSQL(stInNew.getFullSQL(),
                    new File(outDir, getRelativeFilePath(stInNew, true)));
            break;

        case FUNCTION:
            processFunction(el, stInNew);
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
            changeList.push(el);
            TreeElement elParent = el.getParent();
            processTableAndContents(elParent, elParent.getPgStatement(newDb));
            break;

        case TABLE:
            changeList.push(el);
            processTableAndContents(el, stInNew);
            break;

        default:
            // remove old version
            deleteStatementIfExists(stInNew);

            // dump new version
            dumpSQL(getDumpSql((PgStatementWithSearchPath)stInNew),
                    new File(outDir, getRelativeFilePath(stInNew, true)));
        }
    }

    private void createObject(TreeElement el) throws IOException{
        PgStatement stInNew = el.getPgStatement(newDb);
        TreeElement elParent = el.getParent();

        switch (stInNew.getStatementType()) {
        case SCHEMA:
        case EXTENSION:
            // export schema/extension sql file
            dumpSQL(stInNew.getFullSQL(),
                    new File (outDir, getRelativeFilePath(stInNew, true)));
            break;

        case FUNCTION:
            testParentSchema(elParent);
            processFunction(el, stInNew);
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
            testParentSchema(elParent.getParent());
            // table actually, not schema
            testParentSchema(elParent);
            changeList.push(el);
            processTableAndContents(elParent, elParent.getPgStatement(newDb));
            break;

        case TABLE:
            testParentSchema(elParent);
            changeList.push(el);
            processTableAndContents(el, stInNew);
            break;

        default:
            testParentSchema(elParent);
            dumpObjects(Arrays.asList((PgStatementWithSearchPath)stInNew),
                    new File(new File(outDir, "SCHEMA"), getExportedFilename(stInNew.getParent())),
                    stInNew.getStatementType().name());
        }
    }

    /**
     * Tests whether this object is either selected for creation or not selected for deletion.
     *
     * @throws IOException  if this object is not to be created or is to be deleted
     */
    private void testParentSchema(TreeElement el) throws IOException{
        if (el.getSide() == DiffSide.RIGHT && !el.isSelected()
                || el.getSide() == DiffSide.LEFT && el.isSelected()){
            throw new IOException(
                    "Parent schema either will not be created (NEW) or is deleted already along with its schema folder");
        }
    }

    private void processFunction(TreeElement el, PgStatement st) throws IOException {
        TreeElement elParent = el.getParent();
        if (elParent.getSide() == DiffSide.LEFT && elParent.isSelected()) {
            // if the whole parent schema is to be deleted
            return;
        }
        // delete function sql file
        deleteStatementIfExists(st);

        List<PgFunction> funcsToDump = new LinkedList<>();
        PgSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        PgSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());

        // prepare the overloaded function list as if there are no changes
        if (oldParentSchema != null) {
            for (PgFunction oldFunc : oldParentSchema.getFunctions()) {
                if (oldFunc.getBareName().equals(st.getBareName())) {
                    funcsToDump.add(oldFunc);
                }
            }
        }

        // current element is pop()'d from the changeList before processing
        // this is a somewhat ugly workaround
        // this element will be removed in the iterator loop
        changeList.push(el);

        // apply changes based on the tree selection: remove LEFTs, replace BOTHs, add RIGHTs
        Iterator<TreeElement> it = changeList.iterator();
        while (it.hasNext()) {
            TreeElement elFunc = it.next();
            if (elFunc.getType() != DbObjType.FUNCTION) {
                continue;
            }
            // final required function state
            PgFunction funcPrimary = (elFunc.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema).getFunction(elFunc.getName());
            if (funcPrimary == null || !funcPrimary.getBareName().equals(st.getBareName())
                    || !funcPrimary.getParent().getName().equals(elFunc.getParent().getName())) {
                continue;
            }

            switch (elFunc.getSide()) {
            case LEFT:
                funcsToDump.remove(funcPrimary);
                break;
            case RIGHT:
                funcsToDump.add(funcPrimary);
                break;
            case BOTH:
                funcsToDump.set(
                        funcsToDump.indexOf(oldParentSchema.getFunction(elFunc.getName())),
                        funcPrimary);
                break;
            }

            // no further actions required after this processing
            // all overloads are processed in bulk and removed from the changes list
            it.remove();
        }

        dumpFunctions(funcsToDump, new File(outDir, getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false)));
    }

    /**
     * This method expects all related elements to be present on changeList
     * (reinsert them if needed, the method will remove them after processing).
     */
    private void processTableAndContents(TreeElement el, PgStatement st) throws IOException{
        if (el.getSide() == DiffSide.LEFT && el.isSelected()) {
            // table is dropped entirely
            return;
        }
        TreeElement elParent = el.getParent();
        if (elParent.getSide() == DiffSide.LEFT && elParent.isSelected()) {
            // the entire schema is dropped
            return;
        }

        deleteStatementIfExists(st);

        // prepare the dump data, old state
        List<PgStatementWithSearchPath> contents = new LinkedList<>();
        PgSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        PgSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());
        PgTable oldTable = null;
        if (oldParentSchema != null) {
            oldTable = oldParentSchema.getTable(st.getName());
            if (oldTable != null) {
                contents.addAll(oldTable.getConstraints());
                contents.addAll(oldTable.getIndexes());
                contents.addAll(oldTable.getTriggers());
            }
        }
        // table to dump, initially assume old unmodified state
        PgTable tablePrimary = oldTable;

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
                elTableChange = elChange.getParent();
                break;
            default:
                continue;
            }
            PgTable tableChange = (elTableChange.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema).getTable(elTableChange.getName());
            if (tableChange == null || !tableChange.getName().equals(st.getName())
                    || !tableChange.getParent().getName().equals(elTableChange.getParent().getName())) {
                continue;
            }

            if (elChange.getType() == DbObjType.TABLE) {
                tablePrimary = tableChange;
            } else {
                PgStatementWithSearchPath stChange, stChangeOld = null;
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
                default:
                    stChange = null;
                }
                if (stChange == null) {
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

        dumpTable(tablePrimary, contents, new File(outDir, getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false)));
    }

    private void dumpTable(PgTable table, List<PgStatementWithSearchPath> contents,
            File parentDir) throws IOException {
        mkdirObjects(null, parentDir.toString());
        File tablesDir = mkdirObjects(parentDir, "TABLE");

        StringBuilder groupSql = new StringBuilder(getDumpSql(table));

        for (PgStatementWithSearchPath st : contents) {
            groupSql.append(GROUP_DELIMITER).append(getDumpSql(st, false));
        }

        dumpSQL(groupSql, new File(tablesDir, getExportedFilenameSql(table)));
    }
    /*
     * =============================================
     * FULL EXPORT PART
     * =============================================
     */
    /**
     * Starts the {@link #newDb} export process.
     *
     * @throws IOException
     */
    public void exportFull() throws IOException {
        if(outDir.exists()) {
            if(!outDir.isDirectory()) {
                throw new NotDirectoryException(outDir.getAbsolutePath());
            }

            for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
                if (new File(outDir, subdirName.name()).exists()) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.",
                            subdirName));
                }
            }
        } else if(!outDir.mkdirs()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create output directory: {0}",
                    outDir.getAbsolutePath()));
        }

        // exporting schemas
        File schemasSharedDir = new File(outDir,
                ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        if(!schemasSharedDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create schemas directory: {0}",
                    schemasSharedDir.getAbsolutePath()));
        }

        for(PgSchema schema : newDb.getSchemas()) {
            File schemaSQL = new File(schemasSharedDir, getExportedFilenameSql(schema));
            dumpSQL(schema.getCreationSQL(), schemaSQL);
        }

        // exporting extensions
        File extensionsDir = new File(outDir,
                ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name());
        if(!extensionsDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create extensions directory: {0}",
                    extensionsDir.getAbsolutePath()));
        }

        for(PgExtension ext : newDb.getExtensions()) {
            File extSQL = new File(extensionsDir, getExportedFilenameSql(ext));
            dumpSQL(ext.getCreationSQL(), extSQL);
        }

        // exporting schemas contents
        for(PgSchema schema : newDb.getSchemas()) {
            File schemaDir = new File(schemasSharedDir, getExportedFilename(schema));
            if(!schemaDir.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create schema directory: {0}",
                        schemaDir.getAbsolutePath()));
            }
            dumpFunctions(schema.getFunctions(), schemaDir);
            dumpObjects(schema.getSequences(), schemaDir, "SEQUENCE");
            dumpObjects(schema.getTypes(), schemaDir, "TYPE");
            dumpObjects(schema.getDomains(), schemaDir, "DOMAIN");
            dumpTables(schema.getTables(), schemaDir);
            dumpObjects(schema.getViews(), schemaDir, "VIEW");

            // indexes, triggers, constraints are dumped when tables are processed
        }
        writeProjVersion(new File(outDir.getPath(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpFunctions(List<PgFunction> funcs, File parentDir) throws IOException {
        if (funcs.isEmpty()) {
            return;
        }
        mkdirObjects(null, parentDir.getAbsolutePath());
        File funcDir = mkdirObjects(parentDir, "FUNCTION");

        Map<String, StringBuilder> dumps = new HashMap<>(funcs.size());
        for(PgFunction f : funcs) {
            String fileName = getExportedFilenameSql(f);
            StringBuilder groupedDump = dumps.get(fileName);
            if (groupedDump == null) {
                groupedDump = new StringBuilder(getDumpSql(f));
                dumps.put(fileName, groupedDump);
            } else {
                groupedDump.append(GROUP_DELIMITER).append(getDumpSql(f, false));
            }
        }
        for (Entry<String, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), new File(funcDir, dump.getKey()));
        }
    }

    private void dumpTables(List<PgTable> tables, File parentDir) throws IOException {
        if (tables.isEmpty()) {
            return;
        }
        mkdirObjects(null, parentDir.toString());
        File tablesDir = mkdirObjects(parentDir, "TABLE");

        for (PgTable table : tables) {
            StringBuilder groupSql = new StringBuilder(getDumpSql(table));

            for (PgConstraint constr : table.getConstraints()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(constr, false));
            }

            for (PgIndex idx : table.getIndexes()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(idx, false));
            }

            for (PgTrigger trig : table.getTriggers()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(trig, false));
            }

            dumpSQL(groupSql, new File(tablesDir, getExportedFilenameSql(table)));
        }
    }

    private void dumpObjects(List<? extends PgStatementWithSearchPath> objects,
            File parentOutDir, String objectDirName) throws IOException {
        if (objects.isEmpty()) {
            return;
        }
        mkdirObjects(null, parentOutDir.toString());
        File objectDir = mkdirObjects(parentOutDir, objectDirName);

        for(PgStatementWithSearchPath obj : objects) {
            dumpSQL(getDumpSql(obj), new File(objectDir, getExportedFilenameSql(obj)));
        }
    }

    private File mkdirObjects(File parentOutDir, String outDirName)
            throws NotDirectoryException, DirectoryException {
        File objectDir = new File(parentOutDir, outDirName);

        if(objectDir.exists()) {
            if(!objectDir.isDirectory()) {
                throw new NotDirectoryException(objectDir.getAbsolutePath());
            }
        } else {
            if(!objectDir.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create objects directory: {0}",
                        objectDir.getAbsolutePath()));
            }
        }
        return objectDir;
    }

    private void dumpSQL(CharSequence sql, File file) throws IOException {
        if(file.exists()) {
            throw new FileAlreadyExistsException(file.getAbsolutePath());
        }

        if(!file.createNewFile()) {
            throw new FileException(MessageFormat.format(
                    "Cannot create sql output file: {0}",
                    file.getAbsolutePath()));
        }

        try(PrintWriter outFile = new UnixPrintWriter(file, sqlEncoding)) {
            outFile.println(sql);
        }
    }

    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        String name = statement.getBareName();
        Matcher m = INVALID_FILENAME.matcher(name);
        if (m.find()) {
            boolean bareNameGrouped = statement instanceof PgFunction;
            String hash = PgDiffUtils.md5(
                    bareNameGrouped? statement.getBareName() : statement.getName())
                    // 2^40 variants, should be enough for this purpose
                    .substring(0, HASH_LENGTH);

            return m.replaceAll("") + '_' + hash;
        } else {
            return name;
        }
    }

    private static String getExportedFilenameSql(PgStatement statement) {
        return getExportedFilename(statement) + ".sql";
    }

    private String getDumpSql(PgStatementWithSearchPath statement) {
        return getDumpSql(statement, true);
    }

    private String getDumpSql(PgStatementWithSearchPath statement, boolean searchPath) {
        return searchPath ? statement.getSearchPath() + "\n\n" + statement.getFullSQL() :
            statement.getFullSQL();
    }

    private void writeProjVersion(File f) throws IOException {
        try (PrintWriter pw = new UnixPrintWriter(f, ApgdiffConsts.UTF_8)) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = "
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }

    private String getRelativeFilePath(PgStatement st, boolean addExtension){
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ?
                null : ModelExporter.getExportedFilename(parentSt);

        File file = new File("SCHEMA");
        DbObjType type = st.getStatementType();
        switch (type) {
        case EXTENSION:
        case SCHEMA:
            file = new File(type.name());
            break;

        case SEQUENCE:
        case TYPE:
        case DOMAIN:
        case VIEW:
        case TABLE:
        case FUNCTION:
            file = new File(new File(file, parentExportedFileName), type.name());
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
            st = parentSt;
            String schemaName = ModelExporter.getExportedFilename(parentSt.getParent());
            file = new File(new File(file, schemaName), "TABLE");
            break;

        case DATABASE:
        }

        return new File(file, addExtension ?
                getExportedFilenameSql(st) : getExportedFilename(st)).toString();
    }
}
