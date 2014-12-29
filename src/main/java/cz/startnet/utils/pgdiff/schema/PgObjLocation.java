package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PgObjLocation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7110926210150404390L;
    private GenericColumn objName;
    private int offset;
    private String filePath;
    
    public String getObjName() {
        return objName.table != null ? objName.table : "";
    }
    
    public int getOffset() {
        return offset;
    }
    // непонятно какая длинна должна быть)
    // свитчить по типу в случае с колонкой?
    public int getObjLength() {
        int length = 0;
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

    public Path getFilePath() {
        return Paths.get(filePath);
    }

    public PgObjLocation(String schema, String name, String column, int offset,
            Path filePath) {
        this.objName = new GenericColumn(schema, name, column);
        this.offset = offset;
        this.filePath = filePath.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation)obj;
            return loc.getObjName() == getObjName()
                    && loc.getOffset() == getOffset()
                    && loc.getFilePath().equals(getFilePath());
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
        return result;
    }
    
    @Override
    public String toString() {
        return getObjName() + " " + filePath + " " + offset + getObjLength();
    }
}
