package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_returnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;

public class SqlFunctionBody extends Statements<Function_bodyContext> {

    protected SqlFunctionBody(AbstractExpr parent) {
        super(parent);
    }

    public SqlFunctionBody(MetaContainer meta) {
        super(meta);
    }

    @Override
    protected List<StatementContext> getStatements(Function_bodyContext ctx) {
        return ctx.statement();
    }

    @Override
    public List<ModPair<String, String>> analyze(Function_bodyContext ctx) {
        super.analyze(ctx);
        for (Function_returnContext ret : ctx.function_return()) {
            new ValueExpr(this).analyze(new Vex(ret.vex()));
        }

        return Collections.emptyList();
    }
}
