package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class MsExpressionAnalysisLauncher extends AbstractAnalysisLauncher {

    private final MsValueExpr vex;

    public MsExpressionAnalysisLauncher(PgStatementWithSearchPath stmt,
            ExpressionContext ctx, String location, MsValueExpr vex) {
        super(stmt, ctx, location);
        this.vex = vex;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        vex.analyze((ExpressionContext) ctx);
        return vex.getDepcies();
    }
}
