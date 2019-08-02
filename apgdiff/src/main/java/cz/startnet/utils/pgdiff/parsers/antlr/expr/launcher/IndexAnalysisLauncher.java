package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.schema.PgIndex;

public class IndexAnalysisLauncher extends AbstractAnalysisLauncher {

    public IndexAnalysisLauncher(PgIndex stmt, Index_restContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        Index_restContext rest = (Index_restContext) ctx;

        for (Sort_specifierContext sort_ctx : rest.index_sort().sort_specifier_list()
                .sort_specifier()) {
            analyzeTableChildVex(sort_ctx.key);
        }

        if (rest.index_where() != null){
            analyzeTableChildVex(rest.index_where().vex());
        }
    }
}
