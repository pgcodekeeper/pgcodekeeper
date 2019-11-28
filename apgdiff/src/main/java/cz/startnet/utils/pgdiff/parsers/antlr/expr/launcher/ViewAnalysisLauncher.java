package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.ArrayList;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgView;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    private FullAnalyze fullAnalyze;

    public ViewAnalysisLauncher(PgView stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    public void setFullAnalyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(stmt.getDatabase());
            select.setFullAnaLyze(fullAnalyze);
            ((PgView) stmt).addRelationColumns(new ArrayList<>(select.analyze((Select_stmtContext) ctx)));
            return select.getDepcies();
        } else {
            return analyze((VexContext) ctx, new ValueExpr(stmt.getDatabase()));
        }
    }
}
