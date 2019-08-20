package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DepcyWriter {

    private static final int START_LEVEL = 0;

    private final PgDatabase db;
    private final DirectedGraph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;

    public DepcyWriter(PgDatabase db, int depth, PrintWriter writer) {
        this.db = db;
        this.graph = new DepcyGraph(db).getReversedGraph();
        this.writer = writer;
        this.depth = depth;
    }

    public void write(Collection<String> names) {
        if (!names.isEmpty()) {
            // problem with function signature? regex?
            db.getDescendants()
            .flatMap(AbstractTable::columnAdder)
            .filter(st -> names.contains(st.getName()))
            .forEach(st ->  printTree(st, START_LEVEL, new HashSet<>()));
        } else {
            printTree(db, START_LEVEL, new HashSet<>());
        }
    }

    private void printTree(PgStatement st, int level, Set<PgStatement> added) {
        // recording format as cli argument?
        for (int i = 0; i < level; i++) {
            writer.print("\t");
        }
        if (!added.add(st)) {
            writer.println(st.getStatementType() + " " + st.getQualifiedName() + " - cyclic dependency");
            return;
        }

        writer.println(st.getStatementType() + " " + st.getQualifiedName());
        if (depth > level + 1) {
            for (DefaultEdge e : graph.outgoingEdgesOf(st)) {
                printTree(graph.getEdgeTarget(e), level + 1, new HashSet<>(added));
            }
        }
    }
}
