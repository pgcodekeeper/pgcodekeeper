package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }

        setConditionAndAddCommands(ctx, rule, db);

        getSafe(schema::getRuleContainer,
                QNameParser.getFirstNameCtx(ctx.table_name.identifier())).addRule(rule);
        return rule;
    }

    public static void setConditionAndAddCommands(Create_rewrite_statementContext ctx,
            PgRule rule, PgDatabase db) {
        rule.setCondition((ctx.WHERE() != null) ? getFullCtxText(ctx.vex()) : null);

        // allows to write a common namespace-setup code with no copy-paste for each cmd type
        for (Rewrite_commandContext cmd : ctx.commands) {
            rule.addCommand(db.getArguments(), getFullCtxText(cmd));
        }

        db.addContextForAnalyze(rule, ctx);
    }

    public static void analyzeRulesCreate(Create_rewrite_statementContext createRewriteCtx,
            PgRule rule, String schemaName, PgDatabase db) {
        analyzeRulesWhere(createRewriteCtx, rule, schemaName, db);
        for (Rewrite_commandContext cmd : createRewriteCtx.commands) {
            analyzeRulesCommand(cmd, rule, schemaName, db);
        }
    }

    private static void analyzeRulesWhere(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName, PgDatabase db) {
        if (ctx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName, db);
            GenericColumn implicitTable = new GenericColumn(schemaName, rule.getParent().getName(), DbObjType.TABLE);
            vex.addReference("new", implicitTable);
            vex.addReference("old", implicitTable);
            UtilAnalyzeExpr.analyze(new Vex(ctx.vex()), vex, rule);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void analyzeRulesCommand(Rewrite_commandContext cmd, PgRule rule,
            String schemaName, PgDatabase db) {
        ParserRuleContext parser = null;
        AbstractExprWithNmspc analyzer = null;
        if ((parser = cmd.select_stmt()) != null) {
            analyzer = new Select(schemaName, db);
        } else if ((parser = cmd.insert_stmt_for_psql()) != null) {
            analyzer = new Insert(schemaName, db);
        } else if ((parser = cmd.delete_stmt_for_psql()) != null) {
            analyzer = new Delete(schemaName, db);
        } else if ((parser = cmd.update_stmt_for_psql()) != null) {
            analyzer = new Update(schemaName, db);
        }
        if (analyzer != null) {
            GenericColumn implicitTable = new GenericColumn(schemaName, rule.getParent().getName(), DbObjType.TABLE);
            analyzer.addReference("new", implicitTable);
            analyzer.addReference("old", implicitTable);
            UtilAnalyzeExpr.analyze(parser, analyzer, rule);
        }
    }
}