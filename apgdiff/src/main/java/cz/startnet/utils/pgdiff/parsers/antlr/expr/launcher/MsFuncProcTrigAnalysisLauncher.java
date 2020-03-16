package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractMsFunction;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFuncProcTrigAnalysisLauncher extends AbstractAnalysisLauncher {

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            Sql_clausesContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            Select_statementContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(AbstractMsFunction stmt,
            ExpressionContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public MsFuncProcTrigAnalysisLauncher(MsTrigger stmt,
            Sql_clausesContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        String schema = stmt.getSchemaName();

        DbObjType [] disabledDepcies = new DbObjType[] {DbObjType.FUNCTION, DbObjType.PROCEDURE};
        if (stmt.getDatabase().getArguments().isEnableFunctionBodiesDependencies()) {
            disabledDepcies = new DbObjType[0];
        }

        if (ctx instanceof Sql_clausesContext) {
            MsSqlClauses clauses = new MsSqlClauses(schema, disabledDepcies);
            clauses.analyze((Sql_clausesContext) ctx);
            return clauses.getDepcies();
        }

        if (ctx instanceof Select_statementContext) {
            MsSelect select = new MsSelect(schema, disabledDepcies);
            return analyze((Select_statementContext) ctx, select);
        }

        MsValueExpr expr = new MsValueExpr(schema, disabledDepcies);
        return analyze((ExpressionContext) ctx, expr);
    }
}
