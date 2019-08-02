package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

public class TriggerAnalysisLauncher extends AbstractAnalysisLauncher {

    public TriggerAnalysisLauncher(PgTrigger stmt, VexContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
        analyzeTableChild((VexContext) ctx, vex);
    }
}
