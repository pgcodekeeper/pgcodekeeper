package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;
import cz.startnet.utils.pgdiff.schema.meta.MetaUtils;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    private FullAnalyze fullAnalyze;

    public ViewAnalysisLauncher(PgView stmt, Select_stmtContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public void setFullAnalyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Select select = new Select(meta);
        select.setFullAnaLyze(fullAnalyze);
        MetaUtils.initializeView(meta, stmt.getSchemaName(), stmt.getName(),
                select.analyze((Select_stmtContext) ctx));
        return select.getDepcies();
    }
}
