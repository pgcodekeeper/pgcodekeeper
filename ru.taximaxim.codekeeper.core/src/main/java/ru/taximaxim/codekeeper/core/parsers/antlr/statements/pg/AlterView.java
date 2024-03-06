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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_view_actionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_view_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgView;

public class AlterView extends PgParserAbstract {

    private final Alter_view_statementContext ctx;
    private final CommonTokenStream stream;

    public AlterView(Alter_view_statementContext ctx, PgDatabase db, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgView dbView = (PgView) getSafe(AbstractSchema::getView,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));
        Alter_view_actionContext action = ctx.alter_view_action();
        if (action.set_def_column() != null) {
            VexContext exp = action.set_def_column().vex();
            doSafe((s,o) -> {
                s.addColumnDefaultValue(getFullCtxText(action.column_name), getExpressionText(exp, stream));
                db.addAnalysisLauncher(new VexAnalysisLauncher(s, exp, fileName));
            }, dbView, null);
        }
        if (action.drop_def() != null) {
            doSafe(PgView::removeColumnDefaultValue, dbView, getFullCtxText(action.column_name));
        }

        addObjReference(ids, DbObjType.VIEW, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.VIEW, getIdentifiers(ctx.name));
    }
}
