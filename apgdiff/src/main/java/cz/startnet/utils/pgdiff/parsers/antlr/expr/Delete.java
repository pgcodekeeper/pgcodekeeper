package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.AbstractExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;

public class Delete extends AbstractExprWithNmspc<Delete_stmt_for_psqlContext> {

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(String schema) {
        super(schema);
    }

    @Override
    public void analyze(Delete_stmt_for_psqlContext delete) {
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            analyzeCte(with);
        }

        addNameReference(delete.delete_table_name, delete.alias, null);
        if (delete.USING() != null) {
            for (Using_tableContext usingTable : delete.using_table()) {
                addNameReference(usingTable.schema_qualified_name(), usingTable.alias_clause());
            }
        }

        if (delete.WHERE() != null) {
            VexContext vex = delete.vex();
            if (vex != null) {
                new ValueExpr(this).analyze(new Vex(vex));
            }
        }
    }
}
