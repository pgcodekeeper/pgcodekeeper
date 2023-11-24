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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

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
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;

public class GrantPrivilege extends ParserAbstract {
    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;
    private final Map<PgStatement, StatementOverride> overrides;

    public GrantPrivilege(Rule_commonContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public GrantPrivilege(Rule_commonContext ctx, PgDatabase db, Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
        state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
        isGO = ctx.OPTION() != null;
    }

    @Override
    public void parseObject() {
        Rule_member_objectContext obj = ctx.rule_member_object();
        // unsupported roles rules, ALL TABLES/SEQUENCES/FUNCTIONS IN SCHENA
        if (db.getArguments().isIgnorePrivileges() || ctx.other_rules() != null
                || obj.ALL() != null) {
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

        String permissions = ctx.permissions().permission().stream().map(ParserAbstract::getFullCtxText)
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
        } else {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        List<Schema_qualified_nameContext> objName = obj.names_references().schema_qualified_name();

        if (type != null) {
            for (Schema_qualified_nameContext name : objName) {
                addObjReference(getIdentifiers(name), type, state);

                if (isRefMode()) {
                    continue;
                }

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
            String role = ParserAbstract.getFullCtxText(user);
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
            AbstractSchema schema = getSchemaSafe(funcIds);
            AbstractPgFunction func = (AbstractPgFunction) getSafe(AbstractSchema::getFunction, schema,
                    parseSignature(functNameCtx.getText(), funct.function_args()),
                    functNameCtx.getStart());

            StringBuilder sb = new StringBuilder();
            DbObjType type = obj.PROCEDURE() == null ?
                    DbObjType.FUNCTION : DbObjType.PROCEDURE;
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
                        sb.toString(), role, isGO));
            }
        }
    }

    /**
     * Вычитывает из контекста привилегию, и применяет её к таблице, сиквенсу,
     * view, колонкам в таблице
     * @param ctx_body
     */
    private void parseColumns(Columns_permissionsContext columnsCtx, List<String> roles) {
        // собрать информацию о привилегиях на колонки
        Map<String, Entry<IdentifierContext, List<String>>> colPriv = new HashMap<>();
        for (Table_column_privilegesContext priv : columnsCtx.table_column_privileges()) {
            String privName = getFullCtxText(priv.table_column_privilege());
            for (IdentifierContext col : priv.identifier_list().identifier()) {
                colPriv.computeIfAbsent(col.getText(),
                        k -> new SimpleEntry<>(col, new ArrayList<>())).getValue().add(privName);
            }
        }

        // Разобрать объекты
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

        AbstractSchema schema = getSchemaSafe(ids);
        ParserRuleContext firstPart = QNameParser.getFirstNameCtx(ids);

        //привилегии пишем так как получили одной строкой
        PgStatement st = (PgStatement) getSafe(AbstractSchema::getRelation, schema, firstPart);

        for (Entry<String, Entry<IdentifierContext, List<String>>> colPriv : colPrivs.entrySet()) {
            StringBuilder permission = new StringBuilder();
            for (String priv : colPriv.getValue().getValue()) {
                permission.append(priv).append('(')
                .append(colPriv.getValue().getKey().getText()).append("),");
            }

            permission.setLength(permission.length() - 1);

            for (String role : roles) {
                PgPrivilege priv = new PgPrivilege(state, permission.toString(),
                        "TABLE " + st.getQualifiedName(), role, isGO);
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
        AbstractSchema schema;
        switch (type) {
            case SCHEMA:
                schema = getSafe(PgDatabase::getSchema, db, idCtx);
                break;
            case FOREIGN_DATA_WRAPPER:
            case SERVER:
                schema = null;
                break;
            default:
                schema = getSchemaSafe(ids);
        }

        PgStatement statement = null;
        String typeName = null;
        switch (type) {
            case TABLE:
                statement = (PgStatement) getSafe(AbstractSchema::getRelation, schema, idCtx);
                break;
            case SEQUENCE:
                statement = getSafe(AbstractSchema::getSequence, schema, idCtx);
                break;
            case SCHEMA:
                statement = schema;
                break;
            case TYPE:
                statement = schema.getType(idCtx.getText());

                // if type not found try domain
                if (statement == null) {
                    statement = getSafe(AbstractSchema::getDomain, schema, idCtx);
                }
                break;
            case DOMAIN:
                statement = getSafe(AbstractSchema::getDomain, schema, idCtx);
                break;
            case SERVER:
                statement = getSafe(PgDatabase::getServer, db, idCtx);
                typeName = "FOREIGN SERVER";
                break;
            case FOREIGN_DATA_WRAPPER:
                statement = getSafe(PgDatabase::getForeignDW, db, idCtx);
                typeName = "FOREIGN DATA WRAPPER";
                break;
            default:
                break;
        }
        if (typeName == null) {
            typeName = type.name();
        }
        if (statement != null) {
            for (String role : roles) {
                addPrivilege(statement, new PgPrivilege(state, permissions,
                        typeName + " " + statement.getQualifiedName(), role, isGO));
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