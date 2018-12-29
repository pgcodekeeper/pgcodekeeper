package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public final class PgObjLocation extends GenericColumn implements Serializable {

    private static final long serialVersionUID = -2207831039348997758L;

    // danger statement desc
    public static final String DROP_TABLE = "DROP TABLE statement";
    public static final String ALTER_COLUMN_TYPE = "ALTER COLUMN ... TYPE statement";
    public static final String DROP_COLUMN = "DROP COLUMN statement";
    public static final String RESTART_WITH = "ALTER SEQUENCE ... RESTART WITH statement";
    public static final String UPDATE = "UPDATE statement";

    private int offset;
    private String filePath;
    private int lineNumber;

    private String text;
    private String comment = "";
    private StatementActions action = StatementActions.NONE;

    public PgObjLocation(String filePath) {
        super(null, null);
        this.filePath = filePath;
    }

    public PgObjLocation(String schema, String table, String column, DbObjType type) {
        super(schema, table, column, type);
    }

    public PgObjLocation(String schema, String object, DbObjType type) {
        this(schema, object, null, type);
    }

    public PgObjLocation(String schema, DbObjType type) {
        this(schema, null, type);
    }

    public StatementActions getAction() {
        return action;
    }

    public PgObjLocation setAction(StatementActions action) {
        this.action = action;
        return this;
    }

    public PgObjLocation setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public PgObjLocation setLine(int lineNumber) {
        this.lineNumber = lineNumber;
        return this;
    }

    public PgObjLocation setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
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
                    && loc.getFilePath().equals(getFilePath());
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

    public void setWarningText(String text) {
        this.text = text;
    }

    public boolean isDanger() {
        return text != null;
    }

    public static PgObjLocation create(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case DATABASE:
        case COLUMN:
            return null;
        case ASSEMBLY:
        case EXTENSION:
        case SCHEMA:
        case ROLE:
        case USER:
            return new PgObjLocation(st.getName(), type);
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
            return new PgObjLocation(st.getParent().getParent().getName(),
                    st.getParent().getName(), st.getName(), type);
        default:
            return new PgObjLocation(st.getParent().getName(), st.getName(), type);
        }
    }
}