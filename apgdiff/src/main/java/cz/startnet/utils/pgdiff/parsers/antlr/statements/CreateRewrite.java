package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateRewrite extends ParserAbstract {
    private final Create_rewrite_statementContext ctx;

    public CreateRewrite(Create_rewrite_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgSchema schema = getSchemaSafe(ctx.table_name.identifier(), db.getDefaultSchema());
        PgRule rule = new PgRule(ctx.name.getText(), getFullCtxText(ctx.getParent()));
        db.addPairToContextsForAnalyze(rule, ctx);
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText()));
        rule.setCondition((ctx.WHERE() != null) ? getFullCtxText(ctx.vex()) : null);
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }

        // allows to write a common namespace-setup code with no copy-paste for each cmd type
        for (Rewrite_commandContext cmd : ctx.commands) {
            rule.addCommand(db.getArguments(), getFullCtxText(cmd));
        }

        getSafe(schema::getRuleContainer,
                QNameParser.getFirstNameCtx(ctx.table_name.identifier())).addRule(rule);
        return rule;
    }
}