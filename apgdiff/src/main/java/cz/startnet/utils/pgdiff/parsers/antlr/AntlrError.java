package cz.startnet.utils.pgdiff.parsers.antlr;

public class AntlrError {

    private final int line;
    private final int charPositionInLine;
    private final String msg;

    public AntlrError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
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
}
