package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Plpgsql_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Function;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class FuncProcAnalysisLauncher extends AbstractAnalysisLauncher {

    /**
     * Contains pairs, each of which contains the name of the function argument
     * and its full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
     * Used to set up namespace for function body analysis.
     */
    private final List<Pair<String, GenericColumn>> funcArgs;

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, SqlContext ctx,
            String location, List<Pair<String, GenericColumn>> funcArgs) {
        super(stmt, ctx, location);
        this.funcArgs = funcArgs;
    }

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, Plpgsql_functionContext ctx,
            String location, List<Pair<String, GenericColumn>> funcArgs) {
        super(stmt, ctx, location);
        this.funcArgs = funcArgs;
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        PgDiffArguments args = stmt.getDatabase().getArguments();

        if (ctx instanceof SqlContext) {
            Sql sql;
            if (args.isEnableFunctionBodiesDependencies()) {
                sql = new Sql(db);
            } else {
                sql = new Sql(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
            }
            for (int i = 0; i < funcArgs.size(); i++) {
                Pair<String, GenericColumn> arg = funcArgs.get(i);
                sql.declareNamespaceVar("$" + (i + 1), arg.getFirst(), arg.getSecond());
            }
            return analyze((SqlContext) ctx, sql);
        }

        Function function;
        if (args.isEnableFunctionBodiesDependencies()) {
            function = new Function(db);
        } else {
            function = new Function(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
        }

        for (int i = 0; i < funcArgs.size(); i++) {
            Pair<String, GenericColumn> arg = funcArgs.get(i);
            function.declareNamespaceVar("$" + (i + 1), arg.getFirst(), arg.getSecond());
        }

        return analyze((Plpgsql_functionContext) ctx, function);
    }
}
