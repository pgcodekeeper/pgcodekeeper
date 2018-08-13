package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_db_roleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterMsRole extends TableAbstract {

    private final Alter_db_roleContext ctx;

    public AlterMsRole(Alter_db_roleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        MsRole role = getSafe(db::getRole, ctx.role_name);

        if (ctx.ADD() != null) {
            role.addMember(ctx.database_principal.getText());
        }

        return null;
    }
}
