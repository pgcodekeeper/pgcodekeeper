package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.PgDiffArguments;
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
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText()));
        rule.setCondition(getCondition(ctx, rule, schema.getName()));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }
        setCommands(ctx, rule, db.getArguments(), schema.getName());

        getSafe(schema::getRuleContainer,
                QNameParser.getFirstNameCtx(ctx.table_name.identifier())).addRule(rule);
        return rule;
    }

    private static String getCondition(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName) {
        return (ctx.WHERE() != null) ? getFullCtxText(ctx.vex()) : null;
    }

    // allows to write a common namespace-setup code with no copy-paste for each cmd type
    private static void setCommands(Create_rewrite_statementContext ctx, PgRule rule,
            PgDiffArguments args, String schemaName) {
        for (Rewrite_commandContext cmd : ctx.commands) {
            rule.addCommand(args, getFullCtxText(cmd));
        }
    }
}