package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractPgTable;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.Inherits;
import cz.startnet.utils.pgdiff.schema.PartitionPgTable;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class DepcyGraph {

    private static final String REMOVE_DEP = "Remove dependency from {0} to {1}";

    private final DirectedGraph<PgStatement, DefaultEdge> graph =
            new SimpleDirectedGraph<>(DefaultEdge.class);

    private final EdgeReversedGraph<PgStatement, DefaultEdge> reversedGraph =
            new EdgeReversedGraph<>(graph);

    /**
     * Направление связей в графе:<br>
     * зависящий объект → зависимость <br>
     * source → target
     */
    public DirectedGraph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }

    public EdgeReversedGraph<PgStatement, DefaultEdge> getReversedGraph(){
        return reversedGraph;
    }

    private final PgDatabase db;

    /**
     * Copied database, graph source.<br>
     * <b>Do not modify</b> any elements in this as it will break
     * HashSets/HashMaps and with them the generated graph.
     */
    public PgDatabase getDb(){
        return db;
    }

    public DepcyGraph(PgDatabase graphSrc) {
        this(graphSrc, false);
    }

    /**
     * @param reduceGraph if true, merge column nodes into table nodes in the graph
     */
    public DepcyGraph(PgDatabase graphSrc, boolean reduceGraph) {
        db = (PgDatabase) graphSrc.deepCopy();
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
            if (st.getStatementType() == DbObjType.CONSTRAINT) {
                createFkeyToUnique((AbstractConstraint)st);
            } else if (st.getStatementType() == DbObjType.COLUMN
                    && st.isPostgres()) {
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
                    Log.log(Log.LOG_INFO, MessageFormat.format(REMOVE_DEP,
                            st.getQualifiedName(), vertex.getQualifiedName()));

                    PgStatement table = vertex.getParent();
                    if (graph.removeEdge(st, table) != null) {
                        Log.log(Log.LOG_INFO, MessageFormat.format(REMOVE_DEP,
                                st.getQualifiedName(), table.getQualifiedName()));
                    }
                }
            }
        }
    }

    private void processDeps(PgStatement st) {
        for (GenericColumn dep : st.getDeps()) {
            PgStatement depSt = dep.getStatement(db);
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
    private void createFkeyToUnique(AbstractConstraint con) {
        Set<String> refs = con.getForeignColumns();
        GenericColumn refTable = con.getForeignTable();
        if (!refs.isEmpty() && refTable != null) {
            PgStatement cont = refTable.getStatement(db);
            if (cont instanceof IStatementContainer) {
                IStatementContainer c = (IStatementContainer) cont;
                for (AbstractConstraint refCon : c.getConstraints()) {
                    if ((refCon.isPrimaryKey() || refCon.isUnique()) && refs.equals(refCon.getColumns())) {
                        graph.addEdge(con, refCon);
                    }
                }
                for (AbstractIndex refInd : c.getIndexes()) {
                    if (refInd.isUnique() && refs.equals(refInd.getColumns())) {
                        graph.addEdge(con, refInd);
                    }
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
            PgStatement parentTbl = new GenericColumn(in.getKey(), in.getValue(),
                    DbObjType.TABLE).getStatement(db);
            if (parentTbl == null) {
                Log.log(Log.LOG_ERROR, "There is no such partitioned table as: "
                        + in.getQualifiedName());
                continue;
            }

            if (parentTbl instanceof PartitionPgTable) {
                createChildColToPartTblCol((PartitionPgTable) parentTbl, col);
            } else {
                String colName = col.getName();
                AbstractColumn parentCol = ((AbstractTable) parentTbl).getColumn(colName);
                if (parentCol != null) {
                    graph.addEdge(col, parentCol);
                } else {
                    Log.log(Log.LOG_ERROR, "The parent '" + in.getQualifiedName()
                    + '.' + colName + "' column for '" + col.getSchemaName()
                    + '.' + col.getParent().getName()
                    + '.' + colName + "' column is missed.");
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
