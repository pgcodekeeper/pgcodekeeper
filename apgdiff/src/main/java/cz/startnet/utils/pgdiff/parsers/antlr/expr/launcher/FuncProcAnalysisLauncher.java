package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Plpgsql_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Function;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class FuncProcAnalysisLauncher extends AbstractAnalysisLauncher {

    /**
     * Contains pairs, each of which contains the name of the function argument
     * and its full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
     * Used to set up namespace for function body analysis.
     */
    private final List<Pair<String, GenericColumn>> funcArgs;

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, VexContext ctx) {
        super(stmt, ctx);
        funcArgs = null;
    }

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, SqlContext ctx,
            List<Pair<String, GenericColumn>> funcArgs) {
        super(stmt, ctx);
        this.funcArgs = funcArgs;
    }

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, Plpgsql_functionContext ctx,
            List<Pair<String, GenericColumn>> funcArgs) {
        super(stmt, ctx);
        this.funcArgs = funcArgs;
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        PgDatabase db = stmt.getDatabase();
        if (ctx instanceof VexContext) {
            analyze((VexContext) ctx, new ValueExpr(db));
        } else if (ctx instanceof SqlContext) {
            Sql sql;
            if (db.getArguments().isEnableFunctionBodiesDependencies()) {
                sql = new Sql(db);
            } else {
                sql = new Sql(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
            }
            for (int i = 0; i < funcArgs.size(); i++) {
                Pair<String, GenericColumn> arg = funcArgs.get(i);
                sql.declareNamespaceVar("$" + (i + 1), arg.getFirst(), arg.getSecond());
            }
            analyze((SqlContext) ctx, sql);
        } else if (ctx instanceof Plpgsql_functionContext) {
            Function function;
            if (db.getArguments().isEnableFunctionBodiesDependencies()) {
                function = new Function(db);
            } else {
                function = new Function(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
            }
            for (int i = 0; i < funcArgs.size(); i++) {
                Pair<String, GenericColumn> arg = funcArgs.get(i);
                function.declareNamespaceVar("$" + (i + 1), arg.getFirst(), arg.getSecond());
            }
            analyze((Plpgsql_functionContext) ctx, function);
        }
    }
}
