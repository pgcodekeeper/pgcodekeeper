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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsFuncProcTrigAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_or_alter_triggerContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.ms.MsTrigger;

public class CreateMsTrigger extends BatchContextProcessor {

    private final Create_or_alter_triggerContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsTrigger(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_trigger();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.table_name;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, ctx.table_name.name);
        addObjReference(ids, DbObjType.TABLE, null);
        getObject(getSchemaSafe(ids), false);
    }

    public MsTrigger getObject(AbstractSchema schema, boolean isJdbc) {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        IdContext tableNameCtx = ctx.table_name.name;
        IdContext nameCtx = ctx.trigger_name.name;

        MsTrigger trigger = new MsTrigger(nameCtx.getText());
        trigger.setAnsiNulls(ansiNulls);
        trigger.setQuotedIdentified(quotedIdentifier);
        setSourceParts(trigger);

        if (schema == null) {
            addObjReference(Arrays.asList(schemaCtx, tableNameCtx), DbObjType.TABLE, null);
        }

        db.addAnalysisLauncher(new MsFuncProcTrigAnalysisLauncher(trigger,
                ctx.sql_clauses(), fileName));

        PgStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                schema, tableNameCtx);

        if (isJdbc && schema != null) {
            cont.addTrigger(trigger);
        } else {
            addSafe(cont, trigger,
                    Arrays.asList(schemaCtx, tableNameCtx, nameCtx));
        }
        return trigger;
    }

    @Override
    protected String getStmtAction() {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TRIGGER,
                Arrays.asList(schemaCtx, ctx.table_name.name, ctx.trigger_name.name));
    }
}
