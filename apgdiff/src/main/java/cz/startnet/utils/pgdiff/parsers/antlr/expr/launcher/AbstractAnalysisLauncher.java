package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsAbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * This class and all child classes contains statement, its contexts and
 * implementation of logic for launch the analysis of statement's contexts.
 */
public abstract class AbstractAnalysisLauncher {

    protected PgStatementWithSearchPath stmt;
    protected final ParserRuleContext ctx;
    private final String location;

    private int offset;
    private int lineOffset;
    private int inLineOffset;

    public AbstractAnalysisLauncher(PgStatementWithSearchPath stmt,
            ParserRuleContext ctx, String location) {
        this.stmt = stmt;
        this.ctx = ctx;
        this.location = location;
    }

    public PgStatementWithSearchPath getStmt() {
        return stmt;
    }

    public void setOffset(TerminalNode codeStart) {
        offset = codeStart.getSymbol().getStartIndex();
        lineOffset = codeStart.getSymbol().getLine() - 1;
        inLineOffset = codeStart.getSymbol().getCharPositionInLine();
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

    public Set<GenericColumn> launchAnalyze(List<Object> errors) {
        // Duplicated objects don't have parent, skip them
        if (stmt.getParent() == null) {
            return Collections.emptySet();
        }

        try {
            return analyze(ctx);
        } catch (UnresolvedReferenceException ex) {
            Token t = ex.getErrorToken();
            if (t != null) {
                AntlrError err = new AntlrError(t, location, t.getLine(),
                        t.getCharPositionInLine(), ex.getMessage())
                        .copyWithOffset(offset, lineOffset, inLineOffset);
                Log.log(Log.LOG_WARNING, err.toString(), ex);
                errors.add(err);
            } else {
                Log.log(Log.LOG_WARNING, ex.toString(), ex);
                errors.add(location + ' ' + ex.getLocalizedMessage());
            }
        } catch (Exception ex) {
            Log.log(Log.LOG_ERROR, ex.toString(), ex);
            errors.add(location + ' ' + ex);
        }

        return Collections.emptySet();
    }

    protected abstract Set<GenericColumn> analyze(ParserRuleContext ctx);

    protected <T extends ParserRuleContext> Set<GenericColumn> analyze(
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    protected Set<GenericColumn> analyze(VexContext ctx, ValueExpr analyzer) {
        analyzer.analyze(new Vex(ctx));
        return analyzer.getDepcies();
    }

    protected <T extends ParserRuleContext> Set<GenericColumn> analyze(
            T ctx, MsAbstractExprWithNmspc<T> analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    protected Set<GenericColumn> analyze(ExpressionContext ctx, MsValueExpr analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    /**
     * Sets up namespace for Constraint/Index expr analysis
     * @return
     */
    protected Set<GenericColumn> analyzeTableChildVex(VexContext ctx) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String rawTableReference = table.getName();

        ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(stmt.getDatabase());
        valExptWithNmspc.addRawTableReference(
                new GenericColumn(schemaName, rawTableReference, DbObjType.TABLE));
        return analyze(ctx, valExptWithNmspc);
    }

    /**
     * Sets up namespace for Trigger/Rule expr/command analysis
     * @return
     */
    protected <T extends ParserRuleContext> Set<GenericColumn> analyzeTableChild(
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String tableName = table.getName();
        GenericColumn implicitTable = new GenericColumn(schemaName, tableName, DbObjType.TABLE);
        analyzer.addReference("new", implicitTable);
        analyzer.addReference("old", implicitTable);
        return analyze(ctx, analyzer);
    }
}
