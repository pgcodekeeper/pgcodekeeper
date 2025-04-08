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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Alter_authorizationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Class_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class AlterMsAuthorization extends MsParserAbstract {

    private final Alter_authorizationContext ctx;
    private final Map<PgStatement, StatementOverride> overrides;

    public AlterMsAuthorization(Alter_authorizationContext ctx, MsDatabase db, ISettings settings) {
        this(ctx, db, null, settings);
    }

    public AlterMsAuthorization(Alter_authorizationContext ctx, MsDatabase db,
            Map<PgStatement, StatementOverride> overrides, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
        this.overrides = overrides;
    }

    @Override
    public void parseObject() {
        IdContext ownerId = ctx.id();
        if (settings.isIgnorePrivileges() || ownerId == null) {
            return;
        }
        String owner = ownerId.getText();

        Class_typeContext type = ctx.class_type();
        IdContext nameCtx = ctx.qualified_name().name;
        IdContext schemaCtx = ctx.qualified_name().schema;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);

        PgStatement st = null;
        if (type == null || type.OBJECT() != null || type.TYPE() != null) {
            AbstractSchema schema = getSchemaSafe(ids);
            st = getSafe((k, v) -> k.getChildren().filter(
                    e -> e.getBareName().equals(v))
                    .findAny().orElse(null), schema, nameCtx);

            // when type is not defined (sometimes in ref mode), suppose it is a table
            addObjReference(Arrays.asList(schemaCtx, nameCtx),
                    st != null ? st.getStatementType() : DbObjType.TABLE, ACTION_ALTER);
        } else if (type.ASSEMBLY() != null) {
            st = getSafe(MsDatabase::getAssembly, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.ASSEMBLY, ACTION_ALTER);
        } else if (type.ROLE() != null) {
            st = getSafe(MsDatabase::getRole, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.ROLE, ACTION_ALTER);
        } else if (type.SCHEMA() != null) {
            st = getSafe(MsDatabase::getSchema, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.SCHEMA, ACTION_ALTER);
        }

        if (st != null) {
            setOwner(st, owner);
        }
    }

    private void setOwner(PgStatement st, String owner) {
        if (overrides == null) {
            st.setOwner(owner);
        } else {
            overrides.computeIfAbsent(st, k -> new StatementOverride()).setOwner(owner);
        }
    }

    @Override
    protected String getStmtAction() {
        return new StringBuilder(ACTION_ALTER).append(" AUTHORIZATION").toString();
    }
}
