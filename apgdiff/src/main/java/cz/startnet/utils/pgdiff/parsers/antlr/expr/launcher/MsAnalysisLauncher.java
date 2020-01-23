package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsAbstractExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class MsAnalysisLauncher extends AbstractAnalysisLauncher {

    private final MsAbstractExpr abstractExpr;

    public MsAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx,
            MsAbstractExpr abstractExpr) {
        super(stmt, ctx);
        this.abstractExpr = abstractExpr;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        if (ctx instanceof ExpressionContext) {
            MsValueExpr vex = (MsValueExpr) abstractExpr;
            vex.analyze((ExpressionContext) ctx);
            return vex.getDepcies();
        } else if (ctx instanceof Sql_clausesContext) {
            MsSqlClauses clauses = (MsSqlClauses) abstractExpr;
            clauses.analyze((Sql_clausesContext) ctx);
            return clauses.getDepcies();
        } else if (ctx instanceof Select_statementContext) {
            MsSelect sel = (MsSelect) abstractExpr ;
            sel.analyze((Select_statementContext) ctx);
            return sel.getDepcies();
        }
        return Collections.emptySet();
    }
}
