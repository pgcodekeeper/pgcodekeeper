package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_authorizationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_procedureContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_sequenceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_specialContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAuthorization;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsProcedure;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsRule;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomTSQLParserListener extends TSQLParserBaseListener {

    private final PgDatabase db;
    private final List<AntlrError> errors;
    private final IProgressMonitor monitor;
    private final String filename;
    private boolean ansiNulls;
    private boolean quotedIdentifier;

    public CustomTSQLParserListener(PgDatabase database, String filename,
            List<AntlrError> errors, IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
    }

    private void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
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
        } catch (ObjectCreationException ex) {
            errors.add(handleCreationException(ex, filename, ctx.getParent()));
        } catch (InterruptedException ex) {
            throw new MonitorCancelledRuntimeException();
        } catch (Exception e) {
            Log.log(e);
        }
    }

    @Override
    public void exitCreate_sequence(Create_sequenceContext ctx) {
        safeParseStatement(new CreateMsSequence(ctx, db), ctx);
    }

    @Override
    public void exitCreate_schema(Create_schemaContext ctx) {
        safeParseStatement(new CreateMsSchema(ctx, db), ctx);
    }

    @Override
    public void exitCreate_or_alter_view(Create_or_alter_viewContext ctx) {
        safeParseStatement(new CreateMsView(ctx, db, ansiNulls, quotedIdentifier), ctx);
    }

    @Override
    public void exitAlter_authorization(Alter_authorizationContext ctx) {
        safeParseStatement(new AlterMsAuthorization(ctx, db), ctx);
    }

    @Override
    public void exitCreate_or_alter_trigger(Create_or_alter_triggerContext ctx) {
        safeParseStatement(new CreateMsTrigger(ctx, db, ansiNulls, quotedIdentifier), ctx);
    }

    @Override
    public void exitCreate_index(Create_indexContext ctx) {
        safeParseStatement(new CreateMsIndex(ctx, db), ctx);
    }

    @Override
    public void enterCreate_or_alter_procedure(Create_or_alter_procedureContext ctx) {
        safeParseStatement(new CreateMsProcedure(ctx, db, ansiNulls, quotedIdentifier), ctx);
    }

    @Override
    public void exitCreate_or_alter_function(Create_or_alter_functionContext ctx) {
        safeParseStatement(new CreateMsFunction(ctx, db, ansiNulls, quotedIdentifier), ctx);
    }

    @Override
    public void exitCreate_table(Create_tableContext ctx) {
        safeParseStatement(new CreateMsTable(ctx, db, ansiNulls, quotedIdentifier), ctx);
    }

    @Override
    public void exitAlter_table(Alter_tableContext ctx) {
        safeParseStatement(new AlterMsTable(ctx, db), ctx);
    }

    @Override
    public void exitRule_common(Rule_commonContext ctx) {
        safeParseStatement(new CreateMsRule(ctx, db), ctx);
    }

    @Override
    public void exitSet_special(Set_specialContext ctx) {
        if (ctx.name == null) {
            return;
        }

        String set = ctx.name.getText();
        switch (set.toLowerCase()) {
        case "ansi_nulls":
            if (ctx.ON() != null) {
                ansiNulls = true;
            } else if (ctx.OFF() != null) {
                ansiNulls = false;
            }
            break;
        case "quoted_identifier":
            if (ctx.ON() != null) {
                quotedIdentifier = true;
            } else if (ctx.OFF() != null) {
                quotedIdentifier = false;
            }
            break;
        default:
            break;
        }
    }

    static AntlrError handleUnresolvedReference(UnresolvedReferenceException ex, String filename) {
        Token t = ex.getErrorToken();
        Log.log(Log.LOG_WARNING, ex.getMessage(), ex);
        return new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(), ex.getMessage());
    }

    static AntlrError handleCreationException(ObjectCreationException ex, String filename, ParserRuleContext ctx) {
        Token t = ctx.getStart();
        Log.log(Log.LOG_WARNING, ex.getMessage(), ex);
        return new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(),  ex.getMessage());
    }
}