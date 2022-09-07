package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Plpgsql_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Function;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.SqlFunctionBody;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;
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

    public FuncProcAnalysisLauncher(AbstractPgFunction stmt, Function_bodyContext ctx,
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
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        if (ctx instanceof SqlContext) {
            Sql sql = new Sql(meta);
            declareAnalyzerArgs(sql);
            return analyze((SqlContext) ctx, sql);
        }

        if (ctx instanceof Function_bodyContext) {
            SqlFunctionBody body = new SqlFunctionBody(meta);
            declareAnalyzerArgs(body);
            return analyze((Function_bodyContext) ctx, body);
        }

        Function function = new Function(meta);
        declareAnalyzerArgs(function);
        return analyze((Plpgsql_functionContext) ctx, function);
    }

    private void declareAnalyzerArgs(AbstractExprWithNmspc<? extends ParserRuleContext> analyzer) {
        for (int i = 0; i < funcArgs.size(); i++) {
            Pair<String, GenericColumn> arg = funcArgs.get(i);
            analyzer.declareNamespaceVar("$" + (i + 1), arg.getFirst(), arg.getSecond());
        }
    }

    @Override
    protected EnumSet<DbObjType> getDisabledDepcies() {
        PgDiffArguments args = stmt.getDatabase().getArguments();
        if (!args.isEnableFunctionBodiesDependencies()) {
            return EnumSet.of(DbObjType.FUNCTION, DbObjType.PROCEDURE);
        }

        return super.getDisabledDepcies();
    }
}
