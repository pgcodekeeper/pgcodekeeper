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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Class_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Columns_permissionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Name_list_in_bracketsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Object_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Rule_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_column_privilegesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;

public class GrantMsPrivilege extends ParserAbstract {
    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;
    private final Map<PgStatement, StatementOverride> overrides;

    public GrantMsPrivilege(Rule_commonContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public GrantMsPrivilege(Rule_commonContext ctx, PgDatabase db, Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
        if (ctx.DENY() != null) {
            state = "DENY";
        } else {
            state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
        }

        isGO = ctx.WITH() != null;
    }

    @Override
    public void parseObject() {
        Object_typeContext nameCtx = ctx.object_type();
        // unsupported rules without object names
        if (db.getArguments().isIgnorePrivileges() || nameCtx == null) {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        List<String> roles = ctx.name_list().id().stream()
                .map(ParserRuleContext::getText).map(MsDiffUtils::quoteName).collect(Collectors.toList());

        Columns_permissionsContext columnsCtx = ctx.columns_permissions();
        if (columnsCtx != null) {
            parseColumns(columnsCtx, nameCtx, roles);
            return;
        }

        List<String> permissions = ctx.permissions().permission().stream()
                .map(ParserAbstract::getFullCtxText).collect(Collectors.toList());

        PgStatement st = getStatement(nameCtx);

        if (st == null) {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        addObjReference(getIdentifiers(nameCtx.qualified_name()), st.getStatementType(), state);

        StringBuilder name = new StringBuilder();
        if (st.getStatementType() == DbObjType.TYPE || !(st instanceof PgStatementWithSearchPath)) {
            name.append(st.getStatementType()).append("::");
        }

        name.append(st.getQualifiedName());
        Name_list_in_bracketsContext columns = nameCtx.name_list_in_brackets();

        // 1 privilege for each role
        for (String role : roles) {
            // 1 privilege for each permission
            for (String per : permissions) {
                if (columns == null) {
                    addPrivilege(st, new PgPrivilege(state, per, name.toString(), role, isGO));
                    continue;
                }

                // column privileges
                for (IdContext column : columns.id()) {
                    name.append('(').append(MsDiffUtils.quoteName(column.getText())).append(')');
                    PgPrivilege priv = new PgPrivilege(state, per, name.toString(), role, isGO);
                    // table column privileges to columns, other columns to statement
                    if (st instanceof AbstractTable) {
                        addPrivilege(getSafe(AbstractTable::getColumn, (AbstractTable) st, column), priv);
                    } else {
                        addPrivilege(st, priv);
                    }
                }
            }
        }
    }

    private PgStatement getStatement(Object_typeContext object) {
        IdContext nameCtx = object.qualified_name().name;
        Class_typeContext type = object.class_type();

        PgStatement st;
        if (type == null || type.OBJECT() != null || type.TYPE() != null) {
            AbstractSchema schema = getSchemaSafe(
                    Arrays.asList(object.qualified_name().schema, nameCtx));
            st = getSafe((k, v) -> k.getChildren().filter(
                    e -> e.getBareName().equals(v))
                    .findAny().orElse(null), schema, nameCtx);
        } else if (type.ASSEMBLY() != null) {
            st = getSafe(PgDatabase::getAssembly, db, nameCtx);
        } else if (type.ROLE() != null) {
            st = getSafe(PgDatabase::getRole, db, nameCtx);
        } else if (type.USER() != null) {
            st = getSafe(PgDatabase::getUser, db, nameCtx);
        } else if (type.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
        } else {
            return null;
        }

        return st;
    }

    private void parseColumns(Columns_permissionsContext columnsCtx,
            Object_typeContext nameCtx, List<String> roles) {
        // собрать информацию о привилегиях на колонки
        Map<String, Entry<IdContext, List<String>>> colPriv = new HashMap<>();
        for (Table_column_privilegesContext priv : columnsCtx.table_column_privileges()) {
            String privName = getFullCtxText(priv.permission());
            for (IdContext col : priv.name_list_in_brackets().id()) {
                colPriv.computeIfAbsent(col.getText(),
                        k -> new SimpleEntry<>(col, new ArrayList<>())).getValue().add(privName);
            }
        }

        setColumnPrivilege(nameCtx, colPriv, roles);
    }

    private void setColumnPrivilege(Object_typeContext nameCtx,
            Map<String, Entry<IdContext, List<String>>> colPrivs,
            List<String> roles) {
        PgStatement st = getStatement(nameCtx);

        if (st == null) {
            return;
        }

        // 1 permission for 1 column = 1 privilege
        for (Entry<String, Entry<IdContext, List<String>>> colPriv : colPrivs.entrySet()) {
            for (String pr : colPriv.getValue().getValue()) {

                IdContext col = colPriv.getValue().getKey();
                String objectName = st.getQualifiedName()
                        + " (" + MsDiffUtils.quoteName(col.getText()) + ')';

                for (String role : roles) {
                    PgPrivilege priv = new PgPrivilege(state, pr, objectName, role, isGO);
                    if (st instanceof AbstractTable) {
                        addPrivilege(getSafe(AbstractTable::getColumn, (AbstractTable) st, col), priv);
                    } else {
                        addPrivilege(st, priv);
                    }
                }
            }
        }
    }

    private void addPrivilege(PgStatement st, PgPrivilege privilege) {
        if (overrides == null) {
            st.addPrivilege(privilege);
        } else {
            overrides.computeIfAbsent(st,
                    k -> new StatementOverride()).addPrivilege(privilege);
        }
    }

    @Override
    protected String getStmtAction() {
        return state;
    }
}