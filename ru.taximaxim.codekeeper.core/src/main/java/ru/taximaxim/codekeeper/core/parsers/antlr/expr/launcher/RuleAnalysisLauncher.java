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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Delete;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Insert;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Select;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Update;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.ValueExprWithNmspc;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_rewrite_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Rewrite_commandContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Update_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgRule;

public class RuleAnalysisLauncher extends AbstractAnalysisLauncher {

    public RuleAnalysisLauncher(PgRule stmt, Create_rewrite_statementContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Set<PgObjLocation> depcies = new LinkedHashSet<>();

        Create_rewrite_statementContext createRewriteCtx = (Create_rewrite_statementContext) ctx;

        if (createRewriteCtx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(meta);
            depcies.addAll(analyzeTableChild(createRewriteCtx.vex(), vex));
        }

        for (Rewrite_commandContext cmd : createRewriteCtx.rewrite_command()) {
            depcies.addAll(analyzeRulesCommand(cmd, meta));
        }

        return depcies;
    }

    private Set<PgObjLocation> analyzeRulesCommand(Rewrite_commandContext cmd, MetaContainer meta) {
        Select_stmtContext select;
        if ((select = cmd.select_stmt()) != null) {
            return analyzeTableChild(select, new Select(meta));
        }

        Insert_stmt_for_psqlContext insert;
        if ((insert = cmd.insert_stmt_for_psql()) != null) {
            return analyzeTableChild(insert, new Insert(meta));
        }

        Delete_stmt_for_psqlContext delete;
        if ((delete = cmd.delete_stmt_for_psql()) != null) {
            return analyzeTableChild(delete, new Delete(meta));
        }

        Update_stmt_for_psqlContext update;
        if ((update = cmd.update_stmt_for_psql()) != null) {
            return analyzeTableChild(update, new Update(meta));
        }
 
        return Collections.emptySet();
    }
}
