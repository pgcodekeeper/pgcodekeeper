package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ModelExporter extends AbstractModelExporter {

    public ModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public ModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected void createOutDir() throws IOException {
        if (Files.exists(outDir)) {
            if (!Files.isDirectory(outDir)) {
                throw new NotDirectoryException(outDir.toString());
            }

            for (Consts.WORK_DIR_NAMES subdirName : Consts.WORK_DIR_NAMES.values()) {
                if (Files.exists(outDir.resolve(subdirName.name()))) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.",
                            subdirName));
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

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension) {
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ?
                null : getExportedFilename(parentSt);

        Path path = baseDir.resolve("SCHEMA");
        DbObjType type = st.getStatementType();
        String schemaName;
        switch (type) {
        case EXTENSION:
        case SERVER:
        case USER_MAPPING:
        case CAST:
            path = baseDir.resolve(type.name());
            break;

        case FOREIGN_DATA_WRAPPER:
            path = baseDir.resolve("FDW");
            break;

        case SCHEMA:
            path = path.resolve(getExportedFilename(st));
            if (!addExtension) {
                // return schema dir path
                return path;
            }
            break;

        case COLLATION:
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
        case POLICY:
        case COLUMN:
            st = parentSt;
            schemaName = AbstractModelExporter.getExportedFilename(parentSt.getParent());
            path = path.resolve(schemaName).resolve(parentSt.getStatementType().name());
            break;
        default:
            break;
        }

        return path.resolve(addExtension ?
                getExportedFilenameSql(st) : getExportedFilename(st));
    }
}
