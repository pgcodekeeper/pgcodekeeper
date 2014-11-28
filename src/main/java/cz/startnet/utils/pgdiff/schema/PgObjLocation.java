package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PgObjLocation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7110926210150404390L;
    private PgStatement obj;
    private String schemaName;
    private String filePath;
    private int offset;
    
    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
    public PgStatement getObj() {
        return obj;
    }
    
    public String getObjName() {
        return obj.getBareName();
    }
    
    public int getOffset() {
        return offset;
    }
    public int getObjLength() {
        return obj.getBareName().length();
    }

    public Path getFilePath() {
        return Paths.get(filePath);
    }

    public PgObjLocation(PgStatement obj, int offset,
            Path filePath) {
        this.obj = obj;
        this.offset = offset;
        this.filePath = filePath.toString();
    }
    @Override
    public String toString() {
        return obj + " " + filePath + " " + offset + obj.getBareName().length();
    }
}
