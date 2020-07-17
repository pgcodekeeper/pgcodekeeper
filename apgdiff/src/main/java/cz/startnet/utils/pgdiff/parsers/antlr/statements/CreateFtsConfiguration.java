package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_configurationContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFtsConfiguration extends ParserAbstract {

    private final Create_fts_configurationContext ctx;

    public CreateFtsConfiguration(Create_fts_configurationContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String name = QNameParser.getFirstName(ids);
        PgFtsConfiguration config = new PgFtsConfiguration(name);
        if (ctx.parser_name != null) {
            List<ParserRuleContext> parserIds = getIdentifiers(ctx.parser_name);
            config.setParser(ParserAbstract.getFullCtxText(ctx.parser_name));
            addDepSafe(config, parserIds, DbObjType.FTS_PARSER, true);
        }
        addSafe(getSchemaSafe(ids), config, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_CONFIGURATION,
                getIdentifiers(ctx.name));
    }
}