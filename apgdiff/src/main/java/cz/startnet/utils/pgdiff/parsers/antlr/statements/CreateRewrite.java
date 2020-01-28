package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.RuleAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateRewrite extends ParserAbstract {
    private final Create_rewrite_statementContext ctx;

    public CreateRewrite(Create_rewrite_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.table_name.identifier();
        addObjReference(ids, DbObjType.TABLE, StatementActions.NONE);

        PgRule rule = new PgRule(ctx.name.getText());
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText().toUpperCase(Locale.ROOT)));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }

        setConditionAndAddCommands(ctx, rule, db, fileName);

        IdentifierContext parent = QNameParser.getFirstNameCtx(ids);
        IStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                getSchemaSafe(ids), parent);
        addSafe((PgStatement) cont, rule, Arrays.asList(
                QNameParser.getSchemaNameCtx(ids), parent, ctx.name));
    }

    public static void setConditionAndAddCommands(Create_rewrite_statementContext ctx,
            PgRule rule, PgDatabase db, String location) {
        rule.setCondition((ctx.WHERE() != null) ? getFullCtxText(ctx.vex()) : null);

        // allows to write a common namespace-setup code with no copy-paste for each cmd type
        for (Rewrite_commandContext cmd : ctx.rewrite_command()) {
            rule.addCommand(db.getArguments(), getFullCtxText(cmd));
        }

        db.addAnalysisLauncher(new RuleAnalysisLauncher(rule, ctx, location));
    }
}