package cz.startnet.utils.pgdiff;

import java.io.Serializable;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = -7214452461486627862L;

    private final String filePath;
    private final int offset;
    private final int lineNumber;
    private final int charPositionInLine;

    public ContextLocation(String filePath, int offset, int lineNumber, int charPositionInLine) {
        this.filePath = filePath;
        this.offset = offset;
        this.lineNumber = lineNumber;
        this.charPositionInLine = charPositionInLine;
    }

    public String getFilePath() {
        return filePath;
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
