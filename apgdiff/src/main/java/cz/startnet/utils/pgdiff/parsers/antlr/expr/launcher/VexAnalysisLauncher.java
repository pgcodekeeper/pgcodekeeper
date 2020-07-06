package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class VexAnalysisLauncher extends AbstractAnalysisLauncher {

    public VexAnalysisLauncher(PgStatementWithSearchPath stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        ValueExpr expr = new ValueExpr(db);
        expr.analyze(new Vex((VexContext) ctx));
        return expr.getDepcies();
    }
}
