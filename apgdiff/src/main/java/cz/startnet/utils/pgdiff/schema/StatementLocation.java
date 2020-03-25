package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.ContextLocation;

public class StatementLocation extends ContextLocation {

    private static final long serialVersionUID = -809073149629778353L;

    private final int length;

    public StatementLocation(String filePath, int offset, int lineNumber,
            int charPositionInLine, int length) {
        super(filePath, offset, lineNumber, charPositionInLine);
        this.length = length;
    }

    public StatementLocation(String filePath) {
        this(filePath, 0, 0, 0, 0);
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!super.equals(obj)) {
            return false;
        }

        if (obj instanceof StatementLocation) {
            StatementLocation loc = (StatementLocation) obj;
            return loc.length == length;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + length;
        return result;
    }
}
