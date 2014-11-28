package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Revoke_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRevoke;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class Revoke extends ParserAbstract {
    private Revoke_statementContext ctx;
    public Revoke(Revoke_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgRevoke revoke = null;
        for (Schema_qualified_nameContext obj_Name : ctx.obj_name) {
            revoke = new PgRevoke(getFullCtxText(ctx));
            revoke.setObjName(obj_Name.getText());
            break;
        }
        return revoke;
    }

}
