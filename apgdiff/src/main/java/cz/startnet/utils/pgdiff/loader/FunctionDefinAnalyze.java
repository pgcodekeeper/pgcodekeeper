package cz.startnet.utils.pgdiff.loader;

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
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class FunctionDefinAnalyze {

    protected static void funcDefinAnalyze(SqlContext funcDefSqlCtx, String rootFuncSchema,
            PgStatementWithSearchPath rootFunc, PgDatabase db) {
        for (StatementContext s : funcDefSqlCtx.statement()) {
            Data_statementContext ds = s.data_statement();
            if (ds != null) {
                Select_stmtContext selCtx = ds.select_stmt();
                Insert_stmt_for_psqlContext insCtx;
                Update_stmt_for_psqlContext updCtx;
                Delete_stmt_for_psqlContext delCtx;
                if (selCtx != null) {
                    UtilAnalyzeExpr.analyze(selCtx, new Select(rootFuncSchema, db), rootFunc);
                } else if ((insCtx = ds.insert_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyze(insCtx, new Insert(rootFuncSchema, db), rootFunc);
                } else if ((updCtx = ds.update_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyze(updCtx, new Update(rootFuncSchema, db), rootFunc);
                } else if ((delCtx = ds.delete_stmt_for_psql()) != null) {
                    UtilAnalyzeExpr.analyze(delCtx, new Delete(rootFuncSchema, db), rootFunc);
                }
            }
            // TODO add processing for elements of 's.schema_statement()'
        }
    }

    private FunctionDefinAnalyze() {
    }
}
