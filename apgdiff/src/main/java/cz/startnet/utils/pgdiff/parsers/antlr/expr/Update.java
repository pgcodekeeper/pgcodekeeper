package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_setContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;

public class Update extends AbstractExprWithNmspc<Update_stmt_for_psqlContext> {

    protected Update(AbstractExpr parent) {
        super(parent);
    }

    public Update(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(Update_stmt_for_psqlContext update) {
        With_clauseContext with = update.with_clause();
        if (with != null) {
            analyzeCte(with);
        }

        addNameReference(update.update_table_name, update.alias, null);

        if (update.FROM() != null) {
            for (Using_tableContext usingTable : update.using_table()) {
                addNameReference(usingTable.schema_qualified_name(), usingTable.alias_clause());
            }
        }

        for (Update_setContext updateSet : update.update_set()) {
            addColumnsDepcies(update.update_table_name, updateSet.column);

            Table_subqueryContext subQuery = updateSet.table_subquery();
            if (subQuery != null) {
                new Select(this).analyze(subQuery.select_stmt());
            } else if (!updateSet.value.isEmpty()) {
                ValueExpr vex = new ValueExpr(this);
                for (VexContext vexCtx : updateSet.value) {
                    vex.analyze(new Vex(vexCtx));
                }
            }
        }

        if (update.WHERE() != null) {
            VexContext vex = update.vex();
            if (vex != null) {
                new ValueExpr(this).analyze(new Vex(vex));
            }
        }
        return null;
    }
}
