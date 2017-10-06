package cz.startnet.utils.pgdiff.loader.timestamps;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DBTimestampPair {
    private final DBTimestamp dbProject;
    private final DBTimestamp dbRemote;


    public DBTimestampPair(DBTimestamp dbProject, DBTimestamp dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }

    public List<ObjectTimestamp> compare() {
        List<ObjectTimestamp> projectObjects = dbProject.getObjects();
        List<ObjectTimestamp> remoteObjects = dbRemote.getObjects();
        List<ObjectTimestamp> equalsObjects = new ArrayList<>();


        for (ObjectTimestamp pObj : projectObjects) {
            GenericColumn gc = pObj.getObject();
            for (ObjectTimestamp rObj : remoteObjects) {
                if (rObj.getObject().equals(gc)) {
                    equalsObjects.add(new ObjectTimestamp(gc, pObj.getHash(),
                            rObj.getObjId(), rObj.getTime()));
                    break;
                }
            }
        }

        return equalsObjects;
    }

    public void addObject(PgStatement st) {
        DbObjType type = st.getStatementType();
        PgStatement parent = st.getParent();
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
            gc = new GenericColumn(parent.getName(), st.getName(), type);
            break;
        case INDEX:
            gc = new GenericColumn(parent.getParent().getName(), null, st.getName(), type);
            break;
        case RULE:
        case TRIGGER:
            gc = new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
            break;
        default: return;
        }

        StringBuilder hash = new StringBuilder(PgDiffUtils.sha(st.getRawStatement()));

        // add constraints hash to table hash
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

    public void serializeProject(String origin) {
        dbProject.serialize(origin);
    }

    public void clearProject() {
        dbProject.getObjects().clear();
    }
}