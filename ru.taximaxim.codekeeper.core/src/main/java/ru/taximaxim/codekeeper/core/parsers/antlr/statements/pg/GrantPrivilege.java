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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Columns_permissionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Role_name_with_groupContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Rule_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Rule_member_objectContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_privilegesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class GrantPrivilege extends PgParserAbstract {
    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;
    private final Map<PgStatement, StatementOverride> overrides;

    public GrantPrivilege(Rule_commonContext ctx, PgDatabase db, ISettings settings) {
        this(ctx, db, null, settings);
    }

    public GrantPrivilege(Rule_commonContext ctx, PgDatabase db, Map<PgStatement, StatementOverride> overrides,
            ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
        this.overrides = overrides;
        state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
        isGO = ctx.OPTION() != null;
    }

    @Override
    public void parseObject() {
        Rule_member_objectContext obj = ctx.rule_member_object();
        // unsupported roles rules, ALL TABLES/SEQUENCES/FUNCTIONS IN SCHENA
        if (settings.isIgnorePrivileges() || ctx.other_rules() != null || obj.ALL() != null) {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        List<String> roles = parseRoles();
        if (roles.isEmpty()) {
            return;
        }

        Columns_permissionsContext columnsCtx = ctx.columns_permissions();

        if (columnsCtx != null) {
            parseColumns(columnsCtx, roles);
            return;
        }

        String permissions = ctx.permissions().permission().stream()
                .map(ParserAbstract::getFullCtxText)
                .map(e -> e.toUpperCase(Locale.ROOT))
                .collect(Collectors.joining(","));

        if (obj.FUNCTION() != null || obj.PROCEDURE() != null) {
            parseFunction(obj, permissions, roles);
            return;
        }

        DbObjType type = null;
        if (obj.table_names != null) {
            type = DbObjType.TABLE;
        } else if (obj.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (obj.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (obj.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (obj.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (obj.FOREIGN() != null) {
            if (obj.SERVER() != null) {
                type = DbObjType.SERVER;
            } else if (obj.WRAPPER() != null) {
                type = DbObjType.FOREIGN_DATA_WRAPPER;
            }
        }

        if (type == null) {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        for (Schema_qualified_nameContext name : obj.names_references().schema_qualified_name()) {
            addObjReference(getIdentifiers(name), type, state);

            if (!isRefMode()) {
                addToDB(name, type, state, permissions, roles, isGO);
            }
        }
    }

    private List<String> parseRoles() {
        List<String> roles = new ArrayList<>();
        for (Role_name_with_groupContext roleCtx : ctx.roles_names().role_name_with_group()) {
            // skip CURRENT_USER and SESSION_USER
            IdentifierContext user = roleCtx.user_name().identifier();
            if (user == null) {
                continue;
            }
            String role = getFullCtxText(user);
            if (roleCtx.GROUP() != null) {
                role = "GROUP " + role;
            }

            roles.add(role);
        }

        return roles;
    }

    private void parseFunction(Rule_member_objectContext obj, String permissions, List<String> roles) {
        for (Function_parametersContext funct : obj.func_name) {
            List<ParserRuleContext> funcIds = getIdentifiers(funct.schema_qualified_name());
            ParserRuleContext functNameCtx = QNameParser.getFirstNameCtx(funcIds);
            PgSchema schema = getSchemaSafe(funcIds);
            AbstractPgFunction func = (AbstractPgFunction) getSafe(PgSchema::getFunction, schema,
                    parseSignature(functNameCtx.getText(), funct.function_args()),
                    functNameCtx.getStart());

            StringBuilder sb = new StringBuilder();
            DbObjType type = obj.PROCEDURE() == null ? DbObjType.FUNCTION : DbObjType.PROCEDURE;
            addObjReference(funcIds, type, state, parseArguments(funct.function_args()));

            if (isRefMode()) {
                continue;
            }

            sb.append(type).append(' ');
            sb.append(PgDiffUtils.getQuotedName(schema.getName())).append('.');

            // For AGGREGATEs in GRANT/REVOKE the signature will be the same as in FUNCTIONs;
            // important: asterisk (*) and 'ORDER BY' are not displayed.
            func.appendFunctionSignature(sb, false, true);

            for (String role : roles) {
                addPrivilege(func, new PgPrivilege(state, permissions,
                        sb.toString(), role, isGO, DatabaseType.PG));
            }
        }
    }

    private void parseColumns(Columns_permissionsContext columnsCtx, List<String> roles) {
        // collect information about column privileges
        Map<String, Entry<IdentifierContext, List<String>>> colPriv = new HashMap<>();
        for (Table_column_privilegesContext priv : columnsCtx.table_column_privileges()) {
            String privName = getFullCtxText(priv.table_column_privilege()).toUpperCase(Locale.ROOT);
            for (IdentifierContext col : priv.identifier_list_in_paren().identifier_list().identifier()) {
                colPriv.computeIfAbsent(col.getText(),
                        k -> new SimpleEntry<>(col, new ArrayList<>())).getValue().add(privName);
            }
        }

        // parse objects
        for (Schema_qualified_nameContext tbl : ctx.rule_member_object().names_references().schema_qualified_name()) {
            setColumnPrivilege(tbl, colPriv, roles);
        }
    }

    private void setColumnPrivilege(Schema_qualified_nameContext tbl,
            Map<String, Entry<IdentifierContext, List<String>>> colPrivs, List<String> roles) {
        List<ParserRuleContext> ids = getIdentifiers(tbl);

        addObjReference(ids, DbObjType.TABLE, state);

        // TODO waits for column references
        // addObjReference(Arrays.asList(QNameParser.getSchemaNameCtx(ids),firstPart, colName),
        //    DbObjType.COLUMN, StatementActions.NONE);

        if (isRefMode()) {
            return;
        }

        PgSchema schema = getSchemaSafe(ids);
        ParserRuleContext firstPart = QNameParser.getFirstNameCtx(ids);

        // write privileges as we received them in one line
        PgStatement st = (PgStatement) getSafe(PgSchema::getRelation, schema, firstPart);

        for (Entry<String, Entry<IdentifierContext, List<String>>> colPriv : colPrivs.entrySet()) {
            StringBuilder permission = new StringBuilder();
            for (String priv : colPriv.getValue().getValue()) {
                permission.append(priv).append('(')
                .append(colPriv.getValue().getKey().getText()).append("),");
            }

            permission.setLength(permission.length() - 1);

            for (String role : roles) {
                PgPrivilege priv = new PgPrivilege(state, permission.toString(),
                        "TABLE " + st.getQualifiedName(), role, isGO, DatabaseType.PG);
                if (DbObjType.TABLE != st.getStatementType()) {
                    addPrivilege(st, priv);
                } else {
                    IdentifierContext colName = colPriv.getValue().getKey();
                    AbstractColumn col = getSafe(AbstractTable::getColumn,
                            (AbstractTable) st, colName);
                    addPrivilege(col, priv);
                }
            }
        }
    }

    private void addToDB(Schema_qualified_nameContext name, DbObjType type,
            String state, String permissions, List<String> roles, boolean isGO) {
        List<ParserRuleContext> ids = getIdentifiers(name);
        ParserRuleContext idCtx = QNameParser.getFirstNameCtx(ids);
        PgStatement statement = switch (type) {
            case SCHEMA -> getSafe(PgDatabase::getSchema, db, idCtx);
            case DOMAIN -> getSafe(PgSchema::getDomain, getSchemaSafe(ids), idCtx);
            case TABLE -> (PgStatement) getSafe(PgSchema::getRelation, getSchemaSafe(ids), idCtx);
            case SEQUENCE -> getSafe(PgSchema::getSequence, getSchemaSafe(ids), idCtx);
            case FOREIGN_DATA_WRAPPER -> getSafe(PgDatabase::getForeignDW, db, idCtx);
            case SERVER -> getSafe(PgDatabase::getServer, db, idCtx);
            case TYPE -> {
                PgSchema schema = getSchemaSafe(ids);
                statement = schema.getType(idCtx.getText());

                // if type not found try domain
                if (statement == null) {
                    statement = getSafe(PgSchema::getDomain, schema, idCtx);
                }
                yield statement;
            }
            default -> null;
        };
        if (statement != null) {
            String typeName = type == DbObjType.SERVER ? "FOREIGN SERVER" : type.getTypeName();
            for (String role : roles) {
                addPrivilege(statement, new PgPrivilege(state, permissions,
                        typeName + " " + statement.getQualifiedName(), role, isGO, DatabaseType.PG));
            }
        }
    }

    private void addPrivilege(PgStatement st, PgPrivilege privilege) {
        if (overrides == null) {
            doSafe(PgStatement::addPrivilege, st, privilege);
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