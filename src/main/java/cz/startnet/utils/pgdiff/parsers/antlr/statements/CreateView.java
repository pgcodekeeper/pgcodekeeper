package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.As_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Common_value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cross_joinContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Derived_columnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Explicit_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Join_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Join_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Joined_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Joined_table_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Name_or_func_callsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Named_columns_joinContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Natural_joinContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Non_join_query_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Non_join_query_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Non_join_query_termContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Nonparenthesized_value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Numeric_value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Parenthesized_value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_joinContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_termContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_sublistContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Simple_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_referenceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primary_castContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {
    private Create_view_statementContext ctx;
    public CreateView(Create_view_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()), "");
        if (ctx.v_query!=null) {
            view.setQuery(getFullCtxText(ctx.v_query));
            view.setSelect(parseSelect(ctx.v_query));
        }
        if (ctx.column_name!= null) {
            for (String column : getNames(ctx.column_name.name)) {
                view.addColumnName(column);
            }
        }
        fillObjLocation(view, ctx.name.getStart().getStartIndex(), schemaName);
        return view;
    }

    private PgSelect parseSelect(Query_expressionContext ctx) {
        PgSelect select = new PgSelect(getFullCtxText(ctx), null);
        query_expression(ctx, select);
        
        return select;
    }

    private void non_join_query_expression(
            Non_join_query_expressionContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        non_join_query_term(ctx.non_join_query_term(), select);
        joined_table(ctx.joined_table(), select);
        query_term(ctx.query_term(), select);
        
    }

    private void query_term(List<Query_termContext> query_term, PgSelect select) {
        for (Query_termContext term : query_term) {
            non_join_query_term(term.non_join_query_term(), select);
            joined_table(term.joined_table(), select);
        }
    }

    private void joined_table(Joined_tableContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        table_primary(ctx.table_primary(), select);
        joined_table_primary(ctx.joined_table_primary(), select);
    }

    private void joined_table_primary(
            List<Joined_table_primaryContext> joined_table_primary,
            PgSelect select) {
        for (Joined_table_primaryContext ctx : joined_table_primary) {
            cross_join(ctx.cross_join(), select);
            qualified_join(ctx.qualified_join(), select);
            natural_join(ctx.natural_join(), select);
        }
    }

    private void natural_join(Natural_joinContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        table_primary(ctx.table_primary(), select);
    }

    private void qualified_join(Qualified_joinContext ctx,
            PgSelect select) {
        table_primary(ctx.table_primary(), select);
        join_specification(ctx.join_specification(), select);
    }

    private void join_specification(
            Join_specificationContext ctx, PgSelect select) {
        join_condition(ctx.join_condition(), select);
        named_columns_join(ctx.named_columns_join(), select);
    }

    private void named_columns_join(
            Named_columns_joinContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        column_references(ctx.column_references(), select);
    }

    private void join_condition(Join_conditionContext ctx,
            PgSelect select) {
        value_expression_primary_cast(ctx.value_expression_primary_cast(), select);
    }

    private void cross_join(Cross_joinContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        table_primary(ctx.table_primary(), select);
    }

    private void table_primary(Table_primaryContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        name_or_func_calls(ctx.name_or_func_calls(), select);
        table_subquery(ctx.table_subquery(), select);
        as_clause(ctx.as_clause(), select);
        column_references(ctx.column_references(), select);
    }

    private void column_references(Column_referencesContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        for (Schema_qualified_nameContext name : ctx.names_references().name) {
            select.addColumn(new GenericColumn(name.getText()));
        }
    }

    private String as_clause(As_clauseContext ctx, PgSelect select) {
        if (ctx == null) {
            return null;
        }
        return ctx.identifier().getText();
    }

    private void table_subquery(Table_subqueryContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        query_expression(ctx.query_expression(), select);
    }

    private void query_expression(Query_expressionContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        non_join_query_expression(ctx.non_join_query_expression(), select);
        joined_table(ctx.joined_table(), select);
    }

    private void name_or_func_calls(
            Name_or_func_callsContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        String name = ctx.schema_qualified_name().getText();
        if (ctx.function_calls_paren() != null) {
            name += ctx.function_calls_paren().getText(); 
        }
        select.addColumn(new GenericColumn(name));
    }

    private void non_join_query_term(
            Non_join_query_termContext ctx, PgSelect select) {
        if (ctx ==null) {
            return;
        }
        non_join_query_primary(ctx.non_join_query_primary(), select);
        joined_table(ctx.joined_table(), select);
        query_primary(ctx.query_primary(), select);
        
    }

    private void query_primary(List<Query_primaryContext> query_primary,
            PgSelect select) {
        for (Query_primaryContext ctx : query_primary) {
            query_primary(ctx, select);
        }
    }

    private void query_primary(Query_primaryContext ctx, PgSelect select) {
        non_join_query_primary(ctx.non_join_query_primary(), select);
        joined_table(ctx.joined_table(), select);
    }

    private void non_join_query_primary(
            Non_join_query_primaryContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        simple_table(ctx.simple_table(), select);
        non_join_query_expression(ctx.non_join_query_expression(), select);
    }

    private void simple_table(Simple_tableContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        query_specification(ctx.query_specification(), select);
        explicit_table(ctx.explicit_table(), select);
    }

    private void explicit_table(Explicit_tableContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        select.addColumn(new GenericColumn(ctx.schema_qualified_name().getText()));
    }

    private void query_specification(
            Query_specificationContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        select_list(ctx.select_list(), select);
        table_expression(ctx.table_expression(), select);
    }

    private void table_expression(Table_expressionContext ctx,
            PgSelect select) {
        from_clause(ctx.from_clause(), select);
    }

    private void from_clause(From_clauseContext ctx, PgSelect select) {
        if (ctx==null) {
            return;
        }
        table_reference(ctx.table_reference(), select);
    }

    private void table_reference(List<Table_referenceContext> table_reference,
            PgSelect select) {
        for (Table_referenceContext ctx : table_reference) {
            joined_table(ctx.joined_table(), select);
            table_primary(ctx.table_primary(), select);
        }
    }

    private void select_list(Select_listContext ctx, PgSelect select) {
        if (ctx == null) {
            return;
        }
        select_sublist(ctx.select_sublist(), select);
    }

    private void select_sublist(List<Select_sublistContext> select_sublist,
            PgSelect select) {
        for (Select_sublistContext ctx : select_sublist) {
            derived_column(ctx.derived_column(), select);
//            qualified_asterisk(ctx.qualified_asterisk(), select);
        }
    }

    private void derived_column(Derived_columnContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        value_expression_primary_cast(ctx.value_expression_primary_cast(), select);
//        over_clause(ctx.over_clause(), select);
        for (As_clauseContext asctx : ctx.as_clause()) {
            as_clause(asctx, select);
        }
    }

//    private void over_clause(List<Over_clauseContext> over_clause,
//            PgSelect select) {
//        for (Over_clauseContext ctx : over_clause) {
//            
//        }
//    }

    private void value_expression_primary_cast(
            Value_expression_primary_castContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        value_expression_primary(ctx.value_expression_primary(), select);
    }

    private void value_expression_primary(
            Value_expression_primaryContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        nonparenthesized_value_expression_primary(ctx.nonparenthesized_value_expression_primary(), select);
        parenthesized_value_expression(ctx.parenthesized_value_expression(), select);
    }

    private void parenthesized_value_expression(
            Parenthesized_value_expressionContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        value_expression(ctx.value_expression(), select);
    }

    private void value_expression(Value_expressionContext ctx,
            PgSelect select) {
        common_value_expression(ctx.common_value_expression(), select);
    }

    private void common_value_expression(
            Common_value_expressionContext ctx,
            PgSelect select) {
        numeric_value_expression(ctx.numeric_value_expression(), select);
    }

    private void numeric_value_expression(
            Numeric_value_expressionContext numeric_value_expression,
            PgSelect select) {
        // TODO Auto-generated method stub
        
    }

    private void nonparenthesized_value_expression_primary(
            Nonparenthesized_value_expression_primaryContext ctx,
            PgSelect select) {
        if (ctx == null) {
            return;
        }
        if (ctx.unsigned_value_specification()!=null) {
            select.addColumn(new GenericColumn(ctx.unsigned_value_specification().getText()));
        }
        if (ctx.name_or_func_calls() != null) {
            select.addColumn(new GenericColumn(ctx.name_or_func_calls().getText()));
        }
    }

}
