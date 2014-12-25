package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class AlterView extends ParserAbstract {
private Alter_view_statementContext ctx;
    public AlterView(Alter_view_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx=ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgView view = new PgView(name, null, db.getDefSearchPath());
        PgView dbView = db.getSchema(schemaName).getView(name);
        if (ctx.owner_to() != null) {
            view.setOwner(removeQuotes(ctx.owner_to().name));
            if (dbView != null) {
                dbView.setOwner(removeQuotes(ctx.owner_to().name));
            }
        }
        if (ctx.set_def_column() != null) {
            view.addColumnDefaultValue(getFullCtxText(ctx.column_name), getFullCtxText(ctx.set_def_column().expression));
            if (dbView != null) {
                dbView.addColumnDefaultValue(getFullCtxText(ctx.column_name), getFullCtxText(ctx.set_def_column().expression));
            }
        }
        if(ctx.drop_def() != null) {
            view.removeColumnDefaultValue(getFullCtxText(ctx.column_name));
            if (dbView != null) {
                dbView.removeColumnDefaultValue(getFullCtxText(ctx.column_name));
            }
        }
        if (dbView != null) {
            return null;
        }
        return view;
    }

}
