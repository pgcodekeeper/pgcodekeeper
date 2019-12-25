package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;
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
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class ModelExporter extends AbstractModelExporter {

    public ModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public ModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected void deleteObject(TreeElement el) throws IOException {
        PgStatement st = el.getPgStatement(oldDb);

        switch (st.getStatementType()) {
        case SCHEMA:
            // delete schema sql file
            deleteStatementIfExists(st);

            // delete schema's folder content
            Path schemaFolder = outDir.resolve(getRelativeFilePath(st, false));
            if (Files.exists(schemaFolder)) {
                Log.log(Log.LOG_INFO, "Deleting schema folder for schema " + el.getName()); //$NON-NLS-1$
                FileUtils.deleteRecursive(schemaFolder);
            }
            break;
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
        case OPERATOR:
            processFuncOrOper(el, st);
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
            TreeElement elParent = el.getParent();
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
                    outDir.resolve(getRelativeFilePath(stInNew, true)));
            break;
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
        case OPERATOR:
            createParentSchema(elParent);
            processFuncOrOper(el, stInNew);
            break;
        case CONSTRAINT:
        case INDEX:
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
        case VIEW:
            createParentSchema(elParent);
            processViewAndContents(el, stInNew, el);
            break;
        default:
            // remove old version
            deleteStatementIfExists(stInNew);

            createParentSchema(elParent);
            // dump new version
            dumpSQL(getDumpSql(stInNew), outDir.resolve(getRelativeFilePath(stInNew, true)));
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
        Path path = outDir.resolve(getRelativeFilePath(st, true));
        if (Files.notExists(path)) {
            dumpSQL(st.getCreationSQL(), path);
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
            dumpSQL(stInNew.getFullSQL(), outDir.resolve(getRelativeFilePath(stInNew, true)));
            break;
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
        case OPERATOR:
            createParentSchema(elParent);
            processFuncOrOper(el, stInNew);
            break;
        case TRIGGER:
        case RULE:
        case INDEX:
        case CONSTRAINT:
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
            dumpSQL(getDumpSql(stInNew), outDir.resolve(getRelativeFilePath(stInNew, true)));
        }
    }

    private Collection<? extends PgStatement> getAbstrFuncsOrOpers(AbstractSchema schema, DbObjType type) {
        switch(type) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            return schema.getFunctions().stream()
                    .filter(s -> type == s.getStatementType())
                    .collect(Collectors.toList());
        case OPERATOR:
            return schema.getOperators();
        default:
            throw new IllegalArgumentException(type.name() + " type is not allowed.");
        }
    }

    private PgStatement getAbstrFuncOrOper(AbstractSchema schema, String name, DbObjType type) {
        switch(type) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            return schema.getFunctions().stream()
                    .filter(s -> type == s.getStatementType() && name.equals(s.getName()))
                    .findAny().orElse(null);
        case OPERATOR:
            return schema.getOperator(name);
        default:
            throw new IllegalArgumentException(type.name() + " type is not allowed.");
        }
    }

    private void processFuncOrOper(TreeElement el, PgStatement st) throws IOException {
        TreeElement elParent = el.getParent();
        if (elParent.getSide() == DiffSide.LEFT && elParent.isSelected()) {
            // if the whole parent schema is to be deleted
            return;
        }

        List<PgStatement> toDump = new LinkedList<>();
        AbstractSchema newParentSchema = newDb.getSchema(st.getParent().getName());
        AbstractSchema oldParentSchema = oldDb.getSchema(st.getParent().getName());

        DbObjType type = st.getStatementType();

        // prepare the overloaded abstrFunctionOrOperator list as if there are no changes
        if (oldParentSchema != null) {
            for (PgStatement oldFuncOrOper : getAbstrFuncsOrOpers(oldParentSchema, type)) {
                if (oldFuncOrOper.getBareName().equals(st.getBareName())) {
                    toDump.add(oldFuncOrOper);
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
            TreeElement elAbstrFuncOrOper = it.next();
            if (elAbstrFuncOrOper.getType() != type) {
                continue;
            }

            // final required abstrFunctionOrOperator state
            String elName = elAbstrFuncOrOper.getName();
            PgStatement primary = getAbstrFuncOrOper(elAbstrFuncOrOper.getSide() == DiffSide.LEFT ?
                    oldParentSchema : newParentSchema, elName, type);
            if (primary == null || !primary.getBareName().equals(st.getBareName())
                    || !primary.getParent().getName().equals(elAbstrFuncOrOper.getParent().getName())) {
                continue;
            }

            switch (elAbstrFuncOrOper.getSide()) {
            case LEFT:
                toDump.remove(primary);
                break;
            case RIGHT:
                toDump.add(primary);
                break;
            case BOTH:
                toDump.set(
                        toDump.indexOf(getAbstrFuncOrOper(oldParentSchema, elName, type)),
                        primary);
                break;
            }

            // no further actions required after this processing
            // all overloads are processed in bulk and removed from the changes list
            it.remove();
        }

        // delete functionOrOperator sql file
        deleteStatementIfExists(st);

        Path path = outDir.resolve(getRelativeFilePath(
                newParentSchema == null ? oldParentSchema : newParentSchema, false));

        dumpAbstrFunctionsOrOperators(toDump, path, type);
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
        if (Files.exists(outDir)) {
            if (!Files.isDirectory(outDir)) {
                throw new NotDirectoryException(outDir.toString());
            }

            for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
                if (Files.exists(outDir.resolve(subdirName.name()))) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.",
                            subdirName));
                }
            }
        } else {
            Files.createDirectories(outDir);
        }

        // exporting extensions
        Path extensionsDir = outDir.resolve(
                ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.name());

        for (PgExtension ext : newDb.getExtensions()) {
            dumpSQL(ext.getCreationSQL(), extensionsDir.resolve(getExportedFilenameSql(ext)));
        }

        // exporting schemas
        Path schemasSharedDir = outDir.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.name());

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {

            Path schemaDir = schemasSharedDir.resolve(getExportedFilename(schema));

            Path schemaSQL = schemaDir.resolve(getExportedFilenameSql(schema));
            dumpSQL(schema.getCreationSQL(), schemaSQL);

            dumpAbstrFunctionsOrOperators(getAbstrFuncsOrOpers(schema, DbObjType.FUNCTION), schemaDir, DbObjType.FUNCTION);
            dumpAbstrFunctionsOrOperators(getAbstrFuncsOrOpers(schema, DbObjType.PROCEDURE), schemaDir, DbObjType.PROCEDURE);
            dumpAbstrFunctionsOrOperators(getAbstrFuncsOrOpers(schema, DbObjType.AGGREGATE), schemaDir, DbObjType.AGGREGATE);
            dumpAbstrFunctionsOrOperators(schema.getOperators(), schemaDir, DbObjType.OPERATOR);
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
        writeProjVersion(outDir.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpAbstrFunctionsOrOperators(Collection<? extends PgStatement> abstrFuncsOrOpers,
            Path parentDir, DbObjType type) throws IOException {
        if (abstrFuncsOrOpers.isEmpty()) {
            return;
        }

        Map<String, StringBuilder> dumps = new HashMap<>(abstrFuncsOrOpers.size());
        for (PgStatement stmt : abstrFuncsOrOpers) {
            String fileName = getExportedFilenameSql(stmt);
            StringBuilder groupedDump = dumps.get(fileName);
            if (groupedDump == null) {
                groupedDump = new StringBuilder(getDumpSql(stmt));
                dumps.put(fileName, groupedDump);
            } else {
                groupedDump.append(GROUP_DELIMITER).append(getDumpSql(stmt));
            }
        }

        Path folder = parentDir.resolve(type.name());

        for (Entry<String, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), folder.resolve(dump.getKey()));
        }
    }

    private void dumpObjects(Collection<? extends PgStatementWithSearchPath> objects,
            Path parentOutDir) throws IOException {
        if (!objects.isEmpty()) {
            Path objectDir = parentOutDir.resolve(objects.iterator().next()
                    .getStatementType().name());

            for (PgStatementWithSearchPath obj : objects) {
                String dump = getDumpSql(obj);
                if (obj.hasChildren()) {
                    StringBuilder groupSql = new StringBuilder(dump);
                    // only tables and views can be here
                    obj.getChildren().map(st -> (PgStatementWithSearchPath)st).sorted(new ExportTableOrder())
                    .forEach(st -> groupSql.append(GROUP_DELIMITER).append(getDumpSql(st)));
                    dump = groupSql.toString();
                }

                dumpSQL(dump, objectDir.resolve(getExportedFilenameSql(obj)));
            }
        }
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return getRelativeFilePath(st, Paths.get(""), addExtension);
    }

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension) {
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ?
                null : ModelExporter.getExportedFilename(parentSt);

        Path path = baseDir.resolve("SCHEMA");
        DbObjType type = st.getStatementType();
        String schemaName;
        switch (type) {
        case EXTENSION:
            path = baseDir.resolve(type.name());
            break;

        case SCHEMA:
            path = path.resolve(getExportedFilename(st));
            if (!addExtension) {
                // return schema dir path
                return path;
            }
            break;

        case SEQUENCE:
        case TYPE:
        case DOMAIN:
        case VIEW:
        case TABLE:
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
        case OPERATOR:
        case FTS_TEMPLATE:
        case FTS_PARSER:
        case FTS_DICTIONARY:
        case FTS_CONFIGURATION:
            path = path.resolve(parentExportedFileName).resolve(type.name());
            break;

        case CONSTRAINT:
        case INDEX:
        case RULE:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            schemaName = ModelExporter.getExportedFilename(parentSt.getParent());
            path = path.resolve(schemaName).resolve(parentSt.getStatementType().name());
            break;
        default:
            break;
        }

        return path.resolve(addExtension ?
                getExportedFilenameSql(st) : getExportedFilename(st));
    }
}
