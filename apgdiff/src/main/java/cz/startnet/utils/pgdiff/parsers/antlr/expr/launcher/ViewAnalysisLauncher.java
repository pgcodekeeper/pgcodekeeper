package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.meta.MetaRelation;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    private FullAnalyze fullAnalyze;

    public ViewAnalysisLauncher(PgView stmt, ParserRuleContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public void setFullAnalyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx, IDatabase db) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(db);
            select.setFullAnaLyze(fullAnalyze);
            List<ModPair<String, String>> columns = select.analyze((Select_stmtContext) ctx);
            IRelation rel = db.getSchema(stmt.getSchemaName()).getRelation(stmt.getName());
            if (rel instanceof MetaRelation) {
                MetaRelation meta = (MetaRelation) rel;
                columns.forEach(col -> meta.addColumn(col.getFirst(), col.getSecond()));
                meta.setInitialized(true);
            }
            return select.getDepcies();
        } else {
            return analyze((VexContext) ctx, new ValueExpr(db));
        }
    }
}
