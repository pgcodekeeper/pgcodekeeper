package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class UtilExpr {

    public static void create(ParserRuleContext ctx, AbstractExpr analizer, PgStatement pg) {
        analizer.analize(ctx);
        for (GenericColumn col : analizer.getDepcies()) {
            pg.addDep(col);
        }
    }
}
