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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.loader.ms.SupportedMsVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;

public class MsIndicesAndPKReader extends JdbcReader {

    public MsIndicesAndPKReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        boolean isPrimaryKey = res.getBoolean("is_primary_key");
        boolean isUniqueConstraint = res.getBoolean("is_unique_constraint");
        DbObjType type = isPrimaryKey || isUniqueConstraint ? DbObjType.CONSTRAINT : DbObjType.INDEX;
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, type));

        boolean isClustered = res.getBoolean("is_clustered");

        Map<String, String> options = readOption(res);

        String dataSpace = res.getString("data_space");
        String filter = res.getString("filter_definition");

        String parent = res.getString("table_name");
        var cont = schema.getStatementContainer(parent);

        if (type == DbObjType.CONSTRAINT) {
            var constrPk = new MsConstraintPk(name, isPrimaryKey);
            Object isTracked = res.getObject("is_tracked");
            if (null != isTracked) {
                constrPk.setTracked((Boolean) isTracked);
            }
            fillColumns(constrPk, XmlReader.readXML(res.getString("cols")), schema.getName(), parent, false, false);
            constrPk.setClustered(isClustered);
            constrPk.setDataSpace(dataSpace);
            options.forEach(constrPk::addOption);
            cont.addChild(constrPk);
        } else {
            var index = new MsIndex(name);
            var columnstore = res.getInt("index_type");
            boolean isClusteredColumnstoreInd = columnstore == 5;
            boolean isColumnstoreInd = isClusteredColumnstoreInd || columnstore == 6;
            index.setColumnstore(isColumnstoreInd);
            List<XmlReader> cols = XmlReader.readXML(res.getString("cols"));
            if (isColumnstoreInd && SupportedMsVersion.VERSION_22.isLE(loader.getVersion())) {
                cols.stream()
                .filter(col -> col.getInt("col_order") > 0)
                .sorted(Comparator.comparing(col -> col.getInt("col_order")))
                .forEach(col -> index.addOrderCol(col.getString("name")));
            }
            fillColumns(index, cols, schema.getName(), parent, isColumnstoreInd, isClusteredColumnstoreInd);
            index.setClustered(isClustered);
            index.setUnique(res.getBoolean("is_unique"));
            index.setWhere(filter);
            index.setTablespace(MsDiffUtils.quoteName(dataSpace));
            options.forEach(index::addOption);
            cont.addChild(index);
        }
    }

    private void fillColumns(ISimpleColumnContainer stmt, List<XmlReader> cols, String schema, String parent,
            boolean isColumnstoreInd, boolean isClusteredColumnstoreInd) {
        for (XmlReader col : cols) {
            boolean isDesc = col.getBoolean("is_desc");
            String colName = col.getString("name");
            // If we have nonclustered columnstore index we read cols from is_inc
            if (!isClusteredColumnstoreInd && col.getBoolean("is_inc")) {
                stmt.addInclude(colName);
            } else if (!isColumnstoreInd) {
                var simpleCol = new SimpleColumn(colName);
                simpleCol.setDesc(isDesc);
                stmt.addColumn(simpleCol);
            }
            ((PgStatement) stmt).addDep(new GenericColumn(schema, parent, colName, DbObjType.COLUMN));
        }
    }

    private Map<String, String> readOption(ResultSet res) throws SQLException {
        boolean isMemoryOptimized = SupportedMsVersion.VERSION_14.isLE(loader.getVersion()) && res.getBoolean("is_memory_optimized");

        // cannot be used in memory_optimized tables
        boolean allowRowLocks = isMemoryOptimized || res.getBoolean("allow_row_locks");
        boolean allowPageLocks = isMemoryOptimized || res.getBoolean("allow_page_locks");

        Map<String, String> options = new HashMap<>();
        if (res.getBoolean("is_padded")) {
            options.put("PAD_INDEX", "ON");
        }

        if (!allowPageLocks) {
            options.put("ALLOW_PAGE_LOCKS", "OFF");
        }

        if (!allowRowLocks) {
            options.put("ALLOW_ROW_LOCKS", "OFF");
        }

        long fillfactor = res.getLong("fill_factor");
        if (fillfactor != 0) {
            options.put("FILLFACTOR", Long.toString(fillfactor));
        }

        if (res.getBoolean("data_compression")) {
            options.put("DATA_COMPRESSION", res.getString("data_compression_desc"));
        }

        if (res.getBoolean("ignore_dup_key")) {
            options.put("IGNORE_DUP_KEY", "ON");
        }

        if (res.getBoolean("no_recompute")) {
            options.put("STATISTICS_NORECOMPUTE", "ON");
        }

        if (SupportedMsVersion.VERSION_14.isLE(loader.getVersion()) && res.getBoolean("is_incremental")) {
            options.put("STATISTICS_INCREMENTAL", "ON");
        }

        if (SupportedMsVersion.VERSION_19.isLE(loader.getVersion()) && res.getBoolean("optimize_for_sequential_key")) {
            options.put("OPTIMIZE_FOR_SEQUENTIAL_KEY", "ON");
        }

        if (SupportedMsVersion.VERSION_22.isLE(loader.getVersion()) && res.getBoolean("xml_compression")) {
            options.put("XML_COMPRESSION", res.getString("xml_compression_desc"));
        }

        return options;
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsColsPart(builder);

        builder
        .column("o.name AS table_name")
        .column("res.name")
        .column("res.is_primary_key")
        .column("res.is_unique")
        .column("res.type AS index_type")
        .column("res.is_unique_constraint")
        .column("INDEXPROPERTY(res.object_id, res.name, 'IsClustered') AS is_clustered")
        .column("res.is_padded")
        .column("sp.data_compression")
        .column("sp.data_compression_desc")
        .column("res.allow_page_locks")
        .column("res.allow_row_locks")
        .column("res.fill_factor")
        .column("res.filter_definition")
        .column("d.name AS data_space")
        .column("ctt.is_track_columns_updated_on AS is_tracked")
        .column("res.ignore_dup_key")
        .column("st.no_recompute")
        .from("sys.indexes res WITH (NOLOCK)")
        .join("LEFT JOIN sys.filegroups f WITH (NOLOCK) ON res.data_space_id = f.data_space_id")
        .join("LEFT JOIN sys.data_spaces d WITH (NOLOCK) ON res.data_space_id = d.data_space_id")
        .join("JOIN sys.stats st WITH (NOLOCK) ON res.name = st.name AND res.object_id = st.object_id AND res.index_id = st.stats_id")
        .join("JOIN sys.objects o WITH (NOLOCK) ON res.object_id = o.object_id")
        .join("LEFT JOIN sys.change_tracking_tables ctt WITH (NOLOCK) ON ctt.object_id = res.object_id")
        .join("JOIN sys.partitions sp WITH (NOLOCK) ON sp.object_id = res.object_id AND sp.index_id = res.index_id AND sp.partition_number = 1")
        .where("o.type IN ('U', 'V')")
        .where("res.type IN (1, 2, 5, 6)");

        if (SupportedMsVersion.VERSION_14.isLE(loader.getVersion())) {
            builder
            .column("st.is_incremental")
            .column("t.is_memory_optimized")
            .join("LEFT JOIN sys.tables t WITH (NOLOCK) ON o.object_id = t.object_id");
        }

        if (SupportedMsVersion.VERSION_19.isLE(loader.getVersion())) {
            builder.column("res.optimize_for_sequential_key");
        }

        if (SupportedMsVersion.VERSION_22.isLE(loader.getVersion())) {
            builder
            .column("sp.xml_compression")
            .column("sp.xml_compression_desc");
        }
    }

    protected void addMsColsPart(QueryBuilder builder) {
        QueryBuilder subSelect = new QueryBuilder()
                .column("c.index_column_id AS id")
                .column("sc.name")
                .column("c.is_descending_key AS is_desc")
                .column("c.is_included_column AS is_inc")
                .from("sys.index_columns c WITH (NOLOCK)")
                .join("JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id")
                .where("c.object_id = res.object_id")
                .where("c.index_id = res.index_id");

        if (SupportedMsVersion.VERSION_22.isLE(loader.getVersion())) {
            subSelect.column("c.column_store_order_ordinal AS col_order");
        }

        QueryBuilder cols = new QueryBuilder()
                .column("*")
                .from(subSelect, "cc ORDER BY cc.id")
                .postAction("FOR XML RAW, ROOT");

        builder
        .column("cc.cols")
        .join("CROSS APPLY", cols, "cc (cols)");
    }

    @Override
    protected String getSchemaColumn() {
        return "o.schema_id";
    }
}
