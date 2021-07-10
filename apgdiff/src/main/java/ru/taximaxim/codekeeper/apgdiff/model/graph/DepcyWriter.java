package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
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

    private final PgDatabase db;
    private final DirectedGraph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;
    private final EnumSet<DbObjType> filterObjTypes;
    private final boolean isInvertFilter;
    protected final LinkedHashSet<PrintObj> printObjects = new LinkedHashSet<>();

    public DepcyWriter(PgDatabase db, int depth, PrintWriter writer, boolean isReverse, Collection<DbObjType> filterObjTypes, boolean isInvertFilter) {
        this.db = db;
        DepcyGraph dg = new DepcyGraph(db);
        this.graph = isReverse ? dg.getGraph() : dg.getReversedGraph();
        this.writer = writer;
        this.depth = depth;
        if (filterObjTypes.isEmpty()) {
            this.filterObjTypes = EnumSet.noneOf(DbObjType.class);
        } else {
            this.filterObjTypes = EnumSet.copyOf(filterObjTypes);
        }
        this.isInvertFilter = isInvertFilter;
    }

    public void write(Collection<String> names) {
        if (!names.isEmpty()) {
            db.getDescendants().flatMap(AbstractTable::columnAdder)
            .filter(st -> find(names, st.getQualifiedName()))
            .forEach(st ->  printTree(st, START_LEVEL, new HashSet<>(), null, 0));
        } else {
            printTree(db, START_LEVEL, new HashSet<>(), null, 0);
        }

        for (PrintObj prObj : printObjects) {
            printIndent(prObj.getIndent());
            writer.println(prObj.getStatement().getStatementType() + " "
                    + prObj.getStatement().getQualifiedName() + (prObj.getHiddenObj() != 0 ?
                            " (hidden " + prObj.getHiddenObj() + " objects)" : ""));
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

        if (filterObjTypes.isEmpty()) {
            return true;
        }
        if (!isInvertFilter) {
            return filterObjTypes.contains(type);
        }
        return !filterObjTypes.contains(type);
    }

    private void printTree(PgStatement st, int level, Set<PgStatement> added, PgStatement parentSt, int hiddenObj) {
        DbObjType type = st.getStatementType();

        if (DbObjType.DATABASE == type && START_LEVEL != level) {
            // do not show database in reverse graph
            return;
        }

        if (!added.add(st)) {
            writer.println(type + " " + st.getQualifiedName() + " - cyclic dependency");
            return;
        }

        final PgStatement finalParentSt;
        if (isPrintObj(st)) {
            printObjects.add(new PrintObj(st, parentSt, level, hiddenObj));
            finalParentSt = st;
            hiddenObj = 0;
            level++;
        } else {
            hiddenObj++;
            finalParentSt = parentSt;
        }
        if (depth > level) {
            final int finalLevel = level;
            final int finalHiddenObj = hiddenObj;

            graph.outgoingEdgesOf(st).stream().map(graph::getEdgeTarget)
            .sorted(Comparator.comparing(PgStatement::getStatementType))
            .forEach(pgSt -> printTree(pgSt, finalLevel, new HashSet<>(added), finalParentSt, finalHiddenObj));
        }
    }
}
