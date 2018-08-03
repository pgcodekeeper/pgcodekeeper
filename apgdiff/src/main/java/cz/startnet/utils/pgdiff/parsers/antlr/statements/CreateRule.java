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
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateRule extends ParserAbstract {
    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;

    public CreateRule(Rule_commonContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
        isGO = ctx.OPTION() != null;
    }

    @Override
    public PgStatement getObject() {
        // unsupported roles rules, ALL TABLES/SEQUENCES/FUNCTIONS IN SCHENA
        if (db.getArguments().isIgnorePrivileges() || ctx.other_rules() != null
                || ctx.all_objects() != null) {
            return null;
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
            return null;
        }

        String permissions = ctx.permissions().permission().stream().map(ParserAbstract::getFullCtxText)
                .collect(Collectors.joining(","));

        if (ctx.FUNCTION() != null) {
            for (Function_parametersContext funct : ctx.func_name) {
                List<IdentifierContext> funcIds = funct.name.identifier();
                IdentifierContext functNameCtx = QNameParser.getFirstNameCtx(funcIds);
                AbstractSchema schema = getSchemaSafe(funcIds, db.getDefaultSchema());
                AbstractFunction func = getSafe(schema::getFunction,
                        parseSignature(functNameCtx.getText(), funct.function_args()),
                        functNameCtx.getStart());

                StringBuilder sb = new StringBuilder();
                sb.append(DbObjType.FUNCTION).append(' ');
                sb.append(PgDiffUtils.getQuotedName(schema.getName())).append('.');
                ((PgFunction)func).appendFunctionSignature(sb, false, true);

                for (String role : roles) {
                    func.addPrivilege(new PgPrivilege(state, permissions,
                            sb.toString(), role, isGO));
                }
            }

            return null;
        }

        DbObjType type = null;
        Object_typeContext typeCtx = ctx.object_type();
        if (typeCtx.TABLE() != null) {
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
            return null;
        }

        List<Schema_qualified_nameContext> obj_name = ctx.names_references().name;

        if (type != null) {
            for (Schema_qualified_nameContext name : obj_name) {
                for (String role : roles) {
                    addToDB(name, type, new PgPrivilege(state, permissions,
                            type + " " + name.getText(), role, isGO));
                }
            }
        }

        return null;
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
                String colName = col.getText();
                Entry<IdentifierContext, List<String>> privList = colPriv.get(colName);
                if (privList == null) {
                    privList = new SimpleEntry<>(col, new ArrayList<>());
                    colPriv.put(colName, privList);
                }
                privList.getValue().add(privName);
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
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        //привилегии пишем так как получили одной строкой
        PgStatement st = null;
        PgTable tblSt = schema.getTable(firstPart);

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
                .append(colPriv.getValue().getKey().getText()).append("), ");
            }

            permission.setLength(permission.length() - 2);

            for (String role : roles) {
                PgPrivilege priv = new PgPrivilege(state, permission.toString(),
                        "TABLE " + tableName, role, isGO);
                if (tblSt == null) {
                    st.addPrivilege(priv);
                } else {
                    AbstractColumn col = getSafe(tblSt::getColumn, colPriv.getValue().getKey());
                    col.addPrivilege(priv);
                }
            }
        }
    }

    private void addToDB(Schema_qualified_nameContext name, DbObjType type, PgPrivilege pgPrivilege) {
        List<IdentifierContext> ids = name.identifier();
        IdentifierContext idCtx = QNameParser.getFirstNameCtx(ids);
        String id = idCtx.getText();
        AbstractSchema schema = (DbObjType.SCHEMA == type ?
                getSafe(db::getSchema, idCtx)
                : getSchemaSafe(ids, db.getDefaultSchema()));
        PgStatement statement = null;
        switch (type) {
        case TABLE:
            statement = schema.getTable(id);
            if (statement == null) {
                statement = schema.getView(id);
            }
            if (statement == null) {
                statement = getSafe(schema::getSequence, idCtx);
            }
            break;
        case SEQUENCE:
            statement = getSafe(schema::getSequence, idCtx);
            break;
        case SCHEMA:
            statement = getSafe(db::getSchema, idCtx);
            break;
        case TYPE:
            statement = schema.getType(idCtx.getText());
            // if type not found try domain
            if (statement == null) {
                statement = getSafe(schema::getDomain, idCtx);
            }
            break;
        case DOMAIN:
            statement = getSafe(schema::getDomain, idCtx);
            break;
        default:
            break;
        }
        if (statement != null) {
            statement.addPrivilege(pgPrivilege);
        }
    }
}