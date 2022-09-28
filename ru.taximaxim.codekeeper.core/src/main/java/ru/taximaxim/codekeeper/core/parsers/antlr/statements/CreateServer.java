package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_server_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgServer;

public class CreateServer extends ParserAbstract {

    private final Create_server_statementContext ctx;
    public CreateServer(Create_server_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.identifier();
        String name = ids.get(0).getText();
        PgServer server = new PgServer(name);
        if (ctx.type != null) {
            server.setType(getFullCtxText(ctx.type));
        }
        if (ctx.version != null) {
            server.setVersion(getFullCtxText(ctx.version));
        }
        server.setFdw(ids.get(1).getText());
        addDepSafe(server, Arrays.asList(ids.get(1)), DbObjType.FOREIGN_DATA_WRAPPER, true);

        Define_foreign_optionsContext options = ctx.define_foreign_options();
        if (options!= null) {
            for (Foreign_optionContext option : options.foreign_option()) {
                fillOptionParams(option.character_string().getText(), option.col_label().getText(), false,server::addOption);
            }
        }
        addSafe(db, server, Arrays.asList(ids.get(0)));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.SERVER, ctx.identifier().get(0));
    }
}
