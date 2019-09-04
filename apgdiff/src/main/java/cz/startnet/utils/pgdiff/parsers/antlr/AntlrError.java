package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.ContextLocation;

public class AntlrError extends ContextLocation {

    private static final long serialVersionUID = 1073046057633815985L;

    private final String msg;
    private final String text;
    private final int stop;

    public AntlrError(Token tokenError, String location, int line, int charPositionInLine, String msg) {
        super(location, tokenError == null ? -1 : tokenError.getStartIndex(), line, charPositionInLine);
        this.msg = msg;
        this.stop = tokenError == null ? -1 : tokenError.getStopIndex();
        this.text = tokenError == null ? null : tokenError.getText();
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
        return getFilePath() + " line " + getLineNumber() + ':' + getCharPositionInLine() + ' ' + getMsg();
    }
}