package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Script_transactionContext;

public class OtherOperation extends ParserAbstract  {

    protected final ParserRuleContext ctx;

    public OtherOperation(ParserRuleContext ctx) {
        super(null);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        // no impl
    }

    @Override
    protected void fillQueryLocation(String fullScript) {
        String query = ParserAbstract.getFullCtxText(ctx);

        String action;
        if (ctx instanceof Script_transactionContext
                && ((Script_transactionContext) ctx).START() != null) {
            action = "START TRANSACTION";
        } else {
            action = ParserAbstract.getStmtAction(query);
        }

        db.addToBatch(new QueryLocation(action, fullScript.indexOf(query),
                ctx.getStart().getLine(), query));
    }
}
