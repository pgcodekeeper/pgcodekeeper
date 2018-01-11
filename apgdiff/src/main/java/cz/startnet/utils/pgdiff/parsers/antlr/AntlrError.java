package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

public class AntlrError {

    private final int line;
    private final int charPositionInLine;
    private final String msg;
    private final String text;
    private final int start;
    private final int stop;
    private String location;

    public AntlrError(Token tokenError, int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
        this.start = tokenError == null ? -1 : tokenError.getStartIndex();
        this.stop = tokenError == null ? -1 : tokenError.getStopIndex();
        this.text = tokenError == null ? null : tokenError.getText();
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

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return location + " line " + getLine() + ':' + getCharPositionInLine() + ' ' + getMsg();
    }
}