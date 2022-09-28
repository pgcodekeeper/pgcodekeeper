package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Insert_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public class Insert extends AbstractExprWithNmspc<Insert_stmt_for_psqlContext> {

    protected Insert(AbstractExpr parent) {
        super(parent);
    }

    public Insert(MetaContainer meta) {
        super(meta);
    }

    @Override
    public List<ModPair<String, String>> analyze(Insert_stmt_for_psqlContext insert) {
        // this select is used to collect namespaces for this INSERT operation
        Select select = new Select(this);
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            select.analyzeCte(with);
        }

        select.addNameReference(insert.insert_table_name, null, null);

        Insert_columnsContext columns = insert.insert_columns();
        if (columns != null) {
            select.addColumnsDepcies(insert.insert_table_name, columns.indirection_identifier());
        }

        Select_stmtContext selectCtx = insert.select_stmt();
        if (selectCtx != null) {
            new Select(select).analyze(selectCtx);
        }

        if (insert.RETURNING() != null) {
            return select.sublist(insert.select_list().select_sublist(), new ValueExpr(select));
        }

        return Collections.emptyList();
    }
}
