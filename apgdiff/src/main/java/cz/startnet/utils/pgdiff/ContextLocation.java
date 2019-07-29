package cz.startnet.utils.pgdiff;

import java.io.Serializable;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = 7334100073425496383L;

    protected int offset;
    protected int lineNumber;

    public ContextLocation(int offset, int lineNumber) {
        this.offset = offset;
        this.lineNumber = lineNumber;
    }

    public int getOffset() {
        return offset;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
