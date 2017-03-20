package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
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

        i.setDefinition(getDefinition(res));
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

    private String getDefinition(ResultSet res) throws SQLException{
        String tablespace = res.getString("table_space");
        String definition = res.getString("definition");
        StringBuilder sb = new StringBuilder();
        SQLParser parser = AntlrParser.makeBasicParser(SQLParser.class, definition, loader.getCurrentLocation());
        Index_restContext rest = parser.schema_create().create_index_statement().index_rest();
        sb.append(ParserAbstract.getFullCtxText(rest.index_sort()));
        if (tablespace != null){
            sb.append(" TABLESPACE " + tablespace);
        }
        if (rest.index_where() != null){
            sb.append(" " + ParserAbstract.getFullCtxText(rest.index_where()));
        }
        return sb.toString();
    }
}