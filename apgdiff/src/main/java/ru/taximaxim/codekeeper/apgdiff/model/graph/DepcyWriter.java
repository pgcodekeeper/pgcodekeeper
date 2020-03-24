package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DepcyWriter {

    private static final int START_LEVEL = 0;

    private final PgDatabase db;
    private final DirectedGraph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;

    public DepcyWriter(PgDatabase db, int depth, PrintWriter writer, boolean isReverse) {
        this.db = db;
        DepcyGraph dg = new DepcyGraph(db);
        this.graph = isReverse ? dg.getGraph() : dg.getReversedGraph();
        this.writer = writer;
        this.depth = depth;
    }

    public void write(Collection<String> names) {
        if (!names.isEmpty()) {
            List<PgStatement> list = db.getDescendants().flatMap(AbstractTable::columnAdder)
                    .filter(st -> names.contains(st.getName())).collect(Collectors.toList());
            if (list.isEmpty()) {
                list = db.getDescendants().flatMap(AbstractTable::columnAdder)
                        .filter(st -> find(names, st.getName())).collect(Collectors.toList());
            }

            list.forEach(st ->  printTree(st, START_LEVEL, new HashSet<>()));
        } else {
            printTree(db, START_LEVEL, new HashSet<>());
        }
    }

    private boolean find(Collection<String> names, String statement) {
        for (String name : names) {
            if (statement.contains(name)) {
                return true;
            }
        }

        return false;
    }

    private void printTree(PgStatement st, int level, Set<PgStatement> added) {
        DbObjType type = st.getStatementType();
        if (DbObjType.DATABASE == type && START_LEVEL != level) {
            // do not show database in reverse graph
            return;
        }

        for (int i = 0; i < level; i++) {
            writer.print("\t");
        }
        if (!added.add(st)) {
            writer.println(type + " " + st.getQualifiedName() + " - cyclic dependency");
            return;
        }

        writer.println(type + " " + st.getQualifiedName());
        if (depth > level + 1) {
            for (DefaultEdge e : graph.outgoingEdgesOf(st)) {
                printTree(graph.getEdgeTarget(e), level + 1, new HashSet<>(added));
            }
        }
    }
}
