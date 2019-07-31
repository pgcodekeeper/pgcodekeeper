package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.function.BiPredicate;

import cz.startnet.utils.pgdiff.ContextLocation;
import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class PgObjLocation extends ContextLocation {

    private static final long serialVersionUID = 1284715027798712221L;

    private DangerStatement danger;
    private String comment = "";

    private final String filePath;

    private final String action;

    private final GenericColumn gObj;

    public PgObjLocation(GenericColumn gObj, String action,
            int offset, int lineNumber, String filePath) {
        super(offset, lineNumber, 1);
        this.gObj = gObj;
        this.action = action;
        this.filePath = filePath;
    }

    public PgObjLocation(String filePath) {
        this(null, StatementActions.NONE.name(), 0, 0, filePath);
    }

    public String getAction() {
        return action;
    }

    public int getObjLength() {
        return getObjName().length();
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
            return genericObjCompare(loc, Objects::equals)
                    && getOffset() == loc.getOffset()
                    && getLineNumber() == loc.getLineNumber()
                    && Objects.equals(loc.getFilePath(), getFilePath());
        }
        return false;
    }

    private boolean genericObjCompare(PgObjLocation loc,
            BiPredicate<DbObjType, DbObjType> dbObjTypeCompare) {
        if (gObj == null && loc.gObj == null) {
            return true;
        } else if ((gObj != null && loc.gObj == null)
                || (gObj == null && loc.gObj != null)) {
            return false;
        }
        return Objects.equals(gObj.schema, loc.gObj.schema)
                && Objects.equals(gObj.table, loc.gObj.table)
                && Objects.equals(gObj.column, loc.gObj.column)
                && dbObjTypeCompare.test(gObj.type, loc.gObj.type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (gObj != null) {
            result = prime * result + ((gObj.column == null) ? 0 : gObj.column.hashCode());
            result = prime * result + ((gObj.schema == null) ? 0 : gObj.schema.hashCode());
            result = prime * result + ((gObj.table == null) ? 0 : gObj.table.hashCode());
            result = prime * result + ((gObj.type == null) ? 0 : gObj.type.hashCode());
        }
        result = prime * result + getOffset();
        result = prime * result + getLineNumber();
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
        return gObj;
    }

    public String getObjName() {
        if (gObj != null) {
            if (gObj.column != null) {
                return gObj.column;
            } else if (gObj.table != null) {
                return gObj.table;
            } else if (gObj.schema != null) {
                return gObj.schema;
            }
        }

        return "";
    }

    public String getSchema() {
        return gObj == null ? null : gObj.schema;
    }

    public DbObjType getType() {
        return gObj == null ? null : gObj.type;
    }

    public final boolean compare(PgObjLocation col) {
        return genericObjCompare(col, (localType, otherType) -> {
            if (localType == otherType) {
                return true;
            }

            switch (otherType) {
            case TABLE:
            case VIEW:
            case SEQUENCE:
                return localType == DbObjType.TABLE || localType == DbObjType.VIEW
                || localType == DbObjType.SEQUENCE;
            case FUNCTION:
            case AGGREGATE:
                return localType == DbObjType.FUNCTION || localType == DbObjType.AGGREGATE;
            case TYPE:
            case DOMAIN:
                return localType == DbObjType.TYPE || localType == DbObjType.DOMAIN;
            default:
                return false;
            }
        });
    }
}