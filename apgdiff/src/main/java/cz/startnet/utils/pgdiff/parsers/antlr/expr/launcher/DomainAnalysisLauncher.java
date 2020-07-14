package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.TypesSetManually;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class DomainAnalysisLauncher extends AbstractAnalysisLauncher {

    public DomainAnalysisLauncher(PgDomain stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(meta);
        vex.addNamespaceVariable(new Pair<>("VALUE", TypesSetManually.UNKNOWN));
        return analyze((VexContext) ctx, vex);
    }
}
