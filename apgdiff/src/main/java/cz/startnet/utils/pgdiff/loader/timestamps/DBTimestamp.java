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

    private transient DBTimestamp dbTime;

    public void addObject(GenericColumn column, long objId, Instant lastModified, String author) {
        ObjectTimestamp obj = objects.get(column);
        if (obj != null) {
            Instant time = obj.getTime();
            if (time.isAfter(lastModified)) {
                return;
            }
        }

        objects.put(column, new ObjectTimestamp(column, objId, lastModified, author));
    }

    /**
     * Compares each object hash from given database with serialized
     * objects hash from DBTimestamp. Removes not equals objects and
     * re-serializes the remaining objects again. <br><br>
     *
     * Each statement in database <b>must have</b> filled rawStatement.<br><br>
     *
     * If the serialized objects don't exist (first run) or don't have objects,
     * the method does nothing.<br><br>
     *
     * @param db - database with filled raw statements
     * @param path - path to serialized file
     *
     * @see PgDatabase
     * @see DBTimestamp
     */
    public static void updateObjects(PgDatabase db, Path path) {
        if (true) {
            return;
        }

        DBTimestamp timestamp = getDBTimestamp(path);
        if (timestamp.objects.isEmpty()) {
            return;
        }

        Map<GenericColumn, byte[]> statements = new HashMap<>();
        db.getExtensions().forEach(e -> statements.put(
                new GenericColumn(e.getName(), DbObjType.EXTENSION),
                PgDiffUtils.sha(e.getRawStatement())));
        for (PgSchema s : db.getSchemas()) {
            s.getTypes().forEach(t -> statements.put(
                    new GenericColumn(s.getName(), t.getName(), DbObjType.TYPE),
                    PgDiffUtils.sha(t.getRawStatement())));
            s.getDomains().forEach(d -> statements.put(
                    new GenericColumn(s.getName(), d.getName(), DbObjType.TYPE),
                    PgDiffUtils.sha(d.getRawStatement())));
            s.getSequences().forEach(seq -> statements.put(
                    new GenericColumn(s.getName(), seq.getName(), DbObjType.SEQUENCE),
                    PgDiffUtils.sha(seq.getRawStatement())));
            s.getFunctions().forEach(f -> statements.put(
                    new GenericColumn(s.getName(), f.getName(), DbObjType.FUNCTION),
                    PgDiffUtils.sha(f.getRawStatement())));
            for (PgTable t : s.getTables()) {
                t.getIndexes().forEach(i -> statements.put(
                        new GenericColumn(s.getName(), null, i.getName(), DbObjType.INDEX),
                        PgDiffUtils.sha(i.getRawStatement())));
                t.getTriggers().forEach(tr -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), tr.getName(), DbObjType.TRIGGER),
                        PgDiffUtils.sha(tr.getRawStatement())));
                t.getRules().forEach(r -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), r.getName(), DbObjType.RULE),
                        PgDiffUtils.sha(r.getRawStatement())));

                String hash = t.getRawStatement();
                List<PgConstraint> cons = t.getConstraints();
                if (!cons.isEmpty()) {
                    StringBuilder tableHash = new StringBuilder(hash);
                    cons.forEach(con -> tableHash.append(con.getRawStatement()));
                    hash = tableHash.toString();
                }

                statements.put(new GenericColumn(s.getName(), t.getName(), DbObjType.TABLE),
                        PgDiffUtils.sha(hash));
            }
            for (PgView v : s.getViews()) {
                v.getTriggers().forEach(tr -> statements.put(
                        new GenericColumn(s.getName(), v.getName(), tr.getName(), DbObjType.TRIGGER),
                        PgDiffUtils.sha(tr.getRawStatement())));
                v.getRules().forEach(r -> statements.put(
                        new GenericColumn(s.getName(), v.getName(), r.getName(), DbObjType.RULE),
                        PgDiffUtils.sha(r.getRawStatement())));
                statements.put(new GenericColumn(s.getName(), v.getName(), DbObjType.TABLE),
                        PgDiffUtils.sha(v.getRawStatement()));
            }
            statements.put(new GenericColumn(s.getName(), DbObjType.SCHEMA),
                    PgDiffUtils.sha(s.getRawStatement()));
        }

        for (Iterator<ObjectTimestamp> iterator = timestamp.objects.values().iterator();
                iterator.hasNext();) {
            ObjectTimestamp obj = iterator.next();
            GenericColumn name = obj.getObject();
            if (!(Arrays.equals(statements.get(name), obj.getHash()))) {
                iterator.remove();
            }
        }

        PROJ_TIMESTAMPS.put(path, timestamp);

        ApgdiffUtils.serialize(path, timestamp);
    }

    public static DBTimestamp getDBTimestamp(Path path) {
        DBTimestamp db = PROJ_TIMESTAMPS.get(path);
        if (db == null) {
            db = (DBTimestamp) ApgdiffUtils.deserialize(path);
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

    public String getStatementAuthor(PgStatement st) {
        ObjectTimestamp obj = objects.get(createGC(st));
        return obj != null ? obj.getAuthor() : null;
    }

    private static GenericColumn createGC(PgStatement st) {
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
        default: break;
        }

        return gc;
    }

    public DBTimestamp getRemoteDb() {
        return dbTime;
    }

    public List<ObjectTimestamp> searchMatch(DBTimestamp dbTime) {
        this.dbTime = dbTime;
        if (true) {
            return new ArrayList<>();
        }

        List<ObjectTimestamp> equalsObjects = new ArrayList<>();

        for (ObjectTimestamp pObj : objects.values()) {
            GenericColumn gc = pObj.getObject();
            for (ObjectTimestamp rObj : dbTime.objects.values()) {
                // author?
                if (rObj.equals(pObj) && rObj.getTime().equals(pObj.getTime())) {
                    equalsObjects.add(new ObjectTimestamp(gc, pObj.getHash(),
                            rObj.getObjId(), rObj.getTime(), rObj.getAuthor()));
                    break;
                }
            }
        }

        return equalsObjects;
    }

    /**
     * Rewrites timestamp objects
     *
     * @param statements - statements list
     */
    public void rewrite(List<PgStatement> statements, Path path) {
        if (true) {
            return;
        }
        objects.clear();
        for (PgStatement st : statements) {
            StringBuilder hash = new StringBuilder(st.getRawStatement());
            if (st.getStatementType() == DbObjType.TABLE) {
                ((PgTable)st).getConstraints().forEach(con -> hash.append(con.getRawStatement()));
            }

            GenericColumn gc = createGC(st);
            ObjectTimestamp obj = objects.get(gc);
            if (obj != null) {
                objects.put(gc, new ObjectTimestamp(gc, PgDiffUtils.sha(hash.toString()),
                        obj.getTime(), obj.getAuthor()));
            }
        }

        ApgdiffUtils.serialize(path, this);
    }
}