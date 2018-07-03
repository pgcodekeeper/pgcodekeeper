package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_templateContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateFtsTemplate extends ParserAbstract {

    private final Create_fts_templateContext ctx;

    public CreateFtsTemplate(Create_fts_templateContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgFtsTemplate template = new PgFtsTemplate(QNameParser.getFirstName(ids),
                getFullCtxText(ctx.getParent()));

        // TODO functions deps
        if (ctx.init_name != null) {
            template.setInitFunction(ParserAbstract.getFullCtxText(ctx.init_name));
        }

        template.setLexizeFunction(ParserAbstract.getFullCtxText(ctx.lexize_name));
        getSchemaSafe(ids, db.getDefaultSchema()).addFtsTemplate(template);
        return template;
    }
}
