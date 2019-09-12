package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;

public class ConstraintAnalysisLauncher extends AbstractAnalysisLauncher {

    public ConstraintAnalysisLauncher(PgConstraint stmt, VexContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        analyzeTableChildVex((VexContext) ctx);
    }
}
