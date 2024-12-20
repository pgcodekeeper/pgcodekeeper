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

import java.util.Arrays;
import java.util.Locale;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_event_trigger_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Event_trigger_filter_variablesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_name_nontypeContext;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgEventTrigger;

public class CreateEventTrigger extends PgParserAbstract {

    private static final String TAG = "tag";
    private final Create_event_trigger_statementContext ctx;

    public CreateEventTrigger(Create_event_trigger_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        PgEventTrigger eventTrigger = new PgEventTrigger(ctx.name.getText());
        eventTrigger.setEvent(ctx.event.getText());

        if (ctx.WHEN() != null) {
            for (Event_trigger_filter_variablesContext etFiltersCtx : ctx.event_trigger_filter_variables()) {
                if (TAG.equals(etFiltersCtx.identifier().getText().toLowerCase(Locale.ROOT))) {
                    for (Character_stringContext charCtx : etFiltersCtx.filter_values) {
                        eventTrigger.addTag(charCtx.getText());
                    }
                }
            }
        }

        eventTrigger.setExecutable(getFullCtxText(ctx.func_name));

        Schema_qualified_name_nontypeContext funcNameCtx = ctx.func_name.schema_qualified_name_nontype();
        if (funcNameCtx.schema != null) {
            addDepSafe(eventTrigger, getIdentifiers(funcNameCtx), DbObjType.FUNCTION, "()");
        }
        addSafe(db, eventTrigger, Arrays.asList(ctx.name));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.EVENT_TRIGGER, Arrays.asList(ctx.name));
    }
}
