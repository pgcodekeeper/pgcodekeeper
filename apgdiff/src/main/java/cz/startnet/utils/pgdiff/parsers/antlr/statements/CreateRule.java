package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Columns_permissionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Role_name_with_groupContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_member_objectContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_privilegesContext;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateRule extends ParserAbstract {
    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;
    private final Map<PgStatement, StatementOverride> overrides;

    public CreateRule(Rule_commonContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public CreateRule(Rule_commonContext ctx, PgDatabase db, Map<PgStatement, StatementOverride> overrides) {
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
        } else {
            addOutlineRefForCommentOrRule(state, ctx);
            return;
        }

        List<Schema_qualified_nameContext> objName = obj.names_references().schema_qualified_name();

        if (type != null) {
            for (Schema_qualified_nameContext name : objName) {
                addObjReference(name.identifier(), type, state);

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
            List<IdentifierContext> funcIds = funct.schema_qualified_name().identifier();
            IdentifierContext functNameCtx = QNameParser.getFirstNameCtx(funcIds);
            AbstractSchema schema = getSchemaSafe(funcIds);
            AbstractPgFunction func = (AbstractPgFunction) getSafe(AbstractSchema::getFunction, schema,
                    parseSignature(functNameCtx.getText(), funct.function_args()),
                    functNameCtx.getStart());

            StringBuilder sb = new StringBuilder();
            DbObjType type = obj.PROCEDURE() == null ?
                    DbObjType.FUNCTION : DbObjType.PROCEDURE;
            addObjReference(funcIds, type, state);

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
        List<IdentifierContext> ids = tbl.identifier();

        addObjReference(ids, DbObjType.TABLE, state);

        // TODO waits for column references
        // addObjReference(Arrays.asList(QNameParser.getSchemaNameCtx(ids),firstPart, colName),
        //    DbObjType.COLUMN, StatementActions.NONE);

        if (isRefMode()) {
            return;
        }

        AbstractSchema schema = getSchemaSafe(ids);
        IdentifierContext firstPart = QNameParser.getFirstNameCtx(ids);

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
        List<IdentifierContext> ids = name.identifier();
        IdentifierContext idCtx = QNameParser.getFirstNameCtx(ids);
        AbstractSchema schema = (DbObjType.SCHEMA == type ?
                getSafe(PgDatabase::getSchema, db, idCtx) : getSchemaSafe(ids));
        PgStatement statement = null;
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
        default:
            break;
        }
        if (statement != null) {
            for (String role : roles) {
                addPrivilege(statement, new PgPrivilege(state, permissions,
                        type + " " + statement.getQualifiedName(), role, isGO));
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