package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PGObjLocation implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7110926210150404390L;
    private String objName;
    private String filePath;
    private int offset;
    
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

    public PGObjLocation(String objName, int offset,
            Path filePath) {
        this.objName = objName;
        this.offset = offset;
        this.filePath = filePath.toString();
    }
    @Override
    public String toString() {
        return objName + " " + filePath + " " + offset + objName.length();
    }
}
