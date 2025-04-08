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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Drop_stmtContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class DropChStatement extends ChParserAbstract {

    private final Drop_stmtContext ctx;

    public DropChStatement(Drop_stmtContext ctx, ChDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        var element = ctx.drop_element();
        if (element.DATABASE() != null) {
            addObjReference(Arrays.asList(ctx.drop_element().name_with_cluster().identifier()),
                    DbObjType.SCHEMA, ACTION_DROP);
        } else if (element.VIEW() != null) {
            addObjReference(getIdentifiers(element.qualified_name()), DbObjType.VIEW, ACTION_DROP);
        } else if (element.TABLE() != null) {
            PgObjLocation loc = addObjReference(getIdentifiers(element.qualified_name()), DbObjType.TABLE, ACTION_DROP);
            loc.setWarning(DangerStatement.DROP_TABLE);
        } else if (element.FUNCTION() != null) {
            addObjReference(Arrays.asList(ctx.drop_element().name_with_cluster().identifier()),
                    DbObjType.FUNCTION, ACTION_DROP);
        } else if (element.ROLE() != null) {
            for (var elementCtx : element.identifier_list().identifier()) {
                addObjReference(Arrays.asList(elementCtx), DbObjType.ROLE, ACTION_DROP);
            }
        } else if (element.USER() != null) {
            for (var elementCtx : element.identifier_list().identifier()) {
                addObjReference(Arrays.asList(elementCtx), DbObjType.USER, ACTION_DROP);
            }
        }
    }

    @Override
    protected String getStmtAction() {
        var element = ctx.drop_element();
        DbObjType type = null;
        List<ParserRuleContext> ids = null;
        if (element.DATABASE() != null) {
            type = DbObjType.SCHEMA;
            ids = Arrays.asList(element.name_with_cluster().identifier());
        } else if (element.VIEW() != null) {
            type = DbObjType.VIEW;
            ids = getIdentifiers(element.qualified_name());
        } else if (element.TABLE() != null) {
            type = DbObjType.TABLE;
            ids = getIdentifiers(element.qualified_name());
        } else if (element.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
            ids = Arrays.asList(element.name_with_cluster().identifier());
        } else if (element.ROLE() != null) {
            return "DROP ROLE";
        } else if (element.USER() != null) {
            return "DROP USER";
        }

        return type != null && ids != null ? getStrForStmtAction(ACTION_DROP, type, ids) : null;
    }

}