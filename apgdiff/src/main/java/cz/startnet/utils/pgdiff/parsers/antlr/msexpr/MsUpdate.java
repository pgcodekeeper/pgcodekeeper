package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_column_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_elemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;

public class MsUpdate extends MsAbstractExprWithNmspc<Update_statementContext> {

    protected MsUpdate(MsAbstractExpr parent) {
        super(parent);
    }

    public MsUpdate(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(Update_statementContext update) {
        With_expressionContext with = update.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        Qualified_nameContext tableName = update.qualified_name();

        MsSelect select = new MsSelect(this);
        for (From_itemContext item : update.from_item()) {
            select.from(item);
        }

        IdContext schemaCtx = tableName == null ? null : tableName.schema;
        boolean isAlias = false;

        if (schemaCtx == null) {
            isAlias = select.findReference(null, tableName.name.getText()) != null;
        }

        if (tableName != null && !isAlias) {
            addNameReference(tableName, null);
        }

        MsValueExpr vex = new MsValueExpr(select);

        ExpressionContext exp = update.expression();
        if (exp != null) {
            vex.analyze(exp);
        }

        for (Update_elemContext elem : update.update_elem()) {
            ExpressionContext expr = elem.expression();
            if (expr != null) {
                vex.analyze(expr);
                Full_column_nameContext fcn = elem.full_column_name();
                if (fcn != null) {
                    addColumnDepcy(fcn);
                }
            } else {
                vex.expressionList(elem.expression_list());
            }
        }

        Search_conditionContext search = update.search_condition();
        if (search != null) {
            vex.search(search);
        }

        return Collections.emptyList();
    }
}
