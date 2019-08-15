package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Enable_disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DisableMsTrigger extends ParserAbstract {

    private final Enable_disable_triggerContext ctx;

    public DisableMsTrigger(Enable_disable_triggerContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Names_referencesContext triggers = ctx.names_references();
        Qualified_nameContext parent = ctx.qualified_name();
        if (triggers == null || parent == null) {
            return;
        }

        IdContext schemaCtx = parent.schema;
        IStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                getSchemaSafe(Arrays.asList(schemaCtx, parent.name)), parent.name);
        addObjReference(Arrays.asList(parent.schema, parent.name),
                DbObjType.TABLE, StatementActions.NONE);

        for (Qualified_nameContext qname : triggers.qualified_name()) {
            MsTrigger trig = (MsTrigger) getSafe(IStatementContainer::getTrigger,
                    cont, qname.name);
            addObjReference(Arrays.asList(schemaCtx, parent.name, qname.name),
                    DbObjType.TRIGGER, StatementActions.ALTER);
            if (ctx.DISABLE() != null) {
                doSafe(MsTrigger::setDisable, trig, true);
            }
        }
    }

    @Override
    protected void fillQueryLocation(String fullScript) {
        String query = ParserAbstract.getFullCtxText(ctx);
        db.addToBatch(new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctx.getStart().getLine(), query));
    }
}
