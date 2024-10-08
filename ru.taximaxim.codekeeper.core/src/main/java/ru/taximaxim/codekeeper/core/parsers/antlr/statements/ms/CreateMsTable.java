/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ClusteredContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_def_table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Columnstore_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_optionsContext;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;

public class CreateMsTable extends MsTableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;

    public CreateMsTable(Create_tableContext ctx, MsDatabase db, boolean ansiNulls) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.qualified_name().name;
        String tableName = nameCtx.getText();

        MsTable table = new MsTable(tableName);

        table.setAnsiNulls(ansiNulls);

        if (ctx.tablespace != null) {
            String tableSpace = MsDiffUtils.quoteName(ctx.tablespace.getText());
            if (ctx.partition_col_name != null) {
                tableSpace = tableSpace + '(' +
                        MsDiffUtils.quoteName(ctx.partition_col_name.getText()) + ')';
            }
            table.setTablespace(tableSpace);
        }

        if (ctx.textimage != null) {
            table.setTextImage(ctx.textimage.getText());
        }

        if (ctx.filestream != null) {
            table.setFileStream(ctx.filestream.getText());
        }

        for (Table_optionsContext options : ctx.table_options()) {
            fillOptions(table, options.index_option());
        }

        for (Column_def_table_constraintContext colCtx : ctx.column_def_table_constraints().column_def_table_constraint()) {
            fillColumn(colCtx, table);
        }

        List<ParserRuleContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), table, ids);
    }

    private void fillColumn(Column_def_table_constraintContext colCtx, MsTable table) {
        IdContext schemaCtx = ctx.qualified_name().schema;
        IdContext tableCtx = ctx.qualified_name().name;

        if (colCtx.table_constraint() != null) {
            table.addChild(getMsConstraint(colCtx.table_constraint(),
                    schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText()));
        } else if (colCtx.table_index() != null) {
            Table_indexContext indCtx = colCtx.table_index();
            MsIndex index = new MsIndex(indCtx.ind_name.getText());

            var restCtx = indCtx.index_rest();
            if (restCtx != null) {
                index.setUnique(indCtx.UNIQUE() != null);
                ClusteredContext cluster = indCtx.clustered();
                index.setClustered(cluster != null && cluster.CLUSTERED() != null);
                parseIndex(restCtx, index, schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText());
            } else {
                var columnstoreIndCtx = indCtx.columnstore_index();
                index.setColumnstore(true);
                index.setClustered(columnstoreIndCtx.CLUSTERED() != null);
                parseColumnstoreIndex(indCtx.columnstore_index(), index, schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText());
                parseIndexOptions(index, indCtx.index_where(), indCtx.index_options(), ctx.id());
            }

            if (index.getTablespace() == null) {
                index.setTablespace(table.getTablespace());
            }

            table.addChild(index);
        } else {
            MsColumn col = new MsColumn(colCtx.id().getText());
            if (colCtx.data_type() != null) {
                Data_typeContext dt = colCtx.data_type();
                addTypeDepcy(dt, col);
                col.setType(getFullCtxText(dt));
            } else {
                var expr = colCtx.expression();
                col.setExpression(getFullCtxTextWithCheckNewLines(expr));
                db.addAnalysisLauncher(new MsExpressionAnalysisLauncher(col, expr, fileName));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col, table);
            }

            table.addColumn(col);
        }
    }

    private void parseColumnstoreIndex(Columnstore_indexContext ctx, AbstractIndex index, String schema, String table) {
        var nameList = ctx.name_list_in_brackets();
        if (nameList != null) {
            for (IdContext col : nameList.id()) {
                index.addInclude(col.getText());
                index.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
            }
        }
        var orderCols = ctx.order_cols;
        if (orderCols != null) {
            fillOrderCols((MsIndex) index, orderCols.column_name_list_with_order().column_with_order(), schema, table);
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, ctx.qualified_name());
    }
}
