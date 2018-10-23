package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_db_roleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsRole extends ParserAbstract {

    private final Create_db_roleContext ctx;

    public CreateMsRole(Create_db_roleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = ctx.role_name.getText();
        MsRole role = new MsRole(name, getFullCtxText(ctx.getParent()));
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            role.setOwner(ctx.owner_name.getText());
        }

        db.addRole(role);
        return role;
    }
}
