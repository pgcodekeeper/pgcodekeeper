package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_matchedContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_not_matchedContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_updateContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Table_subqueryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Values_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Values_valuesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.When_conditionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public class Merge extends AbstractExprWithNmspc<Merge_stmt_for_psqlContext>  {

    public Merge(AbstractExpr parent) {
        super(parent);
    }

    public Merge(MetaContainer meta) {
        super(meta);
    }

    @Override
    public List<ModPair<String, String>> analyze(Merge_stmt_for_psqlContext merge) {
        // this select is used to collect namespaces for this MERGE operation
        Select select = new Select(this);

        Schema_qualified_nameContext source_table = merge.source_table_name;
        if (source_table != null) {
            select.addNameReference(source_table, merge.source_alias, null);
        } else {
            String tableSubQueryAlias = merge.source_alias.getText();
            select.addReference(tableSubQueryAlias, null);

            Table_subqueryContext subQuery = merge.table_subquery();
            List<ModPair<String, String>> columnList = new Select(select).analyze(subQuery.select_stmt());
            select.complexNamespace.put(tableSubQueryAlias, new ArrayList<>(columnList));
        }

        With_clauseContext with = merge.with_clause();
        if (with != null) {
            select.analyzeCte(with);
        }

        select.addNameReference(merge.merge_table_name, merge.alias, null);

        ValueExpr vexOn = new ValueExpr(select);
        vexOn.analyze(new Vex(merge.vex()));

        for(When_conditionContext whenCondition: merge.when_condition()) {
            Merge_matchedContext match = whenCondition.merge_matched();
            if (match != null) {
                for(Merge_updateContext update: match.merge_update()) {
                    select.addColumnsDepcies(merge.merge_table_name, update.column);
                    for(VexContext vex: update.value ) {
                        new ValueExpr(select).analyze(new Vex(vex));
                    }
                }
            } else {
                Merge_not_matchedContext notMatch = whenCondition.merge_not_matched();
                Values_stmtContext selectCtx = notMatch.values_stmt();
                if (selectCtx != null) {
                    ValueExpr vex = new ValueExpr(this);
                    for (Values_valuesContext values : selectCtx.values_values()) {
                        for (VexContext v : values.vex()) {
                            vex.analyze(new Vex(v));
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
