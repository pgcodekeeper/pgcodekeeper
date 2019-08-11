package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Class_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Columns_permissionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Object_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_column_privilegesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsRule extends ParserAbstract {

    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;
    private final Map<PgStatement, StatementOverride> overrides;

    public CreateMsRule(Rule_commonContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public CreateMsRule(Rule_commonContext ctx, PgDatabase db, Map<PgStatement, StatementOverride> overrides) {
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
            return;
        }

        List<String> roles = ctx.role_names().id().stream()
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
            return;
        }

        StringBuilder name = new StringBuilder();
        if (st.getStatementType() == DbObjType.TYPE || !(st instanceof PgStatementWithSearchPath)) {
            name.append(st.getStatementType()).append("::");
        }

        name.append(st.getQualifiedName());

        Table_columnsContext columns = nameCtx.table_columns();

        // 1 privilege for each role
        for (String role : roles) {
            // 1 privilege for each permission
            for (String per : permissions) {
                if (columns == null) {
                    addPrivilege(st, new PgPrivilege(state, per, name.toString(), role, isGO));
                    continue;
                }

                // column privileges
                for (IdContext column : columns.column) {
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
            List<IdContext> ids = Arrays.asList(object.qualified_name().schema, nameCtx);
            AbstractSchema schema = getSchemaSafe(ids);
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
            for (IdContext col : priv.table_columns().column) {
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
}