/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class SimpleDepcyResolver {

    private final AbstractDatabase oldDb;
    private final AbstractDatabase newDb;
    private final DepcyGraph oldDepcyGraph;
    private final DepcyGraph newDepcyGraph;

    public SimpleDepcyResolver(AbstractDatabase oldDatabase, boolean isShowColumns) {
        this(oldDatabase, null, isShowColumns);
    }

    public SimpleDepcyResolver(AbstractDatabase oldDatabase, AbstractDatabase newDatabase, boolean isShowColumns) {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase, !isShowColumns);
        this.newDepcyGraph = newDatabase == null ? null : new DepcyGraph(newDatabase, !isShowColumns);
    }

    public Collection<PgStatement> getCreateDepcies(PgStatement toCreate) {
        if (newDb == null) {
            throw new IllegalStateException("New database not setted");
        }

        PgStatement statement = toCreate.getTwin(newDb);
        var dependencies = GraphUtils.forward(newDepcyGraph, statement);
        dependencies.add(statement);
        return dependencies;
    }

    public Collection<PgStatement> getDropDepcies(PgStatement toDrop) {
        PgStatement statement = toDrop.getTwin(oldDb);
        var dependents = GraphUtils.reverse(oldDepcyGraph, statement);
        dependents.add(statement);
        return dependents;
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
