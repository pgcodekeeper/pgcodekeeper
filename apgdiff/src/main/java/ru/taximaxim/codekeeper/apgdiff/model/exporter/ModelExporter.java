package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class ModelExporter extends AbstractModelExporter {

    public ModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public ModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected void deleteStatementIfExists(PgStatement st) throws IOException {
        Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true));
        Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() +
                " for object " + st.getStatementType() + ' ' + st.getName());
        Files.deleteIfExists(toDelete);
    }

    @Override
    protected void deleteObject(TreeElement el) throws IOException {
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
        case OPERATOR:
            processFuncOrOper(el, st);
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

    @Override
    protected void editObject(TreeElement el) throws IOException, PgCodekeeperException {
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
        case OPERATOR:
            createParentSchema(elParent);
            processFuncOrOper(el, stInNew);
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

    @Override
    protected void createObject(TreeElement el) throws IOException, PgCodekeeperException {
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
        case OPERATOR:
            createParentSchema(elParent);
            processFuncOrOper(el, stInNew);
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

    private List<PgStatement> getFuncsOrOpers(AbstractSchema schema, boolean isFunc) {
        return (isFunc ? schema.getFunctions() : schema.getOperators())
                .stream().map(funcOrOper -> (PgStatement) funcOrOper).collect(Collectors.toList());
    }

    private void processFuncOrOper(TreeElement el, PgStatement st) throws IOException {
        TreeElement elParent = el.getParent();
        if (elParent.getSide() == DiffSide.LEFT && elParent.isSelected()) {
            // if the whole parent schema is to be deleted
            return;
        }
        // delete functionOrOperator sql file
        deleteStatementIfExists(st);

        List<PgStatement> funcOrOpersToDump = new LinkedList<>();
        AbstractSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());

        DbObjType type = st.getStatementType();
        boolean isFunc = DbObjType.FUNCTION == type;

        // prepare the overloaded functionOrOperator list as if there are no changes
        if (oldParentSchema != null) {
            for (PgStatement oldFuncOrOper : getFuncsOrOpers(oldParentSchema, isFunc)) {
                if (oldFuncOrOper.getBareName().equals(st.getBareName())) {
                    funcOrOpersToDump.add(oldFuncOrOper);
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
            TreeElement elFuncOrOper = it.next();
            if (elFuncOrOper.getType() != type) {
                continue;
            }

            // final required functionOrOperator state
            AbstractSchema defSch = elFuncOrOper.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema;
            String elName = elFuncOrOper.getName();
            PgStatement funcOperPrimary = isFunc ? defSch.getFunction(elName) : defSch.getOperator(elName);
            if (funcOperPrimary == null || !funcOperPrimary.getBareName().equals(st.getBareName())
                    || !funcOperPrimary.getParent().getName().equals(elFuncOrOper.getParent().getName())) {
                continue;
            }

            switch (elFuncOrOper.getSide()) {
            case LEFT:
                funcOrOpersToDump.remove(funcOperPrimary);
                break;
            case RIGHT:
                funcOrOpersToDump.add(funcOperPrimary);
                break;
            case BOTH:
                funcOrOpersToDump.set(
                        funcOrOpersToDump.indexOf(oldParentSchema.getOperator(elFuncOrOper.getName())),
                        funcOperPrimary);
                break;
            }

            // no further actions required after this processing
            // all overloads are processed in bulk and removed from the changes list
            it.remove();
        }

        dumpFunctionsOrOperators(funcOrOpersToDump, new File(outDir, getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false)), type);
    }

    @Override
    protected void dumpContainer(PgStatement obj, List<PgStatementWithSearchPath> contents,
            AbstractSchema schema) throws IOException {
        File parentDir =  new File(outDir, getRelativeFilePath(schema, false));

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
    @Override
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

            dumpFunctionsOrOperators(getFuncsOrOpers(schema, true), schemaDir, DbObjType.FUNCTION);
            dumpFunctionsOrOperators(getFuncsOrOpers(schema, false), schemaDir, DbObjType.OPERATOR);
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
        writeProjVersion(new File(outDir.getPath(), ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpFunctionsOrOperators(List<PgStatement> funcsOrOpers,
            File parentDir, DbObjType type) throws IOException {
        if (funcsOrOpers.isEmpty()) {
            return;
        }
        mkdirObjects(null, parentDir.getAbsolutePath());
        File funcDir = mkdirObjects(parentDir, type.name());

        Map<String, StringBuilder> dumps = new HashMap<>(funcsOrOpers.size());
        for (PgStatement stmt : funcsOrOpers) {
            String fileName = getExportedFilenameSql(stmt);
            StringBuilder groupedDump = dumps.get(fileName);
            if (groupedDump == null) {
                groupedDump = new StringBuilder(getDumpSql(stmt));
                dumps.put(fileName, groupedDump);
            } else {
                groupedDump.append(GROUP_DELIMITER).append(getDumpSql(stmt));
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
        case OPERATOR:
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
