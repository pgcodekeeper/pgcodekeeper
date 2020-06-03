package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
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
    protected final List<Object> errors;
    private final IProgressMonitor monitor;

    public CustomParserListener(PgDatabase database, String filename,
            ParserListenerMode mode, List<Object> errors, IProgressMonitor monitor) {
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
        safeParseStatement(() -> p.parseObject(filename, mode, ctx), ctx);
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

    /**
     * Adding undescribed DB object to query storage for showing information
     * about it in 'Outline' and in 'Console'.
     * <br /><br />
     * 'undescribed DB object' - means that it is not a child of
     * {@link cz.startnet.utils.pgdiff.schema.PgStatement}.
     */
    protected void addToQueries(ParserRuleContext ctx, String acton) {
        safeParseStatement(() -> db.addReference(filename, new PgObjLocation(acton, ctx,
                ParserListenerMode.SCRIPT == mode ? ParserAbstract.getFullCtxText(ctx) : null)), ctx);
    }

    /**
     *  Returns only the first 'descrWordsCount' words from a query in 'ctx'.
     */
    protected String getActionDescription(ParserRuleContext ctx, int descrWordsCount) {
        StringBuilder descr = new StringBuilder();
        fillActionDescription(ctx, new int[] {descrWordsCount}, descr);
        return descr.toString();
    }

    private void fillActionDescription(ParserRuleContext ctx, int[] descrWordsCount,
            StringBuilder descr) {
        List<ParseTree> children = ctx.children;
        if (children == null) {
            return;
        }

        for (ParseTree child : children) {
            if (0 >= descrWordsCount[0]) {
                return;
            }

            if (child instanceof ParserRuleContext) {
                fillActionDescription((ParserRuleContext) child, descrWordsCount, descr);
            } else if (child instanceof TerminalNode) {
                descr.append(child.getText().toUpperCase(Locale.ROOT));
                if (0 < --descrWordsCount[0]) {
                    descr.append(' ');
                }
            }
        }
    }
}
