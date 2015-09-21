package cz.startnet.utils.pgdiff.parsers.antlr;

public class FunctionBodyContainer {

    private final String body;
    private final int offset;
    private final String path;
    private final int line;

    public FunctionBodyContainer(String path, int offset, int line, String body) {
        this.body = body;
        this.offset = offset;
        this.path = path;
        this.line = line;
    }

    public String getBody() {
        return body;
    }

    public int getOffset() {
        return offset;
    }

    public String getPath() {
        return path;
    }

    public int getLineNumber() {
        return line;
    }
}
