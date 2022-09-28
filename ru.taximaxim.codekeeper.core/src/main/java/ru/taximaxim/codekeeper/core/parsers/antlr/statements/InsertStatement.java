package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class InsertStatement extends ParserAbstract {

    private final Insert_stmt_for_psqlContext ctx;

    public InsertStatement(Insert_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(getIdentifiers(ctx.insert_table_name), DbObjType.TABLE, ACTION_INSERT);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_INSERT + " INTO", DbObjType.TABLE, getIdentifiers(ctx.insert_table_name));
    }
}
