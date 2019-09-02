package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Script_transactionContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class OtherOperation extends ParserAbstract  {

    protected final ParserRuleContext ctx;

    public OtherOperation(ParserRuleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        // no impl
    }

    @Override
    protected QueryLocation fillQueryLocation(ParserRuleContext ctx) {
        String query = ParserAbstract.getFullCtxText(ctx);

        String action;
        if (ctx instanceof Script_transactionContext
                && ((Script_transactionContext) ctx).START() != null) {
            action = "START TRANSACTION";
        } else {
            action = getStmtAction(query);
        }

        QueryLocation loc = new QueryLocation(action, ctx.getStart().getStartIndex(),
                ctx.getStart().getLine(), query);
        db.addToBatch(loc);
        return loc;
    }
}
