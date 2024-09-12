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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Columns_permissionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Privilegy_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;

public class GrantChPrivilege extends ChParserAbstract {

    private final Privilegy_stmtContext ctx;
    private final String state;
    private final Map<PgStatement, StatementOverride> overrides;

    public GrantChPrivilege(Privilegy_stmtContext ctx, ChDatabase db, Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
        state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
    }

    @Override
    public void parseObject() {
        if (db.getArguments().isIgnorePrivileges() || isRefMode()) {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        var usersOrRoles = getUsersOrRoles();
        boolean isGrantOption = ctx.with_option().stream().anyMatch(el -> el.GRANT() != null);

        for (var priv : ctx.privileges().privilege()) {
            String objectName = getFullCtxText(priv.names_references());

            //parsed columns
            Columns_permissionsContext columnsCtx = priv.columns_permissions();
            if (columnsCtx != null) {
                parseColumns(columnsCtx, objectName, usersOrRoles, isGrantOption);
                return;
            }

            List<String> permissions = priv.permissions().permission().stream()
                    .map(ParserAbstract::getFullCtxText)
                    .map(e -> e.toUpperCase(Locale.ROOT))
                    .toList();

            // 1 privilege for each user or role
            for (var user : usersOrRoles) {
                var userName = user.getText();
                PgStatement st = getStatement(userName);
                if (st == null) {
                    continue;
                }
                addObjReference(Arrays.asList(user), st.getStatementType(), state);
                // 1 privilege for each permission
                for (String per : permissions) {
                    addPrivilege(st, new PgPrivilege(state, per, objectName,
                            ChDiffUtils.getQuotedName(userName), isGrantOption, DatabaseType.CH));
                }
            }
        }
    }

    private void parseColumns(Columns_permissionsContext columnsCtx, String objectName,
            List<IdentifierContext> usersOrRoles, boolean isGrantOption) {
        // collect information about column privileges
        Map<String, Entry<IdentifierContext, List<String>>> colPriv = new HashMap<>();
        for (var col : columnsCtx.table_column_privileges()) {
            String privName = getFullCtxText(col.permission()).toUpperCase(Locale.ROOT);
            for (var colName : col.identifier_list().identifier()) {
                colPriv.computeIfAbsent(colName.getText(), k -> new SimpleEntry<>(colName, new ArrayList<>()))
                .getValue().add(privName);
            }
        }
        setColumnPrivilege(objectName, colPriv, usersOrRoles, isGrantOption);
    }

    private void setColumnPrivilege(String objectName, Map<String, Entry<IdentifierContext, List<String>>> colPrivs,
            List<IdentifierContext> usersOrRoles, boolean isGrantOption) {
        for (Entry<String, Entry<IdentifierContext, List<String>>> colPriv : colPrivs.entrySet()) {
            StringBuilder permission = new StringBuilder();
            for (String priv : colPriv.getValue().getValue()) {
                permission.append(priv).append('(').append(colPriv.getValue().getKey().getText()).append("),");
            }
            permission.setLength(permission.length() - 1);

            for (var user : usersOrRoles) {
                var userName = user.getText();
                var st = getStatement(userName);
                if (st == null) {
                    continue;
                }

                addObjReference(Arrays.asList(user), st.getStatementType(), state);
                addPrivilege(st, new PgPrivilege(state, permission.toString(), objectName,
                        userName, isGrantOption, DatabaseType.CH));
            }
        }
    }

    // get user or role statement
    private PgStatement getStatement(String name) {
        PgStatement st = db.getUser(name);
        return st != null ? st : db.getRole(name);
    }

    private List<IdentifierContext> getUsersOrRoles() {
        // for skipping CURRENT_USER
        List<IdentifierContext> usersOrRoles = new ArrayList<>();
        var ids = ctx.users().roles;
        for (var user : ids.identifier()) {
            if ("CURRENT_USER".equalsIgnoreCase(user.getText())) {
                continue;
            }
            usersOrRoles.add(user);
        }
        return usersOrRoles;
    }

    private void addPrivilege(PgStatement st, PgPrivilege privilege) {
        if (overrides == null) {
            st.addPrivilege(privilege);
        } else {
            overrides.computeIfAbsent(st, k -> new StatementOverride()).addPrivilege(privilege);
        }
    }

    @Override
    protected String getStmtAction() {
        return state;
    }
}