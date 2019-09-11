package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
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

    @Override
    public void analyze(ParserRuleContext ctx) {
        PgDatabase db = stmt.getDatabase();
        if (ctx instanceof VexContext) {
            analyze((VexContext) ctx, new ValueExpr(db));
        } else {
            Sql sql;
            if (db.getArguments().isEnableFunctionBodiesDependencies()) {
                sql = new Sql(db);
            } else {
                sql = new Sql(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
            }
            for (int i = 0; i < funcArgs.size(); i++) {
                Pair<String, GenericColumn> arg = funcArgs.get(i);
                addArgToNmspc("$" + (i + 1), arg.getFirst(), arg.getSecond(), sql);
            }
            analyze((SqlContext) ctx, sql);
        }
    }

    private void addArgToNmspc(String argDollarName, String argName, GenericColumn argType,
            AbstractExprWithNmspc<?> analyzer) {
        if (ApgdiffConsts.PG_CATALOG.equals(argType.schema)
                && ApgdiffConsts.SYS_TYPES.contains(argType.table.toLowerCase(Locale.ROOT))) {
            addArgToPrims(argDollarName, argName, argType.table, analyzer);
            return;
        }

        IRelation rel = analyzer.findRelations(argType.schema, argType.table)
                .findAny().orElse(null);
        if (rel != null) {
            GenericColumn ref = new GenericColumn(rel.getSchemaName(), rel.getName(), rel.getStatementType());
            analyzer.addReference(argDollarName, ref);
            if (argName != null) {
                analyzer.addReference(argName, ref);
            }
        } else {
            // treat all non-relations (custom types etc) as primitives for now
            // this is in line with current behavior when, e.g., selecting from tables
            // (the composite type's qualified name will be taken as is)
            addArgToPrims(argDollarName, argName, argType.getQualifiedName(), analyzer);
        }
    }

    private static void addArgToPrims(String argDollarName, String argName, String argType,
            AbstractExprWithNmspc<?> analyzer) {
        analyzer.addNamespaceVariable(new Pair<>(argDollarName, argType));
        if (argName != null) {
            analyzer.addNamespaceVariable(new Pair<>(argName, argType));
        }
    }
}
