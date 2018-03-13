package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;

public class StatementBodyContainer {

    private final String body;
    private final int offset;
    private final String path;
    private final int line;

    public StatementBodyContainer(String path, ParserRuleContext ctx) {
        this.path = path;
        offset = ctx.getStart().getStartIndex();
        line = ctx.getStart().getLine();
        body = ParserAbstract.getFullCtxText(ctx);
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
