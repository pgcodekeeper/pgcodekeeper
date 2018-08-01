package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsIndicesAndPKReader extends JdbcMsReader {

    public MsIndicesAndPKReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_INDICES_AND_PK, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, JsonReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        boolean isPrimaryKey = res.getBoolean("is_primary_key");
        boolean isUniqueConstraint = res.getBoolean("is_unique_constraint");
        DbObjType type = isPrimaryKey || isUniqueConstraint ? DbObjType.CONSTRAINT : DbObjType.INDEX;
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, type));

        boolean isClustered = res.getBoolean("is_clustered");
        boolean isPadded = res.getBoolean("is_padded");
        boolean allowRowLocks = res.getBoolean("allow_row_locks");
        boolean allowPageLocks = res.getBoolean("allow_page_locks");
        long fillfactor = res.getLong("fill_factor");
        String dataSpace = res.getString("data_space");
        String filter = res.getString("filter_definition");

        String parent = res.getString("table_name");
        PgTable t = schema.getTable(parent);

        StringBuilder sb = new StringBuilder();


        List<String> columns = new ArrayList<>();
        List<String> includes = new ArrayList<>();

        for (JsonReader col : JsonReader.fromArray(res.getString("cols"))) {
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

        if (filter != null) {
            sb.append(" WHERE ").append(filter);
        }

        if (isPadded || !allowRowLocks || !allowPageLocks || fillfactor != 0) {
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

            sb.setLength(sb.length() - 2);

            // TODO drop existing = off property
            sb.append(")");
        }

        sb.append(" ON ").append(MsDiffUtils.quoteName(dataSpace));

        if (type == DbObjType.CONSTRAINT) {
            MsConstraint constraint = new MsConstraint(name, "");

            StringBuilder definition = new StringBuilder();
            if (!isUniqueConstraint) {
                definition.append("PRIMARY KEY ");
            }

            if (res.getBoolean("is_unique")) {
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
            MsIndex index = new MsIndex(name, "");
            index.setClusterIndex(isClustered);
            index.setUnique("1".equals(res.getString("is_unique")));
            index.setDefinition(sb.toString());
            index.setTableName(t.getName());
            t.addIndex(index);
        }
    }

    @Override
    protected DbObjType getType() {
        return null;
    }
}
