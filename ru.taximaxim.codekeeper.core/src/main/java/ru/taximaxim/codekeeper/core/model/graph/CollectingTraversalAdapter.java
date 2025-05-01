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

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

final class CollectingTraversalAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

    private final List<PgStatement> statements = new ArrayList<>();

    private final PgStatement starter;

    public CollectingTraversalAdapter(PgStatement starter) {
        this.starter = starter;
    }

    @Override
    public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
        PgStatement statement = e.getVertex();
        if (statement.getStatementType() != DbObjType.DATABASE && statement != starter) {
            statements.add(statement);
        }
    }

    List<PgStatement> getStatements() {
        return statements;
    }
}
