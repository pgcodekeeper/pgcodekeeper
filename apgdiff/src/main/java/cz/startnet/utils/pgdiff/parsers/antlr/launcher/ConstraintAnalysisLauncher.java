package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class ConstraintAnalysisLauncher extends AbstractAnalysisLauncher {

    public ConstraintAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeWithNmspc((VexContext) ctx, stmt, schemaName,
                stmt.getParent().getName(), db);
    }
}
