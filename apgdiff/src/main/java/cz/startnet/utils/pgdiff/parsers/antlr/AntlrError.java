package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.Token;

public class AntlrError {

    private final int line;
    private final int charPositionInLine;
    private final String msg;
    private final String text;
    private final int start;
    private final int stop;

    public AntlrError(Token tokenError, String msg) {
        this.line = tokenError.getLine();
        this.charPositionInLine = tokenError.getCharPositionInLine();
        this.start = tokenError.getStartIndex();
        this.stop = tokenError.getStopIndex();
        this.msg = msg;
        this.text = tokenError.getText();
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
}
