package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_db_roleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsRole extends TableAbstract {

    private final Alter_db_roleContext ctx;

    public AlterMsRole(Alter_db_roleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        MsRole role = getSafe(PgDatabase::getRole, db, ctx.role_name);

        if (ctx.ADD() != null) {
            doSafe(MsRole::addMember, role, ctx.database_principal.getText());
        }

        addObjReference(ctx.role_name, DbObjType.ROLE, StatementActions.ALTER);
    }
}
