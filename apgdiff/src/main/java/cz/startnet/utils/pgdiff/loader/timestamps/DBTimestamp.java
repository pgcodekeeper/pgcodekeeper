package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import cz.startnet.utils.pgdiff.hashers.ShaHasher;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Stores database timestamps objects
 *
 * @author galiev_mr
 * @since 4.2.0
 * @see ObjectTimestamp
 */
public class DBTimestamp implements Serializable {

    private static final long serialVersionUID = 6207954672144447111L;
    private static final Map<Path, DBTimestamp> PROJ_TIMESTAMPS = new ConcurrentHashMap<>();

    private final Map <GenericColumn, ObjectTimestamp> objects = new HashMap<>();
    private final transient Set<GenericColumn> duplicatedObjects = new HashSet<>();

    /**
     * Get database timestamps by given path, if not found create new empty object.
     * All modifications of returned objects must be  in synchronize block
     *
     * @param path - path to serialized object
     * @return database timestamps
     */
    public static DBTimestamp getDBTimestamp(Path path) {
        DBTimestamp db = PROJ_TIMESTAMPS.get(path);
        if (db == null) {
            Object obj = ApgdiffUtils.deserialize(path);
            if (obj instanceof DBTimestamp) {
                db = (DBTimestamp) obj;
            }
            if (db == null) {
                db = new DBTimestamp();
            }

            DBTimestamp dbnew = PROJ_TIMESTAMPS.putIfAbsent(path, db);
            if (dbnew != null) {
                return dbnew;
            }
        }

        return db;
    }

    /**
     * Added object from jdbc to objects map. <br>
     * WARNING: if objects already present in map, all version of objects will be deleted,
     * and new versions of this object cannot be added to map.
     *
     * @param column - object definition
     * @param objId - object id
     * @param lastModified - last object modified time
     * @param author - modify aauthor
     * @param acl - objects privileges
     * @param colAcls - object columns privileges
     */
    public void addObject(GenericColumn column, long objId, Instant lastModified,
            String author, String acl, Map<String, String> colAcls) {
        ObjectTimestamp obj = objects.get(column);
        if (obj == null) {
            if (!duplicatedObjects.contains(column)) {
                objects.put(column, new ObjectTimestamp(column, objId, lastModified, author,
                        acl, colAcls));
            }
        } else {
            objects.remove(column, obj);
            duplicatedObjects.add(column);
            Log.log(Log.LOG_WARNING, "pg_dbo_timestamps: duplicated object " + obj);
        }
    }

    /**
     * Compares each object hash from given database with current DBTimestamp and
     * removes not equals. <br><br>
     *
     * Each statement in database <b>must have</b> filled rawStatement.<br><br>
     *
     * If don't have objects, the method does nothing.<br><br>
     *
     * @param db - database with filled raw statements
     *
     * @see PgDatabase
     * @see DBTimestamp
     */
    public void updateObjects(PgDatabase db) {
        if (objects.isEmpty()) {
            return;
        }

        Map<GenericColumn, byte[]> statements = new HashMap<>();
        db.getDescendants().filter(st -> st.getStatementType() != DbObjType.CONSTRAINT).forEach(st -> {
            if (st.getStatementType() == DbObjType.TABLE) {
                List<AbstractConstraint> cons = ((PgTable)st).getConstraints();
                ShaHasher hasher = new ShaHasher();
                hasher.put(st);
                hasher.putUnordered(cons);
                statements.put(createGC(st), hasher.getArray());
            } else {
                statements.put(createGC(st), st.shaHash());
            }
        });

        for (Iterator<Entry<GenericColumn, ObjectTimestamp>> iterator = objects.entrySet().iterator();
                iterator.hasNext();) {
            Entry<GenericColumn, ObjectTimestamp> obj = iterator.next();
            GenericColumn name = obj.getKey();
            if (!Arrays.equals(statements.get(name), obj.getValue().getHash())) {
                iterator.remove();
            }
        }
    }

    public String getElementAuthor(TreeElement el) {
        String parentName = null;
        String schemaName = null;
        DbObjType type = el.getType();

        TreeElement parent = el.getParent();
        if (type == DbObjType.RULE || type == DbObjType.TRIGGER) {
            parentName = parent.getName();
        }

        while (parent != null) {
            if (parent.getType() == DbObjType.SCHEMA) {
                schemaName = parent.getName();
            }
            parent = parent.getParent();
        }

        el.getContainerQName();
        ObjectTimestamp obj = objects.get(createGC(schemaName, parentName, el.getName(),  type));
        return obj != null ? obj.getAuthor() : null;
    }


    private GenericColumn createGC(PgStatement st) {
        String schema = null;
        if (st instanceof PgStatementWithSearchPath) {
            schema = ((PgStatementWithSearchPath)st).getContainingSchema().getName();
        }

        return createGC(schema, st.getParent().getName(), st.getName(), st.getStatementType());
    }

    private GenericColumn createGC(String schema, String parent, String name, DbObjType type) {
        GenericColumn gc = null;
        switch (type) {
        case SCHEMA:
        case EXTENSION:
            gc = new GenericColumn(name, type);
            break;
        case TYPE:
        case SEQUENCE:
        case FUNCTION:
        case TABLE:
        case VIEW:
        case FTS_PARSER:
        case FTS_TEMPLATE:
        case FTS_DICTIONARY:
        case FTS_CONFIGURATION:
            gc = new GenericColumn(schema, name, type);
            break;
        case INDEX:
            gc = new GenericColumn(schema, null, name, type);
            break;
        case RULE:
        case TRIGGER:
            gc = new GenericColumn(schema, parent, name, type);
            break;
        default: break;
        }

        return gc;
    }

    /**
     * Searches equals objects in project timestamps and given remote database timestamps.
     *
     * @param dbTime - filled remote database timestamp
     * @return equals objects
     */
    public List<ObjectTimestamp> searchEqualsObjects(DBTimestamp dbTime) {
        List<ObjectTimestamp> equalsObjects = new ArrayList<>();

        for (ObjectTimestamp pObj : objects.values()) {
            GenericColumn gc = pObj.getObject();
            ObjectTimestamp rObj = dbTime.objects.get(gc);
            if (rObj != null && rObj.getTime().equals(pObj.getTime())) {
                equalsObjects.add(rObj.copyNewHash(pObj.getHash()));
            }
        }

        return equalsObjects;
    }

    /**
     * Clears old objects, fills new objects based on given list of statements and
     * remote database timestamps. <br>
     *
     * @param statements - statements list
     * @param remoteDb - remote database
     */
    public void rewriteObjects(List<PgStatement> statements, DBTimestamp remoteDb) {
        objects.clear();
        for (PgStatement st : statements) {
            GenericColumn gc = createGC(st);
            ObjectTimestamp obj = remoteDb.objects.get(gc);
            if (obj != null) {
                byte [] hash;
                if (st.getStatementType() == DbObjType.TABLE) {
                    ShaHasher hasher = new ShaHasher();
                    hasher.put(st);
                    hasher.putUnordered(((PgTable)st).getConstraints());
                    hash = hasher.getArray();
                } else {
                    hash = st.shaHash();
                }

                objects.put(gc, new ObjectTimestamp(gc, hash, obj.getTime()));
            }
        }
    }
}