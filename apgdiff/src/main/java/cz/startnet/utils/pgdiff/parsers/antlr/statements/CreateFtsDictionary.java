package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_dictionaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Option_with_valueContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFtsDictionary extends ParserAbstract {

    private final Create_fts_dictionaryContext ctx;

    public CreateFtsDictionary(Create_fts_dictionaryContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        PgFtsDictionary dictionary = new PgFtsDictionary(name);
        for (Option_with_valueContext option : ctx.option_with_value()) {
            fillOptionParams(option.vex().getText(), option.identifier().getText(), false, dictionary::addOption);
        }

        List<IdentifierContext> templateIds = ctx.template.identifier();
        dictionary.setTemplate(ParserAbstract.getFullCtxText(ctx.template));
        addDepSafe(dictionary, templateIds, DbObjType.FTS_TEMPLATE, true);
        addSafe(getSchemaSafe(ids), dictionary, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_DICTIONARY, ctx.name.identifier());
    }
}
