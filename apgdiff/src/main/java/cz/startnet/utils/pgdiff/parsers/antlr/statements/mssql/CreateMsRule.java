package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Columns_permissionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Object_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_column_privilegesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CreateMsRule extends ParserAbstract {

    private final Rule_commonContext ctx;
    private final String state;
    private final boolean isGO;

    public CreateMsRule(Rule_commonContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        if (ctx.DENY() != null) {
            state = "DENY";
        } else {
            state = ctx.REVOKE() != null ? "REVOKE" : "GRANT";
        }

        isGO = ctx.OPTION() != null;
    }

    @Override
    public PgStatement getObject() {
        Object_typeContext nameCtx = ctx.object_type();
        // unsupported rules without object names
        if (db.getArguments().isIgnorePrivileges() || nameCtx == null) {
            return null;
        }

        List<String> roles = ctx.role_names().id().stream()
                .map(ParserAbstract::getFullCtxText).collect(Collectors.toList());

        Columns_permissionsContext columnsCtx = ctx.columns_permissions();
        if (columnsCtx != null) {
            // TODO MS SQL dump columns as name part, rewrite parser rule
            parseColumns(columnsCtx, nameCtx, roles);
            return null;
        }

        String permission = ctx.permissions().permission().stream().map(ParserAbstract::getFullCtxText)
                .collect(Collectors.joining(","));

        PgStatement st = getStatement(nameCtx);

        if (st != null) {
            for (String role : roles) {
                st.addPrivilege(new PgPrivilege(state, permission,
                        getFullCtxText(nameCtx), role, isGO));
            }
        }

        return null;
    }

    private PgStatement getStatement(Object_typeContext nameCtx) {
        IdContext schemaName = nameCtx.table_name().schema;
        String schema = schemaName != null ? schemaName.getText() : null;
        String name = nameCtx.table_name().table.getText();

        Stream<PgStatement> stream;

        if (schema != null) {
            PgSchema s = db.getSchema(schema);
            stream = s != null ? s.getChildren() : Stream.empty();
        } else {
            stream = db.getChildren();
        }

        return stream.filter(e -> e.getBareName().equals(name)).findAny().orElse(null);
    }

    private void parseColumns(Columns_permissionsContext columnsCtx,
            Object_typeContext nameCtx, List<String> roles) {
        // собрать информацию о привилегиях на колонки
        Map<String, Entry<IdContext, List<String>>> colPriv = new HashMap<>();
        for (Table_column_privilegesContext priv : columnsCtx.table_column_privileges()) {
            String privName = getFullCtxText(priv.permission());
            for (IdContext col : priv.column) {
                String colName = col.getText();
                Entry<IdContext, List<String>> privList = colPriv.get(colName);
                if (privList == null) {
                    privList = new SimpleEntry<>(col, new ArrayList<>());
                    colPriv.put(colName, privList);
                }
                privList.getValue().add(privName);
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

        for (Entry<String, Entry<IdContext, List<String>>> colPriv : colPrivs.entrySet()) {
            StringBuilder permission = new StringBuilder();
            for (String priv : colPriv.getValue().getValue()) {
                permission.append(priv).append('(')
                .append(colPriv.getValue().getKey().getText()).append("), ");
            }

            permission.setLength(permission.length() - 2);

            for (String role : roles) {
                PgPrivilege priv = new PgPrivilege(state, permission.toString(),
                        "OBJECT " + st.getBareName(), role, isGO);
                if (st instanceof PgTable) {
                    PgColumn col = getSafe(((PgTable)st)::getColumn, colPriv.getValue().getKey());
                    col.addPrivilege(priv);
                } else {
                    st.addPrivilege(priv);
                }
            }
        }
    }
}
