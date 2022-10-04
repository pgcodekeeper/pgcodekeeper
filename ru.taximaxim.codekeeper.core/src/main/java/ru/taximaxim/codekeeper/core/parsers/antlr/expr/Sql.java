package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class Sql extends Statements<SqlContext> {

    protected Sql(AbstractExpr parent) {
        super(parent);
    }

    public Sql(MetaContainer meta) {
        super(meta);
    }

    @Override
    protected List<StatementContext> getStatements(SqlContext ctx) {
        return ctx.statement();
    }
}
