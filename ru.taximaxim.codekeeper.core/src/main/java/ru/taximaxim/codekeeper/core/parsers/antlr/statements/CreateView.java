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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;


import java.text.MessageFormat;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_view_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Table_spaceContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgView;

public class CreateView extends ParserAbstract {

    private static final String RECURSIVE_PATTERN = "CREATE VIEW {0} "
            + "\nAS WITH RECURSIVE {0}({1}) AS ("
            + "\n{2}\n)"
            + "\nSELECT {1}"
            + "\nFROM {0};";

    private final Create_view_statementContext context;
    private final String tablespace;
    private final String accessMethod;
    private final CommonTokenStream stream;

    public CreateView(Create_view_statementContext context, PgDatabase db,
            String tablespace, String accessMethod, CommonTokenStream stream) {
        super(db);
        this.context = context;
        this.tablespace = tablespace;
        this.accessMethod = accessMethod;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        Create_view_statementContext ctx = context;
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        ParserRuleContext name = QNameParser.getFirstNameCtx(ids);
        PgView view = new PgView(name.getText());
        if (ctx.MATERIALIZED() != null) {
            view.setIsWithData(ctx.NO() == null);
            Table_spaceContext space = ctx.table_space();
            if (space != null) {
                view.setTablespace(space.identifier().getText());
            } else if (tablespace != null) {
                view.setTablespace(tablespace);
            }
            if (ctx.USING() != null) {
                view.setMethod(ctx.identifier().getText());
            } else if (accessMethod != null) {
                view.setMethod(accessMethod);
            }
        } else if (ctx.RECURSIVE() != null) {
            String sql = MessageFormat.format(RECURSIVE_PATTERN,
                    ParserAbstract.getFullCtxText(name),
                    ParserAbstract.getFullCtxText(ctx.column_names.identifier()),
                    ParserAbstract.getFullCtxText(ctx.v_query));

            ctx = AntlrParser.parseSqlString(SQLParser.class, SQLParser::sql, sql, "recursive view", null)
                    .statement(0).schema_statement().schema_create().create_view_statement();
        }
        Select_stmtContext vQuery = ctx.v_query;
        if (vQuery != null) {
            view.setQuery(getFullCtxText(vQuery), AntlrUtils.normalizeWhitespaceUnquoted(vQuery, stream));
            db.addAnalysisLauncher(new ViewAnalysisLauncher(view, vQuery, fileName));
        }
        if (ctx.column_names != null) {
            for (IdentifierContext column : ctx.column_names.identifier()) {
                view.addColumnName(column.getText());
            }
        }
        Storage_parametersContext storage = ctx.storage_parameters();
        if (storage != null){
            List <Storage_parameter_optionContext> options = storage.storage_parameter_option();
            for (Storage_parameter_optionContext option: options){
                String key = option.storage_parameter_name().getText();
                VexContext value = option.vex();
                ParserAbstract.fillOptionParams(value != null ? value.getText() : "", key , false, view::addOption);
            }
        }
        if (ctx.with_check_option() != null){
            view.addOption(PgView.CHECK_OPTION,
                    ctx.with_check_option().LOCAL() != null ? "local" : "cascaded");
        }

        addSafe(getSchemaSafe(ids), view, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, getIdentifiers(context.name));
    }
}
