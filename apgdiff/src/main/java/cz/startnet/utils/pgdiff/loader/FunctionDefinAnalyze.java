package cz.startnet.utils.pgdiff.loader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identifier_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class FunctionDefinAnalyze {

    public static final String FUNC_ARGS_KEY = "_SPECIAL_CONTAINER_FOR_FUNCTION_ARGUMENTS";

    protected static void funcDefinAnalyze(SqlContext funcDefSqlCtx, String rootFuncSchema,
            PgStatementWithSearchPath rootFunc, PgDatabase db) {
        Map<String, List<Pair<String, String>>> simpleFuncArgs = new LinkedHashMap<>();
        simpleFuncArgs.put(FUNC_ARGS_KEY, new ArrayList<>());
        Map<String, GenericColumn> relFuncArgs = new LinkedHashMap<>();
        splitFuncArgs(db, rootFunc, relFuncArgs, simpleFuncArgs);

        for (StatementContext s : funcDefSqlCtx.statement()) {
            Data_statementContext ds = s.data_statement();
            if (ds != null) {
                Select_stmtContext selCtx = ds.select_stmt();
                Insert_stmt_for_psqlContext insCtx;
                Update_stmt_for_psqlContext updCtx;
                Delete_stmt_for_psqlContext delCtx;
                if (selCtx != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(selCtx, new Select(rootFuncSchema, db),
                            rootFunc, relFuncArgs, simpleFuncArgs);
                } else if ((insCtx = ds.insert_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(insCtx, new Insert(rootFuncSchema, db),
                            rootFunc, relFuncArgs, simpleFuncArgs);
                } else if ((updCtx = ds.update_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(updCtx, new Update(rootFuncSchema, db),
                            rootFunc, relFuncArgs, simpleFuncArgs);
                } else if ((delCtx = ds.delete_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(delCtx, new Delete(rootFuncSchema, db),
                            rootFunc, relFuncArgs, simpleFuncArgs);
                }
            }
            // TODO add processing for elements of 's.schema_statement()'
        }
    }

    /**
     * Splits function arguments into simple arguments and arguments with relations.
     */
    private static void splitFuncArgs(PgDatabase db, PgStatementWithSearchPath rootFunc,
            Map<String, GenericColumn> relFuncArgs,
            Map<String, List<Pair<String, String>>> simpleFuncArgs) {
        Entry<PgStatementWithSearchPath, List<Function_argumentsContext>> funcArgs = db
                .getFuncArgsCtxsForAnalyze().stream().filter(e -> rootFunc.equals(e.getKey()))
                .findAny().orElse(null);

        List<Function_argumentsContext> argCtxs = funcArgs.getValue();
        for (int i = 0; i < argCtxs.size(); i++) {
            String argDollarName = "$" + (i + 1);
            Identifier_nontypeContext argNameCtx = argCtxs.get(i).argname;

            // TODO if (argName != null) need to put this with argDollarName
            String argName = argNameCtx == null ? null :
                ParserAbstract.getFullCtxText(argCtxs.get(i).argname);


            Data_typeContext dataTypeCtx = argCtxs.get(i).data_type();
            Schema_qualified_name_nontypeContext typeQname = dataTypeCtx.predefined_type()
                    .schema_qualified_name_nontype();

            if (typeQname != null) {
                IdentifierContext schemaCtx = typeQname.identifier();

                String schemaName = rootFunc.getContainingSchema().getName();
                if (schemaCtx != null) {
                    schemaName = ParserAbstract.getFullCtxText(schemaCtx);
                    String typeNameOfObj = ParserAbstract.getFullCtxText(typeQname.identifier_nontype());
                    DbObjType objGenericType = DbObjType.TYPE;
                    if ("pg_catalog".equals(schemaName)
                            || "information_schema".equals(schemaName)) {
                        // put result to the 'simpleFuncArgs'
                        simpleFuncArgs.get(FUNC_ARGS_KEY).add(new Pair<>(argDollarName,
                                typeNameOfObj));
                    } else {
                        // check if it is TABLE OR VIEW OR TYPE then put it to the 'relFuncArgs'

                        AbstractSchema schema = db.getSchema(schemaName);

                        boolean isRelArg = false;
                        if (schema.getTable(typeNameOfObj) != null) {
                            isRelArg = true;
                            objGenericType = DbObjType.TABLE;
                        } else if (schema.getView(typeNameOfObj) != null) {
                            isRelArg = true;
                            objGenericType = DbObjType.VIEW;
                        } else if(schema.getType(typeNameOfObj) != null) {
                            isRelArg = true;
                        }
                        if (isRelArg) {
                            relFuncArgs.put(argDollarName,
                                    new GenericColumn(schemaName, typeNameOfObj, objGenericType));
                            continue;
                        }

                        // else put it to the 'simpleFuncArgs'
                        simpleFuncArgs.get(FUNC_ARGS_KEY).add(new Pair<>(argDollarName,
                                typeNameOfObj));
                    }
                    continue;
                }
            } else {
                // put it to the 'simpleFuncArgs'
                simpleFuncArgs.get(FUNC_ARGS_KEY).add(new Pair<>(argDollarName,
                        ParserAbstract.getFullCtxText(dataTypeCtx)));
            }
        }
    }

    private FunctionDefinAnalyze() {
    }
}
