package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
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
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgView dbView = getSafe(schema::getView, QNameParser.getFirstNameCtx(ids));
        fillOwnerTo(ctx.owner_to(), dbView);
        if (ctx.set_def_column() != null) {
            VexContext exp = ctx.set_def_column().expression;
            dbView.addColumnDefaultValue(getFullCtxText(ctx.column_name), getFullCtxText(exp));
            db.addContextForAnalyze(dbView, exp);
        }
        if (ctx.drop_def() != null) {
            dbView.removeColumnDefaultValue(getFullCtxText(ctx.column_name));
        }
        return null;
    }
}