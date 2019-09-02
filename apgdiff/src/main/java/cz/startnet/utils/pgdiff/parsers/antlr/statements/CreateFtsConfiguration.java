package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_configurationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
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
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        PgFtsConfiguration config = new PgFtsConfiguration(name);
        if (ctx.parser_name != null) {
            List<IdentifierContext> parserIds = ctx.parser_name.identifier();
            config.setParser(ParserAbstract.getFullCtxText(ctx.parser_name));
            addDepSafe(config, parserIds, DbObjType.FTS_PARSER, true);
        }
        addSafe(getSchemaSafe(ids), config, ids);
    }
}