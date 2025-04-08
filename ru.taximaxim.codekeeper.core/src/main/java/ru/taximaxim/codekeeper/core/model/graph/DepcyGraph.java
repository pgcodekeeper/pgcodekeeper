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
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.IConstraintPk;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PartitionPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class DepcyGraph {

    private static final Logger LOG = LoggerFactory.getLogger(DepcyGraph.class);

    private static final String REMOVE_DEP = "Remove dependency from {0} to {1}";

    private final Graph<PgStatement, DefaultEdge> graph =
            new SimpleDirectedGraph<>(DefaultEdge.class);

    private final EdgeReversedGraph<PgStatement, DefaultEdge> reversedGraph =
            new EdgeReversedGraph<>(graph);

    /**
     * Направление связей в графе:<br>
     * зависящий объект → зависимость <br>
     * source → target
     */
    public Graph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }

    public EdgeReversedGraph<PgStatement, DefaultEdge> getReversedGraph(){
        return reversedGraph;
    }

    private final AbstractDatabase db;

    /**
     * Copied database, graph source.<br>
     * <b>Do not modify</b> any elements in this as it will break
     * HashSets/HashMaps and with them the generated graph.
     */
    public AbstractDatabase getDb() {
        return db;
    }

    public DepcyGraph(AbstractDatabase graphSrc, ISettings settings) {
        this(graphSrc, false);
    }

    /**
     * @param reduceGraph if true, merge column nodes into table nodes in the graph
     */
    public DepcyGraph(AbstractDatabase graphSrc, boolean reduceGraph) {
        db = (AbstractDatabase) graphSrc.deepCopy();
        create();
        removeCycles();

        if (reduceGraph) {
            reduce();
        }
    }

    private void create() {
        graph.addVertex(db);

        // first pass: object tree
        db.getDescendants().flatMap(AbstractTable::columnAdder).forEach(st -> {
            graph.addVertex(st);
            graph.addEdge(st, st.getParent());
        });


        // second pass: dependency graph
        db.getDescendants().flatMap(AbstractTable::columnAdder).forEach(st -> {
            processDeps(st);
            if (st instanceof IConstraintFk fk) {
                createFkeyToUnique(fk);
            } else if (st.getStatementType() == DbObjType.COLUMN
                    && st.getDbType() == DatabaseType.PG) {
                PgColumn col = (PgColumn) st;
                PgStatement tbl = col.getParent();
                if (st.getParent() instanceof PartitionPgTable) {
                    createChildColToPartTblCol((PartitionPgTable) tbl, col);
                } else {
                    // Creating the connection between the column of a inherit
                    // table and the columns of its child tables.

                    AbstractColumn parentTblCol = col.getParentCol((AbstractPgTable) tbl);
                    if (parentTblCol != null) {
                        graph.addEdge(col, parentTblCol);
                    }
                }
            }
        });
    }

    private void reduce() {
        List<Pair<PgStatement, PgStatement>> newEdges = new ArrayList<>();
        for (DefaultEdge edge : graph.edgeSet()) {
            PgStatement source = graph.getEdgeSource(edge);
            PgStatement target = graph.getEdgeTarget(edge);
            boolean changeEdge = false;
            if (source.getStatementType() == DbObjType.COLUMN) {
                changeEdge = true;
                source = source.getParent();
            }
            if (target.getStatementType() == DbObjType.COLUMN) {
                changeEdge = true;
                target = target.getParent();
            }
            if (changeEdge && !source.equals(target)) {
                newEdges.add(new Pair<>(source, target));
            }
        }
        for (Pair<PgStatement, PgStatement> edge : newEdges) {
            graph.addEdge(edge.getFirst(), edge.getSecond());
        }

        List<PgStatement> toRemove = new ArrayList<>();
        for (PgStatement st : graph.vertexSet()) {
            if (st.getStatementType() == DbObjType.COLUMN) {
                toRemove.add(st);
            }
        }
        graph.removeAllVertices(toRemove);
    }

    private void removeCycles() {
        CycleDetector<PgStatement, DefaultEdge> detector = new CycleDetector<>(graph);

        for (PgStatement st : detector.findCycles()) {
            if (!(st instanceof AbstractPgFunction)) {
                continue;
            }

            for (PgStatement vertex : detector.findCyclesContainingVertex(st)) {
                if (vertex.getStatementType() == DbObjType.COLUMN) {
                    graph.removeEdge(st, vertex);
                    LOG.info(REMOVE_DEP, st.getQualifiedName(), vertex.getQualifiedName());

                    PgStatement table = vertex.getParent();
                    if (graph.removeEdge(st, table) != null) {
                        LOG.info(REMOVE_DEP, st.getQualifiedName(), table.getQualifiedName());
                    }
                }
            }
        }
    }

    private void processDeps(PgStatement st) {
        for (GenericColumn dep : st.getDeps()) {
            PgStatement depSt = db.getStatement(dep);
            if (depSt != null && !st.equals(depSt)) {
                graph.addEdge(st, depSt);
            }
        }
    }

    /**
     * The only way to find this depcy is to compare refcolumns against all existing unique
     * contraints/keys in reftable.
     * Unfortunately they might not exist at the stage where {@link PgStatement#getDeps()}
     * are populated so we have to defer their lookup until here.
     */
    private void createFkeyToUnique(IConstraintFk con) {
        Set<String> refs = con.getForeignColumns();
        if (refs.isEmpty()) {
            return;
        }

        IStatement cont = db.getStatement(
                new GenericColumn(con.getForeignSchema(), con.getForeignTable(), DbObjType.TABLE));

        if (cont instanceof PgStatementContainer c) {
            for (AbstractConstraint refCon : c.getConstraints()) {
                if (refCon instanceof IConstraintPk && refs.equals(refCon.getColumns())) {
                    graph.addEdge((PgStatement) con, refCon);
                }
            }
            for (AbstractIndex refInd : c.getIndexes()) {
                if (refInd.isUnique() && refInd.compareColumns(refs)) {
                    graph.addEdge((PgStatement) con, refInd);
                }
            }
        }
    }

    /**
     * Creates the connection between the column of a partitioned table and the
     * columns of its sections (child tables).
     * <br />
     * Partitioned tables cannot use the inheritance mechanism, as in simple tables.
     */
    private void createChildColToPartTblCol(PartitionPgTable tbl, PgColumn col) {
        for (Inherits in : tbl.getInherits()) {
            IStatement parentTbl = db.getStatement(new GenericColumn(in.getKey(), in.getValue(), DbObjType.TABLE));
            if (parentTbl == null) {
                LOG.error("There is no such partitioned table as: {}", in.getQualifiedName());
                continue;
            }

            if (parentTbl instanceof PartitionPgTable partTable) {
                createChildColToPartTblCol(partTable, col);
            } else {
                String colName = col.getName();
                AbstractColumn parentCol = ((AbstractTable) parentTbl).getColumn(colName);
                if (parentCol != null) {
                    graph.addEdge(col, parentCol);
                } else {
                    LOG.error("The parent ''{}.{}'' column for ''{}.{}.{}'' column is missed.",
                            in.getQualifiedName(), colName, col.getSchemaName(), col.getParent().getName(), colName);
                }
            }
        }
    }

    public void addCustomDepcies(List<Entry<PgStatement, PgStatement>> depcies) {
        for (Entry<PgStatement, PgStatement> depcy : depcies) {
            graph.addEdge(depcy.getKey(), depcy.getValue());
        }
    }
}
