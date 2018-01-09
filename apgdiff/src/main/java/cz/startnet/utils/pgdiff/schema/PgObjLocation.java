package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;

import cz.startnet.utils.pgdiff.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgObjLocation implements Serializable {

    private static final long serialVersionUID = -7110926210150404390L;
    private final GenericColumn objName;
    private final int offset;
    private final String filePath;
    private final int lineNumber;

    private String text;
    private DbObjType type;
    private String comment = "";
    private StatementActions action;

    public StatementActions getAction() {
        return action;
    }

    public PgObjLocation setAction(StatementActions action) {
        this.action = action;
        return this;
    }

    public GenericColumn getObject() {
        return objName;
    }

    public String getObjName() {
        return objName.table != null ? objName.table : "";
    }

    public int getOffset() {
        return offset;
    }

    public int getObjLength() {
        return objName.table != null ? objName.table.length() : 0;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public DbObjType getObjType() {
        return type;
    }

    public void setObjType(DbObjType type) {
        this.type = type;
    }

    public PgObjLocation(String schema, String name, String column, int offset,
            String filePath, int lineNumber) {
        // TODO pass through object type from caller if it becomes necessary
        this.objName = new GenericColumn(schema, name, column, null);
        this.offset = offset;
        this.filePath = filePath;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation) obj;
            return loc.getObject().equals(getObject())
                    && loc.getOffset() == getOffset()
                    && loc.getFilePath().equals(getFilePath())
                    && loc.getObjType().equals(getObjType());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objName == null) ? 0 : objName.hashCode());
        result = prime * result + offset;
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getObjName() + " " + filePath + " " + offset + " " + getObjLength() + " " + type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDanger() {
        if (action == StatementActions.DROP && type == DbObjType.TABLE){
            return true;
        }

        if (action == StatementActions.ALTER) {
            if (type == DbObjType.TABLE) {
                return DangerStatement.ALTER_COLUMN.getRegex().matcher(text).matches()
                        || DangerStatement.DROP_COLUMN.getRegex().matcher(text).matches();
            } else {
                return type == DbObjType.SEQUENCE &&
                        DangerStatement.RESTART_WITH.getRegex().matcher(text).matches();
            }
        }

        return false;
    }
}