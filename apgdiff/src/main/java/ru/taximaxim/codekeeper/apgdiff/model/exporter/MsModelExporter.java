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
import java.util.Iterator;
import java.util.List;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class MsModelExporter extends AbstractModelExporter {

    private static final String SCHEMAS_FOLDER = "Schemas";

    public MsModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public MsModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    public void exportFull() throws IOException {
        if (outDir.exists()) {
            if (!outDir.isDirectory()) {
                throw new NotDirectoryException(outDir.getAbsolutePath());
            }

            for (MS_WORK_DIR_NAMES sub : MS_WORK_DIR_NAMES.values()) {
                String subdir = sub.getName();
                if (new File(outDir, subdir).exists()) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.", subdir));
                }
            }
        } else if (!outDir.mkdirs()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create output directory: {0}",
                    outDir.getAbsolutePath()));
        }


        for (MS_WORK_DIR_NAMES sub : MS_WORK_DIR_NAMES.values()) {
            String subdir = sub.getName();
            File folder = new File(outDir, subdir);
            if (!folder.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create {0} folder: {1}", subdir,
                        folder.getAbsolutePath()));
            }
        }


        File securityFolder = new File(outDir, MS_WORK_DIR_NAMES.SECURITY.getName());

        // TODO Security folder contains schemas, roles and users

        // exporting schemas
        File schemasSharedDir = new File(securityFolder, SCHEMAS_FOLDER);
        if (!schemasSharedDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create schemas directory: {0}",
                    schemasSharedDir.getAbsolutePath()));
        }

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {
            dumpSQL(getDumpSql(schema), new File(schemasSharedDir, getExportedFilenameSql(schema)));

            dumpFunctions(schema.getFunctions());
            dumpObjects(schema.getSequences(), new File(outDir, MS_WORK_DIR_NAMES.SEQUENCES.getName()));
            dumpObjects(schema.getTables(), new File(outDir, MS_WORK_DIR_NAMES.TABLES.getName()));
            dumpObjects(schema.getViews(), new File(outDir, MS_WORK_DIR_NAMES.VIEWS.getName()));

            // indexes, triggers, rules, constraints are dumped when tables are processed
        }

        writeProjVersion(new File(outDir.getPath(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER), true);
    }

    @Override
    public void exportPartial() throws IOException, PgCodekeeperException {
        super.exportPartial(true);
    }

    private void dumpFunctions(List<AbstractFunction> funcs) throws IOException {
        for (PgStatementWithSearchPath obj : funcs) {
            String schemaName = getExportedFilename(obj.getContainingSchema());
            String objectName = getExportedFilenameSql(obj);

            String dirName = obj.getStatementType() == DbObjType.PROCEDURE ?
                    MS_WORK_DIR_NAMES.PROCEDURES.getName() : MS_WORK_DIR_NAMES.FUNCTIONS.getName();

                    File parentOutDir = new File(outDir, dirName);
                    dumpSQL(getDumpSql(obj), new File(parentOutDir, schemaName + '.' + objectName));
        }
    }

    private void dumpObjects(List<? extends PgStatementWithSearchPath> objects,
            File parentOutDir) throws IOException {
        for (PgStatementWithSearchPath obj : objects) {
            String dump = getDumpSql(obj);
            if (obj.hasChildren()) {
                StringBuilder groupSql = new StringBuilder(dump);
                // only tables and views can be here
                obj.getChildren().map(st -> (PgStatementWithSearchPath)st).sorted(new ExportTableOrder())
                .forEach(st -> groupSql.append(GROUP_DELIMITER).append(getDumpSql(st)));
                dump = groupSql.toString();
            }

            String schemaName = getExportedFilename(obj.getContainingSchema());
            String objectName = getExportedFilenameSql(obj);

            dumpSQL(dump, new File(parentOutDir, schemaName + '.' + objectName));
        }
    }

    @Override
    protected void deleteObject(TreeElement el) throws IOException {
        PgStatement st = el.getPgStatement(oldDb);

        switch (st.getStatementType()) {
        case SCHEMA:
            // delete schema sql file
            deleteStatementIfExists(st);

            // delete other statements
            Iterator<PgStatement> iter = st.getChildren().iterator();
            while (iter.hasNext()) {
                deleteStatementIfExists(iter.next());
            }

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
            // delete sql file
            deleteStatementIfExists(stInNew);

            // dump new version
            dumpSQL(stInNew.getFullSQL(),
                    new File(outDir, getRelativeFilePath(stInNew, true)));
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
            if (elParent.getType() == DbObjType.TABLE) {
                processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            } else {
                processViewAndContents(elParent, elParent.getPgStatement(newDb), el);
            }
            break;
        case PROCEDURE:
        case FUNCTION:
            deleteStatementIfExists(stInNew);
            dumpFunctions(Arrays.asList((AbstractFunction)stInNew));
            break;
        case TABLE:
            processTableAndContents(el, stInNew, el);
            break;
        case VIEW:
            processViewAndContents(el, stInNew, el);
            break;
        case SEQUENCE:
            deleteStatementIfExists(stInNew);
            dumpObjects(Arrays.asList((PgStatementWithSearchPath)stInNew),
                    new File(outDir, MS_WORK_DIR_NAMES.SEQUENCES.getName()));
            break;
        default:
            throw new IllegalStateException("Unsupported export type: " + stInNew.getStatementType());
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
            dumpSQL(stInNew.getFullSQL(), new File (outDir, getRelativeFilePath(stInNew, true)));
            break;

        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
            if (elParent.getType() == DbObjType.TABLE) {
                processTableAndContents(elParent, elParent.getPgStatement(newDb), el);
            } else {
                processViewAndContents(elParent, elParent.getPgStatement(newDb), el);
            }
            break;

        case TABLE:
            processTableAndContents(el, stInNew, el);
            break;

        case VIEW:
            processViewAndContents(el, stInNew, el);
            break;

        case SEQUENCE:
            dumpObjects(Arrays.asList((PgStatementWithSearchPath)stInNew),
                    new File(outDir, MS_WORK_DIR_NAMES.SEQUENCES.getName()));
            break;
        case FUNCTION:
        case PROCEDURE:
            dumpFunctions(Arrays.asList((AbstractFunction)stInNew));
            break;
        default:
            throw new IllegalStateException("Unsupported export type: " + stInNew.getStatementType());
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

        File file;
        DbObjType type = st.getStatementType();
        switch (type) {

        case SCHEMA:

            file = new File(MS_WORK_DIR_NAMES.SECURITY.getName(), SCHEMAS_FOLDER);
            if (!addExtension) {
                // return schema dir path
                return file.toString();
            }
            break;

        case SEQUENCE:
            file = new File(MS_WORK_DIR_NAMES.SEQUENCES.getName());
            break;
        case VIEW:
            file = new File(MS_WORK_DIR_NAMES.VIEWS.getName());
            break;
        case TABLE:
            file = new File(MS_WORK_DIR_NAMES.TABLES.getName());
            break;
        case FUNCTION:
            file = new File(MS_WORK_DIR_NAMES.FUNCTIONS.getName());
            break;
        case PROCEDURE:
            file = new File(MS_WORK_DIR_NAMES.PROCEDURES.getName());
            break;

        case CONSTRAINT:
        case INDEX:
        case RULE:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            file = new File(parentSt.getStatementType() == DbObjType.TABLE ?
                    MS_WORK_DIR_NAMES.TABLES.getName() : MS_WORK_DIR_NAMES.VIEWS.getName());
            break;
        default:
            throw new IllegalStateException("Unsupported export type: " + type);
        }

        String fileName = addExtension ? getExportedFilenameSql(st) : getExportedFilename(st);
        if (type != DbObjType.SCHEMA) {
            fileName = getExportedFilename(((PgStatementWithSearchPath)st)
                    .getContainingSchema().getName()) + '.' + fileName;
        }

        return new File(file, fileName).toString();
    }

    @Override
    protected void dumpContainer(PgStatement obj, List<PgStatementWithSearchPath> contents,
            AbstractSchema schema) throws IOException {
        DbObjType type = obj.getStatementType();
        MS_WORK_DIR_NAMES folder = type == DbObjType.TABLE ?
                MS_WORK_DIR_NAMES.TABLES : MS_WORK_DIR_NAMES.VIEWS;

        File parentDir =  new File(outDir, folder.getName());

        mkdirObjects(null, parentDir.toString());

        if (type == DbObjType.TABLE) {
            Collections.sort(contents, ExportTableOrder.INSTANCE);
        }

        StringBuilder groupSql = new StringBuilder(getDumpSql(obj));

        for (PgStatementWithSearchPath st : contents) {
            groupSql.append(GROUP_DELIMITER).append(getDumpSql(st));
        }

        dumpSQL(groupSql, new File(parentDir, getExportedFilename(
                obj.getParent().getName()) + '.' + getExportedFilenameSql(obj)));
    }

    @Override
    protected void deleteStatementIfExists(PgStatement st) throws IOException {
        Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true));
        Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() +
                " for object " + st.getStatementType() + ' ' + st.getName());
        Files.deleteIfExists(toDelete);
    }
}
