package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.As_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Name_or_func_callsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_asteriskContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Query_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_function_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Simple_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseVisitor;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.GenericColumn.ViewReference;
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
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()));
        if (ctx.v_query != null) {
            view.setQuery(getFullCtxText(ctx.v_query));
            view.setSelect(parseSelect(ctx.v_query));
        }
        if (ctx.column_name != null) {
            for (String column : getNames(ctx.column_name.names_references().name)) {
                view.addColumnName(column);
            }
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "VIEW", name);
            return null;
        }
        db.getSchema(schemaName).addView(view);
        return view;
    }
    
    public SelectQueryVisitor getVisitor(PgSelect select) {
        return new SelectQueryVisitor(select);
    }

    private PgSelect parseSelect(Query_expressionContext ctx) {
        PgSelect select = new PgSelect(getFullCtxText(ctx));
        SelectQueryVisitor visitor = new SelectQueryVisitor(select);
        visitor.visit(ctx);
        return visitor.getSelect();
    }

    public class SelectQueryVisitor extends
            SQLParserBaseVisitor<Query_expressionContext> {
        // список алиасов запросов, игнорируются при заполнении колонок в селект
        private List<String> aliasNames = new ArrayList<>();
        //адреса объектов колонок, таблиц и функций
        private List<GenericColumn> columns = new ArrayList<>();
        // карта алиасов колонок, таблиц и функций
        private Map<String, GenericColumn> tableAliases = new HashMap<>();
        boolean isQuery = false;
        private PgSelect select;
        private boolean isTableRef = false;

        public SelectQueryVisitor(PgSelect select) {
            this.select = select;
        }

        @Override
        public Query_expressionContext visitTable_primary(
                Table_primaryContext ctx) {
            isTableRef = true;
            return visitChildren(ctx);
        }
        
        @Override
        public Query_expressionContext visitSimple_table(Simple_tableContext ctx) {
            if (ctx.query_specification() != null) {
                SelectQueryVisitor vis = new SelectQueryVisitor(select);
                vis.columns.addAll(columns);
                vis.visit(ctx.query_specification());
                columns.clear();
                columns.addAll(vis.getColumns());
                isQuery = true;
                tableAliases.putAll(vis.tableAliases);
                return null;
            }
            return visitChildren(ctx);
        }

        @Override
        public Query_expressionContext visitSet_function_specification(
                Set_function_specificationContext ctx) {
            GenericColumn col = new GenericColumn(null, ctx.COUNT() != null ? 
                    getFullCtxText(ctx) : getFullCtxText(ctx.general_set_function()),
                    null);
            col.setType(ViewReference.SYSTEM);
            columns.add(col);
            return null;
        }
        
        @Override
        public Query_expressionContext visitQualified_asterisk(
                Qualified_asteriskContext ctx) {
            String tblName = null;
            String schmName = null;
            if (ctx.tb_name != null) {
                tblName = getName(ctx.tb_name);
                schmName = getTableName(ctx.tb_name);
            }
            columns.add(new GenericColumn(schmName, tblName, "*"));
            return null;
        }

        @Override
        public Query_expressionContext visitName_or_func_calls(
                Name_or_func_callsContext ctx) {
            if (ctx.function_calls_paren() != null) {
                addFunction(ctx);
                return visitChildren(ctx);
            } 
            if (isTableRef) {
                isTableRef = false;
                String schemaName = getSchemaName(ctx.schema_qualified_name());
                GenericColumn col = new GenericColumn(
                        schemaName == null ? getDefSchemaName() : schemaName,
                        getName(ctx.schema_qualified_name()), null);
                col.setType(ViewReference.TABLE);
                columns.add(col);
                return null;
            }
            
            String colName = getName(ctx.schema_qualified_name());
            String colTable = getTableName(ctx.schema_qualified_name());
            String colSchema = getSchemaName(ctx.schema_qualified_name());
            if (colSchema == null || colSchema.equals(colTable)) {
                columns.add(new GenericColumn(null, colTable, colName));
            } else {
                columns.add(new GenericColumn(colSchema, colTable, colName));
            }
            return null;
        }
        
        private void addFunction(Name_or_func_callsContext ctx) {
            GenericColumn functionCall = new GenericColumn(
                    getSchemaName(ctx.schema_qualified_name()),
                    getName(ctx.schema_qualified_name()), null);
            functionCall.setType(ViewReference.FUNCTION);
            columns.add(functionCall);
        }
        
        @Override
        public Query_expressionContext visitAs_clause(As_clauseContext ctx) {
            String aliasName = ctx.identifier().getText();
            if (isQuery) {
                isQuery = false;
                aliasNames.add(aliasName);
                Iterator<GenericColumn> iter = columns.iterator();
                while (iter.hasNext()) {
                    if (aliasName.equals(iter.next().table)) {
                        iter.remove();
                    }
                }
            } else {
                tableAliases.put(aliasName, columns.get(columns.size() - 1));
            }
            return visitChildren(ctx);
        }

        private List<GenericColumn> getColumns() {
            // вытаскиваем таблицы из смешанного списка колонок и помещаем их в
            // алиасы с их именами
            // например, select t1.c1 from public.t1 тут для корректного разбора
            // создаем вспомогательный алиас t1=public.t1
            Iterator<GenericColumn> tableIter = columns.iterator();
            while (tableIter.hasNext()) {
                GenericColumn tableRef = tableIter.next();
                if (tableRef.getType() == ViewReference.TABLE) {
                    tableAliases.put(tableRef.table, tableRef);
                    tableIter.remove();
                }
            }
            
            Iterator<GenericColumn> iter = columns.iterator();
            List<GenericColumn> newColumns = new ArrayList<>();
            while (iter.hasNext()) {
                GenericColumn col = iter.next();
                // удаляем алиасы из подзапросов
                if (aliasNames.contains(col.table)) {
                    iter.remove();
                    continue;
                }
                switch (col.getType()) {
                case FUNCTION:
                case COLUMN:
                    if (col.column!= null && col.column.equals("*")) {
                        GenericColumn unaliased = tableAliases.get(col.table);
                        if (unaliased != null) {
                            newColumns.add(new GenericColumn(unaliased.schema,
                                    unaliased.table, col.column));
                        } else {
                            // Если не удалось получить алиас, например написано
                            // просто *, то берем все таблицы из запроса и
                            // добавляем ссылки на них
                            for (GenericColumn tblAlias : tableAliases.values()) {
                                newColumns.add(new GenericColumn(
                                        getDefSchemaName(), tblAlias.table,
                                        col.column));
                            }
                        }
                        continue;
                    }
                    GenericColumn unaliased = tableAliases.get(col.table);
                    if (unaliased != null) {
                        GenericColumn column = new GenericColumn(unaliased.schema,
                                unaliased.table, col.column);
                        if (unaliased.getType() == ViewReference.FUNCTION) {
                            column.setType(ViewReference.FUNCTION);
                        }
                        newColumns.add(column);
                    } else {
                        newColumns.add(col);
                    }
                    break;
                case TABLE:
                case SYSTEM:
                    break;
                }
            }
            columns.clear();
            columns.addAll(newColumns);
            return columns;
        }
        
        public PgSelect getSelect() {
            for (GenericColumn col : columns) {
                select.addColumn(col);
            }
            return select;
        }
    }
}
