package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.ContextLocation;
import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgObjLocation extends ContextLocation {

    private static final long serialVersionUID = 1560794454982891339L;

    private DangerStatement danger;
    private String comment = "";

    private final String action;

    private final GenericColumn gObj;
    private String sql;

    public PgObjLocation(GenericColumn gObj, String action,
            int offset, int lineNumber, int charPositionInLine, String filePath) {
        super(filePath, offset, lineNumber, charPositionInLine);
        this.gObj = gObj;
        this.action = action;
    }

    public PgObjLocation(GenericColumn gObj, String action,
            int offset, int lineNumber, String filePath) {
        this(gObj, action, offset, lineNumber, 1, filePath);
    }

    public PgObjLocation(String action, ParserRuleContext ctx, String sql) {
        this(null, action, ctx.getStart().getStartIndex(), ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(), null);
        this.sql = sql;
    }

    public PgObjLocation(GenericColumn gObj, String action, int offset, int lineNumber,
            int charPositionInLine, String filePath, String sql) {
        this(gObj, action, offset, lineNumber, charPositionInLine, filePath);
        this.sql = sql;
    }

    public PgObjLocation(String filePath) {
        this(null, null, 0, 0, 0, filePath);
    }

    public String getAction() {
        return action;
    }

    public int getObjLength() {
        return getObjName().length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation) obj;
            return Objects.equals(loc.getGenericColumn(), getGenericColumn())
                    && Objects.equals(loc.getSql(), getSql())
                    && Objects.equals(loc.getAction(), getAction());

        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        if (gObj != null) {
            result = prime * result + ((gObj.column == null) ? 0 : gObj.column.hashCode());
            result = prime * result + ((gObj.schema == null) ? 0 : gObj.schema.hashCode());
            result = prime * result + ((gObj.table == null) ? 0 : gObj.table.hashCode());
            result = prime * result + ((gObj.type == null) ? 0 : gObj.type.hashCode());
        }
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
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

    public DangerStatement getDanger() {
        return danger;
    }

    public GenericColumn getGenericColumn() {
        return gObj;
    }

    public String getSql() {
        return sql;
    }

    public String getObjName() {
        return gObj != null ? gObj.getObjName() : "";
    }

    public String getSchema() {
        return gObj == null ? null : gObj.schema;
    }

    public DbObjType getType() {
        return gObj == null ? null : gObj.type;
    }

    public final boolean compare(PgObjLocation loc) {
        GenericColumn col = loc.getGenericColumn();
        if (gObj == null || col == null) {
            return false;
        }
        return Objects.equals(gObj.schema, col.schema)
                && Objects.equals(gObj.table, col.table)
                && Objects.equals(gObj.column, col.column)
                && compareTypes(col.type);
    }

    private boolean compareTypes(DbObjType objType) {
        DbObjType type = gObj.type;
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