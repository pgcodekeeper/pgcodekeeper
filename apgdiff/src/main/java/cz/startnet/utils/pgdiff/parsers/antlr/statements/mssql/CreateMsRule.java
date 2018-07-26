package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Grant_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsRule extends ParserAbstract {

    private final Grant_statementContext ctx;

    public CreateMsRule(Grant_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        // TODO role grant where table_name = null
        if (db.getArguments().isIgnorePrivileges() || ctx.table_name() == null) {
            return null;
        }

        String definition = getFullCtxText(ctx);

        IdContext schemaName = ctx.table_name().schema;
        String schema = schemaName != null ? schemaName.getText() : null;
        String name = ctx.table_name().table.getText();

        Stream<PgStatement> stream;

        if (schema != null) {
            PgSchema s = db.getSchema(schema);
            stream = s != null ? s.getChildren() : Stream.empty();
        } else {
            stream = db.getChildren();
        }

        PgStatement st = stream.filter(e -> e.getBareName().equals(name)).findAny().orElse(null);
        if (st != null) {
            st.addPrivilege(new PgPrivilege(false, definition));
        }

        return null;
    }
}
