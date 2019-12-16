package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.log.Log;

public class CustomParserListener {

    protected final PgDatabase db;
    protected final ParserListenerMode mode;
    protected final String filename;
    protected final List<AntlrError> errors;
    private final IProgressMonitor monitor;

    private final List<StatementBodyContainer> statementBodies = new ArrayList<>();

    public CustomParserListener(PgDatabase database, String filename,
            ParserListenerMode mode, List<AntlrError> errors,
            IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
        this.mode = mode;
    }

    /**
     * @param ctx statememnt's first token rule
     */
    protected void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
        safeParseStatement(() -> p.parseObject(filename, mode, statementBodies, ctx), ctx);
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

    /**
     * Adding undescribed DB object to query storage for showing information
     * about it in 'Outline' and in 'Console'.
     * <br /><br />
     * 'undescribed DB object' - means that it is not a child of
     * {@link cz.startnet.utils.pgdiff.schema.PgStatement}.
     */
    protected void addUndescribedObjToQueries(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        safeParseStatement(() -> db.addToQueries(filename, new PgObjLocation(
                getActionForUndescribedObj(ctx, tokenStream), ctx,
                ParserListenerMode.SCRIPT == mode ? ParserAbstract.getFullCtxText(ctx) : null)), ctx);
    }

    /**
     * Returns a string describing the action based on 'ctx'.
     */
    protected String getActionForUndescribedObj(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        return ctx.getStart().getText().toUpperCase(Locale.ROOT);
    }

    /**
     *  Returns only the first 'descrWordsCount' words from a query in 'ctx'.
     */
    protected String getActionDescription(CommonTokenStream tokenStream, ParserRuleContext ctx,
            int descrWordsCount) {
        List<Token> tokens = tokenStream.getTokens(ctx.getStart().getTokenIndex(),
                ctx.getStop().getTokenIndex());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < descrWordsCount; i++) {
            sb.append(tokens.get(i).getText()).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
