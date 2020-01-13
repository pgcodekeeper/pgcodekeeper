package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;

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
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class MsModelExporter extends AbstractModelExporter {

    private static final String SCHEMAS_FOLDER = "Schemas";
    private static final String USERS_FOLDER = "Users";
    private static final String ROLES_FOLDER = "Roles";

    public MsModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public MsModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    public void exportFull() throws IOException {
        if (Files.exists(outDir)) {
            if (!Files.isDirectory(outDir)) {
                throw new NotDirectoryException(outDir.toString());
            }

            for (MS_WORK_DIR_NAMES sub : MS_WORK_DIR_NAMES.values()) {
                String subdir = sub.getDirName();
                if (Files.exists(outDir.resolve(subdir))) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.", subdir));
                }
            }
        } else {
            Files.createDirectories(outDir);
        }


        for (MS_WORK_DIR_NAMES sub : MS_WORK_DIR_NAMES.values()) {
            String subdir = sub.getDirName();
            Path folder = outDir.resolve(subdir);
            Files.createDirectories(folder);
        }


        Path securityFolder = outDir.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName());

        // exporting schemas
        Path schemasSharedDir = securityFolder.resolve(SCHEMAS_FOLDER);

        Path usersFolder = securityFolder.resolve(USERS_FOLDER);
        for (MsUser user : newDb.getUsers()) {
            dumpSQL(getDumpSql(user), usersFolder.resolve(getExportedFilenameSql(user)));
        }

        Path rolesFolder = securityFolder.resolve(ROLES_FOLDER);
        for (MsRole role : newDb.getRoles()) {
            dumpSQL(getDumpSql(role), rolesFolder.resolve(getExportedFilenameSql(role)));
        }

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {
            dumpSQL(getDumpSql(schema), schemasSharedDir.resolve(getExportedFilenameSql(schema)));

            for (AbstractFunction func : schema.getFunctions()) {
                dumpSQL(getDumpSql(func), outDir.resolve(getRelativeFilePath(func, true)));
            }

            dumpObjects(schema.getSequences(), outDir.resolve(MS_WORK_DIR_NAMES.SEQUENCES.getDirName()));
            dumpObjects(schema.getTables(), outDir.resolve(MS_WORK_DIR_NAMES.TABLES.getDirName()));
            dumpObjects(schema.getViews(), outDir.resolve(MS_WORK_DIR_NAMES.VIEWS.getDirName()));

            // indexes, triggers, rules, constraints are dumped when tables are processed
        }

        Path assembliesFolder = outDir.resolve(MS_WORK_DIR_NAMES.ASSEMBLIES.getDirName());
        for (MsAssembly assembly : newDb.getAssemblies()) {
            dumpSQL(getDumpSql(assembly), assembliesFolder.resolve(getExportedFilenameSql(assembly)));
        }

        writeProjVersion(outDir.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpObjects(Collection<? extends PgStatementWithSearchPath> objects,
            Path parentOutDir) throws IOException {
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

            dumpSQL(dump, parentOutDir.resolve(schemaName + '.' + objectName));
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
        case ROLE:
        case USER:
        case ASSEMBLY:
        case SEQUENCE:
        case PROCEDURE:
        case FUNCTION:
        case TYPE:
            // delete sql file
            deleteStatementIfExists(stInNew);

            // dump new version
            dumpSQL(getDumpSql(stInNew),
                    outDir.resolve(getRelativeFilePath(stInNew, true)));
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
        case ASSEMBLY:
        case USER:
        case ROLE:
        case SEQUENCE:
        case FUNCTION:
        case PROCEDURE:
        case TYPE:
            // delete statement if already exists
            deleteStatementIfExists(stInNew);
            dumpSQL(getDumpSql(stInNew),
                    outDir.resolve(getRelativeFilePath(stInNew, true)));
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
        default:
            throw new IllegalStateException("Unsupported export type: " + stInNew.getStatementType());
        }
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return getRelativeFilePath(st, Paths.get(""), addExtension);
    }

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension){
        PgStatement parentSt = st.getParent();

        Path path = baseDir;
        DbObjType type = st.getStatementType();
        switch (type) {

        case SCHEMA:
            path = path.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName()).resolve(SCHEMAS_FOLDER);
            if (!addExtension) {
                return path;
            }
            break;
        case ROLE:
            path = path.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName()).resolve(ROLES_FOLDER);
            if (!addExtension) {
                return path;
            }
            break;
        case USER:
            path = path.resolve(MS_WORK_DIR_NAMES.SECURITY.getDirName()).resolve(USERS_FOLDER);
            if (!addExtension) {
                return path;
            }
            break;
        case ASSEMBLY:
            path = path.resolve(MS_WORK_DIR_NAMES.ASSEMBLIES.getDirName());
            break;
        case SEQUENCE:
            path = path.resolve(MS_WORK_DIR_NAMES.SEQUENCES.getDirName());
            break;
        case VIEW:
            path = path.resolve(MS_WORK_DIR_NAMES.VIEWS.getDirName());
            break;
        case TABLE:
            path = path.resolve(MS_WORK_DIR_NAMES.TABLES.getDirName());
            break;
        case FUNCTION:
            path = path.resolve(MS_WORK_DIR_NAMES.FUNCTIONS.getDirName());
            break;
        case PROCEDURE:
            path = path.resolve(MS_WORK_DIR_NAMES.PROCEDURES.getDirName());
            break;
        case TYPE:
            path = path.resolve(MS_WORK_DIR_NAMES.TYPES.getDirName());
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            path = path.resolve(parentSt.getStatementType() == DbObjType.TABLE ?
                    MS_WORK_DIR_NAMES.TABLES.getDirName() : MS_WORK_DIR_NAMES.VIEWS.getDirName());
            break;
        default:
            throw new IllegalStateException("Unsupported export type: " + type);
        }

        String fileName = addExtension ? getExportedFilenameSql(st) : getExportedFilename(st);
        if (st instanceof PgStatementWithSearchPath) {
            fileName = FileUtils.getValidFilename(
                    ((PgStatementWithSearchPath)st).getSchemaName()) + '.' + fileName;
        }

        return path.resolve(fileName);
    }
}
