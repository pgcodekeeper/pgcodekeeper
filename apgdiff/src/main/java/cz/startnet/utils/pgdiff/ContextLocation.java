package cz.startnet.utils.pgdiff;

import java.io.Serializable;
import java.util.Objects;

public abstract class ContextLocation implements Serializable {

    private static final long serialVersionUID = -2503595439071122218L;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContextLocation) {
            ContextLocation loc = (ContextLocation) obj;
            return Objects.equals(loc.getFilePath(), getFilePath())
                    && getOffset() == loc.getOffset()
                    && getLineNumber() == loc.getLineNumber()
                    && getCharPositionInLine() == loc.getCharPositionInLine();

        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + getOffset();
        result = prime * result + getLineNumber();
        result = prime * result + getCharPositionInLine();
        return result;
    }
}
