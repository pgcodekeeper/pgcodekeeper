package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_fts_template_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFtsTemplate extends ParserAbstract {

    private final Create_fts_template_statementContext ctx;

    public CreateFtsTemplate(Create_fts_template_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgFtsTemplate template = new PgFtsTemplate(QNameParser.getFirstName(ids));

        /*
         * function signatures are hardcoded for proper dependency resolution
         * argument list for each type of function is predetermined
         */

        if (ctx.init_name != null) {
            template.setInitFunction(ParserAbstract.getFullCtxText(ctx.init_name));
            addDepSafe(template, getIdentifiers(ctx.init_name), DbObjType.FUNCTION, true,
                    "(internal)");
        }

        template.setLexizeFunction(ParserAbstract.getFullCtxText(ctx.lexize_name));
        addDepSafe(template, getIdentifiers(ctx.lexize_name), DbObjType.FUNCTION, true,
                "(internal, internal, internal, internal)");

        addSafe(getSchemaSafe(ids), template, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_TEMPLATE, getIdentifiers(ctx.name));
    }
}
