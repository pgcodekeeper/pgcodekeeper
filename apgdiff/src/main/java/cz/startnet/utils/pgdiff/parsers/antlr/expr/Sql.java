package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;

public class Sql extends AbstractExprWithNmspc<SqlContext> {

    protected Sql(AbstractExpr parent) {
        super(parent);
    }

    public Sql(PgDatabase db, DbObjType... disabledDepcies) {
        super(db, disabledDepcies);
    }

    @Override
    public List<ModPair<String, String>> analyze(SqlContext sql) {
        for (StatementContext st : sql.statement()) {
            Data_statementContext data = st.data_statement();
            if (data != null) {
                data(data);
            }
        }

        return Collections.emptyList();
    }

    public void data(Data_statementContext data) {
        Select_stmtContext selCtx = data.select_stmt();
        Insert_stmt_for_psqlContext insCtx;
        Update_stmt_for_psqlContext updCtx;
        Delete_stmt_for_psqlContext delCtx;
        if (selCtx != null) {
            new Select(this).analyze(selCtx);
        } else if ((insCtx = data.insert_stmt_for_psql()) != null) {
            new Insert(this).analyze(insCtx);
        } else if ((updCtx = data.update_stmt_for_psql()) != null) {
            new Update(this).analyze(updCtx);
        } else if ((delCtx = data.delete_stmt_for_psql()) != null) {
            new Delete(this).analyze(delCtx);
        }
    }
}
