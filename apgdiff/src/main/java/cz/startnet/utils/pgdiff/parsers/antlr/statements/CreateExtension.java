package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateExtension extends ParserAbstract {
    private final Create_extension_statementContext ctx;
    public CreateExtension(Create_extension_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgExtension ext = new PgExtension(ctx.name.getText(), getFullCtxText(ctx.getParent()));
        if (ctx.schema_with_name() != null) {
            ext.setSchema(ctx.schema_with_name().name.getText());
            ext.addDep(new GenericColumn(ext.getSchema(), DbObjType.SCHEMA));
        }
        db.addExtension(ext);
        return ext;
    }
}