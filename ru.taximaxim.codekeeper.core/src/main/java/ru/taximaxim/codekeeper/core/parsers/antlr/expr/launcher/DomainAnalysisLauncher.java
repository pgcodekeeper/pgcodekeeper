package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.TypesSetManually;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.ValueExprWithNmspc;
import ru.taximaxim.codekeeper.core.schema.PgDomain;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

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
