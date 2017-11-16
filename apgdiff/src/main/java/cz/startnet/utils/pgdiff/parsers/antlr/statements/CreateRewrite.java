package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
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

    public static String getCondition(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName) {
        if (ctx.WHERE() != null){
            VexContext exp = ctx.vex();
            ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName);
            vex.addReference("new", null);
            vex.addReference("old", null);
            vex.analyze(new Vex(exp));
            rule.addAllDeps(vex.getDepcies());
            return getFullCtxText(exp);
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    // allows to write a common namespace-setup code with no copy-paste for each cmd type
    public static void setCommands(Create_rewrite_statementContext ctx, PgRule rule,
            PgDiffArguments args, String schemaName) {
        for (Rewrite_commandContext cmd : ctx.commands) {
            Object parser = null;
            AbstractExprWithNmspc analyzer = null;
            Select_stmtContext select = cmd.select_stmt();
            if (select != null) {
                analyzer = new Select(schemaName);
                parser = new SelectStmt(select);
            } else if ((parser = cmd.insert_stmt_for_psql()) != null) {
                analyzer = new Insert(schemaName);
            } else if ((parser = cmd.delete_stmt_for_psql()) != null) {
                analyzer = new Delete(schemaName);
            } else if ((parser = cmd.update_stmt_for_psql()) != null) {
                analyzer = new Update(schemaName);
            }
            if (analyzer != null) {
                analyzer.addReference("new", null);
                analyzer.addReference("old", null);
                UtilExpr.analyze(parser, analyzer, rule);
            }
            rule.addCommand(args, getFullCtxText(cmd));
        }
    }
}