package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class PgPrivilegesModelExporter extends AbstractModelExporter {

    public PgPrivilegesModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    public void exportFull() throws IOException {
        // no impl
    }

    @Override
    protected void deleteObject(TreeElement el) {
        // no impl
    }

    @Override
    protected void editObject(TreeElement el) throws IOException {
        PgStatement st = el.getPgStatement(newDb);
        switch (st.getStatementType()) {
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
        case EXTENSION:
        case COLUMN:
            break;
        case FUNCTION:
        case PROCEDURE:
        case OPERATOR:
            dumpFuncPriv(el, st);
            break;
        default:
            deleteStatementIfExists(st);
            dumpPrivileges(st);
        }
    }

    @Override
    protected void createObject(TreeElement el) {
        // no impl
    }

    private void dumpFuncPriv(TreeElement el, PgStatement st) throws IOException {
        PgDiffArguments args = new PgDiffArguments();
        Path path = outDir.resolve(getRelativeFilePath(st, true));
        List<String> dumps = new ArrayList<>();

        try {
            boolean isFound = false;
            for (Entry<PgStatement, List<PgPrivilege>> entry : new ProjectLoader(outDir.toString(), args)
                    .getPrivilegesFromPath(path, oldDb).entrySet()) {
                PgStatement oldSt = entry.getKey();
                StringBuilder sb = new StringBuilder();
                if (st.getName().equals(oldSt.getName())) {
                    isFound = true;
                    // new state
                    st.appendPrivileges(sb);
                } else if (!entry.getValue().isEmpty()) {
                    // we can't change oldSt
                    sb.append("\n\n-- ")
                    .append(oldSt.getStatementType())
                    .append(' ');
                    sb.append(((PgStatementWithSearchPath)oldSt).getContainingSchema().getName())
                    .append('.');
                    sb.append(oldSt.getName())
                    .append(' ')
                    .append("GRANT\n");

                    // old state
                    for (PgPrivilege priv : entry.getValue()) {
                        sb.append('\n').append(priv.getCreationSQL()).append(oldSt.isPostgres() ? ';' : "\nGO");
                    }
                }

                if (sb.length() > 0) {
                    // replace first new line symbol
                    sb.replace(0, 1, "");
                    dumps.add(sb.toString());
                }
            }

            if (!isFound) {
                // add new privileges to end if not found
                StringBuilder sb = new StringBuilder();
                st.appendPrivileges(sb);
                if (sb.length() > 0) {
                    sb.replace(0, 1, "");
                    dumps.add(sb.toString());
                }
            }

            deleteStatementIfExists(st);

            if (!dumps.isEmpty()) {
                String sql = String.join(GROUP_DELIMITER, dumps);
                dumpSQL(sql, path);
            }
        } catch (InterruptedException e) {
            // unreachable
            Log.log(Log.LOG_INFO, "Export interrapted by user");
        }
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ?
                null : ModelExporter.getExportedFilename(parentSt);

        Path path = Paths.get(ApgdiffConsts.PRIVILEGES_DIR, "SCHEMA");
        DbObjType type = st.getStatementType();
        String schemaName;
        switch (type) {
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
            throw new IllegalStateException("Unsupported export type: " + type);
        }

        return path.resolve(addExtension ?
                getExportedFilenameSql(st) : getExportedFilename(st));
    }
}
