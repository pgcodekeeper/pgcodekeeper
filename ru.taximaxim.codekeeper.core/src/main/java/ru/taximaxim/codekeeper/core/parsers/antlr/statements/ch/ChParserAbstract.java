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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Data_type_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Engine_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Engine_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Subquery_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_constraint_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_index_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.ch.ChColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChConstraint;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChEngine;
import ru.taximaxim.codekeeper.core.schema.ch.ChIndex;

public abstract class ChParserAbstract extends ParserAbstract<ChDatabase> {

    protected ChParserAbstract(ChDatabase db) {
        super(db);
    }

    public static List<ParserRuleContext> getIdentifiers(Qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(3);
        ids.addAll(qNameCtx.identifier());
        return ids;
    }

    protected ChColumn getColumn(Table_column_defContext column) {
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
            throw new IllegalArgumentException(
                    "unsupported experimental element of ClickHouse by 26.02.2024: STATISTICS");
        }
        if (column.PRIMARY() != null) {
            throw new IllegalArgumentException(
                    "unsupported syntax sugar part for ChTable by 26.02.2024: column PRIMARY KEY");
        }
        if (column.SETTINGS() != null) {
            throw new IllegalArgumentException("unsupported settings for ChColumn by 26.02.2024");
        }
        return col;
    }

    protected String getQuery(Subquery_clauseContext vQuery) {
        return getFullCtxText(vQuery);
    }

    protected ChEngine getEnginePart(Engine_clauseContext engineClause) {
        if (engineClause == null) {
            return null;
        }

        var engineCtx = engineClause.engine_expr();
        // TODO maybe it will be better if we create special tokens for all engines
        // because they are case sensitive but i'm not sure(note by 26.02.2024)
        ChEngine engine = new ChEngine(engineCtx.NULL() != null ? "Null" : getFullCtxText(engineCtx.identifier()));
        if (engineCtx.expr_list() != null) {
            engine.setBody(getFullCtxText(engineCtx.expr_list()));
        }
        for (var option : engineClause.engine_option()) {
            parseEngineOption(engine, option);
        }
        // TODO check all table engine type to find all default values for each type
        if (Objects.equals(engine.getName(), "MergeTree") && !engine.getOptions().contains("index_granularity")) {
            engine.addOption("index_granularity", "8192");
        }

        return engine;
    }

    protected void parseEngineOption(ChEngine engine, Engine_optionContext optionCtx) {
        var orderBy = optionCtx.order_by_clause();
        if (orderBy != null && !orderBy.isEmpty()) {
            engine.setOrderBy(getFullCtxText(orderBy.order_expr_list()));
            return;
        }

        var pk = optionCtx.primary_key_clause();
        if (pk != null && !pk.isEmpty()) {
            engine.setPrimaryKey(getFullCtxText(pk.expr()));
            return;
        }

        var partBy = optionCtx.partition_by_clause();
        if (partBy != null && !partBy.isEmpty()) {
            engine.setPartitionBy(getFullCtxText(partBy.expr()));
            return;
        }

        var ttl = optionCtx.ttl_clause();
        if (ttl != null && !ttl.isEmpty()) {
            engine.setTtl(getFullCtxText(ttl.ttl_expr_list()));
            return;
        }

        var settings = optionCtx.settings_clause();
        if (settings != null && !settings.isEmpty()) {
            for (var setting : settings.setting_expr_list().setting_expr()) {
                engine.addOption(setting.identifier().getText(), getFullCtxText(setting.expr()));
            }
            return;
        }

        var sampleBy = optionCtx.sample_by_clause();
        if (sampleBy != null && !sampleBy.isEmpty()) {
            engine.setSampleBy(getFullCtxText(sampleBy.expr()));
        }
    }

    protected ChConstraint getConstraint(Table_constraint_defContext constraintCtx) {
        var constr = new ChConstraint(constraintCtx.identifier().getText(), constraintCtx.ASSUME() != null);
        constr.setExpr(getFullCtxText(constraintCtx.expr()));
        return constr;
    }

    protected ChIndex getIndex(Table_index_defContext indexCtx) {
        var index = new ChIndex(indexCtx.identifier().getText());
        index.setExpr(getFullCtxText(indexCtx.expr()));
        index.setType(getFullCtxText(indexCtx.index_type()));
        var granVal = indexCtx.gran;
        if (granVal != null) {
            index.setGranVal(Integer.parseInt(granVal.getText()));
        }
        return index;
    }
}
