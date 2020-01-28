package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

public class TriggerAnalysisLauncher extends AbstractAnalysisLauncher {

    public TriggerAnalysisLauncher(PgTrigger stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
        return analyzeTableChild((VexContext) ctx, vex);
    }
}
