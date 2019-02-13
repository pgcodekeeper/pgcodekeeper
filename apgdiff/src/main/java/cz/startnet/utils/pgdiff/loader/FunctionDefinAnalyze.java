package cz.startnet.utils.pgdiff.loader;

import java.util.List;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class FunctionDefinAnalyze {

    protected static void funcDefinAnalyze(SqlContext funcDefSqlCtx, String rootFuncSchema,
            PgStatementWithSearchPath rootFunc, PgDatabase db) {
        List<String> funcParams = ((IFunction) rootFunc).getArguments()
                .stream().map(Argument::getDataType).collect(Collectors.toList());
        for (StatementContext s : funcDefSqlCtx.statement()) {
            Data_statementContext ds = s.data_statement();
            if (ds != null) {
                Select_stmtContext selCtx = ds.select_stmt();
                Insert_stmt_for_psqlContext insCtx;
                Update_stmt_for_psqlContext updCtx;
                Delete_stmt_for_psqlContext delCtx;
                if (selCtx != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(selCtx, new Select(rootFuncSchema, db),
                            rootFunc, funcParams);
                } else if ((insCtx = ds.insert_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(insCtx, new Insert(rootFuncSchema, db),
                            rootFunc, funcParams);
                } else if ((updCtx = ds.update_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(updCtx, new Update(rootFuncSchema, db),
                            rootFunc, funcParams);
                } else if ((delCtx = ds.delete_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyzeFuncDefin(delCtx, new Delete(rootFuncSchema, db),
                            rootFunc, funcParams);
                }
            }
            // TODO add processing for elements of 's.schema_statement()'
        }
    }

    private FunctionDefinAnalyze() {
    }
}
