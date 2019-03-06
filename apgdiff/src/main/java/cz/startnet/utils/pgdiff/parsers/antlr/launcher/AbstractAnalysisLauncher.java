package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * This class and all child classes contains statement, its contexts and
 * implementation of logic for launch the analysis of statement's contexts.
 */
public abstract class AbstractAnalysisLauncher {

    protected PgStatementWithSearchPath stmt;
    protected PgDatabase db;
    protected List<AntlrError> errors;

    // Contains PgStatement's contexts for analysis (for getting dependencies).
    protected final List<ParserRuleContext> contextsForAnalyze = new ArrayList<>();

    public AbstractAnalysisLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        this.stmt = stmt;
        this.db = db;
        this.errors = errors;
    }

    public PgStatementWithSearchPath getStmt() {
        return stmt;
    }

    /**
     * Add context for analyze.
     *
     * @param ctx context which belongs to stmt
     */
    public void addContextForAnalyze(ParserRuleContext ctx) {
        contextsForAnalyze.add(ctx);
    }

    protected void launchAnalyze() {
        for (ParserRuleContext ctx : contextsForAnalyze) {
            // Duplicated objects doesn't have parent, skip them
            if (stmt.getParent() == null) {
                continue;
            }

            if (stmt.getDatabase() != db) {
                // statement came from another DB object, probably a library
                // for proper depcy processing, find its twin in the final DB object
                stmt = (PgStatementWithSearchPath) stmt.getTwin(db);
            }

            try {
                analyzeOneCtx(ctx, stmt.getContainingSchema().getName());
            } catch (UnresolvedReferenceException ex) {
                unresolvRefExHandler(ex, errors, ctx, stmt.getLocation().getFilePath());
            } catch (Exception ex) {
                addError(errors, CustomParserListener.handleParserContextException(
                        ex, stmt.getLocation().getFilePath(), ctx));
            }
        }
    }

    public abstract void analyzeOneCtx(ParserRuleContext ctx, String schemaName);

    protected <T extends ParserRuleContext> void analyze(
            T ctx, AbstractExprWithNmspc<T> analyzer, PgStatement pg) {
        analyzer.analyze(ctx);
        pg.addAllDeps(analyzer.getDepcies());
    }

    protected void analyze(VexContext ctx, ValueExpr analyzer, PgStatement pg) {
        analyzer.analyze(new Vex(ctx));
        pg.addAllDeps(analyzer.getDepcies());
    }

    protected void analyzeWithNmspc(VexContext ctx, PgStatement statement,
            String schemaName, String rawTableReference, PgDatabase db) {
        ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(db);
        valExptWithNmspc.addRawTableReference(new GenericColumn(schemaName,
                rawTableReference, DbObjType.TABLE));
        analyze(ctx, valExptWithNmspc, statement);
    }

    private void unresolvRefExHandler(UnresolvedReferenceException ex,
            List<AntlrError> errors, ParserRuleContext ctx, String location) {
        if (ex.getErrorToken() == null) {
            ex.setErrorToken(ctx.getStart());
        }
        addError(errors, CustomSQLParserListener.handleUnresolvedReference(ex, location));
    }

    private void addError(List<AntlrError> errors, AntlrError err) {
        if (errors != null) {
            errors.add(err);
        }
    }
}
