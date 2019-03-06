package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
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
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class FuncProcAnalysisLauncher extends AbstractAnalysisLauncher {

    // Contains PgFunction's arguments contexts for analysis (for getting dependencies).
    private final List<Function_argumentsContext> funcArgsCtxsForAnalyze = new ArrayList<>();

    public FuncProcAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    /**
     * Add function's arguments contexts for analyze.
     *
     * @param ctxs contexts which belongs to stmt
     */
    public void addFuncArgsCtxsForAnalyze(List<Function_argumentsContext> ctxs) {
        funcArgsCtxsForAnalyze.addAll(ctxs);
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
        splitFuncArgs(db, st, relFuncArgs, simpleFuncArgs);
        analyzer.addFuncArgsToNmsp(relFuncArgs, simpleFuncArgs);

        analyzer.analyze(ctx);
        st.addAllDeps(analyzer.getDepcies());
    }

    /**
     * Splits function arguments into simple arguments and arguments with relations.
     */
    private void splitFuncArgs(PgDatabase db, AbstractFunction func,
            Map<String, GenericColumn> rels, List<Pair<String, String>> prims) {
        Entry<PgStatementWithSearchPath, List<Function_argumentsContext>> funcArgs = db
                .getFuncArgsCtxsForAnalyze().stream().filter(e -> func.equals(e.getKey()))
                .findAny().orElse(null);

        if (funcArgs == null) {
            return;
        }

        List<Function_argumentsContext> argCtxs = funcArgs.getValue();
        for (int i = 0; i < argCtxs.size(); i++) {
            String argDollarName = "$" + (i + 1);
            Identifier_nontypeContext argNameCtx = argCtxs.get(i).argname;

            String argName = argNameCtx == null ? null :
                ParserAbstract.getFullCtxText(argCtxs.get(i).argname);

            Data_typeContext dataTypeCtx = argCtxs.get(i).data_type();
            Schema_qualified_name_nontypeContext typeQname = dataTypeCtx.predefined_type()
                    .schema_qualified_name_nontype();

            if (typeQname != null) {
                IdentifierContext schemaCtx = typeQname.identifier();
                if (schemaCtx != null) {
                    String schemaName = ParserAbstract.getFullCtxText(schemaCtx);
                    String argType = ParserAbstract.getFullCtxText(typeQname.identifier_nontype());

                    DbObjType argDbObjType = null;
                    AbstractSchema schema = db.getSchema(schemaName);
                    IRelation rel = schema.getRelation(argType);
                    if (rel != null) {
                        argDbObjType = rel.getStatementType();
                    } else if (schema.getType(argType) != null) {
                        argDbObjType = DbObjType.TYPE;
                    } else if (schema.getDomain(argType) != null) {
                        argDbObjType = DbObjType.DOMAIN;
                    }

                    if (argDbObjType == null) {
                        addArgToPrims(argDollarName, argName, argType, prims);
                    } else {
                        addArgToRels(argDollarName, argName, argType, schemaName,
                                argDbObjType, rels);
                    }
                }
            } else {
                addArgToPrims(argDollarName, argName,
                        ParserAbstract.getTypeName(dataTypeCtx), prims);
            }
        }
    }

    private void addArgToPrims(String argDollarName, String argName, String argType,
            List<Pair<String, String>> prims) {
        prims.add(new Pair<>(argDollarName, argType));
        if (argName != null) {
            prims.add(new Pair<>(argName, argType));
        }
    }

    private void addArgToRels(String argDollarName, String argName, String argTypeAndObjName,
            String schemaName, DbObjType argDbObjType, Map<String, GenericColumn> rels) {
        rels.put(argDollarName,
                new GenericColumn(schemaName, argTypeAndObjName, argDbObjType));
        if (argName != null) {
            rels.put(argName,
                    new GenericColumn(schemaName, argTypeAndObjName, argDbObjType));
        }
    }
}
