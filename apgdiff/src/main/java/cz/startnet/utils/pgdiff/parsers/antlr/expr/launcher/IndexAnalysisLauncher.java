package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_columnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Option_with_valueContext;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class IndexAnalysisLauncher extends AbstractAnalysisLauncher {

    public IndexAnalysisLauncher(PgIndex stmt, Index_restContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        Set<PgObjLocation> depcies = new LinkedHashSet<>();
        Index_restContext rest = (Index_restContext) ctx;

        for (Index_columnContext c : rest.index_sort().index_column()) {
            depcies.addAll(analyzeTableChildVex(c.column, db));

            for (Option_with_valueContext o : c.option_with_value()) {
                depcies.addAll(analyzeTableChildVex(o.vex(), db));
            }
        }

        if (rest.index_where() != null){
            depcies.addAll(analyzeTableChildVex(rest.index_where().vex(), db));
        }

        return depcies;
    }
}
