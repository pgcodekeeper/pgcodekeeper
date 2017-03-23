package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class UtilExpr {

    public static void analyze(ParserRuleContext ctx, AbstractExprWithNmspc analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }
}
