package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UtilAnalyzeExpr {

    public static <T> void analyze(T ctx, AbstractExprWithNmspc<T> analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyze(VexContext ctx, ValueExpr analyzer, PgStatement pg) {
        analyzer.analyze(new Vex(ctx));
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyzeWithNmspc(ParserRuleContext ctx, PgStatement statement,
            String schemaName, String rawTableReference, PgDatabase db) {
        ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(schemaName, db);
        valExptWithNmspc.addRawTableReference(new GenericColumn(schemaName,
                rawTableReference, DbObjType.TABLE));
        analyze(new Vex((VexContext)ctx), valExptWithNmspc, statement);
    }

    private UtilAnalyzeExpr() {
    }
}
