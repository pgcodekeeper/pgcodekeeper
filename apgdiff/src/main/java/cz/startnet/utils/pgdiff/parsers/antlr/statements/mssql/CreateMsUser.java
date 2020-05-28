package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_userContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Domain_idContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.User_loginContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.User_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsUser;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsUser extends ParserAbstract {

    private final Create_userContext ctx;

    public CreateMsUser(Create_userContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Domain_idContext nameCtx = ctx.domain_id();
        MsUser user = new MsUser(nameCtx.getText());
        User_loginContext login = ctx.user_login();
        if (login != null && login.domain_id() != null) {
            user.setLogin(login.domain_id().getText());
        }

        for (User_optionContext option : ctx.user_option()) {
            if (option.schema_name != null) {
                user.setSchema(option.schema_name.getText());
            }
        }

        addSafe(db, user, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.USER, Arrays.asList(ctx.domain_id()));
    }
}
