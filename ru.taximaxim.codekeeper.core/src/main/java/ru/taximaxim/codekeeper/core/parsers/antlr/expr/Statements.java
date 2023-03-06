package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Data_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public abstract class Statements<T extends ParserRuleContext> extends AbstractExprWithNmspc<T> {

    protected Statements(AbstractExpr parent) {
        super(parent);
    }

    protected Statements(MetaContainer meta) {
        super(meta);
    }

    protected abstract List<StatementContext> getStatements(T ctx);

    @Override
    public List<ModPair<String, String>> analyze(T ctx) {
        for (StatementContext st : getStatements(ctx)) {
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
        Merge_stmt_for_psqlContext merCtx;
        Delete_stmt_for_psqlContext delCtx;
        if (selCtx != null) {
            new Select(this).analyze(selCtx);
        } else if ((insCtx = data.insert_stmt_for_psql()) != null) {
            new Insert(this).analyze(insCtx);
        } else if ((updCtx = data.update_stmt_for_psql()) != null) {
            new Update(this).analyze(updCtx);
        } else if ((merCtx = data.merge_stmt_for_psql()) != null) {
            new Merge(this).analyze(merCtx);
        } else if ((delCtx = data.delete_stmt_for_psql()) != null) {
            new Delete(this).analyze(delCtx);
        }
    }
}
