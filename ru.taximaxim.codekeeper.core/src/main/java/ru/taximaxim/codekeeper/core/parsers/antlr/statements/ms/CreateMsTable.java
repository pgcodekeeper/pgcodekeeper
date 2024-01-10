/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_optionsContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;

public class CreateMsTable extends MsTableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;

    public CreateMsTable(Create_tableContext ctx, PgDatabase db, boolean ansiNulls) {
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
            MsIndex index = new MsIndex(indCtx.id().getText());

            ClusteredContext cluster = indCtx.clustered();
            index.setClustered(cluster != null && cluster.CLUSTERED() != null);
            index.setUnique(indCtx.UNIQUE() != null);
            parseIndex(indCtx.index_rest(), index, schemaCtx == null ? null : schemaCtx.getText(),
                    tableCtx.getText());

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
                col.setExpression(getFullCtxText(colCtx.expression()));
                db.addAnalysisLauncher(new MsExpressionAnalysisLauncher(col, colCtx.expression(), fileName));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col, table);
            }

            table.addColumn(col);
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, ctx.qualified_name());
    }
}
