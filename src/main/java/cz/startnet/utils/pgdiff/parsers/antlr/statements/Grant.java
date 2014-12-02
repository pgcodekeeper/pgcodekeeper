package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Grant_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgGrant;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class Grant extends ParserAbstract {
    private Grant_statementContext ctx;
    public Grant(Grant_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgGrant grant = null;
        for (Schema_qualified_nameContext objName : ctx.name) {
            grant = new PgGrant(getFullCtxText(ctx));
            grant.setObjName(objName.getText());
        }
        return grant;
    }

}
