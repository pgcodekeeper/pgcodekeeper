package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.log.Log;

public class CustomParserListener {

    protected final PgDatabase db;
    protected final boolean refMode;
    protected final String filename;
    protected final List<Object> errors;
    private final IProgressMonitor monitor;

    private final List<StatementBodyContainer> statementBodies = new ArrayList<>();

    public CustomParserListener(PgDatabase database, String filename,
            boolean refMode, List<Object> errors, IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
        this.refMode = refMode;
    }

    /**
     * @param ctx statememnt's first token rule
     */
    protected void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
        safeParseStatement(() -> p.parseObject(filename, refMode, statementBodies), ctx);
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

    private AntlrError handleParserContextException(Exception ex, String filename, ParserRuleContext ctx) {
        Token t = ctx.getStart();
        AntlrError err = new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(),  ex.getMessage());
        Log.log(ex instanceof ObjectCreationException ? Log.LOG_WARNING : Log.LOG_ERROR,
                err.toString(), ex);
        return err;
    }
}
