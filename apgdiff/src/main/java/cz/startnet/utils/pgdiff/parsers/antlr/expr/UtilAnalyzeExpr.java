package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;
import java.util.ListIterator;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Check_boolean_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Common_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_eofContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.exprold.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IArgument;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UtilAnalyzeExpr {

    public static <T> void analyze(T ctx, AbstractExprWithNmspc<T> analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyze(VexContext ctx, ValueExpr analyzer, PgStatement pg) {
        analyzer.analyze(new Vex(ctx));
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyzeSecond(VexContext ctx,
            cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc analyzer,
            PgStatement pg) {
        analyzer.analyze(new Vex(ctx));
        pg.addAllDeps(analyzer.getDepcies());
    }

    public static void analyzeRulesWhere(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName) {
        if (ctx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName);
            GenericColumn implicitTable = new GenericColumn(schemaName, rule.getParent().getName(), DbObjType.TABLE);
            vex.addReference("new", implicitTable);
            vex.addReference("old", implicitTable);
            analyze(new Vex(ctx.vex()), vex, rule);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void analyzeRulesCommand(Rewrite_commandContext cmd, PgRule rule,
            String schemaName) {
        ParserRuleContext parser = null;
        AbstractExprWithNmspc analyzer = null;
        if ((parser = cmd.select_stmt()) != null) {
            analyzer = new Select(schemaName);
        } else if ((parser = cmd.insert_stmt_for_psql()) != null) {
            analyzer = new Insert(schemaName);
        } else if ((parser = cmd.delete_stmt_for_psql()) != null) {
            analyzer = new Delete(schemaName);
        } else if ((parser = cmd.update_stmt_for_psql()) != null) {
            analyzer = new Update(schemaName);
        }
        if (analyzer != null) {
            GenericColumn implicitTable = new GenericColumn(schemaName, rule.getParent().getName(), DbObjType.TABLE);
            analyzer.addReference("new", implicitTable);
            analyzer.addReference("old", implicitTable);
            analyze(parser, analyzer, rule);
        }
    }

    public static void analyzeTriggersWhen(VexContext ctx, PgTrigger trigger, String schemaName) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName);
        GenericColumn implicitTable = new GenericColumn(schemaName, trigger.getTableName(), DbObjType.TABLE);
        vex.addReference("new", implicitTable);
        vex.addReference("old", implicitTable);
        analyze(new Vex(ctx), vex, trigger);
    }

    public static void analyzeConstraint(Constr_bodyContext ctx, String schemaName,
            PgConstraint constr, PgDatabase db) {
        VexContext exp = null;
        Common_constraintContext common = ctx.common_constraint();
        Check_boolean_expressionContext check;
        if (common != null && (check = common.check_boolean_expression()) != null) {
            exp = check.expression;
        } else {
            exp = ctx.vex();
        }
        if (exp != null) {
            cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc valExptWithNmspc
            = new cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc(schemaName, db);
            valExptWithNmspc.addRawTableReference(new GenericColumn(
                    constr.getContainingSchema().getName(),
                    constr.getParent().getName(), DbObjType.TABLE));
            analyzeSecond(exp, valExptWithNmspc, constr);
        }
    }

    public static void analyzeFunctionDefaults(Vex_eofContext ctx, PgFunction f, String schemaName) {
        List<VexContext> vexCtxList = ctx.vex();
        ListIterator<VexContext> vexCtxListIterator = vexCtxList.listIterator(vexCtxList.size());

        for (int i = (f.getArguments().size() - 1); i >= 0; i--) {
            if (!vexCtxListIterator.hasPrevious()) {
                break;
            }
            IArgument a = f.getArguments().get(i);
            if ("IN".equals(a.getMode()) || "INOUT".equals(a.getMode())) {
                VexContext vx = vexCtxListIterator.previous();
                a.setDefaultExpression(ParserAbstract.getFullCtxText(vx));
                analyze(vx, new ValueExpr(schemaName), f);
                vexCtxListIterator.remove();
            }
        }
    }
}
