package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

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
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * This class and all child classes contains statement, its contexts and
 * implementation of logic for launch the analysis of statement's contexts.
 */
public abstract class AbstractAnalysisLauncher {

    protected PgStatementWithSearchPath stmt;
    protected final ParserRuleContext ctx;

    public AbstractAnalysisLauncher(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        this.stmt = stmt;
        this.ctx = ctx;
    }

    public PgStatementWithSearchPath getStmt() {
        return stmt;
    }

    /**
     * Updates the saved statement to the twin found in the given db
     */
    public void updateStmt(PgDatabase db) {
        if (stmt.getDatabase() != db) {
            // statement came from another DB object, probably a library
            // for proper depcy processing, find its twin in the final DB object

            // twin implies the exact same object type, hence this is safe
            stmt = (PgStatementWithSearchPath) stmt.getTwin(db);
        }
    }

    public void launchAnalyze(List<? super AntlrError> errors) {
        // Duplicated objects don't have parent, skip them
        if (stmt.getParent() == null) {
            return;
        }

        PgObjLocation loc = stmt.getLocation();
        String filePath = loc == null ? null : loc.getFilePath();

        try {
            analyze(ctx);
        } catch (UnresolvedReferenceException ex) {
            unresolvRefExHandler(ex, errors, ctx, filePath);
        } catch (Exception ex) {
            addError(errors, CustomParserListener.handleParserContextException(
                    ex, filePath, ctx));
        }
    }

    protected abstract void analyze(ParserRuleContext ctx);

    protected <T extends ParserRuleContext> void analyze(
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        analyzer.analyze(ctx);
        stmt.addAllDeps(analyzer.getDepcies());
    }

    protected void analyze(VexContext ctx, ValueExpr analyzer) {
        analyzer.analyze(new Vex(ctx));
        stmt.addAllDeps(analyzer.getDepcies());
    }

    /**
     * Sets up namespace for Constraint/Index expr analysis
     */
    protected void analyzeTableChildVex(VexContext ctx) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String rawTableReference = table.getName();

        ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(stmt.getDatabase());
        valExptWithNmspc.addRawTableReference(
                new GenericColumn(schemaName, rawTableReference, DbObjType.TABLE));
        analyze(ctx, valExptWithNmspc);
    }

    /**
     * Sets up namespace for Trigger/Rule expr/command analysis
     */
    protected <T extends ParserRuleContext> void analyzeTableChild(
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String tableName = table.getName();
        GenericColumn implicitTable = new GenericColumn(schemaName, tableName, DbObjType.TABLE);
        analyzer.addReference("new", implicitTable);
        analyzer.addReference("old", implicitTable);
        analyze(ctx, analyzer);
    }

    private void unresolvRefExHandler(UnresolvedReferenceException ex,
            List<? super AntlrError> errors, ParserRuleContext ctx, String location) {
        if (ex.getErrorToken() == null) {
            ex.setErrorToken(ctx.getStart());
        }
        addError(errors, CustomSQLParserListener.handleUnresolvedReference(ex, location));
    }

    private void addError(List<? super AntlrError> errors, AntlrError err) {
        if (errors != null) {
            errors.add(err);
        }
    }
}
