package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.StatementActions;

public class AlterView extends ParserAbstract {
    private Alter_view_statementContext ctx;

    public AlterView(Alter_view_statementContext ctx, PgDatabase db,
            Path filePath) {
        super(db, filePath);
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
        if (ctx.owner_to() != null) {
            dbView.setOwner(removeQuotes(ctx.owner_to().name));
        }
        if (ctx.set_def_column() != null) {
            dbView.addColumnDefaultValue(getFullCtxText(ctx.column_name),
                    getFullCtxText(ctx.set_def_column().expression));
        }
        if (ctx.drop_def() != null) {
            dbView.removeColumnDefaultValue(getFullCtxText(ctx.column_name));
        }
        addObjReference(schemaName, name, DbObjType.VIEW,
                StatementActions.ALTER, ctx.name.getStart().getStartIndex(), 0);
        return null;
    }

}
