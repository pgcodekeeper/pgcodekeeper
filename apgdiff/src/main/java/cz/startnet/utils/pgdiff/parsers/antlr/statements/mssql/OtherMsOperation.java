package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Transaction_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.OtherOperation;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;

public class OtherMsOperation extends OtherOperation {

    public OtherMsOperation(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    protected void fillQueryLocation(String fullScript, List<List<QueryLocation>> batches,
            Set<DangerStatement> dangerStatements) {
        String query = ParserAbstract.getFullCtxText(ctx);

        String action;
        if (ctx instanceof Transaction_statementContext
                && ((Transaction_statementContext) ctx).BEGIN() != null) {
            action = "BEGIN TRANSACTION";
        } else {
            action = ParserAbstract.getStmtAction(query);
        }

        batches.get(batches.size() - 1).add(new QueryLocation(action, fullScript.indexOf(query),
                ctx.getStart().getLine(), query));
    }
}
