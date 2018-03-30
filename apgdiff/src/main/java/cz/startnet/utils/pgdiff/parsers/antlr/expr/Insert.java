package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class Insert extends AbstractExprWithNmspc<Insert_stmt_for_psqlContext> {

    protected Insert(AbstractExpr parent) {
        super(parent);
    }

    public Insert(String schema, PgDatabase db) {
        super(schema, db);
    }

    @Override
    public List<Pair<String, String>> analyze(Insert_stmt_for_psqlContext insert) {
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            analyzeCte(with);
        }

        addNameReference(insert.insert_table_name, null, null);
        if (insert.LEFT_PAREN() != null && insert.RIGHT_PAREN() != null) {
            addColumnsDepcies(insert.insert_table_name, insert.column);
        }

        Select_stmtContext select_ctx = insert.select_stmt();
        if (select_ctx != null) {
            new Select(this).analyze(select_ctx);
        }

        return Collections.emptyList();
    }
}
