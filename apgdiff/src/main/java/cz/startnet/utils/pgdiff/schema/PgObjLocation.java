package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.ContextLocation;
import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgObjLocation extends ContextLocation {

    private static final long serialVersionUID = -6511243237472584008L;

    private DangerStatement danger;
    private int length = -1;

    private final String action;

    private final GenericColumn obj;
    private final String sql;

    PgObjLocation(String filePath, int offset, int lineNumber, int charPositionInLine,
            GenericColumn obj, String action, String sql, int length) {
        super(filePath, offset, lineNumber, charPositionInLine);
        this.obj = obj;
        this.sql = sql;
        this.action = action;
        this.length = length;
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

    public int getObjLength() {
        return length;
    }

    public String getAction() {
        return action;
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

    public String getTable() {
        return obj == null ? null : obj.table;
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
        return new PgObjLocation(filePath,
                getOffset() + offset,
                getLineNumber() + lineOffset,
                getCharPositionInLine() + inLineOffset,
                obj, action, sql, length);
    }

    @Override
    public String toString() {
        GenericColumn gc = getObj();
        if (gc != null) {
            return gc.toString();
        }

        return super.toString();
    }

    public static final class Builder {

        private String filePath;
        private String action;
        private String sql;
        private int offset;
        private int lineNumber;
        private int charPositionInLine;
        private GenericColumn object;
        private ParserRuleContext ctx;

        public Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setSql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder setOffset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
            return this;
        }

        public Builder setCharPositionInLine(int charPositionInLine) {
            this.charPositionInLine = charPositionInLine;
            return this;
        }

        public Builder setObject(GenericColumn object) {
            this.object = object;
            return this;
        }

        public Builder setCtx(ParserRuleContext ctx) {
            this.ctx = ctx;
            return this;
        }

        public PgObjLocation build() {
            if (ctx != null) {
                Token start = ctx.getStart();
                int offset = start.getStartIndex();
                int line = start.getLine();
                int position = start.getCharPositionInLine();
                int length = ctx.getStop().getStopIndex() - offset + 1;

                return new PgObjLocation(filePath, offset, line, position,
                        object, action, sql, length);
            }

            int length = object == null ? 0 : object.getObjName().length();

            return new PgObjLocation(filePath, offset, lineNumber, charPositionInLine,
                    object, action, sql, length);
        }
    }
}