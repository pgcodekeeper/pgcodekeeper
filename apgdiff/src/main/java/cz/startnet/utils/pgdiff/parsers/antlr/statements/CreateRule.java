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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Object_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Role_name_with_groupContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_privilegesContext;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
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
        // unsupported roles rules, ALL TABLES/SEQUENCES/FUNCTIONS IN SCHENA
        if (db.getArguments().isIgnorePrivileges() || ctx.other_rules() != null
                || ctx.all_objects() != null) {
            return;
        }

        List<String> roles = new ArrayList<>();
        for (Role_name_with_groupContext roleCtx : ctx.roles_names().role_name_with_group()) {
            String role = ParserAbstract.getFullCtxText(roleCtx.role_name);
            if (roleCtx.GROUP() != null) {
                role = "GROUP " + role;
            }

            roles.add(role);
        }

        Columns_permissionsContext columnsCtx = ctx.columns_permissions();

        if (columnsCtx != null) {
            parseColumns(columnsCtx, roles);
            return;
        }

        String permissions = ctx.permissions().permission().stream().map(ParserAbstract::getFullCtxText)
                .collect(Collectors.joining(","));

        if (ctx.FUNCTION() != null || ctx.PROCEDURE() != null) {
            for (Function_parametersContext funct : ctx.func_name) {
                List<IdentifierContext> funcIds = funct.name.identifier();
                IdentifierContext functNameCtx = QNameParser.getFirstNameCtx(funcIds);
                AbstractSchema schema = getSchemaSafe(funcIds);
                AbstractFunction func = getSafe(AbstractSchema::getFunction, schema,
                        parseSignature(functNameCtx.getText(), funct.function_args()),
                        functNameCtx.getStart());

                StringBuilder sb = new StringBuilder();
                DbObjType type = ctx.PROCEDURE() == null ?
                        DbObjType.FUNCTION : DbObjType.PROCEDURE;
                addFullObjReference(funcIds, type, StatementActions.NONE);

                if (isRefMode()) {
                    continue;
                }

                sb.append(type).append(' ');
                sb.append(PgDiffUtils.getQuotedName(schema.getName())).append('.');
                ((AbstractPgFunction) func).appendFunctionSignature(sb, false, true);

                for (String role : roles) {
                    addPrivilege(func, new PgPrivilege(state, permissions,
                            sb.toString(), role, isGO));
                }
            }

            return;
        }

        DbObjType type = null;
        Object_typeContext typeCtx = ctx.object_type();
        if (typeCtx == null || typeCtx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (typeCtx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (typeCtx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (typeCtx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (typeCtx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else {
            return;
        }

        List<Schema_qualified_nameContext> objName = ctx.names_references().name;

        if (type != null) {
            for (Schema_qualified_nameContext name : objName) {
                addFullObjReference(name.identifier(), type, StatementActions.NONE);
                if (!isRefMode()) {
                    for (String role : roles) {
                        addToDB(name, type, new PgPrivilege(state, permissions,
                                type + " " + name.getText(), role, isGO));
                    }
                }
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
            for (IdentifierContext col : priv.column) {
                colPriv.computeIfAbsent(col.getText(),
                        k -> new SimpleEntry<>(col, new ArrayList<>())).getValue().add(privName);
            }
        }

        // Разобрать объекты
        for (Schema_qualified_nameContext tbl : ctx.names_references().name) {
            setColumnPrivilege(tbl, colPriv, roles);
        }
    }

    private void setColumnPrivilege(Schema_qualified_nameContext tbl,
            Map<String, Entry<IdentifierContext, List<String>>> colPrivs, List<String> roles) {
        String tableName = getFullCtxText(tbl);
        List<IdentifierContext> ids = tbl.identifier();
        String firstPart = QNameParser.getFirstName(ids);

        if (isRefMode()) {
            // TODO add column references later
            addFullObjReference(ids, DbObjType.TABLE, StatementActions.NONE);
            return;
        }

        AbstractSchema schema = getSchemaSafe(ids);
        //привилегии пишем так как получили одной строкой
        PgStatement st = null;
        AbstractTable tblSt = schema.getTable(firstPart);

        // если таблица не найдена попробовать вьюхи и проч
        if (tblSt == null) {
            st = schema.getView(firstPart);
        }

        if (st == null) {
            st = schema.getSequence(firstPart);
        }

        if (tblSt == null && st == null) {
            return;
        }

        for (Entry<String, Entry<IdentifierContext, List<String>>> colPriv : colPrivs.entrySet()) {
            StringBuilder permission = new StringBuilder();
            for (String priv : colPriv.getValue().getValue()) {
                permission.append(priv).append('(')
                .append(colPriv.getValue().getKey().getText()).append("),");
            }

            permission.setLength(permission.length() - 1);

            for (String role : roles) {
                PgPrivilege priv = new PgPrivilege(state, permission.toString(),
                        "TABLE " + tableName, role, isGO);
                if (tblSt == null) {
                    addPrivilege(st, priv);
                } else {
                    AbstractColumn col = getSafe(AbstractTable::getColumn,
                            tblSt, colPriv.getValue().getKey());
                    addPrivilege(col, priv);
                }
            }
        }
    }

    private void addToDB(Schema_qualified_nameContext name, DbObjType type, PgPrivilege pgPrivilege) {
        List<IdentifierContext> ids = name.identifier();
        IdentifierContext idCtx = QNameParser.getFirstNameCtx(ids);
        String id = idCtx.getText();
        AbstractSchema schema = (DbObjType.SCHEMA == type ?
                getSafe(PgDatabase::getSchema, db, idCtx) : getSchemaSafe(ids));
        PgStatement statement = null;
        switch (type) {
        case TABLE:
            statement = schema.getTable(id);
            if (statement == null) {
                statement = schema.getView(id);
            }
            if (statement == null) {
                statement = getSafe(AbstractSchema::getSequence, schema, idCtx);
            }
            break;
        case SEQUENCE:
            statement = getSafe(AbstractSchema::getSequence, schema, idCtx);
            break;
        case SCHEMA:
            statement = getSafe(PgDatabase::getSchema, db, idCtx);
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
        if (statement != null){
            addPrivilege(statement, pgPrivilege);
        }
    }

    private void addPrivilege(PgStatement st, PgPrivilege privilege) {
        if (overrides == null) {
            setSafe(PgStatement::addPrivilege, st, privilege);
        } else {
            overrides.computeIfAbsent(st,
                    k -> new StatementOverride()).addPrivilege(privilege);
        }
    }
}