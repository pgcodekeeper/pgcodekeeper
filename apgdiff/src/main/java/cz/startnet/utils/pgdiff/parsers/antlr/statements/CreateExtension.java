package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateExtension extends ParserAbstract {
    private final Create_extension_statementContext ctx;
    public CreateExtension(Create_extension_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgExtension ext = new PgExtension(QNameParser.getFirstName(ctx.name.identifier()),
                getFullCtxText(ctx.getParent()));
        if (ctx.schema_with_name() != null) {
            ext.setSchema(QNameParser.getFirstName(ctx.schema_with_name().name.identifier()));
        }
        db.addExtension(ext);
        return ext;
    }

}
