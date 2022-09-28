package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsSelect;
import ru.taximaxim.codekeeper.core.schema.MsView;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class MsViewAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsViewAnalysisLauncher(MsView stmt, Select_statementContext ctx,
            String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        MsSelect select = new MsSelect(stmt.getSchemaName());
        return analyze((Select_statementContext) ctx, select);
    }
}
