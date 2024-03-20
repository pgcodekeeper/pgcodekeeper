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

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_table_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Primary_key_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_element_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_projection_defContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChTable;

public class CreateChTable extends ChParserAbstract {

    private Create_table_stmtContext ctx;

    public CreateChTable(Create_table_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.qualified_name());
        String name = QNameParser.getFirstName(ids);
        ChTable table = new ChTable(name);
        parseObject(table);
        addSafe(getSchemaSafe(ids), table, ids);
    }

    public void parseObject(ChTable table) {
        for (Table_element_exprContext elementCtx : ctx.table_body_expr().table_element_expr()) {
            parseTableElement(table, elementCtx);
        }
        table.setEngine(getEnginePart(ctx.table_body_expr().engine_clause()));
        if (ctx.comment_expr() != null) {
            table.setComment(ctx.comment_expr().STRING_LITERAL().getText());
        }
    }

    private void parseTableElement(ChTable table, Table_element_exprContext elementCtx) {
        Table_column_defContext columnCtx = elementCtx.table_column_def();
        Primary_key_clauseContext pk;
        Table_projection_defContext proj;
        if (columnCtx != null) {
            table.addColumn(getColumn(columnCtx));
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

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, ctx.qualified_name());
    }

}
