package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class ConstraintAnalysisLauncher extends AbstractAnalysisLauncher {

    public ConstraintAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeWithNmspc((VexContext) ctx, stmt, schemaName,
                stmt.getParent().getName(), db);
    }
}
