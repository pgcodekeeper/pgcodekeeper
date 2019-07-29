package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.ContextLocation;

public class AntlrError extends ContextLocation {

    private static final long serialVersionUID = -1845442501326683694L;

    private final String msg;
    private final String text;
    private final int start;
    private final int stop;
    private final String location;

    public AntlrError(Token tokenError, String location, int line, int charPositionInLine, String msg) {
        super(charPositionInLine, line);
        this.location = location;
        this.msg = msg;
        this.start = tokenError == null ? -1 : tokenError.getStartIndex();
        this.stop = tokenError == null ? -1 : tokenError.getStopIndex();
        this.text = tokenError == null ? null : tokenError.getText();
    }

    public int getCharPositionInLine() {
        return getOffset();
    }

    public String getMsg() {
        return msg;
    }

    public String getText() {
        return text;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return location + " line " + getLineNumber() + ':' + getCharPositionInLine() + ' ' + getMsg();
    }
}