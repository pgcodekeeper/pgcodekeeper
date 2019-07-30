package cz.startnet.utils.pgdiff;

import java.io.Serializable;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = 7334100073425496383L;

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
