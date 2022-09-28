package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public class Delete extends AbstractExprWithNmspc<Delete_stmt_for_psqlContext> {

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(MetaContainer meta) {
        super(meta);
    }

    @Override
    public List<ModPair<String, String>> analyze(Delete_stmt_for_psqlContext delete) {
        // this select is used to collect namespaces for this DELETE operation
        Select select = new Select(this);
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            select.analyzeCte(with);
        }

        select.addNameReference(delete.delete_table_name, delete.alias, null);
        if (delete.USING() != null) {
            select.from(delete.from_item());
        }

        if (delete.WHERE() != null) {
            VexContext vex = delete.vex();
            if (vex != null) {
                new ValueExpr(select).analyze(new Vex(vex));
            }
        }

        if (delete.RETURNING() != null) {
            return select.sublist(delete.select_list().select_sublist(), new ValueExpr(select));
        }

        return Collections.emptyList();
    }
}
