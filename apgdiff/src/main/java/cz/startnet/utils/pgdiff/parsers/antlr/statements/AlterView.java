package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterView extends ParserAbstract {

    private final Alter_view_statementContext ctx;

    public AlterView(Alter_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgView dbView = (PgView) getSafe(AbstractSchema::getView,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));
        if (ctx.set_def_column() != null) {
            VexContext exp = ctx.set_def_column().vex();
            doSafe((s,o) -> {
                s.addColumnDefaultValue(getFullCtxText(ctx.column_name), getFullCtxText(exp));
                db.addAnalysisLauncher(new ViewAnalysisLauncher(s, exp));
            }, dbView, null);
        }
        if (ctx.drop_def() != null) {
            doSafe(PgView::removeColumnDefaultValue, dbView, getFullCtxText(ctx.column_name));
        }

        addObjReference(ids, DbObjType.VIEW, StatementActions.ALTER);
    }
}