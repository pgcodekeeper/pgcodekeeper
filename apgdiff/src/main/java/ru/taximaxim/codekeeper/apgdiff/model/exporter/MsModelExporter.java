package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
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
    protected void createOutDir() throws IOException {
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
