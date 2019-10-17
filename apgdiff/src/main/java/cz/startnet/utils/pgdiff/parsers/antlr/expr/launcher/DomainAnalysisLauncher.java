package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.TypesSetManually;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class DomainAnalysisLauncher extends AbstractAnalysisLauncher {

    public DomainAnalysisLauncher(PgDomain stmt, VexContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
        vex.addNamespaceVariable(new Pair<>("VALUE", TypesSetManually.UNKNOWN));
        analyze((VexContext) ctx, vex);
    }
}
