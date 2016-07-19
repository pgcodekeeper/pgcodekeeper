package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class GenericColumn implements Serializable {

    private static final long serialVersionUID = -5032985077177033449L;
    // SONAR-OFF
    public final String schema;
    public final String table;
    public final String column;
    public final DbObjType type;
    // SONAR-ON

    public GenericColumn(String schema, String table, String column, DbObjType type) {
        this.schema = schema;
        this.table = table;
        this.column = column;
        this.type = type;
    }

    public GenericColumn(String schema, String object, DbObjType type) {
        this(schema, object, null, type);
    }

    public GenericColumn(String schema, DbObjType type) {
        this(schema, null, type);
    }

    public PgStatement getStatement(PgDatabase db) {
        PgStatement st = doGetStatement(db);
        if (st == null) {
            Log.log(Log.LOG_WARNING, "Could not find statement for reference: " + this);
        }
        return st;
    }

    private PgStatement doGetStatement(PgDatabase db) {
        if (type == null) {
            return null;
        }

        PgSchema s = db.getSchema(schema);
        if (s == null && type != DbObjType.DATABASE && type != DbObjType.EXTENSION) {
            return null;
        }

        PgTable t;
        switch (type) {
        case DATABASE: return db;
        case SCHEMA: return s;
        case EXTENSION: return db.getExtension(schema);

        // TODO relations are also types
        case TYPE: return s.getType(table);
        case DOMAIN: return s.getDomain(table);
        case SEQUENCE: return s.getSequence(table);
        case FUNCTION: return resolveFunctionCall(s, table);
        case TABLE: return s.getTable(table);

        case COLUMN:
            t = s.getTable(table);
            return t == null ? null : t.getColumn(column);
        case CONSTRAINT:
            t = s.getTable(table);
            return t == null ? null : t.getConstraint(column);
        case INDEX:
            t = s.getTable(table);
            return t == null ? null : t.getIndex(column);
        case TRIGGER:
            t = s.getTable(table);
            return t == null ? null : t.getTrigger(column);

        case VIEW: return s.getView(table);
        case RULE:
            t = s.getTable(table);
            return t == null ? s.getView(table).getRule(column) : t.getRule(column);

        default: throw new IllegalStateException("Unhandled DbObjType: " + type);
        }
    }

    private PgFunction resolveFunctionCall(PgSchema schema, String funcName) {
        // in some cases (like triggers) we already have a signature reference, try it first
        // eventually this will become the norm (pending function call analysis)
        // and bare name lookup will become deprecated
        PgFunction func = schema.getFunction(funcName);
        if (func != null) {
            return func;
        }

        int found = 0;
        for (PgFunction f : schema.getFunctions()) {
            if (f.getBareName().equals(funcName)) {
                ++found;
                func = f;
            }
        }
        // TODO right now we don't have means to resolve overloaded function calls
        // to avoid false dependencies skip resolving overloaded calls completely
        return found == 1 ? func : null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((column == null) ? 0 : column.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((table == null) ? 0 : table.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof GenericColumn) {
            GenericColumn col = (GenericColumn) obj;
            eq = Objects.equals(schema, col.schema)
                    && Objects.equals(table, col.table)
                    && Objects.equals(column, col.column)
                    && type == col.type;
        }

        return eq;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (schema != null) {
            sb.append(PgDiffUtils.getQuotedName(schema));
        }
        if (table != null) {
            if (sb.length() > 0) {
                sb.append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(table));
        }
        if (column != null) {
            if (sb.length() > 0) {
                sb.append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(column));
        }
        sb.append(" (").append(type).append(')');
        return sb.toString();
    }
}