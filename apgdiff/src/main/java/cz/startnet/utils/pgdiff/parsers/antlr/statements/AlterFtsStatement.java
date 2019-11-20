package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_fts_configurationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_fts_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterFtsStatement extends ParserAbstract {

    private final Alter_fts_statementContext ctx;

    public AlterFtsStatement(Alter_fts_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();

        DbObjType tt;
        if (ctx.DICTIONARY() != null) {
            tt = DbObjType.FTS_DICTIONARY;
        } else if (ctx.TEMPLATE() != null) {
            tt = DbObjType.FTS_TEMPLATE;
        } else if (ctx.PARSER() != null) {
            tt = DbObjType.FTS_PARSER;
        } else {
            tt = DbObjType.FTS_CONFIGURATION;
        }

        addObjReference(ids, tt, StatementActions.ALTER);

        if (tt != DbObjType.FTS_CONFIGURATION) {
            return;
        }

        PgFtsConfiguration config = getSafe(AbstractSchema::getFtsConfiguration,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        Alter_fts_configurationContext afc = ctx.alter_fts_configuration();
        if (afc != null && afc.ADD() != null) {
            for (IdentifierContext type : afc.identifier_list().identifier()) {
                List<String> dics = new ArrayList<>();
                for (Schema_qualified_nameContext dictionary : afc.schema_qualified_name()) {
                    List<IdentifierContext> dIds = dictionary.identifier();
                    dics.add(getFullCtxText(dictionary));
                    addDepSafe(config, dIds, DbObjType.FTS_DICTIONARY, true);
                }

                doSafe((s,o) -> s.addDictionary(getFullCtxText(type), dics),
                        config, null);
            }
        }
    }
}