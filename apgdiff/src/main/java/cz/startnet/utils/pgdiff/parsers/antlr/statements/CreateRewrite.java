package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CreateRewrite extends ParserAbstract {
    private final Create_rewrite_statementContext ctx;
    public CreateRewrite(Create_rewrite_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgRule rule = new PgRule(name, getFullCtxText(ctx.getParent()));
        rule.setRuleTargetName(ctx.table_name.getText());

        if (ctx.OR()!=null && ctx.REPLACE()!=null){
            rule.setOrReplace(true);
        }

        if (ctx.where_clause() != null){
            rule.setRuleCondition(getFullCtxText(ctx.where_clause()));
        }
        if (ctx.command != null){
            String command = getFullCtxText(ctx.command);
            rule.setRuleCommand(command);
        }
        rule.setRuleEvent(PgRuleEventType.valueOf(ctx.event.getText()));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }

        if (ctx.ALSO() != null){
            rule.setAlso(true);
        }

        PgTable pgTable = db.getSchema(schemaName).getTable(rule.getRuleTargetName());
        if (pgTable != null){
            pgTable.addRule(rule);
        } else {
            PgView pgView = db.getSchema(schemaName).getView(rule.getRuleTargetName());
            if (pgView != null){
                pgView.addRule(rule);
            } else {
                Log.log(Log.LOG_ERROR,
                        new StringBuilder().append("Rule ")
                        .append(rule.getName())
                        .append(" was added outside table or view for ").append(schemaName)
                        .append(" schema ").toString());
            }
        }
        return rule;
    }

    /*    public static class WhenListener extends SQLParserBaseListener {
        private String when;
        @Override
        public void exitWhen_trigger(When_triggerContext ctx) {
            when = getFullCtxText(ctx.when_expr);
        }
        public String getWhen() {
            return when;
        }
    }*/
}
