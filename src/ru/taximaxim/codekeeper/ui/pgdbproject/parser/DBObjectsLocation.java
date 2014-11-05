package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

public class DBObjectsLocation implements Serializable {
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
    
    public IRegion getRegion() {
        return new Region(offset, objName.length());
    }

    public Path getFilePath() {
        return Paths.get(filePath);
    }

    public DBObjectsLocation(String objName, int offset,
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
