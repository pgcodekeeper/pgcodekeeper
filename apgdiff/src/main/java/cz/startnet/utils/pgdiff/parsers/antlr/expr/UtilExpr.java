package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class UtilExpr {

    //TODO Надо все завернуть в дженерик и будет счастье, наверное

    public static void createSelect(Select_stmtContext selectCtx, String schemaName, PgStatement v) {
        Select selectAnalyzer = new Select(schemaName);
        selectAnalyzer.select(new SelectStmt(selectCtx));

        for (GenericColumn col : selectAnalyzer.getDepcies()) {
            v.addDep(col);
        }
    }

    //public static void createInsert(Insert_stmt_for_psqlContext insertCtx, String schemaName, PgStatement pg) {
    public static void createInsert(ParserRuleContext insertCtx, String schemaName, PgStatement pg) {
        Insert insertAnalizer = new Insert(schemaName);
        insertAnalizer.insert((Insert_stmt_for_psqlContext) insertCtx);

        for (GenericColumn col : insertAnalizer.getDepcies()) {
            pg.addDep(col);
        }
    }

    public static void createDelete(Delete_stmt_for_psqlContext deleteCtx, String schemaName, PgStatement pg) {
        Delete deleteAnalizer = new Delete(schemaName);
        deleteAnalizer.delete(deleteCtx);
        for (GenericColumn col : deleteAnalizer.getDepcies()) {
            pg.addDep(col);
        }
    }

    public static void createUpdate(Update_stmt_for_psqlContext updateCtx, String schemaName, PgStatement pg) {
        Update updateAnalizer = new Update(schemaName);
        updateAnalizer.update(updateCtx);

        for (GenericColumn col : updateAnalizer.getDepcies()) {
            pg.addDep(col);
        }
    }

}
