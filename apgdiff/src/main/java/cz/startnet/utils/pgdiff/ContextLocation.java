package cz.startnet.utils.pgdiff;

import java.io.Serializable;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = -7400598722671864553L;

    private final int offset;
    private final int lineNumber;
    private final int charPositionInLine;

    public ContextLocation(int offset, int lineNumber, int charPositionInLine) {
        this.offset = offset;
        this.lineNumber = lineNumber;
        this.charPositionInLine = charPositionInLine;
    }

    public int getOffset() {
        return offset;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }
}
