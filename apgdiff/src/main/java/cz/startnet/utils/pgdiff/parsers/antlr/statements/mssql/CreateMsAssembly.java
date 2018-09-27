package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_permissionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_assemblyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsAssembly extends ParserAbstract {

    private final Create_assemblyContext ctx;

    public CreateMsAssembly(Create_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        MsAssembly ass = new MsAssembly(ctx.assembly_name.getText(), getFullCtxText(ctx.getParent()));
        IdContext owner = ctx.owner_name;
        if (owner != null) {
            ass.setOwner(owner.getText());
        }

        for (ExpressionContext binary : ctx.expression()) {
            ass.addBinary(getFullCtxText(binary));
        }

        Assembly_permissionContext permission = ctx.assembly_permission();
        if (permission != null) {
            ass.setPermission(getFullCtxText(permission).toUpperCase());
        }

        db.addAssembly(ass);
        return ass;
    }

}
