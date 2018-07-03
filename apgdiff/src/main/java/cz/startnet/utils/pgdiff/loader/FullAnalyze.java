package cz.startnet.utils.pgdiff.loader;

import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AbstractTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public final class FullAnalyze {

    public static void fullAnalyze(PgDatabase db) {
        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator =
                new TopologicalOrderIterator<>(new DepcyGraph(db).getReversedGraph());

        orderIterator.addTraversalListener(new AnalyzeTraversalListenerAdapter(db));

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

            switch (statementType) {
            case RULE:
                CreateRewrite.analyzeRulesCreate((Create_rewrite_statementContext) ctx,
                        (PgRule) statement, schemaName, db);
                break;
            case TRIGGER:
                CreateTrigger.analyzeTriggersWhen((VexContext) ctx,
                        (PgTrigger) statement, schemaName, db);
                break;
            case INDEX:
                CreateIndex.analyzeIndexRest((Index_restContext) ctx, statement,
                        schemaName, db);
                break;
            case CONSTRAINT:
                AbstractTable.analyzeConstraintCtx(ctx, statement, schemaName, db);
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
        }

        db.getContextsForAnalyze().clear();
    }

    private static class AnalyzeTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        private final PgDatabase db;

        AnalyzeTraversalListenerAdapter(PgDatabase db) {
            this.db = db;
        }

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> event) {
            PgStatement stmt = event.getVertex();
            if (DbObjType.VIEW.equals(stmt.getStatementType())) {
                db.getContextsForAnalyze().stream().filter(e -> stmt.equals(e.getKey()))
                .forEach(e -> CreateView.analyzeViewCtx(e.getValue(), (PgView) e.getKey(),
                        stmt.getParent().getName(), db));
            }
        }
    }

    private FullAnalyze() {
    }
}
