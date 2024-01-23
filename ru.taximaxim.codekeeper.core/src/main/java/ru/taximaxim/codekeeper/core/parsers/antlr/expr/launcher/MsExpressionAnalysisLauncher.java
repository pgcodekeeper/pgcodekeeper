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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Sql_clausesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsExprWithNmspc;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsValueExpr;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class MsExpressionAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsExpressionAnalysisLauncher(PgStatementWithSearchPath stmt,
            ExpressionContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        if (stmt instanceof AbstractColumn) {
            var expr = new MsExprWithNmspc(stmt.getSchemaName(), meta);
            PgStatement table = stmt.getParent();
            String schemaName = table.getParent().getName();
            String rawTableReference = table.getName();

            expr.addRawTableReference(new GenericColumn(schemaName, rawTableReference, DbObjType.TABLE));
            return analyze((ExpressionContext) ctx, expr);
        }
        MsValueExpr expr = new MsValueExpr(stmt.getSchemaName(), meta);
        return analyze((ExpressionContext) ctx, expr);
    }
}