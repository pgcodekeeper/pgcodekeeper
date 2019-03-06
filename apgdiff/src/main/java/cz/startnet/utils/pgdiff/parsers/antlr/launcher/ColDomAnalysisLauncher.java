package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class ColDomAnalysisLauncher extends AbstractAnalysisLauncher {

    public ColDomAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyze((VexContext) ctx, new ValueExpr(db), stmt);
    }
}
