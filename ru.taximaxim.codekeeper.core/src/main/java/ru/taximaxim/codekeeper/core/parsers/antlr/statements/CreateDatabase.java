package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_database_statementContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateDatabase extends ParserAbstract {

    private final Create_database_statementContext ctx;

    public CreateDatabase(Create_database_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_CREATE);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DATABASE, Arrays.asList(ctx.identifier()));
    }
}