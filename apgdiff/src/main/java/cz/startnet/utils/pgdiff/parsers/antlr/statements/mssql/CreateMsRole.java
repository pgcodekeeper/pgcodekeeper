package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_db_roleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsRole extends ParserAbstract {

    private final Create_db_roleContext ctx;

    public CreateMsRole(Create_db_roleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.role_name;
        String name = nameCtx.getText();
        MsRole role = new MsRole(name);
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            role.setOwner(ctx.owner_name.getText());
        }

        addSafe(db, role, Arrays.asList(nameCtx));
    }
}
