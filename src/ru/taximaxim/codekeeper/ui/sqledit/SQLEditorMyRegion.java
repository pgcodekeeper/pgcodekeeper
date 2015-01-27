package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;

public class SQLEditorMyRegion implements IRegion {
    
    private int length;
    private int offset;
    private String comment = "";
    
    public SQLEditorMyRegion(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getOffset() {
        return offset;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;        
    }
}
