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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.EnumSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Sql_clausesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsSelect;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsSqlClauses;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsValueExpr;
import ru.taximaxim.codekeeper.core.schema.AbstractMsFunction;
import ru.taximaxim.codekeeper.core.schema.MsTrigger;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class MsFuncProcTrigAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            Sql_clausesContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            Select_statementContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            ExpressionContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(MsTrigger stmt,
            Sql_clausesContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        String schema = stmt.getSchemaName();

        if (ctx instanceof Sql_clausesContext) {
            MsSqlClauses clauses = new MsSqlClauses(schema);
            clauses.analyze((Sql_clausesContext) ctx);
            return clauses.getDepcies();
        }

        if (ctx instanceof Select_statementContext) {
            MsSelect select = new MsSelect(schema);
            return analyze((Select_statementContext) ctx, select);
        }

        MsValueExpr expr = new MsValueExpr(schema);
        return analyze((ExpressionContext) ctx, expr);
    }

    @Override
    protected EnumSet<DbObjType> getDisabledDepcies() {
        PgDiffArguments args = stmt.getDatabase().getArguments();
        if (!args.isEnableFunctionBodiesDependencies()) {
            return EnumSet.of(DbObjType.FUNCTION, DbObjType.PROCEDURE);
        }

        return super.getDisabledDepcies();
    }
}
