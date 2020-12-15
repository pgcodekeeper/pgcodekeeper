package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DepcyWriter {

    private static final int START_LEVEL = 0;
    private int hiddenObj = 0;

    private final PgDatabase db;
    private final DirectedGraph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;
    private final Collection<DbObjType> filterObjTypes;
    private final boolean isInvertFilter;
    protected final LinkedHashSet<PrintObj> printObjects = new LinkedHashSet<>();

    public DepcyWriter(PgDatabase db, int depth, PrintWriter writer, boolean isReverse, Collection<DbObjType> filterObjTypes, boolean isInvertFilter) {
        this.db = db;
        DepcyGraph dg = new DepcyGraph(db);
        this.graph = isReverse ? dg.getGraph() : dg.getReversedGraph();
        this.writer = writer;
        this.depth = depth;
        this.filterObjTypes = filterObjTypes;
        this.isInvertFilter = isInvertFilter;
    }

    public void write(Collection<String> names) {
        if (!names.isEmpty()) {
            db.getDescendants().flatMap(AbstractTable::columnAdder)
            .filter(st -> find(names, st.getQualifiedName()))
            .forEach(st ->  printTree(st, START_LEVEL, new HashSet<>(), st));
        } else {
            printTree(db, START_LEVEL, new HashSet<>(), db);
        }
        if (!printObjects.isEmpty()) {
            for (PrintObj prObj : printObjects) {
                printIndent(prObj.getIndent());
                writer.println(prObj.getActualStSt().getStatementType() + " "
                        + prObj.getActualStSt().getQualifiedName() + " (hidden "
                        + prObj.getHiddenObj() + " objects)");
            }
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

    private void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            writer.print("\t");
        }
    }

    private boolean isPrintObj(PgStatement st) {
        DbObjType type = st.getStatementType();
        if (!filterObjTypes.isEmpty()) {
            if (!isInvertFilter) {
                if (filterObjTypes.contains(type)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (!filterObjTypes.contains(type)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private PgStatement addObjInSet(PgStatement st, int level, PgStatement parentSt,
            int hiddenObj) {
        PrintObj printObj = new PrintObj(st, parentSt, level, hiddenObj);
        printObjects.add(printObj);
        return parentSt = st;
    }

    private void printTree(PgStatement st, int level, Set<PgStatement> added, PgStatement parentSt) {
        DbObjType type = st.getStatementType();

        if (DbObjType.DATABASE == type && START_LEVEL != level) {
            // do not show database in reverse graph
            return;
        }

        if (!added.add(st)) {
            writer.println(type + " " + st.getQualifiedName() + " - cyclic dependency");
            return;
        }

        if (isPrintObj(st)) {
            parentSt = addObjInSet(st, level, parentSt, hiddenObj);
            hiddenObj = 0;
            level++;
        } else {
            if (filterObjTypes.isEmpty()) {
                parentSt = addObjInSet(st, level, parentSt, hiddenObj);
                level++;
            } else {
                hiddenObj++;
            }
        }
        if (depth > level) {
            Set<PgStatement> pgStatSet = new LinkedHashSet<>();

            for (DefaultEdge defEdg : graph.outgoingEdgesOf(st)) {
                pgStatSet.add(graph.getEdgeTarget(defEdg));
            }

            final int finalLevel = level;
            final PgStatement finalParentSt = parentSt;

            pgStatSet.stream()
            .sorted(Comparator.comparing(PgStatement::getStatementType))
            .forEach(pgSt -> printTree(pgSt, finalLevel, new HashSet<>(added), finalParentSt));
        }
    }
}
