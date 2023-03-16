/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.model.graph;

import java.util.HashSet;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class SimpleDepcyResolver {

    private final PgDatabase oldDb;
    private final PgDatabase newDb;
    private final DepcyGraph oldDepcyGraph;
    private final DepcyGraph newDepcyGraph;

    public SimpleDepcyResolver(PgDatabase oldDatabase, boolean isShowColumns) {
        this(oldDatabase, null, isShowColumns);
    }

    public SimpleDepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase, boolean isShowColumns) {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase, !isShowColumns);
        this.newDepcyGraph = newDatabase == null ? null : new DepcyGraph(newDatabase, !isShowColumns);
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

    private static class DepcyIterator extends TraversalListenerAdapter<PgStatement, DefaultEdge> {
        private final Set<PgStatement> depcies;

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
        Graph<PgStatement, DefaultEdge> currentGraph = oldDepcyGraph.getGraph();
        for (DefaultEdge e : currentGraph.outgoingEdgesOf(entity)) {
            connected.add(currentGraph.getEdgeTarget(e));
        }

        return connected;
    }
}
