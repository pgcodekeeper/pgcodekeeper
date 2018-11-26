package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Map;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_authorizationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Class_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;

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
    public PgStatement getObject() {
        IdContext ownerId = ctx.authorization_grantee().principal_name;
        if (ownerId == null) {
            return null;
        }
        String owner = ownerId.getText();

        Class_typeContext type = ctx.class_type();
        IdContext nameCtx = ctx.entity.name;

        PgStatement st;
        if (type == null || type.OBJECT() != null) {
            IdContext schemaName = ctx.entity.schema;
            AbstractSchema schema = schemaName != null ? getSafe(db::getSchema, schemaName) : db.getDefaultSchema();
            st = getSafe(name -> schema.getChildren().filter(
                    e -> e.getBareName().equals(name))
                    .findAny().orElse(null), nameCtx);
        } else if (type.ASSEMBLY() != null) {
            st = getSafe(db::getAssembly, nameCtx);
        } else if (type.ROLE() != null) {
            st = getSafe(db::getRole, nameCtx);
        } else if (type.SCHEMA() != null) {
            st = getSafe(db::getSchema, nameCtx);
        } else {
            return null;
        }

        setOwner(st, owner);
        return null;
    }

    private void setOwner(PgStatement st, String owner) {
        if (overrides == null) {
            st.setOwner(owner);
        } else {
            StatementOverride override = overrides.get(st);
            if (override == null) {
                override = new StatementOverride();
                overrides.put(st, override);
            }

            override.setOwner(owner);
        }
    }
}
