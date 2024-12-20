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

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.StatisticsAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_statistics_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgStatistics;

public class CreateStatistics extends PgParserAbstract {

    private final Create_statistics_statementContext ctx;
    private final CommonTokenStream stream;

    public CreateStatistics(Create_statistics_statementContext ctx, PgDatabase db, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        Schema_qualified_nameContext nameCtx = ctx.name;
        if (nameCtx == null) {
            return;
        }

        List<ParserRuleContext> ids = getIdentifiers(nameCtx);
        String name = QNameParser.getFirstName(ids);
        PgStatistics stat = new PgStatistics(name);

        parseStatistics(stat);

        addSafe(getSchemaSafe(ids), stat, ids);
    }

    public void parseStatistics(PgStatistics stat) {
        if (ctx.kind != null) {
            for (IdentifierContext k : ctx.kind.identifier()) {
                stat.addKind(k.getText());
            }
        }

        List<ParserRuleContext> tableIds = getIdentifiers(ctx.table_name);
        stat.setForeignSchema(QNameParser.getSchemaName(tableIds));
        stat.setForeignTable(QNameParser.getFirstName(tableIds));

        for (VexContext vex : ctx.vex()) {
            stat.addExpr(getExpressionText(vex, stream));
            db.addAnalysisLauncher(new StatisticsAnalysisLauncher(stat, vex, fileName));
        }

        addDepSafe(stat, tableIds, DbObjType.TABLE);
    }


    @Override
    protected String getStmtAction() {
        var nameCtx = ctx.name;
        if (nameCtx == null) {
            return ACTION_CREATE + ' ' + DbObjType.STATISTICS;
        }

        return getStrForStmtAction(ACTION_CREATE, DbObjType.STATISTICS, getIdentifiers(nameCtx));
    }
}
