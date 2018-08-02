package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_authorizationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterMsAuthorization extends ParserAbstract {

    private final Alter_authorizationContext ctx;

    public AlterMsAuthorization(Alter_authorizationContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        IdContext ownerId = ctx.authorization_grantee().principal_name;
        if (ownerId == null) {
            return null;
        }
        String owner = ownerId.getText();

        IdContext schemaName = ctx.entity.schema;
        String schema = schemaName != null ? schemaName.getText() : null;
        String name = ctx.entity.table.getText();

        Stream<PgStatement> stream;

        if (schema != null) {
            AbstractSchema s = db.getSchema(schema);
            stream = s != null ? s.getChildren() : Stream.empty();
        } else {
            stream = db.getChildren();
        }

        PgStatement st = stream.filter(e -> e.getBareName().equals(name)).findAny().orElse(null);
        if (st != null) {
            st.setOwner(owner);
        }

        return null;
    }
}
