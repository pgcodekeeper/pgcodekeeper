package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;

public class MsExpressionAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsExpressionAnalysisLauncher(PgStatementWithSearchPath stmt,
            ExpressionContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        MsValueExpr expr = new MsValueExpr(stmt.getSchemaName());
        return analyze((ExpressionContext) ctx, expr);
    }
}
