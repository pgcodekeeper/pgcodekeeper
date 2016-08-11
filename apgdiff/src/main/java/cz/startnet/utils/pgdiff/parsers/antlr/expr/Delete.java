package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;

public class Delete extends AbstractExprWithNmspc {

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(ParserRuleContext ruleCtx) {
        Delete_stmt_for_psqlContext delete = (Delete_stmt_for_psqlContext) ruleCtx;
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
        return null;
    }
}
