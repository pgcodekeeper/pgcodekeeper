package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class DeleteStatement extends ParserAbstract {

    private final Delete_stmt_for_psqlContext ctx;

    public DeleteStatement(Delete_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(getIdentifiers(ctx.delete_table_name), DbObjType.TABLE, ACTION_DELETE);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_DELETE + " FROM", DbObjType.TABLE, getIdentifiers(ctx.delete_table_name));
    }
}
