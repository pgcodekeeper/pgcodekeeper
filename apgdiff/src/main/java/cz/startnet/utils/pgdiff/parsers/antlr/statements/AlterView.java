package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class AlterView extends ParserAbstract {
    private final Alter_view_statementContext ctx;

    public AlterView(Alter_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgView dbView = db.getSchema(schemaName).getView(name);
        if (dbView == null) {
            logError("VIEW", name);
            return null;
        }
        fillOwnerTo(ctx.owner_to(), dbView);
        if (ctx.set_def_column() != null) {
            dbView.addColumnDefaultValue(getFullCtxText(ctx.column_name),
                    getFullCtxText(ctx.set_def_column().expression));
        }
        if (ctx.drop_def() != null) {
            dbView.removeColumnDefaultValue(getFullCtxText(ctx.column_name));
        }
        return null;
    }

}
