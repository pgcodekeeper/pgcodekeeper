package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_server_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgServer;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        if (ids.size() > 1) {
            server.setFdw(ids.get(1).getText());
        }
        else {
            server.setFdw("FDWName");
        }

        Define_foreign_optionsContext options = ctx.define_foreign_options();
        if (options!= null) {
            for (Foreign_optionContext option : options.foreign_option()) {
                server.addOption(option.foreign_option_name().identifier().getText(), option.character_string().getText());
            }
        }
        addSafe(db, server, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.SERVER, ctx.identifier().get(0));
    }
}
