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

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.JdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcRunner;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.IConstraintPk;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;

public final class InsertWriter {

    private static final String GEOM_FROM_TEXT_MS_FUNC = "{0}::STGeomFromText(''{1}'', 4326)";
    private static final String GEOM_FROM_TEXT_PG_FUNC = "ST_GeomFromText(''{0}'', 4326)";

    private static final String BIT_TYPE = "bit";
    private static final String GEOMETRY_TYPE = "[geometry]";
    private static final String GEOGRAPHY_TYPE = "[geography]";
    private static final String POSTGIS_GEOMETRY_TYPE = "postgis.geometry";
    private static final String TIMESTAMP_TYPE = "[timestamp]";

    private static final String PARENT_KEY = "parent";
    private static final String NAME_KEY = "name";
    private static final String FILTER_KEY = "filter";

    private final DatabaseType dbType;

    /**
     * store schemas of all foreign key constraints from source-database.
     */
    private final Map<String, List<IConstraintFk>> allFkConstr = new HashMap<>();

    /**
     * store schemas of all primary key constraints from source-database.
     */
    private final Map<String, IConstraintPk> allPkConstr = new HashMap<>();

    /**
     * Keys of this field need us for exclude the query SELECT from source-database
     * which was query and processed previously. Values of this field need us for
     * add cycle edges. where key is script of select, value is list of
     * {@link RowData}
     */
    private final Map<String, List<RowData>> selects = new HashMap<>();

    /**
     * store schemas of all tables columns from source-database. where key is
     * qualified table name, value is list of column.
     */
    private final Map<String, List<AbstractColumn>> cols = new HashMap<>();
    private final Graph<RowData, DefaultEdge> graph = new SimpleDirectedGraph<>(DefaultEdge.class);

    private InsertWriter(AbstractDatabase d) {
        this.dbType = d.getArguments().getDbType();
        fillCollections(d);
    }

    /**
     * method find all {@link IConstraintFk}, {@link IConstraintPk} and
     * {@link AbstractColumn} of all {@link AbstractTable} and put all of them in
     * correct Map where key is qualified table name, value is list of some objects
     * for {@link IConstraintFk} and {@link AbstractColumn} or object for
     * {@link IConstraintPk}
     *
     * @param db - source-database schema.
     */
    private void fillCollections(AbstractDatabase db) {
        db.getDescendants().filter(AbstractTable.class::isInstance).map(e -> (AbstractTable) e).forEach(e -> {
            var tableName = e.getQualifiedName();
            for (var constr : e.getConstraints()) {
                if (constr instanceof IConstraintFk) {
                    allFkConstr.computeIfAbsent(tableName, t -> new ArrayList<>()).add((IConstraintFk) constr);
                } else if (constr instanceof IConstraintPk) {
                    allPkConstr.put(tableName, (IConstraintPk) constr);
                }
            }
            cols.put(tableName, e.getColumns());
        });
    }

    /**
     * Method for call from external classes to start the process of get all data
     * which will be need to transfer and create insert script.
     *
     * @param db        - source-database schema
     * @param arguments - database arguments
     * @param name      - qualified table name which data need to transfer
     * @param filter    - condition of WHERE for query select
     * @throws InterruptedException
     * @throws IOException
     * @throws SQLException
     */
    public static String write(AbstractDatabase db, PgDiffArguments arguments, String name, String filter)
            throws InterruptedException, IOException, SQLException {
        var sb = new StringBuilder();
        var dbType = arguments.getDbType();
        var isTransaction = arguments.isAddTransaction();
        if (isTransaction) {
            switch (dbType) {
            case MS:
                sb.append("BEGIN TRANSACTION;\nGO\n\n");
                break;
            case PG:
                sb.append("START TRANSACTION;\n\n");
                break;
            default:
                break;
            }
        }

        String qName = getQualifiedName(name, db);
        new InsertWriter(db).generateScript(arguments.getNewSrc(), qName, filter, sb);

        if (isTransaction) {
            switch (dbType) {
            case MS:
                sb.append("COMMIT;\nGO");
                break;
            case PG:
                sb.append("COMMIT TRANSACTION;");
                break;
            default:
                break;
            }
        }

        return sb.toString();
    }

    private static String getQualifiedName(String name, AbstractDatabase db) {
        String[] names = name.split("\\.");
        if (names.length != 2) {
            throw new IllegalArgumentException("Invalid input format: " + name + ". Expected format : schema.table");
        }

        var escapeList = List.of("[", "\"");
        boolean isNeedQuotes = Utils.stringContainsAnyItem(name, escapeList);

        Predicate<PgStatement> qNameFilter;
        if (isNeedQuotes) {
            qNameFilter = st -> st.getQualifiedName().equalsIgnoreCase(name);
        } else {
            qNameFilter = st -> StatementUtils.getFullBareName(st).equalsIgnoreCase(name);
        }

        return db.getDescendants()
                .filter(st -> st.getStatementType() == DbObjType.TABLE)
                .filter(qNameFilter)
                .map(st -> st.getQualifiedName())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Table " + name + " not found in database"));
    }

    /**
     * Method to start the process of get all data which will be need to transfer
     * and create insert script.
     *
     * @param source - source-database url
     * @param name   - qualified table name which data need to transfer
     * @param filter - condition of WHERE for query select
     * @param sb     - {@link StringBuilder} which will be store data insert script
     * @throws InterruptedException
     * @throws IOException
     * @throws SQLException
     */
    private void generateScript(String source, String name, String filter, StringBuilder sb)
            throws InterruptedException, IOException, SQLException {
        try (Connection connection = JdbcConnector.fromUrl(source).getConnection()) {
            fillGraph(name, filter, connection);
        }
        removeCycles();
        fillScript(sb);
    }

    /**
     * This method create SELECT script, get data from source-database place there
     * in graph and processing graph edges. Finds all foreign keys whose columns are
     * not empty, and repeats all the steps above for each table of the foreign keys
     * found.
     *
     * @param rootName   - qualified table name which data need to transfer
     * @param rootFilter - condition of WHERE for query select
     * @param connection - connection with source-database
     * @throws InterruptedException
     * @throws SQLException
     * @throws IOException
     */
    private void fillGraph(String rootName, String rootFilter, Connection connection)
            throws InterruptedException, SQLException {
        Queue<Map<String, Object>> queue = new LinkedList<>();

        Map<String, Object> map = packData(null, rootName, rootFilter);
        do {
            var parent = (RowData) map.get(PARENT_KEY);
            var name = map.get(NAME_KEY).toString();
            var filter = map.get(FILTER_KEY).toString();

            var select = generateSelect(name, filter);

            // check this select was queried
            if (selects.containsKey(select)) {
                // add edges to old data
                for (var rowData : selects.get(select)) {
                    if (!parent.equals(rowData)) {
                        graph.addEdge(parent, rowData);
                    }
                }
                // exit from cyclic dependency
                continue;
            }

            // collect all data from select query
            List<RowData> tempData = new ArrayList<>();
            try (ResultSet values = new JdbcRunner().runScript(connection.createStatement(), select)) {
                while (values.next()) {
                    tempData.add(getData(values, name, parent));
                }
            }

            // store data to cache
            selects.put(select, tempData);

            for (var rowData : tempData) {
                // add data to graph
                graph.addVertex(rowData);
                if (parent != null) {
                    graph.addEdge(parent, rowData);
                }

                // dependency search
                for (var constr : allFkConstr.getOrDefault(name, Collections.emptyList())) {
                    var parentName = getTableName(constr.getForeignSchema(), constr.getForeignTable());
                    var parentFilter = rowData.generateFilter(constr.getForeignColumns().toArray(),
                            constr.getColumns().toArray());
                    if (parentFilter != null) {
                        queue.add(packData(rowData, parentName, parentFilter));
                    }
                }
            }
        } while ((map = queue.poll()) != null);
    }

    /**
     * packs the arguments into a Map
     *
     * @param parent - the {@link RowData} which depends from some other row
     * @param name   - qualified table name which data need to transfer
     * @param filter - condition of WHERE for query select
     * @return arguments packed in {@link Map}
     */
    private Map<String, Object> packData(RowData parent, String name, String filter) {
        Map<String, Object> map = new HashMap<>();
        map.put(PARENT_KEY, parent);
        map.put(NAME_KEY, name);
        map.put(FILTER_KEY, filter);
        return map;
    }

    private String generateSelect(String name, String filter) {
        var sb = new StringBuilder();
        sb.append("SELECT ");
        for (var col : cols.get(name)) {
            var colName = col.getName();
            var colType = col.getType();
            if (colType != null && colType.contains("binary]")) {
                sb.append("CAST(").append(colName).append(" AS INT) AS ").append(colName);
            } else if (GEOMETRY_TYPE.equals(colType) || GEOGRAPHY_TYPE.equals(colType)) {
                sb.append(colName).append(".STAsText() AS ").append(colName);
            } else if (POSTGIS_GEOMETRY_TYPE.equals(colType)) {
                sb.append("ST_AsText(").append(colName).append(") AS ").append(colName);
            } else {
                sb.append(colName);
            }
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" FROM ").append(name).append(" WHERE ").append(filter).append(';');
        return sb.toString();
    }

    /**
     * This method get data from {@link ResultSet}, processing this data if need and
     * return it packed in object {@link RowData}
     *
     * @param values     - {@link ResultSet} witch contains row data
     * @param tableName  - table name of new {@link RoWData}
     * @param parent     - the first {@link RowData} which depends from this data
     * @return new filled {@link RowData}
     * @throws SQLException
     */
    private RowData getData(ResultSet values, String tableName, RowData parent) throws SQLException {
        Map<String, String> data = new LinkedHashMap<>();
        List<String> notNullCols = new ArrayList<>();

        for (var col : cols.get(tableName)) {
            var colName = col.getName();
            var type = col.getType();
            Object rawValue = values.getObject(colName);

            if (isNeedSkip(rawValue, col, type)) {
                continue;
            }

            if (!col.getNullValue()) {
                notNullCols.add(colName);
            }

            String value = getValue(type, rawValue);
            data.put(colName, value);
        }

        List<String> fkCols = new ArrayList<>();
        for (var fkConstrs : allFkConstr.getOrDefault(tableName, Collections.emptyList())) {
            fkConstrs.getColumns().stream().filter(notNullCols::contains).forEach(fkCols::add);
        }

        IConstraintPk pk = allPkConstr.get(tableName);
        Collection<String> pkCols = pk != null ? pk.getColumns() : Collections.emptyList();
        return new RowData(tableName, parent, data, fkCols, pkCols);
    }

    private boolean isNeedSkip(Object rawValue, AbstractColumn col, String colType) {
        if (rawValue == null) {
            return true;
        }

        if (col instanceof MsColumn) {
            MsColumn msCol = (MsColumn) col;
            return msCol.getExpression() != null || TIMESTAMP_TYPE.equals(colType);
        }

        return col instanceof PgColumn && ((PgColumn) col).isGenerated();
    }

    /**
     * This method process data to correct format if it need
     *
     * @param type - data type of {@link AbstractColumn}
     * @param rawValue - data before processing
     * @param colName - name of {@link AbstractColumn}
     * @return processed data
     */
    private String getValue(String type, Object rawValue) {
        if (BIT_TYPE.equals(type)) {
            return rawValue.equals(true) ? "'1'" : "'0'";
        }
        if (GEOMETRY_TYPE.equals(type) || GEOGRAPHY_TYPE.equals(type)) {
            return MessageFormat.format(GEOM_FROM_TEXT_MS_FUNC, type, rawValue.toString());
        }
        if (POSTGIS_GEOMETRY_TYPE.equals(type)) {
            return MessageFormat.format(GEOM_FROM_TEXT_PG_FUNC, rawValue.toString());
        }
        return isNeedQuotting(rawValue, type) ? PgDiffUtils.quoteString(rawValue.toString()) : rawValue.toString();
    }

    private boolean isNeedQuotting(Object rawValue, String type) {
        return rawValue instanceof String
                || type.contains(BIT_TYPE)
                || type.contains("time")
                || type.contains("date")
                || type.contains("json")
                || "uuid".equals(type)
                || type.endsWith("[]");
    }

    /**
     * This method find the cyclic edges in graph check which edges can be remove
     * and processing this edges and vertices.
     *
     * @throws IllegalStateException - if tables have circular edges and are based
     *                               on foreign keys, which refer to columns with
     *                               the NOT NULL option
     */
    private void removeCycles() throws IllegalStateException {
        CycleDetector<RowData, DefaultEdge> detector = new CycleDetector<>(graph);

        for (RowData rowData : detector.findCycles()) {
            for (RowData vertex : detector.findCyclesContainingVertex(rowData)) {
                if (vertex.equals(rowData)) {
                    continue;
                }
                if (!hasLinkedFk(rowData, vertex)) {
                    // no FK on source table - remove edge
                    removeCycles(rowData, vertex);
                } else if (hasLinkedFk(vertex, rowData)) {
                    /*
                     * if two rows refer to each other by FK, then we throw an exception
                     */
                    throw new IllegalStateException(
                            "can't remove dependency circle in graph\nfirst: " + rowData + "\nsecond: " + vertex);
                }
            }
        }
    }

    /**
     * Find foreign key constraints with a link between source and target rows with not null columns
     */
    private boolean hasLinkedFk(RowData source, RowData target) {
        return allFkConstr.getOrDefault(source.getTableName(), Collections.emptyList()).stream()
                .filter(e -> target.getTableName().equals(getTableName(e.getForeignSchema(), e.getForeignTable())))
                .anyMatch(e -> source.containsAllFkCols(e.getColumns()));
    }

    private String getTableName(String schema, String name) {
        if (dbType == DatabaseType.MS) {
            return MsDiffUtils.quoteName(schema) + '.' + MsDiffUtils.quoteName(name);
        }
        return PgDiffUtils.getQuotedName(schema) + '.' + PgDiffUtils.getQuotedName(name);
    }

    private void removeCycles(RowData source, RowData target) {
        for (IConstraintFk constr : allFkConstr.getOrDefault(source.getTableName(), Collections.emptyList())) {
            if (Objects.equals(target.getTableName(),
                    getTableName(constr.getForeignSchema(), constr.getForeignTable()))) {
                graph.removeEdge(source, target);
                // collect columns whose value will be replaced with null and updated at the end of the script
                for (var fkCol : constr.getColumns()) {
                    source.addReplacement(fkCol);
                }
            }
        }
    }

    private void fillScript(StringBuilder sb) {
        Set<RowData> tempData = new LinkedHashSet<>();

        // 1 step - convert graph to set
        var dfi = new DepthFirstIterator<>(graph);
        dfi.addTraversalListener(new TraversalListenerAdapter<RowData, DefaultEdge>() {

            @Override
            public void vertexFinished(VertexTraversalEvent<RowData> e) {
                tempData.add(e.getVertex());
            }
        });

        while (dfi.hasNext()) {
            dfi.next();
        }

        // 2 step - fill inserts
        for (var rowData : tempData) {
            var tableName = rowData.getTableName();
            var haveIdentity = cols.getOrDefault(tableName, Collections.emptyList())
                    .stream().anyMatch(this::haveIdentityCol);
            rowData.appendInsert(dbType, haveIdentity, sb);
        }

        // 3 step - fill updates
        for (var rowData : tempData) {
            rowData.appendUpdate(dbType, sb);
        }
    }

    private boolean haveIdentityCol(AbstractColumn column) {
        if (dbType == DatabaseType.MS) {
            return ((MsColumn) column).isIdentity();
        }
        PgColumn col = (PgColumn) column;
        return "ALWAYS".equals(col.getIdentityType());
    }
}
