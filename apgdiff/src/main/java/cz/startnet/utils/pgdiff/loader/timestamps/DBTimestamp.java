package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
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

    public void addObject(GenericColumn column, long objId, Instant lastModified, String author) {
        ObjectTimestamp obj = objects.get(column);
        if (obj == null || obj.getTime().isBefore(lastModified)) {
            // replace stale timestamps
            objects.put(column, new ObjectTimestamp(column, objId, lastModified, author));
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
        if (true) {
            return;
        }

        if (objects.isEmpty()) {
            return;
        }

        Map<GenericColumn, byte[]> statements = new HashMap<>();
        db.getExtensions().forEach(e -> statements.put(
                new GenericColumn(e.getName(), DbObjType.EXTENSION),
                PgDiffUtils.sha(e.getRawStatement())));
        for (PgSchema s : db.getSchemas()) {
            s.getTypes().forEach(t -> statements.put(createGC(t), PgDiffUtils.sha(t.getRawStatement())));
            s.getDomains().forEach(d -> statements.put(createGC(d), PgDiffUtils.sha(d.getRawStatement())));
            s.getSequences().forEach(seq -> statements.put(createGC(seq), PgDiffUtils.sha(seq.getRawStatement())));
            s.getFunctions().forEach(f -> statements.put(createGC(f), PgDiffUtils.sha(f.getRawStatement())));
            for (PgTable t : s.getTables()) {
                t.getIndexes().forEach(i -> statements.put(createGC(i), PgDiffUtils.sha(i.getRawStatement())));
                t.getTriggers().forEach(tr -> statements.put(createGC(tr), PgDiffUtils.sha(tr.getRawStatement())));
                t.getRules().forEach(r -> statements.put(createGC(r), PgDiffUtils.sha(r.getRawStatement())));

                String hash = t.getRawStatement();
                List<PgConstraint> cons = t.getConstraints();
                if (!cons.isEmpty()) {
                    StringBuilder tableHash = new StringBuilder(hash);
                    cons.forEach(con -> tableHash.append(con.getRawStatement()));
                    hash = tableHash.toString();
                }

                statements.put(createGC(t), PgDiffUtils.sha(hash));
            }
            for (PgView v : s.getViews()) {
                v.getTriggers().forEach(tr -> statements.put(createGC(tr), PgDiffUtils.sha(tr.getRawStatement())));
                v.getRules().forEach(r -> statements.put(createGC(r), PgDiffUtils.sha(r.getRawStatement())));
                statements.put(createGC(v), PgDiffUtils.sha(v.getRawStatement()));
            }
            statements.put(createGC(s), PgDiffUtils.sha(s.getRawStatement()));
        }

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
        if (true) {
            return new ArrayList<>();
        }

        List<ObjectTimestamp> equalsObjects = new ArrayList<>();

        for (ObjectTimestamp pObj : objects.values()) {
            GenericColumn gc = pObj.getObject();
            ObjectTimestamp rObj = dbTime.objects.get(gc);
            if (rObj != null && rObj.getTime().equals(pObj.getTime())) {
                equalsObjects.add(new ObjectTimestamp(gc, pObj.getHash(),
                        rObj.getObjId(), rObj.getTime()));
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
            StringBuilder hash = new StringBuilder(st.getRawStatement());
            if (st.getStatementType() == DbObjType.TABLE) {
                ((PgTable)st).getConstraints().forEach(con -> hash.append(con.getRawStatement()));
            }

            GenericColumn gc = createGC(st);
            ObjectTimestamp obj = remoteDb.objects.get(gc);
            if (obj != null) {
                objects.put(gc, new ObjectTimestamp(gc, PgDiffUtils.sha(hash.toString()),
                        obj.getTime()));
            }
        }
    }
}