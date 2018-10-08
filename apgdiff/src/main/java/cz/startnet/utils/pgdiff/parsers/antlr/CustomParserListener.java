package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomParserListener {

    protected final PgDatabase db;
    private final List<AntlrError> errors;
    private final IProgressMonitor monitor;
    private final String filename;

    public CustomParserListener(PgDatabase database, String filename,
            List<AntlrError> errors, IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
    }

    /**
     * @param ctx statememnt's first token rule
     */
    protected void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
        try {
            PgDiffUtils.checkCancelled(monitor);
            PgStatement st = p.getObject();
            if (st != null) {
                st.setLocation(filename);

                if (st instanceof AbstractTable) {
                    ((AbstractTable) st).getConstraints().stream()
                    .filter(con -> con.getLocation() == null)
                    .forEach(con -> con.setLocation(filename));
                }
            }
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

    public static AntlrError handleParserContextException(Exception ex, String filename, ParserRuleContext ctx) {
        Token t = ctx.getStart();
        AntlrError err = new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(),  ex.getMessage());
        Log.log(ex instanceof ObjectCreationException ? Log.LOG_WARNING : Log.LOG_ERROR,
                err.toString(), ex);
        return err;
    }
}
