package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;

public class CreateFtsParser extends ParserAbstract {

    private final Create_fts_parserContext ctx;

    public CreateFtsParser(Create_fts_parserContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgFtsParser parser = new PgFtsParser(QNameParser.getFirstName(ids));

        // TODO functions deps
        parser.setStartFunction(ParserAbstract.getFullCtxText(ctx.start_func));
        parser.setGetTokenFunction(ParserAbstract.getFullCtxText(ctx.gettoken_func));
        parser.setEndFunction(ParserAbstract.getFullCtxText(ctx.end_func));
        parser.setLexTypesFunction(ParserAbstract.getFullCtxText(ctx.lextypes_func));
        if (ctx.headline_func != null) {
            parser.setHeadLineFunction(ParserAbstract.getFullCtxText(ctx.headline_func));
        }

        addSafe(getSchemaSafe(ids), parser, ids);
    }
}
