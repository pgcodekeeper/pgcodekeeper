/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
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
        AbstractTable t = schema.getTable(parent);

        if (type == DbObjType.CONSTRAINT) {
            var constrPk = new MsConstraintPk(name, isPrimaryKey);

            constrPk.setClustered(isClustered);
            options.forEach(constrPk::addOption);
            constrPk.setDataSpace(dataSpace);

            for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                String colName = col.getString("name");
                SimpleColumn column = new SimpleColumn(colName);
                column.setDesc(col.getBoolean("is_desc"));
                constrPk.addColumn(colName, column);
                constrPk.addDep(new GenericColumn(schema.getName(), parent, colName, DbObjType.COLUMN));
            }

            t.addConstraint(constrPk);
        } else {
            AbstractIndex index = new MsIndex(name);

            List<String> columns = new ArrayList<>();
            List<String> includes = new ArrayList<>();

            for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                boolean isDesc = col.getBoolean("is_desc");
                String colName = col.getString("name");

                if (col.getBoolean("is_inc")) {
                    includes.add(colName);
                } else {
                    columns.add(MsDiffUtils.quoteName(colName) + (isDesc ? " DESC" : ""));
                    index.addDep(new GenericColumn(schema.getName(), parent, colName, DbObjType.COLUMN));
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(String.join(", ", columns));
            sb.append(")");
            index.setDefinition(sb.toString());

            index.setClustered(isClustered);
            index.setUnique(res.getBoolean("is_unique"));
            index.setWhere(filter);
            index.setTablespace(dataSpace);

            for (String include : includes) {
                index.addInclude(include);
                index.addDep(new GenericColumn(schema.getName(), parent, include, DbObjType.COLUMN));
            }
            options.forEach(index::addOption);

            t.addIndex(index);
        }
    }

    private Map<String, String> readOption(ResultSet res) throws SQLException {
        // TODO more options
        boolean isPadded = res.getBoolean("is_padded");
        boolean isMemoryOptimized = res.getBoolean("is_memory_optimized");
        boolean isStatisticsIncremental = res.getBoolean("is_incremental");

        // cannot be used in memory_optimized tables
        boolean allowRowLocks = isMemoryOptimized || res.getBoolean("allow_row_locks");
        boolean allowPageLocks = isMemoryOptimized || res.getBoolean("allow_page_locks");
        boolean compression = res.getBoolean("data_compression");
        long fillfactor = res.getLong("fill_factor");

        Map<String, String> options = new HashMap<>();
        if (isPadded) {
            options.put("PAD_INDEX", "ON");
        }
        if (isStatisticsIncremental) {
            options.put("STATISTICS_INCREMENTAL", "ON");
        }

        if (!allowPageLocks) {
            options.put("ALLOW_PAGE_LOCKS", "OFF");
        }

        if (!allowRowLocks) {
            options.put("ALLOW_ROW_LOCKS", "OFF");
        }

        if (fillfactor != 0) {
            options.put("FILLFACTOR", Long.toString(fillfactor));
        }

        if (compression) {
            options.put("DATA_COMPRESSION", res.getString("data_compression_desc"));
        }

        return options;
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsColsPart(builder);

        builder
        .column("o.name AS table_name")
        .column("o.is_memory_optimized")
        .column("res.name")
        .column("res.is_primary_key")
        .column("res.is_unique")
        .column("res.is_unique_constraint")
        .column("INDEXPROPERTY(res.object_id, res.name, 'IsClustered') AS is_clustered")
        .column("res.is_padded")
        .column("st.is_incremental")
        .column("sp.data_compression")
        .column("sp.data_compression_desc")
        .column("res.allow_page_locks")
        .column("res.allow_row_locks")
        .column("res.fill_factor")
        .column("res.filter_definition")
        .column("d.name AS data_space")
        .from("sys.indexes res WITH (NOLOCK)")
        .join("LEFT JOIN sys.filegroups f WITH (NOLOCK) ON res.data_space_id = f.data_space_id")
        .join("LEFT JOIN sys.data_spaces d WITH (NOLOCK) ON res.data_space_id = d.data_space_id")
        .join("JOIN sys.stats st WITH (NOLOCK) ON res.name = st.name AND res.object_id = st.object_id AND res.index_id = st.stats_id")
        .join("JOIN sys.tables o WITH (NOLOCK) ON res.object_id = o.object_id")
        .join("JOIN sys.partitions sp WITH (NOLOCK) ON sp.object_id = res.object_id AND sp.index_id = res.index_id AND sp.partition_number = 1")
        .where("o.type = 'U'")
        .where("res.type IN (1, 2)");
    }

    protected void addMsColsPart(QueryBuilder builder) {
        String cols = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT\n"
                + "      c.index_column_id AS id,\n"
                + "      sc.name,\n"
                + "      c.is_descending_key AS is_desc,\n"
                + "      c.is_included_column AS is_inc\n"
                + "    FROM sys.index_columns c WITH (NOLOCK)\n"
                + "    JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id\n"
                + "    WHERE c.object_id = res.object_id AND c.index_id = res.index_id\n"
                + "  ) cc ORDER BY cc.id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") cc (cols)";

        builder.column("cc.cols");
        builder.join(cols);
    }

    @Override
    protected String getSchemaColumn() {
        return "o.schema_id";
    }
}
