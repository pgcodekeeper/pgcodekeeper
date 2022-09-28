package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsValueExpr;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

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
