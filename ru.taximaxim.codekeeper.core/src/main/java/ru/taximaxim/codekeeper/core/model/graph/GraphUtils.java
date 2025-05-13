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

import java.util.Collections;
import java.util.List;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class GraphUtils {

    public static List<PgStatement> reverse(DepcyGraph depcyGraph, PgStatement statement) {
        if (!depcyGraph.getReversedGraph().containsVertex(statement)) {
            return Collections.emptyList();
        }
        var adapter = new CollectingTraversalAdapter(statement);
        var dfi = new DepthFirstIterator<>(depcyGraph.getReversedGraph(), statement);
        iterate(dfi, adapter);
        return adapter.getStatements();
    }

    public static List<PgStatement> forward(DepcyGraph depcyGraph, PgStatement statement) {
        if (!depcyGraph.getGraph().containsVertex(statement)) {
            return Collections.emptyList();
        }
        var adapter = new CollectingTraversalAdapter(statement);
        var dfi = new DepthFirstIterator<>(depcyGraph.getGraph(), statement);
        iterate(dfi, adapter);
        return adapter.getStatements();
    }

    /**
     * Проходит по итератору и заполняет список объектами из итератора
     *
     * @param dfi
     *            итератор для прохода
     * @param action
     *            список объектов из итератора
     */
    private static void iterate(DepthFirstIterator<PgStatement, DefaultEdge> dfi,
            TraversalListenerAdapter<PgStatement, DefaultEdge> adapter) {
        dfi.addTraversalListener(adapter);
        while (dfi.hasNext()) {
            dfi.next();
        }
    }

    private GraphUtils() {
        // only statics
    }
}
