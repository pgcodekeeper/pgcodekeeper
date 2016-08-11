package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class UtilExpr {

    public static void analyze(ParserRuleContext ctx, AbstractExprWithNmspc analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        for (GenericColumn col : analyzer.getDepcies()) {
            pg.addDep(col);
        }
    }
}
