package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public final class FullAnalyze {

    private final List<? super AntlrError> errors;
    private final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    private final PgDatabase db;

    public FullAnalyze(PgDatabase db, List<? super AntlrError> errors) {
        this.db = db;
        this.errors = errors;
    }

    public static void fullAnalyze(PgDatabase db, List<? super AntlrError> errors)
            throws InterruptedException, IOException {
        new FullAnalyze(db, errors).fullAnalyze();
    }

    public void fullAnalyze() throws InterruptedException, IOException {
        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator =
                new TopologicalOrderIterator<>(new DepcyGraph(db).getReversedGraph());

        orderIterator.addTraversalListener(new ViewsAnalyzeTraversal());

        // 'VIEW' statements analysis.
        while (orderIterator.hasNext()) {
            orderIterator.next();
        }

        for (AbstractAnalysisLauncher l : db.getAnalysisLaunchers()) {
            if (l != null && DbObjType.VIEW != l.getStmt().getStatementType()) {
                AntlrParser.submitAntlrTask(antlrTasks,
                        () -> l.launchAnalyze(errors),
                        deps -> l.getStmt().addAllDeps(deps));
            }
        }
        db.clearAnalysisLaunchers();
        AntlrParser.finishAntlr(antlrTasks);
    }

    private class ViewsAnalyzeTraversal extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        private final List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> event) {
            PgStatement st = event.getVertex();
            if (DbObjType.VIEW != st.getStatementType()) {
                return;
            }

            for (int i = 0; i < launchers.size(); ++i) {
                AbstractAnalysisLauncher l = launchers.get(i);
                if (l != null && st.equals(l.getStmt())) {
                    l.launchAnalyze(errors);
                    // allow GC to reclaim context memory immediately
                    launchers.set(i, null);
                }
            }
        }
    }
}
