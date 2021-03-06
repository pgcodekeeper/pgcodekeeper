package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;

public class TriggerAnalysisLauncher extends AbstractAnalysisLauncher {

    public TriggerAnalysisLauncher(PgTrigger stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(meta);
        return analyzeTableChild((VexContext) ctx, vex);
    }
}
