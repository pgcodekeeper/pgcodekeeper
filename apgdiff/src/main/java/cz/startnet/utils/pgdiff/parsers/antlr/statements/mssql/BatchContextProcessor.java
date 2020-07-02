package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.SourceStatement;

public abstract class BatchContextProcessor extends ParserAbstract {

    private final ParserRuleContext batchCtx;
    private final CommonTokenStream stream;

    public BatchContextProcessor(PgDatabase db, ParserRuleContext batchCtx,
            CommonTokenStream stream) {
        super(db);
        this.batchCtx = batchCtx;
        this.stream = stream;
    }

    /**
     * @return the context, after which the second source part starts
     */
    protected abstract ParserRuleContext getDelimiterCtx();

    protected void setSourceParts(SourceStatement st) {
        boolean isKeepNewLines = db.getArguments().isKeepNewlines();
        String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
        st.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));

        List<Token> endTokens = stream.getHiddenTokensToRight(batchCtx.getStop().getTokenIndex());
        Token stopToken = endTokens != null ? endTokens.get(endTokens.size() - 1) : batchCtx.getStop();
        int stop = stopToken.getStopIndex();
        int start = getDelimiterCtx().getStop().getStopIndex() + 1;
        String second = stopToken.getInputStream().getText(Interval.of(start, stop));
        st.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        String act = getStmtAction();
        List<Token> startTokens = stream.getHiddenTokensToLeft(ctx.getStart().getTokenIndex());
        List<Token> stopTokens = stream.getHiddenTokensToRight(ctx.getStop().getTokenIndex());
        Token start = startTokens != null ? startTokens.get(0) : ctx.getStart();
        Token stop = stopTokens != null ? stopTokens.get(stopTokens.size() - 1) : ctx.getStop();
        String sql = getFullCtxText(start, stop);
        String action = act != null ? act : ctx.getStart().getText().toUpperCase(Locale.ROOT);
        int offset = start.getStartIndex();
        int lineNumber = start.getLine();
        int charPositionInLine = start.getCharPositionInLine();

        PgObjLocation loc = new PgObjLocation(action, offset, lineNumber, charPositionInLine, sql);
        db.addReference(fileName, loc);
        return loc;
    }
}
