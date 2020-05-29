package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_authorizationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Class_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsAuthorization extends ParserAbstract {

    private final Alter_authorizationContext ctx;
    private final Map<PgStatement, StatementOverride> overrides;

    public AlterMsAuthorization(Alter_authorizationContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public AlterMsAuthorization(Alter_authorizationContext ctx, PgDatabase db,
            Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
    }

    @Override
    public void parseObject() {
        IdContext ownerId = ctx.authorization_grantee().id();
        if (db.getArguments().isIgnorePrivileges() || ownerId == null) {
            return;
        }
        String owner = ownerId.getText();

        Class_typeContext type = ctx.class_type();
        IdContext nameCtx = ctx.entity.name;
        List<ParserRuleContext> ids = Arrays.asList(ctx.entity.schema, nameCtx);

        PgStatement st = null;
        if (type == null || type.OBJECT() != null || type.TYPE() != null) {
            IdContext schemaCtx = ctx.entity.schema;
            AbstractSchema schema = getSchemaSafe(ids);
            st = getSafe((k, v) -> k.getChildren().filter(
                    e -> e.getBareName().equals(v))
                    .findAny().orElse(null), schema, nameCtx);

            // when type is not defined (sometimes in ref mode), suppose it is a table
            addObjReference(Arrays.asList(schemaCtx, nameCtx),
                    st != null ? st.getStatementType() : DbObjType.TABLE, ACTION_ALTER);
        } else if (type.ASSEMBLY() != null) {
            st = getSafe(PgDatabase::getAssembly, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.ASSEMBLY, ACTION_ALTER);
        } else if (type.ROLE() != null) {
            st = getSafe(PgDatabase::getRole, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.ROLE, ACTION_ALTER);
        } else if (type.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
            addObjReference(Arrays.asList(nameCtx), DbObjType.SCHEMA, ACTION_ALTER);
        }

        if (st != null) {
            setOwner(st, owner);
        }
    }

    private void setOwner(PgStatement st, String owner) {
        if (overrides == null) {
            st.setOwner(owner);
        } else {
            overrides.computeIfAbsent(st, k -> new StatementOverride()).setOwner(owner);
        }
    }

    @Override
    protected String getStmtAction() {
        return new StringBuilder(ACTION_ALTER).append(" AUTHORIZATION").toString();
    }
}
