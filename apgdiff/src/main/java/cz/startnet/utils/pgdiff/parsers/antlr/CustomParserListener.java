package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomParserListener {

    protected final PgDatabase db;
    protected final ParserListenerMode mode;
    protected final String filename;
    private final List<AntlrError> errors;
    private final IProgressMonitor monitor;

    protected final List<List<QueryLocation>> batches;
    protected final Set<DangerStatement> dangerStatements;

    protected String fullScript;

    private final List<StatementBodyContainer> statementBodies = new ArrayList<>();

    public CustomParserListener(PgDatabase database, String filename,
            ParserListenerMode mode, List<AntlrError> errors,
            IProgressMonitor monitor, List<List<QueryLocation>> batches,
            Set<DangerStatement> dangerStatements) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
        this.mode = mode;
        this.batches = batches;
        this.dangerStatements = dangerStatements;
    }

    /**
     * @param ctx statememnt's first token rule
     */
    protected void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
        safeParseStatement(() -> p.parseObject(filename, mode, statementBodies,
                fullScript, batches), ctx);
    }

    protected void safeParseStatement(Runnable r, ParserRuleContext ctx) {
        try {
            PgDiffUtils.checkCancelled(monitor);
            r.run();
        } catch (UnresolvedReferenceException ex) {
            errors.add(handleUnresolvedReference(ex, filename));
        } catch (InterruptedException ex) {
            throw new MonitorCancelledRuntimeException();
        } catch (Exception e) {
            errors.add(handleParserContextException(e, filename, ctx));
        }
    }

    public List<StatementBodyContainer> getStatementBodies() {
        return statementBodies;
    }

    public static AntlrError handleUnresolvedReference(UnresolvedReferenceException ex, String filename) {
        Token t = ex.getErrorToken();
        AntlrError err = new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(), ex.getMessage());
        Log.log(Log.LOG_WARNING, err.toString(), ex);
        return err;
    }

    public static AntlrError handleParserContextException(Exception ex, String filename, ParserRuleContext ctx) {
        Token t = ctx.getStart();
        AntlrError err = new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(),  ex.getMessage());
        Log.log(ex instanceof ObjectCreationException ? Log.LOG_WARNING : Log.LOG_ERROR,
                err.toString(), ex);
        return err;
    }
}
