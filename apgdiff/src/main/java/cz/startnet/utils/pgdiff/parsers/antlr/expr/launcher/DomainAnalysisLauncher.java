package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.TypesSetManually;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class DomainAnalysisLauncher extends AbstractAnalysisLauncher {

    public DomainAnalysisLauncher(PgDomain stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
        vex.addNamespaceVariable(new Pair<>("VALUE", TypesSetManually.UNKNOWN));
        return analyze((VexContext) ctx, vex);
    }
}
