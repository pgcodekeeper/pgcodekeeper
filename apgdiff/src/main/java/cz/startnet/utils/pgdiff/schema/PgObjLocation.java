package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.ContextLocation;
import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgObjLocation extends ContextLocation {

    private static final long serialVersionUID = -6511243237472584008L;

    private DangerStatement danger;
    private int length = -1;

    private final String action;

    private final GenericColumn obj;
    private String sql;

    public PgObjLocation(GenericColumn obj, String action,
            int offset, int lineNumber, int charPositionInLine, String filePath) {
        super(filePath, offset, lineNumber, charPositionInLine);
        this.obj = obj;
        this.action = action;
    }

    public PgObjLocation(GenericColumn gObj, String action,
            int offset, int lineNumber, String filePath) {
        this(gObj, action, offset, lineNumber, 1, filePath);
    }

    public PgObjLocation(GenericColumn gObj) {
        this(gObj, null, 0, 0, null);
    }

    public PgObjLocation(GenericColumn gObj, ParserRuleContext ctx) {
        this(gObj, null, ctx.getStart().getStartIndex(), ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(), null);
        setLength(ctx.getStop().getStopIndex() - ctx.getStart().getStartIndex() + 1);
    }

    public PgObjLocation(String action, int offset, int lineNumber, int charPositionInLine, String sql) {
        this(null, action, offset, lineNumber, charPositionInLine, null);
        this.sql = sql;
    }

    public PgObjLocation(String action, ParserRuleContext ctx, String sql) {
        this(action, ctx.getStart().getStartIndex(), ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(), sql);
    }

    public PgObjLocation(String action, String sql) {
        this(null, action, 0, 0, 0, null);
        this.sql = sql;
    }

    public PgObjLocation(String filePath) {
        this(null, null, 0, 0, 0, filePath);
    }

    public String getAction() {
        return action;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getObjLength() {
        if (length > 0) {
            return length;
        }

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
            return Objects.equals(loc.getObj(), getObj())
                    && Objects.equals(loc.getSql(), getSql())
                    && Objects.equals(loc.getAction(), getAction());

        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (obj == null ? 0 : obj.hashCode());
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        return result;
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

    public GenericColumn getObj() {
        return obj;
    }

    public String getSql() {
        return sql;
    }

    public String getObjName() {
        return obj != null ? obj.getObjName() : "";
    }

    public String getSchema() {
        return obj == null ? null : obj.schema;
    }

    public DbObjType getType() {
        return obj == null ? null : obj.type;
    }

    public final boolean compare(PgObjLocation loc) {
        GenericColumn col = loc.getObj();
        if (obj == null || col == null) {
            return false;
        }
        return Objects.equals(obj.schema, col.schema)
                && Objects.equals(obj.column, col.column)
                && compareTypes(col.type)
                && compareNames(col.table);
    }

    private boolean compareNames(String objName) {
        String name = obj.table;
        if (Objects.equals(objName, name)) {
            return true;
        }

        DbObjType type = obj.type;
        if (type != DbObjType.FUNCTION && type != DbObjType.AGGREGATE
                && type != DbObjType.PROCEDURE && type != DbObjType.OPERATOR) {
            return false;
        }

        return (objName.startsWith(name + '(') || name.startsWith(objName + '('));
    }

    private boolean compareTypes(DbObjType objType) {
        DbObjType type = obj.type;
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
        case PROCEDURE:
            return type == DbObjType.FUNCTION || type == DbObjType.AGGREGATE || type == DbObjType.PROCEDURE;
        case TYPE:
        case DOMAIN:
            return type == DbObjType.TYPE || type == DbObjType.DOMAIN;
        default:
            return false;
        }
    }

    public PgObjLocation copyWithOffset(int offset, int lineOffset,
            int inLineOffset, String filePath) {
        PgObjLocation loc = new PgObjLocation(obj, getAction(),
                getOffset() + offset,
                getLineNumber() + lineOffset,
                getCharPositionInLine() + inLineOffset,
                filePath);
        loc.setLength(length);
        return loc;
    }

    @Override
    public String toString() {
        GenericColumn gc = getObj();
        if (gc != null) {
            return gc.toString();
        }

        return super.toString();
    }
}