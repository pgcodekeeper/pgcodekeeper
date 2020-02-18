package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsView;

public class MsViewAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsViewAnalysisLauncher(MsView stmt, Select_statementContext ctx,
            String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        MsSelect select = new MsSelect(stmt.getSchemaName());
        return analyze((Select_statementContext) ctx, select);
    }
}
