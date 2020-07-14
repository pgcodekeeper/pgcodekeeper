package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;
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
        Alter_view_actionContext action = ctx.alter_view_action();
        if (action.set_def_column() != null) {
            VexContext exp = action.set_def_column().vex();
            doSafe((s,o) -> {
                s.addColumnDefaultValue(getFullCtxText(action.column_name), getFullCtxText(exp));
                db.addAnalysisLauncher(new VexAnalysisLauncher(s, exp, fileName));
            }, dbView, null);
        }
        if (action.drop_def() != null) {
            doSafe(PgView::removeColumnDefaultValue, dbView, getFullCtxText(action.column_name));
        }

        addObjReference(ids, DbObjType.VIEW, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.VIEW, ctx.name.identifier());
    }
}