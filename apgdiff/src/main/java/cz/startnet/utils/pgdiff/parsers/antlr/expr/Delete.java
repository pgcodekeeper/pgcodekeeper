package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;

public class Delete extends AbstractExprWithNmspc<Delete_stmt_for_psqlContext> {

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(PgDatabase db, DbObjType... disabledDepcies) {
        super(db, disabledDepcies);
    }

    @Override
    public List<ModPair<String, String>> analyze(Delete_stmt_for_psqlContext delete) {
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            analyzeCte(with);
        }

        addNameReference(delete.delete_table_name, delete.alias, null);
        if (delete.USING() != null) {
            for (From_itemContext fromItem : delete.from_item()) {
                //TODO collect to current namespace
                new Select(this).from(fromItem);
            }
        }

        if (delete.WHERE() != null) {
            VexContext vex = delete.vex();
            if (vex != null) {
                new ValueExpr(this).analyze(new Vex(vex));
            }
        }

        return Collections.emptyList();
    }
}
