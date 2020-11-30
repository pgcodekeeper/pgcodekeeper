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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DepcyWriter {

    private static final int START_LEVEL = 0;
    private static int hiddenObj = 0;

    private final PgDatabase db;
    private final DirectedGraph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;
    private final Collection<DbObjType> filtrObjTypes;
    private final boolean isInverseFiltr;

    public DepcyWriter(PgDatabase db, int depth, PrintWriter writer, boolean isReverse, Collection<DbObjType> filtrObjTypes, boolean isInverseFiltr) {
        this.db = db;
        DepcyGraph dg = new DepcyGraph(db);
        this.graph = isReverse ? dg.getGraph() : dg.getReversedGraph();
        this.writer = writer;
        this.depth = depth;
        this.filtrObjTypes = filtrObjTypes;
        this.isInverseFiltr = isInverseFiltr;
    }

    public void write(Collection<String> names) {
        if (!names.isEmpty()) {
            db.getDescendants().flatMap(AbstractTable::columnAdder)
            .filter(st -> find(names, st.getQualifiedName()))
            .forEach(st ->  printTree(st, START_LEVEL, new HashSet<>()));
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

    private void printIndents(DbObjType type, int level) {
        if (!filtrObjTypes.isEmpty()) {
            if (!isInverseFiltr) {
                if (filtrObjTypes.contains(type)) {
                    printIndent(level);
                }
            } else {
                if ((!filtrObjTypes.contains(type))) {
                    printIndent(level);
                }
            }
        } else {
            printIndent(level);
        }
    }

    private void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            writer.print("\t");
        }
    }

    private void printType(DbObjType type, PgStatement st) {
        writer.println(type + " " + st.getQualifiedName() + " (hidden "
                + hiddenObj + " objects)");
        hiddenObj = 0;
    }

    private int printObj(PgStatement st, int level) {
        DbObjType type = st.getStatementType();
        if (!filtrObjTypes.isEmpty()) {
            if (!isInverseFiltr) {
                if (filtrObjTypes.contains(type)) {
                    printType(type, st);
                    level++;
                } else {
                    hiddenObj++;
                }
            } else {
                if (!filtrObjTypes.contains(type)) {
                    printType(type, st);
                    level++;
                } else {
                    hiddenObj++;
                }
            }
        } else {
            writer.println(type + " " + st.getQualifiedName());
            level++;
        }
        return level;
    }

    private void printTree(PgStatement st, int level, Set<PgStatement> added) {
        DbObjType type = st.getStatementType();
        if (DbObjType.DATABASE == type && START_LEVEL != level) {
            // do not show database in reverse graph
            return;
        }

        printIndents(type, level);
        if (!added.add(st)) {
            writer.println(type + " " + st.getQualifiedName() + " - cyclic dependency");
            return;
        }

        level = printObj(st, level);
        if (depth > level) {
            for (DefaultEdge e : graph.outgoingEdgesOf(st)) {
                printTree(graph.getEdgeTarget(e), level, new HashSet<>(added));
            }
        }
    }
}
