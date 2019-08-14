package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
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
    protected void fillQueryLocation(String fullScript, List<List<QueryLocation>> batches,
            Set<DangerStatement> dangerStatements) {
        String query = ParserAbstract.getFullCtxText(ctx);

        String action;
        if (ctx instanceof Script_transactionContext
                && ((Script_transactionContext) ctx).START() != null) {
            action = "START TRANSACTION";
        } else {
            action = ParserAbstract.getStmtAction(query);
        }

        batches.get(0).add(new QueryLocation(action, fullScript.indexOf(query),
                ctx.getStart().getLine(), query));
    }
}
