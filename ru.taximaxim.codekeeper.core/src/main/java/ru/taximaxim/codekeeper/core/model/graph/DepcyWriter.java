/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public class DepcyWriter {

    private static final int START_LEVEL = 0;

    private final AbstractDatabase db;
    private final Graph<PgStatement, DefaultEdge> graph;
    private final int depth;
    private final PrintWriter writer;
    private final EnumSet<DbObjType> filterObjTypes;
    private final boolean isInvertFilter;
    private final List<PrintObj> printObjects = new ArrayList<>();

    public DepcyWriter(AbstractDatabase db, int depth, PrintWriter writer, boolean isReverse,
            Collection<DbObjType> filterObjTypes, boolean isInvertFilter) {
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
            Map<Pattern, Boolean> patterns = new HashMap<>();
            var escapeList = List.of("\\[", "\"", "\\(");

            for (String name : names) {
                Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
                boolean isNeedQuotes = Utils.stringContainsAnyItem(name, escapeList);
                patterns.put(pattern, isNeedQuotes);
            }

            db.getDescendants().flatMap(AbstractTable::columnAdder)
            .filter(st -> find(patterns, st))
            .forEach(st -> fillTree(st, START_LEVEL, new HashSet<>(), null, 0));
        } else {
            fillTree(db, START_LEVEL, new HashSet<>(), null, 0);
        }

        for (PrintObj prObj : printObjects) {
            writer.println(prObj);
        }
    }

    private boolean find(Map<Pattern, Boolean> patterns, PgStatement st) {
        for (var entry : patterns.entrySet()) {
            boolean isNeedQuotes = entry.getValue();
            String objName;
            if (isNeedQuotes) {
                objName = st.getQualifiedName();
            } else {
                objName = StatementUtils.getFullBareName(st);
            }

            Pattern pattern = entry.getKey();
            if (pattern.matcher(objName).matches()) {
                return true;
            }
        }
        return false;
    }

    private void fillTree(PgStatement st, int level, Set<PgStatement> added, PgStatement parentSt, int hiddenObj) {
        DbObjType type = st.getStatementType();

        if (DbObjType.DATABASE == type && START_LEVEL != level) {
            // do not show database in reverse graph
            return;
        }

        boolean isCyclic = !added.add(st);

        final PgStatement finalParentSt;
        if (isPrintObj(st)) {
            printObjects.add(new PrintObj(st, parentSt, level, hiddenObj, isCyclic));
            finalParentSt = st;
            hiddenObj = 0;
            level++;
        } else {
            hiddenObj++;
            finalParentSt = parentSt;
        }
        if (depth > level && !isCyclic) {
            final int finalLevel = level;
            final int finalHiddenObj = hiddenObj;

            graph.outgoingEdgesOf(st).stream().map(graph::getEdgeTarget)
            .sorted(Comparator.comparing(PgStatement::getStatementType))
            .forEach(pgSt -> fillTree(pgSt, finalLevel, new HashSet<>(added), finalParentSt, finalHiddenObj));
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
}
