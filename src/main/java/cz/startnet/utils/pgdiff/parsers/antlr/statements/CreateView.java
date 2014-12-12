package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.As_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Name_or_func_callsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_function_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Simple_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseVisitor;
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
        MyVisitor visitor = new MyVisitor(select);
        visitor.visit(ctx);
        return visitor.getSelect();
    }

    private class MyVisitor extends
            SQLParserBaseVisitor<Query_expressionContext> {
        // список алиасов запросов, игнорируются при заполнении колонок в селект
        private Queue<String> aliasNames = new LinkedList<>();
        private List<GenericColumn> columns = new ArrayList<>();
        private Map<String, String> tableAliases = new HashMap<>();
        boolean isQiery = false;
        private PgSelect select;

        public MyVisitor(PgSelect select) {
            this.select = select;
        }

        @Override
        public Query_expressionContext visitSimple_table(Simple_tableContext ctx) {
            if (ctx.query_specification() != null) {
                MyVisitor vis = new MyVisitor(select);
                vis.visit(ctx.query_specification());
                isQiery = true;
                aliasNames.addAll(vis.aliasNames);
                columns.addAll(vis.columns);
                tableAliases.putAll(vis.tableAliases);
                return null;
            }
            return super.visitSimple_table(ctx);
        }

        @Override
        public Query_expressionContext visitSet_function_specification(
                Set_function_specificationContext ctx) {
            if (ctx.COUNT() != null) {
                columns.add(new GenericColumn(ctx.COUNT().getText()));
            } else {
                columns.add(new GenericColumn(ctx.general_set_function()
                        .set_function_type().getText()));
            }
            return null;
        }

        @Override
        public Query_expressionContext visitName_or_func_calls(
                Name_or_func_callsContext ctx) {
            String colName;
            if (ctx.function_calls_paren() != null) {
                colName = getFullCtxText(ctx);
            } else {
                colName = getName(ctx.schema_qualified_name());
            }

            String colTable = getTableName(ctx.schema_qualified_name());
            String colSchema = getSchemaName(ctx.schema_qualified_name());
            if (colSchema == null || colSchema.equals(colTable)) {
                columns.add(new GenericColumn(null, colTable, colName));
            } else {
                columns.add(new GenericColumn(colSchema, colTable, colName));
            }
            return null;
        }

        @Override
        public Query_expressionContext visitAs_clause(As_clauseContext ctx) {
            String aliasName = ctx.identifier().getText();
            if (isQiery) {
                isQiery = false;
                aliasNames.add(aliasName);
                Iterator<GenericColumn> iter = columns.iterator();
                while (iter.hasNext()) {
                    GenericColumn col = iter.next();
                    if (col.table != null && col.table.equals(aliasName)) {
                        iter.remove();
                    }
                }
            } else {
                tableAliases.put(aliasName,
                        columns.get(columns.size() - 1).column);
            }
            return super.visitAs_clause(ctx);
        }

        PgSelect getSelect() {
            for (GenericColumn column : columns) {
                if (column.schema == null && column.table != null) {
                    String unaliased = tableAliases.get(column.table);
                    if (unaliased != null) {
                        column = new GenericColumn(ParserUtils.getSchemaName(
                                unaliased, db),
                                ParserUtils.getObjectName(unaliased),
                                column.column);
                    }
                    // те колонки которые не попали в алиасы не должны быть в
                    // списке алиасов подзапросов
                    if (!aliasNames.contains(column.table)) {
                        column = new GenericColumn(
                                column.schema != null ? column.schema : db
                                        .getDefaultSchema().getName(),
                                column.table, column.column);
                        select.addColumn(column);
                    }
                }
            }
            return select;
        }
    }
}
