package cz.startnet.utils.pgdiff.loader.timestamps;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores project and remote database timestamps
 *
 * @since 4.2.0
 * @author galiev_mr
 * @see DBTimestamp
 */
public class DBTimestampPair {
    private final DBTimestamp dbProject;
    private final DBTimestamp dbRemote;

    public DBTimestampPair(DBTimestamp dbProject, DBTimestamp dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }

    public List<ObjectTimestamp> searchMatch() {
        List<ObjectTimestamp> equalsObjects = new ArrayList<>();

        for (ObjectTimestamp pObj : dbProject.getObjects()) {
            GenericColumn gc = pObj.getObject();
            for (ObjectTimestamp rObj : dbRemote.getObjects()) {
                if (rObj.getObject().equals(gc)) {
                    equalsObjects.add(new ObjectTimestamp(gc, pObj.getHash(),
                            rObj.getObjId(), rObj.getTime()));
                    break;
                }
            }
        }

        return equalsObjects;
    }

    /**
     * Adds given statement with remote timestamp to project's timestamps.
     * It is expected that statement is contained and equal in both databases.
     *  <br><br>
     * Table adds with constraints.
     *
     * @param st - statement, which is contained and equal in both databases
     */
    public void addObject(PgStatement st) {
        DbObjType type = st.getStatementType();
        String schema = null;
        if (st instanceof PgStatementWithSearchPath) {
            schema = ((PgStatementWithSearchPath)st).getContainingSchema().getName();
        }
        GenericColumn gc = null;
        switch (type) {
        case SCHEMA:
        case EXTENSION:
            gc = new GenericColumn(st.getName(), type);
            break;
        case TYPE:
        case SEQUENCE:
        case FUNCTION:
        case TABLE:
        case VIEW:
            gc = new GenericColumn(schema, st.getName(), type);
            break;
        case INDEX:
            gc = new GenericColumn(schema, null, st.getName(), type);
            break;
        case RULE:
        case TRIGGER:
            gc = new GenericColumn(schema, st.getParent().getName(), st.getName(), type);
            break;
        default: return;
        }

        StringBuilder hash = new StringBuilder(PgDiffUtils.sha(st.getRawStatement()));

        if (type == DbObjType.TABLE) {
            ((PgTable)st).getConstraints().forEach(con -> hash.append(PgDiffUtils.sha(con.getRawStatement())));
        }

        for (ObjectTimestamp obj : dbRemote.getObjects()) {
            if (obj.getObject().equals(gc)) {
                dbProject.addObject(
                        new ObjectTimestamp(gc, hash.toString(), obj.getTime()));
                return;
            }
        }
    }

    public void serializeProject(Path path) {
        ApgdiffUtils.serialize(path, dbProject);
    }

    public void clearProject() {
        dbProject.getObjects().clear();
    }
}