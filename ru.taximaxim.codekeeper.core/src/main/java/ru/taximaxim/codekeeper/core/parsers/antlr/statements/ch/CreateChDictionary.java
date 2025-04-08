/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_dictinary_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Dictionary_optionContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChDictionary;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class CreateChDictionary extends ChParserAbstract {

    private final Create_dictinary_stmtContext ctx;

    public CreateChDictionary(Create_dictinary_stmtContext ctx, ChDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.qualified_name());
        String name = QNameParser.getFirstName(ids);
        ChDictionary dictionary = new ChDictionary(name);
        parseObject(dictionary);
        addSafe(getSchemaSafe(ids), dictionary, ids);
    }

    public void parseObject(ChDictionary dictionary) {
        for (var attrCtx : ctx.dictionary_attr_def()) {
            var col = new ChColumn(attrCtx.identifier().getText());
            col.setType(getFullCtxText(attrCtx.data_type()));
            if (attrCtx.DEFAULT() != null) {
                col.setDefaultType("DEFAULT");
                col.setDefaultValue(getFullCtxText(attrCtx.literal()));
            } else if (attrCtx.EXPRESSION() != null) {
                col.setDefaultType("EXPRESSION");
                col.setDefaultValue(getFullCtxText(attrCtx.expr()));
            }
            var attrOptCtx = attrCtx.attr_def_option();
            if (attrOptCtx != null) {
                col.setOption(attrOptCtx.getText());
            }
            dictionary.addColumn(col);
        }
        if (ctx.PRIMARY() != null) {
            dictionary.setPk(getFullCtxText(ctx.expr_list()));
        }
        for (var optionCtx : ctx.dictionary_option()) {
            parseOption(optionCtx, dictionary);
        }
        var commentCtx = ctx.comment_expr();
        if (commentCtx != null) {
            dictionary.setComment(commentCtx.STRING_LITERAL().getText());
        }
    }

    private void parseOption(Dictionary_optionContext option, ChDictionary dictionary) {
        if (option.SOURCE() != null) {
            parseSource(option, dictionary);
            return;
        }

        if (option.LIFETIME() != null) {
            dictionary.setLifeTime(getFullCtxText(option.life_time_expr()));
            return;
        }

        if (option.LAYOUT() != null) {
            dictionary.setLayOut(getFullCtxText(option.layout_expr()));
            return;
        }

        if (option.RANGE() != null) {
            dictionary.setRange(getFullCtxText(option.range_expr()));
            return;
        }

        if (option.SETTINGS() != null) {
            for (var optionCtx : option.pairs().pair()) {
                dictionary.addOption(optionCtx.identifier().getText(), getFullCtxText(optionCtx.expr()));
            }
        }
    }

    private void parseSource(Dictionary_optionContext option, ChDictionary dictionary) {
        var sourceType = option.identifier().getText();
        dictionary.setSourceType(sourceType);
        String sourceTableName = null;
        String sourceDbName = null;
        for (var argCtx : option.dictionary_arg_expr()) {
            String value = getFullCtxText(argCtx.dictionary_arg_value());
            String key = argCtx.identifier().getText();
            dictionary.addSource(key, value);

            if ("clickhouse".equalsIgnoreCase(sourceType)) {
                if ("table".equalsIgnoreCase(key)) {
                    sourceTableName = value.replace("\'", "");
                } else if ("db".equalsIgnoreCase(key)) {
                    sourceDbName = value.replace("\'", "");
                }
            }
        }

        if (sourceTableName != null) {
            if (sourceDbName == null) {
                sourceDbName = "default";
            }
            dictionary.addDep(new GenericColumn(sourceDbName, sourceTableName, DbObjType.TABLE));
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DICTIONARY, ctx.qualified_name());
    }
}