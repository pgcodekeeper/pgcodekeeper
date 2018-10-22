package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Delete_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Top_countContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;

public class MsDelete extends MsAbstractExprWithNmspc<Delete_statementContext> {

    protected MsDelete(MsAbstractExpr parent) {
        super(parent);
    }

    public MsDelete(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(Delete_statementContext delete) {
        With_expressionContext with = delete.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        Top_countContext top = delete.top_count();
        if (top != null) {
            ExpressionContext exp = top.expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(exp);
            }
        }

        Qualified_nameContext tableName = delete.qualified_name();
        if (tableName != null) {
            addNameReference(tableName, null);
        }

        Search_conditionContext search = delete.search_condition();
        if (search != null) {
            new MsValueExpr(this).search(search);
        }

        for (From_itemContext item : delete.from_item()) {
            new MsSelect(this).from(item);
        }

        return Collections.emptyList();
    }
}
