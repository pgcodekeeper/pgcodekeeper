package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.HashSet;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SimpleDepcyResolver {

    private final PgDatabase oldDb;
    private final PgDatabase newDb;
    private final DepcyGraph oldDepcyGraph;
    private final DepcyGraph newDepcyGraph;

    public SimpleDepcyResolver(PgDatabase oldDatabase) {
        this(oldDatabase, null);
    }

    public SimpleDepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase) {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase, true);
        this.newDepcyGraph = newDatabase == null ? null : new DepcyGraph(newDatabase, true);
    }

    public Set<PgStatement> getCreateDepcies(PgStatement toCreate) {
        if (newDb == null) {
            throw new IllegalStateException("New database not setted");
        }

        PgStatement statement = toCreate.getTwin(newDb);
        Set<PgStatement> depcies = new HashSet<>();
        if (newDepcyGraph.getGraph().containsVertex(statement)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    newDepcyGraph.getGraph(), statement);
            dfi.addTraversalListener(new DepcyIterator(depcies));
            while (dfi.hasNext()) {
                dfi.next();
            }
        }

        return depcies;
    }

    public Set<PgStatement> getDropDepcies(PgStatement toDrop) {
        PgStatement statement = toDrop.getTwin(oldDb);
        Set<PgStatement> depcies = new HashSet<>();
        if (oldDepcyGraph.getReversedGraph().containsVertex(statement)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    oldDepcyGraph.getReversedGraph(), statement);
            dfi.addTraversalListener(new DepcyIterator(depcies));
            while (dfi.hasNext()) {
                dfi.next();
            }
        }

        return depcies;
    }

    private class DepcyIterator extends TraversalListenerAdapter<PgStatement, DefaultEdge> {
        Set<PgStatement> depcies = new HashSet<>();

        public DepcyIterator(Set<PgStatement> depcies) {
            this.depcies = depcies;
        }

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement statement = e.getVertex();
            if (statement.getStatementType() != DbObjType.DATABASE) {
                depcies.add(statement);
            }
        }
    }

    public Set<PgStatement> getConnectedTo(PgStatement entity) {
        Set<PgStatement> connected = new HashSet<>();
        DirectedGraph<PgStatement, DefaultEdge> currentGraph = oldDepcyGraph.getGraph();
        for (DefaultEdge e : currentGraph.outgoingEdgesOf(entity)) {
            connected.add(currentGraph.getEdgeTarget(e));
        }

        return connected;
    }
}
