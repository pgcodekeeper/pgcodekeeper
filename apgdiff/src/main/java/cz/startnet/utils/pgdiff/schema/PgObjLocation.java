package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class PgObjLocation implements Serializable {

    private static final long serialVersionUID = 1284715027798712221L;

    private DangerStatement danger;
    private String comment = "";

    private final int offset;
    private final int lineNumber;
    private final String filePath;

    private final StatementActions action;

    private final String schema;
    private final String table;
    private final String column;
    private final DbObjType type;

    public PgObjLocation(String schema, String table, String column,
            DbObjType type, StatementActions action,
            int offset, int lineNumber, String filePath) {
        this.schema = schema;
        this.table = table;
        this.column = column;
        this.type = type;
        this.action = action;
        this.offset = offset;
        this.lineNumber = lineNumber;
        this.filePath = filePath;
    }

    public PgObjLocation(String schema, String object, DbObjType type, StatementActions action,
            int offset, int lineNumber, String filePath) {
        this(schema, object, null, type, action, offset, lineNumber, filePath);
    }

    public PgObjLocation(String schema, DbObjType type, StatementActions action,
            int offset, int lineNumber, String filePath) {
        this(schema, null, type, action, offset, lineNumber, filePath);
    }

    public PgObjLocation(String filePath) {
        this(null, null, StatementActions.NONE, 0, 0, filePath);
    }

    public StatementActions getAction() {
        return action;
    }

    public int getOffset() {
        return offset;
    }

    public int getObjLength() {
        return getObjName().length();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation) obj;
            return Objects.equals(schema, loc.schema)
                    && Objects.equals(table, loc.table)
                    && Objects.equals(column, loc.column)
                    && Objects.equals(type, loc.type)
                    && offset == loc.offset
                    && lineNumber == loc.lineNumber
                    && Objects.equals(loc.getFilePath(), getFilePath());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((column == null) ? 0 : column.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((table == null) ? 0 : table.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + offset;
        result = prime * result + lineNumber;
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        return result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWarningText() {
        switch (danger) {
        case ALTER_COLUMN: return "ALTER COLUMN ... TYPE statement";
        case DROP_COLUMN: return "DROP COLUMN statement";
        case DROP_TABLE: return "DROP TABLE statement";
        case RESTART_WITH: return "ALTER SEQUENCE ... RESTART WITH statement";
        case UPDATE: return "UPDATE statement";
        default: return null;
        }
    }

    public void setWarning(DangerStatement danger) {
        this.danger = danger;
    }

    public boolean isDanger() {
        return danger != null;
    }

    public GenericColumn getGenericColumn() {
        return new GenericColumn(schema, table, column, type);
    }

    public String getObjName() {
        if (column != null) {
            return column;
        } else if (table != null) {
            return table;
        } else if (schema != null) {
            return schema;
        }

        return "";
    }

    public String getSchema() {
        return schema;
    }

    public DbObjType getType() {
        return type;
    }

    public final boolean compare(PgObjLocation col) {
        return Objects.equals(schema, col.schema)
                && Objects.equals(table, col.table)
                && Objects.equals(column, col.column)
                && compareTypes(col.type);
    }

    private boolean compareTypes(DbObjType objType) {
        if (type == objType) {
            return true;
        }

        switch (objType) {
        case TABLE:
        case VIEW:
        case SEQUENCE:
            return type == DbObjType.TABLE || type == DbObjType.VIEW || type == DbObjType.SEQUENCE;
        case FUNCTION:
        case AGGREGATE:
            return type == DbObjType.FUNCTION || type == DbObjType.AGGREGATE;
        case TYPE:
        case DOMAIN:
            return type == DbObjType.TYPE || type == DbObjType.DOMAIN;
        default:
            return false;
        }
    }
}