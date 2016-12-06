package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class IndicesReader extends JdbcReader {

    public static class IndicesReaderFactory extends JdbcReaderFactory {

        public IndicesReaderFactory(long hasHelperMask, String helperFunction, String fallbackQuery) {
            super(hasHelperMask, helperFunction, fallbackQuery);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new IndicesReader(this, loader);
        }
    }

    private IndicesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        PgTable table = schema.getTable(result.getString("table_name"));
        if (table != null) {
            PgIndex index = getIndex(result, schema.getName(), table.getName());
            loader.monitor.worked(1);
            if (index != null) {
                table.addIndex(index);
            }
        }
    }

    private PgIndex getIndex(ResultSet res, String schemaName, String tableName) throws SQLException {
        String indexName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, indexName, DbObjType.INDEX));
        PgIndex i = new PgIndex(indexName, "");
        i.setTableName(tableName);

        String definition = res.getString("definition");
        i.setDefinition(definition.substring(definition.indexOf("USING ")));
        i.setClusterIndex(res.getBoolean("isClustered"));

        i.setUnique(res.getBoolean("indisunique"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            i.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        i.addDep(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        Array colsArray = res.getArray("cols");
        if (colsArray != null) {
            String[] cols = (String[]) colsArray.getArray();
            for (String col : cols){
                i.addDep(new GenericColumn(schemaName, tableName, col, DbObjType.COLUMN));
            }
        }
        return i;
    }
}
