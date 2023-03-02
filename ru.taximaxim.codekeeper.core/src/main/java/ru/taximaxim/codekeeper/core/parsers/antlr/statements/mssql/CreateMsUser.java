package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Create_userContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.User_loginContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.User_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.MsUser;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateMsUser extends ParserAbstract {

    private final Create_userContext ctx;

    public CreateMsUser(Create_userContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.user_name;
        MsUser user = new MsUser(nameCtx.getText());
        User_loginContext login = ctx.user_login();
        if (login != null && login.id() != null) {
            user.setLogin(login.id().getText());
        }

        for (User_optionContext option : ctx.user_option()) {
            if (option.schema_name != null) {
                user.setSchema(option.schema_name.getText());
            }
            if (option.DECIMAL() != null) {
                user.setLanguage(option.DECIMAL().getText());
            } else if (option.language_name_or_alias != null) {
                user.setLanguage(MsDiffUtils.quoteName(option.language_name_or_alias.getText()));
            }
            if (option.on_off() != null) {
                user.setAllowEncrypted(option.on_off().ON() != null);
            }
        }

        addSafe(db, user, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.USER, ctx.user_name);
    }
}
