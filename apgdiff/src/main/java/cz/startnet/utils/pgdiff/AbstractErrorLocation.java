package cz.startnet.utils.pgdiff;

public abstract class AbstractErrorLocation {

    protected int offset;
    protected int lineNumber;

    public AbstractErrorLocation() {
    }

    public AbstractErrorLocation(int offset, int lineNumber) {
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
