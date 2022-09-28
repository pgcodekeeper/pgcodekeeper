package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_fts_dictionary_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgFtsDictionary;

public class CreateFtsDictionary extends ParserAbstract {

    private final Create_fts_dictionary_statementContext ctx;

    public CreateFtsDictionary(Create_fts_dictionary_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String name = QNameParser.getFirstName(ids);
        PgFtsDictionary dictionary = new PgFtsDictionary(name);
        for (Storage_parameter_optionContext option : ctx.storage_parameter_option()) {
            fillOptionParams(option.vex().getText(), option.storage_parameter_name().getText(), false, dictionary::addOption);
        }

        List<ParserRuleContext> templateIds = getIdentifiers(ctx.template);
        dictionary.setTemplate(ParserAbstract.getFullCtxText(ctx.template));
        addDepSafe(dictionary, templateIds, DbObjType.FTS_TEMPLATE, true);
        addSafe(getSchemaSafe(ids), dictionary, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_DICTIONARY, getIdentifiers(ctx.name));
    }
}
