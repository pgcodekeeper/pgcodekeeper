package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.EnumSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractMsFunction;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        String schema = stmt.getSchemaName();

        if (ctx instanceof Sql_clausesContext) {
            MsSqlClauses clauses = new MsSqlClauses(schema);
            clauses.analyze((Sql_clausesContext) ctx);
            return clauses.getDepcies();
        }

        if (ctx instanceof Select_statementContext) {
            MsSelect select = new MsSelect(schema);
            return analyze((Select_statementContext) ctx, select);
        }

        MsValueExpr expr = new MsValueExpr(schema);
        return analyze((ExpressionContext) ctx, expr);
    }

    @Override
    protected EnumSet<DbObjType> getDisabledDepcies() {
        PgDiffArguments args = stmt.getDatabase().getArguments();
        if (!args.isEnableFunctionBodiesDependencies()) {
            return EnumSet.of(DbObjType.FUNCTION, DbObjType.PROCEDURE);
        }

        return super.getDisabledDepcies();
    }
}
