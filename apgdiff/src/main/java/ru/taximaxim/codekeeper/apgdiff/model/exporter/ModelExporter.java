package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
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
                Log.log(Log.LOG_INFO, "Deleting schema folder for schema " + el.getName()); //$NON-NLS-1$
                FileUtils.deleteRecursive(schemaFolder.toPath());
            }
            break;

        case FUNCTION:
            processFunction(el, st);
            break;

        case CONSTRAINT:
        case INDEX:
            TreeElement elParent = el.getParent();
            processTableAndContents(elParent, elParent.getPgStatement(oldDb), el);
            break;

        case TRIGGER:
        case RULE:
            elParent = el.getParent();
            if (elParent.getType() == DbObjType.TABLE){
                processTableAndContents(elParent, elParent.getPgStatement(oldDb), el);
            } else {
                processViewAndContents(elParent, elParent.getPgStatement(oldDb), el);
            }
            break;

        default:
            deleteStatementIfExists(st);
        }
    }

    private void editObject(TreeElement el) throws IOException, PgCodekeeperException{
        PgStatement stInNew = el.getPgStatement(newDb);
        TreeElement elParent = el.getParent();

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
            createParentSchema(elParent);
            processFunction(el, stInNew);
            break;

        case CONSTRAINT:
        case INDEX:
            createParentSchema(elParent.getParent());
            processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            break;

        case TRIGGER:
        case RULE:
            createParentSchema(elParent.getParent());
            if (elParent.getType() == DbObjType.TABLE) {
                processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            } else {
                processViewAndContents(elParent, elParent.getPgStatement(newDb), el);
            }
            break;


        case TABLE:
            createParentSchema(elParent);
            processTableAndContents(el, stInNew, el);
            break;

        default:
            // remove old version
            deleteStatementIfExists(stInNew);

            createParentSchema(elParent);
            // dump new version
            dumpSQL(getDumpSql(stInNew), new File(outDir, getRelativeFilePath(stInNew, true)));
        }
    }

    /**
     * Create parent schema file, if not exists.
     *
     * @throws PgCodekeeperException if this object is not to be created or is to be deleted
     * @throws IOException - if an I/O error occurs
     */
    private void createParentSchema(TreeElement el) throws PgCodekeeperException, IOException {
        if (el.getSide() == DiffSide.RIGHT && !el.isSelected()
                || el.getSide() == DiffSide.LEFT && el.isSelected()) {
            throw new PgCodekeeperException(
                    "Parent schema either will not be created (NEW) or is deleted already along with its schema folder");
        }

        PgStatement st = el.getPgStatement(newDb);
        File file = new File(outDir, getRelativeFilePath(st, true));
        if (!file.exists()) {
            dumpSQL(st.getCreationSQL(), file);
        }
    }

    private void createObject(TreeElement el) throws IOException, PgCodekeeperException {
        PgStatement stInNew = el.getPgStatement(newDb);
        TreeElement elParent = el.getParent();

        switch (stInNew.getStatementType()) {
        case SCHEMA:
            // delete schema if already exists
            deleteStatementIfExists(stInNew);
            // $FALL-THROUGH$
        case EXTENSION:
            // export schema/extension sql file
            dumpSQL(stInNew.getFullSQL(), new File (outDir, getRelativeFilePath(stInNew, true)));
            break;

        case FUNCTION:
            createParentSchema(elParent);
            processFunction(el, stInNew);
            break;

        case CONSTRAINT:
        case INDEX:
            createParentSchema(elParent.getParent());
            // table actually, not schema
            createParentSchema(elParent);
            processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            break;

        case TRIGGER:
        case RULE:
            createParentSchema(elParent.getParent());
            // table actually, not schema
            createParentSchema(elParent);
            if (elParent.getType() == DbObjType.TABLE){
                processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            } else {
                processViewAndContents(elParent, elParent.getPgStatement(newDb), el);
            }
            break;

        case TABLE:
            createParentSchema(elParent);
            processTableAndContents(el, stInNew, el);
            break;

        case VIEW:
            createParentSchema(elParent);
            processViewAndContents(el, stInNew, el);
            break;

        default:
            createParentSchema(elParent);
            dumpObjects(Arrays.asList((PgStatementWithSearchPath)stInNew),
                    new File(new File(outDir, "SCHEMA"), getExportedFilename(stInNew.getParent())));
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

        List<AbstractFunction> funcsToDump = new LinkedList<>();
        AbstractSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());

        // prepare the overloaded function list as if there are no changes
        if (oldParentSchema != null) {
            for (AbstractFunction oldFunc : oldParentSchema.getFunctions()) {
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
            AbstractFunction funcPrimary = (elFunc.getSide() == DiffSide.LEFT ?
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
     * @param elCause The element that caused the table processing.
     * It is expected to be popped from the {@link #changeList}.
     */
    private void processTableAndContents(TreeElement el, PgStatement st,
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

        dumpContainer(tablePrimary, contents, new File(outDir, getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false)));
    }

    /**
     * @param elCause The element that caused the table processing.
     * It is expected to be popped from the {@link #changeList}.
     */
    private void processViewAndContents(TreeElement el, PgStatement st,
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

        dumpContainer(viewPrimary, contents, new File(outDir, getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false)));
    }


    private void dumpContainer(PgStatement obj, List<PgStatementWithSearchPath> contents,
            File parentDir) throws IOException {
        mkdirObjects(null, parentDir.toString());
        DbObjType type = obj.getStatementType();

        File tablesDir = mkdirObjects(parentDir, type.name());

        if (type == DbObjType.TABLE) {
            Collections.sort(contents, ExportTableOrder.INSTANCE);
        }

        StringBuilder groupSql = new StringBuilder(getDumpSql(obj));

        for (PgStatementWithSearchPath st : contents) {
            groupSql.append(GROUP_DELIMITER).append(getDumpSql(st));
        }

        dumpSQL(groupSql, new File(tablesDir, getExportedFilenameSql(obj)));
    }

    /*
     * =============================================
     * FULL EXPORT PART
     * =============================================
     */
    /**
     * Starts the {@link #newDb} export process.
     */
    public void exportFull() throws IOException {
        if (outDir.exists()) {
            if (!outDir.isDirectory()) {
                throw new NotDirectoryException(outDir.getAbsolutePath());
            }

            for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
                if (new File(outDir, subdirName.name()).exists()) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.",
                            subdirName));
                }
            }
        } else if (!outDir.mkdirs()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create output directory: {0}",
                    outDir.getAbsolutePath()));
        }

        // exporting extensions
        File extensionsDir = new File(outDir,
                ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name());
        if (!extensionsDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create extensions directory: {0}",
                    extensionsDir.getAbsolutePath()));
        }

        for (PgExtension ext : newDb.getExtensions()) {
            File extSQL = new File(extensionsDir, getExportedFilenameSql(ext));
            dumpSQL(ext.getCreationSQL(), extSQL);
        }

        // exporting schemas
        File schemasSharedDir = new File(outDir,
                ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());
        if (!schemasSharedDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create schemas directory: {0}",
                    schemasSharedDir.getAbsolutePath()));
        }

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {
            File schemaDir = new File(schemasSharedDir, getExportedFilename(schema));
            if (!schemaDir.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create schema directory: {0}",
                        schemaDir.getAbsolutePath()));
            }

            File schemaSQL = new File(schemaDir, getExportedFilenameSql(schema));
            dumpSQL(schema.getCreationSQL(), schemaSQL);

            dumpFunctions(schema.getFunctions(), schemaDir);
            dumpObjects(schema.getSequences(), schemaDir);
            dumpObjects(schema.getTypes(), schemaDir);
            dumpObjects(schema.getDomains(), schemaDir);
            dumpObjects(schema.getTables(), schemaDir);
            dumpObjects(schema.getViews(), schemaDir);
            dumpObjects(schema.getFtsParsers(), schemaDir);
            dumpObjects(schema.getFtsTemplates(), schemaDir);
            dumpObjects(schema.getFtsDictionaries(), schemaDir);
            dumpObjects(schema.getFtsConfigurations(), schemaDir);

            // indexes, triggers, rules, constraints are dumped when tables are processed
        }
        writeProjVersion(new File(outDir.getPath(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpFunctions(List<AbstractFunction> funcs, File parentDir) throws IOException {
        if (funcs.isEmpty()) {
            return;
        }
        mkdirObjects(null, parentDir.getAbsolutePath());
        File funcDir = mkdirObjects(parentDir, "FUNCTION");

        Map<String, StringBuilder> dumps = new HashMap<>(funcs.size());
        for (AbstractFunction f : funcs) {
            String fileName = getExportedFilenameSql(f);
            StringBuilder groupedDump = dumps.get(fileName);
            if (groupedDump == null) {
                groupedDump = new StringBuilder(getDumpSql(f));
                dumps.put(fileName, groupedDump);
            } else {
                groupedDump.append(GROUP_DELIMITER).append(getDumpSql(f));
            }
        }
        for (Entry<String, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), new File(funcDir, dump.getKey()));
        }
    }

    private void dumpObjects(List<? extends PgStatementWithSearchPath> objects,
            File parentOutDir) throws IOException {
        if (!objects.isEmpty()) {
            mkdirObjects(null, parentOutDir.toString());
            File objectDir = mkdirObjects(parentOutDir, objects.get(0).getStatementType().name());

            for (PgStatementWithSearchPath obj : objects) {
                String dump = getDumpSql(obj);
                if (obj.hasChildren()) {
                    StringBuilder groupSql = new StringBuilder(dump);
                    // only tables and views can be here
                    obj.getChildren().map(st -> (PgStatementWithSearchPath)st).sorted(new ExportTableOrder())
                    .forEach(st -> groupSql.append(GROUP_DELIMITER).append(getDumpSql(st)));
                    dump = groupSql.toString();
                }

                dumpSQL(dump, new File(objectDir, getExportedFilenameSql(obj)));
            }
        }
    }

    private File mkdirObjects(File parentOutDir, String outDirName)
            throws NotDirectoryException, DirectoryException {
        File objectDir = new File(parentOutDir, outDirName);

        if (objectDir.exists()) {
            if(!objectDir.isDirectory()) {
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

    private void dumpSQL(CharSequence sql, File file) throws IOException {
        Files.createDirectories(file.toPath().getParent());
        try (PrintWriter outFile = new UnixPrintWriter(Files.newOutputStream(file.toPath(),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), sqlEncoding)) {
            outFile.println(sql);
        }
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

    public static String getExportedFilenameSql(String name) {
        return getExportedFilename(name) + ".sql"; //$NON-NLS-1$
    }

    private String getDumpSql(PgStatement statement) {
        return statement.getFullSQL();
    }

    public static void writeProjVersion(File f) throws FileNotFoundException {
        try (PrintWriter pw = new UnixPrintWriter(f, StandardCharsets.UTF_8)) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }

    /**
     * @param addExtension whether to add .sql extension to the path
     *      for schemas, no extension also means to get schema dir path,
     *      one segment shorter than file location since schema files
     *      are now stored in schema dirs
     */
    public static String getRelativeFilePath(PgStatement st, boolean addExtension){
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ?
                null : ModelExporter.getExportedFilename(parentSt);

        File file = new File("SCHEMA");
        DbObjType type = st.getStatementType();
        String schemaName;
        switch (type) {
        case EXTENSION:
            file = new File(type.name());
            break;

        case SCHEMA:
            file = new File(file, getExportedFilename(st));
            if (!addExtension) {
                // return schema dir path
                return file.toString();
            }
            break;

        case SEQUENCE:
        case TYPE:
        case DOMAIN:
        case VIEW:
        case TABLE:
        case FUNCTION:
        case PROCEDURE:
        case FTS_TEMPLATE:
        case FTS_PARSER:
        case FTS_DICTIONARY:
        case FTS_CONFIGURATION:
            file = new File(new File(file, parentExportedFileName), type.name());
            break;

        case CONSTRAINT:
        case INDEX:
        case RULE:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            schemaName = ModelExporter.getExportedFilename(parentSt.getParent());
            file = new File(new File(file, schemaName), parentSt.getStatementType().name());
            break;
        default:
            break;
        }

        return new File(file, addExtension ?
                getExportedFilenameSql(st) : getExportedFilename(st)).toString();
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
