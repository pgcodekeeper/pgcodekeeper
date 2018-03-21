package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Check_boolean_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Common_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

public class UtilAnalyzeExpr {

    public static <T> void analyze(T ctx, AbstractExprWithNmspc<T> analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyze(VexContext ctx, ValueExpr analyzer, PgStatement pg) {
        analyzer.analyze(new Vex(ctx));
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyzeRulesWhere(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName, PgDatabase db) {
        if (ctx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName, db);
            vex.addReference("new", null);
            vex.addReference("old", null);
            analyze(new Vex(ctx.vex()), vex, rule);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void analyzeRulesCommand(Rewrite_commandContext cmd, PgRule rule,
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
            analyzer.addReference("new", null);
            analyzer.addReference("old", null);
            analyze(parser, analyzer, rule);
        }
    }

    public static void analyzeTriggersWhen(VexContext ctx, PgTrigger trigger,
            String schemaName, PgDatabase db) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName, db);
        vex.addReference("new", null);
        vex.addReference("old", null);
        analyze(new Vex(ctx), vex, trigger);
    }

    public static void analyzeConstraint(Constr_bodyContext ctx, String schemaName,
            PgStatement stmt, PgDatabase db) {
        VexContext exp = null;
        Common_constraintContext common = ctx.common_constraint();
        Check_boolean_expressionContext check;
        if (common != null && (check = common.check_boolean_expression()) != null) {
            exp = check.expression;
        } else {
            exp = ctx.vex();
        }
        if (exp != null) {
            analyze(exp, new ValueExpr(schemaName, db), stmt);
        }
    }
}
