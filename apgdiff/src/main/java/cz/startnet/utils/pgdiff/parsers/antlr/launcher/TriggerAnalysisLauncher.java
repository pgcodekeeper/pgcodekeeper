package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class TriggerAnalysisLauncher extends AbstractAnalysisLauncher {

    public TriggerAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeTriggersWhen((VexContext) ctx, (PgTrigger) stmt, schemaName, db);
    }

    private void analyzeTriggersWhen(VexContext ctx, PgTrigger trigger,
            String schemaName, PgDatabase db) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(db);
        GenericColumn implicitTable = new GenericColumn(schemaName,
                trigger.getParent().getName(), DbObjType.TABLE);
        vex.addReference("new", implicitTable);
        vex.addReference("old", implicitTable);
        analyze(ctx, vex, trigger);
    }
}
