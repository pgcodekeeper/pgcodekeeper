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
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ChViewAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_live_view_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_mat_view_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_simple_view_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_view_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Definer_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Sql_security_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_schema_clauseContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChView;
import ru.taximaxim.codekeeper.core.schema.ch.ChView.ChViewType;

public class CreateChView extends ChParserAbstract {

    private Create_view_stmtContext ctx;
    private CommonTokenStream stream;

    public CreateChView(Create_view_stmtContext ctx, ChDatabase db, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.stream = stream;
    }

    private Qualified_nameContext getQname() {
        var simpleViewCtx = ctx.create_simple_view_stmt();
        if (simpleViewCtx != null) {
            return simpleViewCtx.qualified_name();
        }

        var matViewCtx = ctx.create_mat_view_stmt();
        if (matViewCtx != null) {
            return matViewCtx.qualified_name();
        }

        return ctx.create_live_view_stmt().qualified_name();
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(getQname());
        String name = QNameParser.getFirstName(ids);
        ChView view = new ChView(name);
        parseObject(view);
        addSafe(getSchemaSafe(ids), view, ids);
    }

    public void parseObject(ChView view) {
        var vQuery = ctx.subquery_clause();
        if (vQuery != null) {
            view.setQuery(getQuery(vQuery), AntlrUtils.normalizeWhitespaceUnquoted(vQuery, stream, getDbType()));
            db.addAnalysisLauncher(new ChViewAnalysisLauncher(view, vQuery, fileName));
        }

        var commentCtx = ctx.comment_expr();
        if (commentCtx != null) {
            view.setComment(commentCtx.STRING_LITERAL().getText());
        }

        var simpleViewCtx = ctx.create_simple_view_stmt();
        if (simpleViewCtx != null) {
            parseSimpleView(simpleViewCtx, view);
            return;
        }
        Create_mat_view_stmtContext matViewCtx = ctx.create_mat_view_stmt();
        if ((matViewCtx) != null) {
            parseMatView(matViewCtx, view);
            return;
        }

        parseLiveView(ctx.create_live_view_stmt(), view);
    }

    private void parseSimpleView(Create_simple_view_stmtContext simpleViewCtx, ChView view) {
        view.setType(ChViewType.SIMPLE);
        fillColumns(simpleViewCtx.table_schema_clause(), view);

        setDefiner(simpleViewCtx.definer_clause(), view);
        setSqlSecurity(simpleViewCtx.sql_security_clause(), view);
    }

    private void parseLiveView(Create_live_view_stmtContext liveViewStmtCtx, ChView view) {
        view.setType(ChViewType.LIVE);
        if (liveViewStmtCtx.REFRESH() != null) {
            view.setWithRefresh(true);

            var period = liveViewStmtCtx.NUMBER();
            if (period != null) {
                view.setRefreshPeriod(Integer.parseInt(period.getText()));
            }
        }
        fillColumns(liveViewStmtCtx.table_schema_clause(), view);
    }

    private void parseMatView(Create_mat_view_stmtContext matViewCtx, ChView view) {
        view.setType(ChViewType.MATERIALIZED);
        fillColumns(matViewCtx.table_schema_clause(), view);

        var destCtx = matViewCtx.destination_clause();
        if (destCtx != null) {
            var qnameCtx = destCtx.qualified_name();
            var ids = getIdentifiers(qnameCtx);
            addDepSafe(view, ids, DbObjType.TABLE);
            view.setDestination(getFullCtxText(qnameCtx));
        }

        view.setEngine(getEnginePart(matViewCtx.engine_clause()));

        setDefiner(matViewCtx.definer_clause(), view);
        setSqlSecurity(matViewCtx.sql_security_clause(), view);
    }

    private void fillColumns(Table_schema_clauseContext tableSchemaCtx, ChView view) {
        if (tableSchemaCtx == null) {
            return;
        }

        for (var tableElementCtx : tableSchemaCtx.table_element_expr()) {
            Table_column_defContext columnCtx = tableElementCtx.table_column_def();
            if (columnCtx != null) {
                view.addColumn(getColumn(columnCtx));
            }
        }
    }

    private void setDefiner(Definer_clauseContext definerClauseCtx, ChView view) {
        if (definerClauseCtx == null) {
            return;
        }

        view.setDefiner(definerClauseCtx.identifier().getText());
    }

    private void setSqlSecurity(Sql_security_clauseContext sqlSecurityCtx, ChView view) {
        if (sqlSecurityCtx == null) {
            return;
        }

        view.setSqlSecurity(sqlSecurityCtx.sec.getText().toUpperCase(Locale.ROOT));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, getQname());
    }
}
