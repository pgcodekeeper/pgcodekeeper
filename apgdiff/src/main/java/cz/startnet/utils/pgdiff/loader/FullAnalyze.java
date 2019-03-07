package cz.startnet.utils.pgdiff.loader;

import java.util.List;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.launcher.AbstractAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public final class FullAnalyze {

    private final List<AntlrError> errors;
    private final PgDatabase db;

    public FullAnalyze(PgDatabase db, List<AntlrError> errors) {
        this.db = db;
        this.errors = errors;
    }

    public static void fullAnalyze(PgDatabase db, List<AntlrError> errors) {
        new FullAnalyze(db, errors).fullAnalyze();
    }

    public void fullAnalyze() {
        TopologicalOrderIterator<PgStatement, DefaultEdge> orderIterator =
                new TopologicalOrderIterator<>(new DepcyGraph(db).getReversedGraph());

        orderIterator.addTraversalListener(new AnalyzeTraversalListenerAdapter(db, errors));

        // 'VIEW' statements analysis.
        while (orderIterator.hasNext()) {
            orderIterator.next();
        }

        // Analysis of all statements except 'VIEW'.
        for (AbstractAnalysisLauncher launcher : db.getAnalysisLaunchers()) {
            if (DbObjType.VIEW == launcher.getStmt().getStatementType()) {
                continue;
            }
            launcher.setErrors(errors);
            launcher.setFinalDb(db);
            launcher.launchAnalyze();
        }

        db.getAnalysisLaunchers().clear();
    }

    private class AnalyzeTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        private final PgDatabase db;
        private final List<AntlrError> errors;

        AnalyzeTraversalListenerAdapter(PgDatabase db, List<AntlrError> errors) {
            this.db = db;
            this.errors = errors;
        }

        @Override
        public void vertexTraversed(VertexTraversalEvent<PgStatement> event) {
            PgStatement st = event.getVertex();
            if (DbObjType.VIEW != st.getStatementType()) {
                return;
            }

            if (st.getDatabase() != db) {
                // statement came from another DB object, probably a library
                // for proper depcy processing, find its twin in the final DB object
                st = st.getTwin(db);
            }

            PgStatement stmt = st;
            db.getAnalysisLaunchers()
            .stream().filter(l -> stmt.equals(l.getStmt())).forEach(l -> {
                l.setErrors(errors);
                l.setFinalDb(db);
                l.launchAnalyze();
            });
        }
    }
}
