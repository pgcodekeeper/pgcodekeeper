package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.meta.MetaUtils;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    private FullAnalyze fullAnalyze;

    public ViewAnalysisLauncher(PgView stmt, ParserRuleContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public void setFullAnalyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(db);
            select.setFullAnaLyze(fullAnalyze);
            MetaUtils.initializeView(db, stmt.getSchemaName(), stmt.getName(),
                    select.analyze((Select_stmtContext) ctx));
            return select.getDepcies();
        } else {
            return analyze((VexContext) ctx, new ValueExpr(db));
        }
    }
}
