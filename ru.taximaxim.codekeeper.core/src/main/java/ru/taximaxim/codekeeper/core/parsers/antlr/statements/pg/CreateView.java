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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.text.MessageFormat;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_view_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_spaceContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgView;
import ru.taximaxim.codekeeper.core.schema.pg.MaterializedPgView;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgView;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class CreateView extends PgParserAbstract {

    private static final String RECURSIVE_PATTERN = """
        CREATE VIEW {0}
        AS WITH RECURSIVE {0}({1}) AS (
        {2}
        )
        SELECT {1}
        FROM {0};""";

    private final Create_view_statementContext context;
    private final String tablespace;
    private final String accessMethod;
    private final CommonTokenStream stream;

    public CreateView(Create_view_statementContext context, PgDatabase db,
            String tablespace, String accessMethod, CommonTokenStream stream, ISettings settings) {
        super(db, settings);
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
        AbstractPgView view = new PgView(name.getText());
        if (ctx.MATERIALIZED() != null) {
            var matV = new MaterializedPgView(name.getText());
            matV.setIsWithData(ctx.NO() == null);
            Table_spaceContext space = ctx.table_space();
            if (space != null) {
                matV.setTablespace(space.identifier().getText());
            } else if (tablespace != null) {
                matV.setTablespace(tablespace);
            }
            if (ctx.USING() != null) {
                matV.setMethod(ctx.identifier().getText());
            } else if (accessMethod != null) {
                matV.setMethod(accessMethod);
            }
            if (ctx.distributed_clause() != null) {
                matV.setDistribution(parseDistribution(ctx.distributed_clause()));
            }
            view = matV;
        } else if (ctx.RECURSIVE() != null) {
            String sql = MessageFormat.format(RECURSIVE_PATTERN,
                    getFullCtxText(name), getFullCtxText(ctx.column_names.identifier()), getFullCtxText(ctx.v_query));

            var parser = AntlrParser.createSQLParser(sql, "recursive view", null);
            ctx = parser.sql().statement(0).schema_statement().schema_create().create_view_statement();
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
                fillOptionParams(value != null ? value.getText() : "", key, false, view::addOption);
            }
        }
        if (ctx.with_check_option() != null){
            view.addOption(AbstractPgView.CHECK_OPTION,
                    ctx.with_check_option().LOCAL() != null ? "local" : "cascaded");
        }

        addSafe(getSchemaSafe(ids), view, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, getIdentifiers(context.name));
    }
}
