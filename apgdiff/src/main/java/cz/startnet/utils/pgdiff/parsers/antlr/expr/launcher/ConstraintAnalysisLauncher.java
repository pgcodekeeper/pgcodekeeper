package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;

public class ConstraintAnalysisLauncher extends AbstractAnalysisLauncher {

    public ConstraintAnalysisLauncher(PgConstraint stmt, VexContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        return analyzeTableChildVex((VexContext) ctx);
    }
}
