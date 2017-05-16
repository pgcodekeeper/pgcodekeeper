package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class UtilExpr {

    public static <T> void analyze(T ctx, AbstractExprWithNmspc<T> analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }
}
