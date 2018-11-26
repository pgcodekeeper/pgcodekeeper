package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class MsPrivilegesModelExporter extends AbstractModelExporter {

    public MsPrivilegesModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
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
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
        case USER:
        case ROLE:
        case TYPE:
        case SEQUENCE:
        case ASSEMBLY:
        case FUNCTION:
        case PROCEDURE:
        case TABLE:
        case VIEW:
            deleteStatementIfExists(st);
            dumpPrivileges(st);
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case COLUMN:
            break;
        default:
            throw new IllegalStateException("Unsupported export type: " + type);
        }
    }

    @Override
    protected void createObject(TreeElement el) {
        // no impl
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return MsModelExporter.getRelativeFilePath(
                st, Paths.get(ApgdiffConsts.PRIVILEGES_DIR), addExtension);
    }
}
