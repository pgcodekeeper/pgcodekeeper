package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class FuncProcAnalysisLauncher extends AbstractAnalysisLauncher {

    // Contains pairs, each of which contains the name of the function argument
    // and its full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
    // It's need for analysis (for getting dependencies).
    private List<Pair<String, GenericColumn>> funcArgs;

    public FuncProcAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    /**
     * Set function arguments for processing and analyze.
     * Each pair contains the name of the argument and its full type name
     * in GenericColumn object (typeSchema, typeName, DbObjType.TYPE)
     *
     * @param funcArgs function arguments which belongs to stmt
     */
    public void setFuncArgs(List<Pair<String, GenericColumn>> funcArgs) {
        this.funcArgs = funcArgs;
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        if (ctx instanceof VexContext) {
            analyze((VexContext) ctx, new ValueExpr(db), stmt);
        } else {
            Sql sql;
            if (db.getArguments().isEnableFunctionBodiesDependencies()) {
                sql = new Sql(db);
            } else {
                sql = new Sql(db, DbObjType.FUNCTION, DbObjType.PROCEDURE);
            }
            analyzeDefinition((SqlContext) ctx, sql, (AbstractFunction) stmt);
        }
    }

    private <T extends ParserRuleContext> void analyzeDefinition(T ctx,
            AbstractExprWithNmspc<T> analyzer, AbstractFunction st) {
        List<Pair<String, String>> simpleFuncArgs = new ArrayList<>();
        Map<String, GenericColumn> relFuncArgs = new LinkedHashMap<>();
        fillArgStoresFromArgs(simpleFuncArgs, relFuncArgs, analyzer);
        analyzer.addArgsToNmsps(simpleFuncArgs, relFuncArgs);
        analyzer.analyze(ctx);
        st.addAllDeps(analyzer.getDepcies());
    }

    /**
     * Fill storage of simple-arguments and storage of relation-arguments
     * by function arguments.
     * <br />(These storages will be added to namespaces for correct analysis).
     *
     * @param prims storage for function arguments with simple-types
     * @param rels storage for function arguments with relation-types
     * @param analyzer analyzer is used here to search relations
     */
    private <T extends ParserRuleContext> void fillArgStoresFromArgs(
            List<Pair<String, String>> prims, Map<String, GenericColumn> rels,
            AbstractExprWithNmspc<T> analyzer) {
        for (int i = 0; i < funcArgs.size(); i++) {
            Pair<String, GenericColumn> arg = funcArgs.get(i);
            FuncProcAnalysisLauncher.putArgToStorageForNmsp(prims,  rels, db,
                    arg.getSecond().schema, arg.getSecond().table, "$" + (i + 1),
                    arg.getFirst(), analyzer);
        }
    }

    /**
     * Put the function argument with a qualified type, depending on the
     * conditions, either in the storage of simple arguments, or in the storage
     * with relation arguments.
     * <br />(These storages will be added to namespaces for correct analysis).
     *
     * @param prims storage for function arguments with simple-types
     * @param rels storage for function arguments with relation-types
     * @param db database statement
     * @param argTypeSchema schema name to which the argument type belongs
     * @param argType type of argument
     * @param argDollarName dollar name of argument
     * @param argName argument name
     * @param analyzer analyzer is used here to search relations
     */
    public static <T extends ParserRuleContext> void putArgToStorageForNmsp(
            List<Pair<String, String>> prims, Map<String, GenericColumn> rels,
            PgDatabase db, String argTypeSchema, String argType, String argDollarName,
            String argName, AbstractExprWithNmspc<T> analyzer) {
        if (ApgdiffUtils.isPgSystemSchema(argTypeSchema)
                && "record".equalsIgnoreCase(argType)) {
            addArgToRels(argDollarName, argName, argType, argTypeSchema,
                    DbObjType.TABLE, rels);
            return;
        }

        DbObjType argDbObjType = null;
        IRelation rel = analyzer.findRelations(argTypeSchema, argType).findAny().orElse(null);
        if (rel != null) {
            argDbObjType = rel.getStatementType();
        } else if (!ApgdiffUtils.isPgSystemSchema(argTypeSchema)) {
            PgSchema schemaOfType = (PgSchema) db.getSchema(argTypeSchema);
            if (schemaOfType.getType(argType) != null) {
                argDbObjType = DbObjType.TYPE;
            } else if (schemaOfType.getDomain(argType) != null) {
                argDbObjType = DbObjType.DOMAIN;
            }
        }

        if (argDbObjType == null) {
            addArgToPrims(argDollarName, argName, argType, prims);
        } else {
            addArgToRels(argDollarName, argName, argType, argTypeSchema,
                    argDbObjType, rels);
        }
    }

    private static void addArgToPrims(String argDollarName, String argName, String argType,
            List<Pair<String, String>> prims) {
        prims.add(new Pair<>(argDollarName, argType));
        if (argName != null) {
            prims.add(new Pair<>(argName, argType));
        }
    }

    private static void addArgToRels(String argDollarName, String argName, String argTypeAndObjName,
            String schemaName, DbObjType argDbObjType, Map<String, GenericColumn> rels) {
        rels.put(argDollarName,
                new GenericColumn(schemaName, argTypeAndObjName, argDbObjType));
        if (argName != null) {
            rels.put(argName,
                    new GenericColumn(schemaName, argTypeAndObjName, argDbObjType));
        }
    }
}
