package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

public class AntlrError {

    private final int line;
    private final int charPositionInLine;
    private final String msg;
    private final String text;
    private final int start;
    private final int stop;
    private final String location;

    public AntlrError(Token tokenError, String location, int line, int charPositionInLine, String msg) {
        this(location, line, charPositionInLine, msg,
                (tokenError == null ? -1 : tokenError.getStartIndex()),
                (tokenError == null ? -1 : tokenError.getStopIndex()),
                (tokenError == null ? null : tokenError.getText()));
    }

    private AntlrError(String location, int line, int charPositionInLine, String msg, int start, int stop, String text) {
        this.location = location;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
        this.start = start;
        this.stop = stop;
        this.text = text;
    }

    public AntlrError copyWithOffset(int offset, int lineOffset, int inLineOffset) {
        return new AntlrError(location, line + lineOffset,
                (line == 1 ? charPositionInLine + inLineOffset : charPositionInLine),
                msg,
                (start == -1 ? -1 : start + offset),
                (stop == -1 ? -1: stop + offset),
                text);
    }

    public int getLine() {
        return line;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
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
        // ANTLR position in line is 0-based, GUI's is 1-based
        return location + " line " + getLine() + ':' + (getCharPositionInLine() + 1) + ' ' + getMsg();
    }
}