package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class IndexAnalysisLauncher extends AbstractAnalysisLauncher {

    public IndexAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeIndexRest((Index_restContext) ctx, stmt, schemaName, db);
    }

    private void analyzeIndexRest(Index_restContext rest, PgStatement indexStmt,
            String schemaName, PgDatabase db) {
        String rawTableReference = indexStmt.getParent().getName();

        for (Sort_specifierContext sort_ctx : rest.index_sort().sort_specifier_list()
                .sort_specifier()) {
            analyzeWithNmspc(sort_ctx.key, indexStmt, schemaName,
                    rawTableReference, db);
        }

        if (rest.index_where() != null){
            analyzeWithNmspc(rest.index_where().vex(), indexStmt,
                    schemaName, rawTableReference, db);
        }
    }
}
