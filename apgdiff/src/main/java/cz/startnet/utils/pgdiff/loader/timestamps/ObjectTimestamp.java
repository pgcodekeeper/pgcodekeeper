package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ObjectTimestamp implements Serializable{

    private static final long serialVersionUID = 6000537650992667481L;

    private final GenericColumn object;
    private final String hash;
    private final Long objId;
    private final Instant time;

    public ObjectTimestamp(GenericColumn object, String hash, Instant modificationtime) {
        this.object = object;
        this.hash = hash;
        this.time = modificationtime;
        objId = null;
    }

    public ObjectTimestamp(GenericColumn object, long objid, Instant modificationtime) {
        this.object = object;
        this.objId = objid;
        this.time = modificationtime;
        hash = null;
    }

    public ObjectTimestamp(GenericColumn object, String hash, long objid, Instant modificationtime) {
        this.object = object;
        this.objId = objid;
        this.hash = hash;
        this.time = modificationtime;
    }

    public GenericColumn getObject() {
        return object;
    }

    public Long getObjId() {
        return objId;
    }

    public String getHash() {
        return hash;
    }

    public Instant getTime() {
        return time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((object == null) ? 0 : object.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof ObjectTimestamp) {
            ObjectTimestamp t = (ObjectTimestamp) obj;
            eq = Objects.equals(object, t.object)
                    && Objects.equals(time, t.time);
        }

        return eq;
    }

    @Override
    public String toString() {
        return object + ": " + time;
    }

    public DbObjType getType() {
        return object.type;
    }

    public String getSchema() {
        return object.schema;
    }

    public PgStatement getShallowCopy(PgDatabase db) {
        return object.getStatement(db).shallowCopy();
    }

    public PgStatement getDeepCopy(PgDatabase db) {
        return object.getStatement(db).deepCopy();
    }

    public String getColumn() {
        return object.column;
    }

    public static PgStatement getObject(PgDatabase db, String schema, String table, String column, DbObjType type) {
        return new GenericColumn(schema, table, column, type).getStatement(db);
    }
}