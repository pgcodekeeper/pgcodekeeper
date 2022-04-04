package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;

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
