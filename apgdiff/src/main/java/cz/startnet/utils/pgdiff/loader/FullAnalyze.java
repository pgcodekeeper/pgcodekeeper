package cz.startnet.utils.pgdiff.loader;

import java.util.List;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractTrigger;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public final class FullAnalyze {

    public static void fullAnalyze(PgDatabase db, List<AntlrError> errors) {
        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator =
                new TopologicalOrderIterator<>(new DepcyGraph(db).getReversedGraph());

        orderIterator.addTraversalListener(new AnalyzeTraversalListenerAdapter(db, errors));

        // 'VIEW' statements analysis.
        while (orderIterator.hasNext()) {
            orderIterator.next();
        }

        // Analysis of all statements except 'VIEW'.
        for (Entry<PgStatementWithSearchPath, ParserRuleContext> entry : db.getContextsForAnalyze()) {
            PgStatementWithSearchPath statement = entry.getKey();
            DbObjType statementType = statement.getStatementType();

            // Duplicated objects doesn't have parent, skip them
            if (DbObjType.VIEW == statementType || statement.getParent() == null) {
                continue;
            }

            ParserRuleContext ctx = entry.getValue();
            String schemaName = statement.getContainingSchema().getName();

            try {
                switch (statementType) {
                case RULE:
                    CreateRewrite.analyzeRulesCreate((Create_rewrite_statementContext) ctx,
                            (PgRule) statement, schemaName, db);
                    break;
                case TRIGGER:
                    CreateTrigger.analyzeTriggersWhen((VexContext) ctx,
                            (AbstractTrigger) statement, schemaName, db);
                    break;
                case INDEX:
                    CreateIndex.analyzeIndexRest((Index_restContext) ctx, statement,
                            schemaName, db);
                    break;
                case CONSTRAINT:
                    TableAbstract.analyzeConstraintCtx((VexContext) ctx, statement, schemaName, db);
                    break;
                case DOMAIN:
                case FUNCTION:
                case COLUMN:
                    UtilAnalyzeExpr.analyze((VexContext) ctx, new ValueExpr(schemaName,
                            db), statement);
                    break;
                default:
                    throw new IllegalStateException("The analyze for the case '"
                            + statementType + ' ' + statement
                            + "' is not defined!"); //$NON-NLS-1$
                }

            } catch (UnresolvedReferenceException ex) {
                unresolvRefExHandler(ex, errors, ctx, statement.getLocation());
            } catch (Exception ex) {
                addError(errors, CustomParserListener.handleParserContextException(
                        ex, statement.getLocation(), ctx));
            }
        }

        db.getContextsForAnalyze().clear();
    }

    private static class AnalyzeTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        private final PgDatabase db;
        private final List<AntlrError> errors;

        AnalyzeTraversalListenerAdapter(PgDatabase db, List<AntlrError> errors) {
            this.db = db;
            this.errors = errors;
        }

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> event) {
            PgStatement stmt = event.getVertex();
            if (DbObjType.VIEW.equals(stmt.getStatementType())) {
                db.getContextsForAnalyze().stream().filter(e -> stmt.equals(e.getKey()))
                .forEach(e -> {
                    ParserRuleContext ctx = e.getValue();
                    try {
                        CreateView.analyzeViewCtx(ctx, (AbstractView) e.getKey(),
                                stmt.getParent().getName(), db);
                    } catch (UnresolvedReferenceException ex) {
                        unresolvRefExHandler(ex, errors, ctx, stmt.getLocation());
                    } catch (Exception ex) {
                        addError(errors, CustomParserListener.handleParserContextException(
                                ex, stmt.getLocation(), ctx));
                    }
                });
            }

        }
    }

    private static void unresolvRefExHandler(UnresolvedReferenceException ex,
            List<AntlrError> errors, ParserRuleContext ctx, String location) {
        if (ex.getErrorToken() == null) {
            ex.setErrorToken(ctx.getStart());
        }
        addError(errors, CustomSQLParserListener.handleUnresolvedReference(ex, location));
    }

    private static void addError(List<AntlrError> errors, AntlrError err) {
        if (errors != null) {
            errors.add(err);
        }
    }

    private FullAnalyze() {
    }
}
