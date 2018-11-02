package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_column_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Merge_matchedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Merge_not_matchedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Merge_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_value_constructorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_elemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;

public class MsMerge extends MsAbstractExprWithNmspc<Merge_statementContext> {

    protected MsMerge(MsAbstractExpr parent) {
        super(parent);
    }

    public MsMerge(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(Merge_statementContext merge) {
        With_expressionContext with = merge.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        Qualified_nameContext tableName = merge.qualified_name();
        if (tableName != null) {
            addNameReference(tableName, merge.as_table_alias());
        }

        MsSelect select = new MsSelect(this);

        for (From_itemContext item : merge.from_item()) {
            select.from(item);
        }

        MsValueExpr vex = new MsValueExpr(select);

        ExpressionContext exp = merge.expression();
        if (exp != null) {
            vex.analyze(exp);
        }

        for (Search_conditionContext search : merge.search_condition()) {
            vex.search(search);
        }

        Merge_not_matchedContext notMatched = merge.merge_not_matched();
        if (notMatched != null) {
            Table_value_constructorContext tvc = notMatched.table_value_constructor();
            if (tvc != null) {
                for (Expression_listContext list : tvc.expression_list()) {
                    vex.expressionList(list);
                }
            }
        }

        for (Merge_matchedContext match : merge.merge_matched()) {
            for (Update_elemContext elem : match.update_elem()) {
                ExpressionContext expr = elem.expression();
                if (expr != null) {
                    vex.analyze(exp);
                    Full_column_nameContext fcn = elem.full_column_name();
                    if (fcn != null) {
                        addColumnDepcy(fcn);
                    }
                } else {
                    vex.expressionList(elem.expression_list());
                }
            }
        }


        return Collections.emptyList();
    }
}
