package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.DirectedGraph;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_eofContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze.Select;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public final class SecondAnalyze {

    public static void goThroughGraphForAnalyze(PgDatabase db) {
        DirectedGraph<PgStatement, DefaultEdge> graph = new DepcyGraph(db, false).getReversedGraph();

        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator = new TopologicalOrderIterator<>(graph);

        AnalyzeTraversalListenerAdapter adapter = new AnalyzeTraversalListenerAdapter(db);
        orderIterator.addTraversalListener(adapter);

        while (orderIterator.hasNext()) {
            orderIterator.next();
        }
    }

    private static class AnalyzeTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        private final PgDatabase db;

        AnalyzeTraversalListenerAdapter(PgDatabase db) {
            this.db = db;
        }

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> e) {
            PgStatement statement = e.getVertex();

            String schemaName = null;
            if (statement instanceof PgStatementWithSearchPath) {
                schemaName = ((PgStatementWithSearchPath) statement).getContainingSchema().getName();
            }

            List<ParserRuleContext> statementContexts = db.getContextsForAnalyze().stream()
                    .filter(entry -> statement.equals(entry.getKey()))
                    .map(Entry::getValue)
                    .collect(Collectors.toList());

            if (statementContexts.isEmpty()) {
                return;
            }

            ParserRuleContext first = statementContexts.get(0);

            switch (statement.getStatementType()) {
            case VIEW:
                PgView view = (PgView)statement;
                Select select = new Select(schemaName, db);
                for (ParserRuleContext ctx : statementContexts) {
                    if (ctx instanceof Select_stmtContext) {
                        view.addRelationColumns(select.analyze(ctx));
                        view.addAllDeps(select.getDepcies());
                    } else {
                        UtilAnalyzeExpr.analyze((VexContext)ctx, new ValueExpr(schemaName), view);
                    }
                }
                break;
            case RULE:
                Create_rewrite_statementContext createRewriteCtx = (Create_rewrite_statementContext) first;
                PgRule rule = (PgRule)statement;

                UtilAnalyzeExpr.analyzeRulesWhere(createRewriteCtx, rule, schemaName);
                for (Rewrite_commandContext cmd : createRewriteCtx.commands) {
                    UtilAnalyzeExpr.analyzeRulesCommand(cmd, rule, schemaName);
                }
                break;
            case TRIGGER:
                UtilAnalyzeExpr.analyzeTriggersWhen((VexContext)first,
                        (PgTrigger)statement, schemaName);
                break;
            case INDEX:
            case DOMAIN:
                UtilAnalyzeExpr.analyze((VexContext)first, new ValueExpr(schemaName), statement);
                break;
            case FUNCTION:
                for (ParserRuleContext ctx : statementContexts) {
                    if (ctx instanceof Vex_eofContext) {
                        UtilAnalyzeExpr.analyzeFunctionDefaults((Vex_eofContext)ctx,
                                (PgFunction)statement, schemaName);
                    } else {
                        UtilAnalyzeExpr.analyze((VexContext)ctx,
                                new ValueExpr(schemaName), statement);
                    }
                }
                break;
            case CONSTRAINT:
                UtilAnalyzeExpr.analyzeConstraint((Constr_bodyContext)first,
                        schemaName, (PgConstraint)statement);
                break;
            case COLUMN:
                for (ParserRuleContext ctx : statementContexts) {
                    UtilAnalyzeExpr.analyze((VexContext)ctx, new ValueExpr(schemaName), statement);
                }
                break;
            default:
                break;
            }
        }
    }

    private SecondAnalyze() {
    }
}
