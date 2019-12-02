package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.ContextLocation;

public class AntlrError extends ContextLocation {

    private static final long serialVersionUID = 3290362774294960759L;

    private final String msg;
    private final String text;
    private final int stop;

    public AntlrError(Token tokenError, String location, int line, int charPositionInLine, String msg) {
        this(location, line, charPositionInLine, msg,
                (tokenError == null ? -1 : tokenError.getStartIndex()),
                (tokenError == null ? -1 : tokenError.getStopIndex()),
                (tokenError == null ? null : tokenError.getText()));
    }

    private AntlrError(String location, int line, int charPositionInLine, String msg,
            int start, int stop, String text) {
        super(location, start, line, charPositionInLine);
        this.msg = msg;
        this.stop = stop;
        this.text = text;
    }

    public AntlrError copyWithOffset(int offset, int lineOffset, int inLineOffset) {
        return new AntlrError(getFilePath(), getLineNumber() + lineOffset,
                (getLineNumber() == 1 ? getCharPositionInLine() + inLineOffset : getCharPositionInLine()),
                msg,
                (getStart() == -1 ? -1 : getStart() + offset),
                (stop == -1 ? -1: stop + offset),
                text);
    }

    public String getMsg() {
        return msg;
    }

    public String getText() {
        return text;
    }

    public int getStart() {
        return getOffset();
    }

    public int getStop() {
        return stop;
    }

    @Override
    public String toString() {
        // ANTLR position in line is 0-based, GUI's is 1-based
        return getFilePath() + " line " + getLineNumber() + ':' + (getCharPositionInLine() + 1) + ' ' + getMsg();
    }
}