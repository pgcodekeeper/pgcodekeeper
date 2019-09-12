package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.PgView;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    public ViewAnalysisLauncher(PgView stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(stmt.getDatabase());
            ((PgView) stmt).addRelationColumns(select.analyze((Select_stmtContext) ctx));
            stmt.addAllDeps(select.getDepcies());
        } else {
            analyze((VexContext) ctx, new ValueExpr(stmt.getDatabase()));
        }
    }
}
