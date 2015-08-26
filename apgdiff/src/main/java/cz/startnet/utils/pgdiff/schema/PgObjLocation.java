package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgObjLocation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7110926210150404390L;
    private final GenericColumn objName;
    private final int offset;
    private final Path filePath;
    private final int lineNumber;
    
    private DbObjType type;
    private String comment = "";
    private int objLength;
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
    // непонятно какая длина должна быть)
    // свитчить по типу в случае с колонкой?
    public int getObjLength() {
        int length = 0;
        if (type == DbObjType.FUNCTION) {
            return objLength;
        }
//        if (objName.schema != null) {
//            length += objName.schema.length(); 
//        }
        if (objName.table != null) {
            length += objName.table.length(); 
        }
//        if (objName.column != null) {
//            length += objName.table.length(); 
//        }
        return length;
    }
    
    public int getLineNumber() {
        return lineNumber;
    }

    public Path getFilePath() {
        return filePath;
    }
    
    public DbObjType getObjType() {
        return type;
    }
    
    public void setObjType(DbObjType type) {
        this.type = type;
    }
    
    public void setObjNameLength(int length) {
        this.objLength = length;
    }

    public PgObjLocation(String schema, String name, String column, int offset,
            Path filePath, int lineNumber) {
        this.objName = new GenericColumn(schema, name, column);
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
}