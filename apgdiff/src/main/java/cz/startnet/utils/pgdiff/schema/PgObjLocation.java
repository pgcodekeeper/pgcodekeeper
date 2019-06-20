package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class PgObjLocation extends GenericColumn implements Serializable {

    private static final long serialVersionUID = -2207831039348997758L;

    private int offset;
    private String filePath;
    private int lineNumber;

    private String text;
    private String comment = "";
    private final StatementActions action;

    public PgObjLocation(String filePath) {
        super(null, null);
        this.filePath = filePath;
        this.action = StatementActions.NONE;
    }

    public PgObjLocation(String schema, String table, String column,
            DbObjType type, StatementActions action) {
        super(schema, table, column, type);
        this.action = action;
    }

    public PgObjLocation(String schema, String object, DbObjType type, StatementActions action) {
        this(schema, object, null, type, action);
    }

    public PgObjLocation(String schema, DbObjType type, StatementActions action) {
        this(schema, null, type, action);
    }

    public StatementActions getAction() {
        return action;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLine(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        if (obj instanceof PgObjLocation && super.equals(obj)) {
            PgObjLocation loc = (PgObjLocation) obj;
            return loc.getOffset() == getOffset()
                    && Objects.equals(loc.getFilePath(), getFilePath());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + offset;
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getObjName() + ' ' + filePath + ' ' + offset + ' '
                + getObjLength() + ' ' + type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWarningText() {
        return text;
    }

    public void setWarningText(DangerStatement danger) {
        switch(danger) {
        case ALTER_COLUMN:
            text = "ALTER COLUMN ... TYPE statement";
            break;
        case DROP_COLUMN:
            text = "DROP COLUMN statement";
            break;
        case DROP_TABLE:
            text = "DROP TABLE statement";
            break;
        case RESTART_WITH:
            text =  "ALTER SEQUENCE ... RESTART WITH statement";
            break;
        case UPDATE:
            text = "UPDATE statement";
            break;
        default:
            return;
        }
    }

    public boolean isDanger() {
        return text != null;
    }
}