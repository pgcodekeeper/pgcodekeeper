package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.MsDiffUtils;
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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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

        isGO = ctx.WITH() != null;
    }

    @Override
    public PgStatement getObject() {
        Object_typeContext nameCtx = ctx.object_type();
        // unsupported rules without object names
        if (db.getArguments().isIgnorePrivileges() || nameCtx == null) {
            return null;
        }

        List<String> roles = ctx.role_names().id().stream()
                .map(ParserRuleContext::getText).map(MsDiffUtils::quoteName).collect(Collectors.toList());

        Columns_permissionsContext columnsCtx = ctx.columns_permissions();
        if (columnsCtx != null) {
            parseColumns(columnsCtx, nameCtx, roles);
            return null;
        }

        List<String> permissions = ctx.permissions().permission().stream()
                .map(ParserAbstract::getFullCtxText).collect(Collectors.toList());

        PgStatement st = getStatement(nameCtx);

        if (st == null) {
            // TODO объект не найден, расширить или создать новый класс для ошибок MS парсера
            // throw new UnresolvedReferenceException("Cannot find object in database: "
            //        + nameCtx.getText(), nameCtx);
            return null;
        }

        String objectName = MsDiffUtils.quoteName(st.getBareName());

        if (st instanceof PgStatementWithSearchPath) {
            objectName = MsDiffUtils.quoteName(((PgStatementWithSearchPath) st).getContainingSchema().getName())
                    + '.' + objectName;
        } else if (st.getStatementType() == DbObjType.SCHEMA) {
            objectName = "SCHEMA::" + objectName;
        }

        Table_columnsContext columns = nameCtx.table_columns();

        // 1 privilege for each role
        for (String role : roles) {
            // 1 privilege for each permission
            for (String per : permissions) {
                if (columns != null) {
                    // column privileges
                    for (IdContext column : columns.column) {
                        String name = objectName + '(' + MsDiffUtils.quoteName(column.getText()) + ')';
                        PgPrivilege priv = new PgPrivilege(state, per, name, role, isGO);
                        // table column privileges to columns, other columns to statement
                        if (st instanceof AbstractTable) {
                            getSafe(((AbstractTable)st)::getColumn, column).addPrivilege(priv);
                        } else {
                            st.addPrivilege(priv);
                        }
                    }
                } else {
                    st.addPrivilege(new PgPrivilege(state, per, objectName, role, isGO));
                }
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
            AbstractSchema s = db.getSchema(schema);
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
            for (IdContext col : priv.table_columns().column) {
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

        String schemaName = ((PgStatementWithSearchPath)st).getContainingSchema().getName();

        // 1 permission for 1 column = 1 privilege
        for (Entry<String, Entry<IdContext, List<String>>> colPriv : colPrivs.entrySet()) {
            for (String pr : colPriv.getValue().getValue()) {

                IdContext col = colPriv.getValue().getKey();
                String objectName = MsDiffUtils.quoteName(schemaName) + '.' +
                        MsDiffUtils.quoteName(st.getBareName()) + " (" +
                        MsDiffUtils.quoteName(col.getText()) + ')';

                for (String role : roles) {
                    PgPrivilege priv = new PgPrivilege(state, pr, objectName, role, isGO);
                    if (st instanceof AbstractTable) {
                        getSafe(((AbstractTable)st)::getColumn, col).addPrivilege(priv);
                    } else {
                        st.addPrivilege(priv);
                    }
                }
            }
        }
    }
}