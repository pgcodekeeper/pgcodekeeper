package cz.startnet.utils.pgdiff.loader;

import java.util.List;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public final class FullAnalyze {

    private final List<? super AntlrError> errors;
    private final PgDatabase db;

    public FullAnalyze(PgDatabase db, List<? super AntlrError> errors) {
        this.db = db;
        this.errors = errors;
    }

    public static void fullAnalyze(PgDatabase db, List<? super AntlrError> errors) {
        new FullAnalyze(db, errors).fullAnalyze();
    }

    public void fullAnalyze() {
        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator =
                new TopologicalOrderIterator<>(new DepcyGraph(db).getReversedGraph());

        orderIterator.addTraversalListener(new ViewsAnalyzeTraversal());

        // 'VIEW' statements analysis.
        while (orderIterator.hasNext()) {
            orderIterator.next();
        }

        // Analysis of all statements except 'VIEW'.
        db.getAnalysisLaunchers().stream()
        .filter(l -> DbObjType.VIEW != l.getStmt().getStatementType())
        .forEach(l -> l.launchAnalyze(errors));
        db.getAnalysisLaunchers().clear();
    }

    private class ViewsAnalyzeTraversal extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> event) {
            PgStatement st = event.getVertex();
            if (DbObjType.VIEW != st.getStatementType()) {
                return;
            }

            db.getAnalysisLaunchers().stream()
            .filter(l -> st.equals(l.getStmt()))
            .forEach(l -> l.launchAnalyze(errors));
        }
    }
}
