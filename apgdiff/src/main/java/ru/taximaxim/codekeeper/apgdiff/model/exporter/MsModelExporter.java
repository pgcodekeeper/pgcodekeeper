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
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.MsUser;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class MsModelExporter extends AbstractModelExporter {

    // move to enum?
    private static final String TABLES_FOLDER = "Tables";
    private static final String VIEWS_FOLDER = "Views";
    private static final String SEQUENCES_FOLDER = "Sequences";
    private static final String FUNCTIONS_FOLDER = "Functions";
    private static final String PROCEDURE_FOLDER = "Stored Procedures";
    private static final String SECURITY_FOLDER = "Security";
    private static final String SCHEMAS_FOLDER = "Schemas";
    private static final String ASSEMBLIES_FOLDER = "Assemblies";
    private static final String ROLES_FOLDER = "Roles";
    private static final String USERS_FOLDER = "Users";

    public MsModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public MsModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    public void exportFull() throws IOException {
        String[] dirs = new String[] { ASSEMBLIES_FOLDER,
                SEQUENCES_FOLDER, SECURITY_FOLDER, PROCEDURE_FOLDER,
                FUNCTIONS_FOLDER, TABLES_FOLDER, VIEWS_FOLDER};

        if (outDir.exists()) {
            if (!outDir.isDirectory()) {
                throw new NotDirectoryException(outDir.getAbsolutePath());
            }

            for (String subdir : dirs) {
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


        for (String subdir : dirs) {
            File folder = new File(outDir, subdir);
            if (!folder.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create {0} folder: {1}", subdir,
                        folder.getAbsolutePath()));
            }
        }


        File securityFolder = new File(outDir, SECURITY_FOLDER);

        // exporting schemas
        File schemasSharedDir = new File(securityFolder, SCHEMAS_FOLDER);
        if (!schemasSharedDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create schemas directory: {0}",
                    schemasSharedDir.getAbsolutePath()));
        }

        File usersFolder = new File(securityFolder, USERS_FOLDER);
        for (MsUser user : newDb.getUsers()) {
            dumpSQL(getDumpSql(user), new File(usersFolder, getExportedFilenameSql(user)));
        }

        File rolesFolder = new File(securityFolder, ROLES_FOLDER);
        for (MsRole role : newDb.getRoles()) {
            dumpSQL(getDumpSql(role), new File(rolesFolder, getExportedFilenameSql(role)));
        }

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {
            dumpSQL(getDumpSql(schema), new File(schemasSharedDir, getExportedFilenameSql(schema)));

            dumpFunctions(schema.getFunctions());
            dumpObjects(schema.getSequences(), new File(outDir, SEQUENCES_FOLDER));
            dumpObjects(schema.getTables(), new File(outDir, TABLES_FOLDER));
            dumpObjects(schema.getViews(), new File(outDir, VIEWS_FOLDER));

            // indexes, triggers, rules, constraints are dumped when tables are processed
        }

        File assembliesFolder = new File(outDir, ASSEMBLIES_FOLDER);
        for (MsAssembly assembly : newDb.getAssemblies()) {
            dumpSQL(getDumpSql(assembly), new File(assembliesFolder, getExportedFilenameSql(assembly)));
        }

        writeProjVersion(new File(outDir.getPath(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpFunctions(List<AbstractFunction> funcs) throws IOException {
        for (PgStatementWithSearchPath obj : funcs) {
            String schemaName = getExportedFilename(obj.getContainingSchema());
            String objectName = getExportedFilenameSql(obj);

            String dirName = obj.getStatementType() == DbObjType.PROCEDURE ?
                    PROCEDURE_FOLDER : FUNCTIONS_FOLDER;

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
            dumpObjects(Arrays.asList((PgStatementWithSearchPath)stInNew),
                    new File(outDir, SEQUENCES_FOLDER));
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
                    new File(outDir, SEQUENCES_FOLDER));
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

            file = new File(SECURITY_FOLDER, SCHEMAS_FOLDER);
            if (!addExtension) {
                // return schema dir path
                return file.toString();
            }
            break;

        case SEQUENCE:
            file = new File(SEQUENCES_FOLDER);
            break;
        case VIEW:
            file = new File(VIEWS_FOLDER);
            break;
        case TABLE:
            file = new File(TABLES_FOLDER);
            break;
        case FUNCTION:
            file = new File(FUNCTIONS_FOLDER);
            break;
        case PROCEDURE:
            file = new File(PROCEDURE_FOLDER);
            break;

        case CONSTRAINT:
        case INDEX:
        case RULE:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            file = new File(parentSt.getStatementType() == DbObjType.TABLE ?
                    TABLES_FOLDER : VIEWS_FOLDER);
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
        String folder = type == DbObjType.TABLE ? TABLES_FOLDER : VIEWS_FOLDER;

        File parentDir =  new File(outDir, folder);

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
