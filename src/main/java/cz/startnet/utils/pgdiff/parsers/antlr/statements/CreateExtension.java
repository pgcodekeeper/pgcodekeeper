package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateExtension extends ParserAbstract {
    private Create_extension_statementContext ctx;
    public CreateExtension(Create_extension_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        PgExtension ext = new PgExtension(name, getFullCtxText(ctx.getParent()));
        if (ctx.old_version!= null) {
            ext.setOldVersion(ctx.old_version.getText());
        }
        if (ctx.schema_name != null) {
            ext.setSchema(ctx.schema_name.getText());
        }
        if (ctx.version!= null) {
            ext.setVersion(ctx.version.getText());
        }
        fillObjLocation(name, ctx.name.getStart().getStartIndex());
        return ext;
    }

}
