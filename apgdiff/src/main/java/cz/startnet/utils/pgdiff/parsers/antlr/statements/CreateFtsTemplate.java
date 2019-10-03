package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_templateContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class CreateFtsTemplate extends ParserAbstract {

    private final Create_fts_templateContext ctx;

    public CreateFtsTemplate(Create_fts_templateContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgFtsTemplate template = new PgFtsTemplate(QNameParser.getFirstName(ids));

        if (ctx.init_name != null) {
            template.setInitFunction(ParserAbstract.getFullCtxText(ctx.init_name));
            addDepSafe(template, ctx.init_name.identifier(), DbObjType.FUNCTION, true);
        }

        template.setLexizeFunction(ParserAbstract.getFullCtxText(ctx.lexize_name));
        addDepSafe(template, ctx.lexize_name.identifier(), DbObjType.FUNCTION, true);

        addSafe(getSchemaSafe(ids), template, ids);
    }

    @Override
    protected Pair<StatementActions, GenericColumn> getActionAndObjForStmtAction() {
        List<IdentifierContext> ids = ctx.name.identifier();
        return new Pair<>(StatementActions.CREATE, new GenericColumn(QNameParser.getSchemaName(ids),
                QNameParser.getFirstNameCtx(ids).getText(), DbObjType.FTS_TEMPLATE));
    }
}
