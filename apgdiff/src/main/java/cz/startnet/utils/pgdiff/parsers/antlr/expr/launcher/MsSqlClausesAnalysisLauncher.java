package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class MsSqlClausesAnalysisLauncher extends AbstractAnalysisLauncher {

    private final MsSqlClauses clauses;

    public MsSqlClausesAnalysisLauncher(PgStatementWithSearchPath stmt,
            Sql_clausesContext ctx, String location, MsSqlClauses clauses) {
        super(stmt, ctx, location);
        this.clauses = clauses;
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        clauses.analyze((Sql_clausesContext) ctx);
        return clauses.getDepcies();
    }
}
