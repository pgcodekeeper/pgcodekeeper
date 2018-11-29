package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
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
        case AGGREGATE:
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
        StringBuilder sb = new StringBuilder();

        Map<PgStatement, List<PgPrivilege>> privs;
        try {
            privs = new ProjectLoader(outDir.toString(), args)
                    .getPrivilegesFromPath(path, oldDb);
        } catch (InterruptedException e) {
            // unreachable
            throw new IllegalStateException(e);
        }
        boolean isFound = false;
        for (Entry<PgStatement, List<PgPrivilege>> entry : privs.entrySet()) {
            PgStatement oldSt = entry.getKey();
            if (st.getName().equals(oldSt.getName())) {
                isFound = true;
                // new state
                st.appendPrivileges(sb);
            } else {
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
                    sb.append('\n').append(priv.getCreationSQL()).append(';');
                }
            }
            sb.append(GROUP_DELIMITER);
        }

        if (!isFound) {
            // add new privileges to end if not found
            st.appendPrivileges(sb);
        } else if (sb.length() > 0) {
            // remove trailing delimiter from loop above
            sb.setLength(sb.length() - GROUP_DELIMITER.length());
        }

        deleteStatementIfExists(st);

        if (sb.length() > 0) {
            dumpSQL(sb.toString(), path);
        }
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return ModelExporter.getRelativeFilePath(
                st, Paths.get(ApgdiffConsts.PRIVILEGES_DIR), addExtension);
    }
}
