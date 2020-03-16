package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DeleteStatement extends ParserAbstract {

    private final Delete_stmt_for_psqlContext ctx;

    public DeleteStatement(Delete_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(ctx.delete_table_name.identifier(), DbObjType.TABLE, ACTION_DELETE);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(
                new StringBuilder(ACTION_DELETE).append(' ').append("FROM").toString(),
                DbObjType.TABLE, ctx.delete_table_name.identifier());
    }
}
