package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }

        PgRule rule = new PgRule(name, getFullCtxText(ctx.getParent()));
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText()));
        rule.setTargetName(ctx.table_name.getText());
        rule.setCondition(getCondition(ctx));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }
        setCommands(ctx, rule, db.getArguments());

        PgSchema schema = db.getSchema(schemaName);
        PgTable table = schema.getTable(rule.getTargetName());
        if (table != null){
            table.addRule(rule);
        } else {
            PgView view = schema.getView(rule.getTargetName());
            if (view != null){
                view.addRule(rule);
            } else {
                Log.log(Log.LOG_ERROR, "Rule " + rule.getName() +
                        " is missing its container " + rule.getTargetName() +
                        " in schema " + schemaName);
            }
        }
        return rule;
    }

    public static String getCondition(Create_rewrite_statementContext ctx) {
        return ctx.WHERE() == null ? null : getFullCtxText(ctx.vex());
    }

    public static void setCommands(Create_rewrite_statementContext ctx, PgRule rule,
            PgDiffArguments args) {
        for (Rewrite_commandContext cmd : ctx.commands) {
            rule.addCommand(args, getFullCtxText(cmd));
        }
    }
}
