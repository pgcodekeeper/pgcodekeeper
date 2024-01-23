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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Enable_disable_triggerContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Names_referencesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.ms.MsTrigger;

public class DisableMsTrigger extends MsParserAbstract {

    private final Enable_disable_triggerContext ctx;

    public DisableMsTrigger(Enable_disable_triggerContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Names_referencesContext triggers = ctx.names_references();
        Qualified_nameContext parent = ctx.qualified_name();
        if (triggers == null || parent == null) {
            return;
        }

        IdContext schemaCtx = parent.schema;
        PgStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                getSchemaSafe(Arrays.asList(schemaCtx, parent.name)), parent.name);
        addObjReference(Arrays.asList(parent.schema, parent.name),
                DbObjType.TABLE, null);

        for (Qualified_nameContext qname : triggers.qualified_name()) {
            MsTrigger trig = (MsTrigger) getSafe(PgStatementContainer::getTrigger,
                    cont, qname.name);
            addObjReference(Arrays.asList(schemaCtx, parent.name, qname.name),
                    DbObjType.TRIGGER, ACTION_ALTER);
            if (ctx.DISABLE() != null) {
                doSafe(MsTrigger::setDisable, trig, true);
            }
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        StringBuilder sb = new StringBuilder();
        Enable_disable_triggerContext ctxEnableDisableTr = (Enable_disable_triggerContext) ctx;
        sb.append(ctxEnableDisableTr.DISABLE() != null ? "DISABLE " : "ENABLE ")
        .append("TRIGGER");

        Names_referencesContext triggers = ctxEnableDisableTr.names_references();
        Qualified_nameContext parent = ctxEnableDisableTr.qualified_name();

        if (triggers != null && parent != null) {
            sb.append(' ');

            String schemaName = parent.schema.getText();
            String parentName = parent.name.getText();

            for (Qualified_nameContext qname : triggers.qualified_name()) {
                sb.append(schemaName)
                .append('.').append(parentName)
                .append('.').append(qname.name.getText())
                .append(", ");
            }

            sb.setLength(sb.length() - 2);
        }

        PgObjLocation loc = new PgObjLocation.Builder()
                .setAction(sb.toString())
                .setCtx(ctx)
                .setSql(getFullCtxText(ctx))
                .build();

        db.addReference(fileName, loc);
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return null;
    }
}
