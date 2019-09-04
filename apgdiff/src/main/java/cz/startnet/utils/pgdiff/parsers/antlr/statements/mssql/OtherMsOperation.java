package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Transaction_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.OtherOperation;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class OtherMsOperation extends OtherOperation {

    public OtherMsOperation(ParserRuleContext ctx, PgDatabase db) {
        super(ctx, db);
    }

    @Override
    protected QueryLocation fillQueryLocation(ParserRuleContext ctx) {
        String query = ParserAbstract.getFullCtxText(ctx);

        String action;
        if (ctx instanceof Transaction_statementContext
                && ((Transaction_statementContext) ctx).BEGIN() != null) {
            action = "BEGIN TRANSACTION";
        } else {
            action = ParserAbstract.getStmtAction(query);
        }

        QueryLocation loc = new QueryLocation(action, ctx, query);
        db.addToBatch(loc);

        return loc;
    }
}
