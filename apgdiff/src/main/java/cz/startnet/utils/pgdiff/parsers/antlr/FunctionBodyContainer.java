package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;

public class FunctionBodyContainer {

    private final String body;
    private final int offset;
    private final Path path;
    private final int line;
    
    public FunctionBodyContainer(Path path, int offset, int line, String body) {
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

    public Path getPath() {
        return path;
    }

    public int getLineNumber() {
        return line;
    }
}
