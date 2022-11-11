package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class MergeStatement extends ParserAbstract {

    private final Merge_stmt_for_psqlContext ctx;

    public MergeStatement(Merge_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(getIdentifiers(ctx.merge_table_name), DbObjType.TABLE, ACTION_MERGE);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_MERGE + " INTO", DbObjType.TABLE, getIdentifiers(ctx.merge_table_name));
    }
}
