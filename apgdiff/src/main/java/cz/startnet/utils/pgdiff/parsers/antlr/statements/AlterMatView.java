package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_materialized_view_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMatView extends ParserAbstract {

    private final Alter_materialized_view_statementContext ctx;
    private final String action;

    public AlterMatView(Alter_materialized_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        this.action = ctx.ALL() != null ? "ALTER MATERIALIZED VIEW ALL" : "ALTER MATERIALIZED";
    }

    @Override
    public void parseObject() {
        if (ctx.ALL() == null) {
            List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
            addObjReference(ids, DbObjType.VIEW, action);
        } else {
            db.addReference(fileName, new PgObjLocation.Builder()
                    .setAction(action).setCtx(ctx.getParent()).build());
        }
    }

    @Override
    protected String getStmtAction() {
        if (ctx.ALL() != null) {
            return action;
        }
        return getStrForStmtAction(action, DbObjType.VIEW,
                ctx.schema_qualified_name().identifier());
    }
}