package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_parser_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFtsParser extends ParserAbstract {

    private final Create_fts_parser_statementContext ctx;

    public CreateFtsParser(Create_fts_parser_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgFtsParser parser = new PgFtsParser(QNameParser.getFirstName(ids));

        /*
         * function signatures are hardcoded for proper dependency resolution
         * argument list for each type of function is predetermined
         */

        parser.setStartFunction(ParserAbstract.getFullCtxText(ctx.start_func));
        addDepSafe(parser, ctx.start_func.identifier(), DbObjType.FUNCTION, true,
                "(internal, integer)");

        parser.setGetTokenFunction(ParserAbstract.getFullCtxText(ctx.gettoken_func));
        addDepSafe(parser, ctx.gettoken_func.identifier(), DbObjType.FUNCTION, true,
                "(internal, internal, internal)");

        parser.setEndFunction(ParserAbstract.getFullCtxText(ctx.end_func));
        addDepSafe(parser, ctx.end_func.identifier(), DbObjType.FUNCTION, true,
                "(internal)");

        parser.setLexTypesFunction(ParserAbstract.getFullCtxText(ctx.lextypes_func));
        addDepSafe(parser, ctx.lextypes_func.identifier(), DbObjType.FUNCTION, true,
                "(internal)");

        if (ctx.headline_func != null) {
            parser.setHeadLineFunction(ParserAbstract.getFullCtxText(ctx.headline_func));
            addDepSafe(parser, ctx.headline_func.identifier(), DbObjType.FUNCTION, true,
                    "(internal, internal, tsquery)");
        }

        addSafe(getSchemaSafe(ids), parser, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_PARSER, ctx.name);
    }
}
