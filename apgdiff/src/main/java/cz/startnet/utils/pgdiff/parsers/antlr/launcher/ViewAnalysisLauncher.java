package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    public ViewAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeViewCtx(ctx, (AbstractView) stmt, db);
    }

    private void analyzeViewCtx(ParserRuleContext ctx, AbstractView view,
            PgDatabase db) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(db);
            view.addRelationColumns(select.analyze((Select_stmtContext) ctx));
            view.addAllDeps(select.getDepcies());
        } else {
            analyze((VexContext) ctx, new ValueExpr(db), view);
        }
    }
}
