package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsSchema extends ParserAbstract {

    private final Create_schemaContext ctx;

    public CreateMsSchema(Create_schemaContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = ctx.schema_name.getText();
        if (name == null) {
            return null;
        }

        AbstractSchema schema = new MsSchema(name, getFullCtxText(ctx.getParent()));
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            schema.setOwner(ctx.owner_name.getText());
        }

        if (ctx.schema_def != null) {
            schema.setDefinition(getFullCtxText(ctx.schema_def));
        }

        db.addSchema(schema);
        return schema;
    }

}
