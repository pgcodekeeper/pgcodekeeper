package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class MsSelectAnalysisLauncher extends AbstractAnalysisLauncher {

    private final MsSelect sel;

    public MsSelectAnalysisLauncher(PgStatementWithSearchPath stmt,
            Select_statementContext ctx, String location, MsSelect sel) {
        super(stmt, ctx, location);
        this.sel = sel;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        sel.analyze((Select_statementContext) ctx);
        return sel.getDepcies();
    }
}
