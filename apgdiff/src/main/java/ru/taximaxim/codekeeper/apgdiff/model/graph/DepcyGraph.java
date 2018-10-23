package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DepcyGraph {

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
        db = graphSrc.deepCopy();
        create();
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
            }
        });
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
            AbstractTable table = (AbstractTable) refTable.getStatement(db);
            if (table != null) {
                for (AbstractConstraint refCon : table.getConstraints()) {
                    if ((refCon.isPrimaryKey() || refCon.isUnique()) && refs.equals(refCon.getColumns())) {
                        graph.addEdge(con, refCon);
                    }
                }
                for (AbstractIndex refInd : table.getIndexes()) {
                    if (refInd.isUnique() && refs.equals(refInd.getColumns())) {
                        graph.addEdge(con, refInd);
                    }
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
