package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
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
        super(JdbcQueries.QUERY_MS_INDICES_AND_PK, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
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
}
