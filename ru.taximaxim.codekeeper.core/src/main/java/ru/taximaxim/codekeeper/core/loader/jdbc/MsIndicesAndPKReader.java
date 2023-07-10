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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsConstraint;
import ru.taximaxim.codekeeper.core.schema.MsIndex;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

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

        // TODO more options
        boolean isUnique = res.getBoolean("is_unique");
        boolean isClustered = res.getBoolean("is_clustered");
        boolean isPadded = res.getBoolean("is_padded");
        boolean isMemoryOptimized = res.getBoolean("is_memory_optimized");
        boolean isStatisticsIncremental = res.getBoolean("is_incremental");

        // cannot be used in memory_optimized tables
        boolean allowRowLocks = isMemoryOptimized || res.getBoolean("allow_row_locks");
        boolean allowPageLocks = isMemoryOptimized || res.getBoolean("allow_page_locks");
        boolean compression = res.getBoolean("data_compression");
        long fillfactor = res.getLong("fill_factor");
        String dataSpace = res.getString("data_space");
        String filter = res.getString("filter_definition");

        String parent = res.getString("table_name");
        AbstractTable t = schema.getTable(parent);

        StringBuilder sb = new StringBuilder();

        List<String> cols = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        List<String> includes = new ArrayList<>();

        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            boolean isDesc = col.getBoolean("is_desc");
            String colName = col.getString("name");

            if (col.getBoolean("is_inc")) {
                includes.add(colName);
            } else {
                columns.add(MsDiffUtils.quoteName(colName) + (isDesc ? " DESC" : ""));
                cols.add(colName);
            }
        }

        sb.append("(");
        sb.append(String.join(", ", columns));
        sb.append(")");

        PgStatement newSt;

        if (type == DbObjType.CONSTRAINT) {
            AbstractConstraint constraint = new MsConstraint(name);
            newSt = constraint;

            if (filter != null) {
                sb.append(" WHERE ").append(filter);
            }

            if (isPadded || !allowRowLocks || !allowPageLocks || fillfactor != 0 || compression) {
                sb.append(" WITH (");

                if (isPadded) {
                    sb.append("PAD_INDEX = ON, ");
                }
                if (isStatisticsIncremental) {
                    sb.append("STATISTICS_INCREMENTAL = ON, ");
                }

                if (!allowPageLocks) {
                    sb.append("ALLOW_PAGE_LOCKS = OFF, ");
                }

                if (!allowRowLocks) {
                    sb.append("ALLOW_ROW_LOCKS = OFF, ");
                }

                if (fillfactor != 0) {
                    sb.append("FILLFACTOR = ").append(fillfactor).append(", ");
                }

                if (compression) {
                    sb.append("DATA_COMPRESSION = ").append(res.getString("data_compression_desc")).append(", ");
                }

                sb.setLength(sb.length() - 2);

                sb.append(")");
            }

            if (dataSpace != null) {
                sb.append(" ON ").append(MsDiffUtils.quoteName(dataSpace));
            }

            StringBuilder definition = new StringBuilder();
            if (!isUniqueConstraint) {
                definition.append("PRIMARY KEY ");
                constraint.setPrimaryKey(true);
            } else if (isUnique) {
                definition.append("UNIQUE ");
                constraint.setUnique(true);
            }

            if (!isClustered) {
                definition.append("NON");
            }

            definition.append("CLUSTERED  ");
            definition.append(sb.toString());

            constraint.setDefinition(definition.toString());

            if (constraint.isUnique() || constraint.isPrimaryKey()) {
                for (String column : cols) {
                    constraint.addColumn(column);
                }
            }
            t.addConstraint(constraint);
        } else {
            AbstractIndex index = new MsIndex(name);
            newSt = index;

            index.setClusterIndex(isClustered);
            index.setUnique(isUnique);
            index.setDefinition(sb.toString());
            index.setWhere(filter);
            index.setTablespace(dataSpace);

            for (String include : includes) {
                index.addInclude(include);
                newSt.addDep(new GenericColumn(schema.getName(), parent, include, DbObjType.COLUMN));
            }

            if (isPadded) {
                index.addOption("PAD_INDEX", "ON");
            }
            if (isStatisticsIncremental) {
                index.addOption("STATISTICS_INCREMENTAL", "ON");
            }

            if (!allowPageLocks) {
                index.addOption("ALLOW_PAGE_LOCKS", "OFF");
            }

            if (!allowRowLocks) {
                index.addOption("ALLOW_ROW_LOCKS", "OFF");
            }

            if (fillfactor != 0) {
                index.addOption("FILLFACTOR", Long.toString(fillfactor));
            }

            if (compression) {
                index.addOption("DATA_COMPRESSION", res.getString("data_compression_desc"));
            }

            t.addIndex(index);
        }

        for (String col : cols) {
            newSt.addDep(new GenericColumn(schema.getName(), parent, col, DbObjType.COLUMN));
        }
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
