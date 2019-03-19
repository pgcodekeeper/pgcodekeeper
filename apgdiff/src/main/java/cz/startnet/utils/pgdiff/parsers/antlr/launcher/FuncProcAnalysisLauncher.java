package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identifier_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Sql;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class FuncProcAnalysisLauncher extends AbstractAnalysisLauncher {

    // Contains PgFunction's arguments contexts for analysis (for getting dependencies).
    // Used in case working with project.
    private List<Function_argumentsContext> funcArgsCtxs;

    // Contains pairs, each of which contains the name of the argument and its
    // full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
    // It's need for analysis (for getting dependencies).
    // Used in case working with db.
    private List<Pair<String, GenericColumn>> funcArgs;

    public FuncProcAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        super(stmt, ctx);
    }

    public FuncProcAnalysisLauncher(PgStatementWithSearchPath stmt,
            List<Function_argumentsContext> funcArgsCtxs) {
        super(stmt);
        setFuncArgsCtxs(funcArgsCtxs);
    }

    /**
     * Set function's arguments contexts for processing and analyze.
     *
     * @param ctxs contexts which belongs to stmt
     */
    public void setFuncArgsCtxs(List<Function_argumentsContext> funcArgsCtxs) {
        this.funcArgsCtxs = funcArgsCtxs;
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
            analyzeDefinition((SqlContext) ctx, new Sql(db),
                    (AbstractFunction) stmt);
        }
    }

    private <T extends ParserRuleContext> void analyzeDefinition(T ctx,
            AbstractExprWithNmspc<T> analyzer, AbstractFunction st) {
        List<Pair<String, String>> simpleFuncArgs = new ArrayList<>();
        Map<String, GenericColumn> relFuncArgs = new LinkedHashMap<>();
        if (funcArgs != null) {
            // In this case, the data which was got from db is analyzed.
            fillArgStoresFromArgs(simpleFuncArgs, relFuncArgs);
        } else {
            // In this case, the data which was got from project is analyzed.
            fillArgStoresFromArgsCtxs(simpleFuncArgs, relFuncArgs);
        }
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
     */
    private void fillArgStoresFromArgsCtxs(List<Pair<String, String>> prims,
            Map<String, GenericColumn> rels) {
        if (funcArgsCtxs == null) {
            return;
        }

        for (int i = 0; i < funcArgsCtxs.size(); i++) {
            String argDollarName = "$" + (i + 1);
            Identifier_nontypeContext argNameCtx = funcArgsCtxs.get(i).argname;

            String argName = argNameCtx == null ? null :
                ParserAbstract.getFullCtxText(funcArgsCtxs.get(i).argname);

            Data_typeContext dataTypeCtx = funcArgsCtxs.get(i).data_type();
            Schema_qualified_name_nontypeContext typeQname = dataTypeCtx.predefined_type()
                    .schema_qualified_name_nontype();

            if (typeQname != null) {
                IdentifierContext schemaCtx = typeQname.identifier();
                if (schemaCtx != null) {
                    putArgToStorageForNmsp(prims, rels, db,
                            ParserAbstract.getFullCtxText(schemaCtx),
                            ParserAbstract.getFullCtxText(typeQname.identifier_nontype()),
                            argDollarName, argName);
                }
            } else {
                addArgToPrims(argDollarName, argName,
                        ParserAbstract.getTypeName(dataTypeCtx), prims);
            }
        }
    }

    /**
     * Fill storage of simple-arguments and storage of relation-arguments
     * by function arguments.
     * <br />(These storages will be added to namespaces for correct analysis).
     *
     * @param prims storage for function arguments with simple-types
     * @param rels storage for function arguments with relation-types
     */
    private void fillArgStoresFromArgs(List<Pair<String, String>> prims,
            Map<String, GenericColumn> rels) {
        for (int i = 0; i < funcArgs.size(); i++) {
            Pair<String, GenericColumn> arg = funcArgs.get(i);
            FuncProcAnalysisLauncher.putArgToStorageForNmsp(prims,  rels, db,
                    arg.getSecond().schema, arg.getSecond().table, "$" + (i + 1),
                    arg.getFirst());
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
     */
    public static void putArgToStorageForNmsp(
            List<Pair<String, String>> prims, Map<String, GenericColumn> rels,
            PgDatabase db, String argTypeSchema, String argType, String argDollarName,
            String argName) {
        if (ApgdiffUtils.isPgSystemSchema(argTypeSchema)
                && "record".equalsIgnoreCase(argType)) {
            addArgToRels(argDollarName, argName, argType, argTypeSchema,
                    DbObjType.TABLE, rels);
            return;
        }

        boolean isSystemSchema = ApgdiffUtils.isPgSystemSchema(argTypeSchema);
        ISchema schemaOfType = !isSystemSchema ? db.getSchema(argTypeSchema) : PgSystemStorage
                .getObjectsFromResources(db.getPostgresVersion()).getSchema(argTypeSchema);

        DbObjType argDbObjType = null;
        IRelation rel = schemaOfType.getRelation(argType);
        if (rel != null) {
            argDbObjType = rel.getStatementType();
        } else if (!isSystemSchema) {
            if (((PgSchema) schemaOfType).getType(argType) != null) {
                argDbObjType = DbObjType.TYPE;
            } else if (((PgSchema) schemaOfType).getDomain(argType) != null) {
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
