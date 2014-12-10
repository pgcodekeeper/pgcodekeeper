package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.parsers.ParserUtils;
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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {
    private Create_view_statementContext ctx;

    public CreateView(Create_view_statementContext ctx, PgDatabase db,
            Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()), "");
        if (ctx.v_query != null) {
            view.setQuery(getFullCtxText(ctx.v_query));
            view.setSelect(parseSelect(ctx.v_query));
        }
        if (ctx.column_name != null) {
            for (String column : getNames(ctx.column_name.name)) {
                view.addColumnName(column);
            }
        }
        fillObjLocation(view, ctx.name.getStart().getStartIndex(), schemaName);
        return view;
    }

    private PgSelect parseSelect(Query_expressionContext ctx) {
        PgSelect select = new PgSelect(getFullCtxText(ctx), null);
        ParseTreeWalker walker = new ParseTreeWalker();
        SelectListener sleList = new SelectListener(select);
        walker.walk(sleList, ctx);
        return sleList.getSelect();
    }

    private class SelectListener extends SQLParserBaseListener {
        private List<GenericColumn> columns = new ArrayList<>();
        private Map<String, String> tableAliases = new HashMap<>();
        private Queue<String> aliasNames = new LinkedList<>();
        private PgSelect select;
        private boolean isFrom = false;
        private boolean isFromQuery = false;

        public SelectListener(PgSelect select) {
            this.select = select;
        }

        @Override
        public void enterTable_primary(Table_primaryContext ctx) {
            if (ctx.as_clause() != null) {
                aliasNames.add(ctx.as_clause().identifier().getText());
            }
        }

//        @Override
//        public void enterDerived_column(Derived_columnContext ctx) {
//            for (As_clauseContext asCtx : ctx.as_clause()) {
//                aliasNames.add(asCtx.identifier().getText());
//            }
//        }

        @Override
        public void enterName_or_func_calls(Name_or_func_callsContext ctx) {
            if (ctx.function_calls_paren() != null) {
                return;
            }
            String colName = getName(ctx.schema_qualified_name());
            String colTable = getTableName(ctx.schema_qualified_name());
            String colSchema = getSchemaName(ctx.schema_qualified_name());
            if (!isFrom) {
                if (colSchema == null 
                        || colSchema.equals(colTable)) {
                    columns.add(new GenericColumn(null, colTable, colName));
                } else {
                    columns.add(new GenericColumn(colSchema, colTable, colName));
                }
            } else {
                if (isFromQuery) {
                    Iterator<GenericColumn> iter = columns.iterator();
                    while (iter.hasNext()) {
                        GenericColumn col = iter.next();
                        if (col.table.equals(aliasNames.peek())) {
                            iter.remove();
                        }
                    }
                } else {
                    tableAliases.put(aliasNames.poll(),
                            getFullCtxText(ctx.schema_qualified_name()));
                }
                
            }
        }

        @Override
        public void enterFrom_clause(From_clauseContext ctx) {
            isFrom = true;
        }

        @Override
        public void exitFrom_clause(From_clauseContext ctx) {
            isFrom = false;
        }
        @Override
        public void enterQuery_specification(Query_specificationContext ctx) {
            if (isFrom) {
                isFromQuery  =true;
            }
        };
        @Override
        public void exitQuery_specification(Query_specificationContext ctx) {
            if (isFrom) {
                isFromQuery = false;
            }
        };
        
        PgSelect getSelect() {
            for (GenericColumn column : columns) {
                if (column.schema == null && column.table != null) {
                    String unaliased = tableAliases.get(column.table);
                    if (unaliased != null) {
                        column = new GenericColumn(ParserUtils.getSchemaName(
                                unaliased, new PgDatabase()),
                                ParserUtils.getObjectName(unaliased),
                                column.column);
                    }
                }
                select.addColumn(column);
            }
            return select;
        }
    }
}
