package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PgObjLocation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7110926210150404390L;
    private transient PgStatement obj;
    private String objName;
    private String filePath;
    private int offset;
    
    public PgStatement getObj() {
        return obj;
    }
    
    public String getObjName() {
        return objName;
    }
    
    public int getOffset() {
        return offset;
    }
    public int getObjLength() {
        return objName.length();
    }

    public Path getFilePath() {
        return Paths.get(filePath);
    }

    public PgObjLocation(PgStatement obj, int offset,
            Path filePath) {
        this.obj = obj;
        objName = obj != null ? obj.getBareName() : "";
        this.offset = offset;
        this.filePath = filePath.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation)obj;
            return loc.getObj().equals(getObj())
                    && loc.getObjName() == getObjName()
                    && loc.getOffset() == getOffset();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((obj == null) ? 0 : obj.hashCode());
        result = prime * result + ((objName == null) ? 0 : objName.hashCode());
        result = prime * result + offset;
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return obj + " " + filePath + " " + offset + obj.getBareName().length();
    }
}
