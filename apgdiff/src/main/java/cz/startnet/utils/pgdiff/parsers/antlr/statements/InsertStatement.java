package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class InsertStatement extends ParserAbstract {

    private final Insert_stmt_for_psqlContext ctx;

    public InsertStatement(Insert_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(ctx.insert_table_name.identifier(), DbObjType.TABLE, ACTION_INSERT);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(
                new StringBuilder(ACTION_INSERT).append(' ').append("INTO").toString(),
                DbObjType.TABLE, ctx.insert_table_name.identifier());
    }
}
