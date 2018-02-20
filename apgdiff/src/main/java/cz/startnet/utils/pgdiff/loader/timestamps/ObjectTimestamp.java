package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ObjectTimestamp implements Serializable {

    private static final long serialVersionUID = 6000537650992667481L;

    private final GenericColumn object;
    private final byte[] hash;
    private final Instant time;
    private final transient long objId;
    private final transient String author;

    public ObjectTimestamp(GenericColumn object, byte[] hash, Instant modificationtime) {
        this.object = object;
        this.hash = hash;
        this.time = modificationtime;
        author = null;
        objId = -1;
    }

    public ObjectTimestamp(GenericColumn object, long objid, Instant modificationtime, String author) {
        this.object = object;
        this.objId = objid;
        this.time = modificationtime;
        this.author = author;
        hash = null;
    }

    public ObjectTimestamp(GenericColumn object, byte[] hash, long objid, Instant modificationtime) {
        this.object = object;
        this.objId = objid;
        this.hash = hash;
        this.time = modificationtime;
        author = null;
    }

    public GenericColumn getObject() {
        return object;
    }

    public long getObjId() {
        return objId;
    }

    public byte[] getHash() {
        return hash;
    }

    public Instant getTime() {
        return time;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((object == null) ? 0 : object.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof ObjectTimestamp) {
            ObjectTimestamp t = (ObjectTimestamp) obj;
            eq = Objects.equals(object, t.object);
        }

        return eq;
    }

    @Override
    public String toString() {
        return object + ": " + time + " - " + author;
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
}