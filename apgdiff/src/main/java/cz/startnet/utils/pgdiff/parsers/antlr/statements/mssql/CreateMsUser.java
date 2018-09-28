package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_userContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.User_loginContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.User_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsUser;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsUser extends ParserAbstract {

    private final Create_userContext ctx;

    public CreateMsUser(Create_userContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = ctx.user_name.getText();
        MsUser user = new MsUser(name, getFullCtxText(ctx.getParent()));
        User_loginContext login = ctx.user_login();
        if (login != null) {
            user.setOwner(login.login_name.getText());
        }

        List<User_optionContext> options = ctx.user_option();

        for (User_optionContext option : options) {
            if (option.schema_name != null) {
                user.setSchema(option.schema_name.getText());
            }
        }

        db.addUser(user);
        return user;
    }
}
