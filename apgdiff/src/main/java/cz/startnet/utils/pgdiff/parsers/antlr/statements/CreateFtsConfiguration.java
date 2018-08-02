package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_configurationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFtsConfiguration extends ParserAbstract {

    private final Create_fts_configurationContext ctx;

    public CreateFtsConfiguration(Create_fts_configurationContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        String name = QNameParser.getFirstName(ids);
        PgFtsConfiguration config = new PgFtsConfiguration(name, getFullCtxText(ctx.getParent()));
        List<IdentifierContext> parserIds = ctx.parser_name.identifier();
        config.setParser(ParserAbstract.getFullCtxText(ctx.parser_name));
        String parserSchema = QNameParser.getSchemaName(parserIds, getDefSchemaName());
        if (!"pg_catalog".equals(parserSchema)) {
            config.addDep(new GenericColumn(parserSchema,
                    QNameParser.getFirstName(parserIds), DbObjType.FTS_PARSER));
        }
        schema.addFtsConfiguration(config);

        return config;
    }
}
