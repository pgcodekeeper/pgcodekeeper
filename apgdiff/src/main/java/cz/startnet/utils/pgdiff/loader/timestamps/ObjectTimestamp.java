package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ObjectTimestamp implements Serializable {

    private static final long serialVersionUID = 6000537650992667481L;

    private final GenericColumn object;
    private final byte[] hash;
    private final Instant time;
    private final transient long objId;
    private final transient String author;
    private final transient String acl;
    private final transient Map<String, String> colAcls;

    public ObjectTimestamp(GenericColumn object, byte[] hash, Instant modificationTime) {
        this(object, hash, -1, modificationTime, null, null, null);
    }

    public ObjectTimestamp(GenericColumn object, long objid, Instant modificationTime,
            String author, String acl, Map<String, String> colAcls) {
        this(object, null, objid, modificationTime, author, acl, colAcls);
    }

    private ObjectTimestamp(GenericColumn object, byte[] hash, long objId,
            Instant modificationTime, String author, String acl, Map<String, String> colAcls) {
        this.object = object;
        this.objId = objId;
        this.time = modificationTime;
        this.author = author;
        this.acl = acl;
        this.colAcls = colAcls;
        this.hash = hash;
    }

    public ObjectTimestamp copyNewHash(byte[] newHash) {
        return new ObjectTimestamp(object, newHash, objId, time, author, acl, colAcls);
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

    public String getColumn() {
        return object.column;
    }

    public PgStatement copyStatement(PgDatabase db, JdbcLoaderBase loader) {
        PgStatement copy = object.getStatement(db).shallowCopy();
        copy.clearPrivileges();
        loader.setPrivileges(copy, acl);
        if (colAcls != null) {
            DbObjType type = copy.getStatementType();
            if (DbObjType.TABLE == type) {
                PgTable table = (PgTable) copy;
                for (PgColumn c : table.getColumns()) {
                    // in case the ACL map lacks a column, null will be passed as ACL
                    // which is the valid indication for "no ACL"
                    // which is the column state in this case
                    loader.setPrivileges(c, table, colAcls.get(c.getName()));
                }
            } else if (DbObjType.VIEW == type) {
                colAcls.forEach((colName, colAcl) -> loader.setPrivileges(copy, colAcl, colName));
            }
        }
        return copy;
    }
}