package cz.startnet.utils.pgdiff.loader.timestamps;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.GenericColumn;

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
                            rObj.getObjId(), rObj.getModificationTime()));
                    break;
                }
            }
        }

        return equalsObjects;
    }
}
