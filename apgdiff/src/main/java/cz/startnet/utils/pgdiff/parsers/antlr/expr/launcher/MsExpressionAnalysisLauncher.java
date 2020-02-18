package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class MsExpressionAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsExpressionAnalysisLauncher(PgStatementWithSearchPath stmt,
            ExpressionContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        MsValueExpr expr = new MsValueExpr(stmt.getSchemaName());
        return analyze((ExpressionContext) ctx, expr);
    }
}
