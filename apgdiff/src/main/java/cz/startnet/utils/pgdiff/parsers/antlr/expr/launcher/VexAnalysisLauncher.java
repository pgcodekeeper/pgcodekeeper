package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class VexAnalysisLauncher extends AbstractAnalysisLauncher {

    public VexAnalysisLauncher(PgStatementWithSearchPath stmt, VexContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        analyze((VexContext) ctx, new ValueExpr(stmt.getDatabase()));
    }
}
