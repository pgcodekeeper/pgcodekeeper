package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
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
        AbstractSchema schema = getSchemaSafe(ctx.table_name.identifier(), db.getDefaultSchema());
        PgRule rule = new PgRule(ctx.name.getText(), getFullCtxText(ctx.getParent()));
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText().toUpperCase()));
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
            UtilAnalyzeExpr.analyze(ctx.vex(), vex, rule);
        }
    }

    private static void analyzeRulesCommand(Rewrite_commandContext cmd, PgRule rule,
            String schemaName, PgDatabase db) {
        Select_stmtContext select;
        Insert_stmt_for_psqlContext insert;
        Delete_stmt_for_psqlContext delete;
        Update_stmt_for_psqlContext update;
        if ((select = cmd.select_stmt()) != null) {
            analyze(select, new Select(schemaName, db), rule, schemaName);
        } else if ((insert = cmd.insert_stmt_for_psql()) != null) {
            analyze(insert, new Insert(schemaName, db), rule, schemaName);
        } else if ((delete = cmd.delete_stmt_for_psql()) != null) {
            analyze(delete, new Delete(schemaName, db), rule, schemaName);
        } else if ((update = cmd.update_stmt_for_psql()) != null) {
            analyze(update, new Update(schemaName, db), rule, schemaName);
        }
    }

    private static <T extends ParserRuleContext> void analyze(
            T ctx, AbstractExprWithNmspc<T> analyzer, PgRule rule, String schemaName) {
        GenericColumn implicitTable = new GenericColumn(schemaName, rule.getParent().getName(), DbObjType.TABLE);
        analyzer.addReference("new", implicitTable);
        analyzer.addReference("old", implicitTable);
        UtilAnalyzeExpr.analyze(ctx, analyzer, rule);
    }
}