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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_table_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Data_type_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Engine_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Engine_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Primary_key_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_element_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_projection_defContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChTable;

public class CreateChTable extends ChParserAbstract {

    Create_table_stmtContext ctx;

    public CreateChTable(Create_table_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.qualified_name());
        String name = QNameParser.getFirstName(ids);
        ChTable table = new ChTable(name);
        parseChTable(table);
        addSafe(getSchemaSafe(ids), table, ids);
    }

    public void parseChTable(ChTable table) {
        for (Table_element_exprContext elementCtx : ctx.table_body_expr().table_element_expr()) {
            parseTableElement(table, elementCtx);
        }
        addEnginePart(table, ctx.table_body_expr().engine_clause());
        if (ctx.comment_expr() != null) {
            table.setComment(ctx.comment_expr().STRING_LITERAL().getText());
        }
    }

    private void parseTableElement(ChTable table, Table_element_exprContext elementCtx) {
        Table_column_defContext column = elementCtx.table_column_def();
        Primary_key_clauseContext pk;
        Table_projection_defContext proj;
        if (column != null) {
            addColumn(table, column);
        } else if ((pk = elementCtx.primary_key_clause()) != null) {
            table.setPkExpr(getFullCtxText(pk.expr()));
        } else if (elementCtx.table_constraint_def() != null) {
            table.addChild(getConstraint(elementCtx.table_constraint_def()));
        } else if (elementCtx.INDEX() != null) {
            table.addChild(getIndex(elementCtx.table_index_def()));
        } else if ((proj = elementCtx.table_projection_def()) != null) {
            table.addProjection(proj.qualified_name().getText(), getFullCtxText(proj.projection_select_stmt()));
        } else {
            throw new IllegalArgumentException("unsupported Table_element_exprContext\n" + getFullCtxText(elementCtx));
        }
    }

    private void addColumn(ChTable table, Table_column_defContext column) {
        List<ParserRuleContext> ids = getIdentifiers(column.qualified_name());
        var col = new ChColumn(QNameParser.getFirstName(ids));
        Data_type_exprContext typeExpr = column.data_type_expr();
        if (typeExpr.data_type() != null) {
            col.setType(getFullCtxText(typeExpr.data_type()));
            if ((typeExpr.not_null() != null && typeExpr.not_null().NOT() != null)
                    || typeExpr.data_type().NULLABLE() == null) {
                col.setNullValue(false);
            }
            var defType = typeExpr.table_column_property_expr();
            if (defType != null) {
                col.setAutoIncremental(defType.AUTO_INCREMENT() != null);
                if (defType.DEFAULT() != null) {
                    col.setDefaultType("DEFAULT");
                } else if (defType.MATERIALIZED() != null) {
                    col.setDefaultType("MATERIALIZED");
                } else if (defType.ALIAS() != null) {
                    col.setDefaultType("ALIAS");
                } else if (defType.EPHEMERAL() != null) {
                    col.setDefaultType("EPHEMERAL");
                } else {
                    throw new IllegalArgumentException("context type is unsupported to processing parse:\n"
                            + getFullCtxText(defType));
                }
                if (defType.expr() != null) {
                    col.setDefaultValue(getFullCtxText(defType.expr()));
                }
            }
        } else {
            throw new IllegalArgumentException("context type is unsupported to processing parse table body part:\n"
                    + getFullCtxText(typeExpr));
        }
        if (column.not_null() != null) {
            col.setNullValue(column.not_null().NOT() != null);
        }
        if (column.comment_expr() != null) {
            col.setComment(column.comment_expr().STRING_LITERAL().getText());
        }
        if (column.codec_expr() != null) {
            for (var codec : column.codec_expr().codec_arg_expr()) {
                col.addCodec(getFullCtxText(codec));
            }
        }
        if (column.TTL() != null) {
            col.setTtl(getFullCtxText(column.ttl));
        }
        if (column.STATISTIC() != null) {
            throw new IllegalArgumentException("unsupported experimental element of ClickHouse by 26.02.2024: STATISTICS");
        }
        if (column.PRIMARY() != null) {
            throw new IllegalArgumentException("unsupported syntax sugar part for ChTable by 26.02.2024: column PRIMARY KEY");
        }
        if (column.SETTINGS() != null) {
            throw new IllegalArgumentException("unsupported settings for ChColumn by 26.02.2024");
        }
        table.addColumn(col);
    }

    private void addEnginePart(ChTable table, Engine_clauseContext engineClause) {
        if (engineClause == null) {
            return;
        }

        var engine = engineClause.engine_expr();
        // TODO maybe it will be better if we create special tokens for all engines
        // because they are case sensitive but i'm not sure(note by 26.02.2024)
        table.setEngineType(engine.NULL() != null ? "Null" : getFullCtxText(engine.identifier()));
        if (engine.expr_list() != null) {
            table.setEngineBody(getFullCtxText(engine.expr_list()));
        }
        for (var option : engineClause.engine_option()) {
            parseEngineOption(table, option);
        }

        // TODO check all table engine type to find all default values for each type
        if (Objects.equals(table.getEngineType(), "MergeTree")
                && !table.getOptionsKey().contains("index_granularity")) {
            table.addOption("index_granularity", "8192");
        }
    }

    private void parseEngineOption(ChTable table, Engine_optionContext optionCtx) {
        var orderBy = optionCtx.order_by_clause();
        if (orderBy != null && !orderBy.isEmpty()) {
            table.setOrderExpr(getFullCtxText(orderBy.order_expr_list()));
            return;
        }

        var pk = optionCtx.primary_key_clause();
        if (pk != null && !pk.isEmpty()) {
            table.setPkExpr(getFullCtxText(pk.expr()));
            return;
        }

        var partBy = optionCtx.partition_by_clause();
        if (partBy != null && !partBy.isEmpty()) {
            table.setPartExpr(getFullCtxText(partBy.expr()));
            return;
        }

        var ttl = optionCtx.ttl_clause();
        if (ttl != null && !ttl.isEmpty()) {
            table.setTtlExpr(getFullCtxText(ttl.ttl_expr_list()));
            return;
        }

        var settings = optionCtx.settings_clause();
        if (settings != null && !settings.isEmpty()) {
            for (var setting : settings.setting_expr_list().setting_expr()) {
                table.addOption(setting.identifier().getText(), getFullCtxText(setting.expr()));
            }
            return;
        }

        var sampleBy = optionCtx.sample_by_clause();
        if (sampleBy != null && !sampleBy.isEmpty()) {
            table.setSampleBy(getFullCtxText(sampleBy.expr()));
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, ctx.qualified_name());
    }
}
