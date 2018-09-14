package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        boolean allowRowLocks = res.getBoolean("allow_row_locks");
        boolean allowPageLocks = res.getBoolean("allow_page_locks");
        boolean compression = res.getBoolean("data_compression");
        long fillfactor = res.getLong("fill_factor");
        String dataSpace = res.getString("data_space");
        String filter = res.getString("filter_definition");

        String parent = res.getString("table_name");
        AbstractTable t = schema.getTable(parent);

        StringBuilder sb = new StringBuilder();


        List<String> columns = new ArrayList<>();
        List<String> includes = new ArrayList<>();

        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            boolean isDesc = col.getBoolean("is_desc");
            String column = MsDiffUtils.quoteName(col.getString("name")) + (isDesc ? " DESC" : "");

            if (col.getBoolean("is_inc")) {
                includes.add(column);
            } else {
                columns.add(column);
            }
        }

        sb.append("(");
        sb.append(String.join(", ", columns));
        sb.append(")");

        if (!includes.isEmpty()) {
            sb.append(" INCLUDE (");
            sb.append(String.join(", ", includes));
            sb.append(")");
        }

        if (type == DbObjType.CONSTRAINT) {
            AbstractConstraint constraint = new MsConstraint(name, "");

            if (filter != null) {
                sb.append(" WHERE ").append(filter);
            }

            if (isPadded || !allowRowLocks || !allowPageLocks || fillfactor != 0 || compression) {
                sb.append(" WITH (");

                if (isPadded) {
                    sb.append("PAD_INDEX = ON, ");
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

            sb.append(" ON ").append(MsDiffUtils.quoteName(dataSpace));

            StringBuilder definition = new StringBuilder();
            if (!isUniqueConstraint) {
                definition.append("PRIMARY KEY ");
            } else if (isUnique) {
                definition.append("UNIQUE ");
            }

            if (!isClustered) {
                definition.append("NON");
            }

            definition.append("CLUSTERED  ");
            definition.append(sb.toString());

            constraint.setDefinition(definition.toString());
            t.addConstraint(constraint);
        } else {
            AbstractIndex index = new MsIndex(name, "");
            index.setClusterIndex(isClustered);
            index.setUnique(isUnique);
            index.setDefinition(sb.toString());
            index.setTableName(t.getName());
            index.setWhere(filter);
            index.setTableSpace(dataSpace);

            if (isPadded) {
                index.addOption("PAD_INDEX", "ON");
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
    }
}
