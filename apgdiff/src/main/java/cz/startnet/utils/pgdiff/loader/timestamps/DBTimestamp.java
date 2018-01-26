package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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

    private final List<ObjectTimestamp> objects = new ArrayList<>();

    public List<ObjectTimestamp> getObjects() {
        return objects;
    }

    public void addObject(ObjectTimestamp obj) {
        objects.add(obj);
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
        DBTimestamp timestamp = getDBTimestamp(path);
        if (timestamp.getObjects().isEmpty()) {
            return;
        }

        Map<GenericColumn, byte[]> statements = new HashMap<>();
        db.getExtensions().forEach(e -> statements.put(
                new GenericColumn(e.getName(), DbObjType.EXTENSION),
                PgDiffUtils.getHash(e.getRawStatement())));
        for (PgSchema s : db.getSchemas()) {
            s.getTypes().forEach(t -> statements.put(
                    new GenericColumn(s.getName(), t.getName(), DbObjType.TYPE),
                    PgDiffUtils.getHash(t.getRawStatement())));
            s.getDomains().forEach(d -> statements.put(
                    new GenericColumn(s.getName(), d.getName(), DbObjType.TYPE),
                    PgDiffUtils.getHash(d.getRawStatement())));
            s.getSequences().forEach(seq -> statements.put(
                    new GenericColumn(s.getName(), seq.getName(), DbObjType.SEQUENCE),
                    PgDiffUtils.getHash(seq.getRawStatement())));
            s.getFunctions().forEach(f -> statements.put(
                    new GenericColumn(s.getName(), f.getName(), DbObjType.FUNCTION),
                    PgDiffUtils.getHash(f.getRawStatement())));
            for (PgTable t : s.getTables()) {
                t.getIndexes().forEach(i -> statements.put(
                        new GenericColumn(s.getName(), null, i.getName(), DbObjType.INDEX),
                        PgDiffUtils.getHash(i.getRawStatement())));
                t.getTriggers().forEach(tr -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), tr.getName(), DbObjType.TRIGGER),
                        PgDiffUtils.getHash(tr.getRawStatement())));
                t.getRules().forEach(r -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), r.getName(), DbObjType.RULE),
                        PgDiffUtils.getHash(r.getRawStatement())));

                StringBuilder tableHash = new StringBuilder(t.getRawStatement());
                t.getConstraints().forEach(con -> tableHash.append(con.getRawStatement()));

                statements.put(new GenericColumn(s.getName(), t.getName(), DbObjType.TABLE),
                        PgDiffUtils.getHash(tableHash.toString()));
            }
            for (PgView v : s.getViews()) {
                v.getTriggers().forEach(tr -> statements.put(
                        new GenericColumn(s.getName(), v.getName(), tr.getName(), DbObjType.TRIGGER),
                        PgDiffUtils.getHash(tr.getRawStatement())));
                v.getRules().forEach(r -> statements.put(
                        new GenericColumn(s.getName(), v.getName(), r.getName(), DbObjType.RULE),
                        PgDiffUtils.getHash(r.getRawStatement())));
                statements.put(new GenericColumn(s.getName(), v.getName(), DbObjType.TABLE),
                        PgDiffUtils.getHash(v.getRawStatement()));
            }
            statements.put(new GenericColumn(s.getName(), DbObjType.SCHEMA),
                    PgDiffUtils.getHash(s.getRawStatement()));
        }

        for (Iterator<ObjectTimestamp> iterator = timestamp.objects.iterator(); iterator.hasNext(); ) {
            ObjectTimestamp obj = iterator.next();
            GenericColumn name = obj.getObject();
            if (!statements.containsKey(name) || !(Arrays.equals(statements.get(name), obj.getHash()))) {
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
}